package view.login;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.MouseInputListener;

public class SignInUp extends JFrame implements MouseListener, KeyListener, FocusListener{
	
	private JFrame frame;
	private TitleBar titleBar;
	
	private JLabel jlIconUser;
	private JTextField jtfUser;
	private JLabel jlLineUser;
	
	private JLabel jlIconPsw;
	private JPasswordField jpfPsw;
	private JLabel jlLinePsw;
	
	private UserButton btnLogin;
	private UserButton btnSignUp;
	
	private JLabel jlSignUp;
	private JLabel jlGoBack;
	private boolean isLoginFrame;
	
	public SignInUp() {
		// TODO Auto-generated constructor stub
		frame = this;
		isLoginFrame = true;
		
		setSize(560, 460);
		Toolkit t = Toolkit.getDefaultToolkit();
		Dimension d = t.getScreenSize();
		int w = d.width;
		int h = d.height;
		int x = (w - 560) / 2;
		int y = (h - 460) / 2;
		setLocation(x, y);
		setUndecorated(true);
		
		titleBar = new TitleBar(560);
		titleBar.setBounds(0, 0, 560, 40);
		titleBar.getJlMinFrame().addMouseListener(this);
		titleBar.getJlCloseFrame().addMouseListener(this);
		MouseEventListener listener = new MouseEventListener(this);
		titleBar.addMouseListener(listener);
		titleBar.addMouseMotionListener(listener);
		
		JLabel jlBack = new JLabel();
		jlBack.setOpaque(true);
		jlBack.setBackground(new Color(102, 167, 232));
		jlBack.setBounds(0, 40, 600, 120);
		
		JLabel jlPhoto = new JLabel(new ImageIcon("./icons/login.png"), JLabel.CENTER);
		jlPhoto.setBounds(205, 90, 150, 150);
		
		jlIconUser = new JLabel(new ImageIcon("./icons/user.png"), JLabel.CENTER);
		jlIconUser.setBounds(130, 230, 30, 30);
		
		jtfUser = new JTextField();
		jtfUser.setBackground(Color.WHITE);
		jtfUser.setFont(new Font("Consola", 0, 24));
		jtfUser.setForeground(Color.BLACK);
		jtfUser.setBorder(null);
		jtfUser.setBounds(170, 230, 250, 40);
		jtfUser.addKeyListener(this);
		jtfUser.addFocusListener(this);
		
		jlLineUser = new JLabel();
		jlLineUser.setOpaque(true);
		jlLineUser.setBackground(new Color(102, 167, 232));
		jlLineUser.setBounds(130, 270, 300, 1);
		
		jlIconPsw = new JLabel(new ImageIcon("./icons/psw_e.png"), JLabel.CENTER);
		jlIconPsw.setBounds(130, 290, 30, 30);
		
		jpfPsw = new JPasswordField();
		jpfPsw.setBackground(Color.WHITE);
		jpfPsw.setFont(new Font("Consola", 0, 24));
		jpfPsw.setForeground(Color.DARK_GRAY);
		jpfPsw.setBorder(null);
		jpfPsw.setBounds(170, 290, 250, 40);
		jpfPsw.addKeyListener(this);
		jpfPsw.addFocusListener(this);
		
		jlLinePsw = new JLabel();
		jlLinePsw.setOpaque(true);
		jlLinePsw.setBackground(new Color(154, 154, 154));
		jlLinePsw.setBounds(130, 330, 300, 1);
		
		btnLogin = new UserButton("Sign In");
		btnLogin.setFont(new Font("Consola", 1, 20));
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setBackground(new Color(102, 167, 232));
		btnLogin.setBounds(130, 360, 300, 45);
		btnLogin.setFocusPainted(false);
		btnLogin.addMouseListener(this);
		
		btnSignUp = new UserButton("Sign Up");
		btnSignUp.setFont(new Font("Consola", 1, 20));
		btnSignUp.setForeground(Color.WHITE);
		btnSignUp.setBackground(new Color(102, 167, 232));
		btnSignUp.setBounds(130, 360, 300, 45);
		btnSignUp.setFocusPainted(false);
		btnSignUp.addMouseListener(this);
		btnSignUp.setVisible(false);
		
		jlSignUp = new JLabel("Sign up", JLabel.CENTER);
		jlSignUp.setForeground(new Color(154, 154, 154));
		jlSignUp.setFont(new Font("Consola", 0, 16));
		jlSignUp.setBounds(460, 410, 80, 30);
		jlSignUp.addMouseListener(this);
		
		jlGoBack = new JLabel("Back", JLabel.CENTER);
		jlGoBack.setForeground(new Color(154, 154, 154));
		jlGoBack.setFont(new Font("Consola", 0, 16));
		jlGoBack.setBounds(460, 410, 80, 30);
		jlGoBack.addMouseListener(this);
		jlGoBack.setVisible(false);
		
		JPanel jPanel = new JPanel(null);
		jPanel.setBackground(Color.WHITE);
		jPanel.setBorder(BorderFactory.createLineBorder(new Color(102, 167, 232), 2, true));
		
		jPanel.add(titleBar);
		jPanel.add(jlPhoto);
		jPanel.add(jlBack);
		jPanel.add(jlIconUser);
		jPanel.add(jtfUser);
		jPanel.add(jlLineUser);
		jPanel.add(jlIconPsw);
		jPanel.add(jpfPsw);
		jPanel.add(jlLinePsw);
		jPanel.add(btnLogin);
		jPanel.add(btnSignUp);
		jPanel.add(jlSignUp);
		jPanel.add(jlGoBack);
		
		this.getContentPane().add(jPanel);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(titleBar.getJlMinFrame())) {
			frame.setExtendedState(JFrame.ICONIFIED);
		}
		else if(e.getSource().equals(titleBar.getJlCloseFrame())) {
			System.exit(0);
		}
		else if(e.getSource().equals(btnLogin)) {
			
		}
		else if(e.getSource().equals(btnSignUp)) {
			
		}
		
		else if(e.getSource().equals(jlSignUp)) {
			jlSignUp.setVisible(false);
			jlGoBack.setVisible(true);
			btnLogin.setVisible(false);
			btnSignUp.setVisible(true);
		}
		
		else if(e.getSource().equals(jlGoBack)) {
			jlSignUp.setVisible(true);
			jlGoBack.setVisible(false);
			btnLogin.setVisible(true);
			btnSignUp.setVisible(false);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(btnLogin)) {
			btnLogin.setFont(new Font("Consola", 1, 20));
		}
		else if(e.getSource().equals(jlSignUp)) {
			jlSignUp.setFont(new Font("Consola", 0, 16));
			jlSignUp.setForeground(Color.GRAY);
		}
		else if(e.getSource().equals(btnSignUp)) {
			btnSignUp.setFont(new Font("Consola", 1, 20));
		}
		else if(e.getSource().equals(jlGoBack)) {
			jlGoBack.setFont(new Font("Consola", 0, 16));
			jlGoBack.setForeground(Color.GRAY);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(btnLogin)) {
			btnLogin.setFont(new Font("Consola", 1, 22));
		}
		else if(e.getSource().equals(jlSignUp)) {
			jlSignUp.setFont(new Font("Consola", 0, 18));
			jlSignUp.setForeground(new Color(154, 154, 154));
		}
		else if(e.getSource().equals(btnSignUp)) {
			btnSignUp.setFont(new Font("Consola", 1, 22));
		}
		else if(e.getSource().equals(jlGoBack)) {
			jlGoBack.setFont(new Font("Consola", 0, 18));
			jlGoBack.setForeground(new Color(154, 154, 154));
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(btnLogin)) {
			btnLogin.setFont(new Font("Consola", 1, 22));
		}
		else if(e.getSource().equals(jlSignUp)) {
			jlSignUp.setFont(new Font("Consola", 0, 18));
			jlSignUp.setForeground(new Color(154, 154, 154));
		}
		else if(e.getSource().equals(btnSignUp)) {
			btnSignUp.setFont(new Font("Consola", 1, 22));
		}
		else if(e.getSource().equals(jlGoBack)) {
			jlGoBack.setFont(new Font("Consola", 0, 18));
			jlGoBack.setForeground(new Color(154, 154, 154));
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(btnLogin)) {
			btnLogin.setFont(new Font("Consola", 1, 20));
		}
		else if(e.getSource().equals(jlSignUp)) {
			jlSignUp.setFont(new Font("Consola", 0, 16));
			jlSignUp.setForeground(new Color(154, 154, 154));
		}
		else if(e.getSource().equals(btnSignUp)) {
			btnSignUp.setFont(new Font("Consola", 1, 20));
		}
		else if(e.getSource().equals(jlGoBack)) {
			jlGoBack.setFont(new Font("Consola", 0, 16));
			jlGoBack.setForeground(new Color(154, 154, 154));
		}
	}
	
	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(jtfUser)) {
			jlIconUser.setIcon(new ImageIcon("./icons/user.png"));
			jlLineUser.setBackground(new Color(102, 167, 232));
		}
		else if(e.getSource().equals(jpfPsw)) {
			jlIconPsw.setIcon(new ImageIcon("./icons/psw.png"));
			jlLinePsw.setBackground(new Color(102, 167, 232));
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(jtfUser)) {
			jlIconUser.setIcon(new ImageIcon("./icons/user_e.png"));
			jlLineUser.setBackground(new Color(154, 154, 154));
		}
		else if(e.getSource().equals(jpfPsw)) {
			jlIconPsw.setIcon(new ImageIcon("./icons/psw_e.png"));
			jlLinePsw.setBackground(new Color(154, 154, 154));
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(jtfUser)) {
			int keyChar = e.getKeyChar();
			byte[] bs = (e.getKeyChar() + "").getBytes();
			for(int i = 0; i < bs.length; i++) {	//½ûÖ¹ÊäÈëºº×Ö
				if(bs[i] >= (byte)0x81 && bs[i] <= (byte)0xfe) {
					e.consume();
				}
			}
			if((keyChar >= 48 && keyChar <= 57)	//Êý×Ö0~9
					|| (keyChar >= 65 && keyChar >= 90)	//×ÖÄ¸A~Z
					|| (keyChar >= 97 && keyChar >= 122)	//×ÖÄ¸a~z
					|| keyChar == 95) {	//ÏÂ»®Ïß_
			}
			else {
				e.consume();
			}
			
			if(jtfUser.getText().length() > 16) {
				e.consume();
			}
		}
		else if(e.getSource().equals(jpfPsw)) {
			int keyChar = e.getKeyChar();
			byte[] bs = (e.getKeyChar() + "").getBytes();
			for(int i = 0; i < bs.length; i++) {	//½ûÖ¹ÊäÈëºº×Ö
				if(bs[i] >= (byte)0x81 && bs[i] <= (byte)0xfe) {
					e.consume();
				}
			}
			if((keyChar >= 48 && keyChar <= 57)	//Êý×Ö0~9
					|| (keyChar >= 65 && keyChar >= 90)	//×ÖÄ¸A~Z
					|| (keyChar >= 97 && keyChar >= 122)	//×ÖÄ¸a~z
					|| keyChar == 95) {	//ÏÂ»®Ïß_
			}
			else {
				e.consume();
			}
			
			if(jpfPsw.getPassword().length > 16) {
				e.consume();
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	class MouseEventListener implements MouseInputListener {
		
		Point origin = new Point();
		SignInUp frame;
		
		public MouseEventListener(SignInUp frame) {
			// TODO Auto-generated constructor stub
			this.frame = frame;
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			origin.x = e.getX();
			origin.y = e.getY();
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			Point p = this.frame.getLocation();
			if(e.getSource().equals(frame.titleBar)) {
				this.frame.setLocation(
						p.x + (e.getX() - origin.x), 
						p.y + (e.getY() - origin.y));
			}
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}

	public static void main(String[] args) {
		new SignInUp().setVisible(true);
	}
	
}


