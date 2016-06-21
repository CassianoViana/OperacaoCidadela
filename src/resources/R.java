package resources;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class R {
	
	public static final String FUNDO_ALEMANHA = "fundo_alemanha.png";
	public static final String FUNDO_RUSSIA = "fundo_russia.png";
	public static final String FUNDO = "background2.jpg";
	public static String background1 = "background1.jpg";
	public static String tank1 = "tank1.jpg";

	public static BufferedImage load(String fileName) {
		try {
			URL resource = R.class.getResource(fileName);
			return ImageIO.read(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
