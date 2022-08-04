package com.day0803;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prof_Baekjoon11660 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 입력 숫자 개수
		int M = Integer.parseInt(st.nextToken());
		
		int[][] sums = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++) { // 행
			st = new StringTokenizer(br.readLine());
			
			for(int j=1; j<=N; j++) {
				sums[i][j] = sums[i][j-1] + Integer.parseInt(st.nextToken());
			}
		} // 입력받고 누적합까지 구함
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			int sum = 0;
			for(int x=x1; x<=x2; x++) { // x: 행값
				sum += sums[x][y2] - sums[x][y1-1]; // x행의 합
			}
			
			sb.append(sum + "\n");
		}
		
		System.out.println(sb);
	}

}
