package de.omikron.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServerConnection {

	private ServerSocket server;
	private int port;
	
	private ArrayList<ClientHandler> clientList;
	
	private boolean isWaitingForClients;
	
	public ServerConnection(int port) {
		this.port = port;
		this.isWaitingForClients = true;
		this.clientList = new ArrayList<>();
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
						
				ClientHandler client = new ClientHandler(this, connection);
				System.out.println("Client connected.");
				
				Thread t1 = new Thread(client);
				t1.start();
				clientList.add(client);
			}	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	protected synchronized void sendToAllClients(String msg) {
		for(ClientHandler ch : clientList) {
			ch.sendMsg(msg);
		}
	}
}