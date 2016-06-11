package game;

import java.rmi.RemoteException;
import java.util.List;

public interface Server extends java.rmi.Remote {

	void addPlayer(Player player) throws RemoteException;

	List<Lobb> listLobbs();

	void addListener(ServerListener listener);

	void addLobb(Lobb lobb);

}
