package editor;

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
import javax.swing.JTextField;

public class CopyMain extends JFrame implements ActionListener{
	//전체적으로 FlowLayout 준다
	//버튼과 텍스트필드 붙힌다
	JButton bt_open,bt_save,bt_copy;
	JTextField t_open,t_save;
	
	FileInputStream fis; //파일 대상으로 한 입력 스트림
	FileOutputStream fos; //파일 대상으로 한 출력 스트림
	
	//파일탐색기를 처리하는 객체
	JFileChooser chooser;
	

	public CopyMain(){



		bt_open=new JButton("원본경로");
		bt_save=new JButton("저장경로");
		bt_copy=new JButton("복사실행");
									
		t_open=new JTextField(30);
		t_save=new JTextField(30); //저장할 파일명은 우리가 정할거니깐 경로까지만
		
		setLayout(new FlowLayout());
		add(bt_open);
		add(t_open);
		add(bt_save);
		add(t_save);
		add(bt_copy);

		//버튼과 리스너 연결
		bt_open.addActionListener(this);
		bt_save.addActionListener(this);
		bt_copy.addActionListener(this);

		//파일 추저를 미리 올려놓자  //생성자 괄호안에 내가디폴트로 보여줄 디렉토리 영역 지정하자!!
		chooser = new JFileChooser("C:/Java_workspace2/project0323");
	
	
		setSize(475,150);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//윈도우 창을 닫히기 전에 존재하는 스트림을 죽여야 하는데
		//윈도우창이 닫히면서 프로그램 종료되어버림
		//윈도우 리스너에 스트림 죽이는 것을 구현해야한다.. window Closing
	}
	
	public void actionPerformed(ActionEvent e){
		//e야 너 뭐뭐햇는지 아니? //겟소스는 버튼뿐만 아니라 다른객체에도 적용가능하니깐 오브젝트형으로..

		Object obj=e.getSource(); //이벤트 소스를 반환 받는다!!
		
		if(obj == bt_open){
			System.out.println("열기");
			open(); //열기 버튼 누를때 메서드
		}else if(obj == bt_save){
			System.out.println("저장");
			 //복사 버튼 누를때 메서드
			int state=chooser.showSaveDialog(this);
			//상수는 인간에게 직관성을 부여해준다
			//왜?영어단어를 사용하니깐!!...			
			if(state==JFileChooser.APPROVE_OPTION){
			//저장경로를 텍스트필드에 출력하자!!!
				File file=chooser.getSelectedFile();
				//파일클래스가 보유한 절대경로 메서드를
				//이용하여 경로 반환!!
				String path=file.getAbsolutePath();
				t_save.setText(path);
			}
		}else if(obj == bt_copy){
			copy();
		}
	
	}//액션이벤트 끝줄
	
	//파일열기!!
	public void open(){
						//component parent 선택
		int state = chooser.showOpenDialog(this);
		if(state == JFileChooser.APPROVE_OPTION){
			//System.out.println("you choose to open this file :");
			//인스턴스 얻기
			File file=chooser.getSelectedFile();
			//얻어진 인스턴스를 이용하여 절대경로 얻기
			String path=file.getAbsolutePath();
			//t_open.setText(chooser.getSelectedFile().getPath());
			//절대 경로 텍스트필드에 출력하기
			t_open.setText(path);
		}

	}
	//복사하기!!
	public void copy(){
		//원본 파일에 스트림 생성하여, 데이터를 들이마시자
		//들어온 데이터는 목적파일에 내려쓰자!!
		//복사 누르면 시작되어야한다!!

		
		String oriPath = t_open.getText(); //입력한 텍스트박스 텍스트 가져오기
		String destPath = t_save.getText(); //목적지는 데스티네이션
		//파일 스트림 처리는 쓰레드에서 한다!!!!!
		
		try{
			fis = new FileInputStream(oriPath);
			fos = new FileOutputStream(destPath); 
			int data; //아무것도 데이터가 없는 상태를 뜻함..
			//리드에서 초기화 될 예정
			while(true){
				data=fis.read();//현재 실행중인 프로그램으로 1byte 읽어들임
				if(data==-1)break; //break 문을 만나지 않고 밑에로 넘어갔다면, 데이터가 유효하다!! //만약 -1을 break 걸지않으면, -1을 쓰겠다는 뜻 = 파일이 망가짐		
				fos.write(data);
			}

			JOptionPane.showMessageDialog(this,"복사완료");
			//스트림을 닫자
			//try 문안에서 닫을 경우 문제점
			//예외발생시 바로 catch 문으로가니깐 close 수행되지 않는다!!!
			//fis.close();

		}catch(FileNotFoundException e){
			//얘가 살아갈 위치는 어디? 어디서 나올거야?
			JOptionPane.showMessageDialog(this,"파일을 찾을수 없습니다.");
			//catch 문안에서 닫을 경우 문제점
			//fis.close();
		}catch(IOException e){
			JOptionPane.showMessageDialog(this,"IO 작업중 에러가 발생했다.");
		}finally{
			
			try{
				//객체가 메모리에 올라왔다면..
				if(fis!=null){
					fis.close();
				}
				if(fos!=null){
					fos.close();
				}
			}catch(IOException e){
			
			}

		 }
	}
	public static void main(String[] args) {
		new CopyMain();
	
	}

}
