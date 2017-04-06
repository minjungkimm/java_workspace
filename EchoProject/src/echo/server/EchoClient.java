package echo.server;

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
	
	//대화를 나눌 수 있는 소켓!!
	//말걸 때 - 소켓으로부터 출력스트림
	//청취할 때 - 소켓으로 부터 입력스트림
	Socket socket;
	BufferedReader buffr; //청취용
	BufferedWriter buffw; //말 걸기용
	
	public EchoClient() {
		area = new JTextArea();
		scroll = new JScrollPane(area);
		p_south = new JPanel();
		t_input = new JTextField(10);
		bt_connect = new JButton("연결");
		
		//add(area);
		add(scroll);
		p_south.add(t_input);
		p_south.add(bt_connect);
		add(p_south,BorderLayout.SOUTH);
		
		bt_connect.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				connect();
			}
		});
		
		t_input.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				//엔터치면..
				int key=e.getKeyCode();
				
				if(key==KeyEvent.VK_ENTER){
					send();
			
				}//
			}//
		});
		
		setVisible(true);
		setSize(400,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}
	
	//서버에 말보내기!! -- 출력!
	//종이컵으로부터 (socket) 
	//소켓을 new 하고서부터, (접속하고서부터)
	//서버한테 말걸수 있는/말들수있는 종이컵 실뽑자!!
	public void send(){
		
		//텍스트상자의 메세지 값을 얻기
		String msg=t_input.getText();
		
		try {
			buffw.write(msg+"\n"); //스트림을 통해 출력!!
									//즉 서버측의 소켓에 데이터 전송!!
			//엔터를 치지않고 버퍼만 출력한 상태!! "\n" 추가
			//끝을 내자!!
			buffw.flush(); //버퍼를 넣은 상태니깐 이제 물을내려보내자
			//버퍼에 남아있을지도 모를 데이터를 대상으로
			//모두 출력시켜버린다!!!
			//버퍼처리된 데이터는 혹시 남아있을 가능성을 염두해놓고
			//flush() 를 해준다!!
			
			//서버에서 날아온 메세지를 area 에 출력
			String data=buffr.readLine();
			area.append(data+"\n");
			t_input.setText("");
			
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	}
	
	
	//서버에 접속하는 메서드
	public void connect(){
		//host : "아이피" , port 번호
		try {
			socket = new Socket("localhost", 7777);
			
			//접속이 완료되었으니 , 스트림 얻어놓자
			//왜? 대화 나누려고!!
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
}
