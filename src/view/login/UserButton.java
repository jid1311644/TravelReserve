package view.login;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;

public class UserButton extends JButton {

	public UserButton(String text) {
		// TODO Auto-generated constructor stub
		super(text);
		setContentAreaFilled(false);
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(new Color(102, 167, 232));
		g.fillRoundRect(0, 0, getSize().width - 1, getSize().height - 1,
				20, 20);
		super.paintComponent(g);
	}
	
	public void paintBorder(Graphics g) {
		//ª≠±ﬂΩÁ«¯”Ú
		g.drawRoundRect(0, 0, getSize().width - 1, getSize().height - 1,
				20, 20);
	}
	
}
