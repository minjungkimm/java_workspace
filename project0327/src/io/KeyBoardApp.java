/*
FileInputStream 등은 개발자가 원하는 시점에
스트림을 생성할 수 있지만 , 키보드와 같은 표준 입력 하드웨어의 경우엔
자바가 스트림을 생성하지 못하고 해당 OS가 관리하므로, 자바 개발자는
OS로 부터 표준입력 스트림을 얻어와야 한다..

자바의 클래스 중 System 클래스의 static 멤버변수 중
즉 has a 관계로 보유한 InputStream 형
in 객체가 바로 표준입력 스트림을 받아놓은 클래스이다
따라서 사용시엔 그냥 System.int;

바이트기반 스트림은 한글이 깨지니까 이때 필요한게 문자기반 스트림!!

문자기반 스트림 클래스의 이름 규칙
입력 : ~~Reader 
출력 : ~~Writer 

문자는 바이트 기반이다
바이트를 좁은 빨대 < 문자기반을 넓은 빨대 꽂은걸로 비유..

*/


package io;
import java.io.InputStream;

import java.io.IOException;
import java.io.InputStreamReader;

class KeyBoardApp{
	public static void main(String[] args){
		InputStream is=System.in;

		//문자기반 스트림은 단독으로 존재하는 것이 아니라,
		//이미 바이트 기반 스트림을 전제로 한다..
		//따라서 생성시 생성자의 인수에 바이트 기반 스트림을 넣는다..
		InputStreamReader reader=null;
		//문자열 기반의 입력 스트림
		reader=new InputStreamReader(is);

		int data;
		try{
			while(true){
				data=reader.read();
				//data=is.read(); //1byte 읽어들임 //한글은 깨지고, 영문은 안깨지게됨
				//바이트기반 스트림은 한글이 깨지니까 이때 필요한게 문자기반 스트림!!
				System.out.println((char)data);
			//system이 보유한 out 이라는 static 멤버변수 
			//a를치고 enter 쳤으면 a,\n,\r 값인 3byte 가 나와야하는데..
			//readt는 1byte 만 나오니깐
			//총 3번 출력되어야 나온다 --> while 문으로 돌린다..
			//문자형으로 바꾸면 a는 그대로 a 나오고,  \n 은 기능상으로만 나와서
			//한줄 내려오고(줄바꿈), \r 커서앞으로옮기기 --> 특수문자는 육안으로 보는게 아니라 기능담당이라서 출력되지만 기능만 적용됨!! 
			}
		}catch(IOException e){
			
		}
	}

}
