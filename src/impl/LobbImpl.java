package impl;

import game.Canvas;
import game.GameObject;
import game.Lobb;
import game.LobbListener;
import java.rmi.Remote;

import java.util.Collection;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LobbImpl implements Lobb, Remote {

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
        public void start() {
                boolean gameOver = false;
                while (!gameOver) {
                        update();
                        detectColisions();
                        paint();
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

        //----------------------------------------------------------
        private void update() {
                gameObjects.parallelStream().forEach((gameObject) -> {
                        gameObject.paint(canvas);
                });
        }

        private void detectColisions() {
                gameObjects.parallelStream().forEach((gameObject) -> {
                        gameObject.paint(canvas);
                });
        }

        private void paint() {
                System.out.println("LoobImpl.pintar()" + canvas);
                gameObjects.parallelStream().forEach((gameObject) -> {
                        gameObject.paint(canvas);
                });
                System.out.println(listeners);
                listeners.forEach((listener) -> {
                        listener.newImageWasGenereted(canvas);
                });
        }

        //----------------------------------------------------------
        @Override
        public void addListener(LobbListener listener) {
                this.listeners.add(listener);
        }

        @Override
        public String getName() {
                return name;
        }

        @Override
        public void addGameObject(GameObject gameObject) {
                System.out.println("GameImpl.addGameObject()");
                gameObjects.add(gameObject);
        }

}
