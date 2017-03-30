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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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

public class GamePanel extends JPanel implements ItemListener, Runnable, ActionListener{
	GameWindow gameWindow;
	
	JPanel p_west; //���� ��Ʈ�� ����
	JPanel p_center; //�ܾ� �׷��� ó�� ����
	
	JLabel la_user; //���� �α��� ������
	JLabel la_score; //���� ����
	Choice choice; //�ܾ� ���� ����ڽ�
	JTextField t_input; //���� �Է�â
	JButton bt_start, bt_pause,bt_stop; //���� ���� ��ư
	String res="C:/java_workspace2/project0329/res/"; //������ ���
	
	FileInputStream fis;
	InputStreamReader reader; //������ ������� �� ���ڱ�� ��Ʈ��
	BufferedReader buffr; //���� ��� ���۽�Ʈ��
	
	//������ �ܾ ��Ƴ���! ���ӿ� ��Ա� ����
	ArrayList<String> wordList=new ArrayList<String>();
	Thread thread; //�ܾ������ ������ ������
	boolean flag=true; //flag�� ���� ������ ����� false�� ��������
	boolean isDown=true;
	ArrayList<Word> words=new ArrayList<Word>();
	
	
	public GamePanel(GameWindow gameWindow) {
		this.gameWindow=gameWindow;
		setLayout(new BorderLayout());
		
		p_west=new JPanel();
		p_center=new JPanel(){
			//�� ������ ���ݺ��� �׸��� �׸� ����!!
			public void paintComponent(Graphics g) {
				//���� �׸� �����!!
				g.setColor(Color.WHITE);
				g.fillRect(0, 0, 750, 700);
				
				g.setColor(Color.BLUE);
				
				//��� ����鿡 ���� render();
				for(int i=0; i<words.size(); i++){
					words.get(i).render(g);
				}
			
			}
		};
		
		
		la_user=new JLabel("����� ��");
		la_score=new JLabel("0��");
		choice=new Choice();
		t_input=new JTextField(10);
		bt_start=new JButton("start");
		bt_pause=new JButton("pause");
		bt_stop = new JButton("����");
		
		p_west.setPreferredSize(new Dimension(150, 700));
		p_west.setBackground(Color.orange);
		
		choice.add("��ܾ��� ����");
		choice.setPreferredSize(new Dimension(135, 40));
		choice.addItemListener(this);
		
		p_west.add(la_user);
		p_west.add(choice);
		p_west.add(t_input);
		p_west.add(bt_start);
		p_west.add(bt_pause);
		p_west.add(bt_stop);
		p_west.add(la_score);
		
		add(p_west, BorderLayout.WEST);
		add(p_center);
		
		//��ư�� ������ ����
		bt_start.addActionListener(this);
		bt_pause.addActionListener(this);
		bt_stop.addActionListener(this);
		
		//�ؽ�Ʈ �ʵ�� ������ ���� //����͸� ���ؼ� �޼��� ������
		t_input.addKeyListener(new KeyAdapter() {
		
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() ==KeyEvent.VK_ENTER){
					//ȭ�鿡 �����ϴ� words �� �Է°� ���Ͽ�, ������
					//words���� ��ü ����
					String value=t_input.getText();
					//words ��� ��ü���� �񱳴�.. wordList �� ����Ʈ�ϻ�
					for(int i=0; i<words.size(); i++){
						if(words.get(i).name.equals(value)){
							words.remove(i);
						}
					}
				}
			}
		});
		
		//setBackground(Color.CYAN);
		setVisible(false); //���ʿ� ���� ����!!
		setPreferredSize(new Dimension(900, 700));
		
		getCategory();
		p_center.repaint();
	}
	
	//���̽� ������Ʈ�� ä���� ���ϸ� �����ϱ�
	public void getCategory(){
		File file=new File(res);
		
		//����+���丮 �����ִ� �迭��ȯ
		File[] files=file.listFiles();
		for(int i=0; i<files.length; i++){
			if(files[i].isFile()){
				String name=files[i].getName();
				String[] arr=name.split("\\.");
				if(arr[1].equals("txt")){ //�޸����̶��
					choice.add(name);
					
				}
			}
		}
		
	}

	// �ܾ� �о���� //������ ü���� �Ҷ����� �ٿ��� ����
	public void getWord(){
		int index=choice.getSelectedIndex();
		
		if(index!=0){ //ù��° ��Ҵ� ����..
		String name=choice.getSelectedItem();
		System.out.println(res+name);
		
		try {
			fis=new FileInputStream(res+name);
		
			reader=new InputStreamReader(fis,"utf-8");
			
			//��Ʈ���� ���� ó�� ���ر��� �ø�!!
			buffr=new BufferedReader(reader);
			String data;
			//������ wordList �� ����!! //������������ ������ �����ص� ������ �������� �ϳ��� ���Ե�
			wordList.removeAll(wordList);
			
			while(true){
				data=buffr.readLine(); //�� ��
				if(data==null)break;
				//System.out.println(data);
				wordList.add(data);
			}
			//�غ�� �ܾ ȭ�鿡 �����ֱ�
			createWord();
			System.out.println("wordList ����?"+wordList.size());
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		}catch (IOException e) {
			
			e.printStackTrace();
		}finally{
			if(buffr!=null){
				try {
					reader.close();
				} catch (IOException e) {
			
					e.printStackTrace();
				}
			}if(reader!=null){
				try {
					reader.close();
				} catch (IOException e) {
				
					e.printStackTrace();
				}
			}if(fis!=null){
					try {
						fis.close();
					} catch (IOException e) {
				
						e.printStackTrace();
					}
				}
			}
		}
	}
		
	public void createWord(){
		for(int i=0; i<wordList.size(); i++){
			String name=wordList.get(i);
			Word word=new Word(name,(i*(75)+10),100);
			
			words.add(word); //���� ��ü ��� �����
		}
	}
	
	
	//���� ����
	public void startGame(){
		if(thread==null){ //thread�� �޸𸮿� �ø����� ���ٸ�
			flag=true; //stop ���� flag�� false �� �س����Ƿ�, �ٽ� start�� �� 
			//while �� �۵��ϵ��� true �����س���..
			thread=new Thread(this); //�츮�� runnable�� �����
			thread.start();
		}//1���� ������. 
	}
	
	//�����Ͻ����� or �����
	public void pauseGame(){
		isDown=!isDown;
		
	}
	
	/*-- �ᱹ ó������ ���ư���!!@@
	 * 1. wordList ����� (�ܾ���� �����ϴ�)
	 * 2. words ����� (Word �ν��Ͻ����� ����ִ� )
	 * 3. choice ������Ʈ �ʱ�ȭ (index = 0 ���� ��������(�ܾ�������))
	 * 4. flag = false 
	 * 5. thread �� null �� �ٽ� �ʱ�ȭ*/
	public void stopGame(){
		wordList.removeAll(wordList);
		words.removeAll(words);
		choice.select(0); //ù��° ��� ���� ����
		flag=false; //while �� ��������!!
		thread=null; //������ �ʱ�ȭ ����!!
		
	}
	
	public void itemStateChanged(ItemEvent e) {
		System.out.println("�� �ٲ�?");
		getWord();
		
	}
	

	

	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		
		if(obj==bt_start){
			startGame();
		}else if(obj==bt_pause){
			pauseGame();
		}else if(obj==bt_stop){
			stopGame();
		}
		
	}
	
	//������ �����
	public void run() {
		while(flag){
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			if(isDown){
			//��� �ܾ�鿡 ���ؼ� tick()
			for(int i=0; i<words.size(); i++){
				words.get(i).tick();
				
			}
			//��� �ܾ�鿡 ���ؼ� render()
			p_center.repaint();
			}
		}
	}
}
