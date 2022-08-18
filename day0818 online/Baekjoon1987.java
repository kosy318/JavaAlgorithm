package com.day0818;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1987 {
	
	static int R, C;
	static char[][] map;
	static int[] dir_x = {-1, 1, 0, 0};
	static int[] dir_y = {0, 0, -1, 1};
	static int answer = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][];
		
		for(int i=0; i<R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		go(0, 0, 0, 1);
		System.out.println(answer);
	}

	private static void go(int x, int y, int flag, int cnt) {
		flag |= 1<<(map[x][y]-'A');
		
		boolean end = true;
		for(int i=0; i<4; i++) {
			int nx = x + dir_x[i];
			int ny = y + dir_y[i];
						
			if(nx>=0 && nx<R && ny>=0 && ny<C) {
				if((flag & 1<<map[nx][ny]-'A') != 0) continue;
				end = false;
				go(nx, ny, flag|1<<(map[nx][ny]-'A'), cnt+1);
			}
		}
		if(end)
			answer = Math.max(answer, cnt);
	}
	

}
