package com.day0818;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1247 {
	
	static Point house, company;
	static Point[] customer;
	static int[][] distance;
	static int answer, N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++) {
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			
			answer = Integer.MAX_VALUE;
			company = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			house = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			customer = new Point[N];
			distance = new int[N+2][N+2]; // N : 회사, N+1 : 집
			
			for(int i=0; i<N; i++) {
				customer[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			getDistance();
			go(0, N, 0, 0);
			
			System.out.println("#" + t + " " + answer);
		}
	}
	
	private static void go(int cnt, int start, int dis, int flag) {
		if(cnt == N) {
			answer = Math.min(answer, dis+distance[start][N+1]);
			return;
		}
		for(int i=0; i<N; i++) {
			if((flag & 1<<i) != 0 || dis+distance[start][i] >= answer) continue;
			go(cnt+1, i, dis+distance[start][i], flag|1<<i);
		}
	}

	private static void getDistance() {
		for(int i=0; i<N; i++) {
			distance[N][i] = manhattanDis(company, customer[i]);
			distance[i][N+1] = manhattanDis(house, customer[i]);
			for(int j=0; j<N; j++)
				distance[i][j] = manhattanDis(customer[i], customer[j]);
		}
	}

	private static int manhattanDis(Point p1, Point p2) {
		return Math.abs(p1.x-p2.x) + Math.abs(p1.y-p2.y);
	}

}
