package view.pages.reservationPage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controller.Controller;
import controller.message.RequestMsg;
import controller.message.ResponseMsg;
import model.beans.reservationBeans.ReservationBean;
import view.MainView;

public class ReservationPage extends JPanel implements MouseListener {
	
	private JFrame frame;

	private JLabel jlFlight;
	private JLabel jlHotel;
	private JLabel jlVehicle;
	private JLabel jlHotelLine;
	private JLabel jlFlightLine;

	private JLabel jlVehicleLine;
	
	private JPanel jpReservations;
	private int currentLabel = 0;
	
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
		jlFlight.setForeground(new Color(30, 146, 195));
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
		jlHotel.setForeground(Color.DARK_GRAY);
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
		jlVehicle.setForeground(Color.DARK_GRAY);
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
		
		Map<String, String> args = new HashMap<>();
		args.put("username", MainView.currentUser);
		args.put("type", ReservationBean.FLIGHT);
		RequestMsg request = new RequestMsg(RequestMsg.SELECT_RESERVATION);
		request.setArgs(args);
		request.sendRequest();
		ResponseMsg response = Controller.handle();
		@SuppressWarnings("unchecked")
		LinkedList<ReservationBean> rbs = (LinkedList<ReservationBean>) response.getData();
		
		jpReservations = new JPanel(null);
		jpReservations.setBackground(Color.WHITE);
		int count = 0;
		while(rbs != null && !rbs.isEmpty()) {
			ReservationBean rb = rbs.pollFirst();
			FlightReservationLabel frl = new FlightReservationLabel(
					rb.getReservationID(), rb.getTime());
			frl.setBounds(20, count * 100, 1000, 100);
			jpReservations.add(frl);
			count++;
		}
		if(count == 0) {
			jpReservations.setPreferredSize(new Dimension(1000, 600));
			JLabel label = new JLabel(response.getMsg(), JLabel.CENTER);
			label.setIcon(new ImageIcon("./icons/uncomplete.png"));
			label.setFont(new Font("Consolas", 1, 25));
			label.setForeground(Color.DARK_GRAY);
			label.setBounds(0, 0, 1000, 200);
			jpReservations.add(label);
		}
		else {
			jpReservations.setPreferredSize(new Dimension(1000, count * 100));
		}
		JScrollPane jspReservations = new JScrollPane(jpReservations);
		jspReservations.setBounds(1, 90, 1050, 660);
		jspReservations.setBorder(null);
		jspReservations.doLayout();
		jspReservations.getVerticalScrollBar().setUnitIncrement(10);

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
		this.add(jspReservations);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(jlFlight) && currentLabel != 0) {
			currentLabel = 0;
			jlFlight.setForeground(new Color(30, 146, 195));
			jlFlightLine.setBackground(new Color(102, 167, 232));
			jlHotel.setForeground(Color.DARK_GRAY);
			jlHotelLine.setBackground(Color.WHITE);
			jlVehicle.setForeground(Color.DARK_GRAY);
			jlVehicleLine.setBackground(Color.WHITE);
			
			Map<String, String> args = new HashMap<>();
			args.put("username", MainView.currentUser);
			args.put("type", ReservationBean.FLIGHT);
			RequestMsg request = new RequestMsg(RequestMsg.SELECT_RESERVATION);
			request.setArgs(args);
			request.sendRequest();
			ResponseMsg response = Controller.handle();
			@SuppressWarnings("unchecked")
			LinkedList<ReservationBean> rbs = (LinkedList<ReservationBean>) response.getData();
			
			jpReservations.removeAll();
			jpReservations.repaint();
			int count = 0;
			while(rbs != null && !rbs.isEmpty()) {
				ReservationBean rb = rbs.pollFirst();
				FlightReservationLabel frl = new FlightReservationLabel(
						rb.getReservationID(), rb.getTime());
				frl.setBounds(20, count * 100, 1000, 100);
				jpReservations.add(frl);
				count++;
			}
			if(count == 0) {
				jpReservations.setPreferredSize(new Dimension(1000, 600));
				JLabel label = new JLabel(response.getMsg(), JLabel.CENTER);
				label.setIcon(new ImageIcon("./icons/uncomplete.png"));
				label.setFont(new Font("Consolas", 1, 25));
				label.setForeground(Color.DARK_GRAY);
				label.setBounds(0, 0, 1000, 200);
				jpReservations.add(label);
			}
			else {
				jpReservations.setPreferredSize(new Dimension(1000, count * 100));
			}
		}
		else if(e.getSource().equals(jlHotel) && currentLabel != 1) {
			currentLabel = 1;
			jlFlight.setForeground(Color.DARK_GRAY);
			jlFlightLine.setBackground(Color.WHITE);
			jlHotel.setForeground(new Color(30, 146, 195));
			jlHotelLine.setBackground(new Color(102, 167, 232));
			jlVehicle.setForeground(Color.DARK_GRAY);
			jlVehicleLine.setBackground(Color.WHITE);
			
			Map<String, String> args = new HashMap<>();
			args.put("username", MainView.currentUser);
			args.put("type", ReservationBean.HOTEL);
			RequestMsg request = new RequestMsg(RequestMsg.SELECT_RESERVATION);
			request.setArgs(args);
			request.sendRequest();
			ResponseMsg response = Controller.handle();
			@SuppressWarnings("unchecked")
			LinkedList<ReservationBean> rbs = (LinkedList<ReservationBean>) response.getData();
			
			jpReservations.removeAll();
			jpReservations.repaint();
			int count = 0;
			while(rbs != null && !rbs.isEmpty()) {
				ReservationBean rb = rbs.pollFirst();
				HotelReservationLabel hrl = new HotelReservationLabel(
						rb.getReservationID(), rb.getTime());
				hrl.setBounds(20, count * 100, 1000, 100);
				jpReservations.add(hrl);
				count++;
			}
			if(count == 0) {
				jpReservations.setPreferredSize(new Dimension(1000, 600));
				JLabel label = new JLabel(response.getMsg(), JLabel.CENTER);
				label.setIcon(new ImageIcon("./icons/uncomplete.png"));
				label.setFont(new Font("Consolas", 1, 25));
				label.setForeground(Color.DARK_GRAY);
				label.setBounds(0, 0, 1000, 200);
				jpReservations.add(label);
			}
			else {
				jpReservations.setPreferredSize(new Dimension(1000, count * 100));
			}
		}
		else if(e.getSource().equals(jlVehicle) && currentLabel != 2) {
			currentLabel = 2;
			jlFlight.setForeground(Color.DARK_GRAY);
			jlFlightLine.setBackground(Color.WHITE);
			jlHotel.setForeground(Color.DARK_GRAY);
			jlHotelLine.setBackground(Color.WHITE);
			jlVehicle.setForeground(new Color(30, 146, 195));
			jlVehicleLine.setBackground(new Color(102, 167, 232));
			
			Map<String, String> args = new HashMap<>();
			args.put("username", MainView.currentUser);
			args.put("type", ReservationBean.VEHICLE);
			RequestMsg request = new RequestMsg(RequestMsg.SELECT_RESERVATION);
			request.setArgs(args);
			request.sendRequest();
			ResponseMsg response = Controller.handle();
			@SuppressWarnings("unchecked")
			LinkedList<ReservationBean> rbs = (LinkedList<ReservationBean>) response.getData();
			
			jpReservations.removeAll();
			jpReservations.repaint();
			int count = 0;
			while(rbs != null && !rbs.isEmpty()) {
				ReservationBean rb = rbs.pollFirst();
				VehicleReservationLabel vrl = new VehicleReservationLabel(
						rb.getReservationID(), rb.getTime());
				vrl.setBounds(20, count * 100, 1000, 100);
				jpReservations.add(vrl);
				count++;
			}
			if(count == 0) {
				jpReservations.setPreferredSize(new Dimension(1000, 600));
				JLabel label = new JLabel(response.getMsg(), JLabel.CENTER);
				label.setIcon(new ImageIcon("./icons/uncomplete.png"));
				label.setFont(new Font("Consolas", 1, 25));
				label.setForeground(Color.DARK_GRAY);
				label.setBounds(0, 0, 1000, 200);
				jpReservations.add(label);
			}
			else {
				jpReservations.setPreferredSize(new Dimension(1000, count * 100));
			}
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
