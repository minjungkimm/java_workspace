/*	1.정보를 한곳에 두기
 * 데이터베이스 계정 정보를
 * 중복해서 기재하지 않기 위해서
 * (db연동을 하는 각각의 클래스에서..)
 * 
 *  2.인스턴스의 갯수를 한개만 둬보지!
 *  어플리케이션 가동 중 생성되는 Connection 객체를
 *  하나로 통일하기 위함
 *  
 * */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
	static private DBManager instance;
	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	String user="batman";
	String password="1234";
	private Connection con;
	
	private DBManager() {
		/*1.드라이버 로드
		 * 2. 접속
		 * */
		try {
			//클래스 에 대한 정보가 Class다!!
			Class.forName(driver);
			con=DriverManager.getConnection(url,user,password);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	static public DBManager getInstance() {
		if(instance==null){
			instance = new DBManager();
		}
		return instance;
	}
	
	public Connection getConnection() {
		return con;
	}
	
	//매개변수로 날라온것 닫을거야!!
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
