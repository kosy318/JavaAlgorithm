package com.day0819;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA3234 {
	
	static int N, totalCnt;
	static int[] weights;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		StringBuilder answer = new StringBuilder();
		
		for(int t=1; t<=tc; t++) {
			totalCnt = 0;
			N = Integer.parseInt(br.readLine());
			weights = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++)
				weights[i] = Integer.parseInt(st.nextToken());
			
			for(int i=0; i<N; i++) {
				perm(1, weights[i], 0, 1<<i);
			}
			
			answer.append("#" + t + " " + totalCnt + "\n");
		}
		
		System.out.println(answer);
	}
	
	private static void perm(int cnt, int left, int right, int selected) {
		for(int i=0; i<N; i++) {
			if((selected & 1<<i) != 0) continue;
			if(left >= right+weights[i]) {
				if(cnt+1 == N) {
					totalCnt += 2;
					return;
				}
				perm(cnt+1, left, right+weights[i], selected | 1<<i);
			}
			if(cnt+1 == N) {
				totalCnt += 1;
				return;
			}
			perm(cnt+1, left+weights[i], right, selected | 1<<i);
		}
	}

}
