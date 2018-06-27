package de.omikron.client;

public class Backend {

	private Frontend front;
	private ClientConnection connection;
	
	public Backend() {
		front = new Frontend();
		//connection = new ClientConnection("localhost", 3000);
	}
	
	protected void init() {
		//connection.init();
		front.init();
	}
}
