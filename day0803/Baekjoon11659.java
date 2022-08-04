
package com.day0803;

import java.util.ArrayList;
import java.util.Scanner;

public class Baekjoon11659 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		ArrayList<Integer> numsAcc = new ArrayList<>();
		numsAcc.add(0);
		
		for(int i=1; i<=N; i++) {
			numsAcc.add(numsAcc.get(i-1) + sc.nextInt());
		}
		
		StringBuffer answer = new StringBuffer();
		for(int m=0; m<M; m++) {
			int i = sc.nextInt();
			int j = sc.nextInt();
			
			answer.append(numsAcc.get(j) - numsAcc.get(i-1) + "\n");
		}
		
		System.out.println(answer);
	}

}