package resources;

import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Resources {

        public static Image background1() {
                try {
                        URL img = Resources.class.getResource("background_1.png");
                        return ImageIO.read(img);
                } catch (IOException ex) {
                        Logger.getLogger(Resources.class.getName()).log(Level.SEVERE, null, ex);
                }
                return null;
        }
        
        
}
