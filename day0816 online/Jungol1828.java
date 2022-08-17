package com.day0816;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Jungol1828 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		int[][] temp = new int[N][2];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			temp[i][0] = Integer.parseInt(st.nextToken());
			temp[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(temp, (o1, o2) -> o1[0] - o2[0]);
		
		int cnt = 1;
		int compare = temp[0][1];
		for(int i=0; i<N; i++) {
			if(compare >= temp[i][0]) {
				if(compare >= temp[i][1])
					compare = temp[i][1];
			} else {
				compare = temp[i][1];
				cnt += 1;
			}
		}
		
		System.out.println(cnt);
	}

}
