package com.day1011;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA4014 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()), L = Integer.parseInt(st.nextToken());

			int[][] map = new int[N][N];
			int answer = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int cnt = 1;
				boolean possible = true, rev = false;
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (j - 1 >= 0) {
						if (map[i][j - 1] == map[i][j]) cnt += 1;
						else if (map[i][j - 1] - 1 == map[i][j]) {
							if (rev && cnt < L) possible = false;
							cnt = 1;
							rev = true;
						}
						else if (map[i][j - 1] == map[i][j] - 1) {
							if (cnt < L) possible = false;
							if (rev && cnt < 2 * L) possible = false;
							cnt = 1;
							rev = false;

						}
						else if (Math.abs(map[i][j - 1] - map[i][j]) >= 2) possible = false;
					}
				}
				if (rev && cnt < L) possible = false;
				if (possible) answer += 1;
			}

			for (int j = 0; j < N; j++) {
				int cnt = 1;
				boolean possible = true, rev = false;
				for (int i = 0; i < N; i++) {
					if (i - 1 >= 0) {
						if (map[i - 1][j] == map[i][j]) cnt += 1;
						else if (map[i - 1][j] - 1 == map[i][j]) {
							if (rev && cnt < L) possible = false;
							cnt = 1;
							rev = true;
						}
						else if (map[i - 1][j] == map[i][j] - 1) {
							if (cnt < L) possible = false;
							if (rev && cnt < 2 * L) possible = false;
							cnt = 1;
							rev = false;

						}
						else if (Math.abs(map[i - 1][j] - map[i][j]) >= 2) possible = false;
					}
				}
				if (rev && cnt < L) possible = false;
				if (possible) answer += 1;
			}

			System.out.println("#" + t + " " + answer);
		}
	}

}
