/*����� ����� ����� �� MP3Player*/
package music;

//��ӽ� �θ� �ҿ����� �߻�Ŭ������ ���
//�����ϰ� �ڵ带 �ϼ��� �ǹ��� �ڽĿ��� �־�����..
//���� ����� ���ÿ� �޴� ����ó��
//�ڵ��Ӱ� �ǹ��� �Բ� �ؾ��Ѵ�.. �ڽĿ��� ������ ����ȭ �ϱ����ؼ�
//**extends�� implements �� is a �����̴�!!!!
//MP3Player �� MusicPlayer �̸鼭, Jet �̴�!!!
//is a ����� ��ü�ڷ��� ���� ����ȯ�� �����ϴ�!!!
public class MP3Player extends MusicPlayer implements Jet{
		//������������ �̿��� �ð�ȭ ���
		public void equlizer(){
			System.out.println("������������");
		}
		
		//�θ� �ϼ����� �޼��带 ���⼭ �ϼ��Ѵ�!
		//��� ���� �� ������ü���� �� ��ɸ�ŭ�� �� ������ ��������
		//����ȭ ��Ű�� �� = ��ȹ�ܰ迡�� ����..
		public void playMP3(){ //�극�̽�(�ٵ�)�� ������ �ϼ��Ȱ�!!
			System.out.println("mp3 �÷�����...");
		}
		public void setVolume(){
			System.out.println("������ ������...");
		}
		public void fly(){
		}
}
