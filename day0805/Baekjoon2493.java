package com.day0805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baekjoon2493 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		StringTokenizer stt = new StringTokenizer(br.readLine());

		StringBuffer answer = new StringBuffer();
		
		Stack<int[]> st = new Stack<>();
		
		for(int i=1; i<=num; i++) {
			int next = Integer.parseInt(stt.nextToken());
			
			boolean empty = st.isEmpty();
			if(empty) answer.append("0 ");
			while(!empty) {
				if(next < st.peek()[0]) {
					answer.append(st.peek()[1] + " ");
					break;
				} else {
					st.pop();
					empty = st.isEmpty();
					if(empty) answer.append("0 ");
				}
			}
			st.push(new int[] {next, i});
		}
		System.out.println(answer);
	}

}


//public class Baekjoon2493 {
//	
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int num = Integer.parseInt(br.readLine());
//		StringTokenizer stt = new StringTokenizer(br.readLine());
//		
//		Stack<int[]> st = new Stack<>();
//		for(int i=1; i<=num; i++) {
//			st.push(new int[] {Integer.parseInt(stt.nextToken()), i});
//		}
//		
//		Stack<int[]> other = new Stack<>();
//		int[] answer = new int[num];
//		
//		while(!st.isEmpty()) {
//			int[] temp = st.pop();
//			while(!other.isEmpty() && other.peek()[0] <= temp[0]) {
//				answer[other.peek()[1]-1] = temp[1];
//				other.pop();
//			}
//			other.push(temp);
//		}
//
//		for(int i : answer) {
//			System.out.print(i + " ");
//		}
//	}
//
//}
