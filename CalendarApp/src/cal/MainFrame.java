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
	
	//현재날짜를 계산하기 위한 변수
	int yy;
	int mm;
	int dd;
	
	public MainFrame() {
		p_north = new JPanel();
		p_center = new JPanel();
		la_title = new JLabel("2017년 4월");
		la_title.setFont(new Font("돋음", Font.BOLD|Font.ITALIC,28));
		bt_prev = new JButton("◀");
		bt_next = new JButton("▶");
		
		p_north.add(bt_prev);
		p_north.add(la_title);
		p_north.add(bt_next);
		
		add(p_north,BorderLayout.NORTH);
		add(p_center);
		
		//현재날짜를 계산하기 위한 객체
		yy=cal.get(Calendar.YEAR);
		mm=cal.get(Calendar.MONTH); //출력할때만 +1 하자
		dd=cal.get(Calendar.DATE);
		
		System.out.println(yy+"-"+(mm+1)+"-"+dd);
		
		bt_prev.addActionListener(this);
		bt_next.addActionListener(this);
		
		printDate();
		
		setVisible(true);
		setSize((120*7)+100,(120*6)+130);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	//날짜 출력 메서드 정의
	public void printDate(){
		//현재 날짜를 라벨에 출력
		la_title.setText(yy+"-"+(mm+1));
		//사각형 모두 날리기
		p_center.removeAll();
		
		//각 월이 무슨 요일부터 시작하나?
		//해당 월을 1일로 맞추고, 그 요일이 무슨 요일인지
		//물어보면 됨..
		cal.set(yy,mm,1);
		int firstDay=cal.get(Calendar.DAY_OF_WEEK);
		System.out.println(mm+1+"의 시작요일은?"+firstDay);
		//1=일요일,2=월,3=화,----.....
		
		//각월의 마지막 날짜 알아맞추기
		//왜? 반복문의 끝을 알기위해!!
		cal.set(yy, mm+1,0);
		int lastDay=cal.get(Calendar.DATE);
		
		int num=0; //실제 찍힐 날짜용 변수
		
		for(int i=0; i<box.length; i++){
			//num이 firstDay 보다 클때 출력
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
		//이전달
		if(obj==bt_prev){
			mm--;
			if(mm<0){
				mm=11;
				yy--;
			}
			printDate();
		}else if(obj==bt_next){
		//다음달
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
