package book;
 
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
 
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
 
public class BookMain extends JFrame implements ItemListener, ActionListener{
	Connection con;
	DBManager manager=DBManager.getInstance();
	PreparedStatement pstmt;
	ResultSet rs;
	
	JPanel p_west; //���� �����
	JPanel p_content; //���� ���� ��ü
	JPanel p_north; //���� ���� ��� ����
	JPanel p_center; //Flow�� ����Ǿ� p_table, p_grid �� ��� ������� ���� �����̳� ����!!
	JPanel p_table; //JTable �� �ٿ��� �г�
	JPanel p_grid; //�׸��尡 �ٿ��� �г�
	Choice ch_top;
	Choice ch_sub;
	JTextField t_name;
	JTextField t_price;
	Canvas can;
	JButton bt_regist;
	CheckboxGroup group;
	Checkbox ch_table, ch_grid;
	Toolkit kit=Toolkit.getDefaultToolkit(); //�̰͵� ������ singleTon����
	Image img;
	JFileChooser chooser;
	File file;
 
	
	//html option���� �ٸ��Ƿ�, Choice ������Ʈ�� ���� �̸� �޾Ƴ���!!
	//�� �÷�����  rs ��ü�� ��ü�� ���̴�
	//����? ���̻� rs.last, rs.getRow�� ������� ����!
	ArrayList<SubCategory> subcategory=new ArrayList<SubCategory>();
	
	public BookMain() {
		setLayout(new BorderLayout());
		
		p_west = new JPanel();
		p_content = new JPanel();
		p_north = new JPanel();
		p_center= new JPanel();
		
		p_table = new TablePanel();
		p_grid = new GridPanel();
		
		ch_top = new Choice();
		ch_sub = new Choice();
		
		t_name = new JTextField(12);
		t_price = new JTextField(12);
		URL url=this.getClass().getResource("/deil.jpg");
		try {
			img=	ImageIO.read(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		can = new Canvas(){
			public void paint(Graphics g) {
				g.drawImage(img,0, 0, 140, 140, this);
			}
		};
		can.setPreferredSize(new Dimension(150, 150));
		
		bt_regist = new JButton("���");
		
		group = new CheckboxGroup();
		ch_table = new Checkbox("JTable",group,false);
		ch_grid = new Checkbox("Grid",group,false);
		
		//���� ���� �ø���
		chooser=new JFileChooser("C:/html_workspace/images");
		
		ch_top.setPreferredSize(new Dimension(130, 45));
		ch_sub.setPreferredSize(new Dimension(130, 45));
		//ch_top.add("�����ī�װ�");//������ ��ó�� ���𰡰� ä���� �־���ϰ�,
		//ch_sub.add("������ī�װ�");//������ ������ ���õȴ�����..
		
		p_west.add(ch_top);
		p_west.add(ch_sub);
		p_west.add(t_name);
		p_west.add(t_price);
		p_west.add(can);
		p_west.add(bt_regist);
		p_west.setBackground(Color.WHITE);
		p_west.setPreferredSize(new Dimension(150, 600));
		add(p_west,BorderLayout.WEST);
		
		//������ ����
		p_north.add(ch_table);
		p_north.add(ch_grid);
		
		
		p_center.setBackground(Color.YELLOW);
		p_center.add(p_table);
		p_center.add(p_grid);
		
		//p_north.setPreferredSize(new Dimension(650, 100));
		p_content.add(p_north,BorderLayout.NORTH);
		p_content.add(p_center);
		p_content.setPreferredSize(new Dimension(400, 600));
		add(p_content);
		
		init();
		ch_top.addItemListener(this);
		can.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				openFile();
				
			}
			
		});
		
		bt_regist.addActionListener(this);
		
		//���̽� ������Ʈ�� ������ ����
		ch_table.addItemListener(this);
		ch_grid.addItemListener(this);
		
		
		setVisible(true);
		setSize(800,600);
		//setPreferredSize(new Dimension(600,600));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}
	
	private void init() {
		//���̽� ������Ʈ�� �ֻ��� ��� ���̱�!!
		con=manager.getConnection();
		String sql="select * from topcategory order by topcategory_id asc";
		
		try {
			
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				ch_top.add(rs.getString("category_name"));
			} //���� Ŀ���� ������ �ʿ䰡����..
			//Ŀ���� �����Ӱ� �������� �ϴ� ������ �迭�� ũ�⸦ ����� ���ؼ�����!!
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					System.out.println("rs ���� ����");
					e.printStackTrace();
				}
			}
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					System.out.println("pstmt ���� ����");
					e.printStackTrace();
				}
			}
		}
		
		//���̺� �гΰ� �׸��� �гο��� Connection ����
		((TablePanel)p_table).setConnection(con); //p_table�� �ڷ����� JPanel�̹Ƿ� �ڽİ� ���� TablePanel������ ����
		((GridPanel)p_grid).setConnection(con);
	}
	
	//���� ī�װ� ��������!!
	public void getSub(String v){
		//������ �̹� ä���� �������� �ִٸ�, ���� �� �����!!
		ch_sub.removeAll();
		StringBuffer sb = new StringBuffer();
		sb.append("select * from subcategory ");
		sb.append(" where topcategory_id=(");
		//�ϳ� �� ���������� ��ĭ �ڰŞ���!!!
		sb.append("select topcategory_id from");
		sb.append("  topcategory where category_name='"+v+"') order by subcategory_id asc"); //order by where�� �� ����
		
		System.out.println(sb.toString());
		
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			pstmt=con.prepareStatement(sb.toString());
			rs=pstmt.executeQuery();
			
			//rs�� ����� ���ڵ� 1���� SubCategory Ŭ������ �ν��Ͻ� 1���� ����!!
			while(rs.next()){
			SubCategory dto=new SubCategory();
				dto.setSubcategory_id(rs.getInt("subcategory_id"));
				dto.setCategory_name(rs.getString("category_name"));
				dto.setTopcategory_id(rs.getInt("topcategory_id"));
				
				subcategory.add(dto); //�÷��ǿ� ���!!
				ch_sub.add(dto.getCategory_name());
			}
			
			//DB���� ���̺��� �ڹ��� ��Ǫ�� ����. emp���̺� scott�� ������ �̰��� �ν��Ͻ�
			//����ī�װ��� ������ 2���� �迭�� ��� + ���
			//���̺��� ��������� Ŭ������ ���ο� �α�.
			//->ex) subcategory ���ڵ带 subcategoryŬ������ ��Ǫ�����κ��� �¾ �ν��Ͻ�, 
			//Ŭ������ �ݵ�� ������ �����ϴ� ���� �ƴ϶� �ν��Ͻ��� �����ϱ⵵ ��.
		 //[���ڵ� ��][�÷� ��]
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		} finally{
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					System.out.println("rs ���� ����");
					e.printStackTrace();
				}
			}
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					System.out.println("pstmt ���� ����");
					e.printStackTrace();
				}
			}
		}
	}
	
	//��ǰ ��� �޼���
	public void regist(){
		//���� ���� ������ ���� ī�װ� ���̽��� index�� ���ؼ�, �� index�� ArrayList�� �����Ͽ� ��ü�� ��ȯ������
		//������ �����ϰ� �� �� �ִ�.
		int index=ch_sub.getSelectedIndex();
		SubCategory dto=subcategory.get(index);
	
		String book_name=t_name.getText();//å�̸�
		int price=Integer.parseInt(t_price.getText()); //������ �ȿ� ���� String������ �޾������� �ڷ����� ��Ȯ�� ����ϴ� ���� ����!
		String img=file.getName(); //���ϸ�
		
		
		StringBuffer sb=new StringBuffer();
		
	
		sb.append("insert into book(book_id, subcategory_id, book_name, price, img)"); //img�� �̸��� �ְ� �ϵ��ũ�� ���� ������ ����
		sb.append("values(seq_book.nextval,"+dto.getSubcategory_id()+",'"+book_name+"',"+price+",'"+img+"')");
		
		//ȭ�鿡�� ����������
		
		
		System.out.println(sb.toString());
		
		PreparedStatement pstmt=null;
		try {
			pstmt=con.prepareStatement(sb.toString());
			
			//SQL���� DML(insert, delete, update) ������ ���۾��� ���
			int result=pstmt.executeUpdate(); 
			
			//���� �޼���� ���ڰ��� ��ȯ�ϸ�, �� ���ڰ��� �� ������ ���� ������ �޴� ���ڵ� ���� ��ȯ�Ѵ�
			//insert�� ��� ������ 1�� ��ȯ�ȴ�
			if(result!=0){
				//System.out.println(book_name+"��� ����");				
				copy();
				
				((TablePanel)p_table).init(); //��ȸ ����Ŵ
				((TablePanel)p_table).table.updateUI();; //UI ����
				
			}else{
				System.out.println(book_name+"��� ����");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		
	}
 
	public void itemStateChanged(ItemEvent e) {
		Object obj=e.getSource();
		if(obj==ch_top){
			Choice ch=(Choice)e.getSource();
			getSub(ch.getSelectedItem());
		}else if(obj==ch_table){
			//System.out.println("���̺� ����?");
			p_table.setVisible(true);
			p_grid.setVisible(false);
		}else if(obj==ch_grid){
			//System.out.println("�׸��� ����?");
			p_table.setVisible(false);
			p_grid.setVisible(true);
		}
		
	}
	
	//�׸����� �ҷ�����
	public void openFile(){
		int result=chooser.showOpenDialog(this);
		
		if(result==JFileChooser.APPROVE_OPTION){
			//������ �̹����� canvas�� �׸����̴�!
			file=chooser.getSelectedFile();
			img=kit.getImage(file.getAbsolutePath());
			can.repaint();
			
		}
	}
	
	/*�̹��� �����ϱ�
	������ ������ �̹�����, �����ڰ� ������ ��ġ�� ���縦 �س���!
	*/
	public void copy(){
		FileInputStream fis=null;
		FileOutputStream fos=null;
		
		try {
			fis=new FileInputStream(file);
			
			String filename=file.getName();
			String dest="C:/java_workspace2/DBProject2/data/"+filename;
			fos=new FileOutputStream(dest);
			
			int data; //�о���� �����Ͱ� ���� ����. ������ ��. 
			byte[] b=new byte[1024]; //�ѹ� ���� �� 1 KByte �� �аڴ� ,[�뷮]�����ڰ� ���� �� ����..
			while(true){
				data=fis.read(b); // read(byte[] b) ->������ ���� , �ӵ� ���� , �迭�� ���� ������ ���Ƶ���->���� �����ʹ� byte�� ��
				fos.write(b); //write(byte[] b)
				if(data==-1)break;
			}
			JOptionPane.showMessageDialog(this, "��� �Ϸ�");
		} catch (FileNotFoundException e) {
			System.out.println("������ ã�� �� �����ϴ�");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("������ ���� �� �����ϴ�");
			e.printStackTrace();
		}finally{
			if(fos!=null){
				try {
					fos.close();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			}
			if(fis!=null){
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
 
	
	
	public void actionPerformed(ActionEvent e) {
		//System.out.println("�� ����?");
		regist();
	
		
	}
	
	public static void main(String[] args) {
		new BookMain();
	}
 
 
 
}