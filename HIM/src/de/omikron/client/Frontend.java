package de.omikron.client;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Frontend extends JFrame {
	
	private JPanel contentPane = new MotionPanel(this);
	
	public Frontend() {
		setUndecorated(true);
		setBounds(100, 100, 1280, 720);
		

	}
	
	protected void init() {
		setVisible(true);		
	}

}
