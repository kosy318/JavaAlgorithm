package com.day0823;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA3124 {
	
	static class Node implements Comparable<Node>{
		int from;
		int to;
		int weight;
		
		public Node(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}
	
	static int V, E;
	static Node[] edgeList;
	static int[] parents;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			edgeList = new Node[E];
			
			for(int i=0; i<E; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				edgeList[i] = new Node(a, b, w);
			}

			Arrays.sort(edgeList);

			parents = new int[V+1];
			for(int i=1; i<=V; i++)
				parents[i] = i;
			 
			int cnt = 0;
			long weight = 0;
			for(Node n : edgeList){
				 if(cnt == V-1) {
					 break;
				 }
				 
				 Node cur = n;
				 if(find(parents, cur.from) == find(parents, cur.to))
					 continue;
				 
				 union(parents, cur.from, cur.to);
				 
				 weight += cur.weight;
				 cnt++;
			}
			
			System.out.println("#" + t + " " + weight);
		}
	}

	
	static void union(int[] set, int a, int b) {
		int aRoot = find(set, a);
		int bRoot = find(set, b);
		
		if(aRoot == bRoot) return;
		
		set[bRoot] = aRoot;
	}
	
	static int find(int[] set, int a) {
		if(set[a] == a) return a;
		return set[a] = find(set, set[a]);
	}

}
