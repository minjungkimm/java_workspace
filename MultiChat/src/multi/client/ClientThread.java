/*�ǽð� û�븦 ����, ���� �����尡 �ƴ�
 * ������ ���� �����带 ������ ������!!*/
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
	
	//��� ,�ޱ�
	//������ �޼��� �޾ƿ���!! (���)
	public void listen(){
		String msg=null;
		try {
			msg=buffr.readLine(); //�����¿� �����Ƿ� ������ �ʴ�. �� ���� ������ ��������. 
			main.area.append(msg+"\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//���ϱ�,������
	public void send(String msg){
		try {
			buffw.write(main.nickName+"�� ��:"+msg+"\n");
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
