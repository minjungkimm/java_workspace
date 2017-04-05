package Oracle;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;

public class LoadMain extends JFrame implements ActionListener,TableModelListener{
	JPanel p_north;
	JButton bt_open,bt_load,bt_excel,bt_del;
	JTable table;
	JScrollPane scroll;
	JTextField t_path; //��γ���..
	JFileChooser chooser;
	FileReader reader=null; //finally ���� ��������.. try���ȿ� x
	BufferedReader buffr=null; //���پ� �о�帱 ���̴ϱ�
	
	//������â�� ������ �̹� ������ Ȯ���س���
	Connection con;
	DBManager manager=DBManager.getInstance(); //���Ŵ��� new�Ѱ�
	PreparedStatement pstmt=null;
	Vector<Vector> list;
	Vector columnName;

	public LoadMain() {
		
		p_north = new JPanel();
		t_path = new JTextField(20);
		bt_open = new JButton("���Ͽ���");
		bt_load = new JButton("�ε��ϱ�");
		bt_excel = new JButton("�����ε�"); //����
		bt_del = new JButton("�����ϱ�");
		
		chooser = new JFileChooser("C:/animal"); //�⺻���
		
		table = new JTable();
		scroll = new JScrollPane(table);
		
		p_north.add(t_path);
		p_north.add(bt_open);
		p_north.add(bt_excel);
		p_north.add(bt_load);
		p_north.add(bt_del);
		
		//������Ʈ�� ������ ����
		bt_open.addActionListener(this);
		bt_load.addActionListener(this);
		bt_excel.addActionListener(this);//����
		bt_del.addActionListener(this);
		
		add(p_north,BorderLayout.NORTH);
		add(scroll);
		
		//������ ������ ����
		this.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e) {
				manager.disConnect(con);
			
			}
			
		});
		
		
		setVisible(true);
		setSize(800,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		init();
	}
	
	//Connection ���ٳ���
	public void init() {
		con=manager.getConnection();
		
	}
	
	//���� Ž���� ����
	public void open(){
		//csv ���Ͽ���� ���ϱ����� �޸������� ��� ANSI /������� �� ����
		int result=chooser.showOpenDialog(this);
		//���⸦ ������!! �������Ͽ� ��Ʈ���� ��������
		if(result==JFileChooser.APPROVE_OPTION){
			//��Ʈ�� , �ѱ��� �������ʰ� ���ڱ��
			//������ ������ ����!!
			File file=chooser.getSelectedFile();
			//���ϴ���� ���ڱ�ݽ�Ʈ��..
			t_path.setText(file.getAbsolutePath());
			
			try {
				reader = new FileReader(file);
				buffr = new BufferedReader(reader);
				
				//String data;
				//**����������ϸ� ���븸 ����..
				//**���⸦ ������ ���ϰ� ���Ḹ �� ����
				
				//�̴������� ���� �ε��ϸ� �׶����� ȭ�鿡 ���´�
				
				//���⼭���ʹ� �Է� ����� ���Ƶ��̴� ����
				/*while(true){
					data=buffr.readLine(); 
					if(data==null)break; //string �̴ϱ� null
					System.out.println(data);
					
				}*/
				
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			} 
			
			
		
		}
	}
	
	
	//CSV --> Oracle�� ������ ����(migration)�ϱ�
	//���� ������ �ٽ�
	public void load(){
		System.out.println(buffr);
		//���۽�Ʈ���� �̿��Ͽ� csv�� �����͸�
		//1�پ� �о�鿩 insert ��Ű��
		//���ڵ尡 ���� ������!! 
		//while ������ ������ �ʹ� �����Ƿ�!
		//��Ʈ��ũ�� ������ �� ���⿡ �Ϻη� ������Ű�鼭~~
		String data;
		//while �� ���ư��ϱ� String ����, ������ ���ù����ϰ� ��Ƹ���
		//���������� sb �������
		StringBuffer sb = new StringBuffer();
		
		try {
			while(true){
				data=buffr.readLine();
				// .�� ��� ��ɼ� .�� �ߺ��ɼ� �ֱ⶧���� "\\." ���� ���н����ش�!!
				//ex)tab
				if(data==null)break;
				
				String[] value = data.split(","); //���µ����͸� �и���ų�ž� "," �ĸ������ؼ�
				//�׷��� String ������ ������ ���ð��̴ϱ� -> string �� �迭
				
				//seq ���� �����ϰ� insert �ϰڴ�
				if(!value[0].equals("seq")){ //value ���� "seq" �� ���� ���� �����ʴٸ�!!
					//System.out.println(data);
					sb.append("insert into hospital(seq,name,addr,regdate,status,dimension,type)");
					sb.append(" values("+value[0]+",'"+value[1]+"','"+value[2]+"','"+value[3]+"','"+value[4]+"',"+value[5]+",'"+value[6]+"')");
				
					//������ϴ¹��!!
					//System.out.println(sb.toString());
					pstmt=con.prepareStatement(sb.toString());
					int result =pstmt.executeUpdate();
					
					//missing expression �� ������ �����ϼ� ������ Ȯ���ϼ���
					//������ ������ StringBuffer ��
					//�����͸� ��� �����
					//0�� ���� sb.length �� �������� ����
					sb.delete(0, sb.length());
					
				}else{System.out.println("�� 1���̹Ƿ� ����");
				
				}
			}
			JOptionPane.showMessageDialog(this, "���̱׷��̿Ϸ�");
			
			//JTable ������ ó��!!
			getList(); //������ ������!!
			table.setModel(new MyModel(list, columnName)); //columnName �� �������ȭ
			
			//���̺� �𵨰� �����ʿ��� ����
			//���̺��� ���̺�� //���������ִ¸� ��ȯ���ش�
			//getModel()
			table.getModel().addTableModelListener(this);
			table.updateUI(); //���� �ֽŻ��·� ������Ʈ��..
			
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
		
			e.printStackTrace();
		} finally{
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
		}
	}
	
	//�������� �о db�� ���̱׷��̼� �ϱ�!!
	//javaSE �������� ���̺귯�� �ִ�? X,����!
	//open Source ��������Ʈ����  - ����ġ���� �����ϴ� ���� �ִ�..
	//copyright ������ <---> copyleft ����ȭ�Ǿ���Ѵ� (����ġ ��ü)
	//POT ���̺귯��! http://apache.org
	/*
	 * HSSFWorkbook : ��������
	 * HSSFSheet : sheet 
	 * HSSFRow : row
	 * HSSFCell : cell 
	 * */
	public void loadExcel(){
		int result = chooser.showOpenDialog(this);
		if(result==JFileChooser.APPROVE_OPTION){
			File file=chooser.getSelectedFile();
			FileInputStream fis=null;
			
			
			try {
				fis = new FileInputStream(file);
				
				HSSFWorkbook book=null;
				book =new HSSFWorkbook(fis);
				
				HSSFSheet sheet = null;
				sheet = book.getSheet("sheet1");
				
				//System.out.println(sheet);
				
				//HSSFRow row = sheet.getRow(0);
				//HSSFCell cell = row.getCell(0);
				
				//System.out.println(cell.getStringCellValue());
				int total=sheet.getLastRowNum();
				DataFormatter df = new DataFormatter();
				
				for(int a=1; a<total; a++){
					HSSFRow row = sheet.getRow(a);
					int columnCount = row.getLastCellNum(); //�÷� �� ����
					
					for(int i=0; i<columnCount; i++){
						HSSFCell cell = row.getCell(i);
						//�ڷ����� ���ѵ��� �ʰ� ��� String ó���Ҽ��ִ�..
						String value = df.formatCellValue(cell);
						//String���� ��ȯ���ش�!!
						System.out.print(value); //println �ƴ϶� print �Դϴ�!! ln �� �ٱ�������!!
						//�ٹٲ��� �����Ͼ��?	
					}
					//�ٱ�������..
					System.out.println("");
				}
				
				
			} catch (FileNotFoundException e) {
	
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
			
		}
	}
	
	//��� ���ڵ� ��������
	public void getList(){
		//�𵨰������� ���� select ������ �����;��� �����Ͱ� ���
		String sql="select * from hospital order by seq asc";
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		
		try {
			
			pstmt=con.prepareStatement(sql);
			//rs�� ���縦 ���̺��� �˾ƾ� �Ѵ�
			rs=pstmt.executeQuery();
			//rs�� ���������ͷ� ���� �� ���ٰ��̴�..
			//�ϳ��� ���ڵ� = �ϳ��� ����
			
			//�÷��� ����!!
			ResultSetMetaData meta = rs.getMetaData();
			int count = meta.getColumnCount();
			columnName = new Vector();//�������� 
			
			for(int i=0; i<count; i++){
				columnName.add(meta.getColumnName(i+1));
				//rs �� ������ ���Ϳ��� �����͸� �Ѱ��ְ� , �÷��� �˷��ְ� ��..
			}
			
			//Vector list = new Vector(); //������ ����!! , 1���� ���͸� ���� ��
			list = new Vector<Vector>(); //������ ����!! , 1���� ���͸� ���� ��
			
			//���⼭����
			while(rs.next()){ //Ŀ�� ��ĭ ����~
				Vector vec = new Vector(); //1���� ����, ���ڵ� 1�� ������
				
				//getIndex �� ��밡���ϳ�, �÷���� ��Ȯ�� ��ġ �� �÷��� ��´ٴ� �ǹ̸� �ο��ϱ�����
				vec.add(rs.getString("seq")); 
				vec.add(rs.getString("name"));
				vec.add(rs.getString("addr"));
				vec.add(rs.getString("regdate"));
				vec.add(rs.getString("status"));
				vec.add(rs.getString("dimension"));
				vec.add(rs.getString("type"));
				
				list.add(vec);
			}
			//������� �ϳ��� ���ڵ�!!
			
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
			
		}//
			
	}
	
	//������ ���ڵ� ����
	public void delete(){
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		if(obj==bt_open){
			open();
		}else if(obj==bt_load){
			load();
		}else if(obj==bt_excel){
			loadExcel();
		}else if(obj==bt_del){
			delete();
		}
		
	}
	
	//���̺� ���� �����Ͱ��� ������ �߻��ϸ�
	//�� ������ �����ϴ� ������!
	@Override
	public void tableChanged(TableModelEvent e) {
		System.out.println("�� �مf��!!!");
		//update hospital set �÷��� name = �� where ~ ����ϱ�..
		//������ �� ���� update ���� ����� �����Բ�..
	}
	
	public static void main(String[] args) {
		new LoadMain();
	}

}
