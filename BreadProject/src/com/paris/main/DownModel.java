/*하위카테고리에 등록된 상품정보 제공모델*/
package com.paris.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class DownModel extends AbstractTableModel{
	Vector <String>columnName= new Vector<String>();
	Vector <Vector> data = new Vector<Vector>();
	Connection con;
	
	public DownModel(Connection con) {
		this.con=con;
		
		columnName.add("product_id");
		columnName.add("subcategory_id");
		columnName.add("product_name");
		columnName.add("price");
		columnName.add("img");
	}
	
	//마우스로 유저가 클릭할 때마다 아이디값이 바뀌므로,
	//아래의 메서드를 그때마다 호출하자!!
	public void getList(int subcategory_id){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from product";
		sql+=" where subcategory_id=?";
		
		try {
			pstmt=con.prepareStatement(sql);
			//바인더할때 sql문의 자료형 살리기
			pstmt.setInt(1, subcategory_id);
			//첫번째 물음표=1 을,subcategory_id
			rs=pstmt.executeQuery();
			
			//백터들 초기화
			data.removeAll(data);
			
			System.out.println("getList 컬럼의 크기는?"+columnName.size());
			
			while(rs.next()){
				Vector vec= new Vector();
				vec.add(rs.getInt("product_id"));
				vec.add(rs.getString("subcategory_id"));
				vec.add(rs.getString("product_name"));
				vec.add(rs.getString("price"));
				vec.add(rs.getString("img"));
				
				data.add(vec);
				
			}
			System.out.println("getList 레코드의 크기는?"+data.size());
			
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
		System.out.println(" 컬럼의갯수는?"+columnName.size());
		return columnName.size();
	}


	public int getRowCount() {
		System.out.println("레코드의 갯수는?"+data.size());
		return data.size();
	}
	
	@Override
	public String getColumnName(int col) {
		
		return columnName.get(col);
	}

	public Object getValueAt(int row, int col) {
		//객체는 출력대상이 아니다, 주소값이 나온다
		//근데 왜 우리는 찍어보고 있을까?
		Object value=data.get(row).get(col);
		System.out.println("getValue호출"+value);
		return value;
	}

}
