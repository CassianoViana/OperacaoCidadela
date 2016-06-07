package remote.client;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import a.remote.client.Player;
import a.remote.server.Game;

public class PlayerClient implements Player {

	public static Player create() {
		try{
			return registryPlayerOnGame();
		} catch (Exception e){
			throw new RuntimeException("Falha ao iniciar jogador.", e);
		}
	}

	private static Player registryPlayerOnGame() throws RemoteException,
			NotBoundException, AccessException {
		Registry registry = LocateRegistry.getRegistry(Registry.REGISTRY_PORT);
		Game game = (Game) registry.lookup("gameServer");
		Player player = new game.PlayerImpl();
		game.addPlayer( player );
		return player;
	}

}
