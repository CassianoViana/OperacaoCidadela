package core.view;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import core.GameWindow;

public class GameButton extends JButton {

	public GameButton(String string) {
		super(string);
		setBackground(GameWindow.BACK);
		setForeground(GameWindow.FRONT);
		setFont(GameWindow.FONT);
		setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
	}

	@Override
	public Color getBackground() {
		return GameWindow.BACK;
	}

}