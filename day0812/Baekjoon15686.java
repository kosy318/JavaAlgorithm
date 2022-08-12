package com.day0812;

import java.util.ArrayList;
import java.util.Scanner;

public class Baekjoon15686 {
	
	static int answer = Integer.MAX_VALUE;
	static int N, chickenLimit;
	static ArrayList<int[]> house;
	static ArrayList<int[]> chicken;
	static int[] numbers;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		chickenLimit = sc.nextInt();
		
		int[][] map = new int[N][N];
		numbers = new int[chickenLimit];
		
		// 1: 집, 2: 치킨집
		house = new ArrayList<>();
		chicken = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 1) {
					house.add(new int[]{i, j});
				} else if(map[i][j] == 2) {
					chicken.add(new int[]{i, j});
				}
			}
		}
		
		comb(0, 0);
		
		System.out.println(answer);
	}
	
	private static void comb(int cnt, int start) { // 치킨집 선택
		if(cnt == chickenLimit) {
			answer = Math.min(answer, cal());
			return;
		}
		
		for(int i=start; i<chicken.size(); i++) {
			numbers[cnt] = i;
			comb(cnt+1, i+1);
		}
	}
	
	private static int cal() { // 선택된 치킨집들의 도시의 치킨 거리
		int sum = 0;
		for(int i=0; i<house.size(); i++) {
			int[] h = house.get(i);
			int dis = Integer.MAX_VALUE;
			for(int idx : numbers) {
				int temp = manhattanDis(h, chicken.get(idx));
				if(dis > temp) dis = temp;
			}
			sum += dis;
		}
		return sum;
	}
	
	private static int manhattanDis(int[] h, int[] c) {
		return Math.abs(h[0]-c[0]) + Math.abs(h[1]-c[1]);
	}
	
}
