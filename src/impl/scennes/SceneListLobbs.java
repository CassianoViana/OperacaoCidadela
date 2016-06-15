package impl.scennes;

import game.Lobb;
import game.Scene;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class SceneListLobbs implements Scene {

        private final List<Lobb> lobbs;

        private Image fundo;

        public SceneListLobbs(List<Lobb> lobbs) {
                this.lobbs = lobbs;
                try {
                        URL resourceBackground = getClass().getResource("background_1.png");
                        fundo = ImageIO.read(resourceBackground);
                } catch (IOException ex) {
                        Logger.getLogger(SceneListLobbs.class.getName()).log(Level.SEVERE, null, ex);
                }
        }

        @Override
        public void pintar(Graphics2D g2d) {
                g2d.drawImage(fundo, null, null);
                g2d.setColor(Color.yellow);
                g2d.drawString("Escolha uma sala:", 50, 50);
                for (int i = 0; i < lobbs.size(); i++) {
                        String lobbName = i + " - " + lobbs.get(i).getName();
                        g2d.drawString(lobbName, 50, 70 + i * 15);
                }
        }

}
