package com.day1006;

import java.util.Arrays;
import java.util.Scanner;

public class DP2_ChangeMinCoinTest2 {
	
	// 4, 6원 화폐단위로 고정
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int money = sc.nextInt(); // 목표 금액, <= 100000
		
		int[] dp = new int[money+1]; // dp[i] : i금액을 만드는 최소동전 수
		dp[0] = 0; // 0원에 대한 최적해는 0
		
		int INF = 100000; // 가장 작은 화폐단위를 가장 많이 써도 만들 수 없는 큰 값, +1 처리시 오버플로우 발생하지 않는 값
		for(int i=1; i<=money; i++) {
			int min = INF;
			if(i >= 4) min = Math.min(min, dp[i-4] + 1);
			if(i >= 6) min = Math.min(min, dp[i-6] + 1);
			
			dp[i] = min;
		}
		
		System.out.println(Arrays.toString(dp));
		System.out.println(dp[money]==INF? -1 : dp[money]);
	}

}
