package com.day0803;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Beakjoon11660 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N, M;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		ArrayList<ArrayList<Integer>> numsAcc = new ArrayList<ArrayList<Integer>>();
		
		for(int i=0; i<N; i++) {
			ArrayList<Integer> temp = new ArrayList<>();
	        st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				if(i==0 && j-1 >= 0) temp.add(temp.get(j-1) + Integer.parseInt(st.nextToken()));
				else if(i==0) temp.add(Integer.parseInt(st.nextToken()));
				else if(i!=0) {
					if(j-1>=0) temp.add(temp.get(j-1) + numsAcc.get(i-1).get(j) + Integer.parseInt(st.nextToken()) - numsAcc.get(i-1).get(j-1));
					else temp.add(numsAcc.get(i-1).get(j) + Integer.parseInt(st.nextToken()));
				}
			}
			numsAcc.add(temp);
		}
		
//		System.out.println();
//		for(ArrayList<Integer> arr: numsAcc) {
//			for(Integer in: arr) {
//				System.out.print(in + " ");
//			}
//			System.out.println();
//		}
		
		StringBuffer answer = new StringBuffer();
		for(int m=0; m<M; m++) {
	        st = new StringTokenizer(br.readLine());
			int[] i = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			int[] j = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			
			int minus = 0;
			if(i[1]-2 >= 0) minus += numsAcc.get(j[0]-1).get(i[1]-2);
			if(i[0]-2 >= 0) minus += numsAcc.get(i[0]-2).get(j[1]-1);
			int plus = 0;
			if(i[0]-2 >= 0 && i[1]-2>=0) plus += numsAcc.get(i[0]-2).get(i[1]-2);
			int total = numsAcc.get(j[0]-1).get(j[1]-1) - minus + plus;
			
			answer.append(total + "\n");
		}
		
		System.out.println(answer);
	}
	
}
