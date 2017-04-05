package book.나;

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
	
	JPanel p_west; //좌측 등록폼
	JPanel p_content; //우측 영역 전체
	JPanel p_north; //우측 선택 모드 영역
	JPanel p_center; //Flow가 적용되어 , p_table, p_grid 
	//모두 존재시켜놓을 컨테이너역할
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
	File file;
	TablePanel tablepanel;
	//html option 과는 다르므로, Choice 컴포넌트의
	//값을 미리 받아놓자!!
	//우리가 담을 객체 하나하나는 서브카테고리!!
	//이 컬렉션은 rs 객체를 대체할 것이다.
	//그럼으로서 얻는 장점?? 
	//더이상 rs.last, rs.getRow 고생하지 말자!!
	
	ArrayList<SubCategory> subcategory = new ArrayList<SubCategory>();
	//String[][] subcategory; 지우고 이제 어레이리스트로..
	//메모리에 생성되는 시점은 국내, 외국도서 선택시점..
	
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
			@Override //Toolkit 과 icon 제외하고 이미지만을 띄울수 있을까?
			public void paint(Graphics g) {
				//ImageIO 사용해보자
				//ImageIO.read(); 어플리케이션 내의 사진 등록.. (카카오톡 이미지같은)
				//사용자가 이미지를 얻어오는게 아니라 , 프로그램 내에서 얻어올때..
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
		
		//초이스 컴포넌트와 연결
		ch_table.addItemListener(this);
		ch_grid.addItemListener(this);
		
		setVisible(true);
		setSize(800,600);
		//setPreferredSize(new Dimension(600,600));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}
	
	//book 테이블의 레코드 받기
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
		//테이블 패널과 그리드 패널에게 Connection 전달
		//변신할거야 !!!!!!!!!!!!!!
		((TablePanel)p_table).setConnection(con);
		((GridPanel)p_grid).setConnection(con);
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
			
			//rs에 담겨진 레코드 1개는 SubCategory 
			//클래스의 인스턴스 1개로 받자!!
			//rs.next();
			
			//텅빈 dto 상태
			//int subcategory_id=rs.getInt("subcategory_id"); //rs에서 이사가자
			//dto.setSubcategory_id(subcategory_id);
			while(rs.next()){
				SubCategory dto = new SubCategory();
				dto.setSubcategory_id(rs.getInt("subcategory_id"));
				dto.setCategory_name(rs.getString("category_name"));
				dto.setTopcategory_id(rs.getInt("topcategory_id"));
				
				subcategory.add(dto); //컬렉션담기!!
				ch_sub.add(dto.getCategory_name()); //가져왓다 카테고리네임을..
			}
			//rs 더이상 필요없다~~ 컬렉션프레임웍 사용하니깐~~
			
			
			/*while(rs.next()){
				ch_sub.add(rs.getString("category_name"));
			}*/
			
			
			//서브카테고리의 정보를 2차원 배열에 
			//담아놓자!! 담기+ 출력
			//subcategory = new String[레코드수][컬럼수];
			//rs 에 들어있는 이차원 배열의 레코드 수 , 컬럼 수
			
			
			
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
	
	//상품 등록 메서드
	@Override
	public void actionPerformed(ActionEvent e) {
		regist();
		
	}
	
	public void regist(){
		//내가 지금 선택한 서브 카테고리 초이스의 index를 구해서
		//그 index 로 ArrayList 를 접근하여, 객체를 반환 받으면
		//정보를 유용하게 쓸수 있다..
		
		int index=ch_sub.getSelectedIndex();
		//array 리스트에서 뭘가져올지
		SubCategory dto=subcategory.get(index);
		//이름 , 아이디값, 프라이머키 .. 들어있다..
		
		String book_name=t_name.getText();//책이름 
		//자료형이 안맞으니깐 //int 를 일부러 쓴 이유는.. 자료형의 정확한 명시를위해!!
		int price=Integer.parseInt(t_price.getText());
		String img=file.getName();//파일명
		
		StringBuffer sb = new StringBuffer();
		sb.append("insert into book(book_id,subcategory_id,book_name,price,img)");
		//subcategory_id 는 우리가 선택한대로 가기때문에...
		//배열로 만들어놓자..
		sb.append(" values(seq_book.nextval,"+dto.getSubcategory_id()+",'"+book_name+"',"+price+",'"+img+"')");
		//Blob ??
		
		System.out.println(sb.toString());
		
		//PreparedStatement pstmt = null;
		
		try {
			pstmt=con.prepareStatement(sb.toString());
			//반환형을 먼저 적으면 이클립스가 알아먹는다..
			//SQL문이 DML(insert,delet,update) //변경가할수있다
			int result=pstmt.executeUpdate();
			
			//위의 메서드는 숫자값을 반환하며, 이 숫자값이
			//쿼리에 의해 영향을 받는 레코드수를 반환
			//insert 의 경우 언제나?? 반환될까? 1
			if(result!=0){
				//System.out.println(book_name+"등록성공");
				//ArrayList 나 vector 계열은 지우고 넣어야됨,, 쌓이니깐
				copy();
				
				((TablePanel)p_table).init(); //조회일으키기
				((TablePanel)p_table).table.updateUI(); //UI갱신
				
			}else{System.out.println(book_name+"등록실패");
			}
			
		} catch (SQLException e) {
			System.out.println("쿼리문 실패");
			e.printStackTrace();
		} finally{
			if(pstmt!=null){try {
				pstmt.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}	
			
			}//f 꿑
				
		}
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		Object obj=e.getSource();
		
		if(obj==ch_top){
			Choice ch=(Choice)e.getSource();
			getSub(ch.getSelectedItem());
		}else if(obj==ch_table){
			System.out.println("테이블 볼래?");
			p_table.setVisible(true);
			p_grid.setVisible(false);
		}else if(obj==ch_grid){
			System.out.println("그리드 볼래?");
			p_table.setVisible(false);
			p_grid.setVisible(true);
		}
	}
	

	
	//그림 파일 불러오기
	public void openFile(){
		
		int result=chooser.showOpenDialog(this);
		if(result==JFileChooser.APPROVE_OPTION){
			//열기창에서 확인 버튼을 누르면..
			//선택한 이미지를 캔버스에 그릴 것이다.
			file=chooser.getSelectedFile();
			img=kit.getImage(file.getAbsolutePath());
			can.repaint();
		}
	}
	
	/*이미지복사하기
	*유저가 선택한 이미지를, 개발자 지정한 위치로
	*복사를 해놓자!! */
	public void copy(){
		FileInputStream fis=null;
		FileOutputStream fos=null;
		try {
		fis= new FileInputStream(file);
		
		String filename=file.getName();
		String dest="C:/Java_workspace2/DBProject2/data/"+filename;
		
		fos= new FileOutputStream(dest);
		
		int data; //읽어들인 데이터가 x, 갯수가 들어있다..
		
		//data 를 1024 크기만큼 빨아들인 후 1024 채워지만 읽는다!!
		//읽어들인 데이터는 여기에
		byte[] b= new byte[1024]; //[] 용량 크기는 개발자가 정할수있다 //1024 1kByte
			while(true){
				data=fis.read(b); //실제데이터는 byte 에 들어있다..
				if(data==-1)break;
				fos.write(b);
			}
			JOptionPane.showMessageDialog(this, "등록완료");
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
