package gamecore;

import java.awt.Graphics;
import java.util.HashSet;
import java.util.Set;

import core.Log;
import util.Util;

public abstract class GameObject {

	private Set<MovState> movsStates = new HashSet<>();
	public int x = 0, y = 0, w = 30, h = 30;
	public float speed = 5;
	public float anguloFace = 45;
	public float velTurning = 3;
	protected float time = 1;

	public abstract void draw(Graphics g);

	StringBuilder sb = new StringBuilder();

	public String drawCommand() {
		return (String) Util.join(this.getClass().getName(), x, y, w, h, anguloFace);
	}

	public void decodeCommand(Command command) {
		Log.d(movsStates);
	}

	public void update() {
		for (MovState movState : movsStates) {
			movState.move(this);
		}
	}

	public Set<MovState> getMovStates() {
		return movsStates;
	}

	public Vector direction = new Vector();
	public Vector velocity = new Vector();
	public Vector position = new Vector();
	
	public class Vector {
		public float x, y;
	}

	@Override
	public String toString() {
		return "GameObject [movsStates=" + movsStates + ", x=" + x + ", y=" + y + ", w=" + w + ", h=" + h + ", speed="
				+ speed + ", anguloFace=" + anguloFace + ", velTurning=" + velTurning + ", time=" + time + ", sb=" + sb
				+ ", direction=" + direction + ", velocity=" + velocity + ", position=" + position + "]";
	}
	
	

}
