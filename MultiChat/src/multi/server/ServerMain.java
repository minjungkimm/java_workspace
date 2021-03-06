package multi.server;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import multi.client.ClientThread;

public class ServerMain extends JFrame implements ActionListener,Runnable{
	JPanel p_north;
	JTextField t_port;
	JButton bt_start;
	JTextArea area;
	JScrollPane scroll;
	int port=7777;
	ServerSocket server; //접속감지용 소켓
	Thread thread; 
	
	Socket socket; //소켓을 만들어서 스트림을 뽑자
	BufferedReader buffr;
	BufferedWriter buffw;
	ServerThread st;
	
	//멀티캐스팅을 위해서는 현재서버에 몇명이 들어오고
	//나가는지를 체크할 저장소가 필요하며, 유연해야 하므로 컬렉션 계열로
	//선언하지 않는다 
	//접속하는 사람 과 동일한..
	Vector<ServerThread> list= new Vector<ServerThread>();
	
	public ServerMain() {
		p_north = new JPanel(); //변환.. int-> String으로
		t_port = new JTextField(Integer.toString(port),10);//디폴트값은 앞에문자열로 넣어줌
		bt_start = new JButton("가동");
		area = new JTextArea();
		scroll = new JScrollPane(area);
		
		p_north.add(t_port);
		p_north.add(bt_start);
		add(p_north,BorderLayout.NORTH);
		add(scroll);
		
		//연결
		bt_start.addActionListener(this);
		
		setVisible(true);
		setBounds(600,100,300,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	//서버 가동 메서드
	public void startServer(){
		
		try {
				port=Integer.parseInt(t_port.getText());
				server = new ServerSocket(port);
				area.append("서버생성 \n");
				
				while(true){
					socket=server.accept(); //서버가동
					String ip=socket.getInetAddress().getHostAddress();
					area.append(ip+" 접속자발견 \n");
					
					//접속자마자 쓰레드를 하나씩 할당
					//해서 대화를 나누게 해준다..
					st = new ServerThread(socket,this);
					st.start();
					
					//접속자가 발견되면, 이 접속자와 대화를
					//나눌 쓰레드를, Vector 에 담는다.
					list.add(st);
					area.append("현재 접속자는?"+list.size()+"명 \n");
					
				}
			} catch (NumberFormatException e) {	
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	public void actionPerformed(ActionEvent e) {
		thread = new Thread(this);
		thread.start();
	}
	
	public void run() {
		startServer();
	}
	
	public static void main(String[] args) {
		new ServerMain();
	}
}
