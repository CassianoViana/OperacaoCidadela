package game;

import java.io.Serializable;
import java.rmi.Remote;

public interface Lobb extends Serializable {

        void addGameObject(GameObject gameObject);

        String getName();

        void start();

        void addListener(LobbListener listener);

}
