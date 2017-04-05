package book.��;

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

public class BookMain extends JFrame implements ItemListener,ActionListener{
	
	Connection con;
	DBManager manager=DBManager.getInstance();
	PreparedStatement pstmt;
	ResultSet rs;
	
	JPanel p_west; //���� �����
	JPanel p_content; //���� ���� ��ü
	JPanel p_north; //���� ���� ��� ����
	JPanel p_center; //Flow�� ����Ǿ� , p_table, p_grid 
	//��� ������ѳ��� �����̳ʿ���
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
	Toolkit kit=Toolkit.getDefaultToolkit();
	//������ �̱���
	Image img;
	JFileChooser chooser;
	File file;
	TablePanel tablepanel;
	//html option ���� �ٸ��Ƿ�, Choice ������Ʈ��
	//���� �̸� �޾Ƴ���!!
	//�츮�� ���� ��ü �ϳ��ϳ��� ����ī�װ�!!
	//�� �÷����� rs ��ü�� ��ü�� ���̴�.
	//�׷����μ� ��� ����?? 
	//���̻� rs.last, rs.getRow ������� ����!!
	
	ArrayList<SubCategory> subcategory = new ArrayList<SubCategory>();
	//String[][] subcategory; ����� ���� ��̸���Ʈ��..
	//�޸𸮿� �����Ǵ� ������ ����, �ܱ����� ���ý���..
	
	public BookMain() {
		setLayout(new BorderLayout());
		p_content = new JPanel();
		p_west = new JPanel();
		p_center = new JPanel();
		p_north = new JPanel();
		
		p_table = new TablePanel();
		p_grid = new GridPanel();
		
		ch_top = new Choice();
		ch_sub = new Choice();
		
		t_name = new JTextField(10);
		t_price = new JTextField(10);
		
		URL url = this.getClass().getResource("/deil.jpg");
		
		try {
			img = ImageIO.read(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		can = new Canvas(){
			@Override //Toolkit �� icon �����ϰ� �̹������� ���� ������?
			public void paint(Graphics g) {
				//ImageIO ����غ���
				//ImageIO.read(); ���ø����̼� ���� ���� ���.. (īī���� �̹�������)
				//����ڰ� �̹����� �����°� �ƴ϶� , ���α׷� ������ ���ö�..
				g.drawImage(img,0,0,140,140,this);
				
			}
			
		};
		
		//���� ���� �ø���
		chooser = new JFileChooser("c:/html_workspace/images");
		
		can.setPreferredSize(new Dimension(150, 150));
		
		bt_regist = new JButton("���");
		
		group = new CheckboxGroup();
		ch_table = new Checkbox("JTable",group,false);
		ch_grid = new Checkbox("Grid",group,false);
		
		
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
		
		p_north.add(ch_table);
		p_north.add(ch_grid);
		
		p_north.setPreferredSize(new Dimension(650, 100));
		
		p_content.add(p_north,BorderLayout.NORTH);
		
		p_center.setBackground(Color.YELLOW);
		
		p_content.add(p_center);
		
		p_center.add(p_table);
		p_center.add(p_grid);
		
		//p_centent.setPreferredSize(new Dimension(400, 600));
		add(p_content);
		
		init();
		ch_top.addItemListener(this);
		can.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				openFile();
			}
		});
		
		bt_regist.addActionListener(this);
		
		//���̽� ������Ʈ�� ����
		ch_table.addItemListener(this);
		ch_grid.addItemListener(this);
		
		setVisible(true);
		setSize(800,600);
		//setPreferredSize(new Dimension(600,600));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}
	
	//book ���̺��� ���ڵ� �ޱ�
	private void init() {
		//���̽� ������Ʈ�� �ֻ��� ��� ���̱�!!
		con=manager.getConnection();
		String sql="select * from topcategory";
		
		try {
			
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				ch_top.add(rs.getString("category_name"));
			} //���� Ŀ���� ������ �ʿ䰡����..
			//Ŀ���� �����Ӱ� �������� �ϴ� ������ �迭�� ũ�⸦ ����� ���ؼ�����!!
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
		//�����Ұž� !!!!!!!!!!!!!!
		((TablePanel)p_table).setConnection(con);
		((GridPanel)p_grid).setConnection(con);
	}
	
	//���� ī�װ� ��������!!
	public void getSub(String v){
		//������ �̹� ä���� �������� �ִٸ�, ���� �� �����!!
		ch_sub.removeAll();
		StringBuffer sb = new StringBuffer();
		sb.append("select * from subcategory");
		sb.append(" where topcategory_id=(");
		//�ϳ� �� ���������� ��ĭ �ڰŞ���!!!
		sb.append("select topcategory_id from");
		sb.append("  topcategory where category_name='"+v+"')");
		
		System.out.println(sb.toString());
		
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			pstmt=con.prepareStatement(sb.toString());
			rs=pstmt.executeQuery();
			
			//rs�� ����� ���ڵ� 1���� SubCategory 
			//Ŭ������ �ν��Ͻ� 1���� ����!!
			//rs.next();
			
			//�ֺ� dto ����
			//int subcategory_id=rs.getInt("subcategory_id"); //rs���� �̻簡��
			//dto.setSubcategory_id(subcategory_id);
			while(rs.next()){
				SubCategory dto = new SubCategory();
				dto.setSubcategory_id(rs.getInt("subcategory_id"));
				dto.setCategory_name(rs.getString("category_name"));
				dto.setTopcategory_id(rs.getInt("topcategory_id"));
				
				subcategory.add(dto); //�÷��Ǵ��!!
				ch_sub.add(dto.getCategory_name()); //�����Ӵ� ī�װ�������..
			}
			//rs ���̻� �ʿ����~~ �÷��������ӿ� ����ϴϱ�~~
			
			
			/*while(rs.next()){
				ch_sub.add(rs.getString("category_name"));
			}*/
			
			
			//����ī�װ��� ������ 2���� �迭�� 
			//��Ƴ���!! ���+ ���
			//subcategory = new String[���ڵ��][�÷���];
			//rs �� ����ִ� ������ �迭�� ���ڵ� �� , �÷� ��
			
			
			
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
	@Override
	public void actionPerformed(ActionEvent e) {
		regist();
		
	}
	
	public void regist(){
		//���� ���� ������ ���� ī�װ� ���̽��� index�� ���ؼ�
		//�� index �� ArrayList �� �����Ͽ�, ��ü�� ��ȯ ������
		//������ �����ϰ� ���� �ִ�..
		
		int index=ch_sub.getSelectedIndex();
		//array ����Ʈ���� ����������
		SubCategory dto=subcategory.get(index);
		//�̸� , ���̵�, �����̸�Ű .. ����ִ�..
		
		String book_name=t_name.getText();//å�̸� 
		//�ڷ����� �ȸ����ϱ� //int �� �Ϻη� �� ������.. �ڷ����� ��Ȯ�� ��ø�����!!
		int price=Integer.parseInt(t_price.getText());
		String img=file.getName();//���ϸ�
		
		StringBuffer sb = new StringBuffer();
		sb.append("insert into book(book_id,subcategory_id,book_name,price,img)");
		//subcategory_id �� �츮�� �����Ѵ�� ���⶧����...
		//�迭�� ��������..
		sb.append(" values(seq_book.nextval,"+dto.getSubcategory_id()+",'"+book_name+"',"+price+",'"+img+"')");
		//Blob ??
		
		System.out.println(sb.toString());
		
		//PreparedStatement pstmt = null;
		
		try {
			pstmt=con.prepareStatement(sb.toString());
			//��ȯ���� ���� ������ ��Ŭ������ �˾ƸԴ´�..
			//SQL���� DML(insert,delet,update) //���氡�Ҽ��ִ�
			int result=pstmt.executeUpdate();
			
			//���� �޼���� ���ڰ��� ��ȯ�ϸ�, �� ���ڰ���
			//������ ���� ������ �޴� ���ڵ���� ��ȯ
			//insert �� ��� ������?? ��ȯ�ɱ�? 1
			if(result!=0){
				//System.out.println(book_name+"��ϼ���");
				//ArrayList �� vector �迭�� ����� �־�ߵ�,, ���̴ϱ�
				copy();
				
				((TablePanel)p_table).init(); //��ȸ����Ű��
				((TablePanel)p_table).table.updateUI(); //UI����
				
			}else{System.out.println(book_name+"��Ͻ���");
			}
			
		} catch (SQLException e) {
			System.out.println("������ ����");
			e.printStackTrace();
		} finally{
			if(pstmt!=null){try {
				pstmt.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}	
			
			}//f �L
				
		}
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		Object obj=e.getSource();
		
		if(obj==ch_top){
			Choice ch=(Choice)e.getSource();
			getSub(ch.getSelectedItem());
		}else if(obj==ch_table){
			System.out.println("���̺� ����?");
			p_table.setVisible(true);
			p_grid.setVisible(false);
		}else if(obj==ch_grid){
			System.out.println("�׸��� ����?");
			p_table.setVisible(false);
			p_grid.setVisible(true);
		}
	}
	

	
	//�׸� ���� �ҷ�����
	public void openFile(){
		
		int result=chooser.showOpenDialog(this);
		if(result==JFileChooser.APPROVE_OPTION){
			//����â���� Ȯ�� ��ư�� ������..
			//������ �̹����� ĵ������ �׸� ���̴�.
			file=chooser.getSelectedFile();
			img=kit.getImage(file.getAbsolutePath());
			can.repaint();
		}
	}
	
	/*�̹��������ϱ�
	*������ ������ �̹�����, ������ ������ ��ġ��
	*���縦 �س���!! */
	public void copy(){
		FileInputStream fis=null;
		FileOutputStream fos=null;
		try {
		fis= new FileInputStream(file);
		
		String filename=file.getName();
		String dest="C:/Java_workspace2/DBProject2/data/"+filename;
		
		fos= new FileOutputStream(dest);
		
		int data; //�о���� �����Ͱ� x, ������ ����ִ�..
		
		//data �� 1024 ũ�⸸ŭ ���Ƶ��� �� 1024 ä������ �д´�!!
		//�о���� �����ʹ� ���⿡
		byte[] b= new byte[1024]; //[] �뷮 ũ��� �����ڰ� ���Ҽ��ִ� //1024 1kByte
			while(true){
				data=fis.read(b); //���������ʹ� byte �� ����ִ�..
				if(data==-1)break;
				fos.write(b);
			}
			JOptionPane.showMessageDialog(this, "��ϿϷ�");
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		} finally{
			if(fis!=null){
				try {
					fis.close();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			}
			if(fos!=null){try {
				fos.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
			}//
		}
	
	}
	
	
	public static void main(String[] args) {
		new BookMain();
	}



}
