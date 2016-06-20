package adapters;

import game.Lobb;
import game.ServerListener;

import java.util.List;

public class ServerListenerAdapter implements ServerListener {

	@Override
	public void updatedLobbs(List<Lobb> lobbs) {}

	@Override
	public void startedLobb() {}


}
