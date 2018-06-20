package de.omikron.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler implements Runnable {

	private Socket connection;
	private DataInputStream in;
	private DataOutputStream out;
	
	public ClientHandler(Socket connection) {
		this.connection = connection;
		try {
			in = new DataInputStream(connection.getInputStream());
			out = new DataOutputStream(connection.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while(!connection.isClosed()) {
			try {
				String s = in.readUTF();
				
				switch(s) {
				case "LOGIN":
					break;
				case "DIRECT":
					break;
				case "GROUP":
					break;
				case "NEWGROUP":
					break;
				case "":
					break;
				default:
					break;				
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
