package game;

import java.rmi.RemoteException;
import java.util.List;

public interface Server extends java.rmi.Remote {

        List<Lobb> listLobbs() throws RemoteException;

        void addListener(ServerListener listener) throws RemoteException;

        void addLobb(Lobb lobb) throws RemoteException;
        
        public void addLobbListener(LobbListener lobbListener, Integer lobbIndex) throws RemoteException;

}
