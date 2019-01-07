package view.dialogs;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.Controller;
import controller.message.RequestMsg;
import controller.message.ResponseMsg;
import model.beans.ContactBean;

public class AddContactDialog extends JDialog implements KeyListener {
	
	private ImageIcon people = new ImageIcon("./icons/contact_people.png");
	private ImageIcon id = new ImageIcon("./icons/contact_id.png");
	private ImageIcon phone = new ImageIcon("./icons/contact_phone.png");
	
	private JTextField jtfName;
	private JTextField jtfID;
	private JTextField jtfTele;
	private JButton jbCommit;
	
	private JFrame frame;
	private JDialog dialog;
	
	private String username;
	private JPanel jpContacts;
	
	public AddContactDialog(String uname, JPanel jpCs) {
		// TODO Auto-generated constructor stub
		this.username = uname;
		this.jpContacts = jpCs;
		this.dialog = this;
		
		setResizable(false);
		setModal(true);
		setTitle("Ìí¼Ó³Ë»úÈË");
		int w = Toolkit.getDefaultToolkit().getScreenSize().width;
		int h = Toolkit.getDefaultToolkit().getScreenSize().height;
		int x = (w - 400) / 2;
		int y = (h - 340) / 2;
		setLocation(x, y);
		this.setSize(400, 340);

		JLabel iconName = new JLabel(people, JLabel.CENTER);
		iconName.setBounds(50, 20, 30, 30);
		jtfName = new JTextField("");
		jtfName.setFont(new Font("", 0, 18));
		jtfName.setBounds(90, 20, 260, 30);
		jtfName.setBorder(null);
		jtfName.addKeyListener(this);
		JLabel line1 = new JLabel();
		line1.setOpaque(true);
		line1.setBackground(new Color(102, 167, 232));
		line1.setBounds(40, 55, 320, 2);
		
		JLabel iconID = new JLabel(id, JLabel.CENTER);
		iconID.setBounds(50, 80, 30, 30);
		jtfID = new JTextField("");
		jtfID.setFont(new Font("Consola", 0, 18));
		jtfID.setBounds(90, 80, 260, 30);
		jtfID.setBorder(null);
		jtfID.addKeyListener(this);
		JLabel line2 = new JLabel();
		line2.setOpaque(true);
		line2.setBackground(new Color(102, 167, 232));
		line2.setBounds(40, 115, 320, 2);
		
		JLabel iconTele = new JLabel(phone, JLabel.CENTER);
		iconTele.setBounds(50, 140, 30, 30);
		jtfTele = new JTextField("");
		jtfTele.setFont(new Font("Consola", 0, 18));
		jtfTele.setBounds(90, 140, 260, 30);
		jtfTele.setBorder(null);
		jtfTele.addKeyListener(this);
		JLabel line3 = new JLabel();
		line3.setOpaque(true);
		line3.setBackground(new Color(102, 167, 232));
		line3.setBounds(40, 175, 320, 2);
		
		JLabel line4 = new JLabel();
		line4.setOpaque(true);
		line4.setBackground(new Color(85, 85, 85));
		line4.setBounds(0, 230, 400, 1);
		
		jbCommit = new JButton("È·    ¶¨");
		jbCommit.setBackground(new Color(48, 151, 187));
		jbCommit.setFont(new Font("", 1, 20));
		jbCommit.setForeground(Color.WHITE);
		jbCommit.setFocusPainted(false);
		jbCommit.setBounds(125, 250, 150, 40);
		jbCommit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String name = jtfName.getText();
				String id = jtfID.getText();
				String tele = jtfTele.getText();
				if(name.equals("") || id.equals("") || tele.equals("")) {
					
				}
				else {
					if(tele.length() == 11 && tele.indexOf("x") == -1 
							&& id.length() == 18 && (id.indexOf("x") == -1 || id.indexOf("x") == 17)) {
						
						Map<String, String> reqArgs = new HashMap<String, String>();
						reqArgs.put("username", username);
						reqArgs.put("teleNumber", tele);
						reqArgs.put("idNumber", id);
						reqArgs.put("name", name);
						RequestMsg request = new RequestMsg(RequestMsg.ADD_CONTACT);
						request.setArgs(reqArgs);
						request.sendRequest();
						ResponseMsg response = Controller.handle();
						
						if(response.getResult().equals("success")) {
							request = new RequestMsg(RequestMsg.SEARCH_CONTACT);
							request.setArgs(reqArgs);
							request.sendRequest();
							response = Controller.handle();
							@SuppressWarnings("unchecked")
							LinkedList<ContactBean> contactBeans = (LinkedList<ContactBean>) response.getData();
							
							jpContacts.removeAll();
							jpContacts.repaint();
							int count = 0;
							while(contactBeans != null && !contactBeans.isEmpty()) {
								ContactBean contactBean = contactBeans.pollFirst();
								ContactLabel contactLabel = new ContactLabel(contactBean.getName(), 
										contactBean.getIdNumber(), contactBean.getTeleNumber());
								contactLabel.setBounds(30, 10 + count * 170, 400, 150);
								
								JLabel line2 = new JLabel();
								line2.setOpaque(true);
								line2.setBackground(new Color(128, 128, 128));
								line2.setBounds(30, (count + 1) * 170, 400, 1);

								jpContacts.add(contactLabel);
								jpContacts.add(line2);
								count++;
							}
							jpContacts.setPreferredSize(new Dimension(400, count * 170));

							dialog.setVisible(false);
						}
						else {
							JOptionPane.showMessageDialog(dialog, response.getMsg(),
									"", JOptionPane.ERROR_MESSAGE);
						}
					}
					else {
						JOptionPane.showMessageDialog(dialog, "Format ERROR!",
								"", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		
		JPanel jPanel = new JPanel(null);
		jPanel.setBackground(Color.WHITE);
		jPanel.add(iconName);
		jPanel.add(iconID);
		jPanel.add(iconTele);
		jPanel.add(jtfName);
		jPanel.add(jtfID);
		jPanel.add(jtfTele);
		jPanel.add(line1);
		jPanel.add(line2);
		jPanel.add(line3);
		jPanel.add(line4);
		jPanel.add(jbCommit);
		
		this.add(jPanel);
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyChar = e.getKeyChar();
		if(e.getSource().equals(jtfID) || e.getSource().equals(jtfTele)) {
			if((keyChar >= 48 && keyChar <= 57)	//Êý×Ö0~9
					|| (keyChar == 120)) {	//Ð¡Ð´×ÖÄ¸x
			}
			else {
				e.consume();
			}
		}
		else if(e.getSource().equals(jtfName)){
			if(keyChar == 32 || keyChar == 45	//¿Õ¸ñºÍ¼õºÅ-
					|| (keyChar >= 65 && keyChar >= 90)	//×ÖÄ¸A~Z
					|| (keyChar >= 97 && keyChar >= 122)) {	//×ÖÄ¸a~z

			}
			else {
				byte[] bs = (e.getKeyChar() + "").getBytes();
				for(int i = 0; i < bs.length; i++) {	//ÊäÈëºº×Ö
					if(bs[i] >= (byte)0x81 && bs[i] <= (byte)0xfe) {

					}
					else {
						e.consume();
						break;
					}
				}
			}

		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
