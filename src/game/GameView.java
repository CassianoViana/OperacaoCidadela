package game;

import java.util.List;

import view.GameViewListener;

public interface GameView {

	void showPresentation();

	void showLobbs(List<Lobb> lobbs);

	void showError(Throwable e);

	void addListener(GameViewListener viewListener);

}
