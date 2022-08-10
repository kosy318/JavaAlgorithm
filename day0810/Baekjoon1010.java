package com.day0810;

import java.util.Scanner;

public class Baekjoon1010 {
	
	// 두번째 방법 용 저장 테이블
	static int[][] combTable = new int[30][30];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		StringBuffer answer = new StringBuffer();
		for(int t=0; t<tc; t++) {
			int N = sc.nextInt(), M = sc.nextInt();
			
			// 첫번째 방법
//			if(N == M) {
//				answer.append("1\n");
//				continue;
//			} else if(N == 1) {
//				answer.append(M + "\n");
//				continue;
//			}
//			
//			// 값만 알면됨
//			// nCr = n*...*(n-r-1) / r*...*1
//			int totalCnt = 1;
//			int div = 1;
//			for(int i=M; i>M-N; i--) {
//				totalCnt = (totalCnt*i)/div;
//				div++;
//			}
			
			// 두번째 방법
			// 이런 방법을 뭐라하지..?
			for(int i=1; i<30; i++) {
				combTable[i][1] = i;
				combTable[i][i] = 1;
			}
			int totalCnt = comb(M, N);
			
			
			answer.append(totalCnt + "\n");
		}
		
		System.out.print(answer);
	}

	// 두번째 방법용 method
	// nCr = n-1Cr-1 + n-1Cr
	private static int comb(int n, int r) {
		if(combTable[n][r] != 0) return combTable[n][r];
		else return combTable[n][r] = comb(n-1, r-1) + comb(n-1, r);
	}
}
