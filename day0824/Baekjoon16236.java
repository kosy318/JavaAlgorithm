package com.day0824;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon16236 {

	static class Fish {
		int x, y;
		int size;

		public Fish(int x, int y, int size) {
			super();
			this.x = x;
			this.y = y;
			this.size = size;
		}
	}

	static int[] dir_x = { -1, 0, 0, 1 };
	static int[] dir_y = { 0, -1, 1, 0 };

	static int N, sharkSize = 2, time = 0;
	static int[][] map;
	static Point cur = new Point(0, 0);
	static ArrayList<Fish> fishPoints;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		int cnt = 0;

		fishPoints = new ArrayList<>();

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				if (num != 0) {
					if (num == 9) {
						cur = new Point(i, j);
						continue;
					}
					map[i][j] = num;
				}
			}
		}

		while (go()) {
			cnt += 1;
			if (cnt == sharkSize) {
				cnt = 0;
				sharkSize += 1;
			}
		}

		System.out.println(time);
	}

	static class PointDis {
		int x, y;
		int dis;

		public PointDis(int x, int y, int dis) {
			super();
			this.x = x;
			this.y = y;
			this.dis = dis;
		}
	}

	private static boolean go() {
		Queue<PointDis> que = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][N];

		que.offer(new PointDis(cur.x, cur.y, 0));
		int queSize = 1;
		visited[cur.x][cur.y] = true;

		ArrayList<PointDis> canEat = new ArrayList<>();

		while (!que.isEmpty()) {
			queSize = que.size();
			for (int q = 0; q < queSize; q++) {
				PointDis p = que.poll();
				int num = map[p.x][p.y];
				if (num != 0 && num < sharkSize) {
					canEat.add(new PointDis(p.x, p.y, p.dis));
				}
				for (int i = 0; i < 4; i++) {
					int nx = p.x + dir_x[i];
					int ny = p.y + dir_y[i];

					if (nx < 0 || ny < 0 || nx >= N || ny >= N)
						continue;
					if (map[nx][ny] > sharkSize || visited[nx][ny])
						continue;
					que.offer(new PointDis(nx, ny, p.dis + 1));
					visited[nx][ny] = true;
				}
			}

			if (canEat.size() != 0)
				break;
		}

		if (canEat.size() == 0)
			return false;

		Collections.sort(canEat, (f1, f2) -> {
			if (f1.x != f2.x)
				return f1.x - f2.x;
			else {
				return f1.y - f2.y;
			}
		});
		
		map[canEat.get(0).x][canEat.get(0).y] = 0;
		time += canEat.get(0).dis;
		cur = new Point(canEat.get(0).x, canEat.get(0).y);

		return true;
	}

}
