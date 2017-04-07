package echo.client;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import db.DBManager;

public class ClientMain extends JFrame implements ItemListener,ActionListener{
	JPanel p_north;
	Choice choice;
	JTextField t_port,t_input;
	JButton bt_connect;
	JTextArea area;
	JScrollPane scroll;
	int port=7777;
	DBManager manager;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	ArrayList<Chat> list = new ArrayList<Chat>();
	Socket socket; //��ȭ�� ����!! ���� ��Ʈ�� �̾Ƴ�����..
	String ip;
	ClientThread ct;

	public ClientMain() {
		p_north = new JPanel();
		choice = new Choice();
		t_port = new JTextField(Integer.toString(port),10);
		bt_connect = new JButton("����");
		area = new JTextArea();
		scroll = new JScrollPane(area);
		t_input = new JTextField();
		
		manager = manager.getInstance();
	
		p_north.add(choice);
		p_north.add(t_port);
		p_north.add(bt_connect);
		add(p_north,BorderLayout.NORTH);
		add(scroll);
		add(t_input,BorderLayout.SOUTH);
		
		loadIP();
		for(int i=0; i<list.size(); i++){
			choice.add(list.get(i).getName());
		}
		
		//�����ʿ��� ����
		choice.addItemListener(this);
		bt_connect.addActionListener(this);
		t_input.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				int key=e.getKeyCode();
				if(key==KeyEvent.VK_ENTER){
					
					String msg=t_input.getText();
					ct.send(msg); //������
					//�Է��� �۾� �����
					t_input.setText("");
					
				}
			}
		});
		
		setVisible(true);
		setBounds(0,100,300,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	
	
	//������ ���̽� ��������
	public void loadIP() {
		Connection con = manager.getConnection();
		String sql="select * from chat_member order by chat_id asc";
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				Chat dto = new Chat();
				
				dto.setChat_id(rs.getInt("chat_id"));
				dto.setName(rs.getString("name"));
				dto.setIp(rs.getString("ip"));
				
				list.add(dto);
				
			}
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		} finally {
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
			manager.disConnect(con);
		}
		
		
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		Choice ch=(Choice)e.getSource();
		//���̽����� ������ �ε����� �ο��ϴ� ��� �̤����ϱ�..
		int index=ch.getSelectedIndex();
		Chat chat=list.get(index); 
		this.setTitle(chat.getIp());
		ip=chat.getIp();
		//���ʿ��� ������ ������ ������ �۾��غ���!!
		
	}
	
	//������ ������ �õ�����!!
	public void connect(){
		//���� ������ ������ �߻���..
	
		try {
			
			port=Integer.parseInt(t_port.getText());
			socket = new Socket(ip, port);
			
			//��ȭ�� ������ ���� ��Ʈ�� ������
			//�ǽð����� ������ �޼����� ���� û���ϱ� ���� , �����带
			//�����Ͽ� ��ȭ������ �� �ðܹ�����
			//���� ������,���� �����ڴ� ����
			ClientThread ct = new ClientThread(socket, area);
			ct.start();
			
			ct.send("�ȳ�?");
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		connect();
		
	}
	
	public static void main(String[] args) {
		new ClientMain();
	}
}
