/*서버의 메세지를 실시간 청취하기 위해서는
 * while 문으로 readLine() 을 실행해야 한다
 * 따라서 메인쓰레드도 이 작업을 시도하면
 * 메인쓰레드가 while문에서 빠져나오지 못하므로,
 * 모든 UI가 멈춰있게 된다...
 * 해결책) 별도의 쓰레드로 처리하자!!
 * */
package client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import javax.swing.JTextArea;

public class ClientThread extends Thread{
	
	Socket socket;  //종이컵
	BufferedReader buffr;
	BufferedWriter buffw;
	boolean flag=true;
	Thread thread;
	JTextArea area;
	
	public ClientThread(Socket socket,JTextArea area) {
		this.socket=socket;
		this.area=area;
		try {
			buffr=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			buffw=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch (IOException e) {
			e.printStackTrace();
	}
	}
	
	//듣기
	public void listen(){
		String msg=null;
		try {
			msg=buffr.readLine();
			area.append(msg+"\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	//말하기
	public void send(String msg){
		try {
			buffw.write(msg+"\n");
			buffw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void run() {
		while(flag){
			listen();
		}
	}
}
