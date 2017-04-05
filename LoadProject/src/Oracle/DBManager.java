package Oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
	//자료형 선언.. 간접적으로 new 를 하기위해서
	//instance 선언위해 static 
	static private DBManager instance;
	private String driver="oracle.jdbc.driver.OracleDriver";
	private String url="jdbc:oracle:thin:@localhost:1521:XE";
	private String user="batman";
	private String password="1234";
	
	Connection con; //접속 후 , 그정보를 담는 객체
	
	//new 막기위함
	private DBManager(){
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,user,password);
			
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}	
	}
	
	//인스턴스를 new 하지않고 호출하기 위해서
	static public DBManager getInstance(){
		if(instance==null){
			//null 이라는 if 문을 주지않으면, 한번만 생성되는 싱글톤을 벗어나므로
			//if 문 추가
			instance = new DBManager();
		}
		return instance;
	}
	
	//접속객체 반환 
	public Connection getConnection(){
		return con;
	}
	
	//접속해제 
	public void disConnect(Connection con){
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
	}
	
}
