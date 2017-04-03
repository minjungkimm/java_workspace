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
	ConnectionManager manager; //������â�� ���϶��� �� �ΰ��� �־�� �Ѵ�..
	Connection con; //��� ��ü�� �����ϱ� ���� //���ø����̼� �����ɶ�
	JTable table;
	JScrollPane scroll;
	JPanel p_west,p_center;
	Choice choice;
	String[][] item={
			{"�����̺��� �����ϼ���",""},
			{"������̺�","emp"},
			{"�μ����̺�","dept"}
			
	};
	
	TableModel[] model=new TableModel[item.length];
	
	public AppMain() {
		//�����ΰ� ������ �и���Ű�� ���� �߰��� (Controller)
		//�� ���簡 �ʿ��ϴ� JTable ������ �� ��Ʈ�ѷ��� ������
		//TableModel �� ���ش�
		//TableModel �� ����� ���, JTable �� �ڽ��� ������� ��
		//�����͸� TableModel �κ��� ������ ���� ����Ѵ�!!
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
		
		//���̺� �𵨵��� �÷�����!!
		//���� �����ڰ� �ƴ϶�, ���� �޼��忡�� �����ϰڴ�..!!
		model[0] = new DefaultTableModel();
		model[1] = new EmpModel(con);
		model[2] = new DeptModel(con);
		
		//html ���� value ���� ������, �ΰ��� ���� �����ϵ�
		//�ڹٿ����� �ΰ��� ���� ������
		//���̽� ����
		for(int i=0; i<item.length; i++){
			choice.add(item[i][0]);
		
		} //�迭����� ����
		//west ������ �гο� ���̽� ����
		p_west.add(choice);
		p_center.add(scroll);
		add(p_west,BorderLayout.WEST);
		add(p_center);
	
		//������������ �������� ���̺� �Է�
		//��� ���� ��ų��� ����..
		//�����ΰ� �����Ͱ� �Բ� �ִ� ����..
		//�ڹ��� ���� ���ٰ� ���� �ٸ� ������ ���Ƴ���ȴ�..
		//������������ �پ��..
		
		add(scroll);
		
		pack();
		
		//���̽��� ������ ����
		choice.addItemListener(this);
		
		//������â ���� �� ����Ŭ ���� ����..
		this.addWindowListener(new WindowAdapter() {
		
			@Override
			public void windowClosing(WindowEvent e) {
				//Ŀ�ؼ� �ݱ�..
				manager.disConnect(con);
				//���α׷� ����
				System.exit(0);
				
			}
		});
		
		setVisible(true);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	//�ش�Ǵ� ���̺� �����ֱ�
	public void showData(int index){
		System.out.println("����� ���Ե� ���̺���? "+item[index][1]);
		//�ش�Ǵ� ���̺� ���� ����ϸ� �ȴ�!!
		// emp--> EmpModel
		// dept--> deptModel
		//�ƹ��͵� �ƴϸ� --> DefaultTableModel
		table.setModel(model[index]);
		
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		//�̺�Ʈ������ 2�ܰ�
		//�������� ���°� ���Ҷ����� ȣ��ȴ�..
		Choice ch=(Choice)e.getSource();
		//ch ������, ���缱�õȰ� ���� �˼��ִ�..
		int index=ch.getSelectedIndex();
		//���° �������� �����ߴ���?
		showData(index);
	}
	
	public static void main(String[] args) {
		new AppMain();
	}


}
