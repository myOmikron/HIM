package de.omikron.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

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
	
	private ArrayList<Integer> getInt() {
		ArrayList<Integer> intList = new ArrayList<>();
		
		
		
		return intList;
	}

	@Override
	public void run() {
		
	}
}
