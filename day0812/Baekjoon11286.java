package com.day0812;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Baekjoon11286 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		PriorityQueue<Integer> pQue = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				int abs1 = Math.abs(o1);
				int abs2 = Math.abs(o2);
				if(abs1 < abs2)	return -1;
				else if(abs1 > abs2) return 1;
				else if(o1 < o2) return -1;
				else if(o1 > o2) return 1;
				return 0;
			}
			
		});
		
		for(int i=0; i<N; i++) {
			int num = sc.nextInt();
			if(num != 0) pQue.add(num);
			else if(num == 0) {
				if(!pQue.isEmpty()) System.out.println(pQue.poll());
				else System.out.println(0);
			}
		}
	}

}
