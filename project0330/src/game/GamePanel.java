package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

/*모든 게임은 이 패널안에서 그려질 예정이다
 * 아무리 게임의 장면이 다양하더라도, 패널은 오직 1개만 사용된다
 * 모든 오브젝트는 결국 이 패널에 그려져야
 * 하므로, 이 패널의 paint 메서드의 인수로 전달되는
 * graphic 개체를 게임에 등장할 모든 오브젝트가
 * 전달 받아야 한다...*/
//runnable 내가 이미 누군가의 자식일 때 임플리먼츠 런어블...사용
//런어블은 쓰레드가 아니라 런만 갖고있는 것..
public class GamePanel extends JPanel implements 	Runnable{
	//쓰레드는 하나만 둬서 역호출 가능하게
	//모든 메서드는 tick ,render 메서드 보유
	public static final int WIDTH =400;
	public static final int HEIGHT =300; //상수를 쓰는 이유는? 직관성
	public static final int SCALE =2;
	boolean flag = true; //게임 가동여부를 결정하는 변수
	//게임을 진행할 쓰레드 선언 (run 실행을 위한..)
	Thread thread; //게임운영 쓰레드
	Player player; //우리가 만든 주인공 클래스
	ObjectManager objectManager; // 선언 후 사용하자!! 객체명단관리자@
	
	public GamePanel() {
		thread = new Thread(this);
		//런을 갖고있는 타겟을 쓰레드 타겟으로 선언@@
		thread.start();
		
		 init(); 
		//setBackground(Color.GRAY);
		//크기 지정 //상수는 접근허용해줘야지
		setPreferredSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
	}
	
	
	public void init(){
		objectManager = new ObjectManager();
		//주인공 등장시키기
		player = new Player(objectManager,ObjectId.Player,100, 200, 50, 50);
		//올라왓지만 데이터베이스에는 없다..
		objectManager.addObject(player);//1명추가!!!
		
		//적군 등장
		//y값도 랜덤주자
		Random r=new Random();
		for(int i=0; i<10; i++){
			int y=r.nextInt((HEIGHT*SCALE-50)-(50)+1)+50;
			int x=r.nextInt((WIDTH*SCALE-50)-(50)+1)+50;
			Enemy enemy = new Enemy(objectManager,ObjectId.Enemy,x , y, 30, 30);
		
			objectManager.addObject(enemy);
		}
		//패널과 키보드리스너 연결!!!
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
			//오브젝트 매니저에 등록된 모든~~객체를 대상으로 tick() 호출하자
			for(int i=0;i<objectManager.list.size(); i++){
				GameObject obj=objectManager.list.get(i);
				obj.tick();
			}
			repaint();
			
			//player.tick(); //tick 은 여기올수있지만 , render 는 g 객체가 여기없어서 불가능..
			//render 을 포함한 paintComponent 를 간접호출하여야 실행되니깐 repaint 메서드 !!
			//총알의 tick , render
			//적군의 tick , render
			//아이템의 tick , render
			//패널은 패널에 출현할 녀석들의 총 망라 리스트를 알수잇어야함..	
		}
	}
}
