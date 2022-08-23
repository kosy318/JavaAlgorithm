package com.day0823;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon12023 {

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
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		
		adjList = new Node[N];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
			
			adjList[a] = new Node(b, adjList[a]);
			adjList[b] = new Node(a, adjList[b]);
		}
		
		for(int i=0; i<N; i++) {
			visited = new boolean[N];
			if(dfs(i, 0)) {
				System.out.println("1");
				return;
			}
		}
		
		System.out.println("0");
	}

	private static boolean dfs(int start, int cnt) {
		if(cnt >= 4) return true;
		
		visited[start] = true;
		
		Node curNode = adjList[start];
		
		while(curNode != null) {
			int to = curNode.to;
			if(!visited[to]) {
				if(dfs(to, cnt+1)) return true;
			}
			curNode = curNode.next;
		}
		visited[start] = false;
		
		return false;
	}


}
