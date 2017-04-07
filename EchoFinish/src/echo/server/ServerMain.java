package echo.server;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ServerMain extends JFrame implements ActionListener{
	JPanel p_north;
	JTextField t_port;
	JButton bt_start;
	JTextArea area;
	JScrollPane scroll;
	int port=7777;
	ServerSocket server; //접속감지용 소켓
	
	Thread thread; //내부익명으로 가자 //서버가동용 쓰레드!
	BufferedReader buffr;
	BufferedWriter buffw;
	
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
	
	@Override
	public void actionPerformed(ActionEvent e) {
		thread = new Thread(){
			@Override
			public void run() {
				//단독적으로 수행을 위한 run 메서드
				startServer();
			}
		};
		thread.start();
	}
	
	//서버 생성 및 가동
	//예외의 종류 - checked Exception 예외처리 강요
	//				- runtime Exception 예외처리 안강요
	private void startServer() {
		bt_start.setEnabled(false); //비활성화!!
		//0. 버튼을 누르면 접속되게 하자
		//1. 클라이언트의 접속을 감지한다
		//스트링이 int 로 바뀐다..
		//port 에는 숫자만 들어가게 , 개발자가 막아보자!!
		/*런타임 예외 (강요하지 않는 예외)
		: 프로그램이 돌아가는 와중에 에러가 발생했을 때
		처리하는 것..↓*/
		try {
			port=Integer.parseInt(t_port.getText());
			server = new ServerSocket(port);
			area.append("서버 준비됨..\n");
			//가동
			Socket socket = server.accept(); 
			/*실행부라 불리는 메인쓰레드는 절대
			 * 무한루프나 대기, 혹은 지연 상태에 
			 * 빠지게 해서는 안된다..
			 * 왜? 실행부는 유저들의 이벤트를 감지하거나,
			 * 프로그램을 운영해야한다. 
			 * 무한루프나 대기에 빠지면, 본연의 업무를 할 수 없다
			 * 스마트폰 개발분야에서는 이와같은 코드는
			 * 이미 컴파일 타임부터 에러발생함*/
			//어제는 GUI 사용하지않아서, 감지할 이벤트나 본연의 업무가
			//필요없었다...
			area.append("서버가동..\n");
			
			//클라이언트는 대화를 하기 위해 접속한 것이므로,
			//접속이 되는 순간 스트림을 얻어놓자!!
			buffr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			buffw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			//클라이언트의 메세지 받기
			String data;
			//계속 듣자!!
			while(true){
				data=buffr.readLine(); //받기
				area.append("클라이언트의 말:"+data+"\n");
				
				buffw.write(data+"\n"); //보내기 //문장의끝 줄바꿈
				buffw.flush(); //버퍼비우기
			}
			
		} catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(this, "포트는 숫자로 넣어주세요");
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void main(String[] args) {
		new ServerMain();
	}
}
