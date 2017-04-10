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
		//대화를 나눌 스트림 뽑기
			try {
				buffr=new BufferedReader(new InputStreamReader(socket.getInputStream()));
				buffw= new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			} catch (IOException e) {
				
				e.printStackTrace();
			}
	}
	 //듣고
	 public void listen(){
		 String msg=null;
		 try {
			msg=buffr.readLine();//죽자마자 바로 send
			main.area.append(msg+"\n");
			send(msg); //곧 바로 다시 보내기
		} catch (IOException e) {
			flag=false; //현재쓰레드 죽여버리기
			
			//벡터에서 이 쓰레드를 제거
			main.list.remove(this); //나자신이 쓰레드니깐.. 나자신을 죽이자
			main.area.append("1명 퇴장 후 현재 접속자"+main.list.size()+"\n");
			System.out.println("읽기 불가 \n");
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} 
		 
	 }
	 //말하고
	 public void send(String msg){
		 try {
			//현재접속한자 전부
			//접속한자의 전부는? 어떻게 구할까,,
			//-> 정보.. 비영구적이고, 임시적인것 계속해서 변하니깐!!
			//나갔다 들어왔다 반복
			//ArrayList 와 vector 중에 안정성 있는 vector 를 선택
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
	 

	 
	 //프로그램이 종료될때까지
	 //끝없이 클라이언트의 메세지를 받아와서 다시 보낸다
	 @Override
	public void run() {
		 while(flag){
			 listen();
		 }
	}//
}
