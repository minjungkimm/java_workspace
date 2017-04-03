/*mariadb�� �����Ͽ� ���ڵ带 �ֿܼ� ����!!
 * ����) DBMS �����簡 �����ϴ� ����̹���
 * 		�̸� �غ�����!!
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
	String password=""; //����)����ó������ ����..
	Connection con=null; //���������� ���� �������̽�
	PreparedStatement pstmt=null; //������ ���ఴü!!
	ResultSet rs; //�������� select ���� ���
	//������(����Ŭ�������ִ°�)�� �����ͺ��̽��� ���̺�� ������ ���������
	//��Ƴ��� ��ü (=ǥ�Ͱ���)
	//�޸𸮿� ���ڸ��� �����Ͱ� ���̺����� �ö��ִ�
	//������� ����Ű���� , �����͸� �����ؾ� �Ѵ�
	//next() �޼��带 ���� , row ���� ����ĭ���� �̵�, ����ĭ���� �̵��ϸ鼭 ���翩�� �Ǵ�
	
	public selectTest() {
		/*
		 * 1.����̹��� �ε�
		 * 2.�����϶�
		 * 3.���ϴ� Ŀ���� ����
		 * 4.db ���õ� �ڿ� �ݱ�
		 * */
		try {
				Class.forName(driver);
				System.out.println("�ε强��");
			
				con=DriverManager.getConnection(url,user,password);
			
				if(con!=null){
					System.out.println("���� ����");
					
					String sql="select * from member";
					pstmt=con.prepareStatement(sql);
					//���� ������ ��ȯ�Ǵ� ��������� ����
					//��? select ���̴ϱ�!!
					rs=pstmt.executeQuery();
					
					//rs.next() --> ���� true �̴ϱ�!!
					while(rs.next()){
						//Ŀ�� ��ĭ ����!!
						int member_id=rs.getInt("member_id");
						String name=rs.getString("name"); //�÷��� �ش��ϴ� �� ��ȯ
						
						int age=rs.getInt("age");
						
						System.out.println(member_id+","+name+","+age+"��");
					}
					
				}else{System.out.println("���� ����"); 
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("�ε����");
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
