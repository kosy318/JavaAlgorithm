package com.day0822;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA1238 {
	
	static class Node{
		int to;
		Node next;
		
		public Node(int to, Node next) {
			super();
			this.to = to;
			this.next = next;
		}
	}
	
	static Node[] adjList;
	static int N;
	static boolean visited[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t=1; t<=10; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			
			adjList = new Node[101];
			visited = new boolean[101];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N/2; i++) {
				int from = Integer.parseInt(st.nextToken()), to = Integer.parseInt(st.nextToken());
				adjList[from] = new Node(to, adjList[from]);
			}
			
			int answer = bfs(start);
			System.out.println("#" + t + " " + answer);
		}
	}

	private static int bfs(int start) {
		Queue<int[]> que = new ArrayDeque<>();
		
		int[] answer = new int[] {start, 0};
		que.offer(new int[] {start, 0});
		while(!que.isEmpty()) {
			int[] nodeNb = que.poll();
			if((answer[1]==nodeNb[1] && answer[0]<nodeNb[0]) || answer[1]<nodeNb[1])
				answer = nodeNb;
			Node curNode = adjList[nodeNb[0]];
			if(curNode == null) continue;
			do {
				int to = curNode.to;
				if(!visited[to]) {
					que.offer(new int[] {to, nodeNb[1]+1});
					visited[to] = true;
					
				}
			} while((curNode = curNode.next) != null);
		}
		
		return answer[0];
	}

}
