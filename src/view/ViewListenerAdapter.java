package view;

import game.Command;
import game.Lobb;
import game.Team;

public class ViewListenerAdapter implements ViewListener {

	@Override
	public void creattedLobb(Lobb lobb) {}

	@Override
	public void selectedLobb(Lobb lobb) {}

	@Override
	public void commanded(Command command) {}

	@Override
	public void selectedTeam(Team team) {}

}
