package com.day0810;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Coord{
	int x, y;

	public Coord(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}

public class Baekjoon16926 {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N=sc.nextInt(), M=sc.nextInt(), R=sc.nextInt();
		
		int[][] map = new int[N][M];
		for(int i=0; i<N; i++){
			for(int j=0; j<M; j++){
				map[i][j] = sc.nextInt();
			}
		}
		
		int i=0;
		List<List<Coord>> coordList = new ArrayList<>();
		while(i < Math.min(N, M)/2) {
			List<Coord> temp = new ArrayList<>();
			
			for(int j=i; j<M-i; j++) // i,i .. i,M-i-1
				temp.add(new Coord(i, j));
			for(int j=i+1; j<N-i; j++) // i+1,M-i-1 .. N-i-1,M-i-1
				temp.add(new Coord(j, M-i-1));
			for(int j=M-i-2; j>=i; j--) // N-i-1,M-i-2 .. N-i-1,i
				temp.add(new Coord(N-i-1, j));
			for(int j=N-i-2; j>=i+1; j--) // N-i-2,i .. i+1,i
				temp.add(new Coord(j, i));
			
			coordList.add(temp);
			i += 1;
		}
		
		int[][] ansMap = new int[N][M];
		for(List<Coord> list : coordList) {
			int putIdx = 0;
			for(int idx=R%list.size(); idx<list.size(); idx++) {
				int x = list.get(idx).x, y = list.get(idx).y;
				int putX = list.get(putIdx).x, putY = list.get(putIdx).y;
				ansMap[putX][putY] = map[x][y];
				putIdx++;
			}
			
			for(int idx=0; idx<R%list.size(); idx++){
				int x = list.get(idx).x, y = list.get(idx).y;
				int putX = list.get(putIdx).x, putY = list.get(putIdx).y;
				ansMap[putX][putY] = map[x][y];
				putIdx++;
			}
		}
		
		for(int n=0; n<N; n++){
			for(int m=0; m<M; m++){
				System.out.print(ansMap[n][m] + " ");
			}
			System.out.println();
		}
	}
	
}
