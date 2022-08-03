package com.day0801;

import java.util.Scanner;

public class Prof_Baekjoon17478 {
	
	static StringBuffer buffer;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 반복할 횟수
		
		buffer = new StringBuffer();
		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다."); // 반복 안되는 첫 문장
		
		// N번 반복하러 감. 반복시마다 달라지는 값 체크(_ 개수가 달라짐)
		recur(N, ""); // 반복을 제어할 값 -> parameter로 전달해서 사용함
		
		System.out.println(buffer); // 결과 출력
	}

	private static void recur(int num, String underBar) {
		buffer.append(underBar + "\"재귀함수가 뭔가요?\"\n");

		// 종료 조건
		if(num == 0) {
			buffer.append(underBar + "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
			buffer.append(underBar + "라고 답변하였지.\n");
			return;
		}
		
		// 반복 조건
		buffer.append(underBar + "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n");
		buffer.append(underBar + "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");
		buffer.append(underBar + "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");
		
		// 다음 반복을 위해 새로운 값 준비; _ 4개씩 추가됨
		// 재귀호출
		recur(num-1, underBar+"____");
		
		// 재귀호출 후 마무리 작업
		buffer.append(underBar + "라고 답변하였지.\n");
	}

}
