package com.day0801;

import java.util.Scanner;

public class SWEA1289 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int t=1; t<=tc; t++) {
			String mem = sc.next();
			
			int answer = 0;
			
            char bf = '0';
            for(int i=0; i<mem.length(); i++) {
            	if(bf != mem.charAt(i)) {
            		answer += 1;
            		bf = mem.charAt(i);
            	}
            }
			
			System.out.println("#" + t + " " + answer);
		}
	}

}
