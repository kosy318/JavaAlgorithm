package com.day0802;

import java.util.Scanner;

public class SWEA1954 {
	
	public static void main(String[] args) {
	    // 오른쪽 아래 왼쪽 위 순서대로
	    int[] dx = {0, 1, 0, -1};
	    int[] dy = {1, 0, -1, 0};

	    Scanner sc = new Scanner(System.in);
	    int tc = sc.nextInt();
	    for(int t=1; t <=tc; t++){
	        int N = sc.nextInt();
	        int[][] snails = new int[N][N];

	        int x = 0, y = 0, dir = 0;
	        for(int i=1; i<N*N+1; i++){
	            snails[x][y] = i;
	            if(i == N*N) break;
	            while(x+dx[dir] >= N || y+dy[dir] >= N || x+dx[dir] < 0 || y+dy[dir] < 0 || snails[x+dx[dir]][y+dy[dir]] != 0)
	                dir = (dir+1)%4;
	            
	            x = x+dx[dir];
	            y = y+dy[dir];
	        }

	        System.out.println("#" + t);
	        for(int[] vec: snails){
	            for(int snail: vec){
	            	System.out.print(snail + " ");
	            }
	            System.out.println();
	        }
	    }
	}
	
}
