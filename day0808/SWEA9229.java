package com.day0808;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SWEA9229 {
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1; t<=tc; t++) {
			int answer = -1;
			
			int N = sc.nextInt(), M = sc.nextInt();
			List<Integer> weights = new ArrayList<>();
			
			for(int i=0; i<N; i++) {
				weights.add(sc.nextInt());
			}
			
			Collections.sort(weights, Collections.reverseOrder());
			
			int take;
		out:for(int i=0; i<N; i++) {
				take = weights.get(i);
				for(int j=i+1; j<N; j++) {
					take += weights.get(j);
					
					if(take<=M && answer<take) answer = take;
					else if(take<=M && answer>take) {
						if(j==i+1) break out;
						break;
					}
					else if(take==M) break out;
					take -= weights.get(j);
				}
			}
			
			System.out.println("#" + t + " " + answer);
		}
	}

}

