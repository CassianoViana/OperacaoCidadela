package core;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import gamecore.Background;
import gamecore.Command;
import gamecore.GameObject;
import gamecore.Shoot;
import gamecore.Tank;
import util.Util;

public class Server {
	public static final int PORT = 50000;
	public static final String HOST = "localhost";
	private ServerSocket server;
	private Map<String, ClientGate> gates = new HashMap<>();
	private Map<String, Tank> tanks = new LinkedHashMap<>();
	private Set<GameObject> objects = new HashSet<>();
	private Set<String> ids = new HashSet<>();
	private BlockingQueue<String> comandos = new ArrayBlockingQueue<>(20);

	public static void main(String[] args) throws Exception {
		new Server().init();
	}

	private void init() throws Exception {

		server = new ServerSocket(PORT);
		objects.add(new Background());
		new Thread(recebeConexoes()).start();
		new Thread(computaComandos()).start();
		new Thread(montaStringCanvas()).start();

	}

	private Runnable recebeConexoes() {
		return new Runnable() {
			@Override
			public void run() {
				while (true) {
					Socket socket;
					try {
						Log.d(this, "Esperando conexao");
						socket = server.accept();
						InputStream inFromClient = socket.getInputStream();
						OutputStream outToClient = socket.getOutputStream();
						addPlayer(inFromClient, outToClient);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		};
	}

	private Runnable computaComandos() {
		return new Runnable() {
			@Override
			public void run() {
				try {
					while (true) {
						Log.d(this, "Esperando comando");
						String utf = comandos.take();
						String id = Util.split(utf)[0];
						String command = Util.split(utf)[1];
						decodeCommand(id, command);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			private void decodeCommand(String id, String commandName) {
				Command command = Command.valueOf(commandName);
				tanks.get(id).decodeCommand(command);
				switch (command) {
				case EXIT:
					gates.remove(id);
					objects.remove(id);
					ids.remove(id);
					break;
				case SHOOT:
					Tank tank = tanks.get(id);
					Shoot shoot = tank.shoot();
					objects.add(shoot);
					break;
				default:
					break;
				}
			}
		};
	}

	private Runnable montaStringCanvas() {
		return new Runnable() {
			@Override
			public void run() {
				StringBuffer sb = new StringBuffer();
				while (true) {
					for (GameObject gameObject : objects) {
						gameObject.update();
						sb.append(gameObject.drawCommand()).append(Util.DRAW_COMMAND_SEPARATOR);
					}
					ClientGate gate;
					for (String id : gates.keySet()) {
						gate = gates.get(id);
						gate.sendMessage(sb.toString());
					}
					Util.sleep();
					sb.delete(0, sb.length());
				}
			}
		};
	}

	private void addPlayer(InputStream inFromClient, OutputStream outToClient) throws IOException {
		ClientGate gate = new ClientGate(inFromClient, outToClient);

		String id = gate.readUTF();
		Tank tank = new Tank();
		objects.add(tank);
		tanks.put(id, tank);
		gates.put(id, gate);
		ids.add(id);

		gate.startListenCommands(comandos);
	}
}