/*레코드 결과를 배열로 받을 때의 단점
 *레코드의 총 갯수를 알수가 없다..
 **/
package table;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//J java
//D data
//B base
//C connectivity --- 자바의 데이터베이스 연동 기술
public class ResultSetTest {
	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	String user="batman";
	String password="1234";
	
	Connection con; //접속시도X, 접속한 이후
								//그 결과를 담는 객체
								//결과를 담았으니 끊을수도 있다.
	PreparedStatement pstmt;
	
	/*PreparedStatement prepareStatement(String sql,
														            int resultSetType,
														            int resultSetConcurrency)
     	throws SQLException
     */
	
	ResultSet rs; // 
	//last()  : Moves the cursor to the last row in this ResultSet object. 
	//getRow() : Retrieves the current row number. 
	//ResultSet.CONCUR_READ_ONLY or ResultSet.CONCUR_UPDATABLE
	
	//삼총사 전부 인터페이스
	
	//레코드셋 객체를 이용하여 총 레코드 수
	//알아맞춰 보자!!
	public ResultSetTest() {
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,user,password);
			if(con!=null){
				String sql="select * from company";
				//rs의 커서를 전방향, 후방향 등으로 자유롭게 움직이거나
				//한꺼번에 건너뛰게 하려면, 스크롤 가능한 상수옵션을 부여해야 한다
				//select 문의 결과집합을 대상으로 단지 보기만 할 거면, READ_ONLY 로,
				//수정을 가할거면, UPDATABLE 로
				//내 경험상 SELECT 문에 의한 레코드는 읽기위함이다!!
				
				//스크롤을 움직이고, 한꺼번에 건너뛰기 위한 상수
				pstmt=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
				
				//rs=pstmt.executeQuery();
				rs=pstmt.executeQuery();
				
				//제일 마지막 레코드로 보내기
				rs.last();
				int num=rs.getRow();//현재커서가 가리키는 레코드 번호!!
				//즉 레코드 위치!!
				System.out.println(num);
				
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	public static void main(String[] args) {
		new ResultSetTest();
	}
	
	
}
