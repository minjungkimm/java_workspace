/*1.스트림의 방향성에 따른 분류
 * - 입력, 출력
 * 
 * 2.스트림의 데이터 처리방법에 따른 분류
 * (1)byte 기반 스트림  
 *  - (입출력 시 1byte 씩 처리) 
 * (2)문자 기반 스트림
 * 	 - (입출력시 2byte 씩 묶어서 이해할 수 있는 스트림)
 *  주의!!) 2byte 씩 읽거나 , 쓰는게 아니다!!
 *  문자 기반 스트림의 명명규칙
 *  입력스트림 - ~~Reader 끝남. 
 *  출력스트림 - ~~Writer 끝남.
 *  
 * (3)버퍼 스트림
 *  - ()
 * 
 * */
package editor;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StandardInput {
	
	public static void main(String[] args) {
		//스트림 얻기!!
		InputStream is = System.in;
		InputStreamReader reader=null;
		reader = new InputStreamReader(is);
		//reader 는 byte 기반을 두어야 한다!!
		
		int data;
		
		try {
			data=reader.read(); //1byte 
			//read 메서드는while 문없으면 본래 한자만 읽어들임
			//System.in 과 System.out 은 대표적인
			//표준 입력,    표준출력 이다..
			//in과 out 이라는 변수의 정체는?
			//객체, println(); 이라는 메서드 없이는 문자인지 숫자인지 구분불가
			System.out.print((char)data); //ln이 의미하는 것 줄바꿈
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
}
