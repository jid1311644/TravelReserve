package view.pages.hotelPage;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import view.dialogs.ReserveHotelDialog;


public class HotelLabel extends JPanel {

	private ImageIcon hotel1 = new ImageIcon("./icons/hotel1.png");
	private ImageIcon hotel2 = new ImageIcon("./icons/hotel2.png");
	private ImageIcon hotel3 = new ImageIcon("./icons/hotel3.png");
	private ImageIcon price = new ImageIcon("./icons/hotel_price.png");
	
	private JLabel jlIcon;
	private JLabel jlName;
	private JLabel jlAddress;
	private JLabel jlPrice;
	
	public HotelLabel(String id, String name, String address, int floorPrice) {
		// TODO Auto-generated constructor stub
		this.setLayout(null);
		this.setSize(1000, 100);
		this.setBackground(Color.WHITE);
		this.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				setBorder(null);
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				setBorder(BorderFactory.createLineBorder(new Color(102, 167, 232), 1, false));
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				ReserveHotelDialog dialog = new ReserveHotelDialog(id);
				dialog.setVisible(true);
			}
		});
		
		jlIcon = new JLabel(hotel1, JLabel.CENTER);
		jlIcon.setBounds(20, 15, 70, 70);
		ImageIcon[] hotelIcons = {hotel1, hotel2, hotel3};
		jlIcon.setIcon(hotelIcons[new Random().nextInt(3) % 3]);
		
		jlName = new JLabel(name);
		jlName.setFont(new Font("ËÎÌå", 1, 20));
		jlName.setBounds(120, 30, 700, 20);
		
		jlAddress = new JLabel(address);
		jlAddress.setForeground(new Color(85, 85, 85));
		jlAddress.setFont(new Font("ËÎÌå", 0, 14));
		jlAddress.setBounds(120, 60, 700, 20);
		
		JLabel jlPriceIcon = new JLabel(price, JLabel.CENTER);
		jlPriceIcon.setBounds(850, 45, 20, 20);
		
		jlPrice = new JLabel(floorPrice + "", JLabel.CENTER);
		jlPrice.setFont(new Font("Consola", 1, 30));
		jlPrice.setForeground(new Color(30, 146, 195));
		jlPrice.setBounds(870, 35, 70, 30);
		
		JLabel jlPriceHint = new JLabel("Æð");
		jlPriceHint.setFont(new Font("", 0, 16));
		jlPriceHint.setForeground(new Color(30, 146, 195));
		jlPriceHint.setBounds(950, 49, 16, 16);
		
		JLabel line = new JLabel();
		line.setOpaque(true);
		line.setBackground(new Color(240, 240, 240));
		line.setBounds(0, 97, 1000, 2);
		
		this.add(jlIcon);
		this.add(jlName);
		this.add(jlAddress);
		this.add(jlPriceIcon);
		this.add(jlPrice);
		this.add(jlPriceHint);
		this.add(line);
	}

}
