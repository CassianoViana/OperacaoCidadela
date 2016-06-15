package impl;

import config.GameConstants;
import game.Canvas;
import java.awt.image.BufferedImage;

class CanvasImpl extends Canvas {
        public CanvasImpl() {
                image = new BufferedImage(GameConstants.SCREEN_WIDTH, GameConstants.SCREEN_HEIGHT, BufferedImage.TYPE_INT_ARGB);
        }
}
