package game;

import java.io.Serializable;

public abstract class Player extends GameObject implements Serializable {

        abstract public void execute(Command command);

        abstract public void setTeam(Team team);

}
