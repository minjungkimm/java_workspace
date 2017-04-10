/*실시간 청취를 위해, 메인 쓰레드가 아닌
 * 개발자 정의 쓰레드를 루프로 돌리자!!*/
package multi.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Vector;

import javax.swing.JTextArea;

import multi.server.ServerMain;
import multi.server.ServerThread;

public class ClientThread extends Thread{
	Socket socket;
	BufferedReader buffr;
	BufferedWriter buffw;
	JTextArea area;
	ClientMain main;
	ServerMain serverMain;
	
	public ClientThread(Socket socket,ClientMain main) {
		this.socket=socket;
		this.main=main;
		
		try {
			buffr=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			buffw=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//듣기 ,받기
	//서버의 메세지 받아오기!! (듣기)
	public void listen(){
		String msg=null;
		try {
			msg=buffr.readLine(); //대기상태에 빠지므로 빠르지 않다. 말 걸지 않으면 멈춰있음. 
			main.area.append(msg+"\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//말하기,보내기
	public void send(String msg){
		try {
			buffw.write(main.nickName+"의 말:"+msg+"\n");
			buffw.flush();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public void run() {
		while(true){
			listen();
		}
	}
}
