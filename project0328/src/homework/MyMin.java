package homework;

public class MyMin extends Thread{

	AniMin animin;
	
	public MyMin(AniMin animin){
		//������� �����̴µ� �����̴� �ӵ��� ���� ũ�Ⱑ �޶�� �Ѵ�..
		this.animin=animin;
	}
	
	public void run(){
			while(true){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			animin.move(5,5,100,100);
	
			}
	}
}
