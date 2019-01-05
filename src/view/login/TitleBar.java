package view.login;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TitleBar extends JPanel implements MouseListener {
	
	private JLabel jlText;
	
	private JLabel jlMinFrame;
	private JLabel jlCloseFrame;
	
	public TitleBar(int width) {
		// TODO Auto-generated constructor stub
		this.setLayout(null);
		this.setPreferredSize(new Dimension(width, 40));
		this.setBackground(new Color(102, 167, 232));
		
		int x = (width - 320) / 2;
		jlText = new JLabel(new ImageIcon(
				"./icons/title.png"), JLabel.CENTER);
		jlText.setBounds(x, 0, 330, 40);
		
		x = width - 100;
		jlMinFrame = new JLabel(new ImageIcon(
				"./icons/title_min.png"), JLabel.CENTER);
		jlMinFrame.setOpaque(true);
		jlMinFrame.setBackground(new Color(102, 167, 232));
		jlMinFrame.setBounds(x, 2, 40, 32);
		jlMinFrame.addMouseListener(this);
		
		jlCloseFrame = new JLabel(new ImageIcon(
				"./icons/title_close.png"), JLabel.CENTER);
		jlCloseFrame.setOpaque(true);
		jlCloseFrame.setBackground(new Color(102, 167, 232));
		jlCloseFrame.setBounds(x + 40, 2, 50, 32);
		jlCloseFrame.addMouseListener(this);
		
		this.add(jlText);
		this.add(jlMinFrame);
		this.add(jlCloseFrame);
	}

	public JLabel getJlText() {
		return jlText;
	}

	public JLabel getJlMinFrame() {
		return jlMinFrame;
	}

	public JLabel getJlCloseFrame() {
		return jlCloseFrame;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(jlMinFrame)) {
			jlMinFrame.setIcon(new ImageIcon("./icons/title_min.png"));
			jlMinFrame.setBackground(new Color(102, 115, 255));
			jlCloseFrame.setIcon(new ImageIcon("./icons/title_close.png"));
			jlCloseFrame.setBackground(new Color(102, 167, 232));
		}
		else if(e.getSource().equals(jlCloseFrame)) {
			jlMinFrame.setIcon(new ImageIcon("./icons/title_min.png"));
			jlMinFrame.setBackground(new Color(102, 167, 232));
			jlCloseFrame.setIcon(new ImageIcon("./icons/title_close.png"));
			jlCloseFrame.setBackground(new Color(249, 108, 108));
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(jlMinFrame)) {
			jlMinFrame.setIcon(new ImageIcon("./icons/title_min_choose.png"));
			jlMinFrame.setBackground(new Color(102, 167, 232));
			jlCloseFrame.setIcon(new ImageIcon("./icons/title_close.png"));
			jlCloseFrame.setBackground(new Color(102, 167, 232));
		}
		else if(e.getSource().equals(jlCloseFrame)) {
			jlMinFrame.setIcon(new ImageIcon("./icons/title_min.png"));
			jlMinFrame.setBackground(new Color(102, 167, 232));
			jlCloseFrame.setIcon(new ImageIcon("./icons/title_close_choose.png"));
			jlCloseFrame.setBackground(new Color(102, 167, 232));
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(jlMinFrame)) {
			jlMinFrame.setIcon(new ImageIcon("./icons/title_min_choose.png"));
			jlMinFrame.setBackground(new Color(102, 167, 232));
			jlCloseFrame.setIcon(new ImageIcon("./icons/title_close.png"));
			jlCloseFrame.setBackground(new Color(102, 167, 232));
		}
		else if(e.getSource().equals(jlCloseFrame)) {
			jlMinFrame.setIcon(new ImageIcon("./icons/title_min.png"));
			jlMinFrame.setBackground(new Color(102, 167, 232));
			jlCloseFrame.setIcon(new ImageIcon("./icons/title_close_choose.png"));
			jlCloseFrame.setBackground(new Color(102, 167, 232));
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(jlMinFrame)) {
			jlMinFrame.setIcon(new ImageIcon("./icons/title_min.png"));
			jlMinFrame.setBackground(new Color(102, 167, 232));
			jlCloseFrame.setIcon(new ImageIcon("./icons/title_close.png"));
			jlCloseFrame.setBackground(new Color(102, 167, 232));
		}
		else if(e.getSource().equals(jlCloseFrame)) {
			jlMinFrame.setIcon(new ImageIcon("./icons/title_min.png"));
			jlMinFrame.setBackground(new Color(102, 167, 232));
			jlCloseFrame.setIcon(new ImageIcon("./icons/title_close.png"));
			jlCloseFrame.setBackground(new Color(102, 167, 232));
		}
	}

}
