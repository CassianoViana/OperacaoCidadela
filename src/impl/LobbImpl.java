package impl;

import game.Canvas;
import game.GameObject;
import game.Lobb;
import game.LobbListener;
import game.Player;

import java.util.Collection;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LobbImpl implements Lobb {

        private static final int SLEEP_TIME = 100;
        private final Collection<LobbListener> listeners;
        private final Collection<GameObject> gameObjects;
        private final Canvas canvas;
        private final String name;

        public LobbImpl(String name) {
                this.name = name;
                gameObjects = new HashSet<>();
                listeners = new HashSet<>();
                canvas = new CanvasImpl();
        }

        @Override
        public void addPlayer(Player player) {
                System.out.println("GameImpl.addPlayer()");
                gameObjects.add(player);
        }

        @Override
        public String getName() {
                return name;
        }

        @Override
        public void start() {
                while (true) {
                        canvas.paintGameObjects(gameObjects);
                        painted(canvas);
                        sleep();
                }
        }

        private void sleep() {
                try {
                        Thread.sleep(SLEEP_TIME);
                } catch (InterruptedException ex) {
                        Logger.getLogger(LobbImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
        }

        public void painted(Canvas canvas) {
                listeners.parallelStream().forEach((listener) -> {
                        listener.painted(canvas);
                });
        }

        @Override
        public void addListener(LobbListener listener) {
                this.listeners.add(listener);
        }

}
