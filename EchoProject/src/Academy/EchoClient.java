package Academy;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class EchoClient extends JFrame{
	JTextArea area;
	JScrollPane scroll;
	JPanel p_south;
	JTextField t_input;
	JButton bt_connect;
	Socket socket;
	BufferedReader buffr;
	BufferedWriter buffw;
	
	public EchoClient() {
		area = new JTextArea();
		scroll = new JScrollPane(area);
		p_south = new JPanel();
		 t_input = new JTextField(10);
		 bt_connect = new JButton("접속");
		 
		 add(scroll);
		 p_south.add(t_input);
		 p_south.add(bt_connect);
		 add(p_south,BorderLayout.SOUTH);
		 
		 bt_connect.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Connect();
				
			}
		}); //a e
		
		 t_input.addKeyListener(new KeyAdapter() {
	
			@Override
			public void keyReleased(KeyEvent e) {
				int key=e.getKeyCode();
				
				if(key==KeyEvent.VK_ENTER){
					send();
				}
			}

		});//k e
		 
		 setVisible(true);
		 setSize(400, 500);
		 setDefaultCloseOperation(EXIT_ON_CLOSE);
		 
	}//생
	
	//키 이벤트 실행 시 메서드
	private void send() {
		String msg = t_input.getText();
		
		buffw.write(msg+"\n");
		

	}
	
	
	//접속 버튼 클릭 시 클라이언트 접속
	private void Connect() {
		try {
			socket = new Socket("localhost", 7777);
			
			buffr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			buffw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		
		} catch (UnknownHostException e) {
			
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		
	
	
	}
	
	public static void main(String[] args) {
		new EchoClient();
	}
	
}// ㄲ
