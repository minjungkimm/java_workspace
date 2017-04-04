/*
 * JTable이 얹혀질 패널
 * */
package book;

import java.awt.Color;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class TablePanel_min2 extends JPanel{
	Connection con;
	JTable table;
	JScrollPane scroll;
	//오늘은 테이블 모델을 내부익명으로 가자..
	TableModel model;
	
	//Vector ArrayList 둘다 같다
	//차이점? 동기화 지원여부
	Vector <String> list = new Vector<String>();
	Vector <String> columnName = new Vector<String>();
	
	//book 클래스 생성
	int cols;
	
	public TablePanel_min2() { //인터페이스니깐 자식을 뉴한다..
		//db 연동
		this.con=con;
		
		
		table = new JTable();
		scroll = new JScrollPane(table);
		add(scroll);
		
		setPreferredSize(new Dimension(650, 550));
		setBackground(Color.PINK);
	}
	
	//생성자는 생성할 때 , 일반메서드는 메서드 호출할때
	public void setConnection(Connection con){
		this.con=con;
		
		init();
		
		//테이블 모델을 JTable 에 적용
		model = new AbstractTableModel() {
			
			@Override
			public int getRowCount() {
				return list.size();
			}
			
			@Override
			public int getColumnCount() {
				return cols;
			}
			
			//JTable 이 호출하는 메서드
			@Override
			public Object getValueAt(int row, int col) {
				Vector vec = (Vector)list.get(row);
				
				return vec.elementAt(col);
			}
			
		};
		
		//테이블에 모델 적용
		table.setModel(model);
	}
	
	//book 테이블의 레코드 가져오기
	public void init() {
		String sql="select * from book order by book_id asc";
		//pstmt 는 con에 의존적,, con 을얻어오자
	
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			cols=rs.getMetaData().getColumnCount();
			
			
			//rs의 정보를 컬렉션의 DTO로 옮겨담자!!
		while(rs.next()){
			Vector<String> data= new Vector<String>();
			
			data.add(Integer.toString(rs.getInt("book_id")));
			data.add(rs.getString("book_name"));
			data.add(Integer.toString(rs.getInt("price")));
			data.add(rs.getString("img"));
			data.add(Integer.toString(rs.getInt("subcategory_id")));
			
			list.add(data);
		}	
			
		} catch (SQLException e) {
			System.out.println("쿼리문 실패");
			e.printStackTrace();
		}finally{
			if(rs!=null){
				rs.close();
				
			}
		}
		
	}
}
