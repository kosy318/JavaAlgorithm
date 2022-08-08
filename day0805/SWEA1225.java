package com.day0805;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA1225 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int t=1; t<=10; t++) {
			Queue<Integer> nums = new LinkedList<>();
			sc.nextInt();
			
			for(int i=0; i<8; i++) {
				nums.offer(sc.nextInt());
			}
			
			int num;
			
		top:while(true) {
				for(int i=1; i<=5; i++) {
					num = nums.poll() - i;
					if(num <= 0) {
						break top;
					}
					nums.offer(num);
				}
			}
			
			System.out.print("#" + t + " ");
			for(int n : nums) {
				System.out.print(n + " ");
			} System.out.println("0");
		}
	}

}
