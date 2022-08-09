package com.day0809;

import java.util.Scanner;

public class Baekjoon2563 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[][] map = new int[100][100];
		int answer = 0;
		for(int i=0; i<n; i++) {
			int y = sc.nextInt(), x = sc.nextInt();
			for(int j=100-(x+10); j<100-x; j++)
				for(int k=y; k<y+10; k++)
					if(map[j][k] == 0) {
						map[j][k] = 1;
						answer += 1;
					}
		}
		
		System.out.println(answer);
	}

}