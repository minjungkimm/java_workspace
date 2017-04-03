//emp ���̺��� �����͸� ó���ϴ� ��Ʈ�ѷ�!!
package oracle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.table.AbstractTableModel;
//�������̽� �������Ѵ�, �ʹ��� ���Ƽ� ���߿��� �����Ѵ�!!
public class EmpModel extends AbstractTableModel{
	//ǥ�μ� ���� �⺻���� 3���� �޼��尡 �����Ѵ�..
	//�츮�� ��񿬵��� ���� �ҷ��� ������ �����´�..	
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	String[] column; //�÷��� �����迭!!
	String[][] data; //���ڵ带 �����迭!!
	//������ �迭�� ũ��� ���� �˼�����!! ���̺� ���� �ۼ��ɰž�
	
	//1. �����ڿ��� ��񿬵� ���� ����
	public EmpModel(Connection con) {
		this.con=con;
		/*1. ����̹��ε�
		 * 2. ����̹�����
		 * 3. ������ �ۼ�
		 * 4. ���� �ݱ�(���� �ڿ� ��� �ݱ�)
		 * */
		try {
			
			//���ӿϷ�Ȱ� Ȯ���Ϸ���?
			if(con!=null){
			 
			 String sql="select * from emp";
			 //Ŀ���� �����ο��... ��ũ�� �����ϰ�.. �бⰡ����..
			 //��� �ΰ� �߰�����
			 //�Ʒ��� pstmt �� ���� �����Ǵ� rs �� Ŀ�Ż� �����ο�� �ִ�..
			 pstmt=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			 rs=pstmt.executeQuery(); //������չ�ȯ
			 
			 //�÷��� ���غ���!!
			 ResultSetMetaData meta=rs.getMetaData(); //��Ÿ��� �ϸ� ���� �� ��ü
			 //��Ÿ�����ʹ� ��������
			 int count=meta.getColumnCount(); //�÷��ǰ���
			 column=new String[count]; //�÷����� �迭 �غ�!!
			 
			 //�÷����� ä����!!
			 for(int i=0; i<column.length; i++){
				 column[i]=meta.getColumnName(i+1);
				 //meta ��°�ü�� �÷��� ��ȯ���ش�.. (��ȣ�ȿ��� index , �ٵ� 1���ͽ����ϴϱ� +1)
			 }
			 
			 rs.last(); //���� ���������� ����
			 int total=rs.getRow(); //���ڵ��ȣ
			 rs.beforeFirst(); //ù��°�δٽÿ���..
			 
			 //�� ���ڵ� ���� �˾����� , ������ �迭 �����غ���!!
			 //�÷��� �������� �þ���� ���ݾ�!!
			 data = new String[total][column.length];
			 
			 //���ڵ带 �������迭�� data �� ä���ֱ�..
			
			 for(int a=0; a<data.length; a++){ //������ŭ
				 	rs.next(); //���������̵�!!
				 for(int i=0; i<data[a].length; i++){ //ȣ����ŭ
					 data[a][i]=rs.getString(column[i]);
					 //�÷����� column[i]; ....
					 //�����ͺ��̽��� �ڷ����� ��ġ�����ʾƵ��ȴ�
					 
				 }
				 
			 }
			
			 
			}
		} catch (SQLException e) {
			System.out.println("����̹� ���� ����");
			e.printStackTrace();
		}finally{
			if(rs!=null){
			  try {
				rs.close();
			} catch (SQLException e) {
				System.out.println("rs �ȴ���");
				e.printStackTrace();
			}
			}
			if(pstmt!=null){
				  try {
					rs.close();
				} catch (SQLException e) {
					System.out.println("pstmt �ȴ���");
					e.printStackTrace();
				}
				}

		}
		
	}
	
	@Override
	public int getColumnCount() {
	
		return column.length;
	}
	
	//�⺻ 3���� �޼��� �ܿ� �÷����� �������ִ� �޼��� �߰�!!
	@Override
	public String getColumnName(int index) {
		
		return column[index];
	}

	@Override
	public int getRowCount() {
		
		return data.length;
	}

	@Override
	public Object getValueAt(int row, int col) {
		
		return data[row][col];
	}
		
}
