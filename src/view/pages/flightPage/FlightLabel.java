package view.pages.flightPage;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import view.dialogs.ReserveFlightDialog;

public class FlightLabel extends JPanel {

	private ImageIcon arrow = new ImageIcon("./icons/arrow.png");
	private ImageIcon price = new ImageIcon("./icons/price_icon.png");
	
	private JLabel jlFlightNumber;
	private JLabel jlStartTime;
	private JLabel jlArrivaTime;
	private JLabel jlArrow;
	private JLabel jlTime;
	private JLabel jlPriceIcon;
	private JLabel jlPrice;

	public FlightLabel() {
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
				ReserveFlightDialog dialog = new ReserveFlightDialog();
				dialog.setVisible(true);
			}
		});
		
		jlFlightNumber = new JLabel("¼ªÏéº½MU23C88", JLabel.CENTER);
		jlFlightNumber.setFont(new Font("Consola", 0, 20));
		jlFlightNumber.setBounds(30, 35, 150, 30);
		
		jlStartTime = new JLabel("23:45", JLabel.CENTER);
		jlStartTime.setFont(new Font("Consola", 0, 30));
		jlStartTime.setBounds(345, 25, 80, 50);
		
		jlArrivaTime = new JLabel("01:55", JLabel.CENTER);
		jlArrivaTime.setFont(new Font("Consola", 0, 30));
		jlArrivaTime.setBounds(575, 25, 80, 50);
		
		String time = "";
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
			Date start = sdf.parse(jlStartTime.getText());
			Date arriva = sdf.parse(jlArrivaTime.getText());
			long minutes = (arriva.getTime() - start.getTime()) / 60000;
			if(minutes <= 0) {
				sdf = new SimpleDateFormat("dd HH:mm");
				start = sdf.parse("01 " + jlStartTime.getText());
				arriva = sdf.parse("02 " + jlArrivaTime.getText());
				minutes = (arriva.getTime() - start.getTime()) / 60000;
			}
			time = ((minutes / 60 == 0)? "":minutes / 60 + "Ð¡Ê±") + 
					((minutes % 60 == 0)? "":minutes % 60 + "·ÖÖÓ");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jlTime = new JLabel(time, JLabel.CENTER);
		jlTime.setFont(new Font("", 0, 14));
		jlTime.setForeground(new Color(136, 136, 136));
		jlTime.setBounds(425, 35, 150, 20);
		
		jlArrow = new JLabel(arrow, JLabel.CENTER);
		jlArrow.setBounds(425, 55, 150, 10);
		
		jlPriceIcon = new JLabel(price, JLabel.CENTER);
		jlPriceIcon.setBounds(860, 45, 20, 20);
		
		jlPrice = new JLabel("1080", JLabel.CENTER);
		jlPrice.setFont(new Font("Consola", 1, 30));
		jlPrice.setForeground(new Color(255, 130, 5));
		jlPrice.setBounds(880, 35, 70, 30);
		
		JLabel line = new JLabel();
		line.setOpaque(true);
		line.setBackground(new Color(240, 240, 240));
		line.setBounds(0, 97, 1000, 2);
		
		this.add(jlFlightNumber);
		this.add(jlStartTime);
		this.add(jlTime);
		this.add(jlArrow);
		this.add(jlArrivaTime);
		this.add(jlPriceIcon);
		this.add(jlPrice);
		this.add(line);
		
	}
	
}
