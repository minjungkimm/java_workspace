package use;

class MainTest{
	public void test(){
	}
	//메인 메서드는 시스템이 호출하므로,
	//즉 java.exe 실행시 호출해버리므로,
	//개발자가 호출할 수 없다!!
	//메인메서드 호출시 스트링 배열을 가질 수 있다
	public static void main(String[] args){
		/*
		mario.jpg 와 같이 파일정보를 인수로 넣으면
		그 분석결과를 보여주기!!

		파일명은 mario
		확장자는 jpg

		점이 라는게 우리한테는 문자로 보일지 모르겠지만
		abc 이런거 말고 /\. 이런것들은 기능을 담당하는 특수기호
		본래의 기능을 무마시켜야 한다..
		특수기호 앞에다가 \(역슬래시) 넣으면 문자로 인식하게됨
		*/
		String[] arr=args[0].split("\\."); //mario,jpg 분리되어나옮
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		
		//mario\.jpg
		String[] arr=args[0].split("\\.");


		/*
		int len=args.length;
		//인수로 넘긴 문자열을 실제 정수화 시켜 반환
		int dan=Integer.parseInt(args[0]);
		for(int i=1; i<=9; i++){
			System.out.println(dan+"*"+i+"="+dan*i);
		//배열의 0번째 단어
		//System.out.println(args[0]);
		//원하는 인수를 담아서 나오게끔
		
		//System.out.println(args);
		//System.out.println("당신이 넘긴 배열의 길이는"+len);
		*/
		//}
	}
}
