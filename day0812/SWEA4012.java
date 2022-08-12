package com.day0812;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA4012 {
	
	static int[][] synergy;
	static int N, min; // min : 답
	static int[] foodA, foodB; // 각 음식에 들어가는 ㅈ료의 번호가 저장되는 배열
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++) {
			min = Integer.MAX_VALUE;
            N = Integer.parseInt(br.readLine()); // 재료 개수. 4<=N<=16
			synergy = new int[N][N];
			
			foodA = new int[N/2];
			foodB = new int[N/2];
			
			for(int i=0; i<N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++) {
                    synergy[i][j] = Integer.parseInt(st.nextToken());
                }
			} // 입력 완료
			
			comb(0, 0);
			System.out.println("#" + t + " " + min);
		}
	}

	private static void comb(int cnt, int start) {
		if(cnt == N/2) { // 조합 하나 완성
			check();
			return;
		}

		for(int i=start; i<N; i++) { // 전체 N개의 재료 중에서 뽑기
			foodA[cnt] = i;
			comb(cnt+1, i+1);
		}
	}

	// 하나의 조합이 완성됐을 때, foodB배열의 값 완성하기
	private static void check() {
		boolean[] selected = new boolean[N]; // 모든 재료 개수만큼
		
		for(int i=0; i<foodA.length; i++) {
			selected[foodA[i]] = true; // foodA가 사용하는 재료 위치에 true로 표시.
		}
		
		// foodB 배열값 완성하기
		int index = 0;
		for(int i=0; i<selected.length; i++) {
			if(!selected[i])
				foodB[index++] = i;
		}
		
		min = Math.min(min, Math.abs(calc(foodA) - calc(foodB)));
	}

	private static int calc(int[] food) {
		int sum = 0;
		for(int i : food) { // 재료 번호 하나 꺼냄
			for(int j : food) {
				if(i != j) { // 같은 재료가 아닌 경우만
					sum += synergy[i][j];
				}
			}
		}
		return 0;
	}
	
}
