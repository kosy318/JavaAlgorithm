package com.day0809;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA1233 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=1; t<=10; t++) {
			int answer = 1;
			int N = Integer.parseInt(br.readLine());
			
			// 길이가 4면 부모노드가 맞는지 확인해야함(연산자)
			// (나중에 쓰일줄) 본인 노드 숫자*2, 노드 숫자*2+1이 자식 노드 숫자
			
			// 길이가 2면 leaf노드가 맞는지 확인해야함(숫자)
			for(int i=0; i<N; i++) {
				if(answer == 0) {
					br.readLine();
					continue;
				}
				String[] info = br.readLine().split(" ");
				if((info.length==4 && !"+-*/".contains(info[1])) || 
				   (info.length==2 && !info[1].matches("\\d+"))) {
					answer = 0;
				}
			}
			
			System.out.println("#" + t + " " + answer);
		}
	}

}
