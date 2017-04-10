/*
 * --�ڹپ��� ������ ���̽� ����
 * --����Ŭ , mariadb
 * �츮�� ������� �����ͺ��̽� ��ǰ�� 
 * ��� DBMS�̴�!!
 * DB(�����) MS(�����ý���)- ��Ʈ��ũ���
 * �̶�, ���������� �����ϴ�!!
 * ����Ҵ� ���� ���� ������� ǥ��..
 * ���ÿ��� �����ͺ��̽� ���� Ŭ���̾�Ʈ (SQLPLUS,Toad) �� ����..
 * ����Ŭ�� ����!!
 *
 *���� ������� ��Ʈ��ũ ���������� TCP/IP ����̹Ƿ�,
 *�������� ȣ��Ʈ�� �����Ϸ��� �� ȣ��Ʈ�� �ּҸ� �˾ƾ� �ϴµ�, �����
 *TCP/IP ������ IP �ּҸ� �˾ƾ� �Ѵ�
 **/

package Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//sql �߿��� db ������ ��Ű���� �����Ǿ��ֱ���...
public class TestMain {
	public static void main(String[] args) {
		//1�ܰ� - ����Ŭ�� �ڹٰ� ������ �� �ִ� �ڵ尡 ����ִ�
		// jar ������ �޸𸮿� �ε��ؾ��Ѵ�.. �̷� �����ͺ��̽� ����
		// jar ������ �ڹٿ����� "����̹�"�� �Ѵ�!!!
		//����̹��� db �����翡�� �����Ѵ�..
		//oracle --> ����Ŭ��
		//mysql --> ����Ŭ��
		//mssql --> MS
		//2�ܰ� - ����Ŭ�� ��������!!
		
		//����̹� Ŭ���� �ε�
		//����Ѱ� ��Ʈ�������� ������ ��
		Connection con=null;
		PreparedStatement pstmt=null; 
		//���������ε�, try �����ٴ� �ۿ������Ƿ� ��밡��..
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("����̹� �ε� ����");
														
			try {				//url �� sun�� ���� , �ϱ���� //jdbc/����/���/@~����𼭹�(���ڽ�:localhost)/ä�� (����Ŭ:1521)
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "batman", "1234");
				if(con!=null){
					System.out.println("���Ӽ���!");
					
					//���� ������ ������ ���̺� insert
					String sql="insert into company(sequence_id,name,email) values(seq_company.nextval,'�赿��','swatdj')";
					//������ ������ ���ؼ��� �������� ���� �ϴ�
					//��ü�� �̿��ؾ� �ϴµ�, �� ��ü�� �ٷ�
					//PreparedStatement ���Ϳ��ǽ��̴�
					pstmt=con.prepareStatement(sql);
					int result=pstmt.executeUpdate(); //������ ����޼���!! //�������� ���� ��ȯ��
					//�� ������ ���࿡ ���� �ݿ��� ���ڵ��� ���� ��ȯ���ش�!!
					//insert ���� ������ 1�� ����- 1 , ����-0
					if(result==1){
						System.out.println("�Է¼���");
					}else{
						System.out.println("�Է½���");
					}
					
				}else{
					System.out.println("���ӽ���!");
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			System.out.println("����̹��� ã�� �� �����ϴ�.");
			e.printStackTrace();
		}finally {
			//��Ʈ���� DB���� �۾� �Ŀ� �ݵ�� �ݴ� ó���� �ؾ��Ѵ�!!
			//pstmt �� con ����
			try {
				if(pstmt!=null){
				pstmt.close();
				}
				System.out.println("������ �������ϴ�.");
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("�������ʾҽ��ϴ�.");
			}
			try {
				if(con!=null){
				con.close();
				}
				System.out.println("������ �������ϴ�.");
			} catch (SQLException e) {
				System.out.println("�������ʾҽ��ϴ�.");
				e.printStackTrace();
			}
		}
	}
}
