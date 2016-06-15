
package game;

import java.awt.Graphics2D;
import java.io.Serializable;
import java.util.Collection;


public abstract class Canvas implements Serializable, Scene {
        private Graphics2D graphics;

        public Graphics2D getGraphics() {
                return graphics;
        }

        public abstract void paintGameObjects(Collection<GameObject> gameObjects);
}
