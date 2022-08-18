package com.day0818;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon3109 {
	
	static StringBuffer[] map;
	static int R, C, answer = 0;
	static int[] dir_x = {-1, 0, 1};
	static boolean success = false;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new StringBuffer[R];
		for(int i=0; i<R; i++) {
			map[i] = new StringBuffer(br.readLine().trim());
		}
		
		// 최대한 위쪽에 딱 붙어서 파이프가 연결되도록
		for(int i=0; i<R; i++) {
			success = false;
			dfs(i, 0);
		}
		
		System.out.println(answer);
	}

	private static void dfs(int x, int y) {
		map[x].setCharAt(y, 'x');
		if(y == C-1) {
			answer += 1;
			success = true;
			return;
		}
		
		for(int i=0; i<3; i++) {
			if(x+dir_x[i]<0 || x+dir_x[i]>=R || map[x+dir_x[i]].charAt(y+1) == 'x')
				continue;
			
			dfs(x+dir_x[i], y+1);
			if(success) break;
		}
	}	

}
