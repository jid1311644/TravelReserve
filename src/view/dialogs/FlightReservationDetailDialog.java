package view.dialogs;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controller.Controller;
import controller.message.RequestMsg;
import controller.message.ResponseMsg;
import model.beans.ContactBean;
import model.beans.reservationBeans.FlightReseverationBean;

public class FlightReservationDetailDialog extends JDialog {
	
	private JPanel jpPassenger;
	
	public FlightReservationDetailDialog(String reserID) {
		// TODO Auto-generated constructor stub
		setSize(500, 600);
		setResizable(false);
		setModal(true);
		setTitle("³Ë»úÈË");		
		int w = Toolkit.getDefaultToolkit().getScreenSize().width;
		int h = Toolkit.getDefaultToolkit().getScreenSize().height;
		int x = (w - 500) / 2;
		int y = (h - 600) / 2;
		setLocation(x, y);
		
		Map<String, String> args = new HashMap<>();
		args.put("reservationID", reserID);
		RequestMsg request = new RequestMsg(RequestMsg.SELECT_FLIGHT_RESERVATION);
		request.setArgs(args);
		request.sendRequest();
		ResponseMsg response = Controller.handle();
		@SuppressWarnings("unchecked")
		LinkedList<FlightReseverationBean> frbs = (LinkedList<FlightReseverationBean>)
				response.getData();
		
		jpPassenger = new JPanel(null);
		jpPassenger.setBackground(new Color(255, 255, 255));
		int count = 0;
		args.put("idNumber", "");
		while(frbs != null && !frbs.isEmpty()) {
			FlightReseverationBean frb = frbs.pollFirst();
			args.replace("idNumber", frb.getPassengerID());
			request = new RequestMsg(RequestMsg.SELECT_PASSENGER);
			request.setArgs(args);
			request.sendRequest();
			ContactBean contactBean = (ContactBean) Controller.handle().getData();
			
			ContactLabel contactLabel = new ContactLabel(contactBean.getName(), 
					contactBean.getIdNumber(), contactBean.getTeleNumber());
			contactLabel.setBounds(30, 10 + count * 170, 400, 150);
			
			JLabel line2 = new JLabel();
			line2.setOpaque(true);
			line2.setBackground(new Color(128, 128, 128));
			line2.setBounds(30, (count + 1) * 170, 400, 1);

			jpPassenger.add(contactLabel);
			jpPassenger.add(line2);
			count++;
		}
		jpPassenger.setPreferredSize(new Dimension(400, count * 170));
		JScrollPane jspPassenger = new JScrollPane(jpPassenger);
		jspPassenger.setBounds(10, 5, 480, 560);
		jspPassenger.setBorder(null);
		jspPassenger.doLayout();
		jspPassenger.getVerticalScrollBar().setUnitIncrement(10);
		
		JPanel jPanel = new JPanel(null);
		jPanel.setBackground(Color.WHITE);
		jPanel.add(jspPassenger);
		this.add(jPanel);
		
	}
	
	

	class ContactLabel extends JPanel {

		private ImageIcon people = new ImageIcon("./icons/contact_people.png");
		private ImageIcon id_icon = new ImageIcon("./icons/contact_id.png");
		private ImageIcon phone = new ImageIcon("./icons/contact_phone.png");
		
		private JLabel jlName;
		private JLabel jlID;
		private JLabel jlTele;
		
		
		public ContactLabel(String name, String id, String tele) {
			// TODO Auto-generated constructor stub
			this.setBackground(Color.WHITE);
			this.setSize(400, 150);
			this.setLayout(null);

			JLabel iconName = new JLabel(people, JLabel.CENTER);
			iconName.setBounds(20, 20, 30, 30);
			jlName = new JLabel(name);
			jlName.setFont(new Font("", 0, 20));
			jlName.setBounds(70, 20, 200, 30);
			
			JLabel iconID = new JLabel(id_icon, JLabel.CENTER);
			iconID.setBounds(20, 60, 30, 30);
			jlID = new JLabel(id);
			jlID.setFont(new Font("Consola", 0, 16));
			jlID.setBounds(70, 60, 200, 30);
			
			JLabel iconTele = new JLabel(phone, JLabel.CENTER);
			iconTele.setBounds(20, 100, 30, 30);
			jlTele = new JLabel(tele);
			jlTele.setFont(new Font("Consola", 0, 16));
			jlTele.setBounds(70, 100, 200, 30);
			
			this.add(iconName);
			this.add(iconID);
			this.add(iconTele);
			this.add(jlName);
			this.add(jlID);
			this.add(jlTele);
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
					setBorder(null);
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					setBorder(BorderFactory.createLineBorder(new Color(102, 167, 232), 1, true));
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
		}
	}

}













