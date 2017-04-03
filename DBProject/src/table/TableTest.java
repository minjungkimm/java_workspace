/*swing �� ������Ʈ �� ������ ���̽��� ���������
 * �ð�ȭ �ϱ⿡ ����ȭ�� ������Ʈ�� �ִµ�
 * JTable �̴�!!*/
//���α׷� ���ڸ��� �����Ƶ��� �����Ǿ ��Ÿ���Բ�..
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
	//url �� ������Ʈ���� �ٸ���.. ǥ���� �˾Ƶ���!!
	String url="jdbc:mariadb://localhost:3306/db0331";
	String user="root"; //��������
	String password="";//�н��������
	
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null; //select���� ��츸 �ʿ���
							//��? ����� ��ƾ� �ϹǷ�..
	
	String[][] data; //���ڵ尡 ä���� ����
	String[] column={"member_id","name","age"};
	
	public TableTest() {
		loadData();
		//���̺��� ������������� �����Ϳ������� ����!!
		//�޼���λ��� !!
		
		table = new JTable(data,column);
		scroll = new JScrollPane(table);
		
		add(scroll);
		setVisible(true);
		setSize(500, 150);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	//���ڵ� ä���ֱ�!!
	//���̺��� �����ϱ� ���� , mariadb �����Ͽ�
	//member ���̺��� ���ڵ带 ������ �迭�� ��Ƴ���!
	//��? JTable �� �������� �μ��� �������迭�� ���Ǵϱ�!!
	public void loadData(){
		/*
		 * 1�ܰ� - ����̹� �ε�
		 * 2�ܰ� - ����
		 * 3�ܰ� - ���ϴ� ��������
		 * 4�ܰ� - �����ͺ��̽� �ݱ�
		 * */
		
		try {
			
			Class.forName(driver);
			con=DriverManager.getConnection(url,user,password);
			
			System.out.println("�ε强��");
			
			if(con!=null){
				
				System.out.println("���Ӽ���");
				
				String sql="select * from member";
				pstmt=con.prepareStatement(sql);
				rs=pstmt.executeQuery();
				
				//�ֱ����� ������ �迭���� ��������
				//��,ȣ���� ������Ű�� �� �ӻ��ϴ�.. ���Ľð��� �����
				data = new String[3][3];
				
				int index=0; //����
				while(rs.next()){
					//�����̸Ӹ� Ű ����
					int member_id=rs.getInt("member_id");
					String name=rs.getString("name");
					int age=rs.getInt("age");	
					
					//wrapper Ŭ���� �̿�
					data[index][0]=Integer.toString(member_id);
					data[index][1]=name;
					data[index][2]=Integer.toString(age);
					
					index++;
			}
				
			}else{System.out.println("���ӽ���");
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("�ε����");
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
