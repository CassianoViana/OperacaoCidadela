package util;

import core.Params;

public class UtfSplitter {
	
	private String id;
	private String command;
	private Params parameters = new Params();
	
	public void split(String utf){
		String[] parts = Util.split(utf);
		id = parts[0];
		command = parts[1];
		extractParametersIfAny(parts);
	}

	private void extractParametersIfAny(String[] parts) {
		if(anyParam(parts)){
			extract(parts);
		}
	}

	private void extract(String[] parts) {
		parameters = new Params();
		for(int i=2; i<parts.length; i++){
			String[] keyValue = parts[i].split("=");
			String key = keyValue[0];
			String value = keyValue[1];
			parameters.add(key, value);
		}
	}

	private boolean anyParam(String[] parts) {
		return parts.length > 2;
	}
	
	public String getId() {
		return id;
	}
	
	public String getCommand() {
		return command;
	}
	
	public Params getParameters() {
		return parameters;
	}

	public void clear() {
		id = "";
		command = "";
		parameters.clear();
	}
	
}
