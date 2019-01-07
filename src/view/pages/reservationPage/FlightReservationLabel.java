package view.pages.reservationPage;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Controller;
import controller.message.RequestMsg;
import model.beans.FlightBean;
import model.beans.reservationBeans.FlightReseverationBean;
import view.dialogs.FlightReservationDetailDialog;

public class FlightReservationLabel extends JPanel {

	private ImageIcon turn_big = new ImageIcon("./icons/turn_b.png");

	public FlightReservationLabel(String reserID, String reserTime) {
		// TODO Auto-generated constructor stub
		
		this.setLayout(null);
		this.setSize(1000, 100);
		this.setBackground(Color.WHITE);
		this.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				FlightReservationDetailDialog dialog = new FlightReservationDetailDialog(reserID);
				dialog.setVisible(true);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				setBorder(BorderFactory.createLineBorder(new Color(102, 167, 232), 1, false));
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				setBorder(null);
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}	
		});
		
		Map<String, String> args = new HashMap<>();
		args.put("reservationID", reserID);
		RequestMsg request = new RequestMsg(RequestMsg.SELECT_FLIGHT_RESERVATION);
		request.setArgs(args);
		request.sendRequest();
		@SuppressWarnings("unchecked")
		LinkedList<FlightReseverationBean> frbs = (LinkedList<FlightReseverationBean>) 
				Controller.handle().getData();

		String flightNum = frbs.peek().getFlightNumber();
		args.put("flightNumber", flightNum);
		request = new RequestMsg(RequestMsg.SELECT_FLIGHT);
		request.setArgs(args);
		request.sendRequest();
		FlightBean fb = (FlightBean) Controller.handle().getData();
		
		args.put("cityID", fb.getDepartureCity());
		request = new RequestMsg(RequestMsg.SELECT_CITY_NAME_BY_ID);
		request.setArgs(args);
		request.sendRequest();
		String startCity = (String) Controller.handle().getData();
		args.replace("cityID", fb.getDestinationCity());
		request.setArgs(args);
		request.sendRequest();
		String arrivaCity = (String) Controller.handle().getData();
		
		JLabel jlStartCity = new JLabel(startCity, JLabel.CENTER);
		jlStartCity.setFont(new Font("", 1, 20));
		jlStartCity.setForeground(Color.DARK_GRAY);
		jlStartCity.setBounds(50, 25, 100, 30);
		JLabel jlStartTime = new JLabel(fb.getDepartureTime(), JLabel.CENTER);
		jlStartTime.setFont(new Font("Consola", 0, 16));
		jlStartTime.setForeground(new Color(85, 85, 85));
		jlStartTime.setBounds(50, 55, 100, 20);
		
		JLabel jlPlane = new JLabel(turn_big, JLabel.CENTER);
		jlPlane.setBounds(150, 20, 50, 50);
		
		JLabel jlArrivaCity = new JLabel(arrivaCity, JLabel.CENTER);
		jlArrivaCity.setFont(new Font("", 1, 20));
		jlArrivaCity.setForeground(Color.DARK_GRAY);
		jlArrivaCity.setBounds(200, 25, 100, 30);
		JLabel jlArrivaTime = new JLabel(fb.getDestinationTime(), JLabel.CENTER);
		jlArrivaTime.setFont(new Font("Consola", 0, 16));
		jlArrivaTime.setForeground(new Color(85, 85, 85));
		jlArrivaTime.setBounds(200, 55, 100, 20);
		
		JLabel jlFlightN = new JLabel("航班号：" + flightNum);
		jlFlightN.setFont(new Font("", 0, 16));
		jlFlightN.setBounds(600, 25, 170, 20);
		
		JLabel jlReserID = new JLabel("订单号：" + reserID);
		jlReserID.setFont(new Font("", 0, 16));
		jlReserID.setBounds(770, 25, 170, 20);
		
		JLabel jlReserTime = new JLabel("下单时间：" + reserTime);
		jlReserTime.setFont(new Font("", 0, 16));
		jlReserTime.setBounds(600, 55, 340, 20);
		
		JLabel line = new JLabel();
		line.setOpaque(true);
		line.setBackground(new Color(240, 240, 240));
		line.setBounds(0, 97, 1000, 2);

		this.add(jlStartCity);
		this.add(jlStartTime);
		this.add(jlPlane);
		this.add(jlArrivaCity);
		this.add(jlArrivaTime);
		this.add(jlFlightN);
		this.add(jlReserID);
		this.add(jlReserTime);
		this.add(line);
		
	}
	
}
