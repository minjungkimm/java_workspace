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

	//현재 날짜객체
	Calendar cal=Calendar.getInstance();
	
	//Date 객체사용
	int yy=cal.get(Calendar.YEAR);
	int mm=cal.get(Calendar.MONTH);
	int dd=cal.get(Calendar.DATE);
	
	public ResvPanel(HotelMain main,Connection con) {
		this.main=main;
		this.con=con;
		
		this.setLayout(new BorderLayout());
		p_north = new JPanel();
		p_center = new JPanel();
		bt_prev = new JButton("이전");
		la_date = new JLabel(yy+"-"+(mm+1)); 
		bt_next = new JButton("다음");
		table = new JTable();
		scroll = new JScrollPane(table);
		//상단 패널
		p_north.add(bt_prev);
		p_north.add(la_date);
		p_north.add(bt_next);
		
		//테이블 바로 위 날짜 - date 객체이용 패널
		p_center.add(scroll);
		
		add(p_north,BorderLayout.NORTH);
		add(p_center,BorderLayout.CENTER);
		
		//System.out.println(yy+"-"+(mm+1)+"-"+dd);
		
		//버튼을 누르면 연도/월 이 바뀌게 이벤트추가
		bt_prev.addActionListener(this);
		bt_next.addActionListener(this);
		
		table.setModel(model = new ResvModel(main,con));
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.out.println("예약관리 기본테이블 클릭시 이벤트발생");
				newOpen = new NewOpen(main,con);
			}
		});
		
		setBackground(Color.CYAN);
		
		setPreferredSize(new Dimension(1100, 900));
		setVisible(false);
		
	}//
	
	
	//이전 과 다음 버튼을 눌러 이전달, 다음달로 이동
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
