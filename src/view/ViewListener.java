package view;

import game.Command;
import game.Lobb;
import game.Team;

public interface ViewListener {

	void creattedLobb(Lobb lobb);

	void selectedLobb(Lobb lobb);

	void commanded(Command command);

	void selectedTeam(Team team);

}
