package game.word;
 
import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
 
public class GamePanel extends JPanel implements ItemListener, ActionListener,Runnable{
	GameWindow gameWindow;
	
	JPanel p_west; //왼쪽 컨트롤 영역
	JPanel p_center; //단어 그래픽 처리 영역
	
	JLabel la_user; //게임 로그인 유저명
	JLabel la_score; //게임 점수
	Choice choice; //단어 선택 드랍박스
	JTextField t_input; //게임 입력창
	JButton bt_start, bt_pause; //게임 시작 버튼
	String res="C:/java_workspace2/project0329/res/"; //조사할 경로
	
	FileInputStream fis;
	InputStreamReader reader; //파일을 대상으로 한 문자기반 스트림
	BufferedReader buffr; //문자 기반 버퍼스트림
	
	//조사한 단어를 담아놓자! 게임에 써먹기 위해
	ArrayList<String> wordList=new ArrayList<String>();
	
	Thread thread;//단어게임을 진행할 쓰레드
	boolean flag=true;
	//int y; //단어 현재의 y축 값  지운다..
	ArrayList<Word> words = new ArrayList<Word>();
	
	public GamePanel(GameWindow gameWindow) {
		this.gameWindow=gameWindow;
		setLayout(new BorderLayout());
		
		p_west=new JPanel();
		p_center=new JPanel(){
			//이 영역은 지금부터 그림을 그릴 영역!!
			public void paintComponent(Graphics g) {
				//기존 그림 지우기!!
				g.setColor(Color.WHITE);
				g.fillRect(0, 0, 750, 750);
				
				g.setColor(Color.BLUE);
				//g.drawString("고등어", 0, y);
				//모든 워드들에 대한 render();
				for(int i=0;i<words.size(); i++){
					words.get(i).render(g);
				}
			}
		};
		
		
		la_user=new JLabel("한예지 님");
		la_score=new JLabel("0점");
		choice=new Choice();
		t_input=new JTextField(10);
		bt_start=new JButton("start");
		bt_pause=new JButton("pause");
		
		p_west.setPreferredSize(new Dimension(150, 700));
		p_west.setBackground(Color.orange);
		
		choice.add("▼카테고리 선택");
		choice.setPreferredSize(new Dimension(135, 40));
		choice.addItemListener(this);
		
		p_west.add(la_user);
		p_west.add(choice);
		p_west.add(t_input);
		p_west.add(bt_start);
		p_west.add(bt_pause);
		p_west.add(la_score);
		
		add(p_west, BorderLayout.WEST);
		add(p_center);
		
		//버튼과 리스너연결
		bt_start.addActionListener(this);
		bt_pause.addActionListener(this);
		
		//setBackground(Color.CYAN);
		setVisible(false); //최초에 등장 안함!!
		setPreferredSize(new Dimension(900, 700));
		
		getCategory();
		p_center.repaint();
	}
	
	//초이스 컴포넌트에 채워질 파일명 조사하기
	public void getCategory(){
		File file=new File(res);
		
		//파일+디렉토리 섞여있는 배열반환
		File[] files=file.listFiles();
		for(int i=0; i<files.length; i++){
			if(files[i].isFile()){
				String name=files[i].getName();
				String[] arr=name.split("\\.");
				if(arr[1].equals("txt")){ //메모장이라면
					choice.add(name);
					
				}
			}
		}
		
	}
 
	// 단어 읽어오기
	public void getWord(){
		int index=choice.getSelectedIndex();
		
		if(index!=0){ //첫번째 요소는 빼고..
		String name=choice.getSelectedItem();
		System.out.println(res+name);
		
		try {
			fis=new FileInputStream(res+name);
		
			reader=new InputStreamReader(fis,"utf-8");
			
			//스트림을 버퍼 처리 수준까지 올림!!
			buffr=new BufferedReader(reader);
			String data;
			while(true){
				data=buffr.readLine(); //한 줄
				if(data==null)break;
				//System.out.println(data);
				wordList.add(data);
			}
			
			//준비된 단어를 화면에 보여주기
			createWord();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(buffr!=null){
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}if(reader!=null){
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}if(fis!=null){
					try {
						fis.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	public void createWord(){
		for(int i=0; i<wordList.size(); i++){
			String name=wordList.get(i);
			Word word = new Word(name, (i*(75)+10), 100);
			
			words.add(word);//워드 객체 명단 만들기
		}
	}
	
	//게임 시작
 
	public void startGame(){
		//한번눌렀을때만 실행되게
		//쓰레드가 널일때 , 즉 이미 있으면 실행안됨
		if(thread==null){
			thread = new Thread(this);
			//우리의 런을 수행하게 인수로 this 넣어주자
			thread.start();
		}
	}
	//게임 중지
	public void pauseGame(){
	
	}
	
	//down 메서드지움
	
	public void itemStateChanged(ItemEvent e) {
		System.out.println("나 바꿈?");
		getWord();
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		Object obj = e.getSource();
		
		if(obj == bt_start){
			startGame();
		}else if(obj ==bt_pause){
			pauseGame();
		}
	}	
	@Override
	public void run() {

		while(flag){
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//모든 단어들에 대해서 tick()
			//모든 단어들에 대해서 render()
			for(int i=0;i<words.size(); i++){
				words.get(i).tick();
			}
			//모든 단어들에 대해서 repaint()
			p_center.repaint();
		}
	}

}
