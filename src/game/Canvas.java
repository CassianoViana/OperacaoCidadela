package game;

import java.awt.Graphics2D;
import java.awt.Image;
import java.io.Serializable;

public abstract class Canvas implements Serializable {

        public transient Image image;

        public Image getImage() {
                return image;
        }

        public Graphics2D getGraphics() {
                return (Graphics2D) image.getGraphics();
        }

}
