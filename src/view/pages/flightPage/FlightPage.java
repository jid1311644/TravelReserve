package view.pages.flightPage;

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
import model.beans.FlightBean;
import view.MainView;

public class FlightPage extends JPanel implements MouseListener {

	private ImageIcon turn_small = new ImageIcon("./icons/turn.png");
	private ImageIcon turn_big = new ImageIcon("./icons/turn_b.png");
	private ImageIcon search_small = new ImageIcon("./icons/search.png");
	private ImageIcon search_big = new ImageIcon("./icons/search_b.png");
	
	private JFrame frame;
	
	private JTextField jtfStart;
	private JTextField jtfArriva;
	private JLabel jlTurn;
	private JLabel jlSearch;
	private JPanel jlFlights;
	
	private String currentStart = "南京";
	private String currentArriva = "西安";
	
	public FlightPage(JFrame f) {
		// TODO Auto-generated constructor stub
		this.frame = f;
		
		this.setSize(1060, 800);
		this.setBackground(new Color(240, 240, 240));
		this.setLayout(null);
		
		jtfStart = new JTextField(currentStart, JTextField.CENTER);
		jtfStart.setBackground(Color.WHITE);
		jtfStart.setFont(new Font("", 1, 24));
		jtfStart.setBorder(null);
		jtfStart.setBounds(235, 50, 100, 40);
		jtfStart.setEditable(false);
		jtfStart.addMouseListener(this);
		JLabel jlLineS = new JLabel();
		jlLineS.setOpaque(true);
		jlLineS.setBackground(new Color(102, 167, 232));
		jlLineS.setBounds(210, 90, 150, 1);
		
		jlTurn = new JLabel(turn_small, JLabel.CENTER);
		jlTurn.setBounds(420, 40, 50, 50);
		jlTurn.addMouseListener(this);
		
		jtfArriva = new JTextField(currentArriva, JTextField.CENTER);
		jtfArriva.setBackground(Color.WHITE);
		jtfArriva.setFont(new Font("", 1, 24));
		jtfArriva.setBorder(null);
		jtfArriva.setBounds(565, 50, 100, 40);
		jtfArriva.setEditable(false);
		jtfArriva.addMouseListener(this);
		JLabel jlLineA = new JLabel();
		jlLineA.setOpaque(true);
		jlLineA.setBackground(new Color(102, 167, 232));
		jlLineA.setBounds(540, 90, 150, 1);
		
		jlSearch = new JLabel(search_small, JLabel.CENTER);
		jlSearch.setBounds(780, 40, 70, 70);
		jlSearch.addMouseListener(this);
		
		JPanel jpTop = new JPanel(null);
		jpTop.setBounds(0, 0, 1060, 120);
		jpTop.setBackground(Color.WHITE);

		Map<String, String> args = new HashMap<>();
		args.put("departureCity", jtfStart.getText());
		args.put("destinationCity", jtfArriva.getText());
		RequestMsg request = new RequestMsg(RequestMsg.SEARCH_FLIGHT);
		request.setArgs(args);
		request.sendRequest();
		ResponseMsg response = Controller.handle();
		@SuppressWarnings("unchecked")
		LinkedList<FlightBean> flightBeans = (LinkedList<FlightBean>) response.getData();
		
		jlFlights = new JPanel(null);
		jlFlights.setBackground(new Color(255, 255, 255));
		int count = 0;
		while(flightBeans != null && !flightBeans.isEmpty()) {
			FlightBean flightBean = flightBeans.pollFirst();
			float fp = flightBean.getPrice();
			FlightLabel flightLabel = new FlightLabel(flightBean.getFlightNumber(), 
					flightBean.getDepartureTime(), flightBean.getDestinationTime(), (int) fp + "");
			flightLabel.setBounds(20, count * 100, 1000, 100);
			jlFlights.add(flightLabel);
			count++;
		}
		
		jlFlights.setPreferredSize(new Dimension(1000, count * 100));
		JScrollPane jspFlights = new JScrollPane(jlFlights);
		jspFlights.setBounds(1, 140, 1050, 610);
		jspFlights.setBorder(null);
		jspFlights.doLayout();
		jspFlights.getVerticalScrollBar().setUnitIncrement(10);
		
		this.add(jlLineS);
		this.add(jlLineA);
		this.add(jtfStart);
		this.add(jlTurn);
		this.add(jtfArriva);
		this.add(jlSearch);
		this.add(jpTop);
		this.add(jspFlights);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(jtfStart)) {
			MainView.selectCities.setLocation(frame.getX() + 280, frame.getY() + 140);
			MainView.selectCities.setJtfCity(jtfStart);
			MainView.selectCities.setVisible(true);
		}
		else if(e.getSource().equals(jtfArriva)) {
			MainView.selectCities.setLocation(frame.getX() + 610, frame.getY() + 140);
			MainView.selectCities.setJtfCity(jtfArriva);
			MainView.selectCities.setVisible(true);
		}
		else if(e.getSource().equals(jlTurn)) {
			String start = jtfStart.getText();
			String arriva = jtfArriva.getText();
			jtfStart.setText(arriva);
			jtfArriva.setText(start);
		}
		else if(e.getSource().equals(jlSearch)) {
			if(jtfStart.getText().equals(currentStart) && jtfArriva.getText().equals(currentArriva)) {
				
			}
			else {
				currentStart = jtfStart.getText();
				currentArriva = jtfArriva.getText();
				Map<String, String> args = new HashMap<>();
				args.put("departureCity", currentStart);
				args.put("destinationCity", currentArriva);
				RequestMsg request = new RequestMsg(RequestMsg.SEARCH_FLIGHT);
				request.setArgs(args);
				request.sendRequest();
				ResponseMsg response = Controller.handle();
				@SuppressWarnings("unchecked")
				LinkedList<FlightBean> flightBeans = (LinkedList<FlightBean>) response.getData();
				
				jlFlights.removeAll();
				jlFlights.repaint();
				int count = 0;
				while(flightBeans != null && !flightBeans.isEmpty()) {
					FlightBean flightBean = flightBeans.pollFirst();
					float fp = flightBean.getPrice();
					FlightLabel flightLabel = new FlightLabel(flightBean.getFlightNumber(), 
							flightBean.getDepartureTime(), flightBean.getDestinationTime(), (int) fp + "");
					flightLabel.setBounds(20, count * 100, 1000, 100);
					jlFlights.add(flightLabel);
					count++;
				}
				if(count == 0) {
					jlFlights.setPreferredSize(new Dimension(1000, 600));
					JLabel label = new JLabel(response.getMsg(), JLabel.CENTER);
					label.setIcon(new ImageIcon("./icons/uncomplete.png"));
					label.setFont(new Font("Consolas", 1, 25));
					label.setForeground(Color.DARK_GRAY);
					label.setBounds(0, 0, 1000, 200);
					jlFlights.add(label);
				}
				else {
					jlFlights.setPreferredSize(new Dimension(1000, count * 100));
				}
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(jlTurn)) {
			jlTurn.setIcon(turn_small);
		}
		else if(e.getSource().equals(jlSearch)) {
			jlSearch.setIcon(search_small);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(jlTurn)) {
			jlTurn.setIcon(turn_big);
		}
		else if(e.getSource().equals(jlSearch)) {
			jlSearch.setIcon(search_big);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(jlTurn)) {
			jlTurn.setIcon(turn_big);
		}else if(e.getSource().equals(jlSearch)) {
			jlSearch.setIcon(search_big);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(jlTurn)) {
			jlTurn.setIcon(turn_small);
		}else if(e.getSource().equals(jlSearch)) {
			jlSearch.setIcon(search_small);
		}
	}

}
