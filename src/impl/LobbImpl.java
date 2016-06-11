package impl;

import game.Lobb;
import game.Player;

import java.util.ArrayList;
import java.util.Collection;

public class LobbImpl implements Lobb {

	private final Collection<Player> players; 
	
	public LobbImpl() {
		players = new ArrayList<>();
	}
	
	@Override
	public void addPlayer(Player player) {
		System.out.println("GameImpl.addPlayer()");
		players.add(player);
	}

}
