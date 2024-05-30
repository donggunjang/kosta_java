// 프로그램 실행시에 두 개의 정수를 전달받아 나누기한 결과를 출력
// java Calc 4 2

class Calc05 {
	public static void main(String[] args) {
		try{
			int a = Integer.parseInt(args[0]);
			int b = Integer.parseInt(args[1]);
			int div = a/b;
			System.out.println("나누기결과:"+div);
		}catch(ArithmeticException e){
			System.out.println("0으로 나눌수가 없어요");
		}catch(Exception e){
			System.out.println("나누기 할 두개의 정수를 확인해 주세요");
		}
	}
}
