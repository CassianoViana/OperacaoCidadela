package core;

public class Log {

	public static void d(Object msg) {
		System.out.println(msg + ".");
	}

	public static void d(Object origem, Object msg) {
		System.out.println(origem.getClass().getSimpleName() + ": " + msg + ".");
	}

	public static void e(Object origem, Object msg) {
		System.err.println(origem.getClass().getSimpleName() + ": " + msg + ".");
	}

}
