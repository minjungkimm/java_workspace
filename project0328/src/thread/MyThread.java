/*���� �����ϰ� ���� �ڵ�� �����ڰ� �����ؾ�
 * �ϱ� ������ �����带 ������ �ؾ� �Ѵ�*/
package thread; 
public class MyThread extends Thread {
	/*�����ڴ� ���������� �����ϰ� ���� �ڵ带 ��������
	 * run �޼���ȿ� �ۼ��ϸ� �ȴ�*/
	//setTimeout �� ����� ����
	@Override
	public void run() {
		while(true){ //����ΰ� �ݴº극�̽� ������ �����ϱ�
							//�ݴº극�̽� �����ʰ� ������ �ݺ��� ������
							//run �ΰ� , �Ѵ� while �� �������ϸ� �ϳ������� 
							//while ���� ���°� �ƴ϶� �Ѵ� ����
		try {
			Thread.sleep(1000);//1�� ���ٰ� ��!!!!
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
		System.out.println("��"); //�����ؼ� ��� �ٽ� ���Ϲ� ���ư��� 1�ʽ��� �ݺ�
		}
	}
}
