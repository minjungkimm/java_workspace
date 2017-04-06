/*JTable�� ���÷� ������ ���� ��Ʈ�ѷ�*/
package Oracle;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class MyModel extends AbstractTableModel{
	Vector columnName; //�÷��� ������ ���� ����
	Vector<Vector> list; //���ڵ带 ���� ������ ����
	//�����͵� ���� , ������� , rs���� �Ѱ��ٰž�
	
	//���͸� ���� �����ڸ� ���� �Ѱ��ֱ⸸ �Ѵ�
	public MyModel(Vector list, Vector columnName) {
		this.list=list;
		this.columnName=columnName;
	}
	
	@Override
	public int getColumnCount() {
		
		return columnName.size();
	}
	
	//�÷��� ����!!!
	@Override
	public String getColumnName(int col) {
	
		return (String)columnName.elementAt(col);
	}
	
	@Override
	public int getRowCount() {
	
		return list.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		//���̺��� ��������� ���� rs �� ����������ȭ �Ǿ��־�� �Ѵ�
		//������ ���� �� �ʿ�� �Ѵ�..
		Vector vec=list.get(row);
		return vec.elementAt(col);
	}
	
	
	//row,col �� ��ġ�� ���� ���������ϰ� �Ѵ�..
	@Override
	public boolean isCellEditable(int row, int col) {
	//true �س����� , (0,0) ���� ���ʷ� �����鼭 ������������ ���Եɶ����� ��� ������ true ���
		//������ �༭ ������ ����/�Ұ��� ������..
		boolean flag=false;
		if(col==0){
			flag=false;
		}else{
			flag=true;
		}
		
		return flag;
		//���� �� ������ ü�����Ƕ�

	}
	
	@Override
	public void setValueAt(Object value, int row, int col) {
		//�� , ȣ���� �����Ѵ�
		Vector vec = list.get(row);
		vec.set(col,value);
		this.fireTableCellUpdated(row, col); //�������� �߿��ϴ�!!
	}
	
}
