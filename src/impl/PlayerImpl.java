package impl;

import game.Player;

public class PlayerImpl implements Player {

	private int x, y;
	
	@Override
	public void setPosicao(int x, int y) {
		this.x = x;
		this.y = y;
	}

}
