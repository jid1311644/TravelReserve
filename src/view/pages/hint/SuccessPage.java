package view.pages.hint;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SuccessPage extends JPanel  {
	
	public SuccessPage(String hint) {
		// TODO Auto-generated constructor stub
		this.setSize(1060, 800);
		this.setBackground(Color.WHITE);
		this.setLayout(null);
		
		JLabel icon = new JLabel(new ImageIcon("./icons/complete.png"), JLabel.CENTER);
		icon.setBounds(350, 350, 50, 50);
		JLabel text = new JLabel(hint, JLabel.CENTER);
		text.setFont(new Font("Consolas", 1, 25));
		text.setForeground(Color.DARK_GRAY);
		text.setBounds(400, 350, 300, 50);
		
		this.add(icon);
		this.add(text);
	}
}
