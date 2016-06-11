package remote;

import game.Lobb;
import game.Player;
import game.Server;
import game.ServerListener;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class ServerImpl implements Server {
	
	private static Server game;

	public static Server instance() {
		if (game == null){
			game = new ServerImpl();
			registry();
		}
		return game;
	}

	public static void main(String[] args) {
		ServerImpl.instance();
	}
	
	private static void registry() {
		try {
			Server gameStub = (Server) UnicastRemoteObject.exportObject(game, Registry.REGISTRY_PORT);
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

	@Override
	public List<Lobb> listLobbs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addListener(ServerListener listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addLobb(Lobb lobb) {
		// TODO Auto-generated method stub
		
	}


}
