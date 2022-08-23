package com.day0823;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class primTest {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 정점수
		
		int input[][] = new int[N][N];
		boolean[] visited = new boolean[N]; // 해당정점이 방문되었는지 체크. MST에 포함되었는지 여부 체크
		// visited[0] = true; 정점 0은 MST에 포함되었음.
		
		int[] minEdge = new int[N]; // 각 정점별 다른 정점과의 연결 간선 중 최소 비용. minEdge[2] = 7;
		
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				input[i][j] = Integer.parseInt(st.nextToken()); 
			}
			minEdge[i] = Integer.MAX_VALUE;
		} // 정점별 연결 비용 저장됨
		
		// 시작정점 정황
		minEdge[0] = 0; // 나머지 정점들은 max
		
		int minValue; // 매 회차 찾아내는 최소비용
		int minVertex; // 매 회차 찾아내는 최소비용으로 연결되는 상대 정점.
		int result = 0; // 누적 비용
		for(int i=0; i<N; i++) { // 정점 수 만큼 반복
			minValue = Integer.MAX_VALUE; 
			minVertex = 0;
			
			for(int j=0; j<N; j++) {
				// !visited[j]: 정점 j가 아직 mst에 포함되어 있지 않고
				if(!visited[j] && minValue > minEdge[j]) {
					minValue = minEdge[j];
					minVertex = j; // 최소 비용을 갖는 정점
					System.out.println("정점번호: " + minVertex + " 최소비용: " + minValue);
				}
			}
			
			// 최소 비용과 최소 비용을 갖는 정점이 결정됨
			result += minValue; // 최소비용 누적
			visited[minVertex] = true; // MST에 포함시킴
			
			// 방금찾은 최소비용의 정점 기준으로 이 정점과 연결되어 있으면서 신장트리에는 아직 포함되어 있지 않은 다른 정점들과의
			// 최소 간선 비용 업데이트
			for(int k=0; k<N; k++) {
				if(!visited[k] && input[minVertex][k] != 0 && input[minVertex][k] < minEdge[k]) {
					minEdge[k] = input[minVertex][k];
				}
			}
			System.out.println("최소 간선 비용 배열: " + Arrays.toString(minEdge));
		}
	}
	
}
