package view;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.Controller;
import controller.message.RequestMsg;
import controller.message.ResponseMsg;
import view.dialogs.CityDialog;
import view.menu.MainButton;
import view.menu.Menu;
import view.pages.flightPage.FlightPage;

public class MainView extends JFrame {
	
	public static String currentUser = "user1";
	public static JPanel page;
	public static CityDialog selectCities;
	public static LinkedList<String> cities;
	
	public MainView() {
		// TODO Auto-generated constructor stub
		super();
		
		setTitle("¬√”Œ∂©∆±œµÕ≥");
		setSize(1300, 800);
		int w = Toolkit.getDefaultToolkit().getScreenSize().width;
		int h = Toolkit.getDefaultToolkit().getScreenSize().height;
		int x = (w - 1300) / 2;
		int y = (h - 800) / 2;
		setLocation(x, y);
		setResizable(false);
		
		Menu menu = new Menu(MainButton.FLIGHT, this);
		menu.setBounds(0, 0, 241, 800);
		
		page = new JPanel(null);
		page.setBounds(241, 0, 1060, 800);
		page.setBackground(Color.WHITE);
		page.add(new FlightPage(this));
		
		initCityData();
		selectCities = new CityDialog(this);
		
		JPanel main = new JPanel(null);
		main.setBackground(Color.WHITE);
		main.add(menu);
		main.add(page);
		this.getContentPane().add(main);
		
	}
	
	@SuppressWarnings("unchecked")
	private boolean initCityData() {
		
		RequestMsg request = new RequestMsg(RequestMsg.GET_CITIES_NAME);
		request.sendRequest();
		ResponseMsg response = Controller.handle();
		cities = (LinkedList<String>) response.getData();
		return true;
	}
	
	protected void processWindowEvent(final WindowEvent e) {
		if (e.getID() == WindowEvent.WINDOW_CLOSING) {
			
			int n = JOptionPane.showConfirmDialog(this, "Exit now?"
					, "", JOptionPane.YES_NO_OPTION);
			if(n == 0) {
				System.exit(0);
			}
		}
		else {
			super.processWindowEvent(e);
		}
	}
	
//	public static void main(String[] args) {
//		new MainView().setVisible(true);
//	}

}
