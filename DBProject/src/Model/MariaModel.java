//�� ��ü�� JTable�� �����ڿ��� �䱸�ϴ�
//��Ʈ�ѷ� ��ü�̴�.
//�� ��ü�� ������ �����ΰ� ������ �и������ִ�
//�߰��� ����....
package Model;

import javax.swing.table.AbstractTableModel;

public class MariaModel extends AbstractTableModel{
	String driver="oracle.jdbc.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	String user="batman";
	String password="1234";
	
	String[][] data=new String[3][3];
	
	public MariaModel() {
		data[0][0]="û����";
		data[0][1]="�����ٳ�";
		data[0][2]="2000";
		
		data[1][0]="�����";
		data[1][1]="���";
		data[1][2]="5000";
		
		data[2][0]="ġ��";
		data[2][1]="����Ű";
		data[2][2]="50000";
		
	}
	
	//�÷��� ������ ��ȯ
	@Override
	public int getColumnCount() {

		return data[0].length;
	}
	//���ڵ��� ������ ��ȯ
	@Override
	public int getRowCount() {

		return data.length;
	}
	
	//Ư�� ��ġ�� ���� ��ȯ
	@Override
	public Object getValueAt(int row, int col) {
		//System.out.println("row="+row+",col="+col+"�̴�");
		return data[row][col];
	}

}