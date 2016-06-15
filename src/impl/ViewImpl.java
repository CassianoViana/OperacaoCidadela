package impl;

import game.View;
import game.Lobb;
import impl.scennes.SceneListLobbs;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import view.ViewListener;
import view.Scene;

public class ViewImpl extends JFrame implements View {

        private final Collection<ViewListener> listeners;
        private final Canvas canvas;

        public ViewImpl() {
                listeners = new ArrayList<>();
                setSize(1000, 665);
                setResizable(false);
                setLocationRelativeTo(null);
                canvas = new Canvas();
                add(canvas);
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
                Scene sceneListLobbs = new SceneListLobbs(lobbs);
                paint(sceneListLobbs);
        }

        @Override
        public void showError(Throwable e) {

        }

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
                return "Joao";
        }

        @Override
        public void paint(Scene scene) {
                canvas.paintScene(scene);
        }

        private static class Canvas extends JPanel {

                private Scene scene;

                private void paintScene(Scene scene) {
                        this.scene = scene;
                        repaint();
                }

                @Override
                public void paintComponent(Graphics g) {
                        super.paintComponent(g);
                        Graphics2D g2d = (Graphics2D) g;
                        this.scene.pintar(g2d);
                }
        }
}
