/*�α��� �� �����*/
package gui;
import java.awt.*;

class LoginForm{
	public static void main(String[] args){
		Frame frame; //���������� �����ڰ� �ʱ�ȭ ����������,
		//�ڵ����� �ʱ�ȭ���� �����Ƿ�, �Ʒ��� ��ü�鿡 ����
		//���۷��� ������ �ƹ��� ���� ������� �ʴ�..
		//=null �־���� �Ѵ�.. FM) Frame frame=null;
		Panel p_center,p_south,p_container; //�ǹ̺ο��� ���̹��� �ʿ��ϴ�

		Label la_id,la_pw; 

		TextField t_id,t_pw;

		Button bt_login,bt_regist;

		frame=new Frame("�α��� ��");
		p_center = new Panel();
		p_south = new Panel();
		//������ ��ſ� �г��� ���� container!!
		p_container = new Panel();
		la_id = new Label("ID");
		la_pw = new Label("Password");
		t_id=new TextField(20);
		t_pw=new TextField(20);
		bt_login=new Button("�α���");
		bt_regist=new Button("ȸ������");

		//���� ���� �����ϱ�
		//������ ���� ���̾ƿ��� ���� �����ؾ� �Ѵ�!!
		//Panel ����Ʈ�� FlowLayout �̹Ƿ�,
		//GridLayout ���� ��������!!\
		p_center.setLayout(new GridLayout(2,2));
		p_center.add(la_id); //1�� 1��
		p_center.add(t_id); //1�� 2��

		p_center.add(la_pw); //2�� 1��
		p_center.add(t_pw); //2�� 2��

		//���� �гο� ��ư ����!!
		p_south.add(bt_login);
		p_south.add(bt_regist);
		
		//������ ���, BorderLayout �� ������ �����̳�
		p_container.setLayout(new BorderLayout());

		//�гε��� ��ü �����ӿ� ������!!
						//Ŭ����. ��� �����ϸ� static ����Ǿ��ִٴ� ����
		p_container.add(p_center,BorderLayout.CENTER);
		p_container.add(p_south,BorderLayout.SOUTH);

		//�������� ���̾ƿ��� FlowLayout ���� ��ȯ
		frame.setLayout(new FlowLayout());
		frame.add(p_container);
		
		//������ ũ�� �� ���̱� ����
		frame.setSize(300,150);
		frame.setVisible(true);
	}	
}
