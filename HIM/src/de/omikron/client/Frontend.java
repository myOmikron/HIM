package de.omikron.client;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class Frontend extends JFrame {
	
	private JPanel contentPane = new MotionPanel(this);
	
	private JPanel sidePanel = new JPanel(null), centerPanel = new JPanel(null), titlePanel = new JPanel(null);
	private JPanel centerMidPanel = new JPanel(null), centerBottomPanel = new JPanel(null), centerTopPanel = new JPanel(null);
	private JPanel sideTopPanel = new JPanel(null), sideMidPanel = new JPanel(null);
	private JPanel sideTopSearchPanel = new JPanel(null);
	
	private JLabel lblBackground;
	private JLabel lblClose, lblMinimize;
	private JLabel lblMenue;
	
	private JTextField tfSearch;
	
	private JSeparator sideCenterSeperator;
	
	private final ImageIcon background = new ImageIcon("res/background.jpg");
	private final ImageIcon userIconAlpha = new ImageIcon("res/user_alpha.png"), userIconBlue = new ImageIcon("res/user_blue.png");
	private final ImageIcon closeIconAlpha = new ImageIcon("res/close_alpha.png"), closeIconGrey = new ImageIcon("res/close_grey.png");
	private final ImageIcon groupIconAlpha = new ImageIcon("res/group_alpha.png"), groupIconBlue = new ImageIcon("res/group_blue.png");
	private final ImageIcon menueIconAlpha = new ImageIcon("res/menue_alpha.png"), menueIconGrey = new ImageIcon("res/menue_grey.png");
	private final ImageIcon minimizeIconAlpha = new ImageIcon("res/minimize_alpha.png"), minimizeIconGrey = new ImageIcon("res/minimize_grey.png");
	private final ImageIcon settingsIconAlpha = new ImageIcon("res/settings_alpha.png"), settingsIconBlue = new ImageIcon("res/settings_blue.png");
	
	private final Color lightGrey = new Color(230, 230, 230), darkGrey = new Color(204, 204, 204);
	private final Color white = new Color(250, 250, 250);
	private final Color blue = new Color(102, 194, 255);
	
	private boolean isUserInput = false;
	
	public Frontend() {
		setUndecorated(true);
		setBounds(50, 50, 1024, 700);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setContentPane(contentPane);
		
		
	}
	
	protected void init() {
		
		tfSearch = new JTextField("Search");
		tfSearch.setBounds(15, 0, 235, 35);
		tfSearch.setFont(tfSearch.getFont().deriveFont(16f));
		tfSearch.setForeground(Color.GRAY);
		tfSearch.setOpaque(false);
		tfSearch.setCaretPosition(0);
		tfSearch.setBorder(null);
		tfSearch.addKeyListener(new KeyListener() {
			@Override public void keyReleased(KeyEvent e) {  }
			@Override public void keyPressed(KeyEvent e) {  }
			@Override
			public void keyTyped(KeyEvent e) {
				
				if(!isUserInput) {
					tfSearch.setText("");
					isUserInput = true;
				}
			}
		});
		tfSearch.addMouseListener(new MouseListener() {
			@Override public void mouseClicked(MouseEvent e) {  }
			@Override public void mousePressed(MouseEvent e) {  }
			@Override
			public void mouseReleased(MouseEvent e) {
				tfSearch.setCaretPosition(0);
			}
			@Override  
			public void mouseExited(MouseEvent e) {
				sideTopSearchPanel.setBorder(null);
				sideTopSearchPanel.setBackground(lightGrey);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				sideTopSearchPanel.setBorder(new LineBorder(blue));
				sideTopSearchPanel.setBackground(white);
			}
		});
		sideTopSearchPanel.add(tfSearch);
		
		lblMenue = new JLabel(menueIconGrey);
		lblMenue.setBounds(30, 20, 32, 32);
		sideTopPanel.add(lblMenue);
		
		sideCenterSeperator = new JSeparator(SwingConstants.VERTICAL);
		sideCenterSeperator.setBounds(399, 31, 1, 668);
		sideCenterSeperator.setForeground(Color.GRAY);
		contentPane.add(sideCenterSeperator);
		
		lblClose = new JLabel(closeIconGrey);
		lblClose.setBounds(982, 0, 40, 30);
		lblClose.setOpaque(true);
		lblClose.setBackground(null);
		lblClose.addMouseListener(new MouseListener() {
			@Override public void mousePressed(MouseEvent e) {  }
			@Override public void mouseClicked(MouseEvent e) {  }
			
			@Override
			public void mouseReleased(MouseEvent e) {
				closeOperation();
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				lblClose.setBackground(null);
				lblClose.setIcon(closeIconGrey);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				lblClose.setBackground(Color.red);
				lblClose.setIcon(closeIconAlpha);
			}
			
			
		});
		titlePanel.add(lblClose);
		
		lblMinimize = new JLabel(minimizeIconGrey);
		lblMinimize.setBounds(942, 0, 40, 30);
		lblMinimize.setOpaque(true);
		lblMinimize.setBackground(null);
		lblMinimize.addMouseListener(new MouseListener() {
			@Override public void mousePressed(MouseEvent e) {  }
			@Override public void mouseClicked(MouseEvent e) {  }
			@Override
			public void mouseEntered(MouseEvent e) {
				lblMinimize.setBackground(darkGrey);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				lblMinimize.setBackground(null);
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				setExtendedState(JFrame.ICONIFIED);
			}
		});
		titlePanel.add(lblMinimize);
		
		lblBackground = new JLabel(background);
		lblBackground.setBounds(0, 0, 623, 668);
		lblBackground.setOpaque(true);
		centerPanel.add(lblBackground);
		
		centerBottomPanel.setBounds(0, 615, 623, 53);
		centerPanel.add(centerBottomPanel);
		
		centerMidPanel.setBounds(0, 100, 623, 515);
		centerPanel.add(centerMidPanel);
		
		centerTopPanel.setBounds(0, 0, 623, 100);
		centerPanel.add(centerTopPanel);
		
		centerPanel.setBounds(400, 31, 623, 668);
		contentPane.add(centerPanel);
		
		sideTopSearchPanel.setBounds(80, 20, 250, 35);
		sideTopSearchPanel.setOpaque(true);
		sideTopSearchPanel.setBackground(lightGrey);
		sideTopSearchPanel.setBorder(null);
		sideTopSearchPanel.addMouseListener(new MouseListener() {
			@Override public void mouseClicked(MouseEvent e) {  }
			@Override public void mousePressed(MouseEvent e) {  }
			@Override public void mouseReleased(MouseEvent e) {  }
			@Override
			public void mouseExited(MouseEvent e) {
				sideTopSearchPanel.setBackground(lightGrey);
				sideTopSearchPanel.setBorder(null);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				sideTopSearchPanel.setBackground(white);
				sideTopSearchPanel.setBorder(new LineBorder(blue));
			}
		});
		sideTopPanel.add(sideTopSearchPanel);
		
		sideTopPanel.setBounds(0, 0, 398, 150);
		sideTopPanel.setOpaque(false);
		sidePanel.add(sideTopPanel);
		
		sideMidPanel.setBounds(0, 150, 398, 518);
		sideMidPanel.setOpaque(false);
		sidePanel.add(sideMidPanel);
		
		sidePanel.setBounds(1, 32, 398, 668);
		sidePanel.setBackground(white);
		contentPane.add(sidePanel);
		
		titlePanel.setBounds(1, 1, 1022, 30);
		titlePanel.setOpaque(true);
		titlePanel.setBackground(lightGrey);
		contentPane.add(titlePanel);
		
		contentPane.setSize(1024, 700);
		contentPane.setBorder(new LineBorder(Color.LIGHT_GRAY));
		contentPane.setLayout(null);
		
		setVisible(true);
		requestFocusInWindow();
	}
	
	public void closeOperation() {
		System.exit(0);
	}

}
