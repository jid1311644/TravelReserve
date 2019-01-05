package view.pages.vehiclePage;

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
import view.dialogs.ReserveVehicleDialog;

public class VehicleLabel extends JPanel {

	private ImageIcon car1 = new ImageIcon("./icons/car1.png");
	private ImageIcon car2 = new ImageIcon("./icons/car2.png");
	private ImageIcon car3 = new ImageIcon("./icons/car3.png");
	private ImageIcon car4 = new ImageIcon("./icons/car4.png");
	private ImageIcon bus = new ImageIcon("./icons/bus.png");
	private ImageIcon price = new ImageIcon("./icons/hotel_price.png");

	private JLabel jlCarIcon;
	private JLabel jlCarType;
	private JLabel jlCarPlate;
	private JLabel jlCarPrice;
	
	
	private boolean isBus;
	
	public VehicleLabel(boolean isBus) {
		// TODO Auto-generated constructor stub
		this.isBus = isBus;
		
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
				ReserveVehicleDialog dialog = new ReserveVehicleDialog(true);
				dialog.setVisible(true);
			}
		});
		
		jlCarIcon = new JLabel(car1, JLabel.CENTER);
		jlCarIcon.setBounds(20, 15, 70, 70);
		ImageIcon[] carIcons = {car1, car2, car3, car4};
		if(isBus) {
			jlCarIcon.setIcon(bus);
		}
		else {
			jlCarIcon.setIcon(carIcons[new Random().nextInt(4) % 4]);
		}
		
		jlCarType = new JLabel("商务车");
		jlCarType.setFont(new Font("宋体", 1, 20));
		jlCarType.setBounds(140, 30, 700, 20);
		
		jlCarPlate = new JLabel("京A·14490");
		jlCarPlate.setForeground(new Color(85, 85, 85));
		jlCarPlate.setFont(new Font("宋体", 0, 16));
		jlCarPlate.setBounds(140, 60, 700, 20);
		
		JLabel jlPriceIcon = new JLabel(price, JLabel.CENTER);
		jlPriceIcon.setBounds(850, 45, 20, 20);
		
		jlCarPrice = new JLabel("6.00", JLabel.CENTER);
		jlCarPrice.setFont(new Font("Consola", 1, 30));
		jlCarPrice.setForeground(new Color(30, 146, 195));
		jlCarPrice.setBounds(870, 35, 70, 30);
		
		JLabel jlPriceHint = new JLabel("/千米");
		if(isBus) {
			jlPriceHint.setText("/人");
		}
		else {
			jlPriceHint.setText("/千米");
		}
		jlPriceHint.setFont(new Font("", 0, 16));
		jlPriceHint.setForeground(new Color(30, 146, 195));
		jlPriceHint.setBounds(950, 49, 40, 16);
		
		JLabel line = new JLabel();
		line.setOpaque(true);
		line.setBackground(new Color(240, 240, 240));
		line.setBounds(0, 97, 1000, 2);
		
		this.add(jlCarIcon);
		this.add(jlCarType);
		this.add(jlCarPlate);
		this.add(jlPriceIcon);
		this.add(jlCarPrice);
		this.add(jlPriceHint);
		this.add(line);
		
		
	}
	
}
