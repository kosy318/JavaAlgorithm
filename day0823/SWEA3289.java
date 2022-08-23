package com.day0823;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA3289 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
			
			int[] set = new int[n+1];
			StringBuilder answer = new StringBuilder();
			
			make(set, n);
			
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int order = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
				
				if(order == 0)
					union(set, a, b);
				else if(a==b || find(set, set[a])==find(set, set[b]))
					answer.append(1);
				else if(find(set, set[a])!=find(set, set[b]))
					answer.append(0);
			}
			
			System.out.println("#" + t + " " + answer);
		}
	}

	static void make(int[] set, int n) {
		for(int i=1; i<=n; i++) {
			set[i] = i;
		}
	}
	
	static int find(int[] set, int a) {
		if(set[a] == a) return a;
		return set[a] = find(set, set[a]);
	}
	
	static void union(int[] set, int a, int b) {
		int aRoot = find(set, a);
		int bRoot = find(set, b);
		
		if(aRoot == bRoot) return;
		
		set[bRoot] = aRoot;
	}


}
