package start;

import java.rmi.RemoteException;

import org.junit.Test;

import remote.client.PlayerClient;
import remote.server.GameServer;
import a.remote.client.Player;
import a.remote.server.Game;

public class StartTest {

	@Test
	public void startGameAndTwoPlayers() throws RemoteException {
		Game gameServer = GameServer.instance();
		Player player1 = PlayerClient.create();
		Player player2 = PlayerClient.create();
		gameServer.addPlayer(player1);
		gameServer.addPlayer(player2);
//		player1.setPosicao(10,10).setDirecaoCorpo(0).giraCanhao(0);
//		player2.setPosicao(100, 10).setDirecaoCorpo();
		
	}

}
