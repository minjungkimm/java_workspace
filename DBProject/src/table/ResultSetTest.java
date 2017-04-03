/*���ڵ� ����� �迭�� ���� ���� ����
 *���ڵ��� �� ������ �˼��� ����..
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
//C connectivity --- �ڹ��� �����ͺ��̽� ���� ���
public class ResultSetTest {
	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	String user="batman";
	String password="1234";
	
	Connection con; //���ӽõ�X, ������ ����
								//�� ����� ��� ��ü
								//����� ������� �������� �ִ�.
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
	
	//���ѻ� ���� �������̽�
	
	//���ڵ�� ��ü�� �̿��Ͽ� �� ���ڵ� ��
	//�˾Ƹ��� ����!!
	public ResultSetTest() {
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,user,password);
			if(con!=null){
				String sql="select * from company";
				//rs�� Ŀ���� ������, �Ĺ��� ������ �����Ӱ� �����̰ų�
				//�Ѳ����� �ǳʶٰ� �Ϸ���, ��ũ�� ������ ����ɼ��� �ο��ؾ� �Ѵ�
				//select ���� ��������� ������� ���� ���⸸ �� �Ÿ�, READ_ONLY ��,
				//������ ���ҰŸ�, UPDATABLE ��
				//�� ����� SELECT ���� ���� ���ڵ�� �б������̴�!!
				
				//��ũ���� �����̰�, �Ѳ����� �ǳʶٱ� ���� ���
				pstmt=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
				
				//rs=pstmt.executeQuery();
				rs=pstmt.executeQuery();
				
				//���� ������ ���ڵ�� ������
				rs.last();
				int num=rs.getRow();//����Ŀ���� ����Ű�� ���ڵ� ��ȣ!!
				//�� ���ڵ� ��ġ!!
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
