package test;

import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

public class ResvModel extends AbstractTableModel{
	HotelMain main;
	Vector <String>columnName = new Vector<String>();
	Vector <Vector>data = new Vector<Vector>();
	Connection con;
	
	public ResvModel(HotelMain main,Connection con){
		this.main=main;
		this.con=con;
		getList();
		
	}
	
	public void getList(){
				PreparedStatement pstmt=null;
				ResultSet rs=null;
				
				String sql="select room_number from room order by room_number asc";
				
				try {
					pstmt=con.prepareStatement(sql);
					rs=pstmt.executeQuery();
					
					//백터들을 초기화하자
					//data.removeAll(data);
					
					
					//컬럼명 추출하자
					ResultSetMetaData meta = rs.getMetaData();
					for(int i=1; i<=meta.getColumnCount(); i++){
						columnName.add(meta.getColumnName(i));
					}
					
				
					while(rs.next()){
						//레코드 한건을 백터에 옮겨심자
						//여기서 백터는 DTO 역할..
						Vector vec = new Vector();
						
						vec.add(rs.getInt("room_number"));
						
						data.add(vec);
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				} finally{
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
							e.printStackTrace();
						}
					}
				}
				
	}

	public int getColumnCount() {
		return columnName.size();
	}

	public int getRowCount() {
		return data.size();
	}

	public String getColumnName(int col) {
		return columnName.get(col);
	}
	
	public Object getValueAt(int row, int col) {
		return data.get(row).get(col);
	}
}
