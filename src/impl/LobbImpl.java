package impl;

import game.Lobb;
import game.Player;

import java.util.ArrayList;
import java.util.Collection;

public class LobbImpl implements Lobb {

	private final Collection<Player> players; 
        private final String name;
	
	public LobbImpl(String name) {
                this.name = name;
		players = new ArrayList<>();
	}
	
	@Override
	public void addPlayer(Player player) {
		System.out.println("GameImpl.addPlayer()");
		players.add(player);
	}

        @Override
        public String getName() {
                return name;
        }

}
