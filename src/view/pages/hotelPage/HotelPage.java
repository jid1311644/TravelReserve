package view.pages.hotelPage;

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

public class HotelPage extends JPanel implements MouseListener {
	
	private ImageIcon search_small = new ImageIcon("./icons/search.png");
	private ImageIcon search_big = new ImageIcon("./icons/search_b.png");
	
	private JFrame frame;
	
	private JTextField jtfCity;
	private JLabel jlSearch;
	
	public HotelPage(JFrame f) {
		// TODO Auto-generated constructor stub
		this.frame = f;
		this.setSize(1060, 800);
		this.setBackground(new Color(240, 240, 240));
		this.setLayout(null);
		
		jtfCity = new JTextField("±±¾©", JTextField.CENTER);
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
		
		int size = 10;
		JPanel jlHotels = new JPanel(null);
		jlHotels.setBackground(new Color(255, 255, 255));
		jlHotels.setPreferredSize(new Dimension(1000, size * 100));
		HotelLabel hotelLabel0 = new HotelLabel();
		hotelLabel0.setBounds(20, 0, 1000, 100);
		HotelLabel hotelLabel1 = new HotelLabel();
		hotelLabel1.setBounds(20, 100, 1000, 100);
		HotelLabel hotelLabel2 = new HotelLabel();
		hotelLabel2.setBounds(20, 200, 1000, 100);
		HotelLabel hotelLabel3 = new HotelLabel();
		hotelLabel3.setBounds(20, 300, 1000, 100);
		HotelLabel hotelLabel4 = new HotelLabel();
		hotelLabel4.setBounds(20, 400, 1000, 100);
		HotelLabel hotelLabel5 = new HotelLabel();
		hotelLabel5.setBounds(20, 500, 1000, 100);
		HotelLabel hotelLabel6 = new HotelLabel();
		hotelLabel6.setBounds(20, 600, 1000, 100);
		HotelLabel hotelLabel7 = new HotelLabel();
		hotelLabel7.setBounds(20, 700, 1000, 100);
		HotelLabel hotelLabel8 = new HotelLabel();
		hotelLabel8.setBounds(20, 800, 1000, 100);
		HotelLabel hotelLabel9 = new HotelLabel();
		hotelLabel9.setBounds(20, 900, 1000, 100);
		jlHotels.add(hotelLabel0);
		jlHotels.add(hotelLabel1);
		jlHotels.add(hotelLabel2);
		jlHotels.add(hotelLabel3);
		jlHotels.add(hotelLabel4);
		jlHotels.add(hotelLabel5);
		jlHotels.add(hotelLabel6);
		jlHotels.add(hotelLabel7);
		jlHotels.add(hotelLabel8);
		jlHotels.add(hotelLabel9);
		JScrollPane jspHotels = new JScrollPane(jlHotels);
		jspHotels.setBounds(1, 140, 1050, 610);
		jspHotels.setBorder(null);
		jspHotels.doLayout();
		
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
