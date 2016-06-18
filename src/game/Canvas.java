package game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.Serializable;

public abstract class Canvas implements Serializable {

	public BufferedImage image;

	public BufferedImage getImage() {
		return image;
	}

	public Graphics getGraphics() {
		return image.getGraphics();
	}

}
