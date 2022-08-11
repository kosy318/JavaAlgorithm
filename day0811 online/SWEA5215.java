package com.day0811;

import java.util.Scanner;

public class SWEA5215 {
	
	static int N, calLimit;
	static int[][] foods;
	static int answer;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1; t<=tc; t++) {
			N = sc.nextInt();
			calLimit = sc.nextInt();
			answer = 0;
			
			foods = new int[N][2];  // 0: 점수, 1: 칼로리
			for(int i=0; i<N; i++) {
				foods[i] = new int[] {sc.nextInt(), sc.nextInt()};
			}
			
			subset(0,0,0);
			System.out.println("#" + t + " " +answer);
		}
	}

	private static void subset(int index, int taste, int limit) { 
		if(index == N) {
			answer = Math.max(answer, taste);
			return;
		}
		
		subset(index+1, taste, limit);
		if(limit+foods[index][1] > calLimit) return;
		subset(index+1, taste+foods[index][0], limit+foods[index][1]);
	}
	
}
