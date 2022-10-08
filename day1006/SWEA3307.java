package com.day1006;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA3307 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			int N = Integer.parseInt(br.readLine());
			int max = 1;
			int[] nums = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}

			int[] dp = new int[N];
			dp[0] = 1;
			for (int i = 1; i < N; i++) {
				dp[i] = 1;
				for (int j = 0; j < i; j++) {
					if (nums[i] >= nums[j] && dp[j] + 1 > dp[i]) dp[i] = dp[j] + 1;
				}
				if(max < dp[i]) max = dp[i];
			}

			System.out.println("#" + t + " " + max);
		}
	}

}
