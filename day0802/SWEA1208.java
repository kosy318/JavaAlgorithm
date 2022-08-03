package com.day0802;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

public class SWEA1208 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int t=1; t<=10; t++) {
			int k = sc.nextInt();
			TreeMap<Integer, Integer> heights = new TreeMap<>();
			
			for(int j=0; j<100; j++) {
				int height = sc.nextInt();
				if(heights.containsKey(height))heights.put(height, heights.get(height)+1);
				else heights.put(height, 1);
			}
			
			for(int j=0; j<k; j++) {
				int min = heights.firstKey();
				int max = heights.lastKey();
				if((max - min <= 1)) break;
				
				heights.put(max, heights.get(max)-1);
				if(heights.containsKey(max-1))
					heights.put(max-1, heights.get(max-1)+1);
				else heights.put(max-1, 1);
				
				heights.put(min, heights.get(min)-1);
				if(heights.containsKey(min+1))
					heights.put(min+1, heights.get(min+1)+1);
				else heights.put(min+1, 1);
				
				if(heights.get(max) == 0) heights.remove(max);
				if(heights.get(min) == 0) heights.remove(min);
			}
			int min = heights.firstKey();
			int max = heights.lastKey();

			System.out.println("#" + t + " " + (max - min));
		}
	}
	
}
