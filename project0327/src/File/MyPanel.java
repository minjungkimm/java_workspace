/*�г��� �󺧰� ��ư�� ������ �ִ�.
 * JPanel has a Label & JButton */
package File;

import java.awt.BorderLayout;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyPanel extends JPanel{
	JLabel la;
	JButton bt;
	
	//�г��� �¾ �� ���� �� ��ǰ�� ���� �¾�� �ϹǷ�,
	//�����ڿ��� �ʱ�ȭ ����!!       //�����ϴ�..
	public MyPanel(String title, Icon icon){
		la = new JLabel(title);
		bt = new JButton(icon);
		
		bt.setBorderPainted(false); //���� ���ֱ�
		bt.setContentAreaFilled(false);//�� ä��� ����
		bt.setFocusPainted(false);//��Ŀ���� ���� ��� ���ֱ�
		bt.setOpaque(false); //�����ϰ�
		
		this.setLayout(new BorderLayout());
		add(la,BorderLayout.NORTH);
		//add(bt,BorderLayout.CENTER);
		add(bt);

	}

}
