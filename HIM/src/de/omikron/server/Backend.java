package de.omikron.server;

public class Backend {
	
	private ServerConnection server;
	
	public Backend() {
		server = new ServerConnection(3000);
	}
	
	protected void init() {
		server.init();
	}

}
