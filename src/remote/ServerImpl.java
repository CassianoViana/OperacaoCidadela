package remote;

import game.Lobb;
import game.LobbListener;
import game.Server;
import game.ServerListener;
import impl.factory.LobbsFactory;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class ServerImpl implements Server {

        private static Server game;
        private final List<Lobb> lobbs;

        private ServerImpl() throws RemoteException {
                lobbs = new ArrayList<>();
                lobbs.add(LobbsFactory.createStartedLobb("Dead Field"));
        }

        public static Server instance() throws RemoteException {
                if (game == null) {
                        game = new ServerImpl();
                        registry();
                }
                return game;
        }

        public static void main(String[] args) throws RemoteException {
                ServerImpl.instance();
        }

        private static void registry() {
                try {
                        Server gameStub = (Server) UnicastRemoteObject.exportObject(game, Registry.REGISTRY_PORT);
                        Registry registry = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
                        registry.rebind("gameServer", gameStub);
                } catch (RemoteException e) {
                        throw new RuntimeException("Falha ao iniciar servidor.", e);
                }
        }

        @Override
        public List<Lobb> listLobbs() {
                return lobbs;
        }

        @Override
        public void addListener(ServerListener listener) {

        }

        @Override
        public void addLobb(Lobb lobb) {
                this.lobbs.add(lobb);
        }

        @Override
        public void addLobbListener(LobbListener lobbListener, Integer lobbIndex) throws RemoteException {
                lobbs.get(lobbIndex).addListener(lobbListener);
        }

}
