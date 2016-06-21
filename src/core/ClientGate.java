package core;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.BlockingQueue;

import util.Util;

public class ClientGate {

	private DataInputStream inFromClient;
	private DataOutputStream outToClient;

	public ClientGate(InputStream inFromClient, OutputStream outToClient) {
		this.inFromClient = new DataInputStream(inFromClient);
		this.outToClient = new DataOutputStream(outToClient);
	}

	public void startListenCommands(final BlockingQueue<String> comandos) {

		new Thread(new Runnable() {
			@Override
			public void run() {
				DataInputStream dataInputStream = new DataInputStream(inFromClient);
				while (inFromClient != null) {
					try {
						if (inFromClient.available() > 0) {
							String comando = dataInputStream.readUTF();
							comandos.put(comando);
							Log.d(this, comando);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}

	public String readUTF() {
		try {
			return inFromClient.readUTF();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}

	public void sendMessage(String message) {
		try {
			outToClient.writeUTF(message);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
