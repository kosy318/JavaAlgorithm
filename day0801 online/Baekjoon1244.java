// 0801 assignment
package com.day0801;

import java.util.ArrayList;
import java.util.Scanner;

public class Baekjoon1244 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> state = new ArrayList<>();
		state.add(-1);
		
		int n = sc.nextInt();
		for(int i=0; i<n; i++) {
			state.add(sc.nextInt());
		}
		
		int people = sc.nextInt();
		for(int i=0; i<people; i++) {
			int sex = sc.nextInt();
			int num = sc.nextInt();
			
			if(sex == 1) {
				for(int j=num; j<=n; j+=num) {
					state.set(j, 1-state.get(j));
				}
			}else if(sex == 2) {
				state.set(num, 1-state.get(num));
				
				int left = num-1;
				int right = num+1;
				
				while(true) {
					if(left < 0 || right > n) break;
					
					if(state.get(left) == state.get(right)) {
						state.set(left, 1-state.get(left));
						state.set(right, 1-state.get(right));
						
						left -= 1;
						right += 1;
					} else break;
					
				}
			}
		}
		
		state.remove(0);
		int cnt = 0;
		for(int s : state) {
			System.out.print(s + " ");
			cnt += 1;
			if(cnt%20 == 0) System.out.println();
		}
	}

}
