package game;

import java.io.Serializable;

public abstract class GameObject implements Serializable {

        private int x, y;

        public void setPosition(int x, int y) {
                this.x = x;
                this.y = y;
        }

}
