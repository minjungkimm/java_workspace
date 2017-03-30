package project0330;

import java.awt.Graphics;
import java.awt.Rectangle;

/*게임에 등장할 모든~~객체의 최상위 클래스를
 * 정의한다.. 
 * 왜? 상속을 이용하면 코드 중복을 방지 할 수 있고,
 * 최상위 클래스 자료형으로 자식들을 가리킬 수 있으므로,
 * 코드가 유연해진다..!!*/
abstract public class GameObject {
	ObjectManager objectManager;
	ObjectId id; //모든 게임 객체에 할당될 아이디
	int x;
	int y;
	int width;
	int height;
	int velX;
	int velY;
	Rectangle rect; //교차테스트에 써먹을 사각형 객체!!
	
	public GameObject(ObjectManager objectManager,ObjectId id,int x,int y,int width,int height) {
		this.objectManager=objectManager;
		this.id=id; //어떤종류인지 구분하기 위함..
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		
		
		rect = new Rectangle(x, y, width, height); //게임오브젝트 상속하면 전부 사각형 안고 태어나게된다!!
	}
	
	abstract public void tick();
	
	abstract public void render(Graphics g);
	
}
