package view.pages.vehiclePage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

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
	
	private boolean isBus = false;
	
	public VehiclePage(JFrame f) {
		// TODO Auto-generated constructor stub
		this.frame = f;
		this.setSize(1060, 800);
		this.setBackground(new Color(240, 240, 240));
		this.setLayout(null);
		
		jtfCity = new JTextField("北京", JTextField.CENTER);
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
		
		int size = 10;
		JPanel jlVehicles = new JPanel(null);
		jlVehicles.setBackground(new Color(255, 255, 255));
		jlVehicles.setPreferredSize(new Dimension(1000, size * 100));
		VehicleLabel hotelLabel0 = new VehicleLabel(isBus);
		hotelLabel0.setBounds(20, 0, 1000, 100);
		VehicleLabel hotelLabel1 = new VehicleLabel(true);
		hotelLabel1.setBounds(20, 100, 1000, 100);
		VehicleLabel hotelLabel2 = new VehicleLabel(isBus);
		hotelLabel2.setBounds(20, 200, 1000, 100);
		VehicleLabel hotelLabel3 = new VehicleLabel(isBus);
		hotelLabel3.setBounds(20, 300, 1000, 100);
		VehicleLabel hotelLabel4 = new VehicleLabel(true);
		hotelLabel4.setBounds(20, 400, 1000, 100);
		VehicleLabel hotelLabel5 = new VehicleLabel(isBus);
		hotelLabel5.setBounds(20, 500, 1000, 100);
		VehicleLabel hotelLabel6 = new VehicleLabel(isBus);
		hotelLabel6.setBounds(20, 600, 1000, 100);
		VehicleLabel hotelLabel7 = new VehicleLabel(true);
		hotelLabel7.setBounds(20, 700, 1000, 100);
		VehicleLabel hotelLabel8 = new VehicleLabel(isBus);
		hotelLabel8.setBounds(20, 800, 1000, 100);
		VehicleLabel hotelLabel9 = new VehicleLabel(true);
		hotelLabel9.setBounds(20, 900, 1000, 100);
		jlVehicles.add(hotelLabel0);
		jlVehicles.add(hotelLabel1);
		jlVehicles.add(hotelLabel2);
		jlVehicles.add(hotelLabel3);
		jlVehicles.add(hotelLabel4);
		jlVehicles.add(hotelLabel5);
		jlVehicles.add(hotelLabel6);
		jlVehicles.add(hotelLabel7);
		jlVehicles.add(hotelLabel8);
		jlVehicles.add(hotelLabel9);
		JScrollPane jspVehicles = new JScrollPane(jlVehicles);
		jspVehicles.setBounds(1, 140, 1050, 610);
		jspVehicles.setBorder(null);
		jspVehicles.doLayout();
		
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
