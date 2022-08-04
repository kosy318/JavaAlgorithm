package com.day0803;

import java.util.HashMap;
import java.util.Scanner;

public class SWEA1873 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int t=1; t<=tc; t++) {
			int H = sc.nextInt();
			int W = sc.nextInt();
			
			char[][] map = new char[H][];
			
			char heading = 'U';
			int[] cur = new int[2];

			HashMap<Character, char[]> hash = new HashMap<>();
			hash.put('U', new char[]{'^', '0'});
			hash.put('D', new char[]{'v', '1'});
			hash.put('L', new char[]{'<', '2'});
			hash.put('R', new char[]{'>', '3'});
			hash.put('^', new char[]{'U'});
			hash.put('v', new char[]{'D'});
			hash.put('<', new char[]{'L'});
			hash.put('>', new char[]{'R'});
			
			for(int i=0; i<H; i++) { // map 입력
				map[i] = sc.next().toCharArray();
//				System.out.println(Arrays.toString(map[i]));	
				for(int j=0; j<W; j++) {
					if(map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<' || map[i][j] == '>') {
						heading = hash.get(map[i][j])[0];
						map[i][j] = '.';
						cur[0] = i; cur[1] = j;
					}
				}
			}
			
			int num = sc.nextInt();
			char[] inputs = sc.next().toCharArray();
			int[] shoot;
			
			int[] dir_x = {-1, 1, 0, 0};
			int[] dir_y = {0, 0, -1, 1};
			
			for(char ch : inputs) {
				if(ch == 'S') {
					shoot = new int[] {cur[0], cur[1]};
					while(shoot[0]>=0 && shoot[0]<H && shoot[1]>=0 && shoot[1]<W) {
						if(map[shoot[0]][shoot[1]] == '*') {
							map[shoot[0]][shoot[1]] = '.';
							break;
						} else if(map[shoot[0]][shoot[1]] == '#') break;
						
						int dir = hash.get(heading)[1] - '0';
						shoot[0] += dir_x[dir];
						shoot[1] += dir_y[dir];
					}
				} else {
					heading = ch;
					int dir = (hash.get(ch))[1] - '0';
					if(cur[0]+dir_x[dir]>=0 && cur[0]+dir_x[dir]<H &&
					   cur[1]+dir_y[dir]>=0 && cur[1]+dir_y[dir]<W &&
					   map[cur[0]+dir_x[dir]][cur[1]+dir_y[dir]] == '.') {
						cur[0] += dir_x[dir];
						cur[1] += dir_y[dir];
					}
				}				
//				System.out.println(ch);
//				map[cur[0]][cur[1]] = heading;
//				for(char[] chs : map) {
//					for(char ch2 : chs) {
//						System.out.print(ch2);
//					}
//					System.out.println();
//				}System.out.println();
//				map[cur[0]][cur[1]] = '.';
			} // 사용자 입력에 따른 상태 변화 완료
			
			map[cur[0]][cur[1]] = hash.get(heading)[0];
			
			System.out.print("#" + t + " ");
			for(char[] chs : map) {
				for(char ch : chs) {
					System.out.print(ch);
				}
				System.out.println();
			}
		}
}

}
