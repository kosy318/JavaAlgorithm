package com.day0809;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Room{
	int startNo;
	int x, y;
	int cnt;
	
	public Room(int startNo, int x, int y, int cnt) {
		super();
		this.startNo = startNo;
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
	public Room(Room r) {
		this.startNo = r.startNo;
		this.x = r.x;
		this.y = r.y;
		this.cnt = r.cnt;
	}
	public Room(Room r, int x, int y) {
		this.startNo = r.startNo;
		this.x = x;
		this.y = y;
		this.cnt = r.cnt+1;
	}
}

public class SWEA1861 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++) {
			int N = Integer.parseInt(br.readLine());
			// start 숫자, 좌표, 이동한 칸(본인 포함)
			Queue<Room> que = new LinkedList<>();
			int[][] map = new int[N][N];
			
			StringTokenizer st;
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					
					que.offer(new Room(map[i][j], i, j, 1));
				}
			} // 입력 완료
			
			Room best = new Room(0, 0, 0, 0);
			int[] dir_x = {-1, 1, 0, 0};
			int[] dir_y = {0, 0, -1, 1};			
			while(!que.isEmpty()) {
				Room front = que.poll();
				if(best.cnt<front.cnt || (best.cnt==front.cnt && best.startNo>front.startNo))
					best = new Room(front);
				for(int i=0; i<4; i++) {
					int next_x = front.x + dir_x[i];
					int next_y = front.y + dir_y[i];
					if(next_x<N && next_x>=0 && next_y<N && next_y>=0 &&
					   map[front.x][front.y]+1 == map[next_x][next_y]) {
						que.offer(new Room(front, next_x, next_y));
					}
					
				}
			}
			
			System.out.println("#" + t + " " + best.startNo + " " + best.cnt);
		}
	}
	
}
