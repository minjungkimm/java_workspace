/*swing �� ������Ʈ �� ������ ���̽��� ���������
 *�ð�ȭ �ϱ⿡ ����ȭ�� ������Ʈ�� �ִµ�
 *JTable �̴�!!
 * 
 *���ڵ��� ������ ���� �迭�� ũ�⸦ �����ؼ�
 *������ ����*/

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

public class TableTest2 extends JFrame{
	JTable table;
	JScrollPane scroll;
	
	String driver="oracle.jdbc.driver.OracleDriver";
	//url �� ������Ʈ���� �ٸ���.. ǥ���� �˾Ƶ���!!
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	String user="batman"; //��������
	String password="1234";//�н��������
	
	//�����ڷ��Ͽ��� ������ �ٲ��� �ڵ尡 �ٲ����ʰ� �Ѵ�..
	
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null; //select���� ��츸 �ʿ���
							//��? ����� ��ƾ� �ϹǷ�..
	
	String[][] data; //���ڵ尡 ä���� ����
	String[] column={
			"empno","ename","mgr","hiredate","sal","comm","deptno","job"
			};
	
	public TableTest2() {
		loadData();
		//���̺��� ������������� �����Ϳ������� ����!!
		//�޼���λ��� !!
		
		table = new JTable(data,column);
		scroll = new JScrollPane(table);
		
		add(scroll);
		setVisible(true);
		setSize(800, 600);
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
				
				String sql="select * from emp";  //���׷��̵�Ϸ�
				pstmt=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
				rs=pstmt.executeQuery();
				
				//rs�� last()�� ������, ��ġ�� ����
				rs.last();
				int total=rs.getRow();
				
				//rs ���󺹱�
				rs.beforeFirst(); //�ƹ��͵� ����Ű�� �ʴ� ����
				
				//�ֱ����� ������ �迭���� ��������
				//��,ȣ���� ������Ű�� �� �ӻ��ϴ�.. ���Ľð��� �����
				data = new String[total][column.length];
				
				int index=0; //����
				
				while(rs.next()){
					//�����̸Ӹ� Ű ����
					int empno=rs.getInt("empno");
					String ename=rs.getString("ename");
					String job=rs.getString("job");
					int mgr=rs.getInt("mgr");
					String hiredate=rs.getString("hiredate");
					int sal=rs.getInt("sal");
					String comm=rs.getString("comm");
					int deptno=rs.getInt("deptno");
					
					//wrapper Ŭ���� �̿�
					data[index][0]=Integer.toString(empno);
					data[index][1]=ename;
					data[index][2]=job;
					data[index][3]=Integer.toString(mgr);
					data[index][4]=hiredate;
					data[index][5]=Integer.toString(sal);
					data[index][6]=comm; //���� ���� null�� �����ؾ� �ϱ⶧���� string ������
					data[index][7]=Integer.toString(deptno);
					
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
		new TableTest2();
	}
}
