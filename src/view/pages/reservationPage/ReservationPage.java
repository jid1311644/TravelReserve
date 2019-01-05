package view.pages.reservationPage;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ReservationPage extends JPanel implements MouseListener {
	
	private JFrame frame;

	private JLabel jlFlight;
	private JLabel jlHotel;
	private JLabel jlVehicle;
	private JLabel jlFlightLine;
	private JLabel jlHotelLine;
	private JLabel jlVehicleLine;
	
	public ReservationPage(JFrame f) {
		// TODO Auto-generated constructor stub
		this.frame = f;
		this.setSize(1060, 800);
		this.setBackground(new Color(240, 240, 240));
		this.setLayout(null);
		
		jlFlight = new JLabel("º½°à¶©µ¥", JLabel.CENTER);
		jlFlight.setFont(new Font("", 1, 20));
		jlFlight.setBounds(0, 0, 350, 80);
		jlFlight.setBackground(Color.WHITE);
		jlFlight.setOpaque(true);
		jlFlight.addMouseListener(this);
		JLabel line1 = new JLabel();
		line1.setOpaque(true);
		line1.setBackground(Color.DARK_GRAY);
		line1.setBounds(350, 0, 1, 80);
		jlFlightLine = new JLabel();
		jlFlightLine.setOpaque(true);
		jlFlightLine.setBackground(new Color(102, 167, 232));
		jlFlightLine.setBounds(0, 80, 351, 5);
		
		jlHotel = new JLabel("ÂÃ¹Ý¶©µ¥", JLabel.CENTER);
		jlHotel.setFont(new Font("", 1, 20));
		jlHotel.setBounds(351, 0, 350, 80);
		jlHotel.setBackground(Color.WHITE);
		jlHotel.setOpaque(true);
		jlHotel.addMouseListener(this);
		JLabel line2 = new JLabel();
		line2.setOpaque(true);
		line2.setBackground(Color.DARK_GRAY);
		line2.setBounds(701, 0, 1, 80);
		jlHotelLine = new JLabel();
		jlHotelLine.setOpaque(true);
		jlHotelLine.setBackground(Color.WHITE);
		jlHotelLine.setBounds(351, 80, 351, 5);
		
		jlVehicle = new JLabel("½Ó»ú¶©µ¥", JLabel.CENTER);
		jlVehicle.setFont(new Font("", 1, 20));
		jlVehicle.setBounds(702, 0, 350, 80);
		jlVehicle.setBackground(Color.WHITE);
		jlVehicle.setOpaque(true);
		jlVehicle.addMouseListener(this);
		jlVehicleLine = new JLabel();
		jlVehicleLine.setOpaque(true);
		jlVehicleLine.setBackground(Color.WHITE);
		jlVehicleLine.setBounds(702, 80, 351, 5);
		
		JPanel jpTop = new JPanel(null);
		jpTop.setBounds(0, 0, 1060, 80);
		jpTop.setBackground(Color.WHITE);
		JLabel line3 = new JLabel();
		line3.setOpaque(true);
		line3.setBackground(Color.DARK_GRAY);
		line3.setBounds(0, 85, 1060, 1);

		this.add(jlFlight);
		this.add(jlFlightLine);
		this.add(line1);
		this.add(jlHotel);
		this.add(jlHotelLine);
		this.add(line2);
		this.add(jlVehicle);
		this.add(jlVehicleLine);
		this.add(jpTop);
		this.add(line3);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(jlFlight)) {
			jlFlightLine.setBackground(new Color(102, 167, 232));
			jlHotelLine.setBackground(Color.WHITE);
			jlVehicleLine.setBackground(Color.WHITE);
		}
		else if(e.getSource().equals(jlHotel)) {
			jlFlightLine.setBackground(Color.WHITE);
			jlHotelLine.setBackground(new Color(102, 167, 232));
			jlVehicleLine.setBackground(Color.WHITE);
		}
		else if(e.getSource().equals(jlVehicle)) {
			jlFlightLine.setBackground(Color.WHITE);
			jlHotelLine.setBackground(Color.WHITE);
			jlVehicleLine.setBackground(new Color(102, 167, 232));
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(jlFlight)) {
			
		}
		else if(e.getSource().equals(jlHotel)) {
			
		}
		else if(e.getSource().equals(jlVehicle)) {
			
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(jlFlight)) {
			
		}
		else if(e.getSource().equals(jlHotel)) {
			
		}
		else if(e.getSource().equals(jlVehicle)) {
			
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(jlFlight)) {
			jlFlight.setBackground(new Color(229, 243, 251));
		}
		else if(e.getSource().equals(jlHotel)) {
			jlHotel.setBackground(new Color(229, 243, 251));
		}
		else if(e.getSource().equals(jlVehicle)) {
			jlVehicle.setBackground(new Color(229, 243, 251));
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(jlFlight)) {
			jlFlight.setBackground(Color.WHITE);
		}
		else if(e.getSource().equals(jlHotel)) {
			jlHotel.setBackground(Color.WHITE);
		}
		else if(e.getSource().equals(jlVehicle)) {
			jlVehicle.setBackground(Color.WHITE);
		}
	}

}
