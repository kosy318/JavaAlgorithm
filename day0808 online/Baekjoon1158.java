package com.day0808;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon1158 {
	
	public static void main(String[] args) {
		Queue<Integer> que = new LinkedList<>();
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(), K = sc.nextInt();
		
		for(int i=1; i<=N; i++) {
			que.offer(i);
		}
		
		int cnt = 0;
		StringBuffer answer = new StringBuffer();
		answer.append("<");
		int front;
		while(!que.isEmpty()) {
			front = que.poll();
			cnt++;
			if(cnt%K == 0) {
				answer.append(front + ", ");
			} else {
				que.offer(front);
			}
		}
		
		answer.delete(answer.length()-2, answer.length());
		System.out.println(answer + ">");
	}

}