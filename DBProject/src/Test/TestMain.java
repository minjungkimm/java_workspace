/*
 * --자바언어로 데이터 베이스 연동
 * --오라클 , mariadb
 * 우리가 사용중인 데이터베이스 제품은 
 * 모두 DBMS이다!!
 * DB(저장소) MS(관리시스템)- 네트워크기반
 * 이라서, 원격접속이 가능하다!!
 * 저장소는 보통 원통 모양으로 표현..
 * 평상시에는 데이터베이스 접속 클라이언트 (SQLPLUS,Toad) 로 들어갔다..
 * 오라클은 서버!!
 *
 *현재 사용중인 네트워크 프로토콜은 TCP/IP 기반이므로,
 *원격지의 호스트를 접속하려면 그 호스트의 주소를 알아야 하는데, 기반이
 *TCP/IP 인지라 IP 주소를 알아야 한다
 **/

package Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//sql 중에서 db 연동된 패키지에 연관되어있구나...
public class TestMain {
	public static void main(String[] args) {
		//1단계 - 오라클을 자바가 제어할 수 있는 코드가 들어있는
		// jar 파일을 메모리에 로드해야한다.. 이런 데이터베이스 제어
		// jar 파일을 자바에서는 "드라이버"라 한다!!!
		//드라이버는 db 제조사에서 제공한다..
		//oracle --> 오라클사
		//mysql --> 오라클사
		//mssql --> MS
		//2단계 - 오라클에 접속하자!!
		
		//드라이버 클래스 로드
		//희안한게 스트링형으로 넣으면 됨
		Connection con=null;
		PreparedStatement pstmt=null; 
		//지역변수인데, try 문보다는 밖에있으므로 사용가능..
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로드 성공");
														
			try {				//url 은 sun사 지정 , 암기사항 //jdbc/기종/방식/@~어디어디서버(나자신:localhost)/채널 (오라클:1521)
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "batman", "1234");
				if(con!=null){
					System.out.println("접속성공!");
					
					//현재 유저가 보유한 테이블에 insert
					String sql="insert into company(company_id,brand) values(seq_company.nextval,'나이키')";
					//쿼리문 수행을 위해서는 쿼리문을 전담 하는
					//객체를 이용해야 하는데, 이 객체가 바로
					//PreparedStatement 인터에피스이다
					pstmt=con.prepareStatement(sql);
					int result=pstmt.executeUpdate(); //쿼리문 실행메서드!! //성공여부 위해 반환형
					//이 쿼리문 수행에 의해 반영된 레코드의 수를 반환해준다!!
					//insert 문은 언제나 1개 성공- 1 , 실패-0
					if(result==1){
						System.out.println("입력성공");
					}else{
						System.out.println("입력실패");
					}
					
				}else{
					System.out.println("접속실패!");
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버를 찾을 수 없습니다.");
			e.printStackTrace();
		}finally {
			//스트림과 DB연동 작업 후엔 반드시 닫는 처리를 해야한다!!
			//pstmt 와 con 닫자
			try {
				if(pstmt!=null){
				pstmt.close();
				}
				System.out.println("접속이 닫혔습니다.");
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("닫히지않았습니다.");
			}
			try {
				if(con!=null){
				con.close();
				}
				System.out.println("접속이 닫혔습니다.");
			} catch (SQLException e) {
				System.out.println("닫히지않았습니다.");
				e.printStackTrace();
			}
		}
	}
}
