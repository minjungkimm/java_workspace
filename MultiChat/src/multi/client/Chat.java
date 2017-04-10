/*이 클래스는 데이터베이스 용
 * 테이블 Chat 이라는 테이블의
 * 레코드 1건 담기위한 클래스로서
 * 이러한 목적의 객체를 가리켜 DTO,VO
 * 라 부른다..
 * 
 * <현실에 존재하는 사물에 대한 표현>
 * 언어           						DB
 * Class              --> 			테이블
 * instance          --> 		   	레코드
 * 객체의 속성(멤버변수) --> 		컬럼
 * */
package multi.client;

public class Chat { //<--> 테이블
	
	private int chat_id;
	private String name;
	private String ip;
	
	public int getChat_id() {
		return chat_id;
	}
	public void setChat_id(int chat_id) {
		this.chat_id = chat_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}

}
