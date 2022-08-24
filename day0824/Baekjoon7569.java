package com.day0824;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon7569 {
	
	static class Tomato{
		int x, y;
		int time;
		
		public Tomato(int x, int y, int time) {
			super();
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}
	
	public static void main(String[] args) throws Exception {
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		Queue<Tomato> tomatoQue = new ArrayDeque<>();
		
		int[][] tomatoBox = new int[N][M];
		int total = N*M;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				tomatoBox[i][j] = Integer.parseInt(st.nextToken());
				if(tomatoBox[i][j] == 1) tomatoQue.add(new Tomato(i, j, 0));
				else if(tomatoBox[i][j] == -1) total -= 1;
			}
		}
		
		Tomato cur = null;
		while(!tomatoQue.isEmpty()) {
			cur = tomatoQue.poll();
			total -= 1;
			
			for(int i=0; i<4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				if(nx<0 || ny<0 || nx>=N || ny>=M || tomatoBox[nx][ny]!=0) continue;
				tomatoBox[nx][ny] = 1;
				tomatoQue.add(new Tomato(nx, ny, cur.time+1));
			}
		}
		
		System.out.println((total==0)? cur.time : -1);
	}

}
