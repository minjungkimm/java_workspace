/*
 * JTable�� ������ �г�
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

public class TablePanel extends JPanel{
	Connection con;
	JTable table;
	JScrollPane scroll;
	//������ ���̺� ���� �����͸����� ����..
	TableModel model;
	
	//Vector ArrayList �Ѵ� ����
	//������? ����ȭ ��������
	Vector list = new Vector();
	Vector <String> columnName = new Vector<String>();
	
	//book Ŭ���� ����
	int cols;
	
	public TablePanel() { //�������̽��ϱ� �ڽ��� ���Ѵ�..
		//db ����
		this.con=con;
		
		
		table = new JTable();
		scroll = new JScrollPane(table);
		add(scroll);
		
		setPreferredSize(new Dimension(650, 550));
		setBackground(Color.PINK);
	}
	
	//�����ڴ� ������ �� , �Ϲݸ޼���� �޼��� ȣ���Ҷ�
	public void setConnection(Connection con){
		this.con=con;
		
		init();
		
		//���̺� ���� JTable �� ����
		model = new AbstractTableModel() {
			
			@Override
			public int getRowCount() {
				return list.size();
			}
			
			@Override
			public int getColumnCount() {
				return cols;
			}
			
			//JTable �� ȣ���ϴ� �޼���
			@Override
			public Object getValueAt(int row, int col) {
				Vector vec = (Vector)list.get(row);
				
				return vec.elementAt(col);
			}
			
		};
		
		//���̺� �� ����
		table.setModel(model);
	}
	
	//book ���̺��� ���ڵ� ��������
	public void init() {
		String sql="select * from book order by book_id asc";
		//pstmt �� con�� ������,, con ��������
	
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			cols=rs.getMetaData().getColumnCount();
			
			
			//rs�� ������ �÷����� DTO�� �Űܴ���!!
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
			System.out.println("������ ����");
			e.printStackTrace();
		}finally{
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		
	}
}
