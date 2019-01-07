package view.dialogs;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controller.Controller;
import controller.message.RequestMsg;
import controller.message.ResponseMsg;
import model.beans.ContactBean;
import model.beans.FlightBean;
import view.MainView;

public class ReserveFlightDialog extends JDialog {
	
	private ImageIcon add = new ImageIcon("./icons/add_b.png");
	
	private JDialog dialog;
	private JButton jbAddContact;
	private JButton jbSelect;
	private JPanel jpContacts;
	private JLabel jlFreeSeats;
	
	public ReserveFlightDialog(String flightNumber) {
		// TODO Auto-generated constructor stub
		this.dialog = this;
		
		setSize(500, 600);
		setResizable(false);
		setModal(true);
		setTitle("选择乘机人");		
		int w = Toolkit.getDefaultToolkit().getScreenSize().width;
		int h = Toolkit.getDefaultToolkit().getScreenSize().height;
		int x = (w - 500) / 2;
		int y = (h - 600) / 2;
		setLocation(x, y);
		
		jbAddContact = new JButton(add);
		jbAddContact.setBackground(Color.WHITE);
		jbAddContact.setBounds(400, 20, 36, 36);
		jbAddContact.setFocusPainted(false);
		jbAddContact.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new AddContactDialog(MainView.currentUser, jpContacts).setVisible(true);
			}
		});
		
		JLabel line1 = new JLabel();
		line1.setOpaque(true);
		line1.setBackground(new Color(48, 151, 187));
		line1.setBounds(0, 65, 500, 1);

		Map<String, String> args = new HashMap<>();
		args.put("username", MainView.currentUser);
		RequestMsg request = new RequestMsg(RequestMsg.SEARCH_CONTACT);
		request.setArgs(args);
		request.sendRequest();
		ResponseMsg response = Controller.handle();
		@SuppressWarnings("unchecked")
		LinkedList<ContactBean> contactBeans = (LinkedList<ContactBean>) response.getData();
		
		jpContacts = new JPanel(null);
		jpContacts.setBackground(new Color(255, 255, 255));
		int count = 0;
		LinkedList<ContactLabel> cls = new LinkedList<>();
		while(contactBeans != null && !contactBeans.isEmpty()) {
			ContactBean contactBean = contactBeans.pollFirst();
			ContactLabel contactLabel = new ContactLabel(contactBean.getName(), 
					contactBean.getIdNumber(), contactBean.getTeleNumber());
			contactLabel.setBounds(30, 10 + count * 170, 400, 150);
			cls.add(contactLabel);
			
			JLabel line2 = new JLabel();
			line2.setOpaque(true);
			line2.setBackground(new Color(128, 128, 128));
			line2.setBounds(30, (count + 1) * 170, 400, 1);

			jpContacts.add(contactLabel);
			jpContacts.add(line2);
			count++;
		}
		jpContacts.setPreferredSize(new Dimension(400, count * 170));
		JScrollPane jspContacts = new JScrollPane(jpContacts);
		jspContacts.setBounds(10, 67, 470, 420);
		jspContacts.setBorder(null);
		jspContacts.doLayout();
		jspContacts.getVerticalScrollBar().setUnitIncrement(10);
		
		JLabel line = new JLabel();
		line.setOpaque(true);
		line.setBackground(Color.GRAY);
		line.setBounds(0, 500, 500, 1);
		
		jbSelect = new JButton("提交订单");
		jbSelect.setBackground(new Color(48, 151, 187));
		jbSelect.setFont(new Font("", 1, 20));
		jbSelect.setForeground(Color.WHITE);
		jbSelect.setFocusPainted(false);
		jbSelect.setBounds(100, 510, 180, 40);
		jbSelect.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(cls.size() != 0) {
					int n = JOptionPane.showConfirmDialog(dialog, "Commit this reservation?"
							, "", JOptionPane.YES_NO_OPTION);
					if(n == 0) {
						Map<String, String> args = new HashMap<>();
						args.put("username", MainView.currentUser);
						args.put("flightNumber", flightNumber);
						int count = 0;
						while(!cls.isEmpty()) {
							if(cls.peek().isChecked()) {
								args.put((count++) + "idNumber", cls.poll().getIdNumber());
							}
							else {
								cls.poll();
							}
						}
						RequestMsg request = new RequestMsg(RequestMsg.RESERVE_FLIGHT);
						request.setArgs(args);
						request.sendRequest();
						ResponseMsg response = Controller.handle();
						if(response.getResult().equals("success")) {
							JOptionPane.showMessageDialog(dialog, response.getMsg(),
									"", JOptionPane.INFORMATION_MESSAGE);
						}
						else {
							JOptionPane.showMessageDialog(dialog, response.getMsg(),
									"", JOptionPane.ERROR_MESSAGE);
						}
						dialog.setVisible(false);
					}
				}
			}
		});
		
		args.put("flightNumber", flightNumber);
		request = new RequestMsg(RequestMsg.SELECT_FLIGHT);
		request.setArgs(args);
		request.sendRequest();
		response = Controller.handle();
		FlightBean fb = (FlightBean) response.getData();
		jlFreeSeats = new JLabel("还剩 " + fb.getFreeSeats() + " 个座位");
		jlFreeSeats.setFont(new Font("", 0, 14));
		jlFreeSeats.setForeground(new Color(255, 130, 5));
		jlFreeSeats.setBounds(310, 530, 200, 14);
		
		JPanel jPanel = new JPanel(null);
		jPanel.setBackground(Color.WHITE);
		jPanel.add(jbAddContact);
		jPanel.add(line1);
		jPanel.add(jspContacts);
		jPanel.add(line);
		jPanel.add(jbSelect);
		jPanel.add(jlFreeSeats);
		
		this.add(jPanel);
	}

}



class ContactLabel extends JPanel {

	private ImageIcon people = new ImageIcon("./icons/contact_people.png");
	private ImageIcon id_icon = new ImageIcon("./icons/contact_id.png");
	private ImageIcon phone = new ImageIcon("./icons/contact_phone.png");
	private ImageIcon checked = new ImageIcon("./icons/contact_check.png");
	private ImageIcon unchecked = new ImageIcon("./icons/contact_uncheck.png");
	
	private JLabel jlSelect;
	private JLabel jlName;
	private JLabel jlID;
	private JLabel jlTele;
	
	private boolean isChecked = false;
	
	public ContactLabel(String name, String id, String tele) {
		// TODO Auto-generated constructor stub
		this.setBackground(Color.WHITE);
		this.setSize(400, 150);
		this.setLayout(null);
		
		jlSelect = new JLabel(unchecked, JLabel.CENTER);
		jlSelect.setBounds(340, 50, 50, 50);

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
		
		this.add(jlSelect);
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
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				setBorder(BorderFactory.createLineBorder(new Color(102, 167, 232), 1, true));
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(isChecked) {
					jlSelect.setIcon(unchecked);
					isChecked = false;
				}
				else {
					jlSelect.setIcon(checked);
					isChecked = true;
				}
			}
		});
		
	}
	
	public String getIdNumber() {
		return jlID.getText();
	}
	
	public String getTeleNumber() {
		return jlTele.getText();
	}
	
	public String getName() {
		return jlName.getText();
	}

	public boolean isChecked() {
		return isChecked;
	}

	public void setChecked(boolean isChecked) {
		this.isChecked = isChecked;
	}
	
}

