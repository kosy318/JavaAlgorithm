package com.day0817;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA5644 {
	
	static int[][] dir = {{0,0}, {-1,0}, {0,1}, {1,0}, {0,-1}};
	static int A, M, answer = 0;
	static int[][][] map;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] order_A, order_B;
	
	public static void main(String[] args) throws Exception {
		int tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++) {
			
			answer = 0;
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			
			order_A = new int[M];
			order_B = new int[M];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<M; i++)
				order_A[i] = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<M; i++)
				order_B[i] = Integer.parseInt(st.nextToken());
			
			makeMap();
			move();
			
			System.out.println("#" + t + " " + answer);
		}
	}

	private static void move() {
		int x_A = 1, y_A = 1;
		int x_B = 10, y_B = 10;

		calc(map[x_A][y_A], map[x_B][y_B]);
		
		for(int i=0; i<M; i++) {
			x_A += dir[order_A[i]][0];
			y_A += dir[order_A[i]][1];
			
			x_B += dir[order_B[i]][0];
			y_B += dir[order_B[i]][1];

			calc(map[x_A][y_A], map[x_B][y_B]);
		}
	}

	private static void calc(int[] cur_A, int[] cur_B) {
		int a = findMaxIdx(cur_A, -1), b;
		if(cur_A[a] != 0)
			b = findMaxIdx(cur_B, a);
		else b = findMaxIdx(cur_B, -1);
		
		int temp1 = cur_A[a] + cur_B[b];
		
		b = findMaxIdx(cur_B, -1);
		if(cur_B[b] != 0)
			a = findMaxIdx(cur_A, b);
		else a = findMaxIdx(cur_A, -1);
		
		int temp2 = cur_A[a] + cur_B[b];
		
		answer += Math.max(temp1, temp2);
	}

	private static int findMaxIdx(int[] arr, int x) {
		int idx = 0;
		int max = Integer.MIN_VALUE;
		for(int i=0; i<A; i++) {
			if(i == x) continue;
			if(arr[i] > max) {
				idx = i;
				max = arr[i];
			}
		}
		return idx;
	}

	private static void makeMap() throws Exception {
		map = new int[11][11][A];
		for(int a=0; a<A; a++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken()), x = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			
			int cnt = 0, add = 1;
			for(int i=x-C; i<=x+C; i++) {
				cnt += add;
				if(i>0 && i<=10)
					for(int j=0; j<cnt; j++) {
						if(y-j>0) map[i][y-j][a] = P;
						if(y+j<=10) map[i][y+j][a] = P;
					}
				if(i==x) add = -1;
			}
		}
	}

}
