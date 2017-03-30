/*�׸� �׷��� �������� �����Ǵ� ��ü��
 * Canvas �� �׸��� �׷�����!!
 * �� ĵ������ �׷��� �ϳ�? ĵ������ �����̳� ó�� �ƹ��͵� ����..
 * ����ִ� �� ��ȭ���� ǥ���� ��ü�̹Ƿ�..
 * */
package graphic;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class CanvasTest extends JFrame{
	Canvas can;//�� �� ��ȭ��
	Toolkit kit;//�ڹ�SE���� �̹����� ��������
	//��Ŷ ��ü�� �̿��ؾ� �Ѵ�..(sun�簡...)
	Image img; //�߻�Ŭ������ new ����!!
	public CanvasTest(){
		kit=Toolkit.getDefaultToolkit(); //�ν��Ͻ� ���
		//�̹����� ������� �����, �̹����� �ƴϴ�!!
		img=kit.getImage("C:/html_workspace/images/dora.png");
		//�����츸 �������� ���ϱ�, �츮�� ���� ���� �Ϲݽ����÷� ����!!
		//�̹����� �������� �׷��������� �÷��ߵȴ�!!
		//�ǰ��ϸ� ���⼭ �������̵� ����
		//���� �������� ����
		can = new Canvas(){
			//paint �޼���� ��ǻ� ������ �Ұ��ϸ�
			//� �׸��� �׸����� �����ϴ� ��ü��
			//Graphics ��ü�̴�!!
			public void paint(Graphics g) {
								//image(�߻�Ŭ����),x,y,������
			//�߻�Ŭ�����߿��� api ��ü���� �����ϴ� Ŭ������ �ֳ�? Ȯ�κ�������
			//������ �ڽ��� new ���ڴ� ���� ������
			//�ν��Ͻ��� new �޼���, �ȵǴϱ� �ϴ°Ŵϱ� Ŭ���� �޼���
				g.drawImage(img,0,0,200,200,this);
				//���⼭ ���ϴ� this �� �극�̽� �ȿ��� this
			}
		};
		
		can.setBackground(Color.YELLOW);
		add(can);
		
		setSize(700,600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}
	
	public static void main(String[] args) {
		new CanvasTest();
	}
}
