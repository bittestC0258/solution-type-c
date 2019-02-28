package problem04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Test implements Comparable<Test>{
	private int success;
	private int fail;
	private long time;

	public Test(int success, int fail, long time) {
		this.success = success;
		this.fail = fail;
		this.time = time;
	}


	public int getSuccess() {
		return success;
	}

	public void setSuccess(int success) {
		this.success = success;
	}

	public int getFail() {
		return fail;
	}

	public void setFail(int fail) {
		this.fail = fail;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}


	@Override
	public int compareTo(Test o) {
		
		return (int)(time - o.time);
	}

}

class Game {

	int[][] gugudan = new int[10][2]; // 1~9단까지 2문제를 저장한다.

	public Game() {
		// 초기화 시 게임이 생성된다.
		for (int i = 1; i <= 9; i++) {
			gugudan[i][0] = (int) (Math.random() * 9) + 1;
			// gugudan[i][1] = (int)(Math.random()*9)+1;

			do {
				gugudan[i][1] = (int) (Math.random() * 9) + 1;
			} while (gugudan[i][1] == gugudan[i][0]);

		}

		// 생성된 게임 출력

		for (int i = 1; i <= 9; i++) {
			String s = "";
			for (int j = 0; j < 2; j++) {
				s += i + "x" + gugudan[i][j] + ",";
			}

			s = s.substring(0, s.length() - 1); // 마지막 ',' 제거 
			System.out.println(s);
		}
		System.out.println();
	}
	
	public Test gugudanTest() {
		Scanner sc = new Scanner(System.in);	
		
		long time = 0;
		int success = 0;
		int fail = 0;
		
		//총 10문제 출제
		for(int i=1; i<=10; i++) {
			
			int dan = (int) (Math.random() * 9) + 1;
			int num = (int) (Math.random() * 2);
					
			long start = System.currentTimeMillis();

			System.out.println(i+". "+dan+"x"+gugudan[dan][num]+" ?");
			System.out.print("입력: ");
			int result = sc.nextInt();
			
			if(result == dan*gugudan[dan][num])
				success++;
			else
				fail++;		
	
			long end = System.currentTimeMillis();
			System.out.println("시간: "+( end - start )/1000.0 +"초");
			
			time += ( end - start )/1000.0 ;
		}
		
		Test test = new Test(success, fail, time);
		
		return test;		
	}

}

public class Main {
	/*
	 * 문제 가정 
	 * 1. 1~9단까지 2문제씩 뽑을 때 각 단에서 중복 문제는 허용하지 않겠다.
	 *  2. 다시 랜덤으로 구구단 문제를 줄 때는 총 10문제를 제출하고 각 문제 별 소요 시간을 측정한다. 문제는 중복을 허용한다. 
	 * 3. 문제를 푼 회수별 게임시간, 성공, 실패 회수를 출력한다. 정렬 조건은 게임시간이 짧은 것을 높은 순위로 한다.
	 * 
	 */

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		List<Test> list = new ArrayList<Test>();

		while(true) {
			Game game = new Game();
			list.add(game.gugudanTest());
			
			System.out.println("게임을 종료하시겠습니까? Y/N");
			System.out.print("입력: ");
			char a = sc.nextLine().charAt(0);
			if(a=='Y'||a=='y')
				break;
		}
		
		Collections.sort(list);
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(i+1+" : 시간: "+list.get(i).getTime()+", 성공: "+list.get(i).getSuccess()+", 실패: "+list.get(i).getFail());
		}
		
	}

}