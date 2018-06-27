package de.omikron.client;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Frontend extends JFrame {
	
	private JPanel contentPane = new MotionPanel(this);
	
	public Frontend() {
		setUndecorated(true);
		setBounds(100, 100, 1024, 700);
		setContentPane(contentPane);
		
		
	}
	
	protected void init() {
		
		contentPane.setBorder(BorderFactory.createEtchedBorder());
		
		setVisible(true);		
	}

}
