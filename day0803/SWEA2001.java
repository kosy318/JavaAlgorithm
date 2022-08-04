package com.day0803;

import java.util.Scanner;

public class SWEA2001 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for(int tc=1; tc<=t; tc++){
			int kill = 0, n, m;
			n = sc.nextInt();
			m = sc.nextInt();
			
			int[][] map = new int[n][n];
			for(int i=0; i<n; i++){
				for(int j=0; j<n; j++){
					map[i][j] = sc.nextInt();
				}
			}
			
			int[] pivot = {0, 0};
			while(true){
				int temp = 0;
				for(int i=pivot[0]; i<pivot[0]+m; i++){
					for(int j=pivot[1]; j<pivot[1]+m; j++){
						temp += map[i][j];
					}
				}
				if(kill < temp) kill = temp;
				
				pivot[1] += 1;
				if(pivot[1]+m-1 == n){
					pivot[0] += 1;
					pivot[1] = 0;
				}
				if(pivot[0]+m-1 == n) break;
			}
			
			System.out.println("#" + tc + " " + kill);
		}
	}

}
