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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BookMain extends JFrame implements ItemListener{
	Connection con;
	DBManager manager=DBManager.getInstance();
	PreparedStatement pstmt;
	ResultSet rs;
	
	JPanel p_west; //���� �����
	JPanel p_center; //���� ���� ��ü
	JPanel p_north; //���� ���� ��� ����
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
	
	public BookMain() {
		setLayout(new BorderLayout());
		
		p_west = new JPanel();
		p_center = new JPanel();
		p_north = new JPanel();
		
		p_table = new JPanel();
		p_grid = new JPanel();
		
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
		//p_north.setBackground(Color.YELLOW);
		p_north.setPreferredSize(new Dimension(650, 100));
		p_center.add(p_north,BorderLayout.NORTH);
		
		p_center.add(p_table);
		p_center.add(p_grid);
		p_center.setPreferredSize(new Dimension(400, 600));
		add(p_center);
		
		init();
		ch_top.addItemListener(this);
		can.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				openFile();
			}
		});
		
		setVisible(true);
		setSize(800,600);
		//setPreferredSize(new Dimension(600,600));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}
	
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
			while(rs.next()){
				ch_sub.add(rs.getString("category_name"));
			}
			
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
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		Choice ch=(Choice)e.getSource();
		getSub(ch.getSelectedItem());
		
	}
	
	//�׸� ���� �ҷ�����
	public void openFile(){
		
		int result=chooser.showOpenDialog(this);
		if(result==JFileChooser.APPROVE_OPTION){
			//����â���� Ȯ�� ��ư�� ������..
			//������ �̹����� ĵ������ �׸� ���̴�.
			File file=chooser.getSelectedFile();
			img=kit.getImage(file.getAbsolutePath());
			can.repaint();
		}
	}
	
	public static void main(String[] args) {
		new BookMain();
	}


}
