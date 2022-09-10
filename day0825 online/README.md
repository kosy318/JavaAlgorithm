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
<b>PrimTest2_PQ.java</b><br>

> Priority Queue + 인접리스트 : $O( (V+E)logV )$

# 최단 경로 알고리즘
# Dijkstra 알고리즘
# Dijkstra with Priority Queue
# 위상 정렬
