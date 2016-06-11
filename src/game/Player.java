package game;

import java.io.Serializable;

public interface Player extends Serializable {

	public void setPosicao(int x, int y);

	public void execute(Command command);

	public void setTeam(Team team);

}
