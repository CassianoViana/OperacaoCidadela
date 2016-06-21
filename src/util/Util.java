package util;

import java.awt.Graphics;
import java.util.HashMap;
import java.util.Map;

import core.Log;
import gamecore.GameObject;

public class Util {

	public static final String DRAW_COMMAND_SEPARATOR = "!";

	public static void sleep() {
		try {
			Thread.sleep(50);
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

	private static class Holder {
		Map<String, GameObject> map = new HashMap<>();

		public GameObject getGameObjectFromType(String className) throws Exception {
			if (!map.containsKey(className)) {
				map.put(className, (GameObject) Class.forName(className).newInstance());
			}
			return map.get(className);
		}
	}

	private static Holder holder = new Holder();

	public static GameObject translate(String comando) {
		GameObject go = null;
		try {
			Log.d(comando);
			String[] c = comando.split(",");
			String className = c[0];

			go = holder.getGameObjectFromType(className);

			// GameObject go = newGameObject(className);
			go.x = Integer.parseInt(c[1]);
			go.y = Integer.parseInt(c[2]);
			go.w = Integer.parseInt(c[3]);
			go.h = Integer.parseInt(c[4]);
			go.anguloFace = Float.parseFloat(c[5]);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return go;
	}
}
