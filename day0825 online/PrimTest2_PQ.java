package com.day0825;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class PrimTest2_PQ {
	
	static class Node{
		int vertex, weight;
		Node next;
		
		public Node(int vertex, int weight, Node next) {
			super();
			this.vertex = vertex;
			this.weight = weight;
			this.next = next;
		}
	}
	
	static class Vertex{
		int no, weight;
		public Vertex(int no, int weight) {
			this.no = no;
			this.weight = weight;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		Node[] adjList = new Node[V]; // 각 정점별 인접리스트
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			// 무향처리
			adjList[from] = new Node(to, weight, adjList[from]);
			adjList[to] = new Node(from, weight, adjList[to]);
		}
		
		// 프림 알고리즘에 필요한 자료구조
		int[] minEdge = new int[V]; // 각 정점 입장에서 신장트리에 포함된 정점과의 간선 비용중 최소 바용
		boolean[] visited = new boolean[V]; // 신장트리에 포함여부
		
		Arrays.fill(minEdge, Integer.MAX_VALUE); // 최소값 관리하기 위해 큰 값 세팅
		
		// 1. 임의의 시작점 처리, 0번 정점을 신장트리의 구성의 시작점
		minEdge[0] = 0;
		int result = 0; // 최소신장트리 비용 누적
		//////////////////// 추가!!!!!!!!
		PriorityQueue<Vertex> pQueue = new PriorityQueue<>((v1, v2) -> v1.weight - v2.weight);
		pQueue.offer(new Vertex(0, minEdge[0]));
		
		int cnt = 0;
		while(true) { ///////////////// 수정
			// step1. 신장트리의 구성에 포함되지 않은 정점 중 최소비용 정점 선택
			///////////////////// 수정!!!!!!
			Vertex minVertex = pQueue.poll();
			
			// step2. 신장트리에 추가
			if(visited[minVertex.no]) continue; // priority Queue에 같은 정점이 여러개 들어가있을 수 있다.
			visited[minVertex.no] = true;
			result += minVertex.weight;
			if(++cnt == V) break; /////////////// V개의 정점을 다 추가했으면 끝
			
			// step3. 신장트리에 새롭게 추가되는 정점과 신장트리에 포함되지 않은 정점들의 최소 비용과 비교해서 갱신
			//		  신장트리에 새롭게 추가되는 정점의 모든 인접정점 들여다보며 처리
			for(Node temp = adjList[minVertex.no]; temp != null; temp = temp.next) {
				if(!visited[temp.vertex] && minEdge[temp.vertex] > temp.weight) {
					minEdge[temp.vertex] = temp.weight;
					pQueue.offer(new Vertex(temp.vertex, minEdge[temp.vertex])); // 더 weight가 적은 간선 추가, 전의 것은 어차피 뒤로 밀려나므로 상관 없음, 어차피 수정으로 정렬이 안되고 해당 간선만 뺄 수 없음
				}
			}
		}
		
		System.out.println(result);
	}
	

}
