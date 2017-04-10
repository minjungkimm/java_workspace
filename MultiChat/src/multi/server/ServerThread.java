package multi.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import javax.swing.JTextArea;

public class ServerThread extends Thread{
	 Socket socket;
	 BufferedReader buffr;
	 BufferedWriter buffw;
	 JTextArea area;
	 ServerMain main;
	 ServerThread st;
	 boolean flag=true;
	 
	 public ServerThread(Socket socket,ServerMain main) {
		 this.socket=socket;
		 this.main=main;
		//��ȭ�� ���� ��Ʈ�� �̱�
			try {
				buffr=new BufferedReader(new InputStreamReader(socket.getInputStream()));
				buffw= new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			} catch (IOException e) {
				
				e.printStackTrace();
			}
	}
	 //���
	 public void listen(){
		 String msg=null;
		 try {
			msg=buffr.readLine();//���ڸ��� �ٷ� send
			main.area.append(msg+"\n");
			send(msg); //�� �ٷ� �ٽ� ������
		} catch (IOException e) {
			flag=false; //���羲���� �׿�������
			
			//���Ϳ��� �� �����带 ����
			main.list.remove(this); //���ڽ��� ������ϱ�.. ���ڽ��� ������
			main.area.append("1�� ���� �� ���� ������"+main.list.size()+"\n");
			System.out.println("�б� �Ұ� \n");
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} 
		 
	 }
	 //���ϰ�
	 public void send(String msg){
		 try {
			//������������ ����
			//���������� ���δ�? ��� ���ұ�,,
			//-> ����.. �񿵱����̰�, �ӽ����ΰ� ����ؼ� ���ϴϱ�!!
			//������ ���Դ� �ݺ�
			//ArrayList �� vector �߿� ������ �ִ� vector �� ����
		for(int i=0; i<main.list.size(); i++){
			st=main.list.elementAt(i);
			buffw.write(msg+"\n");
			buffw.flush();
		}
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 

	 
	 //���α׷��� ����ɶ�����
	 //������ Ŭ���̾�Ʈ�� �޼����� �޾ƿͼ� �ٽ� ������
	 @Override
	public void run() {
		 while(flag){
			 listen();
		 }
	}//
}
