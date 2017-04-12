package cal;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainFrame extends JFrame implements ActionListener{
	JPanel p_north,p_center;
	JLabel la_title;
	JButton bt_prev,bt_next;
	DateBox[] box = new DateBox[7*6];
	Calendar cal=Calendar.getInstance();
	
	//���糯¥�� ����ϱ� ���� ����
	int yy;
	int mm;
	int dd;
	
	public MainFrame() {
		p_north = new JPanel();
		p_center = new JPanel();
		la_title = new JLabel("2017�� 4��");
		la_title.setFont(new Font("����", Font.BOLD|Font.ITALIC,28));
		bt_prev = new JButton("��");
		bt_next = new JButton("��");
		
		p_north.add(bt_prev);
		p_north.add(la_title);
		p_north.add(bt_next);
		
		add(p_north,BorderLayout.NORTH);
		add(p_center);
		
		//���糯¥�� ����ϱ� ���� ��ü
		yy=cal.get(Calendar.YEAR);
		mm=cal.get(Calendar.MONTH); //����Ҷ��� +1 ����
		dd=cal.get(Calendar.DATE);
		
		System.out.println(yy+"-"+(mm+1)+"-"+dd);
		
		bt_prev.addActionListener(this);
		bt_next.addActionListener(this);
		
		printDate();
		
		setVisible(true);
		setSize((120*7)+100,(120*6)+130);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	//��¥ ��� �޼��� ����
	public void printDate(){
		//���� ��¥�� �󺧿� ���
		la_title.setText(yy+"-"+(mm+1));
		//�簢�� ��� ������
		p_center.removeAll();
		
		//�� ���� ���� ���Ϻ��� �����ϳ�?
		//�ش� ���� 1�Ϸ� ���߰�, �� ������ ���� ��������
		//����� ��..
		cal.set(yy,mm,1);
		int firstDay=cal.get(Calendar.DAY_OF_WEEK);
		System.out.println(mm+1+"�� ���ۿ�����?"+firstDay);
		//1=�Ͽ���,2=��,3=ȭ,----.....
		
		//������ ������ ��¥ �˾Ƹ��߱�
		//��? �ݺ����� ���� �˱�����!!
		cal.set(yy, mm+1,0);
		int lastDay=cal.get(Calendar.DATE);
		
		int num=0; //���� ���� ��¥�� ����
		
		for(int i=0; i<box.length; i++){
			//num�� firstDay ���� Ŭ�� ���
			box[i] = new DateBox(this);
			p_center.add(box[i]);
			
			if(i>=firstDay-1){
				num++;
			}else{
				num=0;
			}
			if(num!=0){
				if(num<=lastDay){
					box[i].la.setText(Integer.toString(num));
				}else{
					box[i].la.setText("");
				}
			}else{
				box[i].la.setText("");
			}
		}
	}

	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		//������
		if(obj==bt_prev){
			mm--;
			if(mm<0){
				mm=11;
				yy--;
			}
			printDate();
		}else if(obj==bt_next){
		//������
			mm++;
			if(mm>11){
				mm=0;
				yy++;
			}
			printDate();
		}
		
	}
	
	public static void main(String[] args) {
		new MainFrame();
	}

}
