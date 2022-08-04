package com.day0803;

import java.util.Scanner;

// 구간합
public class Prof_Baekjoon11659 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 입력될 숫자 개수
		int M = sc.nextInt(); // 구간합 연산 개수
		
		int[] nums = new int[N + 1]; // 0번 인덱스는 사용x
		int[] sums = new int[N + 1]; // 입력되는 수들의 누적값 저장 배열
		
		for(int i=1; i<nums.length; i++) {
			nums[i] = sc.nextInt();
			sums[i] = sums[i-1] + nums[i]; // 바로 앞 칸의 누적 값에 방금 입력된 값을 더해서 새로운 누적값을 생성
		}
		
		for(int i=0; i<M; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			
			System.out.println(sums[end] - sums[start-1]);
		}
	}

}
