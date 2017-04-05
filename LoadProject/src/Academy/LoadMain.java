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
	JTextField t_path; //경로넣을
	JFileChooser chooser;
	FileReader reader=null; //finally 에서 닫으려면 멤버변수
	BufferedReader buffr=null; //한줄씩 읽어드릴 것이니깐 사용
	
	public LoadMain() {
		p_north = new JPanel();
		t_path = new JTextField(20);
		bt_open = new JButton("파일열기");
		bt_load = new JButton("로드하기");
		bt_del = new JButton("삭제하기");
		
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
	
	//파일열기 누르면 탐색창 //파일 연결만!!
	public void open(){
		int result=chooser.showOpenDialog(this);
		if(result==JFileChooser.APPROVE_OPTION){
			//확인버튼누르면~~
			File file=chooser.getSelectedFile();
			t_path.setText(file.getAbsolutePath());
			
			try {
				reader = new FileReader(file);
				buffr = new BufferedReader(reader); //파일대상
				//여기까지만 하면 빨대만 생성
				//열기를 누르면 파일과 연결만 한 상태
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}
	
	//파일로드 뿌리자~~
	public void load(){
		System.out.println(buffr);
		
		String data;
		StringBuffer sb = new StringBuffer();
		
		data=buffr.readLine();
		if(data==null)break;
		
		String[] value = data.split(","); //나는 데이터를 콤마에서 분리싴ㄹ거야
		//그러면 String 형으로 여러개 나오니깐 -> 스트링형 배열로 받자
		
		if(!value[0].equals("seq")){
			
			sb.append("insert into hospital(seq,name,addr,regdate,status,dimension,type)");
			sb.append(" values("+value[0]+",'"+value[1]+"','"+value[2]+"','"+value[3]+,',"",)");
		}
	
	}
	
	//파일삭제
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
