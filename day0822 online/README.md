> 정점 중심 표현 : 인접 행렬(작성 용이, 공간 효율성 안좋음, 탐색 효율성 안좋음), 인접리스트 -> prim<br>
> 간선 중심 표현 : 간선 리스트 -> kruskal

# 서로소 집합(Disjoint-set)
- 서로소 또는 상호배타 집합들은 서로 중복 포함된 원소가 없는 집합들이다. 다시 말해 교집합이 없다.
- 집합에 속한 하나의 특정 멤버를 통해 각 집합들을 구분한다. 이를 대표자(representative)라고 한다.
- 서로소 집합을 표현하는 방법 : 집합 구성요소(원소) 표현
  - 연결 리스트
  - 트리
- 서로소 집합 연산
  - Make-Set(x) : 집합 생성(x가 대표자)
  - Find-Set(x) : x가 속한 집합 찾기
  - Union(x, y) : x, y원소를 하나의 집합으로 만들기

## 서로소 집합 표현 - 연결리스트
- 같은 집합의 원소들은 하나의 연결리스트로 관리한다.
- 연결리스트의 맨 앞의 원소를 집합의 대표 원소로 삼는다.
- 각 원소는 집합의 대표원소를 가리키는 링크를 갖는다.

## 서로소 집합 표현 - 트리
- 같은 집합의 원소들을 하나의 트리로 표현한다.
- 자식 노드가 부모 노드를 가리키며 루트 노드가 대표자가 된다.
- 합칠 때 대표자끼리 합친다.

## 서로소 집합에 대한 연산
### Make-Set(x) : 유일한 멤버 x를 포함하는 새로운 집합을 생성하는 연산
```java
Make-Set(x)
  p[x] <- x // 부모 노드 인덱스 저장
```

### Find-Set(x) : x를 포함하는 집합을 찾는 연산
```java
Find-Set(x)
  If x==p[x] : RETURN x
  ELSE : RETURN Find_Set(p[x])
```

### Union(x, y) : x와 y를 포함하는 두 집합을 통합하는 연산
```java
Union(x, y)
  IF Find-Set(y) == Find-Set(x) RETURN; // 이미 같은 집합
  p[Find-Set(y)] <- Find-Set(x) // y집합의 대표자의 부모를 x집합의 대표자의 부모로 바꿈
```

### 연산의 효율을 높이는 방법
- Rank를 이용한 Union (Rank : 트리 높이)
  - 각 노드는 자신을 루트로 하는 subtree의 높이를 rank로 저장한다.
  - 두 집합을 합칠 때 rank가 낮은 집합을 rank가 높은 집합에 붙인다.

- Path compression
  - Find-Set을 행하는 과정에서 만나는 모든 노드들이 직접 root를 가리키도록 포인터를 바꾸어준다.
  - Path Compresssion을 적용한 Find-Set연산은 특정 노드에서 루트까지의 경로를 찾아 가면서 노드의 부모 정보를 갱신한다.

### Path Compression 적용한 Find-Set 연산
- Find-Set(x) : x를 포함하는 집합을 찾는 오퍼레이션
```java
Find-Set(x)
  IF x == p[x] : RETRUN x
  ELSE : RETURN p[x] = Find-Set(p[x])
```

# 최소 신장 트리(MST)
### 그래프에서 최소 비용 문제
1. 모든 정점을 연결하는 간선들의 가중치의 합이 최소가 되는 트리
2. 두 정점 사이의 최소 비용의 경로 찾기

### 신장 트리
- n개의 정점으로 이루어진 무향 그래프에서 n개의 정점과 n-1개의 간선으로 이루어진 트리(싸이클 x)

### 최소 신장 트리(Minimum Spanning Tree)
- 무향 가중치 그래프에서 신장 트리를 구성하는 간선들의 가중치의 합이 최소인 신장 트리

# kruskal 알고리즘
### 간선을 하나씩 선택해서 MST를 찾는 알고리즘 : 그리디
1. 최초, 모든 간선을 가중치에 따라 오름차순으로 정렬
2. 가중치가 낮은 간선부터 선택하면서 트리를 증가시킴
    - 사이클이 존재하면 다음으로 가중치가 낮은 간선 선택
3. n-1개의 간선이 선택될 때까지 2번 반복

### 알고리즘
<a href="https://github.com/kosy318/JavaAlgorithm/blob/main/day0822%20online/KruskalTest.java"><b>KruskalTest.java</b></a><br>
```java
// G.V: 그래프의 정점 집합
// G.E: 그래프의 간선 집합

MST-KRUSKAL(G, w)
  FOR vertex v in G.V
    Make-Set(v) // v개의 정점을 make-set : 크기가 1인 서로소 집합 생성
  
  G.E에 포함된 간선들을 가중치 w를 이용한 오름차순 정렬
  
  FOR G.E에 속하는 가중치가 가장 낮은 간선(u, v) 선택(n-1개)
    IF Find-Set(u) != Find-Set(v) // 같은 집합이 아니면, 싸이클x
      Union(u, v)
```
