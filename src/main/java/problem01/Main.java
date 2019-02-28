package problem01;

import java.util.Random;
import java.util.Scanner;


public class Main {
	
	// 게임 변수들
	public static int min = 1;
	public static int max = 100;
	public static int count = 0;
	public static int randomNumber = new Random().nextInt(max) + min;
	
	public static void main(String[] args) {
		
		// 키보드 입력을 받기 위해 Scanner 생성
		Scanner scanner = new Scanner(System.in);
		
		// 게임 시작
		while( true ) {
	
			System.out.print( "[" + min + "-" + max + "] 사이의 값 입력:" );
			int answer = scanner.nextInt();
			
			boolean result = checkAnswer( answer );
			if ( result ) {
				break;
			}
		
			System.out.println("");
		}
		
		// 키보드 닫기
		scanner.close();
		
		// 결과 출력
		System.out.println("\n맞췄습니다. 총 실행 횟수는 " + count + "번 입니다.");
	}
	
	public static boolean checkAnswer(int answer) {
		
		if(answer == randomNumber) {
			count++;
			return true;
		}
			
		
		if(answer<min) {
			System.out.println(min+"이상의 수를 입력해주셔야 합니다.");
			return false;
		}
		
		if(answer <=max) {
			if(answer>randomNumber)
				max = answer;
			else
				min = answer;				
		}
	
		count++;
	
		return false;
	}
}