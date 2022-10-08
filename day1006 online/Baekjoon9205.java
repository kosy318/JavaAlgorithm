package com.day1006;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
	int x = 0, y = 0;
	Point prev = null;
	Point next = null;

	public Point() {
	}
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public Point(int x, int y, Point prev) {
		this.x = x;
		this.y = y;
		this.prev = prev;
	}
};

public class Baekjoon9205 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 0; t < tc; t++) {
			int n = Integer.parseInt(br.readLine());
			boolean possible = false;

			Queue<Point> que = new LinkedList<>();

			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
			que.offer(new Point(x, y));

			Point stores = new Point();
			Point start = stores;

			for (int i = 1; i <= n; i++) { // stores
				st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				stores.next = new Point(x, y, stores);
				stores = stores.next;
			}

			st = new StringTokenizer(br.readLine());
			Point festival = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

			while (!que.isEmpty()) {
				Point cur = que.poll();
				if ((Math.abs(cur.x - festival.x) + Math.abs(cur.y - festival.y)) <= 1000) {
					possible = true;
					break;
				}

				Point store = start;
				while (store != null) {
					if ((Math.abs(cur.x - store.x) + Math.abs(cur.y - store.y)) <= 1000) {
						que.offer(store);

						if(store.prev != null) (store.prev).next = store.next;
						else start = store.next;
						if(store.next != null) (store.next).prev = store.prev;
					}
					store = store.next;
				}
			}

			System.out.println((possible)? "happy" : "sad");
		}
	}

}
