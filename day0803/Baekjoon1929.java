package com.day0803;

import java.util.Scanner;

public class Baekjoon1929 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		int[] primeNums = new int[N+1];
		primeNums[2] = 1;
		
		StringBuffer answer = new StringBuffer();

		for(int i=2; i<=N; i++) {
			if(primeNums[i] != -1) {
				primeNums[i] = 1;
				for(int j=2*i; j<=N; j+=i) primeNums[j] = -1;
			}
		}
		
		
		for(int i=M; i<=N; i++) {
			if(primeNums[i] == 1) answer.append(i + "\n");
		}
		System.out.println(answer);
	}

}
