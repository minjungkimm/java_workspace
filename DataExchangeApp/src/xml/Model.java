package xml;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class Model extends AbstractTableModel{
	Vector<String> columnName = new Vector<String>();
	Vector<Vector> data = new Vector<Vector>();
	
	
	@Override
	public String getColumnName(int col) {
		
		return columnName.get(col);
	}
	
	@Override
	public int getColumnCount() {
		
		return columnName.size();
	}

	@Override
	public int getRowCount() {
		
		return data.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		
		return data.get(row).get(col);
	}

}
