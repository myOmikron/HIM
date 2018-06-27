package de.omikron.client;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.TitlePaneLayout;

@SuppressWarnings("serial")
public class Frontend extends JFrame {
	
	private JPanel contentPane = new MotionPanel(this);
	
	private JPanel sidePanel = new JPanel(null), centerPanel = new JPanel(null), topPanel = new JPanel(null), titlePanel = new JPanel(null);
	private JPanel centerTopPanel = new JPanel(null), centerBottomPanel = new JPanel(null);
	
	private JLabel lblBackground;
	private JLabel lblClose, lblMinimize;
	
	private final ImageIcon background = new ImageIcon("res/background.jpg");
	private final ImageIcon userIconAlpha = new ImageIcon("res/user_alpha.png"), userIconBlue = new ImageIcon("res/user_blue.png");
	private final ImageIcon closeIconAlpha = new ImageIcon("res/close_alpha.png"), closeIconGrey = new ImageIcon("res/close_grey.png");
	private final ImageIcon groupIconAlpha = new ImageIcon("res/group_alpha.png"), groupIconBlue = new ImageIcon("res/group_blue.png");
	private final ImageIcon menueIconAlpha = new ImageIcon("res/menue_alpha.png"), menueIconBlue = new ImageIcon("res/menue_blue.png");
	private final ImageIcon minimizeIconAlpha = new ImageIcon("res/minimize_alpha.png"), minimizeIconGrey = new ImageIcon("res/minimize_grey.png");
	private final ImageIcon settingsIconAlpha = new ImageIcon("res/settings_alpha.png"), settingsIconBlue = new ImageIcon("res/settings_blue.png");
	
	private final Color darkBlue = new Color(0, 0, 150), midBlue = new Color(0, 0, 255);
	private final Color lightGrey = new Color(230, 230, 230), darkGrey = new Color(204, 204, 204);
	
	public Frontend() {
		setUndecorated(true);
		setBounds(50, 50, 1024, 700);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setContentPane(contentPane);
		
	}
	
	protected void init() {
		
		lblClose = new JLabel(closeIconGrey);
		lblClose.setBounds(990, 0, 30, 30);
		lblClose.setOpaque(true);
		lblClose.addMouseListener(new MouseListener() {
			@Override public void mousePressed(MouseEvent e) {  }
			@Override public void mouseClicked(MouseEvent e) {  }
			
			@Override
			public void mouseReleased(MouseEvent e) {
				closeOperation();
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				lblClose.setBackground(Color.red);
			}
			
			
		});
		titlePanel.add(lblClose);
		
		lblMinimize = new JLabel(minimizeIconGrey);
		lblMinimize.setBounds(960, 0, 30, 30);
		titlePanel.add(lblMinimize);
		
		lblBackground = new JLabel(background);
		lblBackground.setBounds(0, 0, 874, 590);
		lblBackground.setOpaque(true);
		centerTopPanel.add(lblBackground);
		
		centerBottomPanel.setBounds(0, 570, 773, 54);
		centerPanel.add(centerBottomPanel);
		
		centerTopPanel.setBounds(0, 0, 773, 570);
		centerPanel.add(centerTopPanel);
		
		centerPanel.setBounds(250, 75, 773, 624);
		contentPane.add(centerPanel);
		
		titlePanel.setBounds(1, 1, 1022, 30);
		titlePanel.setOpaque(true);
		titlePanel.setBackground(lightGrey);
		contentPane.add(titlePanel);
		
		contentPane.setSize(1024, 700);
		contentPane.setBorder(new LineBorder(Color.LIGHT_GRAY));
		contentPane.setLayout(null);
		
		setVisible(true);		
	}
	
	public void closeOperation() {
		
	}

}
