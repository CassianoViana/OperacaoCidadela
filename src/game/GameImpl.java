package game;

import java.util.ArrayList;
import java.util.Collection;

import a.remote.client.Player;
import a.remote.server.Game;

public class GameImpl implements Game {

	private final Collection<Player> players; 
	
	public GameImpl() {
		players = new ArrayList<>();
	}
	
	@Override
	public void addPlayer(Player player) {
		players.add(player);
	}

}
