package view.pages.vehiclePage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import controller.Controller;
import controller.message.RequestMsg;
import controller.message.ResponseMsg;
import model.beans.VehicleBean;
import view.MainView;

public class VehiclePage extends JPanel implements MouseListener{

	private ImageIcon search_small = new ImageIcon("./icons/search.png");
	private ImageIcon search_big = new ImageIcon("./icons/search_b.png");
	private ImageIcon select_bus = new ImageIcon("./icons/select_bus.png");
	private ImageIcon select_no_bus = new ImageIcon("./icons/select_nobus.png");
	
	private JFrame frame;
	
	private JTextField jtfCity;
	private JLabel jlSearch;
	private JButton jbBus;
	private JPanel jlVehicles;
	
	private String currentCity = "南京";
	private String currentIsBus = "false";
	private boolean isBus = false;
	
	public VehiclePage(JFrame f) {
		// TODO Auto-generated constructor stub
		this.frame = f;
		this.setSize(1060, 800);
		this.setBackground(new Color(240, 240, 240));
		this.setLayout(null);
		
		jtfCity = new JTextField(currentCity, JTextField.CENTER);
		jtfCity.setBackground(Color.WHITE);
		jtfCity.setFont(new Font("", 1, 24));
		jtfCity.setBorder(null);
		jtfCity.setBounds(375, 50, 100, 40);
		jtfCity.setEditable(false);
		jtfCity.addMouseListener(this);
		JLabel jlLine = new JLabel();
		jlLine.setOpaque(true);
		jlLine.setBackground(new Color(102, 167, 232));
		jlLine.setBounds(350, 90, 150, 1);
		
		jlSearch = new JLabel(search_small, JLabel.CENTER);
		jlSearch.setBounds(570, 40, 70, 70);
		jlSearch.addMouseListener(this);
		
		jbBus = new JButton(select_no_bus);
		jbBus.setBounds(660, 60, 30, 30);
		jbBus.setBackground(Color.WHITE);
		jbBus.setFocusPainted(false);
		jbBus.addMouseListener(this);
		JLabel jlBus = new JLabel("机场大巴", JLabel.CENTER);
		jlBus.setFont(new Font("", 0, 16));
		jlBus.setForeground(new Color(48, 151, 187));
		jlBus.setBounds(690, 60, 80, 30);
		
		JPanel jpTop = new JPanel(null);
		jpTop.setBounds(0, 0, 1060, 120);
		jpTop.setBackground(Color.WHITE);
		
		Map<String, String> args = new HashMap<>();
		args.put("location", currentCity);
		args.put("isBus", currentIsBus);
		RequestMsg request = new RequestMsg(RequestMsg.SEARCH_VEHICLE);
		request.setArgs(args);
		request.sendRequest();
		ResponseMsg response = Controller.handle();
		@SuppressWarnings("unchecked")
		LinkedList<VehicleBean> vehicleBeans = (LinkedList<VehicleBean>) response.getData();
		
		jlVehicles = new JPanel(null);
		jlVehicles.setBackground(new Color(255, 255, 255));
		int count = 0;
		while(vehicleBeans != null && !vehicleBeans.isEmpty()) {
			VehicleBean vehicleBean = vehicleBeans.pollFirst();
			VehicleLabel vehicleLabel = new VehicleLabel(vehicleBean.getCarType(), 
					vehicleBean.getPlateNumber(), vehicleBean.getDestination(), vehicleBean.getPrice());
			vehicleLabel.setBounds(20, count * 100, 1000, 100);
			jlVehicles.add(vehicleLabel);
			count++;
		}
		
		jlVehicles.setPreferredSize(new Dimension(1000, count * 100));
		JScrollPane jspVehicles = new JScrollPane(jlVehicles);
		jspVehicles.setBounds(1, 140, 1050, 610);
		jspVehicles.setBorder(null);
		jspVehicles.doLayout();
		jspVehicles.getVerticalScrollBar().setUnitIncrement(10);
		
		this.add(jlLine);
		this.add(jtfCity);
		this.add(jlSearch);
		this.add(jbBus);
		this.add(jlBus);
		this.add(jpTop);
		this.add(jspVehicles);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(jtfCity)) {
			MainView.selectCities.setLocation(frame.getX() + 410, frame.getY() + 140);
			MainView.selectCities.setJtfCity(jtfCity);
			MainView.selectCities.setVisible(true);
		}
		else if(e.getSource().equals(jbBus)) {
			if(isBus) {
				jbBus.setIcon(select_no_bus);
				isBus = false;
			}
			else {
				jbBus.setIcon(select_bus);
				isBus = true;
			}
		}
		else if(e.getSource().equals(jlSearch)) {
			if(currentCity.equals(jtfCity.getText()) && currentIsBus.equals(isBus + "")) {
				
			}
			else {
				currentCity = jtfCity.getText();
				currentIsBus = isBus + "";
				Map<String, String> args = new HashMap<>();
				args.put("location", currentCity);
				args.put("isBus", currentIsBus);
				RequestMsg request = new RequestMsg(RequestMsg.SEARCH_VEHICLE);
				request.setArgs(args);
				request.sendRequest();
				ResponseMsg response = Controller.handle();
				@SuppressWarnings("unchecked")
				LinkedList<VehicleBean> vehicleBeans = (LinkedList<VehicleBean>) response.getData();
				
				jlVehicles.removeAll();
				jlVehicles.repaint();
				int count = 0;
				while(vehicleBeans != null && !vehicleBeans.isEmpty()) {
					VehicleBean vehicleBean = vehicleBeans.pollFirst();
					VehicleLabel vehicleLabel = new VehicleLabel(vehicleBean.getCarType(), 
							vehicleBean.getPlateNumber(), vehicleBean.getDestination(), vehicleBean.getPrice());
					vehicleLabel.setBounds(20, count * 100, 1000, 100);
					jlVehicles.add(vehicleLabel);
					count++;
				}
				if(count == 0) {
					jlVehicles.setPreferredSize(new Dimension(1000, 600));
					JLabel label = new JLabel(response.getMsg(), JLabel.CENTER);
					label.setIcon(new ImageIcon("./icons/uncomplete.png"));
					label.setFont(new Font("Consolas", 1, 25));
					label.setForeground(Color.DARK_GRAY);
					label.setBounds(0, 0, 1000, 200);
					jlVehicles.add(label);
				}
				else {
					jlVehicles.setPreferredSize(new Dimension(1000, count * 100));
				}
				
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		 if(e.getSource().equals(jlSearch)) {
			 jlSearch.setIcon(search_small);
		 }
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		 if(e.getSource().equals(jlSearch)) {
			 jlSearch.setIcon(search_big);
		 }
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		 if(e.getSource().equals(jlSearch)) {
			 jlSearch.setIcon(search_big);
		 }
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		 if(e.getSource().equals(jlSearch)) {
			 jlSearch.setIcon(search_small);
		 }
	}
	
}
