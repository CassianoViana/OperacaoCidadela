package impl.decorators;

import game.Lobb;
import game.LobbListener;
import game.Player;

public class LobbRunnable implements Runnable, Lobb {

        private final Lobb lobb;

        public LobbRunnable(Lobb lobb) {
                this.lobb = lobb;
        }

        @Override
        public void addPlayer(Player player) {
                lobb.addPlayer(player);
        }

        @Override
        public String getName() {
                return lobb.getName();
        }

        @Override
        public void start() {
                new Thread(this).start();
        }

        @Override
        public void addListener(LobbListener listener) {
                lobb.addListener(listener);
        }

        @Override
        public void run() {
                lobb.start();
        }

}
