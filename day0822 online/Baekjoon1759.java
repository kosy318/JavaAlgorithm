package com.day0822;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon1759 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int L = Integer.parseInt(st.nextToken()), C = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		char[] characters = new char[C];
		for(int i=0; i<C; i++)
			characters[i] = st.nextToken().charAt(0);
		
		Arrays.sort(characters);
		
		int[] choose = new int[C];
		for(int i=0; i<L; i++)
			choose[i] = 1;
		
		List<Character> vowels = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
		StringBuilder answer = new StringBuilder();
		do {
			int vowelCnt = 0, consonantCnt = 0;
			StringBuilder str = new StringBuilder();
			for(int i=0; i<C; i++) {
				if(choose[i] == 1) {
					str.append(characters[i] + "");
					if(vowels.contains(characters[i])) vowelCnt += 1;
					else consonantCnt += 1;
				}
			}
			if(vowelCnt>=1 && consonantCnt>=2) answer.append(str + "\n");
		}while(np(choose));
		
		System.out.println(answer);
	}

	private static boolean np(int[] choose) {
		int N = choose.length;
		int i = N-1;
		while(i>0 && choose[i-1]<=choose[i]) i -= 1;
		
		if(i==0) return false;
		
		int j = N-1;
		while(choose[i-1] <= choose[j]) j -= 1;
		
		swap(choose, i-1, j);
		
		int k = N-1;
		while(i < k) swap(choose, i++, k--);
		
		return true;
	}

	private static void swap(int[] choose, int i, int j) {
		int temp = choose[i];
		choose[i] = choose[j];
		choose[j] = temp;
	}

}
