/*mariadb를 연동하여 레코드를 콘솔에 찍어보자!!
 * 주의) DBMS 제조사가 제공하는 드라이버를
 * 		미리 준비하자!!
 * */
package mariadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class selectTest {
	String driver="org.mariadb.jdbc.Driver";
	String url="jdbc:mariadb://localhost:3306/db0331";
	String user="root";
	String password=""; //조심)공백처리하지 말것..
	Connection con=null; //접속정보를 가진 인터페이스
	PreparedStatement pstmt=null; //쿼리문 수행객체!!
	ResultSet rs; //쿼리문이 select 문일 경우
	//원격지(오라클서버가있는곳)의 데이터베이스의 테이블과 동일한 결과집합을
	//담아놓는 객체 (=표와같다)
	//메모리에 뜨자마자 포인터가 테이블위에 올라가있다
	//김민정을 가리키려면 , 포인터를 제어해야 한다
	//next() 메서드를 통해 , row 에서 다음칸으로 이동, 다음칸으로 이동하면서 존재여부 판단
	
	public selectTest() {
		/*
		 * 1.드라이버를 로드
		 * 2.접속하라
		 * 3.원하는 커리문 실행
		 * 4.db 관련된 자원 닫기
		 * */
		try {
				Class.forName(driver);
				System.out.println("로드성공");
			
				con=DriverManager.getConnection(url,user,password);
			
				if(con!=null){
					System.out.println("접속 성공");
					
					String sql="select * from member";
					pstmt=con.prepareStatement(sql);
					//쿼리 수행후 반환되는 결과집합을 받자
					//왜? select 문이니깐!!
					rs=pstmt.executeQuery();
					
					//rs.next() --> 값이 true 이니깐!!
					while(rs.next()){
						//커서 한칸 전진!!
						int member_id=rs.getInt("member_id");
						String name=rs.getString("name"); //컬럼에 해당하는 값 반환
						
						int age=rs.getInt("age");
						
						System.out.println(member_id+","+name+","+age+"살");
					}
					
				}else{System.out.println("접속 실패"); 
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("로드실패");
			}finally{
				if(rs!=null){
					try {
						rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
				if(pstmt!=null){
					try {
						pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				if(con!=null){try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
				
			}
	}
	
	public static void main(String[] args) {
		new selectTest();
	}

}
