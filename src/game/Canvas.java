package game;

import java.awt.Image;
import java.io.Serializable;
import javax.swing.JPanel;

public abstract class Canvas extends JPanel implements Serializable {

        public transient Image image;

        public Image getImage() {
                return image;
        }


}
