package view.menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import view.MainView;
import view.login.SignInUp;
import view.pages.flightPage.FlightPage;
import view.pages.hotelPage.HotelPage;
import view.pages.reservationPage.ReservationPage;
import view.pages.vehiclePage.VehiclePage;

public class Menu extends JPanel implements MouseListener {

	private ImageIcon plane_small = new ImageIcon("./icons/plane.png");
	private ImageIcon plane_big = new ImageIcon("./icons/plane_b.png");
	private ImageIcon hotel_small = new ImageIcon("./icons/hotel.png");
	private ImageIcon hotel_big = new ImageIcon("./icons/hotel_b.png");
	private ImageIcon car_small = new ImageIcon("./icons/car.png");
	private ImageIcon car_big = new ImageIcon("./icons/car_b.png");
	private ImageIcon order_small = new ImageIcon("./icons/reservation.png");
	private ImageIcon order_big = new ImageIcon("./icons/reservation_b.png");
	private ImageIcon logout_small = new ImageIcon("./icons/logout.png");
	private ImageIcon logout_big = new ImageIcon("./icons/logout_b.png");
	
	private static MainButton btnFlight;
	private static MainButton btnHotel;
	private static MainButton btnVehicle;
	private JLabel jlReservation;
	private JLabel jlLogout;
	
	private int pageID;
	private JFrame frame;
	
	public Menu(int pageID, JFrame f) {
		// TODO Auto-generated constructor stub
		this.pageID = pageID;
		this.frame = f;
		
		switch (pageID) {
		case MainButton.FLIGHT:
			btnFlight = new MainButton(MainButton.FLIGHT, true);
			btnHotel = new MainButton(MainButton.HOTEL, false);
			btnVehicle = new MainButton(MainButton.VEHICLE, false);
			break;
		case MainButton.HOTEL:
			btnFlight = new MainButton(MainButton.FLIGHT, false);
			btnHotel = new MainButton(MainButton.HOTEL, true);
			btnVehicle = new MainButton(MainButton.VEHICLE, false);
			break;
		case MainButton.VEHICLE:
			btnFlight = new MainButton(MainButton.FLIGHT, false);
			btnHotel = new MainButton(MainButton.HOTEL, false);
			btnVehicle = new MainButton(MainButton.VEHICLE, true);
			break;
		default:
			break;
		}
		
		this.setSize(new Dimension(241, 800));
		this.setLayout(null);
		this.setBackground(new Color(255, 255, 255));
		
		btnFlight.setBounds(0, 0, 240, 80);
		btnFlight.addMouseListener(this);
		btnHotel.setBounds(0, 80, 240, 80);
		btnHotel.addMouseListener(this);
		btnVehicle.setBounds(0, 160, 240, 80);
		btnVehicle.addMouseListener(this);
		
		jlReservation = new JLabel(order_small, JLabel.CENTER);
		jlReservation.setBounds(0, 560, 240, 110);
		jlReservation.addMouseListener(this);
		
		jlLogout = new JLabel(logout_small, JLabel.CENTER);
		jlLogout.setBounds(20, 690, 60, 60);
		jlLogout.addMouseListener(this);
		
		JLabel line = new JLabel();
		line.setOpaque(true);
		line.setBackground(Color.GRAY);
		line.setBounds(240, 0, 1, 800);
		
		this.add(btnFlight);
		this.add(btnHotel);
		this.add(btnVehicle);
		this.add(jlReservation);
		this.add(jlLogout);
		this.add(line);
		
	}

	public static MainButton getBtnRunning() {
		return btnFlight;
	}

	public static void setBtnRunning(MainButton btnRun) {
		Menu.btnFlight = btnRun;
	}
	
	public static MainButton getBtnMachine() {
		return btnHotel;
	}

	public static void setBtnMachine(MainButton btnMachine) {
		Menu.btnHotel = btnMachine;
	}

	public static MainButton getBtnAssist() {
		return btnVehicle;
	}

	public static void setBtnAssist(MainButton btnAssist) {
		Menu.btnVehicle = btnAssist;
	}
	
	public static void setButton(int btnID) {
		switch (btnID) {
		case MainButton.FLIGHT:
			btnFlight.setBackground(new Color(209, 232, 255));
			btnFlight.setChoose(true);
			btnHotel.setBackground(new Color(255, 255, 255));
			btnHotel.setChoose(false);
			btnVehicle.setBackground(new Color(255, 255, 255));
			btnVehicle.setChoose(false);
			break;
		case MainButton.HOTEL:
			btnFlight.setBackground(new Color(255, 255, 255));
			btnFlight.setChoose(false);
			btnHotel.setBackground(new Color(209, 232, 255));
			btnHotel.setChoose(true);
			btnVehicle.setBackground(new Color(255, 255, 255));
			btnVehicle.setChoose(false);
			break;
		case MainButton.VEHICLE:
			btnFlight.setBackground(new Color(255, 255, 255));
			btnFlight.setChoose(false);
			btnHotel.setBackground(new Color(255, 255, 255));
			btnHotel.setChoose(false);
			btnVehicle.setBackground(new Color(209, 232, 255));
			btnVehicle.setChoose(true);
			break;
		default:
			btnFlight.setBackground(new Color(255, 255, 255));
			btnFlight.setChoose(false);
			btnHotel.setBackground(new Color(255, 255, 255));
			btnHotel.setChoose(false);
			btnVehicle.setBackground(new Color(255, 255, 255));
			btnVehicle.setChoose(false);
			break;
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(btnFlight)) {
			if(!btnFlight.isChoose()) {
				setButton(MainButton.FLIGHT);
				MainView.page.removeAll();
				MainView.page.repaint();
				MainView.page.add(new FlightPage(frame));
			}
		}
		else if(e.getSource().equals(btnHotel)) {
			if(!btnHotel.isChoose()) {
				setButton(MainButton.HOTEL);
				MainView.page.removeAll();
				MainView.page.repaint();
				MainView.page.add(new HotelPage(frame));
			}
		}
		else if(e.getSource().equals(btnVehicle)) {
			if(!btnVehicle.isChoose()) {
				setButton(MainButton.VEHICLE);
				MainView.page.removeAll();
				MainView.page.repaint();
				MainView.page.add(new VehiclePage(frame));
			}
		}
		else if(e.getSource().equals(jlReservation)) {
			setButton(-1);
			MainView.page.removeAll();
			MainView.page.repaint();
			MainView.page.add(new ReservationPage(frame));
		}
		else if(e.getSource().equals(jlLogout)) {
			int n = JOptionPane.showConfirmDialog(frame, "Logout now?"
					, "", JOptionPane.YES_NO_OPTION);
			if(n == 0) {
				SignInUp gui = new SignInUp();
				gui.setVisible(true);
				frame.dispose();
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(btnFlight)) {
			btnFlight.setIcon(plane_small);
			if(!btnFlight.isChoose()) {
				btnFlight.setBackground(new Color(209, 232, 255));
			}
		}
		else if(e.getSource().equals(btnHotel)) {
			btnHotel.setIcon(hotel_small);
			if(!btnHotel.isChoose()) {
				btnHotel.setBackground(new Color(209, 232, 255));
			}
		}
		else if(e.getSource().equals(btnVehicle)) {
			btnVehicle.setIcon(car_small);
			if(!btnVehicle.isChoose()) {
				btnVehicle.setBackground(new Color(209, 232, 255));
			}
		}
		else if(e.getSource().equals(jlReservation)) {
			jlReservation.setIcon(order_small);
		}
		else if(e.getSource().equals(jlLogout)) {
			jlLogout.setIcon(logout_small);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(btnFlight)) {
			btnFlight.setIcon(plane_big);
			if(!btnFlight.isChoose()) {
				btnFlight.setBackground(new Color(229, 243, 251));
			}
		}
		else if(e.getSource().equals(btnHotel)) {
			btnHotel.setIcon(hotel_big);
			if(!btnHotel.isChoose()) {
				btnHotel.setBackground(new Color(229, 243, 251));
			}
		}
		else if(e.getSource().equals(btnVehicle)) {
			btnVehicle.setIcon(car_big);
			if(!btnVehicle.isChoose()) {
				btnVehicle.setBackground(new Color(229, 243, 251));
			}
		}
		else if(e.getSource().equals(jlReservation)) {
			jlReservation.setIcon(order_big);
		}
		else if(e.getSource().equals(jlLogout)) {
			jlLogout.setIcon(logout_big);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(btnFlight)) {
			btnFlight.setIcon(plane_big);
			if(!btnFlight.isChoose()) {
				btnFlight.setBackground(new Color(229, 243, 251));
			}
		}
		else if(e.getSource().equals(btnHotel)) {
			btnHotel.setIcon(hotel_big);
			if(!btnHotel.isChoose()) {
				btnHotel.setBackground(new Color(229, 243, 251));
			}
		}
		else if(e.getSource().equals(btnVehicle)) {
			btnVehicle.setIcon(car_big);
			if(!btnVehicle.isChoose()) {
				btnVehicle.setBackground(new Color(229, 243, 251));
			}
		}
		else if(e.getSource().equals(jlReservation)) {
			jlReservation.setIcon(order_big);
		}
		else if(e.getSource().equals(jlLogout)) {
			jlLogout.setIcon(logout_big);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(btnFlight)) {
			btnFlight.setIcon(plane_small);
			if(!btnFlight.isChoose()) {
				btnFlight.setBackground(new Color(255, 255, 255));
			}
		}
		else if(e.getSource().equals(btnHotel)) {
			btnHotel.setIcon(hotel_small);
			if(!btnHotel.isChoose()) {
				btnHotel.setBackground(new Color(255, 255, 255));
			}
		}
		else if(e.getSource().equals(btnVehicle)) {
			btnVehicle.setIcon(car_small);
			if(!btnVehicle.isChoose()) {
				btnVehicle.setBackground(new Color(255, 255, 255));
			}
		}
		else if(e.getSource().equals(jlReservation)) {
			jlReservation.setIcon(order_small);
		}
		else if(e.getSource().equals(jlLogout)) {
			jlLogout.setIcon(logout_small);
		}
	}

}

