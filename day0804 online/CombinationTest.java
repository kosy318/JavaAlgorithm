package com.day0804;

import java.util.Arrays;
import java.util.Scanner;

public class CombinationTest {
	
	static int N, R, totalCnt;
	static int[] numbers, input;

	// nCr : n개의 입력받은 수 중 r개를 모두 뽑아 순서 없이 나열한것(1<=r<=n)
	public static void main(String[] args) {
		Scanner sc = new  Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		totalCnt = 0;
		
		input = new int[N];
		numbers = new int[R];
		
		for(int i=0; i<N; i++) {
			input[i] = sc.nextInt();
		}
		
		comb(0, 0);
		System.out.println("총 경우의 수 : " + totalCnt);
	}
	
	// cnt+1번째 해당하는 순열에 포함될 수를 뽑기
	private static void comb(int cnt, int start) { // cnt: 직전까지 뽑은 조합에 포함된 수의 개수, start: 시도할 수의 시작 위치
		if(cnt == R) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		// 가능한 모든 수에 대해 시도(input 배열의 가능한 수 시도)
		// start부터 처리시 중복 수 추출 방지 및 순서가 다른 조합 추출 방지
		for(int i=start; i<N; i++) { // 선택지
			// start위치부터 처리했으므로 중복체크 필요없음!!
			// 앞쪽에서 선택되지 않았다면 수를 사용
			numbers[cnt] = input[i];
			// 다음 수 뽑으러 가기
			comb(cnt+1, i+1);
		}
	}

}
