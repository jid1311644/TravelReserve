package view.dialogs;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.Controller;
import controller.message.RequestMsg;
import controller.message.ResponseMsg;
import model.beans.VehicleBean;
import view.MainView;

public class ReserveVehicleDialog extends JDialog implements MouseListener, ActionListener {
	
	private ImageIcon add_small = new ImageIcon("./icons/add.png");
	private ImageIcon add_big = new ImageIcon("./icons/add_b.png");
	private ImageIcon sub_small = new ImageIcon("./icons/sub.png");
	private ImageIcon sub_big = new ImageIcon("./icons/sub_b.png");
	
	private JDialog dialog;
	
	private JLabel jlCarType;
	private JLabel jlCarPlate;
	private JLabel jlFreeSeat;
	private JLabel jlSubIcon;
	private JLabel jlNum;
	private JLabel jlAddIcon;
	private JButton jbSelect;
	
	private int freeSeats = 10;
	private boolean isBus;
	private String plateNumber;
	
	public ReserveVehicleDialog(String plate, boolean isbus) {
		// TODO Auto-generated constructor stub
		this.isBus = isbus;
		this.dialog = this;
		this.plateNumber = plate;
		
		setSize(400,200);
		setResizable(false);
		setModal(true);
		setTitle("预定接机服务");		
		int w = Toolkit.getDefaultToolkit().getScreenSize().width;
		int h = Toolkit.getDefaultToolkit().getScreenSize().height;
		int x = (w - 400) / 2;
		int y = (h - 200) / 2;
		setLocation(x, y);
		
		Map<String, String> args = new HashMap<>();
		args.put("plateNumber", plate);
		RequestMsg request = new RequestMsg(RequestMsg.SELECT_VEHICLE);
		request.setArgs(args);
		request.sendRequest();
		VehicleBean vb = (VehicleBean) Controller.handle().getData();
		
		jlCarType = new JLabel(vb.getCarType());
		jlCarType.setFont(new Font("", 1, 18));
		jlCarType.setBounds(30, 30, 80, 20);
		jlCarPlate = new JLabel(plate);
		jlCarPlate.setFont(new Font("", 0, 14));
		jlCarPlate.setBounds(30, 50, 80, 14);
		
		jlFreeSeat = new JLabel("还剩" + freeSeats + "个座位", JLabel.CENTER);
		jlFreeSeat.setForeground(new Color(48, 151, 187));
		jlFreeSeat.setFont(new Font("", 0, 14));
		jlFreeSeat.setBounds(270, 40, 100, 14);
		
		JLabel line = new JLabel();
		line.setOpaque(true);
		line.setBackground(Color.DARK_GRAY);
		line.setBounds(0, 80, 450, 1);
		
		jlSubIcon = new JLabel(sub_small, JLabel.CENTER);
		jlSubIcon.setBounds(60, 100, 35, 35);
		jlSubIcon.addMouseListener(this);
		
		jlNum = new JLabel("0", JLabel.CENTER);
		jlNum.setFont(new Font("Consola", 1, 16));
		jlNum.setBounds(100, 100, 35, 35);
		
		jlAddIcon = new JLabel(add_small, JLabel.CENTER);
		jlAddIcon.setBounds(140, 100, 35, 35);
		jlAddIcon.addMouseListener(this);
		
		if(!isBus) {
			jlFreeSeat.setVisible(false);
			jlSubIcon.setVisible(false);
			jlNum.setVisible(false);
			jlAddIcon.setVisible(false);
		}
		else {
			request = new RequestMsg(RequestMsg.SELECT_BUS_FREE_SEAT);
			request.setArgs(args);
			request.sendRequest();
			freeSeats = (int) Controller.handle().getData();
			jlFreeSeat.setText("还剩" + freeSeats + "个座位");
		}
		
		jbSelect = new JButton("提交订单");
		jbSelect.setBackground(new Color(48, 151, 187));
		jbSelect.setFont(new Font("", 1, 20));
		jbSelect.setForeground(Color.WHITE);
		jbSelect.setFocusPainted(false);
		jbSelect.setBounds(230, 100, 150, 40);
		jbSelect.addActionListener(this);
		
		JPanel jPanel = new JPanel(null);
		jPanel.setBackground(Color.WHITE);
		jPanel.add(jlCarType);
		jPanel.add(jlCarPlate);
		jPanel.add(jlFreeSeat);
		jPanel.add(line);
		jPanel.add(jlSubIcon);
		jPanel.add(jlNum);
		jPanel.add(jlAddIcon);
		jPanel.add(jbSelect);
		
		this.add(jPanel);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int n = Integer.parseInt(jlNum.getText());
		if(e.getSource().equals(jlAddIcon)) {
			if(n < freeSeats) {
				n++;
				jlNum.setText("" + n);
			}
		}
		else if(e.getSource().equals(jlSubIcon)) {
			if(n > 0) {
				n--;
				jlNum.setText("" + n);
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(jlAddIcon)) {
			jlAddIcon.setIcon(add_small);
		}
		else if(e.getSource().equals(jlSubIcon)) {
			jlSubIcon.setIcon(sub_small);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(jlAddIcon)) {
			jlAddIcon.setIcon(add_big);
		}
		else if(e.getSource().equals(jlSubIcon)) {
			jlSubIcon.setIcon(sub_big);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(jlAddIcon)) {
			jlAddIcon.setIcon(add_big);
		}
		else if(e.getSource().equals(jlSubIcon)) {
			jlSubIcon.setIcon(sub_big);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(jlAddIcon)) {
			jlAddIcon.setIcon(add_small);
		}
		else if(e.getSource().equals(jlSubIcon)) {
			jlSubIcon.setIcon(sub_small);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Map<String, String> args = new HashMap<>();
		args.put("username", MainView.currentUser);
		args.put("isBus", isBus + "");
		args.put("plateNumber", plateNumber);
		if(isBus) {
			int n = Integer.parseInt(jlNum.getText());
			if(n == 0) {
				
			}
			else {
				args.put("ticket", n + "");
			}
		}
		else {
			args.put("ticket", "-1");
		}
		RequestMsg request = new RequestMsg(RequestMsg.RESERVE_VEHICLE);
		request.setArgs(args);
		request.sendRequest();
		ResponseMsg response = Controller.handle().sendResponse();
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
