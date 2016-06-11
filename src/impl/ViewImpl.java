package impl;

import game.View;
import game.Lobb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import view.ViewListener;
import view.Scene;

public class ViewImpl implements View {

	private Collection<ViewListener> listeners;
	
	public ViewImpl() {
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
	public void addListener(ViewListener viewListener) {
		this.listeners.add(viewListener);
	}

	@Override
	public void startedLobb() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void paint(Scene scene) {
		// TODO Auto-generated method stub
		
	}
	
	

}
