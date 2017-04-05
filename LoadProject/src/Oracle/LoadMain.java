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
	JTextField t_path; //경로넣을..
	JFileChooser chooser;
	FileReader reader=null; //finally 에서 닫으려면.. try문안에 x
	BufferedReader buffr=null; //한줄씩 읽어드릴 것이니까
	
	//윈도우창이 열리면 이미 접속을 확보해놓자
	Connection con;
	DBManager manager=DBManager.getInstance(); //디비매니저 new한것
	PreparedStatement pstmt=null;
	Vector<Vector> list;
	Vector columnName;

	public LoadMain() {
		
		p_north = new JPanel();
		t_path = new JTextField(20);
		bt_open = new JButton("파일열기");
		bt_load = new JButton("로드하기");
		bt_excel = new JButton("엑셀로드"); //엑셀
		bt_del = new JButton("삭제하기");
		
		chooser = new JFileChooser("C:/animal"); //기본경로
		
		table = new JTable();
		scroll = new JScrollPane(table);
		
		p_north.add(t_path);
		p_north.add(bt_open);
		p_north.add(bt_excel);
		p_north.add(bt_load);
		p_north.add(bt_del);
		
		//컴포넌트와 리스너 연결
		bt_open.addActionListener(this);
		bt_load.addActionListener(this);
		bt_excel.addActionListener(this);//엑셀
		bt_del.addActionListener(this);
		
		add(p_north,BorderLayout.NORTH);
		add(scroll);
		
		//윈도우 리스너 연결
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
	
	//Connection 얻어다놓기
	public void init() {
		con=manager.getConnection();
		
	}
	
	//파일 탐색기 띄우기
	public void open(){
		//csv 파일열기시 파일깨지면 메모장으로 열어서 ANSI /모든파일 로 저장
		int result=chooser.showOpenDialog(this);
		//열기를 누르면!! 목적파일에 스트림을 생성하자
		if(result==JFileChooser.APPROVE_OPTION){
			//스트림 , 한글이 깨지지않게 문자기반
			//유저가 선택한 파일!!
			File file=chooser.getSelectedFile();
			//파일대상의 문자기반스트림..
			t_path.setText(file.getAbsolutePath());
			
			try {
				reader = new FileReader(file);
				buffr = new BufferedReader(reader);
				
				//String data;
				//**여기까지만하면 빨대만 생성..
				//**열기를 누르면 파일과 연결만 한 상태
				
				//이다음부터 누가 로드하면 그때부터 화면에 나온다
				
				//여기서부터는 입력 빨대로 빨아들이는 시점
				/*while(true){
					data=buffr.readLine(); 
					if(data==null)break; //string 이니깐 null
					System.out.println(data);
					
				}*/
				
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			} 
			
			
		
		}
	}
	
	
	//CSV --> Oracle로 데이터 이전(migration)하기
	//오늘 수업의 핵심
	public void load(){
		System.out.println(buffr);
		//버퍼스트림을 이용하여 csv의 데이터를
		//1줄씩 읽어들여 insert 시키자
		//레코드가 없을 때까지!! 
		//while 문으로 돌리면 너무 빠르므로!
		//네트워크가 감당할 수 없기에 일부러 지연시키면서~~
		String data;
		//while 문 돌아가니깐 String 쓰면, 데이터 무시무시하게 잡아먹음
		//수정가능한 sb 사용하자
		StringBuffer sb = new StringBuffer();
		
		try {
			while(true){
				data=buffr.readLine();
				// .의 경우 기능성 .과 중복될수 있기때문에 "\\." 으로 구분시켜준다!!
				//ex)tab
				if(data==null)break;
				
				String[] value = data.split(","); //나는데이터를 분리시킬거야 "," 컴마를통해서
				//그러면 String 형으로 여러개 나올것이니깐 -> string 형 배열
				
				//seq 줄을 제외하고 insert 하겠다
				if(!value[0].equals("seq")){ //value 값이 "seq" 와 같은 값이 있지않다면!!
					//System.out.println(data);
					sb.append("insert into hospital(seq,name,addr,regdate,status,dimension,type)");
					sb.append(" values("+value[0]+",'"+value[1]+"','"+value[2]+"','"+value[3]+"','"+value[4]+"',"+value[5]+",'"+value[6]+"')");
				
					//디버깅하는방법!!
					//System.out.println(sb.toString());
					pstmt=con.prepareStatement(sb.toString());
					int result =pstmt.executeUpdate();
					
					//missing expression 시 데이터 문제일수 있으니 확인하세요
					//기존에 누적된 StringBuffer 의
					//데이터를 모두 지우기
					//0은 시작 sb.length 는 끝까지를 뜻함
					sb.delete(0, sb.length());
					
				}else{System.out.println("난 1줄이므로 제외");
				
				}
			}
			JOptionPane.showMessageDialog(this, "마이그레이완료");
			
			//JTable 나오게 처리!!
			getList(); //데이터 연동함!!
			table.setModel(new MyModel(list, columnName)); //columnName 도 멤버변수화
			
			//테이블 모델과 리스너와의 연결
			//테이블은 테이블모델 //내가쓰고있는모델 반환해준다
			//getModel()
			table.getModel().addTableModelListener(this);
			table.updateUI(); //모델이 최신상태로 업데이트됨..
			
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
	
	//엑셀파일 읽어서 db에 마이그레이션 하기!!
	//javaSE 엑셀제어 라이브러리 있다? X,없다!
	//open Source 공개소프트웨어  - 아파치에서 제공하는 것이 있다..
	//copyright 돈내라 <---> copyleft 무료화되어야한다 (아파치 단체)
	//POT 라이브러리! http://apache.org
	/*
	 * HSSFWorkbook : 엑셀파일
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
					int columnCount = row.getLastCellNum(); //컬럼 총 갯수
					
					for(int i=0; i<columnCount; i++){
						HSSFCell cell = row.getCell(i);
						//자료형에 국한되지 않고 모두 String 처리할수있다..
						String value = df.formatCellValue(cell);
						//String으로 반환해준다!!
						System.out.print(value); //println 아니라 print 입니다!! ln 은 바깥층에서!!
						//줄바꿈은 언제일어날까?	
					}
					//바깥층에서..
					System.out.println("");
				}
				
				
			} catch (FileNotFoundException e) {
	
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
			
		}
	}
	
	//모든 레코드 가져오기
	public void getList(){
		//모델가져오기 전에 select 문부터 가져와야지 데이터가 뜬다
		String sql="select * from hospital order by seq asc";
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		
		try {
			
			pstmt=con.prepareStatement(sql);
			//rs의 존재를 테이블이 알아야 한다
			rs=pstmt.executeQuery();
			//rs를 이차원백터로 가공 후 없앨것이다..
			//하나의 레코드 = 하나의 백터
			
			//컬럼명도 추출!!
			ResultSetMetaData meta = rs.getMetaData();
			int count = meta.getColumnCount();
			columnName = new Vector();//잊지말자 
			
			for(int i=0; i<count; i++){
				columnName.add(meta.getColumnName(i+1));
				//rs 는 이차원 백터에게 데이터를 넘겨주고 , 컬럼명도 알려주고 끝..
			}
			
			//Vector list = new Vector(); //이차원 백터!! , 1차원 백터를 담을 것
			list = new Vector<Vector>(); //이차원 백터!! , 1차원 백터를 담을 것
			
			//여기서부터
			while(rs.next()){ //커서 한칸 전진~
				Vector vec = new Vector(); //1차원 백터, 레코드 1건 담을것
				
				//getIndex 도 사용가능하나, 컬럼명과 정확한 일치 및 컬럼을 담는다는 의미를 부여하기위해
				vec.add(rs.getString("seq")); 
				vec.add(rs.getString("name"));
				vec.add(rs.getString("addr"));
				vec.add(rs.getString("regdate"));
				vec.add(rs.getString("status"));
				vec.add(rs.getString("dimension"));
				vec.add(rs.getString("type"));
				
				list.add(vec);
			}
			//여기까지 하나의 레코드!!
			
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
	
	//선택한 레코드 삭제
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
	
	//테이블 모델의 데이터값에 변경이 발생하면
	//그 찰나를 감지하는 리스너!
	@Override
	public void tableChanged(TableModelEvent e) {
		System.out.println("나 바꿧어!!!");
		//update hospital set 컬럼명 name = 값 where ~ 출력하기..
		//수정할 때 마다 update 문이 제대로 나오게끔..
	}
	
	public static void main(String[] args) {
		new LoadMain();
	}

}
