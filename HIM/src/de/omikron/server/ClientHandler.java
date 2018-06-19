package de.omikron.server;

import java.net.Socket;

public class ClientHandler implements Runnable {

	private Socket connection;
	
	public ClientHandler(Socket connection) {
		this.connection = connection;
	}

	@Override
	public void run() {
		
	}
	
	
	
}
