package test;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.sql.Connection;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

public class NewOpen extends JFrame{
	JPanel p_date;
	JLabel la_date;
	JPanel p_in,p_out;
	JLabel la_in,la_out;
	JTable table_in,table_out;
	
	Calendar cal=Calendar.getInstance();
	HotelMain main;
	Connection con;
	
	//ResvModel �� ��¥�� �� ��ġ�Ͽ����ϹǷ�, �����ʿ�
	//������ �׽�Ʈ����
	int yy=cal.get(cal.YEAR); 
	int mm=cal.get(cal.MONTH);
	int dd=cal.get(cal.DATE);
	
	NewInModel newModel_in;
	NewOutModel newModel_out;
	public NewOpen(HotelMain main,Connection con){
		main.main=main;
		main.con=con;
		
		this.setLayout(new BorderLayout());
		//north
		p_date = new JPanel();
		//**���õ� ���̺� ���� ��¥�� �°� ....
		la_date = new JLabel(yy+"-"+(mm+1)+"-"+dd);
		//west
		p_in = new JPanel();
		la_in = new JLabel("Check-In");
		table_in = new JTable();
		//east
		p_out = new JPanel();
		la_out = new JLabel("Check-Out");
		table_out = new JTable();
		
		p_date.setLayout(new BorderLayout());
		p_in.setLayout(new BorderLayout());
		p_out.setLayout(new BorderLayout());
		
		//table
		table_in.setPreferredSize(new Dimension(400, 400));
		table_out.setPreferredSize(new Dimension(400, 400));
		
		//north
		p_date.add(la_date,BorderLayout.NORTH);
		add(p_date,BorderLayout.NORTH);
		
		//west
		p_in.add(la_in,BorderLayout.NORTH);
		p_in.add(table_in);
		add(p_in,BorderLayout.WEST);
		
		//east
		p_out.add(la_out,BorderLayout.NORTH);
		p_out.add(table_out);
		add(p_out,BorderLayout.EAST);
	
		setVisible(true);
		setSize(new Dimension(820, 400));
		
		table_in.setModel(newModel_in = new NewInModel(main, con));
		table_out.setModel(newModel_out = new NewOutModel(main, con));
		table_in.updateUI();
		table_out.updateUI();
	}

}
