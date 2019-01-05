package view.dialogs;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ReserveHotelDialog extends JDialog implements ActionListener, MouseListener {

	private ImageIcon add_small = new ImageIcon("./icons/add.png");
	private ImageIcon add_big = new ImageIcon("./icons/add_b.png");
	private ImageIcon sub_small = new ImageIcon("./icons/sub.png");
	private ImageIcon sub_big = new ImageIcon("./icons/sub_b.png");
	
	private JDialog dialog;

	private JLabel jlFreeRoom1;
	private JLabel jlFreeRoom2;
	private JLabel jlFreeRoom3;
	private JButton jbChoose1;
	private JButton jbChoose2;
	private JButton jbChoose3;
	private JLabel jlAddIcon;
	private JLabel jlNum;
	private JLabel jlSubIcon;
	private JButton jbSelect;
	
	int roomType = -1;
	int[] freeRoomNums = {14, 27, 4};
	
	public ReserveHotelDialog() {
		// TODO Auto-generated constructor stub
		this.dialog = this;
		
		setSize(430, 260);
		setResizable(false);
		setModal(true);
		setTitle("Ԥ���ù�");		
		int w = Toolkit.getDefaultToolkit().getScreenSize().width;
		int h = Toolkit.getDefaultToolkit().getScreenSize().height;
		int x = (w - 430) / 2;
		int y = (h - 260) / 2;
		setLocation(x, y);
		
		JLabel jlRoom1 = new JLabel("�󴲷�");
		jlRoom1.setFont(new Font("", 1, 18));
		jlRoom1.setBounds(30, 30, 80, 20);
		jbChoose1 = new JButton("ѡ ��");
		jbChoose1.setFont(new Font("", 0, 14));
		jbChoose1.setForeground(Color.WHITE);
		jbChoose1.setBackground(new Color(102, 167, 232));
		jbChoose1.setFocusPainted(false);
		jbChoose1.setBounds(280, 25, 70, 30);
		jbChoose1.addActionListener(this);
		jlFreeRoom1 = new JLabel("��ʣ" + freeRoomNums[0] + "��");
		jlFreeRoom1.setForeground(new Color(48, 151, 187));
		jlFreeRoom1.setFont(new Font("", 0, 14));
		jlFreeRoom1.setBounds(360, 41, 70, 14);
		
		JLabel jlRoom2 = new JLabel("��׼��");
		jlRoom2.setFont(new Font("", 1, 18));
		jlRoom2.setBounds(30, 70, 80, 20);
		jbChoose2 = new JButton("ѡ ��");
		jbChoose2.setFont(new Font("", 0, 14));
		jbChoose2.setForeground(Color.WHITE);
		jbChoose2.setBackground(new Color(102, 167, 232));
		jbChoose2.setFocusPainted(false);
		jbChoose2.setBounds(280, 65, 70, 30);
		jbChoose2.addActionListener(this);
		jlFreeRoom2 = new JLabel("��ʣ" + freeRoomNums[1] + "��");
		jlFreeRoom2.setForeground(new Color(48, 151, 187));
		jlFreeRoom2.setFont(new Font("", 0, 14));
		jlFreeRoom2.setBounds(360, 81, 70, 14);
		
		JLabel jlRoom3 = new JLabel("�߼��׷�");
		jlRoom3.setFont(new Font("", 1, 18));
		jlRoom3.setBounds(30, 110, 80, 20);
		jbChoose3 = new JButton("ѡ ��");
		jbChoose3.setFont(new Font("", 0, 14));
		jbChoose3.setForeground(Color.WHITE);
		jbChoose3.setBackground(new Color(102, 167, 232));
		jbChoose3.setFocusPainted(false);
		jbChoose3.setBounds(280, 105, 70, 30);
		jbChoose3.addActionListener(this);
		jlFreeRoom3 = new JLabel("��ʣ" + freeRoomNums[2] + "��");
		jlFreeRoom3.setForeground(new Color(48, 151, 187));
		jlFreeRoom3.setFont(new Font("", 0, 14));
		jlFreeRoom3.setBounds(360, 121, 70, 14);
		
		JLabel line = new JLabel();
		line.setOpaque(true);
		line.setBackground(Color.DARK_GRAY);
		line.setBounds(0, 150, 450, 1);
		
		jlSubIcon = new JLabel(sub_small, JLabel.CENTER);
		jlSubIcon.setBounds(60, 170, 35, 35);
		jlSubIcon.addMouseListener(this);
		
		jlNum = new JLabel("0", JLabel.CENTER);
		jlNum.setFont(new Font("Consola", 1, 16));
		jlNum.setBounds(100, 170, 35, 35);
		
		jlAddIcon = new JLabel(add_small, JLabel.CENTER);
		jlAddIcon.setBounds(140, 170, 35, 35);
		jlAddIcon.addMouseListener(this);
		
		jbSelect = new JButton("�ύ����");
		jbSelect.setBackground(new Color(48, 151, 187));
		jbSelect.setFont(new Font("", 1, 20));
		jbSelect.setForeground(Color.WHITE);
		jbSelect.setFocusPainted(false);
		jbSelect.setBounds(230, 170, 150, 40);
		jbSelect.addActionListener(this);
		
		JPanel jPanel = new JPanel(null);
		jPanel.setBackground(Color.WHITE);
		jPanel.add(jlRoom1);
		jPanel.add(jlRoom2);
		jPanel.add(jlRoom3);
		jPanel.add(jbChoose1);
		jPanel.add(jbChoose2);
		jPanel.add(jbChoose3);
		jPanel.add(jlFreeRoom1);
		jPanel.add(jlFreeRoom2);
		jPanel.add(jlFreeRoom3);
		jPanel.add(line);
		jPanel.add(jlSubIcon);
		jPanel.add(jlNum);
		jPanel.add(jlAddIcon);
		jPanel.add(jbSelect);
		
		this.add(jPanel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(jbChoose1)) {
			roomType = 0;
			jlNum.setText("0");
		}
		else if(e.getSource().equals(jbChoose2)) {
			roomType = 1;
			jlNum.setText("0");
		}
		else if(e.getSource().equals(jbChoose3)) {
			roomType = 2;
			jlNum.setText("0");
		}
		else if(e.getSource().equals(jbSelect)) {
			int n = Integer.parseInt(jlNum.getText());
			if(n == 0) {
				
			}
			else {
				
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int n = Integer.parseInt(jlNum.getText());
		if(e.getSource().equals(jlAddIcon) && roomType != -1) {
			if(n < freeRoomNums[roomType]) {
				n++;
				jlNum.setText("" + n);
			}
		}
		else if(e.getSource().equals(jlSubIcon) && roomType != -1) {
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

}