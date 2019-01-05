package view.menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainButton extends JPanel {

	public final static int FLIGHT = 0;
	public final static int HOTEL = 1;
	public final static int VEHICLE = 2;

	private ImageIcon plane_small = new ImageIcon("./icons/plane.png");
	private ImageIcon plane_big = new ImageIcon("./icons/plane_b.png");
	private ImageIcon hotel_small = new ImageIcon("./icons/hotel.png");
	private ImageIcon hotel_big = new ImageIcon("./icons/hotel_b.png");
	private ImageIcon car_small = new ImageIcon("./icons/car.png");
	private ImageIcon car_big = new ImageIcon("./icons/car_b.png");
	
	private JLabel icon = new JLabel();
	private JLabel text = new JLabel();
	
	private int buttonID;
	private boolean isChoose;
	
	public MainButton(int buttonID, boolean isChoose) {
		// TODO Auto-generated constructor stub
		this.buttonID = buttonID;
		this.isChoose = isChoose;
		
		this.setLayout(null);
		this.setSize(new Dimension(240, 80));
		
		icon.setHorizontalAlignment(JLabel.CENTER);
		icon.setBounds(0, 0, 80, 79);
		text.setHorizontalAlignment(JLabel.CENTER);
		text.setFont(new Font("ËÎÌå", 1, 22));
		text.setForeground(Color.DARK_GRAY);
		text.setBounds(80, 0, 140, 79);
		switch (buttonID) {
		case FLIGHT:
			text.setText("º½  °à");
			icon.setIcon(plane_small);
			if(isChoose) {
				this.setBackground(new Color(209, 232, 255));
			}
			else {
				this.setBackground(new Color(255, 255, 255));
			}
			break;
		case HOTEL:
			text.setText("ÂÃ  ¹Ý");
			icon.setIcon(hotel_small);
			if(isChoose) {
				this.setBackground(new Color(209, 232, 255));
			}
			else {
				this.setBackground(new Color(255, 255, 255));
			}
			break;
		case VEHICLE:
			text.setText("½Ó  »ú");
			icon.setIcon(car_small);
			if(isChoose) {
				this.setBackground(new Color(209, 232, 255));
			}
			else {
				this.setBackground(new Color(255, 255, 255));
			}
			break;
		default:
			break;
		}
		
		JLabel line = new JLabel();
		line.setOpaque(true);
		line.setBackground(Color.GRAY);
		line.setBounds(20, 79, 200, 1);
		
		this.add(icon);
		this.add(text);
		this.add(line);
	}
	
	public boolean isChoose() {
		return isChoose;
	}
	
	public void setChoose(boolean isChoose) {
		this.isChoose = isChoose;
	}
	
	public void setIcon(Icon image) {
		icon.setIcon(image);
	}
	
	
}
