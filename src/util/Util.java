package util;

import java.util.HashMap;
import java.util.Map;

import core.Log;
import core.Teams;
import gamecore.GameObject;
import gamecore.Tank;

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

	public static GameObject toGameObject(String comando) {
		GameObject go = null;
		try {
			Log.d(comando);
			String[] c = comando.split(",");
			String className = c[0];

			go = holder.getGameObjectFromType(className);

			go.x = Integer.parseInt(c[1]);
			go.y = Integer.parseInt(c[2]);
			go.w = Integer.parseInt(c[3]);
			go.h = Integer.parseInt(c[4]);
			go.anguloFace = Float.parseFloat(c[5]);
			
			if (className.endsWith("Tank")) {
				((Tank) go).setName(c[6]);
				((Tank) go).setTeam(Teams.valueOf(c[7]));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return go;
	}
}
