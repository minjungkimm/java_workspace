/*������ ������ ��� �� ������*/
package thread;

public class MoveThread extends  Thread {
	//�����ڴ� ���� ������ �ڵ带 run�� �����Ѵ�..
	//JVM�� run�� �˾Ƽ� ȣ���Ѵ�
	AniMain animain;
	public MoveThread(AniMain animain) {
		this.animain=animain;
	}
	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(100); //0.1�� ��������
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			animain.move();
			
		}
	}

}
