package de.omikron.client;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import de.omikron.client.MyScrollBar.MyScrollbarUI;

@SuppressWarnings("serial")
public class Frontend extends JFrame {
	
	private JPanel contentPane = new MotionPanel(this);
	
	private JPanel sidePanel = new JPanel(null), centerPanel = new JPanel(null), titlePanel = new JPanel(null);
	private JPanel centerMidPanel = new JPanel(null), centerBottomPanel = new JPanel(null), centerTopPanel = new JPanel(null);
	private JPanel sideTopPanel = new JPanel(null), sideMidPanel = new JPanel(null);
	private JPanel sideTopSearchPanel = new JPanel(null);
	
	private JScrollPane sideMidScrollPane = new JScrollPane();
	
	private JLabel lblBackground;
	private JLabel lblClose, lblMinimize;
	private JLabel lblMenue, lblSearchClose;
	
	private JTextField tfSearch;
	
	private JSeparator sideCenterSeperator;
	
	private final ImageIcon background = new ImageIcon("res/background.jpg");
	private final ImageIcon userIconAlpha = new ImageIcon("res/user_alpha.png");
	private final ImageIcon closeIconAlpha = new ImageIcon("res/close_alpha.png"), closeIconGrey = new ImageIcon("res/close_grey.png");
	private final ImageIcon closeIconDarkGrey = new ImageIcon("res/close_darkgrey.png");
	private final ImageIcon groupIconAlpha = new ImageIcon("res/group_alpha.png");
	private final ImageIcon menueIconAlpha = new ImageIcon("res/menue_alpha.png"), menueIconGrey = new ImageIcon("res/menue_grey.png");
	private final ImageIcon minimizeIconGrey = new ImageIcon("res/minimize_grey.png");
	private final ImageIcon settingsIconAlpha = new ImageIcon("res/settings_alpha.png");
	
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
		
		lblSearchClose = new JLabel(closeIconGrey);
		lblSearchClose.setBounds(268, 2, 32, 32);
		lblSearchClose.setOpaque(false);
		lblSearchClose.setVisible(false);
		lblSearchClose.addMouseListener(new MouseListener() {
			@Override public void mouseClicked(MouseEvent e) {  }
			@Override public void mousePressed(MouseEvent e) {  }
			@Override
			public void mouseEntered(MouseEvent e) {
				lblSearchClose.setIcon(closeIconDarkGrey);
				sideTopSearchPanel.setBackground(white);
				sideTopSearchPanel.setBorder(new LineBorder(blue));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				lblSearchClose.setIcon(closeIconGrey);
				sideTopSearchPanel.setBackground(lightGrey);
				sideTopSearchPanel.setBorder(null);
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
				isUserInput = false;
				tfSearch.setText("Search");
				updateSearchCloseVisible();
				requestFocusInWindow();
			}
		});
		sideTopSearchPanel.add(lblSearchClose);
		
		tfSearch = new JTextField("Search");
		tfSearch.setBounds(15, 0, 235, 35);
		tfSearch.setFont(tfSearch.getFont().deriveFont(16f));
		tfSearch.setForeground(Color.GRAY);
		tfSearch.setOpaque(false);
		tfSearch.setCaretPosition(0);
		tfSearch.setBorder(null);
		tfSearch.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				sideTopSearchPanel.setBackground(lightGrey);
				sideTopSearchPanel.setBorder(null);
				isUserInput = false;
			}
			@Override
			public void focusGained(FocusEvent e) {
				sideTopSearchPanel.setBackground(white);
				sideTopSearchPanel.setBorder(new LineBorder(blue, 2));
				isUserInput = true;
			}
		});
		tfSearch.addKeyListener(new KeyListener() {
			@Override public void keyReleased(KeyEvent e) {  }
			@Override public void keyTyped(KeyEvent e) {  }
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() != KeyEvent.VK_ENTER && e.getKeyCode() != KeyEvent.VK_BACK_SPACE && e.getKeyCode() != KeyEvent.VK_SHIFT) {
					searchForUser(tfSearch.getText() + e.getKeyChar());
					isUserInput = true;
					updateSearchCloseVisible();
				}
				
				if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
					searchForUser(tfSearch.getText().substring(0, tfSearch.getText().length()-1));
				}
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					searchForMessage(tfSearch.getText());
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
				if(isUserInput) {
					if(tfSearch.getText() == "") {
						isUserInput = false;
						tfSearch.setText("Search");
						sideTopSearchPanel.setBorder(null);
						sideTopSearchPanel.setBackground(lightGrey);
					}
				} else {
					tfSearch.setText("Search");
					sideTopSearchPanel.setBorder(null);
					sideTopSearchPanel.setBackground(lightGrey);
				}
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				if(!isUserInput) {
					tfSearch.setText("");
				}
				sideTopSearchPanel.setBorder(new LineBorder(blue, 2));
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
		
		sideTopSearchPanel.setBounds(80, 20, 300, 35);
		sideTopSearchPanel.setOpaque(true);
		sideTopSearchPanel.setBackground(lightGrey);
		sideTopSearchPanel.setBorder(null);
		sideTopSearchPanel.addMouseListener(new MouseListener() {
			@Override public void mouseClicked(MouseEvent e) {  }
			@Override public void mousePressed(MouseEvent e) {  }
			@Override
			public void mouseReleased(MouseEvent e) {
				tfSearch.setCaretPosition(0);
			}
			@Override  
			public void mouseExited(MouseEvent e) {
				if(isUserInput) {
					if(tfSearch.getText() == "") {
						isUserInput = false;
						tfSearch.setText("Search");
						sideTopSearchPanel.setBorder(null);
						sideTopSearchPanel.setBackground(lightGrey);
					}
				} else {
					tfSearch.setText("Search");
					sideTopSearchPanel.setBorder(null);
					sideTopSearchPanel.setBackground(lightGrey);
				}
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				if(!isUserInput) {
					tfSearch.setText("");
				}
				sideTopSearchPanel.setBorder(new LineBorder(blue, 2));
				sideTopSearchPanel.setBackground(white);
			}
		});
		sideTopPanel.add(sideTopSearchPanel);
		
		sideTopPanel.setBounds(0, 0, 398, 80);
		sideTopPanel.setOpaque(false);
		sidePanel.add(sideTopPanel);
		
		sideMidScrollPane.setBounds(0, 0, 397, 587);
		sideMidScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		sideMidScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		sideMidScrollPane.setUI(new MyScrollbarUI());
		sideMidScrollPane.setOpaque(false);
		sideMidScrollPane.getViewport().setOpaque(false);
		sideMidScrollPane.setBorder(null);
		sideMidPanel.add(sideMidScrollPane);
		
		sideMidPanel.setBounds(0, 80, 398, 588);
		sideMidPanel.setOpaque(false);
		sidePanel.add(sideMidPanel);
		
		sidePanel.setBounds(1, 32, 398, 667);
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
	
	public void searchForUser(String s) {
		System.out.println(s);
	}
	
	public void searchForMessage(String s) {
		System.out.println(s);
	}
	
	private void updateSearchCloseVisible() {
		if(isUserInput) {
			lblSearchClose.setVisible(true);
		} else {
			lblSearchClose.setVisible(false);
		}
	}

}
