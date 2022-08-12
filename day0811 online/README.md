# 트리 탐색 - BFS
## BFS(Breadth First Search)
- 너비 우선 탐색
- 너비 : 루트에서 자신까지 오는 데 사용되는 간선 수(각 노드에서의 높ㅇ이)
- 너비 우선 탐색은 루트 노드의 자식 노드들을 먼저 모두 차례로 방문한 후에, 방문했던 자식 노드들을 기준으로 하여 다시 해당 노드의 자식 노드들을 차례로 방문하는 방식
- 인접한 노드들에 대해 탐색을 한 후, 차례로 다시 너비우선탐색을 진행해야 하므로, 선입선출 형태의 자료구조인 큐를 활용함

## BFS 알고리즘
<b>CompleteBinaryTree.java</b><br>
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
<b>CompleteBinaryTree.java</b><br>
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
<b>CompleteBinaryTree.java</b><br>
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
- 부모 노드의 키 값 >= 자식 노드의 키 값
- 루트 노드 : 키 값이 가장 큰 노드

### 최소 힙(min heap)
- 키 값이 가장 작은 노드를 찾기 위한 완전 이진 트리
- 부모 노드의 키 값 <= 자식 노드의 키 값
- 루트 노드 : 키 값이 가장 작은 노드

### 힙 연산 - 삭제 
- 힙에서는 루트 노드의 원소만을 삭제할 수 있다.
- 루트 노드의 원소를 삭제하여 반홚나다.
- 힙의 종류에 따라 최대값 또는 최소값을 구할 수 있다.

# 힙(Heap)활용
## 힙의 활용1 - 우선순위큐
### 우선순위 큐를 구현하는 가장 효율적인 방법이 힙을 사용한는 것이다.
- 노드 하나의 추가/삭제의 시간 복잡도가 O(logN)이고 최대값/최소값을 O(1)에 구할 수 있다.
- 완전 정렬보다 관리 비용이 적다.

### 배열을 통해 트리 형태를 쉽게 구현할 수 있다.
- 부모나 자식 노드를 O(1)연산으로 쉽게 찾을 수 있다.
- n위치에 있는 노드의 자식은 2n과 2n+1위치에 존재한다.
- 완전 이진 트리의 특성에 의해 추가/삭제의 위치는 자료의 시작과 끝 인덱스로 쉽게 판단할 수 있다.

### 우선순위 큐의 특성
- 우선순위를 가진 항목들을 저장하는 큐
- FIFO 순서가 아니라 우선순위가 높은 순서대로 먼저 나가게 된다.

### java.util.PriorityQueue
- Heap 자료구조
- 최대 heap
  - 가장 큰 값을 기준으로 먼저 나옴
- 최소 heap
  - 가장 작은 값을 기준으로 먼저 나옴

### java.util.PriorityQueue()
- 원소들의 natural Ordering에 따라 Heap 유지
- 따라서 반드시 모든 원소는 Comparable 인터페이스를 구현해야 함

### java.util.PriorityQueue(Comparator comparator)
- 명시된 Comparator의 구현에 따라 원소들의 순서를 유지

## 힙의 활용2
- 힙 정렬은 힙 자료구조를 이요해서 이진 트리와 유사한 방법으로 수행된다.
- 정렬을 위한 2단계
  1. 하나의 값을 힙에 삽입한다(반복).
  2. 힙에서 순차적(오름차순)으로 값을 하나씩 제거한다.

- 힙의 정렬의 시간 복잡도
  - N개의 노드 삽입 연산 + N개의 노드 삭제 연산
  - 노드 하나의 삽입과 삭제 연산은 각각 O(logN)이다.
  - 따라서 전체 정렬은 O(NlogN)이다.

# 완전검색
- 완전 검색 방법의 문제의 해법으로 생각할 수 있는 모든 경우의 수를 나열해보고 확인하는 기법이다.
- Brute-force 혹은 generate-and-test 기법이라고도 불리운다.
- 모든 경우의 수를 테스트한 후, 최종 해법을 도출한다. 시간적으로는 불리하다.
- 상대적으로 빠른 시간에 문제 해결(알고리즘 설계)을 할 수 있다.
- 일반적으로 경우의 수가 상대적으로 작을 때 유용하다.
- 이들은 전형적으로 순열, 조합, 그리고 부분집합과 같은 조합적문제들과 연관된다.

## 완전 검색으로 시작하라
- 모든 경우의 수를 생성하고 테스트하기 때문에 수행 속도는 느리지만, 해답을 찾아내지 못할 확률이 작다.
- 검정 등에서 주어진 문제를 풀 때, 우선 완전 검색으로 접근하여 해답을 도출한 후, 성능 개선을 위해 다른 알고리즘을 사용하고 해답을 확인하는 것이 바람직하다.

# 순열 응용 - 비트마스킹 순열
### 비트마스킹을 통한 순열 생성 - 정수와 비트연산자를 사용
<b>PermutationBitMaskingTest.java</b><br>
```java
nPn -> N개의 원소로 만들 수 있는 모든 순열 생성
input[] : 숫자 배열
numbers[] : 순열 저장 배열

perm(cnt, flag) // cnt: 현재까지 뽑은 순열 원소의 개수, flag: 선택된 원소에 대한 비트정보를 표현하는 정수
  if cnt == N
    순열 생성 완료
  else
    for i from 0 to N-1
      if(flag & 1<<i) != 0 then continue // i번째 자리가 1이면 continue라는 의미
      numbers[cnt] <- input[i]
      perm(cnt+1, flag | 1<<i) // i번째 자리에 1을 넣는것
    end for
  end perm()
```

### 비트 연산자
- & : 비트단위로 AND 연산을 한다.
  - 각 배트열을 비교하여 두 비트 모두 1이면 1, 아니면 0으로 처리
- | : 비트 단위로 OR 연산을 한다.
  - 각 비트열을 비교하여 두 비트 모두 0이면 0, 아니면 1로 처리
- ^ : 비트 단위로 XOR 연산을 한다.(같으면 0 다르면 1)
- ~ : 단항 연산자로서 피연산자의 모든 비트를 반전시킨다.
- << : 피연산자의 비트 열을 왼쪽으로 이동시킨다.
  - value << n : value를 n비트 만큼 왼쪽으로 shift
  - 왼쪽으로 밀어내고 남은 오른쪽 자리는 0으로 채움
- >> : 피연산자의 열을 오른쪽으로 이동시킨다.

# 순열 응용 - Next Permutation
<b>NextPermutationTest.java</b>
> 현 순열에서 사전 순으로 다음 순열 생성 - NextPermutation
### 알고리즘
- 배열을 오름차순으로 정렬한 후 시작한다.
- 아래 과정을 반복하여 사전 순으로 다음으로 큰 순열 생성(가장 큰 내림차순 순열을 만들 때까지 반복한다.)
  1. 뒤쪽부터 탐색하며 교환위치(i-1) 찾기(i: 꼭대기)
  2. 뒤쪽부터 탐색하며 교환위치(i-1)와 교환할값보다 첫번째로 큰 값 위치(j) 찾기
  3. 두 위치 값(i-1, j) 교환
  4. 꼭대기위치(i)부터 맨 뒤까지 오름차순 정렬

### 주의사항
- NextPermutation 사용 전에 숫자배열을 오름차순으로 정렬하여 가장 작은 순열 한번 처리

# 조합 응용 - Next Permutation 활용
> hot encoding? 같은거?
- 원소크기와 같은 크기의 int 배열 P를 생성하여 r개 크기만큼 뒤에서 0이 아닌 값(예를 들어 1)으로 초기화한다.
- nextPermutation 알고리즘을 활용한다.
- nextPermutation 알고리즘 한 번 수행시마다 조합이 만들어짐
  > nextPermutation 과정 수행시마다 0이 아닌 값의 위치가 변경됨
- P 배열에서 0이 아닌 값을 갖고 있는 위치에 해당하는 원소가 조합에 선택된 것임

# 부분집합 응용 - 바이너리 카운팅
### 바이너리 카운팅을 통한 사전적 순서(Lexicographical Order)로 생성하는 방법
- 부분집합을 생성하기 위한 가장 자연스러운 방법이다.
- 바이너리 카운팅(Binary Counting)은 사전적 순서로 생성하기 위한 가장 간단한 방법이다.