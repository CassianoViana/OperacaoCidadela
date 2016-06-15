package game;

import java.io.Serializable;
import java.util.List;

public interface ServerListener extends Serializable {

	void updatedLobbs(List<Lobb> lobbs);
	void startedLobb();
	
}
