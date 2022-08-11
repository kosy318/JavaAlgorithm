package com.day0811;

import java.util.Scanner;

public class Baekjoon3040 {
	
	static int[] input = new int[9];
	static int[] numbers = new int[7];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int i=0; i<9; i++)
			input[i] = sc.nextInt();
		
		comb(0, 0, 0);
	}
	
	private static void comb(int cnt, int start, int total) {
		if(cnt == 7) {
			if(total == 100)
				for(int i : numbers) System.out.println(i);
			return;
		}
		
		for(int i=start; i<9; i++) {
			if(total+input[i] > 100) continue;
			numbers[cnt] = input[i];
			comb(cnt+1, i+1, total+input[i]);
		}
	}

}
