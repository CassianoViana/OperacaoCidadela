
package impl.factory;

import game.Lobb;
import impl.LobbImpl;
import impl.decorators.LobbRunnable;


public class LobbsFactory {

        public static Lobb createStartedLobb(String name) {
                LobbRunnable lobbRunnable = new LobbRunnable(new LobbImpl(name));
                lobbRunnable.start();
                return lobbRunnable;
        }

}
