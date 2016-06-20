package impl;

import config.GameConstants;
import game.Canvas;
import game.Lobb;
import game.View;
import java.awt.BorderLayout;
import java.awt.Image;
import java.io.Serializable;
import java.rmi.Remote;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import view.ViewListener;

public class ViewImpl extends JFrame implements View, Remote {

	private final Collection<ViewListener> listeners;
	private final PanelGame panelGame;

	public ViewImpl() {
		listeners = new ArrayList<>();
		panelGame = new PanelGame();
		setSize(GameConstants.SCREEN_WIDTH, GameConstants.SCREEN_HEIGHT);
		// setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		add(panelGame);
	}

	@Override
	public void showView() {
		setVisible(true);
	}

	@Override
	public void showPresentation() {

	}

	@Override
	public void showLobbs(List<Lobb> lobbs) {

	}

	// ----------------------------------------------------------------------
	@Override
	public Lobb chooseLobb(List<Lobb> lobbs) {
		String i = JOptionPane.showInputDialog("Escolha a sala");
		Lobb lobb = lobbs.get(Integer.parseInt(i));
		repaint();
		return lobb;
	}

	@Override
	public void showError(Throwable e) {
		e.printStackTrace();
	}

	// ----------------------------------------------------------------------
	@Override
	public void addListener(ViewListener viewListener) {
		this.listeners.add(viewListener);
	}

	@Override
	public void startedLobb() {
		// TODO Auto-generated method stub
	}

	@Override
	public String requestName() {
		return JOptionPane.showInputDialog("Informe o nome");
	}

	// ----------------------------------------------------------------------
	@Override
	public void paint(Canvas canvas) {
		panelGame.paint(canvas.getImage());
	}

	private class PanelGame extends JPanel implements Serializable {

		public PanelGame() {
			setLayout(new BorderLayout());
		}

		private void paint(Image image) {
			PanelGame.this.add(new JLabel(new ImageIcon(image)));
			repaint();
		}
	}
}
