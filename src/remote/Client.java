package remote;

import game.GameView;
import game.Lobb;
import game.Player;
import game.Server;
import game.ServerListener;
import impl.GameViewImpl;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

import view.GameViewListener;

public class Client implements Player, ServerListener {

	private static Server server;
	private static Player player;
	private final GameView view;
	
	private static Client instance;
	
	private Client() {
		view = new GameViewImpl();
		view.addListener(new GameViewListener(){
			@Override
			public void creattedLobb(Lobb lobb){
				try{					
					server.addLobb(lobb);
				} catch (Exception e){
					showError(e);
				}
			}
		});
	}
	
	public static void main(String[] args) {
		new Client().start();
	}

	public void start(){
		try {
			showView();
			getRemoteServer();
			createPlayer();
		} catch (RemoteException | NotBoundException e) {
			showError(e);
		}
	}
	
	private void showView() {
		view.showPresentation();
		showLobbs();
	}

	private void showLobbs() {
		view.showLobbs(server.listLobbs());
	}
	
	private void getRemoteServer() throws RemoteException,
			NotBoundException, AccessException {
		Registry registry = LocateRegistry.getRegistry(Registry.REGISTRY_PORT);
		server = (Server) registry.lookup("gameServer");
		server.addListener(Client.this);
	}


	public static Player create() {
		try {
			if(instance==null){				
				instance = new Client();
				instance.start();
			}
			return player;
		} catch (Exception e) {
			throw new RuntimeException("Falha ao iniciar jogador.", e);
		}
	}

	private Player createPlayer() {
		player = new impl.PlayerImpl();
		return player;
	}

	private void showError(Throwable e){
		view.showError(e);
	}
	
	@Override
	public void setPosicao(int x, int y) {
		player.setPosicao(x, y);
	}

	@Override
	public void updatedLobbs(List<Lobb> lobbs) {
		showLobbs();
	}

}
