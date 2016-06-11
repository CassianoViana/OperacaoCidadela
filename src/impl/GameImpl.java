package impl;

import game.Server;
import game.ServerListener;
import game.Lobb;
import game.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GameImpl implements Server {

	private final Collection<Player> players; 
	
	public GameImpl() {
		players = new ArrayList<>();
	}
	
	@Override
	public void addPlayer(Player player) {
		System.out.println("GameImpl.addPlayer()");
		players.add(player);
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
