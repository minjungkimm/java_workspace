package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

/*��� ������ �� �гξȿ��� �׷��� �����̴�
 * �ƹ��� ������ ����� �پ��ϴ���, �г��� ���� 1���� ���ȴ�
 * ��� ������Ʈ�� �ᱹ �� �гο� �׷�����
 * �ϹǷ�, �� �г��� paint �޼����� �μ��� ���޵Ǵ�
 * graphic ��ü�� ���ӿ� ������ ��� ������Ʈ��
 * ���� �޾ƾ� �Ѵ�...*/
//runnable ���� �̹� �������� �ڽ��� �� ���ø����� �����...���
//������� �����尡 �ƴ϶� ���� �����ִ� ��..
public class GamePanel extends JPanel implements 	Runnable{
	//������� �ϳ��� �ּ� ��ȣ�� �����ϰ�
	//��� �޼���� tick ,render �޼��� ����
	public static final int WIDTH =400;
	public static final int HEIGHT =300; //����� ���� ������? ������
	public static final int SCALE =2;
	boolean flag = true; //���� �������θ� �����ϴ� ����
	//������ ������ ������ ���� (run ������ ����..)
	Thread thread; //���ӿ ������
	Player player; //�츮�� ���� ���ΰ� Ŭ����
	ObjectManager objectManager; // ���� �� �������!! ��ü��ܰ�����@
	
	public GamePanel() {
		thread = new Thread(this);
		//���� �����ִ� Ÿ���� ������ Ÿ������ ����@@
		thread.start();
		
		 init(); 
		//setBackground(Color.GRAY);
		//ũ�� ���� //����� ��������������
		setPreferredSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
	}
	
	
	public void init(){
		objectManager = new ObjectManager();
		//���ΰ� �����Ű��
		player = new Player(objectManager,ObjectId.Player,100, 200, 50, 50);
		//�ö������ �����ͺ��̽����� ����..
		objectManager.addObject(player);//1���߰�!!!
		
		//���� ����
		//y���� ��������
		Random r=new Random();
		for(int i=0; i<10; i++){
			int y=r.nextInt((HEIGHT*SCALE-50)-(50)+1)+50;
			int x=r.nextInt((WIDTH*SCALE-50)-(50)+1)+50;
			Enemy enemy = new Enemy(objectManager,ObjectId.Enemy,x , y, 30, 30);
		
			objectManager.addObject(enemy);
		}
		//�гΰ� Ű���帮���� ����!!!
		this.addKeyListener(new KeyBoard(player));
		
	}
	
	protected void paintComponent(Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH*SCALE, HEIGHT*SCALE);
	
		for(int i=0;i<objectManager.list.size(); i++){
			GameObject obj=objectManager.list.get(i);
			obj.render(g);
		}
	}
	
	@Override
	public void run() {
		while(flag){
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//������Ʈ �Ŵ����� ��ϵ� ���~~��ü�� ������� tick() ȣ������
			for(int i=0;i<objectManager.list.size(); i++){
				GameObject obj=objectManager.list.get(i);
				obj.tick();
			}
			repaint();
			
			//player.tick(); //tick �� ����ü������� , render �� g ��ü�� ������ �Ұ���..
			//render �� ������ paintComponent �� ����ȣ���Ͽ��� ����Ǵϱ� repaint �޼��� !!
			//�Ѿ��� tick , render
			//������ tick , render
			//�������� tick , render
			//�г��� �гο� ������ �༮���� �� ���� ����Ʈ�� �˼��վ����..	
		}
	}
}
