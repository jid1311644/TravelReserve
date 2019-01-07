package view.pages.reservationPage;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Controller;
import controller.message.RequestMsg;
import model.beans.HotelBean;
import model.beans.reservationBeans.HotelReservationBean;
import view.dialogs.ReserveHotelDialog;

public class HotelReservationLabel extends JPanel {
	
	private String hotelNumber;

	public HotelReservationLabel(String reserID, String time) {
		// TODO Auto-generated constructor stub
		this.setLayout(null);
		this.setSize(1000, 100);
		this.setBackground(Color.WHITE);
		
		Map<String, String> args = new HashMap<>();
		args.put("reservationID", reserID);
		RequestMsg request = new RequestMsg(RequestMsg.SELECT_HOTEL_RESERVATION);
		request.setArgs(args);
		request.sendRequest();
		HotelReservationBean hrb = (HotelReservationBean) 
				Controller.handle().getData();

		hotelNumber = hrb.getHotelNumber();
		args.put("hotelNumber", hotelNumber);
		request = new RequestMsg(RequestMsg.SELECT_HOTEL);
		request.setArgs(args);
		request.sendRequest();
		HotelBean hb = (HotelBean) Controller.handle().getData();
		
		JLabel jlHotelName = new JLabel(hb.getHotelName());
		jlHotelName.setFont(new Font("", 1, 20));
		jlHotelName.setBounds(50, 25, 400, 20);
		
		JLabel jlRoom = new JLabel(hrb.getRoomNumber() + "间" + hrb.getRoomType());
		jlRoom.setFont(new Font("", 0, 16));
		jlRoom.setBounds(50, 60, 400, 16);
		
		JLabel jlReserID = new JLabel("订单号：" + reserID);
		jlReserID.setFont(new Font("", 0, 16));
		jlReserID.setBounds(600, 25, 170, 20);
		
		JLabel jlReserTime = new JLabel("下单时间：" + time);
		jlReserTime.setFont(new Font("", 0, 16));
		jlReserTime.setBounds(600, 55, 340, 20);
		
		JLabel line = new JLabel();
		line.setOpaque(true);
		line.setBackground(new Color(240, 240, 240));
		line.setBounds(0, 97, 1000, 2);
		
		this.add(jlHotelName);
		this.add(jlRoom);
		this.add(jlReserID);
		this.add(jlReserTime);
		this.add(line);
		
		this.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				ReserveHotelDialog dialog = new ReserveHotelDialog(hotelNumber);
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
	}
	
}
