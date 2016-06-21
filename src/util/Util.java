package util;

import java.awt.Graphics;

import core.Log;
import gamecore.GameObject;

public class Util {

	public static final String DRAW_COMMAND_SEPARATOR = "!";

	public static void sleep() {
		try {
			Thread.sleep(30);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static String generateId() {
		return String.valueOf(System.currentTimeMillis());
	}

	public static String[] split(String utf) {
		return utf.split(",");
	}

	public static Object join(Object... objects) {
		String joined = "";
		for (Object object : objects) {
			joined += object + ",";
		}
		joined = joined.substring(0, joined.length() - 1);		
		return joined;
	}

	private static GameObject newGameObject(String className) {
		try {
			return (GameObject) Class.forName(className).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return new GameObject() {
			@Override
			public void draw(Graphics g) {
			}
		};
	}

	public static GameObject translate(String comando) {
		String[] c = comando.split(",");
		String className = c[0];
		GameObject go = newGameObject(className);
		go.x = Integer.parseInt(c[1]);
		go.y = Integer.parseInt(c[2]);
		go.w = Integer.parseInt(c[3]);
		go.h = Integer.parseInt(c[4]);
		go.anguloFace = Float.parseFloat(c[5]);
		return go;
	}
}
