package use;

class MainTest{
	public void test(){
	}
	//���� �޼���� �ý����� ȣ���ϹǷ�,
	//�� java.exe ����� ȣ���ع����Ƿ�,
	//�����ڰ� ȣ���� �� ����!!
	//���θ޼��� ȣ��� ��Ʈ�� �迭�� ���� �� �ִ�
	public static void main(String[] args){
		/*
		mario.jpg �� ���� ���������� �μ��� ������
		�� �м������ �����ֱ�!!

		���ϸ��� mario
		Ȯ���ڴ� jpg

		���� ��°� �츮���״� ���ڷ� ������ �𸣰�����
		abc �̷��� ���� /\. �̷��͵��� ����� ����ϴ� Ư����ȣ
		������ ����� �������Ѿ� �Ѵ�..
		Ư����ȣ �տ��ٰ� \(��������) ������ ���ڷ� �ν��ϰԵ�
		*/
		String[] arr=args[0].split("\\."); //mario,jpg �и��Ǿ��
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		
		//mario\.jpg
		String[] arr=args[0].split("\\.");


		/*
		int len=args.length;
		//�μ��� �ѱ� ���ڿ��� ���� ����ȭ ���� ��ȯ
		int dan=Integer.parseInt(args[0]);
		for(int i=1; i<=9; i++){
			System.out.println(dan+"*"+i+"="+dan*i);
		//�迭�� 0��° �ܾ�
		//System.out.println(args[0]);
		//���ϴ� �μ��� ��Ƽ� �����Բ�
		
		//System.out.println(args);
		//System.out.println("����� �ѱ� �迭�� ���̴�"+len);
		*/
		//}
	}
}
