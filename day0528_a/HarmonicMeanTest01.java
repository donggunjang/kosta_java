// 사용자한테 두 수를 입력받아 "조화평균"을 구하여 출력하는 프로그램을 작성
import java.util.Scanner;

class NotHarmonicmeanException extends Exception{
	public NotHarmonicmeanException(String message){
		super(message);
	}
}

class  HarmonicMeanTest01{
	public static void main(String[] args) {

		try{
			Scanner sc = new Scanner(System.in);
			int a,b,mean;
			System.out.println("첫번째 수 입력:");
			a = sc.nextInt();
			System.out.println("두번째 수 입력:");
			b = sc.nextInt();
			
			if(a == -b){
				throw new NotHarmonicmeanException(a+"와"+b+"의 조화평균은 있을수가 없다.");
			}

			mean = (2*a*b) / (a+b);
			System.out.println("두 수의 조화평균은 :"+ mean);
		}catch(NotHarmonicmeanException e){
			System.out.println("예외 발생:" +e.getMessage());
		}
	}
}
