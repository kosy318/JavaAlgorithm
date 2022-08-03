package com.day0803;

import java.util.Scanner;

public class SWEA1873 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int t=1; t<=tc; t++) {
			int H = sc.nextInt();
			int W = sc.nextInt();
			
			char[][] map = new char[H][];
			
			char heading = '^';
			int[] cur = new int[2];
			
			for(int i=0; i<H; i++) { // map 입력
				map[i] = sc.next().toCharArray();
//				System.out.println(Arrays.toString(map[i]));	
				for(int j=0; j<W; j++) {
					if(map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<' || map[i][j] == '>') {
						heading = map[i][j];
						map[i][j] = '.';
						cur[0] = i; cur[1] = j;
					}
				}
			}
			
			int num = sc.nextInt();
			char[] inputs = sc.next().toCharArray();
			int shoot = 0;
			
			for(char ch : inputs) {
				switch(ch) {
				case 'U':
					heading = '^';
					if(cur[0]-1>=0 && map[cur[0]-1][cur[1]] == '.') {
						cur[0] -= 1;
					}
					break;
				case 'D':
					heading = 'v';
					if(cur[0]+1<H && map[cur[0]+1][cur[1]] == '.') {
						cur[0] += 1;
					}					
					break;
				case 'L':
					heading = '<';
					if(cur[1]-1>=0 && map[cur[0]][cur[1]-1] == '.') {
						cur[1] -= 1;
					}					
					break;
				case 'R':
					heading = '>';
					if(cur[1]+1<W && map[cur[0]][cur[1]+1] == '.') {
						cur[1] += 1;
					}					
					break;
				case 'S':
					switch(heading) {
					case '^':
						shoot = cur[0];
						while(shoot >= 0) {
							if(map[shoot][cur[1]] == '*') {
								map[shoot][cur[1]] = '.';
								break;
							} else if(map[shoot][cur[1]] == '#') break;
							shoot -= 1;
						}
						break;
					case 'v':
						shoot = cur[0];
						while(shoot < H) {
							if(map[shoot][cur[1]] == '*') {
								map[shoot][cur[1]] = '.';
								break;
							} else if(map[shoot][cur[1]] == '#') break;
							shoot += 1;
						}
						break;
					case '<':
						shoot = cur[1];
						while(shoot >= 0) {
							if(map[cur[0]][shoot] == '*') {
								map[cur[0]][shoot] = '.';
								break;
							} else if(map[cur[0]][shoot] == '#') break;
							shoot -= 1;
						}
						break;
					case '>':
						shoot = cur[1];
						while(shoot < W) {
							if(map[cur[0]][shoot] == '*') {
								map[cur[0]][shoot] = '.';
								break;
							} else if(map[cur[0]][shoot] == '#') break;
							shoot += 1;
						}
						break;
					}
					break;
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
			
			map[cur[0]][cur[1]] = heading;
			
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
