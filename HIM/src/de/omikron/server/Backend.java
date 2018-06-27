package de.omikron.server;

import de.omikron.client.Frontend;

public class Backend {
	
	private ServerConnection server;
	
	public Backend() {
		server = new ServerConnection(3000);
	}
	
	protected void init() {
		server.init();
	}

}
