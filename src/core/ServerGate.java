package core;

import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.BlockingQueue;

import javax.imageio.ImageIO;

public class ServerGate {

	private DataOutputStream outToServer;
	private DataInputStream inFromServer;

	public ServerGate(InputStream inFromServer, OutputStream outToServer) {
		this.inFromServer = new DataInputStream(inFromServer);
		this.outToServer = new DataOutputStream(outToServer);
	}

	public void send(Object object) {
		try {
			outToServer.writeUTF(object.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void startReadImage(final BlockingQueue<BufferedImage> imagens) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (inFromServer != null) {
					try {
						if (inFromServer.available() > 0) {
							BufferedImage image = ImageIO.read(inFromServer);
							if (image != null)
								imagens.put(image);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}

	public void startReceiveMessages(final BlockingQueue<String> drawCommands) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (inFromServer != null) {
					try {
						if (inFromServer.available() > 0) {
							String drawCommand = inFromServer.readUTF();
							Log.d(this, "Chegou mensagem: " + drawCommand);
							drawCommands.put(drawCommand);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}
}
