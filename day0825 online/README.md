# Prim 알고리즘 리뷰
> 신장트리 : 모든 정점이 나머지 다른 정점과의 유일한 경로 모두 존재<br>
> 최소신장트리 : N개 정점을 가진 그래프에서 N개 정점을 모두 연결하기 위해 N-1개(최소 간선수) 간선(무향)을 선택하여 만든 최소 비용의 트리<br>
> 크루스칼 : uninon - Find<br>
> 크루스칼과 프림 모두 "GREEDY"<br>
<br>

> 정점 중심 : Prim(인접행렬, 인접리스트), Dijkstra<br>
> 간선 중심 : Kruskal, Bellman-Ford

### 하나의 정점에서 연결된 간선들 중에 하나씩 선택하면서 MST를 만들어가는 방식
1. 임의 정점을 하나 선택해서 시작
2. 선택한 정점과 인접하는 정점들 중의 최소 비용의 간선이 존재하는 정점을 선택
3. 모든 정점이 선택될 때까지 1, 2과정을 반복

### 서로소인 2개의 집합(2 disjoint-sets) 정보를 유지
- 트리 정점들(tree vertices) - MST를 만들기 위해 선택된 정점들
- 비트리 정점들(non-tree vertices) - 선택 되지 않은 정점들

<b>PrimTest.java</b><br>
> 인접리스트 : $O( V^2 + E )$ 간선의 개수가 적으면 인접행렬을 사용했을 때와 차이가 많이 나게 된다.<br>
> 인접행렬 : $O( 2V^2 )$ ; &nbsp;&nbsp;&nbsp; $V \le 1000$<br>
> 크루스칼 : $O( E log E + V-1)$

# Prim with Priority Queue
### 알고리즘
```java
MST-PRIM(G, r) // G: 그래프, r: 시작 정점, minEdge[]: 각 정점기준으로 타 정점과의 최소 간선 비용
  result <- 0, cnt <- // result: MST 비용, cnt: 처리한 정점수, visited[]: MST에 포함된 정점여부
  FOR u in G.V
    minEdge[u] <- INF
  minEdge[r] <- 0 // 시작 정점 r의 최소비용 0 처리
  WHILE true
    u <- Extract-MIN() // 방문하지 않은(MST에 포함되지 않은 정점) 최소비용 정점 찾기
    ...
  return result
end MST-PRIM
```

<a href="https://github.com/kosy318/JavaAlgorithm/blob/main/day0825%20online/PrimTest2_PQ.java"><b>PrimTest2_PQ.java</b></a><br>

> Priority Queue + 인접리스트 : $O( (V+E)logV )$

# 최단 경로 알고리즘
### 최단 경로 정의
- 간선의 가중치가 있는 그래프에서 두 정점 사이의 경로들 중에 간선의 가중치의 합이 최소인 경로

### 하나의 시작 정점에서 끝 정점까지의 최단 경로
- 다익스트라(Dijkstra) 알고리즘
  - 음의 가중치를 허용하지 않음
- 벨만-포드(Bellman-Ford) 알고리즘
  - 음의 가중치 허용

### 모든 정점들에 대한 최단 경로
- 플로이드-워샬(Floyd-Warshall) 알고리즘

# Dijkstra 알고리즘
<a href="https://github.com/kosy318/JavaAlgorithm/blob/main/day0825%20online/DijkstraTest.java"><b>DijkstraTest.java</b></a><br>
> 시간복잡도 Prim이랑 동일<br>

- 시작 정점에서 다른 모든 정점으로의 최단 경로를 구하는 알고리즘
- 시작 정점에서의 거리가 최소인 정점을 선택해 나가면서 최단 경로를 구하는 방식이다.
- 탐욕 기법을 사용한 알고리즘으로 MST의 프림 알고리즘과 유사하다.
```java
s: 시작 정점, A: 인접 행렬, D: 시작정점에서의 거리
V: 정점 집합, U: 선택된 정점 집합
Dijkstra(s, A, D)
  U = {s};
  
  FOR 모든 정점 v
    D[v] <- A[s][v] // 간선 없는 애들은 INF
    
  WHILE U != V // 선택된 정점의 집합이 모든 정점이 아니면
    D[w]가 최소인 정점 w ∈ V-U를 선택 // 처리되지 않은 정점중 출발지에서 자신으로 오는 비용이 최소인 정점을 찾음
    U <- U ∪ {w}
    FOR w에 인접한 모든 미방문 정점 v
      D[v] <- min(D[v], D[w] + A[w][v]) // 선택한 정점 w를 거치는것이 가까운지 확인
```

# Dijkstra with Priority Queue
- D[w]가 최소인 정점 w ∈ V-U를 선택 // 처리되지 않은 정점중 출발지에서 자신으로 오는 비용이 최소인 정점을 찾음
- 이 부분을 PQ로 대체 

# 위상 정렬
- 유향 그래프의 정점들의 변의 방향을 거스르지 않도록 나열하는 것을 의미한다.
- 위상 정렬은 순서가 정해져 있는 작업들을 차례대로 수행해야 할 때, 그 순서를 결정해주는 알고리즘이다.
- 위상 정렬을 가장 잘 설명해 줄 수 있는 예로 교육과정의 선수과목(prerequisite) 구조를 예로 들 수 있다.
- 만약 특정 수강 과목에 선수 과목이 있다면 그 선수 과목부터 수강해야 하므로, 특정 과목들을 수강해야 할 때 위상 정렬을 통해 올바른 수강 순서를 찾아낼 수 있다.

<br>

- 선후 관계가 정의된 그래프 구조 상에서 선후 관계에 따라 정렬하기 위해 위상 정렬을 이용할 수 있다.
- 정렬의 순서는 유향 그래프의 구조에 따라 여러 개의 종류가 나올 수 있다.
- 위상 정렬이 성립하기 위해서는 반드시 그래프의 순환이 존재하지 않아야 한다.
- 즉, 그래프가 비순환 유향 그래프(directed acyclic graph)여야 한다.

## 위상 정렬 - 결과
- 위상 정렬이 가능한지 여부
  - 사이클 발생 여부 확인 가능
- 가능하다면 정렬된 결과

## 위상 정렬 - 구현방식
- BFS를 이용한 구현
- DFS를 이용한 구현

## 위상 정렬 구현
### BFS 사용
<a href="https://github.com/kosy318/JavaAlgorithm/blob/main/day0825%20online/TopologySortTest.java"><b>TopologySortTest.java</b></a><br>
```
1. 진입 차수가 0인 노드(시작점, 선행 작업이 없음)를 큐에 모두 넣는다.
  진입차수 : 다른 정점에서 나로 들어오는 간선 수
2. 큐에서 진입 차수가 0인 노드를 꺼내어 자신과 인접한 노드의 간선을 제거한다.
  -> 인접한 노드의 진입 차수를 1 감소시킨다.
3. 간선 제거 후 진입 차수가 0이 된 노드를 큐에 넣는다.
```
- 큐가 공백 큐 상태가 될 때까지 2-3 작업을 반복한다.
  - 모든 노드가 다 처리되었다면 위상 정렬 완성
  - 모든 노드가 처리되지 않았다면 사이클링이 발생했다는 의미
