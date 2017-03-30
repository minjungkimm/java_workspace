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
	
	JPanel p_west; //���� ��Ʈ�� ����
	JPanel p_center; //�ܾ� �׷��� ó�� ����
	
	JLabel la_user; //���� �α��� ������
	JLabel la_score; //���� ����
	Choice choice; //�ܾ� ���� ����ڽ�
	JTextField t_input; //���� �Է�â
	JButton bt_start, bt_pause; //���� ���� ��ư
	String res="C:/java_workspace2/project0329/res/"; //������ ���
	
	FileInputStream fis;
	InputStreamReader reader; //������ ������� �� ���ڱ�� ��Ʈ��
	BufferedReader buffr; //���� ��� ���۽�Ʈ��
	
	//������ �ܾ ��Ƴ���! ���ӿ� ��Ա� ����
	ArrayList<String> wordList=new ArrayList<String>();
	
	Thread thread;//�ܾ������ ������ ������
	boolean flag=true;
	//int y; //�ܾ� ������ y�� ��  �����..
	ArrayList<Word> words = new ArrayList<Word>();
	
	public GamePanel(GameWindow gameWindow) {
		this.gameWindow=gameWindow;
		setLayout(new BorderLayout());
		
		p_west=new JPanel();
		p_center=new JPanel(){
			//�� ������ ���ݺ��� �׸��� �׸� ����!!
			public void paintComponent(Graphics g) {
				//���� �׸� �����!!
				g.setColor(Color.WHITE);
				g.fillRect(0, 0, 750, 750);
				
				g.setColor(Color.BLUE);
				//g.drawString("����", 0, y);
				//��� ����鿡 ���� render();
				for(int i=0;i<words.size(); i++){
					words.get(i).render(g);
				}
			}
		};
		
		
		la_user=new JLabel("�ѿ��� ��");
		la_score=new JLabel("0��");
		choice=new Choice();
		t_input=new JTextField(10);
		bt_start=new JButton("start");
		bt_pause=new JButton("pause");
		
		p_west.setPreferredSize(new Dimension(150, 700));
		p_west.setBackground(Color.orange);
		
		choice.add("��ī�װ� ����");
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
		
		//��ư�� �����ʿ���
		bt_start.addActionListener(this);
		bt_pause.addActionListener(this);
		
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
 
	// �ܾ� �о����
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
			while(true){
				data=buffr.readLine(); //�� ��
				if(data==null)break;
				//System.out.println(data);
				wordList.add(data);
			}
			
			//�غ�� �ܾ ȭ�鿡 �����ֱ�
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
			
			words.add(word);//���� ��ü ��� �����
		}
	}
	
	//���� ����
 
	public void startGame(){
		//�ѹ����������� ����ǰ�
		//�����尡 ���϶� , �� �̹� ������ ����ȵ�
		if(thread==null){
			thread = new Thread(this);
			//�츮�� ���� �����ϰ� �μ��� this �־�����
			thread.start();
		}
	}
	//���� ����
	public void pauseGame(){
	
	}
	
	//down �޼�������
	
	public void itemStateChanged(ItemEvent e) {
		System.out.println("�� �ٲ�?");
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
			//��� �ܾ�鿡 ���ؼ� tick()
			//��� �ܾ�鿡 ���ؼ� render()
			for(int i=0;i<words.size(); i++){
				words.get(i).tick();
			}
			//��� �ܾ�鿡 ���ؼ� repaint()
			p_center.repaint();
		}
	}

}
