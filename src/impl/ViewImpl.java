package impl;

import config.GameConstants;
import game.Canvas;
import game.Lobb;
import game.View;
import java.awt.BorderLayout;
import java.awt.Graphics;
import static java.awt.image.ImageObserver.WIDTH;
import java.io.Serializable;
import java.rmi.RemoteException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import resources.Resources;

import view.ViewListener;

public class ViewImpl extends JFrame implements View {

        private final Collection<ViewListener> listeners;
        private final PanelGame panelGame;

        public ViewImpl() {
                listeners = new ArrayList<>();
                panelGame = new PanelGame();
                setSize(GameConstants.SCREEN_WIDTH, GameConstants.SCREEN_HEIGHT);
                setResizable(false);
                setLocationRelativeTo(null);
                setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                add(panelGame);
        }

        @Override
        public void showView() {
                setVisible(true);
        }

        @Override
        public void showPresentation() {

        }

        @Override
        public void showLobbs(List<Lobb> lobbs) {

        }

        //----------------------------------------------------------------------
        @Override
        public Lobb chooseLobb(List<Lobb> lobbs) {
                try {
                        String i = JOptionPane.showInputDialog("Escolha a sala");
                        Lobb lobb = lobbs.get(Integer.parseInt(i));
                        Canvas canvas;
                        canvas = lobb.getCanvas();
                        canvas.setSize(getSize());
                        remove(panelGame);
                        add(canvas);
                        repaint();
                        return lobb;
                } catch (RemoteException ex) {
                        showError(ex);
                }
                return null;
        }

        @Override
        public void showError(Throwable e) {
                e.printStackTrace();
        }

        //----------------------------------------------------------------------
        @Override
        public void addListener(ViewListener viewListener) {
                this.listeners.add(viewListener);
        }

        @Override
        public void startedLobb() {
                // TODO Auto-generated method stub
        }

        @Override
        public String requestName() {
                return JOptionPane.showInputDialog("Informe o nome");
        }

        //----------------------------------------------------------------------
        @Override
        public void paint(Canvas canvas) {
                System.out.println(canvas.getGraphics());
        }

        private class PanelGame extends JPanel implements Serializable {

                Graphics graphics;

                @Override
                protected void paintComponent(Graphics g) {
                        super.paintComponent(g);
                        g.drawImage(Resources.background1(), WIDTH, WIDTH, this);
                }
        }
}
