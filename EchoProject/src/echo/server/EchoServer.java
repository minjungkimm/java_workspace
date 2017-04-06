/*에코 프로그램이란?
 * 클라이언트의 메세지를 그대로 다시 전달하는
 * 방식의 서버!! 채팅 기초 1단계
 * */
package echo.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer{
	ServerSocket server;
	int port=7777;
	
	public EchoServer() {
		try {
			server = new ServerSocket(port);
			System.out.println("서버 생성");
			
			Socket socket=server.accept(); //접속자가 있을 때까지 //다른사람의 접속 감지한다..
			InetAddress inet=socket.getInetAddress(); //반환형 inetAddres
			String ip=inet.getHostAddress(); 
			//무한대기에 빠진다.
			
			System.out.println(ip+"접속자 발견");
			
			//서버는 듣고 말한다
			//클라이언트의 데이터를 받기 위해 
			//입력 스트림 얻기!!
			//바이트기반-->문자기반-->버퍼기반
			BufferedReader buffr=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//3단계 업그레이드 한줄로 가기!!!! //청취용!! 듣기용!!
			//마지막에는 버퍼만 닫아주면 끝난다..
			BufferedWriter buffw= new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			//3단계 업그레이드 한줄로 가기!!!! //말하기용!!
			
			//여기서부터 캐치문 전까지 while 문 걸면 1인 접속서버다
			//대화는 끝없이 가능하지만 , 다른 접속자의 접속이 불가능하다
			
			/*대화는 계속 가능하지만 , 실행부가 아래의 while문안에
			 * 갇혀있으므로, 더이상 추가 접속자에 대한 접속허용은
			 * 불가하다 결론: 최초 가장 빨리 들어온 사람용 서버*/
			while(true){
				//클라이언트의 말 듣기!!
				String msg;
				msg=buffr.readLine(); //듣기
				System.out.println("클라이언트가 보낸 말:"+msg);
				
				//메시지 다시 보내기
				buffw.write(msg+"\n"); //한 줄 보내기
				buffw.flush(); //버퍼비우기
			
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new EchoServer();
	}
}
