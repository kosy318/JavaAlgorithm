package com.day0824;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon3055 {
	
	static class Node{
		boolean isWater;
		int x, y;
		int time;
		
		public Node(boolean isWater, int x, int y, int time) {
			super();
			this.isWater = isWater;
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[R][C];
		boolean[][] visited = new boolean[R][C];
		Queue<Node> que = new ArrayDeque<>();
		Node start = null;
		
		for(int i=0; i<R; i++) {
			map[i] = br.readLine().toCharArray();
			for(int j=0; j<C; j++) {
				if(map[i][j] == 'S') {
					start = new Node(false, i, j, 0);
					visited[i][j] = true;
				}
				else if(map[i][j] == '*') que.add(new Node(true, i, j, 0));
			}
		}
		que.add(start);
		
		while(!que.isEmpty()) {
			Node cur = que.poll();
				
			for(int j=0; j<4; j++) {
				int nx = cur.x + dx[j];
				int ny = cur.y + dy[j];
				
				if(nx<0 || ny<0 || nx >=R || ny>=C || map[nx][ny]=='X' || map[nx][ny]=='*') continue;
				if(cur.isWater) {
					if(map[nx][ny]=='D') continue;
					map[nx][ny] = '*';
				} else {
					if(visited[nx][ny]) continue;
					if(map[nx][ny]=='D') {
						System.out.println(cur.time+1);
						return;
					}
					visited[nx][ny] = true;
				}
				que.offer(new Node(cur.isWater, nx, ny, cur.time+1));
			}
		}
		
		System.out.println("KAKTUS");
	}

}
