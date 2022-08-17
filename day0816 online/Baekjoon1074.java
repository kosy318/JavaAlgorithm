package com.day0816;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1074 {
	
	static int r, c, answer = -1;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		count(0, 0, 1<<N);
	}

	private static void count(int x, int y, int n) {
		if(x == r && y == c) {
			System.out.println(answer+1);
			return;
		}
		
		if(r<x+n && c<y+n && r>=x && c>=y) {
			count(x, y, n/2);
			count(x, y+n/2, n/2);
			count(x+n/2, y, n/2);
			count(x+n/2, y+n/2, n/2);
		} else answer += n*n;
	}

}
