package view.dialogs;

import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ReserveFlightDialog extends JDialog {
	
	private JDialog dialog;
	
	private JButton jbSelect;
	
	public ReserveFlightDialog() {
		// TODO Auto-generated constructor stub
		this.dialog = this;
		
		setSize(500, 600);
		setResizable(false);
		setModal(true);
		setTitle("乘机人");		
		int w = Toolkit.getDefaultToolkit().getScreenSize().width;
		int h = Toolkit.getDefaultToolkit().getScreenSize().height;
		int x = (w - 500) / 2;
		int y = (h - 600) / 2;
		setLocation(x, y);
		
		int size = 5;
		JPanel jpContacts = new JPanel(null);
		jpContacts.setBackground(Color.WHITE);
		jpContacts.setPreferredSize(new Dimension(450, size * 220 + 20));
		ContactLabel contactLabel0 = new ContactLabel();
		contactLabel0.setBounds(30, 20, 400, 200);
		ContactLabel contactLabel1 = new ContactLabel();
		contactLabel1.setBounds(30, 240, 400, 200);
		ContactLabel contactLabel2 = new ContactLabel();
		contactLabel2.setBounds(30, 460, 400, 200);
		ContactLabel contactLabel3 = new ContactLabel();
		contactLabel3.setBounds(30, 680, 400, 200);
		ContactLabel contactLabel4 = new ContactLabel();
		contactLabel4.setBounds(30, 900, 400, 200);
		jpContacts.add(contactLabel0);
		jpContacts.add(contactLabel1);
		jpContacts.add(contactLabel2);
		jpContacts.add(contactLabel3);
		jpContacts.add(contactLabel4);
		
		JScrollPane jspContacts = new JScrollPane(jpContacts);
		jspContacts.setBounds(10, 10, 480, 490);
		jspContacts.setBorder(null);
		
		JLabel line = new JLabel();
		line.setOpaque(true);
		line.setBackground(Color.GRAY);
		line.setBounds(0, 500, 500, 1);
		
		jbSelect = new JButton("提交订单");
		jbSelect.setBackground(new Color(48, 151, 187));
		jbSelect.setFont(new Font("", 1, 20));
		jbSelect.setForeground(Color.WHITE);
		jbSelect.setFocusPainted(false);
		jbSelect.setBounds(150, 510, 180, 40);
		jbSelect.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		JPanel jPanel = new JPanel(null);
		jPanel.setBackground(Color.WHITE);
		jPanel.add(jspContacts);
		jPanel.add(line);
		jPanel.add(jbSelect);
		
		this.add(jPanel);
	}

}



class ContactLabel extends JPanel {

	private ImageIcon people = new ImageIcon("./icons/contact_people.png");
	private ImageIcon id = new ImageIcon("./icons/contact_id.png");
	private ImageIcon phone = new ImageIcon("./icons/contact_phone.png");
	private ImageIcon checked = new ImageIcon("./icons/contact_check.png");
	private ImageIcon unchecked = new ImageIcon("./icons/contact_uncheck.png");
	
	private JLabel jlSelect;
	private JLabel jlName;
	private JLabel jlID;
	private JLabel jlTele;
	
	private boolean isChecked = false;
	
	public ContactLabel() {
		// TODO Auto-generated constructor stub
		this.setBackground(Color.WHITE);
		this.setSize(400, 200);
		this.setLayout(null);
		
		jlSelect = new JLabel(unchecked, JLabel.CENTER);
		jlSelect.setBounds(340, 10, 50, 50);

		JLabel iconName = new JLabel(people, JLabel.CENTER);
		iconName.setBounds(20, 60, 30, 30);
		jlName = new JLabel("张丽丽");
		jlName.setFont(new Font("", 0, 20));
		jlName.setBounds(70, 60, 200, 30);
		
		JLabel iconID = new JLabel(id, JLabel.CENTER);
		iconID.setBounds(20, 100, 30, 30);
		jlID = new JLabel("622827199609100322");
		jlID.setFont(new Font("Consola", 0, 16));
		jlID.setBounds(70, 100, 200, 30);
		
		JLabel iconTele = new JLabel(phone, JLabel.CENTER);
		iconTele.setBounds(20, 140, 30, 30);
		jlTele = new JLabel("18240457941");
		jlTele.setFont(new Font("Consola", 0, 16));
		jlTele.setBounds(70, 140, 200, 30);
		
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
	
}

