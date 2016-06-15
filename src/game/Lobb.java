package game;

import java.io.Serializable;

public interface Lobb extends java.rmi.Remote, Serializable {

        void addGameObject(GameObject gameObject) throws java.rmi.RemoteException;

        String getName() throws java.rmi.RemoteException;

        void start() throws java.rmi.RemoteException;

        void addListener(LobbListener listener) throws java.rmi.RemoteException;

        public Canvas getCanvas() throws java.rmi.RemoteException;

}
