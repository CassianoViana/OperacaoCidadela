package game;

import java.util.List;

public class ServerListenerAdapter implements ServerListener {

	@Override
	public void updatedLobbs(List<Lobb> lobbs) {}

	@Override
	public void startedLobb() {}

	@Override
	public void updated(Scene scene) {}

}
