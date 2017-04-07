/*	1.������ �Ѱ��� �α�
 * �����ͺ��̽� ���� ������
 * �ߺ��ؼ� �������� �ʱ� ���ؼ�
 * (db������ �ϴ� ������ Ŭ��������..)
 * 
 *  2.�ν��Ͻ��� ������ �Ѱ��� �ֺ���!
 *  ���ø����̼� ���� �� �����Ǵ� Connection ��ü��
 *  �ϳ��� �����ϱ� ����
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
		/*1.����̹� �ε�
		 * 2. ����
		 * */
		try {
			//Ŭ���� �� ���� ������ Class��!!
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
	
	//�Ű������� ����°� �����ž�!!
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
