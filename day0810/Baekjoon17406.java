package com.day0810;

import java.util.Scanner;

public class Baekjoon17406 {
	
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int[] numbers;
	static boolean[] isSelected;
	static int N, M, K;
	static int min = Integer.MAX_VALUE;
	static int[][] orders;
	static int[][] map;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		orders = new int[K][3];

		numbers = new int[K];
		isSelected = new boolean[K];
		
		map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for(int i=0; i<K; i++) {
			orders[i] = new int[]{sc.nextInt(), sc.nextInt(), sc.nextInt()};
		}
		
		perm(0);
		
		
		System.out.println(min);
	}
	
	private static void perm(int cnt) {
		if(cnt == K) {
			turn();
			return;
		}
		for(int i=0; i<K; i++) {
			if(isSelected[i]) continue;
			numbers[cnt] = i;
			isSelected[i] = true;
			perm(cnt+1);
			isSelected[i] = false;
		}
	}

	private static void turn() {
		int[][] turnedMap = new int[N][M];
		for(int i=0; i<N; i++)
			turnedMap[i] = map[i].clone();
		
		for(int k : numbers) {
			int r = orders[k][0], c = orders[k][1], s = orders[k][2];
			int x1 = r-s-1, y1 = c-s-1;
			int x2 = r+s-1, y2 = c+s-1;
			
			while(x1<x2 && y1<y2) {
				int x = x1, y = y1;
				int startValue = turnedMap[x][y];

				int dir = 0;
				while(dir < 4) {
					int nx = x+dx[dir];
					int ny = y+dy[dir];
					if(nx>=x1 && ny>=y1 && nx<=x2 && ny<=y2) {
						turnedMap[x][y] = turnedMap[nx][ny];
						x = nx;
						y = ny;
					} else dir += 1;
				}
				turnedMap[x1][y1+1] = startValue;
				
				x1 += 1; y1 += 1;
				x2 -= 1; y2 -= 1;
			}
		}
		
		for(int i=0; i<N; i++) {
			int row = 0;
			for(int j=0; j<M; j++) {
				row += turnedMap[i][j];
			}
			
			min = Math.min(row, min);
		}
	}

}
