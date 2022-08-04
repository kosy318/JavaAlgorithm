package com.day0803;

import java.util.Scanner;

public class Prof_SWEA1873 {
	
	// 
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int tx, ty; // 전차의 좌표값
	static int H, W; // 배열의 행, 열
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // test case
		
		for(int tc=1; tc<=T; tc++) {
			H = sc.nextInt();
			W = sc.nextInt();
			
			char[][] map = new char[H][W];
			// 배열 안에 값을 입력 받으면서 전차의 위치 찾아놓기
			for(int i=0; i<H; i++) {
				map[i] = sc.next().toCharArray(); // 한 행 입력
				
				for(int j=0; j<W; j++) { // 한 행의 모든 열에 대해서 전차 여부 체크
					switch(map[i][j]) {
					case '^':
					case 'v':
					case '<':
					case '>':
						tx = i;
						ty = j;
						break;
					}
				}
			} // 입력 끝
			
			// 입력 완료 + 전차위치 파악(tx, ty)
			int N = sc.nextInt(); // 명령어 개수
			String command = sc.next(); // 명령어 한줄.
			
			for(int i=0; i<command.length(); i++) { // 명령 수 만큼 반복
				char c = command.charAt(i); // 명령어 한글자
				switch(c) {
				case 'U': // 전차를 위쪽으로 이동시켜라
					map[tx][ty] = '^'; // 탱크 위치 변경
					move(map, 0); // 해당 방향으로 탱크를 이동시켜봄. 방향구분값
					break;
				case 'D':
					map[tx][ty] = 'v'; // 탱크 위치 변경
					move(map, 1);
					break;
				case 'L':
					map[tx][ty] = '<'; // 탱크 위치 변경
					move(map, 2);
					break;
				case 'R':
					map[tx][ty] = '>'; // 탱크 위치 변경
					move(map, 3);
					break;
				case 'S':
					shoot(map);
					break;
				}
			}
			
			System.out.print("#" + tc + " ");
			for(char[] chars : map) {
				for(char ch : chars) {
					System.out.print(ch);
				}System.out.println();
			}
		}
	}

	// 가능한 경우 계속해서 포탄이 날아감.
	private static void shoot(char[][] map) {
		// 포탄이 날아가는 방향은 전차의 방향임
		// 현재 전차의 방향이 무슨 값인지 알아내야함
		
		int dir = 0; // 전차 방향
		switch(map[tx][ty]) { // map[tx][ty]에 전차의 방향이 들어있음. ^, v, <, >
		case '^':
			dir = 0;
			break;
		case 'v':
			dir = 1;
			break;
		case '<':
			dir = 2;
			break;
		case '>':
			dir = 3;
			break;
		}
		
		int nx = tx;
		int ny = ty;
		
		// 포탄은 계속 전진이 가능
		while(true) {
			// 포탄이 이동할 새 좌표 계산
			nx += dx[dir];
			ny += dy[dir];
			
			if(!isIn(nx, ny)) return;
			
			if(map[nx][ny] == '*') {
				map[nx][ny] = '.'; // 벽돌벽은 부서짐
				return;
			} else if(map[nx][ny] == '#') { // 강철벽
				return;
			}
		}
	}

	// 전차가 해당 방향으로 1번만 이동하면됨.
	private static void move(char[][] map, int dir) {
		// dir: 0(상), 1(하), 2(좌), 3(우)
		
		//전차가 이동할 새 위치를 계산해 봄
		int nx = tx + dx[dir];
		int ny = ty + dy[dir];
		
		if(!isIn(nx, ny)) return; // 배열 밖이면 멈춤
		
		// 이동이 가능한데 평지이어야됨.
		if(map[nx][ny] == '.') { // 평지임. 이동 가능
			map[nx][ny] = map[tx][ty]; // 새 위치에 기존 전차 정보 이동
			map[tx][ty] = '.'; // 이전 전차 위치는 평지로 바꿈.
			
			// 전차의 좌표 갱신
			tx = nx;
			ty = ny;
		}
	}

	private static boolean isIn(int nx, int ny) {
		return (nx>=0 && ny>=0 && nx<H && ny<W);
	}

}
