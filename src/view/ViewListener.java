package view;

import game.Command;
import game.Lobb;
import game.Team;
import java.io.Serializable;

public interface ViewListener extends Serializable {

        void creattedLobb(Lobb lobb);

        void selectedLobb(Lobb lobb);

        void commanded(Command command);

        void selectedTeam(Team team);

}
