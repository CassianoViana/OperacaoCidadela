package impl;

import game.Command;
import game.Player;
import game.Team;

public class PlayerImpl implements Player {

	private int x, y;
	
	@Override
	public void setPosicao(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public void execute(Command command) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTeam(Team team) {
		// TODO Auto-generated method stub
		
	}

}
