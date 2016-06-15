package start;

import game.Server;
import game.Player;

import java.rmi.RemoteException;

import org.junit.Test;

import remote.ServerImpl;
import remote.Client;

public class StartTest {

	@Test
	public void startGameAndTwoPlayers() throws RemoteException {
		Server gameServer = ServerImpl.instance();
		Player player1 = Client.create();
		Player player2 = Client.create();
	}

}
