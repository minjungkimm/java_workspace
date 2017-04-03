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
	
	JPanel p_west; //좌측 등록폼
	JPanel p_center; //우측 영역 전체
	JPanel p_north; //우측 선택 모드 영역
	JPanel p_table; //JTable 이 붙여질 패널
	JPanel p_grid; //그리드가 붙여질 패널
	Choice ch_top;
	Choice ch_sub;
	JTextField t_name;
	JTextField t_price;
	Canvas can;
	JButton bt_regist;
	CheckboxGroup group;
	Checkbox ch_table, ch_grid;
	Toolkit kit=Toolkit.getDefaultToolkit();
	//일종의 싱글톤
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
			@Override //Toolkit 과 icon 제외하고 이미지만을 띄울수 있을까?
			public void paint(Graphics g) {
				//ImageIO 사용해보자
				//ImageIO.read(); 어플리케이션 내의 사진 등록.. (카카오톡 이미지같은)
				g.drawImage(img,0,0,140,140,this);
				
			}
			
		};
		
		//파일 추저 올리기
		chooser = new JFileChooser("c:/html_workspace/images");
		
		can.setPreferredSize(new Dimension(150, 150));
		
		bt_regist = new JButton("등록");
		
		group = new CheckboxGroup();
		ch_table = new Checkbox("JTable",group,false);
		ch_grid = new Checkbox("Grid",group,false);
		
		
		ch_top.setPreferredSize(new Dimension(130, 45));
		ch_sub.setPreferredSize(new Dimension(130, 45));
		//ch_top.add("▼상위카테고리");//상위는 맨처음 무언가가 채워져 있어야하고,
		//ch_sub.add("▼하위카테고리");//하위는 상위가 선택된다음에..
		
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
		//초이스 컴포넌트에 최상위 목록 보이기!!
		con=manager.getConnection();
		String sql="select * from topcategory";
		
		try {
			
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				ch_top.add(rs.getString("category_name"));
			} //굳이 커서를 움직일 필요가없다..
			//커서를 자유롭게 움직여야 하는 이유는 배열의 크기를 만들기 위해서였다!!
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					System.out.println("rs 끊기 실패");
					e.printStackTrace();
				}
			}
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					System.out.println("pstmt 끊기 실패");
					e.printStackTrace();
				}
			}
		}

	}
	
	//하위 카테고리 가져오기!!
	public void getSub(String v){
		//기존에 이미 채워진 아이템이 있다면, 먼저 싹 지운다!!
		ch_sub.removeAll();
		StringBuffer sb = new StringBuffer();
		sb.append("select * from subcategory");
		sb.append(" where topcategory_id=(");
		//하나 더 붙히기전에 한칸 뛴거옝ㅅ!!!
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
					System.out.println("rs 끊기 실패");
					e.printStackTrace();
				}
			}
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					System.out.println("pstmt 끊기 실패");
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
	
	//그림 파일 불러오기
	public void openFile(){
		
		int result=chooser.showOpenDialog(this);
		if(result==JFileChooser.APPROVE_OPTION){
			//열기창에서 확인 버튼을 누르면..
			//선택한 이미지를 캔버스에 그릴 것이다.
			File file=chooser.getSelectedFile();
			img=kit.getImage(file.getAbsolutePath());
			can.repaint();
		}
	}
	
	public static void main(String[] args) {
		new BookMain();
	}


}
