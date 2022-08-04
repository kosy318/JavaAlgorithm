// java에서 stack을 알기 전
package com.day0804;

import java.util.ArrayList;
import java.util.Scanner;

public class SWEA1218 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int t=1; t<=10; t++) {
			int n = sc.nextInt();
			
			int answer = 1;
			ArrayList<Character> stack = new ArrayList<>();
			
			char[] str = sc.next().toCharArray();
			for(char ch : str) {
				if( (ch==')' && stack.get(stack.size()-1)=='(') || (ch==']' && stack.get(stack.size()-1)=='[') ||
				    (ch=='}' && stack.get(stack.size()-1)=='{') || (ch=='>' && stack.get(stack.size()-1)=='<')) {
					stack.remove(stack.size()-1);
				} else {
					stack.add(ch);
				}
			}
			
			if(!stack.isEmpty()) answer = 0;
			System.out.println("#" + t + " " + answer);
		}
	}

}
