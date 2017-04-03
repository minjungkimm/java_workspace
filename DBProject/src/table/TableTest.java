/*swing 의 컴포넌트 중 데이터 베이스의 결과집합을
 * 시각화 하기에 최적화된 컴포넌트가 있는데
 * JTable 이다!!*/
//프로그램 열자마자 마리아디비와 연동되어서 나타나게끔..
package table;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TableTest extends JFrame{
	JTable table;
	JScrollPane scroll;
	
	String driver="oracle.jdbc.driver.OracleDriver";
	//url 은 프로젝트마다 다르다.. 표준을 알아두자!!
	String url="jdbc:mariadb://localhost:3306/db0331";
	String user="root"; //유저네임
	String password="";//패스워드없음
	
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null; //select문일 경우만 필요함
							//왜? 결과를 담아야 하므로..
	
	String[][] data; //레코드가 채워질 예정
	String[] column={"member_id","name","age"};
	
	public TableTest() {
		loadData();
		//테이블이 만들어지기전에 데이터연동부터 하자!!
		//메서드로빼자 !!
		
		table = new JTable(data,column);
		scroll = new JScrollPane(table);
		
		add(scroll);
		setVisible(true);
		setSize(500, 150);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	//레코드 채워넣기!!
	//테이블을 생성하기 전에 , mariadb 연동하여
	//member 테이블의 레코드를 이차원 배열에 담아놓자!
	//왜? JTable 의 생성자의 인수로 이차원배열이 사용되니깐!!
	public void loadData(){
		/*
		 * 1단계 - 드라이버 로드
		 * 2단계 - 접속
		 * 3단계 - 원하는 쿼리수행
		 * 4단계 - 데이터베이스 닫기
		 * */
		
		try {
			
			Class.forName(driver);
			con=DriverManager.getConnection(url,user,password);
			
			System.out.println("로드성공");
			
			if(con!=null){
				
				System.out.println("접속성공");
				
				String sql="select * from member";
				pstmt=con.prepareStatement(sql);
				rs=pstmt.executeQuery();
				
				//넣기전에 이차원 배열부터 생성하자
				//층,호수를 고정시키는 거 속상하다.. 오후시간에 배우자
				data = new String[3][3];
				
				int index=0; //층수
				while(rs.next()){
					//프라이머리 키 접근
					int member_id=rs.getInt("member_id");
					String name=rs.getString("name");
					int age=rs.getInt("age");	
					
					//wrapper 클래스 이용
					data[index][0]=Integer.toString(member_id);
					data[index][1]=name;
					data[index][2]=Integer.toString(age);
					
					index++;
			}
				
			}else{System.out.println("접속실패");
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("로드실패");
			e.printStackTrace();
			
		}finally{
			if(rs!=null){
				try {
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
				if(pstmt!=null){
					try {
						pstmt.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
				if(con!=null){try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				}
			}
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		new TableTest();
	}
}
