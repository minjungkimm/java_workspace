package test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ResvPanel extends JPanel implements ActionListener{
	HotelMain main;
	JPanel p_north,p_center;
	JButton bt_prev,bt_next;
	JLabel la_date;
	JTable table;
	JScrollPane scroll;
	ResvModel model;
	DBManager manager=DBManager.getInstance();
	NewOpen newOpen;
	Connection con;

	//���� ��¥��ü
	Calendar cal=Calendar.getInstance();
	
	//Date ��ü���
	int yy=cal.get(Calendar.YEAR);
	int mm=cal.get(Calendar.MONTH);
	int dd=cal.get(Calendar.DATE);
	
	public ResvPanel(HotelMain main,Connection con) {
		this.main=main;
		this.con=con;
		
		this.setLayout(new BorderLayout());
		p_north = new JPanel();
		p_center = new JPanel();
		bt_prev = new JButton("����");
		la_date = new JLabel(yy+"-"+(mm+1)); 
		bt_next = new JButton("����");
		table = new JTable();
		scroll = new JScrollPane(table);
		//��� �г�
		p_north.add(bt_prev);
		p_north.add(la_date);
		p_north.add(bt_next);
		
		//���̺� �ٷ� �� ��¥ - date ��ü�̿� �г�
		p_center.add(scroll);
		
		add(p_north,BorderLayout.NORTH);
		add(p_center,BorderLayout.CENTER);
		
		//System.out.println(yy+"-"+(mm+1)+"-"+dd);
		
		//��ư�� ������ ����/�� �� �ٲ�� �̺�Ʈ�߰�
		bt_prev.addActionListener(this);
		bt_next.addActionListener(this);
		
		table.setModel(model = new ResvModel(main,con));
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.out.println("������� �⺻���̺� Ŭ���� �̺�Ʈ�߻�");
				newOpen = new NewOpen(main,con);
			}
		});
		
		setBackground(Color.CYAN);
		
		setPreferredSize(new Dimension(1100, 900));
		setVisible(false);
		
	}//
	
	
	//���� �� ���� ��ư�� ���� ������, �����޷� �̵�
	public void actionPerformed(ActionEvent e) {
		la_date.setText(yy+"-"+(mm+1));
		
		Object obj=e.getSource();
		if(obj==bt_prev){
			mm--;
			if(mm<0){
				yy--;
				mm=11;
			}
		}else if(obj==bt_next){
			mm++;
			if(mm>11){
				yy++;
				mm=0;
			}
		}
	}//
	
}
