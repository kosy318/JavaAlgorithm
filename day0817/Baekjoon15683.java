package com.day0817;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baekjoon15683 {
	
	static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	static ArrayList<int[][]> cctvDir = new ArrayList<>();
	static int K, N, M, answer = Integer.MAX_VALUE;
	static int[] numbers;
	static int[][] map;
	static ArrayList<Point> cctv = new ArrayList<>();
	static ArrayList<Point> wall = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		cctvDir.add(new int[][] {{0}, {1}, {2}, {3}});
		cctvDir.add(new int[][] {{2, 0}, {1, 3}, {2, 0}, {1, 3}});
		cctvDir.add(new int[][] {{3, 0}, {0, 1}, {1, 2}, {2, 3}});
		cctvDir.add(new int[][] {{2, 3, 0}, {3, 0, 1}, {0, 1, 2}, {1, 2, 3}});
		cctvDir.add(new int[][] {{2, 3, 0, 1}, {2, 3, 0, 1}, {2, 3, 0, 1}, {2, 3, 0, 1}});
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] != 0 && map[i][j] != 6) {
					cctv.add(new Point(i, j));
				} else if(map[i][j] == 6) {
					wall.add(new Point(i, j));
				}
			}
		}
		
		K = cctv.size();
		numbers = new int[K];
		
		perm(0);
		System.out.println(answer);
	}
	
	private static void perm(int cnt) {
		if(cnt == K) {
			check();
			return;
		}
		
		for(int i=0; i<4; i++) {
			numbers[cnt] = i;
			perm(cnt+1);
		}
	}

	private static void check() {
		int[][] copyMap = new int[N][M];
		for(int i=0; i<wall.size(); i++) {
			copyMap[wall.get(i).x][wall.get(i).y] = 6;
		}
		for(int k=0; k<K; k++) {
			int x = cctv.get(k).x, y = cctv.get(k).y;
			int num = map[x][y]-1;
			copyMap[x][y] = num+1;
			int[] direction = cctvDir.get(num)[numbers[k]];
			
			for(int idx : direction) {
				int[] w = dir[idx];
				int i = x, j = y;
				while(i>=0 && i<N && j>=0 && j<M) {
					if(map[i][j] == 0) copyMap[i][j] = -1;
					else if(map[i][j] == 6) break;
					i += w[0];
					j += w[1];
				}
			}
		}
		
		answer = Math.min(countBlind(copyMap), answer);
	}

	private static int countBlind(int[][] copyMap) {
		int cnt = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(copyMap[i][j] == 0) cnt++;
			}
		}
		return cnt;
	}
}
