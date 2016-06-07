package a.remote.server;

import java.rmi.RemoteException;

import a.remote.client.Player;

public interface Game extends java.rmi.Remote {

	void addPlayer(Player player) throws RemoteException;

}
