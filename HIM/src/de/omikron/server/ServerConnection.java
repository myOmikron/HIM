package de.omikron.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerConnection {

	private ServerSocket server;
	private int port;
	
	private boolean isWaitingForClients;
	
	public ServerConnection(int port) {
		this.port = port;
		this.isWaitingForClients = true;
	}
	
	@SuppressWarnings("resource")
	protected void init() {
		try {
			System.out.println("Starting server ..");
			server = new ServerSocket(port);
			System.out.println("Server started.");
			
			System.out.println("Waiting for clients ..");
			while(isWaitingForClients) {
				Socket connection = server.accept();
				System.out.println("Client connected.");
						
				ClientHandler client = new ClientHandler(connection);
				System.out.println("Client connected.");
				
				Thread t1 = new Thread(client);
				t1.start();
				
				
			}
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}