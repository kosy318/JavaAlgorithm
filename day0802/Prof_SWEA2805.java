package com.day0802;

import java.util.Arrays;
import java.util.Scanner;

public class Prof_SWEA2805 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt(); // test case 수
		
		for(int t=1; t<=tc; t++) {
			int N = sc.nextInt(); // 배열 크기, 항상 홀수
			int[][] map = new int[N][N];
			
			// 배열에 값 입력받기
			for(int i=0; i<N; i++) {
				char[] tmp = sc.next().toCharArray(); // char 배열로 저장. '1', '0', ...
				
				for(int j=0; j<N; j++) { // 열
					map[i][j] = tmp[j] - '0'; // char 타입의 숫자 -> 정수형 타입으로 변환
				}
			} // 입력 완료
			
			// 입력 확인
//			System.out.println(Arrays.deepToString(map));
			
			// 영역 수확
			int center = N/2;
			int harvest = 0, start, end, gap = 0;
			
			for(int i=0; i<N; i++) { // 모든 행에 대해 작업
				// 각 행별로 시작위치, 끝위치 결정(열값)
				start = center - gap; // 수확을 할 시작위치
				end = center + gap; // 수확을 할 끝 위치
				
				for(int j=start; j<=end; j++) {
					harvest += map[i][j]; // 수확
				}
				
				// gap을 조정
				if(i < center) { // i가 행값, center보다 작으면 세로방향 기준으로 볼 때 위쪽
					gap++;
				} else { // i가 center이거나 center보다 크면
					gap--;
				}
			} // 수확하는 for문 끝
			
			System.out.println("#" + tc + " " + harvest);
		}
	}

}
