package com.day0819;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baekjoon17135 {
	
	static int[][] dis;
	static int[][] map;
	static int[] numbers = new int[3];
	static int N, M, D;
	static ArrayList<Point> enemy;
	static int answer = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][M];
		enemy = new ArrayList<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) enemy.add(new Point(i,j));
			}
		}
		
		for(int i=M-3; i<M; i++) map[N][i] = 1;
		
		dis = new int[enemy.size()][3];
		
		setArcher(0, 0);
		
		System.out.println(answer);
	}

	public static void setArcher(int cnt, int start) {
		if(cnt == 3){
			getDistance();
			answer = Math.max(answer, kill());
			return;
		}
		for(int i=start; i<M; i++) {
			numbers[cnt] = i;
			setArcher(cnt+1, i+1);
		}
	}

	private static void getDistance() {
		for(int i=0; i<enemy.size(); i++) {
			for(int j=0; j<3; j++) {
				dis[i][j] = manhattanDis(enemy.get(i), new Point(N, numbers[j]));
			}
		}
	}

	public static int manhattanDis(Point p1, Point p2) {
		return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
	}
	
	private static int kill() {
		int[] dead = new int[enemy.size()];
		int turn = 0, killed = 0, range = D, out = 0;
		boolean end = true;
		while(killed + out < enemy.size()) {
			for(int i=0; i<enemy.size(); i++) {
				if(dead[i] == 0) {
					if(enemy.get(i).x+turn < N) end = false;
					else {
						out += 1;
						dead[i] = 1;
					}
				}
			}
			
			if(end || killed+out>=enemy.size()) return killed;
			
			int[] picked = new int[] {-1, -1, -1};
			for(int i=0; i<3; i++) {
				int distance = Integer.MAX_VALUE, y = Integer.MAX_VALUE;
				for(int j=0; j<enemy.size(); j++) {
					if(dead[j] == 0 && dis[j][i] <= range) {
						if((distance>dis[j][i]) || (distance == dis[j][i] && y>enemy.get(j).y)) {
							picked[i] = j;
							distance = dis[j][i];
							y = enemy.get(picked[i]).y;
						}
					}
				}
			}
			for(int who : picked) {
				if(who != -1 && dead[who]==0) {
					dead[who] = 1;
					killed++;
				}
			}
			
			range++;
			turn++;
		}
		
		return killed;
	}

}
