/*키보드에 관련된 스트림은 개발자가 만드는 것이 아니라, OS 가 미리 만들어놓는다.
 * 키보드건 파일이건 OS가 제어한다.
 * 키보드에 대해서는 기존에 배운 스트림과 달리 이미 Iterator 이 존재한다..
 * 시스템으로부터 얻어 오기만 하면된다..*/
package editor;

import java.io.IOException;
import java.io.InputStream;

public class KeyBoardTest {
	
	
	public static void main(String[] args) {
		/*KeyBoard 는 개발자가 원할 때 생성할 수 있는 스트림이 아니라,
		 *이미 시스템에서 컴퓨터 켤때, 미리 얻어놓기 때문에
		 *개발자는 이미 존재하는 스트림을 얻어와 사용만 하면된다!!
		 *자바에서는 OS로부터 스트림을 이미 얻어와서 
		 *System 클래스의 멤버변수인 in 변수에 받아 놓았다..
		 * 기존에 배운 스트림 - 개발자가 원할 때 올릴 수 있다
		 * 이번에 배우는 스트림 - 컴퓨터를 키면 이미 올라와 있다 - 이미존재하는 스트림을 얻어온다
		 *
		 *자바는 하드웨어를 직접 제어하지 않고, 하드웨어 자체는 현 시스템을 운영하는 OS가 제어하므로, 하드웨어에 대한
		 *입력스트림은 자바가 아닌 OS가 이미 제어해놓고 있다 따라서 자바언어를 이용하여, 키보드, 스캐너, 기타등등의
		 *입력 하드웨어의 값을 얻기위해서는 각 하드웨어의 알맞는 스트림 클래스가 지원되는 게 아니라,
		 *오직 표준 입력 스트림인 InputStream 을 쓰면 된다!!
		 *표준입력도구 하드웨어 에는 제한이 있다..*/
		InputStream is=System.in;
		//윈도우에 의존적인 것은 모두 최상위객체인 InputStream 으로 받아 쓸수 있다.
		//윈도우가 
		//인스턴스를 만들지 말고, 갖다쓰기만 할수있다. 자료형은 InputStream(추상클래스)
		//sun사에서 Stream 객체 중 최상위객체.. 
		int data;
		try {
			//read()메서드는 사용자의 입력이 있을 때까지 
			//블럭상태에 빠진다!!!!
			//블럭상태란 대기상태를 말한다!!
			while(true){//read 메서드는 스트림내에 존재하는 건 모조리 읽어들인다.
				data=is.read(); //1byte 읽기 //System.out 
				System.out.print((char)data); //char형인 경우 문자데이터만 나온다.
				//엔터의 두가지 기능 1.줄바꿈 2. 커서를 앞으로 옮기기
			}
		} catch (IOException e) {
			e.printStackTrace();
		} //쉬프트+알트+Z
	}
}