/*
 *스윙의 컴포넌트 중 데이터베이스의 결과집합을 시각화하기에 최적화된 컴포넌트가 있는데 
 *그게 바로 JTable이다
 *
 *레코드의 갯수에 따라 배열의 크기를 지정해서 개발해 보자!!
 * */
package table;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
 
public class TableTest3 extends JFrame{
	JTable table;
	JScrollPane scroll;
	
	//기종이 바껴도 소스는 동일하다.
	String driver="oracle.jdbc.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	String user="batman";
	String password="1234";
	
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs; //select 문인 경우에만 필요하다. 왜? 결과를 담아야 하므로
	
	String[][] data;
	String[] column={
			"empno","ename","job","mgr","hiredate",
			"sal","comm","deptno"
			};
	
	
	public TableTest3() {
		//setLayout(new FlowLayout());
		loadData(); //데이터가 만들어지기 직전에 디비 연동
		table=new JTable(data,column);
		scroll=new JScrollPane(table);
		add(scroll);
 
		setSize(800,600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	
		
	}
	
	//레코드 채워넣기!!!
	//테이블을 생성하기 전에, mariadb연동하여 
	//member 테이블의 레코드를 이차원 배열에 담아놓자
	//왜?? JTable의 생성자의 인수로 이차원배열이 사용되니까
	public void loadData(){
		/*
		 * 1단계-드라이버 로드
		 * 2단계-접속
		 * 3단계-쿼리문 작성
		 * 4단계-데이터베이스 닫기
		 * */
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url, user, password);
			System.out.println("로드 성공!");
			
			if(con!=null){
				System.out.println("접속 성공!");
				
				String sql="select * from emp";
				pstmt=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
				
				rs=pstmt.executeQuery();
				
				//rs를 last로 보내고, 위치를 묻자
				rs.last();
				int total=rs.getRow();
				
				//rs 원상복구
				rs.beforeFirst(); //아무것도 가리키지 않는 상태 
				
				//이차원 배열 생성
				data=new String[total][column.length]; //배열은 크기 고정됨
				int index=0;
				
				while(rs.next()){
					int empno=rs.getInt("empno");
					String ename=rs.getString("ename");
					String job=rs.getString("job");
					int mgr=rs.getInt("mgr");
					String hiredate=rs.getString("hiredate");
					int sal=rs.getInt("sal");
					String comm=rs.getString("comm"); //없는 값은 null로 생각해야 하기 때문에 객체인 String으로
					int deptno=rs.getInt("deptno");
					
					
					data[index][0]=Integer.toString(empno);
					data[index][1]=ename;
					data[index][2]=job;
					data[index][3]=Integer.toString(mgr);
					data[index][4]=hiredate;
					data[index][5]=Integer.toString(sal);
					data[index][6]=comm;
					data[index][7]=Integer.toString(deptno);
					
					index++;
					
					
					
					
				}
					
			}else{
				System.out.println("접속 실패");
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println("로드 실패");
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
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
					
					e.printStackTrace();
				}
			}
			if(con!=null){
				try {
					con.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		new TableTest3();
 
	}
 
}