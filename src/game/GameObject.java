package game;

import java.io.Serializable;

public abstract class GameObject implements Serializable {

        private int x, y;

        public void setPosition(int x, int y) {
                this.x = x;
                this.y = y;
        }

        public void mvRight() {
                this.x += getSpeed();
        }

        public abstract void paint(Canvas canvas);

        public abstract void update();
        
        public abstract float getSpeed();

        public int getX() {
                return x;
        }

        public void setX(int x) {
                this.x = x;
        }

        public int getY() {
                return y;
        }

        public void setY(int y) {
                this.y = y;
        }

}
