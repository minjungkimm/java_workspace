/*JTable이 수시로 정보를 얻어가는 컨트롤러*/
package Oracle;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class MyModel extends AbstractTableModel{
	Vector columnName; //컬럼의 제목을 담을 백터
	Vector<Vector> list; //레코드를 담을 이차원 백터
	//데이터도 없음 , 비어있음 , rs에서 넘겨줄거야
	
	//백터를 만들어서 생성자를 통해 넘겨주기만 한다
	public MyModel(Vector list, Vector columnName) {
		this.list=list;
		this.columnName=columnName;
	}
	
	@Override
	public int getColumnCount() {
		
		return columnName.size();
	}
	
	//컬럼명 주자!!!
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
		//테이블이 만들어지기 전에 rs 가 이차원백터화 되어있어야 한다
		//이차원 백터 를 필요로 한다..
		Vector vec=list.get(row);
		return vec.elementAt(col);
	}
	
	
	//row,col 에 위치한 셀을 편집가능하게 한다..
	@Override
	public boolean isCellEditable(int row, int col) {
	//true 해놓으면 , (0,0) 부터 차례로 물으면서 수정가능한지 묻게될때마다 모든 물음에 true 대답
		return true;
		//변경 시 데이터 체인지되라

	}
	
	@Override
	public void setValueAt(Object value, int row, int col) {
		//층 , 호수를 변경한다
		Vector vec = list.get(row);
		vec.set(col,value);
		this.fireTableCellUpdated(row, col); //시점문제 중요하다!!
	}
	
}
