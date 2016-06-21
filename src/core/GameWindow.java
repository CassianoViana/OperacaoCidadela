package core;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import gamecore.Command;
import gamecore.GameObject;
import util.Util;

public class GameWindow extends JFrame {
	private static final long serialVersionUID = 1L;

	public static final int WIDTH = 1000;
	public static final int HEIGHT = 600;

	public static final Color BACK = new Color(0.5f, 0.9f, 0.5f, 0f);
	public static final Color FRONT = Color.yellow;
	public static final Font FONT = new Font("Khmer OS", Font.BOLD, 35);

	private Listener listener;
	public BlockingQueue<BufferedImage> images = new ArrayBlockingQueue<>(1);
	public BlockingQueue<String> commandosDraw = new ArrayBlockingQueue<>(5);
	public BufferedImage image;
	public String comandoDraw;
	private PainelPintura painelPintura = new PainelPintura();
	private TeamSelectionDialog teamSelectionDialog;

	public GameWindow(Listener listener) {
		setSize(WIDTH, HEIGHT);
		setLocationRelativeTo(null);
		add(painelPintura);
		Joystick joystick = new Joystick();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		addWindowListener(joystick);
		addKeyListener(joystick);
		this.listener = listener;
		createTeamSelectionDialog();
	}

	public void mostrar() {
		setVisible(true);
		mostrarSelecaoTime();
	}

	public void commandComming(String command) {
		comandoDraw = command;
		painelPintura.repaint();
	}

	private class Joystick implements KeyListener, WindowListener {

		@Override
		public void keyPressed(KeyEvent arg0) {
			int code = arg0.getKeyCode();
			switch (code) {
			case KeyEvent.VK_RIGHT:
				listener.commanded(Command.RIGHT);
				break;
			case KeyEvent.VK_LEFT:
				listener.commanded(Command.LEFT);
				break;
			case KeyEvent.VK_UP:
				listener.commanded(Command.UP);
				break;
			case KeyEvent.VK_DOWN:
				listener.commanded(Command.DOWN);
				break;
			case KeyEvent.VK_SPACE:
				listener.commanded(Command.SHOOT);
				break;
			default:
				break;
			}
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			int code = arg0.getKeyCode();
			switch (code) {
			case KeyEvent.VK_RIGHT:
				listener.commanded(Command.RIGHT_STOP);
				break;
			case KeyEvent.VK_LEFT:
				listener.commanded(Command.LEFT_STOP);
				break;
			case KeyEvent.VK_UP:
				listener.commanded(Command.UP_STOP);
				break;
			case KeyEvent.VK_DOWN:
				listener.commanded(Command.DOWN_STOP);
				break;
			case KeyEvent.VK_SPACE:
				listener.commanded(Command.SHOOT_STOP);
				break;
			default:
				break;
			}
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
		}

		@Override
		public void windowActivated(WindowEvent e) {
		}

		@Override
		public void windowClosed(WindowEvent e) {
		}

		@Override
		public void windowClosing(WindowEvent e) {
			listener.commanded(Command.EXIT);
		}

		@Override
		public void windowDeactivated(WindowEvent e) {
		}

		@Override
		public void windowDeiconified(WindowEvent e) {
		}

		@Override
		public void windowIconified(WindowEvent e) {
		}

		@Override
		public void windowOpened(WindowEvent e) {
		}
	}

	public interface Listener {
		void commanded(Command command);
		void commanded(Command command, Params params);
	}
	
	public class ListenerAdapter implements Listener{
		public void commanded(Command command) {}
		public void commanded(Command command, Params params) {}
	}

	private class PainelPintura extends JPanel {

		@Override
		protected void paintComponent(Graphics graphics) {
			super.paintComponent(graphics);
			Graphics2D g = (Graphics2D) graphics;
			if (comandoDraw != null) {
				String comandos[] = comandoDraw.split(Util.DRAW_COMMAND_SEPARATOR);
				for (String comando : comandos) {
					GameObject go = Util.translate(comando);
					go.draw(g);
				}
			}
			g.dispose();
		}
	}

	public void mostrarSelecaoTime() {
		teamSelectionDialog.setVisible(true);
	}
	
	private void createTeamSelectionDialog() {
		teamSelectionDialog = new TeamSelectionDialog();
		teamSelectionDialog.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				String team = teamSelectionDialog.getSelectedTeamName();
				String name = teamSelectionDialog.getPlayerName();
				Params params = new Params();
				params.add("team", team);
				params.add("name", name);
				listener.commanded(Command.CONFIGURE_PLAYER, params);
			}
		});
	}
}
