package oracle;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class AppMain extends JFrame implements ItemListener{
	ConnectionManager manager; //윈도우창이 보일때는 이 두개가 있어야 한다..
	Connection con; //모든 객체간 공유하기 위해 //어플리케이션 가동될때
	JTable table;
	JScrollPane scroll;
	JPanel p_west,p_center;
	Choice choice;
	String[][] item={
			{"▼테이블을 선택하세요",""},
			{"사원테이블","emp"},
			{"부서테이블","dept"}
			
	};
	
	TableModel[] model=new TableModel[item.length];
	
	public AppMain() {
		//디자인과 로직을 분리시키기 위해 중간자 (Controller)
		//의 존재가 필요하다 JTable 에서는 이 컨트롤러의 역할을
		//TableModel 이 해준다
		//TableModel 을 사용할 경우, JTable 은 자신이 보여줘야 할
		//데이터를 TableModel 로부터 정보를 얻어와 출력한다!!
		//getColumnCount()
		//getRowCount()
		//getValueAt()
		manager = ConnectionManager.getInstance();
		con = manager.getConnection();
		
		table = new JTable();
		scroll = new JScrollPane(table);
		p_west = new JPanel();
		p_center = new JPanel();
		choice = new Choice();
		
		//테이블 모델들을 올려놓자!!
		//모델을 생성자가 아니라, 추후 메서드에서 결정하겠다..!!
		model[0] = new DefaultTableModel();
		model[1] = new EmpModel(con);
		model[2] = new DeptModel(con);
		
		//html 에서 value 값과 실제값, 두개의 값이 존재하듯
		//자바에서도 두개의 값을 만들어보자
		//초이스 구성
		for(int i=0; i<item.length; i++){
			choice.add(item[i][0]);
		
		} //배열만든거 돌림
		//west 영역의 패널에 초이스 부착
		p_west.add(choice);
		p_center.add(scroll);
		add(p_west,BorderLayout.WEST);
		add(p_center);
	
		//유지보수성이 떨어지는 테이블 입력
		//살과 옷을 꿰매놓은 상태..
		//디자인과 데이터가 함께 있는 상태..
		//자바의 장점 빵꾸가 나면 다른 바퀴만 갈아끼면된다..
		//유지보수성이 뛰어나다..
		
		add(scroll);
		
		pack();
		
		//초이스와 리스너 연결
		choice.addItemListener(this);
		
		//윈도우창 닫을 때 오라클 접속 끊기..
		this.addWindowListener(new WindowAdapter() {
		
			@Override
			public void windowClosing(WindowEvent e) {
				//커넥션 닫기..
				manager.disConnect(con);
				//프로그램 종료
				System.exit(0);
				
			}
		});
		
		setVisible(true);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	//해당되는 테이블 보여주기
	public void showData(int index){
		System.out.println("당신이 보게될 테이블은? "+item[index][1]);
		//해당되는 테이블 모델을 사용하면 된다!!
		// emp--> EmpModel
		// dept--> deptModel
		//아무것도 아니면 --> DefaultTableModel
		table.setModel(model[index]);
		
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		//이벤트구현의 2단계
		//아이템의 상태가 변할때마다 호출된다..
		Choice ch=(Choice)e.getSource();
		//ch 얻어오면, 현재선택된게 뭔지 알수있다..
		int index=ch.getSelectedIndex();
		//몇번째 아이템을 선택했느냐?
		showData(index);
	}
	
	public static void main(String[] args) {
		new AppMain();
	}


}
