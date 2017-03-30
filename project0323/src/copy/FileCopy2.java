/*
예외처리의 목적
- 비정상 종료의 방지(즉 안정적인 시스템 운영을 목적)

일반적으로 프로그램이 정상수행될수 없는 상황을 카리켜
"에러"라 한다

sun에서는 에러에 대한 나름 분류를 했다. 클래스를 지원..

1. 프로그래머가 대처할 수 없는 불가항력적 에러
	-Error 
2. 프로그래머가 대처할 수 있는 에러
	-예외
	자바의 관심 사항은 바로 "예외"이다.
	sun에서는 이 예외를 상황에 따라 체계적인 클래스로
	지원하고 있다.

	이 예외 객체들을 다시 크게 2가지 유형으로 분류
	(1) 컴파일 타임에 예외처리를 강요하는 경우
		checked Exception (개발자가 코드를 작성할때부터 강요한다..)
	(2) 컴파일 타임에 예외처리를 강요하지 않는 경우
		unchecked Exception = Runtime Exception

--- 스프링 시간에 다시할것!!

try catch 문은 컴파일러가 쓰라고 할때 쓰면 된다!!

*/
package copy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

class FileCopy2{
	FileInputStream fis; //파일 대상으로한 입력 스트림
	FileOutputStream fos; //파일 대상으로한 출력 스트림
	
	public FileCopy2(){
		//아래의 코드는 장차, 에러가 발생할 수 있는 가능성이 다분하다..
		//따라서, 개발자가 문법을 잘 작성했음에도 불구하고, 특별한
		//안전장치를 마련하기를 강요한다!!
		try{
			fis=new FileInputStream("C:/Java_workspace2/project0323/res/dorayaki.jpg");
				//System.out.println("파일을 스트림 생성했어요");
			fos=new FileOutputStream("C:/Java_workspace2/project0323/data/dorayaki_2.jpg");
				//스트림이 빈 파일을 만든다, 만들파일 경로와, 파일명 넣자
			int data;
			while(true){ 
				data=fis.read(); //1byte 를 읽자!!
				//FileCopy2.java:44: error: unreported exception IOException; must be caught or declared to be thrown
				//입출력 시 예외가 발생할 수 있다.. catch 문 하나 더추가하자!!
				fos.write(data); //1byte 를 쓰자!! //읽고 쓴 파일의 스트림은 한번쓰면 삭제되어야 한다 // 그렇지않으면 메모리의 누수가 발생!!
				//읽어들인 데이터를 내뱉어보자!!
				if(data==-1)break;
				System.out.println(data);
			}
			
		}catch(FileNotFoundException e){//에러가 발생하면 실행부가 이영역으로 진입된다!!
			//catch 문을 수행하게 되면, 프로그램이 비정상 종료 되지 않는다!!
			//사용자에게 안내하는 용도도 catch문을 사용하게 된다..
			System.out.println("파일을 찾을 수 없습니다");
			//catch 문이 없다는 비정상종료 된다..
			//예외처리의 목적이 뭐입니까? 비정상종료의 방지!!(★★)
		
		}catch(IOException e){
			System.out.println("파일을 읽을 수 없습니다");
		}finally{
			//finally 를 선언하면, 
			//try문을 수행하던, catch 문을 수행하던
			//실행부가 무조건 이 영역을 거치게 되어있다..
			//그러므로, 마무리 짓는 코드는 보통 여기로..
			//finally 코드의 사용목적
			/*
			주로 database 연동과 스트림 사용 시
			성공여부를 떠나서 무조건 자원을 닫거나,
			마무리 하려면 try문이든지 catch 문이든지 상관없이
			무조건 거쳐가야 할 코드영역을 두기 위함이다..
			*/
			try{
				if(fis!=null){fis.close();}
				//fis 가 선언되지않으면 ,close 안되게
				//fis 의 스트림을 끊어버리겠다 - 스트림 연결해제!! //예외사항 다시 발생!!	
			
			}catch(IOException e){
				
			}//fis.close() 끝줄
			try{	

				if(fos!=null){fos.close();};//fos 의 스트림을 끊어버리자..

			}catch(IOException e){
			
			}

		}

	}
	
	public static void main(String[] args){
		new FileCopy2();
	}

}