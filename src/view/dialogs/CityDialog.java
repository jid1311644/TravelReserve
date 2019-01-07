package view.dialogs;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import view.MainView;

public class CityDialog extends JDialog {

	public static final int FROM_FLIGHT_START = 0;
	public static final int FROM_FLIGHT_ARRIVA = 1;
	public static final int FROM_HOTEL = 2;
	public static final int FROM_VEHICLE = 3;
	
	private JFrame frame;
	private JDialog dialog;
	private JTextField jtfCity;

	private int from;
	private String city;
	
	public CityDialog(JFrame f) {
		// TODO Auto-generated constructor stub
		this.frame = f;
		this.dialog = this;
		
		setSize(500, 350);
		setResizable(false);
		setUndecorated(true);
		setModal(true);
		
		JPanel jPanel = new JPanel(null);
		jPanel.setBackground(new Color(250, 250, 250));
		jPanel.setBorder(BorderFactory.createLineBorder(new Color(102, 167, 232), 2, true));
		
		JLabel jlTitle = new JLabel("Select city", JLabel.CENTER);
		jlTitle.setFont(new Font("Consola", 0, 20));
		jlTitle.setBounds(1, 1, 498, 40);
		JLabel jlTitleLine = new JLabel();
		jlTitleLine.setOpaque(true);
		jlTitleLine.setBackground(new Color(102, 167, 232));
		jlTitleLine.setBounds(0, 40, 500, 1);
		
		JPanel jpCities = new JPanel(null);
		jpCities.setBackground(new Color(250, 250, 250));
		jpCities.setPreferredSize(new Dimension(400, 700));
		int i = 0;
		for(String s: MainView.cities) {
			JLabel jlCity = new JLabel(s, JLabel.CENTER);
			jlCity.setFont(new Font("", 0, 16));
			MyLabel myJlCity = new MyLabel(frame, this, jlCity);
			myJlCity.setBounds(25 + i % 5 * 90, 30 + i / 5 * 40, 70, 20);
			jpCities.add(myJlCity);
			i++;
		}
		JScrollPane jspCities = new JScrollPane(jpCities);
		jspCities.setBounds(2, 42, 496, 305);
		jspCities.setBorder(null);
		jspCities.doLayout();
		jspCities.getVerticalScrollBar().setUnitIncrement(10);
		
		jPanel.add(jlTitle);
		jPanel.add(jlTitleLine);
		jPanel.add(jspCities);
		
		this.add(jPanel);
		
	}

	public int getFrom() {
		return from;
	}

	public void setFrom(int from) {
		this.from = from;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	public void setJtfCity(JTextField jtfCity) {
		this.jtfCity = jtfCity;
	}

	public JTextField getJtfCity() {
		return jtfCity;
	}

}

class MyLabel extends JPanel{
	
	private JFrame frame;
	private JLabel label;
	private CityDialog dialog;
	
	public MyLabel(JFrame f, CityDialog d, JLabel l) {
		// TODO Auto-generated constructor stub
		this.frame = f;
		this.dialog = d;
		this.label = l;
		
		label.setBounds(0, 0, 70, 19);
		JLabel line = new JLabel();
		line.setOpaque(true);
		line.setBackground(new Color(38, 180, 211));
		line.setBounds(0, 19, 70, 1);
		line.setVisible(false);
		
		this.setLayout(null);
		this.setSize(50, 20);
		this.setBackground(new Color(250, 250, 250));
		this.add(label);
		this.add(line);
		this.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				label.setForeground(Color.DARK_GRAY);
				dialog.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				line.setVisible(false);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				label.setForeground(new Color(38, 180, 211));
				dialog.setCursor(new Cursor(Cursor.HAND_CURSOR));
				line.setVisible(true);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				dialog.getJtfCity().setText(label.getText());
				dialog.setVisible(false);
			}
		});
	}
	
}



