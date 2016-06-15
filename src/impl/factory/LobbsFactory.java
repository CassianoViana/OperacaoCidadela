
package impl.factory;

import game.Lobb;
import impl.LobbImpl;
import impl.decorators.LobbRunnable;
import java.rmi.RemoteException;


public class LobbsFactory {

        public static Lobb createStartedLobb(String name) throws RemoteException {
                LobbRunnable lobbRunnable = new LobbRunnable(new LobbImpl(name));
                lobbRunnable.start();
                return lobbRunnable;
        }

}
