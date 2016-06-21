package gamecore;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import core.Teams;
import resources.R;

public class Tank extends GameObject {

	private TankType tankType;
	private String name = "Tank";
	private Teams team = Teams.URSS; // Por padrão é da Rússia
	private int vida = 100;

	public Tank() {
		tankType = TankType.STRONG;
		x = 50;
		y = 50;
		w = 50;
		h = 50;
		velTurning = 3;
		speed = 4;
	}

	@Override
	public void draw(Graphics graphics) {
		Graphics2D grafico = (Graphics2D) graphics;

		grafico.setColor(getColor(vida));
		grafico.fillRect(x, y, vida, 5);
		grafico.drawString(name, x, y - 5);
		grafico.setColor(Color.ORANGE);
		grafico.drawRect(x, y, 100, 5);

		grafico.setColor(Color.white);
		Rectangle rectangle = new Rectangle(x, y, w, h);
		AffineTransform transform = new AffineTransform();
		transform.rotate(Math.toRadians(anguloFace), rectangle.getX()
				+ rectangle.width / 2, rectangle.getY() + rectangle.height / 2);
		grafico.setTransform(transform);
		grafico.fill(rectangle);
		grafico.drawImage(team.getImage(), null, x, y);
	}

	private Color getColor(int vida) {
		if (vida > 50) {
			return Color.GREEN;
		} else if (vida > 25) {
			return Color.ORANGE;
		} else {
			return Color.RED;
		}
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

	public Shoot shoot() {
		return tankType.shoot(this);
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTeam(Teams team) {
		this.team = team;
	}

}
