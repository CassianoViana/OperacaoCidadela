package resources;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class R {
	
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
