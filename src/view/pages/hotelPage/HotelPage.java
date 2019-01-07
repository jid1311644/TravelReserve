package view.pages.hotelPage;

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
import javax.swing.JTextField;

import controller.Controller;
import controller.message.RequestMsg;
import controller.message.ResponseMsg;
import model.beans.HotelBean;
import view.MainView;

public class HotelPage extends JPanel implements MouseListener {
	
	private ImageIcon search_small = new ImageIcon("./icons/search.png");
	private ImageIcon search_big = new ImageIcon("./icons/search_b.png");
	
	private JFrame frame;
	
	private JTextField jtfCity;
	private JLabel jlSearch;
	private JPanel jlHotels;
	
	private String currentCity = "南京";
	
	public HotelPage(JFrame f) {
		// TODO Auto-generated constructor stub
		this.frame = f;
		this.setSize(1060, 800);
		this.setBackground(new Color(240, 240, 240));
		this.setLayout(null);
		
		jtfCity = new JTextField(currentCity, JTextField.CENTER);
		jtfCity.setBackground(Color.WHITE);
		jtfCity.setFont(new Font("", 1, 24));
		jtfCity.setBorder(null);
		jtfCity.setBounds(405, 50, 100, 40);
		jtfCity.setEditable(false);
		jtfCity.addMouseListener(this);
		JLabel jlLine = new JLabel();
		jlLine.setOpaque(true);
		jlLine.setBackground(new Color(102, 167, 232));
		jlLine.setBounds(380, 90, 150, 1);
		
		jlSearch = new JLabel(search_small, JLabel.CENTER);
		jlSearch.setBounds(600, 40, 70, 70);
		jlSearch.addMouseListener(this);
		
		JPanel jpTop = new JPanel(null);
		jpTop.setBounds(0, 0, 1060, 120);
		jpTop.setBackground(Color.WHITE);
		
		Map<String, String> args = new HashMap<>();
		args.put("location", currentCity);
		RequestMsg request = new RequestMsg(RequestMsg.SEARCH_HOTEL);
		request.setArgs(args);
		request.sendRequest();
		ResponseMsg response = Controller.handle();
		@SuppressWarnings("unchecked")
		LinkedList<HotelBean> hotelBeans = (LinkedList<HotelBean>) response.getData();
		
		jlHotels = new JPanel(null);
		jlHotels.setBackground(new Color(255, 255, 255));
		int count = 0;
		while(hotelBeans != null && !hotelBeans.isEmpty()) {
			HotelBean hotelBean = hotelBeans.pollFirst();
			HotelLabel hotelLabel = new HotelLabel(hotelBean.getHotelNumber(), hotelBean.getHotelName(), 
					"位于" + currentCity + "市" + hotelBean.getAddress(), hotelBean.getFloorPrice());	
			hotelLabel.setBounds(20, count * 100, 1000, 100);
			jlHotels.add(hotelLabel);
			count++;
		}
		
		jlHotels.setPreferredSize(new Dimension(1000, count * 100));
		JScrollPane jspHotels = new JScrollPane(jlHotels);
		jspHotels.setBounds(1, 140, 1050, 610);
		jspHotels.setBorder(null);
		jspHotels.doLayout();
		jspHotels.getVerticalScrollBar().setUnitIncrement(10);
		
		this.add(jlLine);
		this.add(jtfCity);
		this.add(jlSearch);
		this.add(jpTop);
		this.add(jspHotels);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(jtfCity)) {
			MainView.selectCities.setLocation(frame.getX() + 440, frame.getY() + 140);
			MainView.selectCities.setJtfCity(jtfCity);
			MainView.selectCities.setVisible(true);
		}
		else if(e.getSource().equals(jlSearch)) {
			if(jtfCity.getText().equals(currentCity)) {
				
			}
			else {
				currentCity = jtfCity.getText();
				Map<String, String> args = new HashMap<>();
				args.put("location", currentCity);
				RequestMsg request = new RequestMsg(RequestMsg.SEARCH_HOTEL);
				request.setArgs(args);
				request.sendRequest();
				ResponseMsg response = Controller.handle();
				@SuppressWarnings("unchecked")
				LinkedList<HotelBean> hotelBeans = (LinkedList<HotelBean>) response.getData();
				
				jlHotels.removeAll();
				jlHotels.repaint();
				int count = 0;
				while(hotelBeans != null && !hotelBeans.isEmpty()) {
					HotelBean hotelBean = hotelBeans.pollFirst();
					HotelLabel hotelLabel = new HotelLabel(hotelBean.getHotelNumber(), hotelBean.getHotelName(), 
							"位于" + currentCity + "市" + hotelBean.getAddress(), hotelBean.getFloorPrice());	
					hotelLabel.setBounds(20, count * 100, 1000, 100);
					jlHotels.add(hotelLabel);
					count++;
				}
				if(count == 0) {
					jlHotels.setPreferredSize(new Dimension(1000, 600));
					JLabel label = new JLabel(response.getMsg(), JLabel.CENTER);
					label.setIcon(new ImageIcon("./icons/uncomplete.png"));
					label.setFont(new Font("Consolas", 1, 25));
					label.setForeground(Color.DARK_GRAY);
					label.setBounds(0, 0, 1000, 200);
					jlHotels.add(label);
				}
				else {
					jlHotels.setPreferredSize(new Dimension(1000, count * 100));
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
