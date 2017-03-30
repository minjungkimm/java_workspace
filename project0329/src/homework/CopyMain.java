package homework;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
//runnable 구현 -> run 메서드 재정의..
public class CopyMain extends JFrame implements ActionListener,Runnable{
	JProgressBar bar;
	JButton bt_open,bt_save,bt_copy;
	JTextField t_open,t_save;
	JFileChooser chooser; //미리 new한다음에 필요한 메서드만 불러내는 것
	File file; //읽어들일 파일,복사원본
	Thread thread; //복사를 실행할 전용 쓰레드
	//메인메서드는 우리가 알고있는 실행부라 불리는 어플리케이션의 운영을
	//담당하는 역할을 수행한다 , 따라서 절대 무한루프나 
	//대기상태에 빠트리지 말자
	long total; //원본 파일의 전체 용량 //8byte 해당되는 long
	
	public CopyMain(){
		bar = new JProgressBar();
		
		bt_open = new JButton("열기");
		bt_save = new JButton("저장");
		bt_copy = new JButton("복사실행");
		
		t_open = new JTextField(30);
		t_save = new JTextField(30);
		
		chooser = new JFileChooser("C:/Java_workspace2"); //디폴트 디렉터리
		
		bar.setPreferredSize(new Dimension(400, 50));
		bar.setStringPainted(true);
		bar.setBackground(Color.yellow);
		bar.setString("0%");
		
		setLayout(new FlowLayout());
		
		add(bar);
		
		add(bt_open);
		add(t_open);
		add(bt_save);
		add(t_save);
		
		add(bt_copy);
		
		//버튼과리스너연결
		bt_open.addActionListener(this);
		bt_save.addActionListener(this);
		bt_copy.addActionListener(this);
		
		setVisible(true);
		setSize(450,200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//삼항연산자의 장점 코드(가독성이좋아짐)가 짧아진다 = (if,else if 문을 대체하자(가독성이 떨어지는))
		//()안에 판단조건이 온다
		//버튼
		//이벤트 일으킨 이벤트소스(이벤트 주체)
		Object obj = e.getSource();
		
		if(obj==bt_open){
			open();
		}else if(obj==bt_save){
			save();
		}else if(obj==bt_copy){
			//메인이 직접 복사를 수행하지 말고 
			//쓰레드에게 시키자
			//쓰레드 생성자에 Runnable 구현객체를
			//인수에 넣으면 , Runnable 객체에서
			//재정의한 run()메서드를 수행한다
			thread = new Thread(this);
			//우리가 만든 run이 수행하게하자
			thread.start(); //메인실행부위에있는 run수행
		}
	}
	
		public void open(){
			//component 는 바깥쪽 컴포넌트 뜻하는 것
			//(윈도우창) this 가 들어가야함
			int result=chooser.showOpenDialog(this);
			if(result==JFileChooser.APPROVE_OPTION){
				file=chooser.getSelectedFile();
				t_open.setText(file.getAbsolutePath());
				total = file.length();
			}
		}
		
		public void save(){
			
			int result=chooser.showSaveDialog(this);
			if(result==JFileChooser.APPROVE_OPTION){
				File file=chooser.getSelectedFile();
				t_save.setText(file.getAbsolutePath());
			}
		}
		
		public void copy(){
			
			FileInputStream fis=null;
			FileOutputStream fos=null;
			
			try {
				
				fis=new FileInputStream(file); //파일에 빨대를 꼽았다!!
				fos=new FileOutputStream(t_save.getText()); //만들어질 파일
				
				int data;
				int count=0;
				//생성된 스트림을 통해 데이터 읽기!!
					while(true){
						data=fis.read();//1byte 씩 읽기 //read의 횟수가 곧 용량
						if(data==-1)break;
						count++;
						fos.write(data);//1byte씩 출력
						int v=(int)getPercent(count); //count넣고 long v로 받는다
						//(int) 의도된 강제형변환을 명시시킴!!
						//프로그레스바에 적용
						bar.setValue(v);
						bar.setString(v+"%");
					}
					//while 문 완료되면 복사끝난다 복사완료 창 뜨자!!
					JOptionPane.showMessageDialog(this, "복사완료");
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}  catch (IOException e) {
					e.printStackTrace();
				}finally{
					if(fis!=null){
						try {
							fis.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					if(fos!=null){
						try {
							fos.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			
		}	
		
	@Override
	public void run() {
		copy();
		
	}
	
	//현재 진행율 구하기 공식
	//진행율= 100%*현재읽어들인데이터/전체크기
	public long getPercent(int currentRead){
		return (100*currentRead)/total;
		//int를 long으로 하는게 손실이 안 일어난다..
	}
	
	public static void main(String[] args) {
		new CopyMain();

	}

}
