package core;

import gamecore.Command;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import util.Util;

public class Cliente {

	private Socket server;
	private ServerGate serverGate;
	private GameWindow gameWindow;
	private String id;
	private BlockingQueue<String> commandos = new ArrayBlockingQueue<>(5);

	public static void main(String[] args) throws Exception {
		new Cliente().init();
	}

	private void init() throws Exception {
		connect();
		startGui();
		new Thread(communication()).start();
	}

	private Runnable communication() {
		return new Runnable() {
			@Override
			public void run() {
				while (true) {					
					try {
						String command = commandos.take();
						// transformar em listener:
						gameWindow.commandComming(command);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
	}

	private void connect() throws UnknownHostException, IOException {
		server = new Socket(Server.HOST, Server.PORT);
		serverGate = new ServerGate(server.getInputStream(), server.getOutputStream());
		id = Util.generateId();
		serverGate.send(id);
		
		serverGate.startReceiveMessages(commandos);
	}

	private void startGui() {
		gameWindow = new GameWindow(new GameWindow.Listener() {
			@Override
			public void commanded(Command command) {
				serverGate.send(Util.join(id, command));
			}
		});
		gameWindow.mostrar();
	}
}
