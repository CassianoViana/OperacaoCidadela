package remote;

import game.Canvas;
import game.Command;
import game.Lobb;
import game.LobbListenerAdapter;
import game.Player;
import game.Scene;
import game.Server;
import game.ServerListenerAdapter;
import game.Team;
import game.View;
import impl.ViewImpl;
import java.io.Serializable;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

import view.ViewListenerAdapter;

public class Client implements Serializable {

        private static Server server;
        private static Player player;
        private transient final View view;

        private static Client instance;

        private Client() {
                view = new ViewImpl();
                view.addListener(new ViewListenerAdapter() {
                        @Override
                        public void creattedLobb(Lobb lobb) {
                                try {
                                        server.addLobb(lobb);
                                } catch (Exception e) {
                                        showError(e);
                                }
                        }

                        @Override
                        public void selectedTeam(Team team) {
                                player.setTeam(team);
                        }

                        @Override
                        public void selectedLobb(Lobb lobb) {
                                try {
                                        lobb.addPlayer(player);
                                } catch (Exception e) {
                                        showError(e);
                                }
                        }

                        @Override
                        public void commanded(Command command) {
                                try {
                                        player.execute(command);
                                } catch (Exception e) {
                                        showError(e);
                                }
                        }

                });
        }

        public static void main(String[] args) {
                new Client().start();
        }

        public void start() {
                try {
                        getRemoteServer();
                        showView();
                        createPlayer();
                        chooseLobb();
                } catch (RemoteException | NotBoundException e) {
                        showError(e);
                }
        }

        private void getRemoteServer() throws RemoteException,
                NotBoundException, AccessException {
                Registry registry = LocateRegistry.getRegistry(Registry.REGISTRY_PORT);
                server = (Server) registry.lookup("gameServer");
                server.addListener(new ServerListenerAdapter() {

                        @Override
                        public void updatedLobbs(List<Lobb> lobbs) {
                                showLobbs();
                        }

                        @Override
                        public void startedLobb() {
                                view.startedLobb();
                        }

                        @Override
                        public void updated(Scene scene) {
                                view.paint(scene);
                        }

                });
        }

        private void showView() {
                view.showView();
                view.showPresentation();
        }

        private Player createPlayer() {
                String name = view.requestName();
                player = new impl.PlayerImpl();
                return player;
        }

        private void chooseLobb() {
                showLobbs();
                Lobb lobb;
                try {
                        lobb = view.chooseLobb(server.listLobbs());
                        lobb.addListener(new LobbListenerAdapter() {
                                @Override
                                public void painted(Canvas canvas) {
                                        view.paint(canvas);
                                }
                        });
                } catch (RemoteException ex) {
                        view.showError(ex);
                }

        }

        private void showLobbs() {
                try {
                        view.showLobbs(server.listLobbs());
                } catch (RemoteException ex) {
                        view.showError(ex);
                }
        }

        public static Player create() {
                try {
                        if (instance == null) {
                                instance = new Client();
                                instance.start();
                        }
                        return player;
                } catch (Exception e) {
                        throw new RuntimeException("Falha ao iniciar jogador.", e);
                }
        }

        private void showError(Throwable e) {
                view.showError(e);
        }

}
