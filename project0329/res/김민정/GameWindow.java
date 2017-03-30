package game.word;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

//�� ������� ũ�Ⱑ �����Ǿ� ���� �ʾƾ� �Ѵ�
//��? ������ �ȿ� ������ �� �г��� 
//�� ũ�⸦ �����ϰ� �ǹǷ�..
//�α��� ����� ���� �۰� , ���� ���� ȭ�鿡���� ũ��..
//������ �����̴� �� 1. ������ ��ȭ 2. �ݿ�
public class GameWindow extends JFrame{
	LoginForm loginform;
	GamePanel gamePanel; //���� ������� 2�������� �� �����ϰ� �ִ�.
	
	JPanel[] page = new JPanel[2]; //2�������� ������� �г� �迭
	
	public GameWindow() {
		
		setLayout(new FlowLayout());

		page[0] = new LoginForm(this); //�迭�� ����
		page[1] = new GamePanel(this); //�迭�� ����
		
		add(page[0]);
		add(page[1]);
		
		setPage(0);

		setVisible(true);	
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	//������ �ȿ� � �г��� ���� �������ִ� �޼��带 ��������!!
	//�μ��� ���ϴ� �г��� �ִ´�
	public void setPage(int index){
		for(int i=0; i<page.length; i++){
			if(i==index){
				page[i].setVisible(true); //�μ��� �޴� index
				//setSize �� ������ ũ�⸦ �������� �ʾұ� ������ ȭ���� �ּҷ� ���´�
			}else{page[i].setVisible(false);}
		}
		pack(); //���빰�� ũ�⸸ŭ ������ ũ�⸦ ��������!
		setLocationRelativeTo(null);//ȭ���߾����� ����ؼ� ���õǰ�.. �α��ε��Ŀ��� ������ �ʴ� ���� ����
	}
	
	public static void main(String[] args) {
		new GameWindow();

	}
}
