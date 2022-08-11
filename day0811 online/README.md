# 트리 탐색 - BFS
## BFS(Breadth First Search)
- 너비 우선 탐색
- 너비 : 루트에서 자신까지 오는 데 사용되는 간선 수(각 노드에서의 높ㅇ이)
- 너비 우선 탐색은 루트 노드의 자식 노드들을 먼저 모두 차례로 방문한 후에, 방문했던 자식 노드들을 기준으로 하여 다시 해당 노드의 자식 노드들을 차례로 방문하는 방식
- 인접한 노드들에 대해 탐색을 한 후, 차례로 다시 너비우선탐색을 진행해야 하므로, 선입선출 형태의 자료구조인 큐를 활용함

## BFS 알고리즘
```java
BFS()
  queue 생성
  루트 v를 큐에 삽입
  while(큐가 비어 있지 않은 경우){
    t <- 큐의 첫번째 원소 반환
    t 방문
    for(t와 연결된 모든 간선에 대해){
      u <- t의 자식 노드
      u를 queue에 삽입
    }
  }
end BFS()
```

Queue를 Stack으로 변경하면? DFS

# 트리 탐색 - DFS
## DFS(Depth First Search)
- 깊이 우선 탐색
- 루트 노드에서 출발하여 한 방향으로 갈 수 있는 경로가 있는 곳까지 깊이 탐색해 가다가 더 이상 갈 곳이 없게 되면, 가장 마지막에 만났던 갈림길 간선이 있는 노드로 되돌아와서 다른 방향의 노드로 탐색을 계속 반복하여 결국 모든 노드를 방문하는 순회방법
- 가장 마지막에 만났던 갈림길의 노드로 되돌아가서 다시 깊이 우선 탐색을 반복해야 하므로 재귀적으로 구현하거나 후입선출 구조의 스택 사용해서 구현

## DFS 알고리즘
```java
DFS(v)
  v 방문;
  for(v의 모든 자식노드 w){
    DFS(w);
  }
end DFS()
```

## 이진트리 - 순회(traversal)
### 순회(travelsal)
트리의 노드들을 체계적으로 방문하는 것
### 3가지의 기본적인 순회 방법
- 전위 순회(preorder traversal) : VLR
  - 부모노드 방문 후, 자식노드를 좌, 우 순서로 방문한다.
- 중위 순회(indorder traversal) : LVR
  - 왼쪽 자식노드, 부모노드, 오른쪽 자식노드 순으로 방문한다.
- 후위 순회(postorder traversal) : LRV
  - 자식노드를 좌우 순서로 방문한 후, 부모노드로 방문한다.
  
### 전위 순회(preorder traversal)
- 수행방법
  1. 현재 노드 T를 방문하여 처리한다. -> V
  2. 현재 노드 T의 왼쪽 서브트리로 이동한다. -> L
  3. 현재 노드 T의 오른쪽 서브트리로 이동한다. -> R
  
- 전위 순회 알고리즘
  ```java
  preorder_traverse(T)
    if(T is not null){
      visit(T);
      preorder_traverse(T.left);
      preorder_traverse(T.right);
    }
  End preorder_traverse
  ```

### 중위 순회(inorder traversal)
- 수행 방법
  1. 현재 노드 T의 왼쪽 서브트리로 이동한다. -> L
  2. 현재 노드 T를 방문하여 처리한다. -> V
  3. 현재 노드 T의 오른쪽 서브트리로 이동한다. -> R

- 중위 순회 알고리즘
  ```java
  inorder_traverse(T)
    if(T is not null){
      inorder_traverse(T.left);
      visit(T);
      inorder_traverse(T.right);
    }
  End inorder_traverse
  ```
  
### 후위 순회(postorder traversal)
- 수행 방법
  1. 현재 노드 T의 왼쪽 서브트리로 이동한다. -> L
  2. 현재 노드 T의 오른쪽 서브트리로 이동한다. -> R
  3. 현재 노드 T를 방문하여 처리한다. -> V

- 후위 순회 알고리즘
  ```java
  postorder_traverse(T)
    if(T is not null){
      postorder_traverse(T.left);
      postorder_traverse(T.right);
      visit(T);
    }
  End postorder_traverse
  ```
  
## 수식트리
- 수식을 표현하는 이진 트리
- 수식 이진 트리(Expression Binary Tree)라고 부르기도 함
- 연산자는 루트 노드이거나 가지 노드
- 피연산자는 모드 잎 노드

### 수식 트리의 순회
- 중위 순회 : 식의 중위 표기법
- 후위 순회 : 식의 후위 표기법
- 전위 순회 : 식이 전위 표기법

# 힙(Heap)
#### 완전 이진 트리에 있는 노드 중에서 키 값이 가장 큰 노드나 키 값이 가장 작은 노드를 찾기 위해 만든 자료구조
### 최대 힙(max heap)
- 키 값이 가장 큰 노드를 찾기 위한 완전 이진 트리
- 부모 노드의 키 값 > 자식 노드의 키 값
- 루트 노드 : 키 값이 가장 큰 노드

### 최소 힙(min heap)
- 키 값이 가장 작은 노드를 찾기 위한 완전 이진 트리
- 부모 노드의 키 값 < 자식 노드의 키 값
- 루트 노드 : 키 값이 가장 작은 노드

### 힙 연산 - 삭제 
- 힙에서는 루트 노드의 원소만을 삭제할 수 있다.
- 
# 힙(Heap)활용 - 우선순위큐
# 완전검색
# 순열 응용 - 비트마스킹 순열
# 순열 응용 - Next Permutation
# 조합 응용 - Next Permutation 활용
# 부분집합 응용 - 바이너리 카운팅
