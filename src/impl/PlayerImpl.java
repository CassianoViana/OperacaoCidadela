package impl;

import game.Canvas;
import game.Command;
import game.Player;
import game.Team;

public class PlayerImpl extends Player {
        
        private final float speed = 10;

        @Override
        public void execute(Command command) {
		// TODO Auto-generated method stub
        }

        @Override
        public void setTeam(Team team) {
		// TODO Auto-generated method stub
        }

        @Override
        public void paint(Canvas canvas) {
                canvas.getGraphics().fillOval(getX(), getY(), 30, 30);
        }

        @Override
        public void update() {
                mvRight();
        }

        @Override
        public float getSpeed() {
                return speed;
        }

}
