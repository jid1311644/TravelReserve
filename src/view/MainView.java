package view;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import view.dialogs.CityDialog;
import view.menu.MainButton;
import view.menu.Menu;
import view.pages.flightPage.FlightPage;
import view.pages.reservationPage.ReservationPage;

public class MainView extends JFrame {
	
	public static String currentUser;
	public static JPanel page;
	public static CityDialog selectCities;
	public static LinkedList<String> cities;
	
	public MainView() {
		// TODO Auto-generated constructor stub
		super();
		
		initData();
		
		setTitle("旅游订票系统");
		setSize(1300, 800);
		int w = Toolkit.getDefaultToolkit().getScreenSize().width;
		int h = Toolkit.getDefaultToolkit().getScreenSize().height;
		int x = (w - 1300) / 2;
		int y = (h - 800) / 2;
		setLocation(x, y);
		setResizable(false);
		
		Menu menu = new Menu(MainButton.FLIGHT, this);
		menu.setBounds(0, 0, 241, 800);
		
//		new SocketServer();
//		RunningPage.labelServices = new ArrayList<>();
		page = new JPanel(null);
		page.setBounds(241, 0, 1060, 800);
		page.setBackground(Color.WHITE);
		page.add(new ReservationPage(this));
		
		selectCities = new CityDialog(this);
		
		JPanel main = new JPanel(null);
		main.setBackground(Color.WHITE);
		main.add(menu);
		main.add(page);
		this.getContentPane().add(main);
		
	}
	
	private boolean initData() {
		cities = new LinkedList<>();
		cities.add("鄂尔多斯");
		cities.add("南京");
		cities.add("西安");
		cities.add("哈尔滨");
		cities.add("鄂尔多斯");
		cities.add("西安");
		cities.add("北京");
		cities.add("南京");
		cities.add("西安");
		cities.add("北京");
		cities.add("南京");
		cities.add("西安");
		cities.add("北京");
		cities.add("南京");
		cities.add("西安");
		cities.add("北京");
		cities.add("南京");
		cities.add("西安");
		cities.add("北京");
		cities.add("南京");
		cities.add("西安");
		cities.add("北京");
		cities.add("南京");
		cities.add("西安");
		cities.add("北京");
		cities.add("南京");
		cities.add("西安");
		cities.add("北京");
		cities.add("南京");
		cities.add("西安");
		cities.add("北京");
		cities.add("南京");
		cities.add("西安");
		cities.add("北京");
		cities.add("南京");
		cities.add("西安");
		cities.add("北京");
		cities.add("南京");
		cities.add("西安");
		cities.add("北京");
		cities.add("南京");
		cities.add("西安");
		cities.add("北京");
		cities.add("南京");
		cities.add("西安");
		cities.add("北京");
		cities.add("南京");
		cities.add("西安");
		cities.add("北京");
		cities.add("南京");
		cities.add("西安");
		cities.add("北京");
		cities.add("南京");
		cities.add("西安");
		cities.add("北京");
		cities.add("南京");
		cities.add("西安");
		cities.add("北京");
		cities.add("南京");
		cities.add("西安");
		cities.add("北京");
		cities.add("南京");
		cities.add("西安");
		cities.add("北京");
		cities.add("南京");
		cities.add("西安");
		cities.add("北京");
		cities.add("南京");
		cities.add("西安");
		cities.add("北京");
		cities.add("南京");
		cities.add("西安");
		cities.add("北京");
		cities.add("南京");
		cities.add("西安");
		cities.add("北京");
		cities.add("南京");
		cities.add("西安");
		cities.add("北京");
		cities.add("南京");
		cities.add("西安");
		cities.add("北京");
		cities.add("南京");
		cities.add("西安");
		cities.add("北京");
		cities.add("南京");
		cities.add("西安");
		cities.add("北京");
		cities.add("南京");
		cities.add("西安");
		cities.add("北京");
		cities.add("南京");
		cities.add("西安");
		cities.add("北京");
		cities.add("南京");
		cities.add("西安");
		cities.add("北京");
		cities.add("南京");
		cities.add("西安");
		cities.add("北京");
		cities.add("南京");
		cities.add("西安");
		cities.add("北京");
		cities.add("南京");
		cities.add("西安");
		cities.add("北京");
		cities.add("南京");
		cities.add("西安");
		cities.add("北京");
		cities.add("南京");
		cities.add("西安");
		cities.add("北京");
		cities.add("南京");
		cities.add("西安");
		cities.add("北京");
		cities.add("南京");
		cities.add("西安");
		cities.add("北京");
		cities.add("南京");
		cities.add("西安");
		cities.add("北京");
		cities.add("南京");
		cities.add("西安");
		cities.add("北京");
		cities.add("南京");
		cities.add("西安");
		cities.add("北京");
		cities.add("南京");
		cities.add("西安");
		cities.add("北京");
		cities.add("南京");
		cities.add("西安");
		cities.add("北京");
		cities.add("南京");
		cities.add("西安");
		cities.add("北京");
		cities.add("南京");
		cities.add("西安");
		cities.add("北京");
		cities.add("南京");
		cities.add("西安");
		cities.add("北京");
		cities.add("南京");
		cities.add("西安");
		cities.add("北京");
		cities.add("南京");
		cities.add("西安");
		cities.add("北京");
		cities.add("南京");
		cities.add("西安");
		cities.add("北京");
		cities.add("南京");
		cities.add("西安");
		cities.add("北京");
		cities.add("南京");
		cities.add("西安");
		cities.add("北京");
		cities.add("南京");
		cities.add("西安");
		cities.add("北京");
		cities.add("南京");
		cities.add("西安");
		cities.add("北京");
		cities.add("南京");
		cities.add("西安");
		cities.add("北京");
		cities.add("南京");
		cities.add("西安");
		cities.add("北京");
		cities.add("南京");
		cities.add("西安");
		cities.add("北京");
		cities.add("南京");
		cities.add("西安");
		cities.add("北京");
		cities.add("南京");
		cities.add("西安");
		cities.add("北京");
		cities.add("南京");
		cities.add("西安");
		cities.add("北京");
		cities.add("南京");
		cities.add("西安");
		cities.add("北京");
		cities.add("南京");
		cities.add("西安");
		cities.add("北京");
		cities.add("南京");
		cities.add("西安");
		cities.add("北京");
		cities.add("南京");
		cities.add("西安");
		cities.add("北京");
		cities.add("南京");
		cities.add("西安");
		cities.add("北京");
		cities.add("南京");
		cities.add("西安");
		cities.add("北京");
		cities.add("南京");
		cities.add("西安");
		return true;
	}
	
	protected void processWindowEvent(final WindowEvent e) {
		if (e.getID() == WindowEvent.WINDOW_CLOSING) {
			/*if(SocketServer.running.size() > 0) {
				int n = JOptionPane.showConfirmDialog(this, "Something is running. Logout now?"
						, "", JOptionPane.YES_NO_OPTION);
				if(n == 0) {
					System.exit(0);
				}
			}
			else*/ {
				int n = JOptionPane.showConfirmDialog(this, "Exit now?"
						, "", JOptionPane.YES_NO_OPTION);
				if(n == 0) {
					System.exit(0);
				}
			}
		}
		else {
			super.processWindowEvent(e);
		}
	}
	
	public static void main(String[] args) {
		new MainView().setVisible(true);
	}

}
