package view.pages.flightPage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

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
	
	public FlightPage(JFrame f) {
		// TODO Auto-generated constructor stub
		this.frame = f;
		
		this.setSize(1060, 800);
		this.setBackground(new Color(240, 240, 240));
		this.setLayout(null);
		
		jtfStart = new JTextField("西安", JTextField.CENTER);
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
		
		jtfArriva = new JTextField("南京", JTextField.CENTER);
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

		int size = 10;
		JPanel jlFlights = new JPanel(null);
		jlFlights.setBackground(new Color(255, 255, 255));
		jlFlights.setPreferredSize(new Dimension(1000, size * 100));
		FlightLabel flightLabel0 = new FlightLabel();
		flightLabel0.setBounds(20, 0, 1000, 100);
		FlightLabel flightLabel1 = new FlightLabel();
		flightLabel1.setBounds(20, 100, 1000, 100);
		FlightLabel flightLabel2 = new FlightLabel();
		flightLabel2.setBounds(20, 200, 1000, 100);
		FlightLabel flightLabel3 = new FlightLabel();
		flightLabel3.setBounds(20, 300, 1000, 100);
		FlightLabel flightLabel4 = new FlightLabel();
		flightLabel4.setBounds(20, 400, 1000, 100);
		FlightLabel flightLabel5 = new FlightLabel();
		flightLabel5.setBounds(20, 500, 1000, 100);
		FlightLabel flightLabel6 = new FlightLabel();
		flightLabel6.setBounds(20, 600, 1000, 100);
		FlightLabel flightLabel7 = new FlightLabel();
		flightLabel7.setBounds(20, 700, 1000, 100);
		FlightLabel flightLabel8 = new FlightLabel();
		flightLabel8.setBounds(20, 800, 1000, 100);
		FlightLabel flightLabel9 = new FlightLabel();
		flightLabel9.setBounds(20, 900, 1000, 100);
		jlFlights.add(flightLabel0);
		jlFlights.add(flightLabel1);
		jlFlights.add(flightLabel2);
		jlFlights.add(flightLabel3);
		jlFlights.add(flightLabel4);
		jlFlights.add(flightLabel5);
		jlFlights.add(flightLabel6);
		jlFlights.add(flightLabel7);
		jlFlights.add(flightLabel8);
		jlFlights.add(flightLabel9);
		JScrollPane jspFlights = new JScrollPane(jlFlights);
		jspFlights.setBounds(1, 140, 1050, 610);
		jspFlights.setBorder(null);
		jspFlights.doLayout();
		
		
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
