package help;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import game.word.GameWindow;

public class GamePanel extends JPanel implements ItemListener{
	GameWindow gameWindow;
	
	JPanel p_west; //왼쪽 컨트롤 영역
	JPanel p_center; //단어 그래픽 처리 영역
	
	JLabel la_user; //게임 로그인한 유저명
	JLabel la_score; //게임 점수

	Choice choice; //단어 선택 드립박스
	JTextField t_input; //게임입력창
	JButton bt_start; //게임 시작 버튼
	JButton bt_pause; //게임 중지 버튼
	String res="C:/Java_workspace2/project0329/res";
	
	FileInputStream fis;
	InputStreamReader reader; //파일을 대상으로 한 문자기반 //인풋스트림 + 리더 합쳐진..
	BufferedReader buffer; //문자기반 버퍼스트림..
	
	//조사한 단어를 담아놓자 게임에 써먹기 위해
	ArrayList wordList = new ArrayList<String>();
	
	
	public GamePanel(GameWindow gameWindow) {
		this.gameWindow=gameWindow;
		setLayout(new BorderLayout());
		
		p_west = new JPanel(){
			@Override
			public void paint(Graphics g) {
				//이 영역은 지금부터 그림을 그릴 영역!!
				g.drawString("그동어", 200, 500);
			}
		};
		p_center = new JPanel(); 
		
		la_user = new JLabel("김민정 님"); 
		la_score = new JLabel("0점"); 

		choice = new Choice(); 
		t_input = new JTextField(20); 
		bt_start = new JButton("START");
		bt_pause = new JButton("PAUSE");
		
		p_west.setPreferredSize(new Dimension(150, 700));
		//p_west.setBackground(Color.PINK);
		
		choice.setPreferredSize(new Dimension(135, 40));
		choice.add("▼ 단어집 선택");
		choice.addItemListener(this);
		
		p_west.add(la_user);
		p_west.add(choice);
		p_west.add(t_input);
		p_west.add(bt_start);
		p_west.add(bt_pause);
		p_west.add(la_score);
		
		add(p_center);
		
		add(p_west,BorderLayout.WEST);
		
		setBackground(Color.ORANGE);
		setVisible(false); //게임윈도우에서 패널두개다 add 시켜놓은탓에 
		//최초에 등장하기 때문에 여기서 최초 등장값을 false 라고 줬다.
		setPreferredSize(new Dimension(900, 700));
		
		getCategory();
		
	}

	//초이스 컴포넌트에 채워질 파일명 조사하기
	public void getCategory(){
		//하드디스크의  물리적 경로를 원하므로, 전체 적는다 
		File file = new File(res);
		
		//파일+디렉토리 섞여있는 배열반환
		File[] files = file.listFiles();
		
		for(int i=0; i<files.length; i++){
			if(files[i].isFile()){
				String name=files[i].getName(); //memo.txt
				String [] arr =name.split("\\."); //기능적인 부분을 없애기 위해 \\
				if(arr[1].equals("txt")){
					choice.add(name);
				}
			}
		}
	}
	
	//단어 읽어오기
	public void getWord(){
		
		int index=choice.getSelectedIndex();
		
		if(index!=0){//첫번째요소는 빼고
		String name=choice.getSelectedItem();
		System.out.println(res+name);
		
		try {
			fis = new FileInputStream(res+name);
			reader = new InputStreamReader(fis, "utf-9");
			//스트림을 버퍼처리 수준까지 올림!!
			buffer=new BufferedReader(reader);
			int data;
			while(true){
				data=buffer.readLine();
				if(data==null)break;
			{
				
			}
		}
	} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e){
		  e.printStackTrace();
		  }finally{
			  if(fis!=null){try {
				fis.close();
			} catch (IOException e) {

				e.printStackTrace();
			} 
		 }
			  
	  }
	}
}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		System.out.println("나 바꿧어?");
		getWord();
	}

}
