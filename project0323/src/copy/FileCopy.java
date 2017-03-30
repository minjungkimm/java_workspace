/*특정 디렉토리 안의 파일을 원하는 위치로 복사해본다!!
스트림이란? (Stream)
1.의미 : 흐름을 뜻한다.
 현실에서의 스트림은 그 대상이 물이지만,
 전산에서의 스트림의 대상은 데이터이다!!
 결국 데이터가 흐르는 모습을 가리켜 스트림이라
 한다..

2.종류 : 
 (1)방향에 따른 구분
	입력 : 실행 중인 프로그램으로 데이터가 들어가는 스트림
	대표적 입력도구 : 바코드스캐너, 키보드
	출력 : 실행중인 프로그램에서 데이터가 나오는 스트림
	대표적 출력도구 : 모니터, 인쇄기(입출력동시)

java.io-
FileInputStream(String name) - 파일경로 전체넣기
-------------------------------------------------------
컴파일 했을 때 컴파일러가 무사히 컴파일을 마치면
이 프로그램은 정상 수행이 보장된 것이다.
아니다!! 정상수행을 방해하는 예외사항 발생시 불가..

자바 코드를 작성 후 컴파일 했을 때, 문법의 문제가 없다고 하여
그 프로그램은 언제나 정상수행을 보장해주지는 않는다..
예) 파일의 경로를 잘못 적은 경우 (문법X,데이터 문제)
	--> 컴파일은 제대로 되었으나, 실행 시 에러발생
		  해서 비정상 종료
예) 방금 전까지는 파일이 존재해서 제대로 프로그램이
수행되고 있었는데, 누군가가 나쁜 마음을 먹고 파일을 지워버린 경우
프로그램으로 감당 할 수 없는 외부 요인..
	--> 실행 시 에러발생해서 비정상 종료
비정상 종료 시 상당한 손실 가능성...
예외 exception 
*/
package copy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javax.swing.JOptionPane;
import javax.swing.JFrame;


class FileCopy extends JFrame{
	
	FileInputStream fis;
	//String ori="C:/Java_workspace2/project0323/res/dorayaki.jpg"; - 정상
	String ori="C:/Java_workspace2/project0323/res/dorayaki_2.jpg"; //오류 반응 테스트를 위한 잘못된 경로
	public FileCopy(){
		setSize(300,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//fis=new FileInputStream(ori);
		//파일경로만 잘못되면 밑의 대롱이 생성되지 못하고 비정상 작동..
		//sun 에서는 try문에서 에러가 발생한 경우
		//프로그램을 비정상 종료 시키지 않기 위해
		//실행부가 catch 문으로 진입하게 하여
		//정상수행을 할 수 있는 기회를 준다..
		//catch문에서는 정상에 대한 복구가 아닌, 에러가 났다는 걸 알려주고 원인을 알려준다..
		try{ //이 코드는 무조건 실행부에 의해 시도된다
		fis=new FileInputStream(ori); //미래에 에러 발생가능한 코드..
				//만일 이 try문 안에서 파일을 찾을 수 없는
				//에러가 발생할 경우, sun FileNotFoundException 객체를
				//메모리에 올리고, 이 인스턴스를 개발자에게 전달해준다.. 왜??
				//그래야 개발자가 에러정보를 이용하여 사용자에게 알맞는 메세지를
				//보여줄 수 있으니깐..
				//catch 문을 적기 
		}catch(FileNotFoundException e){ //안전장치!!
				//FileNotFoundException: 이것도 sun사에서 만든 클래스이다
				JOptionPane.showMessageDialog(this,"파일을 찾을 수 없습니다.");
		}
	}

	public static void main(String[] args){
		new FileCopy();
	}
}
