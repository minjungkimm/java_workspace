package game.word;

import java.awt.Graphics;

//게임에 등장할 대상 단어가 각각
//y축의 값을 따로 갖고, 대량으로 만들어야 하기 때문에..
//결국 재사용성을 위한 코드집합의 클래스로 간다.
public class Word {
	String name; //이 객체가 담게될 단어
	int x;
	int y;
	int velX;
	int velY; //단어가 움직일 속도..
	
	//이 단어가 태어날 때 갖추어야 할 초기화 값
	public Word(String name,int x,int y) {
		this.name=name;
		this.x=x;
		this.y=y;
	}
	
	//이 객체에 반영될 데이터 변화코드
	public void tick(){ //메인심장부에서 언제나 호출되야함
		y+=5;
	}
	
	//그 반영된 데이터를 이용하여 화면에 그리기
	public void render(Graphics g){ //메인심장부에서 언제나 호출되야함
		g.drawString(name,x,y);
		//이 단어가 생길 때 초기화 되어야함
	}
	
}
