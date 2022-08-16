package com.day0816;

import java.util.Scanner;

public class Baekjoon2839 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int five = N/5, three;
		do {
			three = (N-5*five) / 3;
			if(five*5+three*3 == N) {
				System.out.println(five + three);
				return;
			}
		} while(five-- != 0);
		
		System.out.println(-1);
	}

}
