package game;

import java.util.List;

import view.Scene;

public interface ServerListener {

	void updatedLobbs(List<Lobb> lobbs);
	void startedLobb();
	void updated(Scene scene);
	
}
