/*�޸����� ������*/

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
	JMenuBar bar; //�ʱⰪ ����Ʈ�����ڿ����� null �̶�� �ʱⰪ����
	JMenu m_file, m_edit, m_form, m_view, m_help;
	JTextArea area;
	//���������ϴ� ��ũ�Ѱ�ü
	JScrollPane scroll; //��ũ�Ѱ�ü
	JMenuItem item_new,item_open,item_save,item_otherSave,item_page,item_print,item_exit;

	//�޸��� �����찡 �¾ ��, �� ��ǰ��
	//���ÿ� �¾�� �ϹǷ�, �������� ��ȸ��
	//��ġ�� ����!!
	public MemoEditor(){
	//�����ڴ� �������� �ʴ´�..
	//�θ�Ŭ������ �μ� �����޴´ٸ�..
		super("���� ���� - �޸���");
		bar = new JMenuBar();
		area=new JTextArea();
		scroll = new JScrollPane(area);
	
		//�޴����� ��������!!
		m_file=new JMenu("����");
		m_edit=new JMenu("����");
		m_form=new JMenu("����");
		m_view=new JMenu("����");
		m_help=new JMenu("����");
		//�������� �迭�� ���� ������..
							//�����������

		item_new=new JMenuItem("���θ����");
		item_open=new JMenuItem("����"); 
		item_save=new JMenuItem("����"); 
		item_otherSave=new JMenuItem("�ٸ��̸����� ����"); 
		//���⼭ ������
		item_page=new JMenuItem("����������"); 
		item_print=new JMenuItem("�μ�"); 
		//���⼭ ������
		item_exit=new JMenuItem("������"); 
		
		m_file.add(item_new);
		m_file.add(item_open);
		m_file.add(item_save);
		m_file.add(item_otherSave);
		m_file.add(item_page);
		m_file.add(item_print);
		m_file.add(item_exit);
		//�������� �÷ȴ�
		bar.add(m_file);
		bar.add(m_edit);
		bar.add(m_form);
		bar.add(m_view);
		bar.add(m_help);
		//�޴��ٿ� �޴��� �÷��� ��Ÿ����
		setJMenuBar(bar); //Ư���ϴϱ� 
		add(scroll);//��ũ���� area�� ��������Ƿ�,
		//���������� ��ũ���� �����ؾ���!!
		//*���� ����-������ 7�� �߰��ϰ�, �Է±۾��� ��Ʈ/���� �ٲٱ�..
		area.setForeground(Color.RED);
												//����ϱ��κ��ڱⰡ�����մ�
		area.setFont(new Font("Dotum",Font.BOLD,20));
		//�� �𸣰����� �� �ڼ��� �ڼ��� ���� Ȯ���غ���
		//API ���¹�� ������ �Ʒð� ��Ģ�� ���� ����..
		//������ ��Ģ���� �м����� ��� ���̴���?
		
							//x,y,width,height
		this.setBounds(200,100,600,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);


	}

	public static void main(String[] args){
		new MemoEditor();
	
	}
}
