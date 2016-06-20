package gamecore;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import core.GameWindow;
import resources.R;

public class Background extends GameObject {

	private BufferedImage background;
	public Background() {
		w = GameWindow.WIDTH;
		h = GameWindow.HEIGHT;
		x = 0;
		y = 0;
		background = R.load(R.background1);
	}
	@Override
	public void draw(Graphics g) {
		g.drawImage(background, x, y, null);
	}

}
