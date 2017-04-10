/*메모장을 만들어보자*/

package gui;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JMenuItem;
import java.awt.Color;
import java.awt.Font;

class MemoEditor extends JFrame{
	JMenuBar bar; //초기값 디폴트생성자에의해 null 이라는 초기값생성
	JMenu m_file, m_edit, m_form, m_view, m_help;
	JTextArea area;
	//따로존재하는 스크롤객체
	JScrollPane scroll; //스크롤객체
	JMenuItem item_new,item_open,item_save,item_otherSave,item_page,item_print,item_exit;

	//메모장 윈도우가 태어날 때, 그 부품도
	//동시에 태어나야 하므로, 생성자의 기회를
	//놓치지 말자!!
	public MemoEditor(){
	//생성자는 물려받지 않는다..
	//부모클래스의 인수 물려받는다면..
		super("제목 없음 - 메모장");
		bar = new JMenuBar();
		area=new JTextArea();
		scroll = new JScrollPane(area);
	
		//메뉴들을 생성하자!!
		m_file=new JMenu("파일");
		m_edit=new JMenu("편집");
		m_form=new JMenu("서식");
		m_view=new JMenu("보기");
		m_help=new JMenu("도움말");
		//다음에는 배열로 만들어서 붙히자..
							//행과열이존재

		item_new=new JMenuItem("새로만들기");
		item_open=new JMenuItem("열기"); 
		item_save=new JMenuItem("저장"); 
		item_otherSave=new JMenuItem("다른이름으로 저장"); 
		//여기서 나누기
		item_page=new JMenuItem("페이지설정"); 
		item_print=new JMenuItem("인쇄"); 
		//여기서 나누니
		item_exit=new JMenuItem("끝내기"); 
		
		m_file.add(item_new);
		m_file.add(item_open);
		m_file.add(item_save);
		m_file.add(item_otherSave);
		m_file.add(item_page);
		m_file.add(item_print);
		m_file.add(item_exit);
		//아이템을 올렸다
		bar.add(m_file);
		bar.add(m_edit);
		bar.add(m_form);
		bar.add(m_view);
		bar.add(m_help);
		//메뉴바에 메뉴를 올려야 나타난다
		setJMenuBar(bar); //특별하니깐 
		add(scroll);//스크롤이 area를 흡수했으므로,
		//최종적으로 스크롤을 부착해야함!!
		//*숙제 파일-아이템 7개 추가하고, 입력글씨의 폰트/색상 바꾸기..
		area.setForeground(Color.RED);
												//상수니깐대부분자기가갖고잇다
		area.setFont(new Font("Dotum",Font.BOLD,20));
		//잘 모르겠으면 더 자세히 자세히 들어가서 확인해보자
		//API 보는방법 꾸준한 훈련과 원칙을 갖고 하자..
		//나만의 원칙으로 분석하자 어디에 쓰이는지?
		
							//x,y,width,height
		this.setBounds(200,100,600,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);


	}

	public static void main(String[] args){
		new MemoEditor();
	
	}
}
