package de.omikron.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JOptionPane;

public class ClientConnection {

	private Socket connection;
	
	private DataInputStream in;
	private DataOutputStream out;
	
	public ClientConnection(String hostname, int port) {
		try {
			connection = new Socket(hostname, port);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	protected void init() {
		try {
			in = new DataInputStream(connection.getInputStream());
			out = new DataOutputStream(connection.getOutputStream());
			
			String s = JOptionPane.showInputDialog("Gib deine Nachricht ein!");
			out.writeUTF(s);
			
			String tmp = in.readUTF();
			while(tmp != null) {
				System.out.println(tmp);
				tmp = in.readUTF();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
