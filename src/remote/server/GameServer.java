package remote.server;

import game.GameImpl;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import a.remote.client.Player;
import a.remote.server.Game;

public class GameServer implements Game {
	private static Game game;

	public static Game instance() {
		if (game == null){
			game = new GameImpl();
			registry();
		}
		return game;
	}

	private static void registry() {
		try {
			Game gameStub = (Game) UnicastRemoteObject.exportObject(game, Registry.REGISTRY_PORT);
			Registry registry = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
			registry.rebind("gameServer", gameStub);
		} catch (RemoteException e) {
			throw new RuntimeException("Falha ao iniciar servidor.", e);
		}
	}

	@Override
	public void addPlayer(Player player) throws RemoteException {
		game.addPlayer(player);
	}
	

}
