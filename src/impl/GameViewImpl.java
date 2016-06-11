package impl;

import game.GameView;
import game.Lobb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import view.GameViewListener;

public class GameViewImpl implements GameView {

	private Collection<GameViewListener> listeners;
	
	public GameViewImpl() {
		listeners = new ArrayList<>();
	}
	
	@Override
	public void showPresentation() {
		
	}

	@Override
	public void showLobbs(List<Lobb> lobbs) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showError(Throwable e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addListener(GameViewListener viewListener) {
		// TODO Auto-generated method stub
		
	}
	
	

}
