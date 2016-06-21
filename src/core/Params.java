package core;

import java.util.HashMap;
import java.util.Map;

public class Params {

	private Map<String, Object> params;

	public Params() {
		params = new HashMap<String, Object>();
	}

	public void add(String key, String value) {
		params.put(key, value);
	}

	public String get(String key) {
		return params.getOrDefault(key, "").toString();
	}

	public void clear() {
		params.clear();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		params.forEach((key, value) -> {
			sb.append(key).append("=").append(value).append(",");
		});
		return sb.substring(0, sb.length() - 1).toString();
	}

}
