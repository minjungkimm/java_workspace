package Academy;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class LoadMain extends JFrame implements ActionListener{
	JPanel p_north;
	JButton bt_open,bt_load,bt_del;
	JTable table;
	JScrollPane scroll;
	JTextField t_path; //��γ���
	JFileChooser chooser;
	FileReader reader=null; //finally ���� �������� �������
	BufferedReader buffr=null; //���پ� �о�帱 ���̴ϱ� ���
	
	public LoadMain() {
		p_north = new JPanel();
		t_path = new JTextField(20);
		bt_open = new JButton("���Ͽ���");
		bt_load = new JButton("�ε��ϱ�");
		bt_del = new JButton("�����ϱ�");
		
		chooser = new JFileChooser("c:/animal");
		
		table = new JTable();
		scroll = new JScrollPane(table);
		
		
		p_north.add(t_path);
		p_north.add(bt_open);
		p_north.add(bt_load);
		p_north.add(bt_del);
		
		add(p_north,BorderLayout.NORTH);
		add(scroll);
		
		bt_open.addActionListener(this);
		bt_load.addActionListener(this);
		bt_del.addActionListener(this);
		
		setVisible(true);
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}//
	
	//���Ͽ��� ������ Ž��â //���� ���Ḹ!!
	public void open(){
		int result=chooser.showOpenDialog(this);
		if(result==JFileChooser.APPROVE_OPTION){
			//Ȯ�ι�ư������~~
			File file=chooser.getSelectedFile();
			t_path.setText(file.getAbsolutePath());
			
			try {
				reader = new FileReader(file);
				buffr = new BufferedReader(reader); //���ϴ��
				//��������� �ϸ� ���븸 ����
				//���⸦ ������ ���ϰ� ���Ḹ �� ����
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}
	
	//���Ϸε� �Ѹ���~~
	public void load(){
		System.out.println(buffr);
		
		String data;
		StringBuffer sb = new StringBuffer();
		
		data=buffr.readLine();
		if(data==null)break;
		
		String[] value = data.split(","); //���� �����͸� �޸����� �и����ž�
		//�׷��� String ������ ������ �����ϱ� -> ��Ʈ���� �迭�� ����
		
		if(!value[0].equals("seq")){
			
			sb.append("insert into hospital(seq,name,addr,regdate,status,dimension,type)");
			sb.append(" values("+value[0]+",'"+value[1]+"','"+value[2]+"','"+value[3]+,',"",)");
		}
	
	}
	
	//���ϻ���
	public void delete(){
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		if(obj==bt_open){
			open();
		}else if(obj==bt_load){
			load();
		}else if(obj==bt_del){
			delete();
		}
		
	}
	
	public static void main(String[] args) {
		new LoadMain();
	}
	
}
