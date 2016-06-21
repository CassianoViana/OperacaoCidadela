package gamecore;

import java.awt.Color;
import java.awt.Graphics;

public class Shoot extends GameObject {
	
	public Shoot(GameObject go) {
		this.x = go.x;
		this.y = go.y;
		getMovStates().add(MovState.GOING_TO_FRONT);
	}
	
	public Shoot() {
	}
	
	@Override
	public void update() {
		super.update();
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.yellow);
		g.fillOval(x, y, w, h);
	}

}
