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
	
	JPanel p_west; //���� ��Ʈ�� ����
	JPanel p_center; //�ܾ� �׷��� ó�� ����
	
	JLabel la_user; //���� �α����� ������
	JLabel la_score; //���� ����

	Choice choice; //�ܾ� ���� �帳�ڽ�
	JTextField t_input; //�����Է�â
	JButton bt_start; //���� ���� ��ư
	JButton bt_pause; //���� ���� ��ư
	String res="C:/Java_workspace2/project0329/res";
	
	FileInputStream fis;
	InputStreamReader reader; //������ ������� �� ���ڱ�� //��ǲ��Ʈ�� + ���� ������..
	BufferedReader buffer; //���ڱ�� ���۽�Ʈ��..
	
	//������ �ܾ ��Ƴ��� ���ӿ� ��Ա� ����
	ArrayList wordList = new ArrayList<String>();
	
	
	public GamePanel(GameWindow gameWindow) {
		this.gameWindow=gameWindow;
		setLayout(new BorderLayout());
		
		p_west = new JPanel(){
			@Override
			public void paint(Graphics g) {
				//�� ������ ���ݺ��� �׸��� �׸� ����!!
				g.drawString("�׵���", 200, 500);
			}
		};
		p_center = new JPanel(); 
		
		la_user = new JLabel("����� ��"); 
		la_score = new JLabel("0��"); 

		choice = new Choice(); 
		t_input = new JTextField(20); 
		bt_start = new JButton("START");
		bt_pause = new JButton("PAUSE");
		
		p_west.setPreferredSize(new Dimension(150, 700));
		//p_west.setBackground(Color.PINK);
		
		choice.setPreferredSize(new Dimension(135, 40));
		choice.add("�� �ܾ��� ����");
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
		setVisible(false); //���������쿡�� �гεΰ��� add ���ѳ���ſ�� 
		//���ʿ� �����ϱ� ������ ���⼭ ���� ���尪�� false ��� ���.
		setPreferredSize(new Dimension(900, 700));
		
		getCategory();
		
	}

	//���̽� ������Ʈ�� ä���� ���ϸ� �����ϱ�
	public void getCategory(){
		//�ϵ��ũ��  ������ ��θ� ���ϹǷ�, ��ü ���´� 
		File file = new File(res);
		
		//����+���丮 �����ִ� �迭��ȯ
		File[] files = file.listFiles();
		
		for(int i=0; i<files.length; i++){
			if(files[i].isFile()){
				String name=files[i].getName(); //memo.txt
				String [] arr =name.split("\\."); //������� �κ��� ���ֱ� ���� \\
				if(arr[1].equals("txt")){
					choice.add(name);
				}
			}
		}
	}
	
	//�ܾ� �о����
	public void getWord(){
		
		int index=choice.getSelectedIndex();
		
		if(index!=0){//ù��°��Ҵ� ����
		String name=choice.getSelectedItem();
		System.out.println(res+name);
		
		try {
			fis = new FileInputStream(res+name);
			reader = new InputStreamReader(fis, "utf-9");
			//��Ʈ���� ����ó�� ���ر��� �ø�!!
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
		System.out.println("�� �مf��?");
		getWord();
	}

}
