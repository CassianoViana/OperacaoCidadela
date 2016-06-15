package game;

import java.io.Serializable;
import java.util.List;

import view.Scene;

public interface ServerListener extends Serializable {

	void updatedLobbs(List<Lobb> lobbs);
	void startedLobb();
	void updated(Scene scene);
	
}
