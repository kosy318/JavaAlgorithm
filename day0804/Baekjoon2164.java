package com.day0804;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon2164 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		Queue<Integer> que = new LinkedList<>();
		for(int i=1; i<=N; i++) {
			que.offer(i);
		}
		
		int lastCard = 0;
		Integer temp;
		while(!que.isEmpty()) {
			if((temp = que.poll()) == null) break;
			lastCard = temp;
			
			if((temp = que.poll()) == null) break;
			que.offer(temp);
		}
		
		System.out.println(lastCard);
	}

}
