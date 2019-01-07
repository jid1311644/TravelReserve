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
import model.beans.VehicleBean;
import model.beans.reservationBeans.VehicleReservationBean;
import view.dialogs.ReserveVehicleDialog;

public class VehicleReservationLabel extends JPanel {
	
	private String plateNumber;
	private boolean isBus = false;

	public VehicleReservationLabel(String reserID, String time) {
		// TODO Auto-generated constructor stub
		this.setLayout(null);
		this.setSize(1000, 100);
		this.setBackground(Color.WHITE);
		
		Map<String, String> args = new HashMap<>();
		args.put("reservationID", reserID);
		RequestMsg request = new RequestMsg(RequestMsg.SELECT_VEHICLE_RESERVATION);
		request.setArgs(args);
		request.sendRequest();
		VehicleReservationBean vrb = (VehicleReservationBean) 
				Controller.handle().getData();
		
		plateNumber = vrb.getPlateNumber();
		args.put("plateNumber", plateNumber);
		request = new RequestMsg(RequestMsg.SELECT_VEHICLE);
		request.setArgs(args);
		request.sendRequest();
		VehicleBean vb = (VehicleBean) Controller.handle().getData();
		
		JLabel jlCarType = new JLabel(vb.getCarType());
		jlCarType.setFont(new Font("", 1, 24));
		jlCarType.setBounds(50, 30, 200, 30);
		
		JLabel jlDest = new JLabel();
		jlDest.setFont(new Font("", 0, 16));
		jlDest.setBounds(50, 70, 400, 16);
		jlDest.setVisible(false);
		if(vb.getCarType().equals(VehicleBean.BUS)) {
			isBus = true;
			request = new RequestMsg(RequestMsg.SELECT_BUS_DESTINATION);
			request.setArgs(args);
			request.sendRequest();
			String destination = (String) Controller.handle().getData();
			jlDest.setText("共" + vrb.getTicket() + "张票, 去往" + destination);
			jlDest.setVisible(true);
		}
		
		JLabel jlPlateN = new JLabel("车牌号：" + plateNumber);
		jlPlateN.setFont(new Font("", 0, 16));
		jlPlateN.setBounds(600, 25, 170, 20);
		
		JLabel jlReserID = new JLabel("订单号：" + reserID);
		jlReserID.setFont(new Font("", 0, 16));
		jlReserID.setBounds(770, 25, 170, 20);
		
		JLabel jlReserTime = new JLabel("下单时间：" + time);
		jlReserTime.setFont(new Font("", 0, 16));
		jlReserTime.setBounds(600, 55, 340, 20);
		
		JLabel line = new JLabel();
		line.setOpaque(true);
		line.setBackground(new Color(240, 240, 240));
		line.setBounds(0, 97, 1000, 2);
		
		this.add(jlCarType);
		this.add(jlDest);
		this.add(jlPlateN);
		this.add(jlReserID);
		this.add(jlReserTime);
		this.add(line);
		
		this.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				ReserveVehicleDialog dialog = new ReserveVehicleDialog(plateNumber, isBus);
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
