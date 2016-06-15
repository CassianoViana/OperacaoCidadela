package impl.decorators;

import game.Canvas;
import game.GameObject;
import game.Lobb;
import game.LobbListener;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LobbRunnable implements Runnable, Lobb {

        private final Lobb lobb;

        public LobbRunnable(Lobb lobb) {
                this.lobb = lobb;
        }

        @Override
        public void addGameObject(GameObject gameObject) throws RemoteException {
                lobb.addGameObject(gameObject);
        }

        @Override
        public String getName() throws RemoteException {
                return lobb.getName();
        }

        @Override
        public void start() {
                new Thread(this).start();
        }

        @Override
        public void addListener(LobbListener listener) throws RemoteException {
                lobb.addListener(listener);
        }

        @Override
        public Canvas getCanvas() throws RemoteException {
                return lobb.getCanvas();
        }

        @Override
        public void run() {
                try {
                        lobb.start();
                } catch (RemoteException ex) {
                        Logger.getLogger(LobbRunnable.class.getName()).log(Level.SEVERE, null, ex);
                }
        }

}
