package com.day0811;

import java.util.Scanner;

public class Baekjoon2961 {
	
	static int[][] foods;
	static int answer = Integer.MAX_VALUE, N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		foods = new int[N][2];  // 0: 신맛, 1: 쓴맛
		for(int i=0; i<N; i++) {
			foods[i] = new int[] {sc.nextInt(), sc.nextInt()};			
		}
		subset(0, -1, 0);
		System.out.println(answer);
	}

	private static void subset(int index, int sour, int bitter) {
		if(index == N) {
			if(bitter != 0) answer = Math.min(answer, Math.abs(sour+bitter));
			return;
		}
		
		subset(index+1, sour, bitter);
		subset(index+1, sour*foods[index][0], bitter+foods[index][1]);
	}
	
}
