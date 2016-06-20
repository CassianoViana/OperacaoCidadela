package gamecore;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import resources.R;

public class Tank extends GameObject {

	private BufferedImage image;

	public Tank() {
		x = 50;
		y = 50;
		w = 50;
		h = 50;
		velTurning = 3;
		speed = 4;
		image = R.load(R.tank1);
	}

	@Override
	public void draw(Graphics graphics) {
		Graphics2D g = (Graphics2D) graphics;
		g.setColor(Color.white);
		Rectangle rectangle = new Rectangle(x, y, w, h);
		AffineTransform transform = new AffineTransform();
		transform.rotate(Math.toRadians(anguloFace), rectangle.getX() + rectangle.width / 2,
				rectangle.getY() + rectangle.height / 2);
		g.setTransform(transform);
		g.fill(rectangle);
		g.dispose();
	}

	@Override
	public void decodeCommand(Command command) {
		super.decodeCommand(command);
		switch (command) {
		case UP:
			getMovStates().add(MovState.GOING_TO_FRONT);
			break;
		case UP_STOP:
			getMovStates().remove(MovState.GOING_TO_FRONT);
			break;
		case DOWN:
			getMovStates().add(MovState.GOING_TO_BACK);
			break;
		case DOWN_STOP:
			getMovStates().remove(MovState.GOING_TO_BACK);
			break;
		case RIGHT:
			getMovStates().add(MovState.TURNING_RIGHT);
			break;
		case RIGHT_STOP:
			getMovStates().remove(MovState.TURNING_RIGHT);
			break;
		case LEFT:
			getMovStates().add(MovState.TURNING_LEFT);
			break;
		case LEFT_STOP:
			getMovStates().remove(MovState.TURNING_LEFT);
		default:
			break;
		}
	}

}
