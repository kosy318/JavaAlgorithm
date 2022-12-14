# 리스트(List)
- 순서를 가진 데이터의 집합을 가리티는 추상자료형(abstract data type)
- 동일한 데이터를 가지고 있어도 상관없다.

- 구현 방법에 따라 크게 두 가지로 나뉜다.
  1. 순차 리스트: 배열을 기반으로 구현된 리스트
  2. 연결 리스트: 메모리의 동적할등을 기반으로 구현된 리스트

## 순차 리스트
### 구현 방법
- 1차원 배열에 항목들을 순서대로 저장한다.
- 데이터의 종류와 구조에 따라 구조화된 자료구조를 만들어 배열에 저장할 수도 있다.

### 데이터 접근
- 배열의 인덱스를 이용해 원하는 위치의 데이터에 접근할 수 있다.

### 삽입 연산
- 삽입 위치 다음의 항목들을 뒤로 이동해야 한다.

### 삭제 연산
- 삭제 위치 다음의 항목들을 앞으로 이동해야 한다.

## 순차 리스트의 문제점
- 단순 배열을 이용한 순차리스트를 구현해 사용하는 경우, 자료의 삽입/삭제 연산 과정에서 연속적인 메모리 배열을 위해 원소들을 이동시키는 작업이 필요하다.
- 원소의 개수가 많고 삽입/삭제 연산이 빈번하게 일어날수록 작업에 소요되는 시간이 크게 증가한다.
- 배열의 크기가 정해져있는 경우, 실제로 사용될 메모리보다 크게 할당하여 메모리의 낭비를 초래할 수도 있고, 반대로 할당된 메모리보다 많은 자료를 사용하여 새롭게 배열을 만들어 작업을 해야하는 경우가 발생할 수도 있다.

## 연결 리스트(Linked List)
### 특성
- 자료의 논리적인 순서와 메모리 상의 물리적인 순서가 일치하지 않고, 개별적으로 위치하고 있는 각 원소를 연결하여 하나의 전체적인 자료구조를 이룬다.
- 링크를 통해 원소에 접근하므로, 순차 리스트에서처럼 물리적인 순서를 맞추기 위한 작업이 필요하지 않다.
- 자료구조의 크기를 동적으로 조정할 수 있어, 메모리의 효율적인 사용이 가능하다.

## 연결 리스트의 기본 구조
### 노드
- 연결 리스트에서 하나의 원소를 표현하는 building block
- 구성 요소
  1. 데이터 필드
    - 원소의 값을 저장
    - 저장할 원소의 종류나 크기에 따라 구조를 정의하여 사용함
  2. 링크 필드
    - 다음 노드의 참조값을 저장

### 헤드
- 연결 리스트의 첫 노드에 대한 참조값을 갖고 있음

## 연결 리스트의 종류
- 단순 연결 리스트
- 이중 연결 리스트
- 원형 연결 리스트

# 단순연결리스트(Singly Linked List)
### 연결 구조
- 노드가 하나의 링크필드에 의해 다음 노드와 연결되는 구조를 가진다.
- 헤드가 가장 앞의 노드를 가리키고, 링크 필드가 연속적으로 다음 노드를 가리킨다.
- 링크 필드가 Null인 노드가 연결 리스트의 가장 마지막 노드이다.

## 단순 연결 리스트의 삽입 연산 - 첫번째 노드로 삽입
### 공백 리스트의 첫번째 'A' 노드를 삽입할 때
1. 새로운 노드 new 생성
2. 새로운 노드 new의 데이터 필드에 'A' 저장
3. Head에 저장된 참조값을 새로운 노드 new의 링크 필드값에 저장
4. Head에 새로운 노드 new의 참조값을 저장

### 'A'를 원소로 갖고 있는 리스트의 첫번째에 'C' 노드를 삽입할 때
1. 새로운 노드 new 생성
2. 새로운 노드 new의 데이터 필드에 'C' 저장
3. Head에 저장된 참조값을 새로운 노드 new의 링크 필드값에 저장
4. Head에 새로운 노드 new의 참조값을 저장

### 첫 번째 노드로 삽입하는 알고리즘
```java
addtoFirst(L, i)        // 리스트 헤드 L, 원소 i
  new <- createNode();  // 새로운 노드 생성
  new.data = i;         // 데이터 필드 작성
  new.link = L;         // 링크 필드 작성
  L = new;              // 리스트의 처음으로 지정
end addtoFirst()
```

## 단순 연결 리스트의 삽입 연산 - 마지막 노드로 삽입
### 'C', 'A'를 원소로 갖고 있는 리스트의 마지막에 'D' 노드를 삽입할 때
1. 새로운 노드 new 생성
2. 새로운 노드 new의 데이터필드에 'D', 링크 필드에는 Null 저장
3. 리스트의 마지막 노드의 링크 필드에 새로운 노드 new의 참조값을 저장

### 마지막 노드로 삽입하는 알고리즘
```java
addtoLast(L, i)             // 리스트 헤드 L, 원소 i
  new <= createNode()       // 새로운 노드 생성
  new.data = i;
  new.link = Null;
  if(L == Null){            // 빈 리스트일 때, 최초 노드 추가
    L = new;
    return;
  }
  temp = L;                 // 노드 링크 이용하여 리스트 순회
  while(temp.link != Null){ // 마지막 노드 찾을 때까지 이동
    temp = temp.link;
  }
  temp.link = new;          // 마지막 노드 추가
end addtoLast()
```

## 단순 연결 리스트의 삽입 연산 - 가운데 노드로 삽입
### 'C', 'A', 'D'를 원소로 갖고 있는 리스트의 두번째에 'B' 노드를 삽입할 때
1. 새로운 노드 new 생성
2. 새로운 노드 new의 데이터 필드에 'B' 저장
3. 삽입될 위치의 바로 앞에 위치한 노드의 링크 필드를 new의 링크 필드에 복사
4. 새로운 노드 new의 참조값을 바로 앞 노드의 링크 필드에 저장

### 가운데 노드로 삽입하는 알고리즘
- 노드 pre의 다음 위치에 노드 삽입
```java
add(L, pre, i)        // 리스트 헤드 L, 노드 pre, 원소 i
  new <- createNode() // 새로운 노드 생성
  new.data = i;       // 데이터 필드 작성
  if(L == Null){
    L = new;
    new.link = Null;
  } else {
    new.link = pre.link;
    pre.link = new;
  }
end add()
```

## 단순 연결 리스트의 삭제 연산
### 'A', 'B', 'C', 'D'를 원소로 갖고 있는 리스트의 'B'노드를 삭제할 때
1. 삭제할 노드의 앞 노드(선행노드) 탐색
2. 삭제할 노드의 링크 필드를 선행노드의 링크 필드에 복사
3. 삭제할 노드의 링크 필드에 Null 저장

### 'A', 'C', 'D'를 원소로 갖고 있는 리스트의 'A' 노드를 삭제할 때
1. 삭제할 노드의 앞 노드(선행노드) 탐색: 선행노드 없음
2. 삭제할 노드의 링크 필드를 리스트의 Head에 복사
3. 삭제할 노드의 링크 필드에 Null 저장

### 노드를 삭제하는 알고리즘
- target 노드 삭제
```java
delete(L, target)                           // 리스트 헤드 L, 삭제노드 target
  if(L == null || target == Null) return;
  pre = getPreNode(target);                 // 선행노드 탐색
  if(pre == Null) {                         // 선행노드가 없다면, 첫 노드임
    L = target.link;
  } else {
    pre.link = target.link;
  }
  target.link = null;
end delete()
```

## 단순연결리스트로 스택 만들기
<b>IStack.java</b></br>
<b>Node.java</b></br>
<b>SooStack.java</b></br>
<b>StackTest.java</b></br>

# 이중연결리스트(Doubly Linked List)
### 특성
- 양쪽 방향으로 순회할 수 있도록 노드를 연결한 리스트
- 두 개의 링크 필드와 한 개의 데이터 필드로 구성

## 이중 연결 리스트의 삽입 연산
### cur이 가리키는 노드 다음으로 D값을 가진 노드를 삽입하는 과정
1. 새로운 노드 new를 생성하고 데이터 필드에 'D'를 저장한다.
2. cur 노드의 next를 new 노드의 next에 저장하여 cur의 다음 노드를 new노드의 다음 노드로 연결한다.
3. cur의 참조값을 new 노드의 prev에 저장하여 cur를 new 노드의 이전 노드로 연결한다.
4. new의 참조값을 new 노드의 이전 노드의 next에 저장하여 new 노드의 이전 노드의 다음 노드로 new 노드를 연결한다.
5. new의 참조값을 new 노드의 다음 노드의 prev에 저장하여 new 노드의 다음 노드의 이전 노드로 new 노드를 연결한다.

## 이중 연결 리스트의 삭제 연산
### cur이 가리키는 노드를 삭제하는 과정
1. 삭제할 노드 cur의 next를 cur의 이전 노드의 next에 저장하여 cur의 다음 노드를 cur의 이전 노드의 다음 노드로 연결한다.
2. 삭제할 노드 cur의 prev를 cur의 다음 노드의 prev에 저장하여 cur의 이전 노드를 cur의 다음 노드의 이전 노드로 연결한다.
3. 삭제할 노드 cur의 prev, next에 Null을 저장한다.

# 트리(Tree)
### 트리의 개념
- 비선형 구조
- 원소들 간에 1:n 관계를 가지는 자료구조
- 원소들 간에 계층관계를 가지는 계층형 자료구조
- 상위 원소에서 하위 원소로 내려가면서 확장되는 트리(나무)모양의 구조

## 정의 및 용어정리
- 한 개 이상의 노드로 이루어진 유한 집합이며 다음 조건을 만족한다.
  - 노드 중 최상위 노드를 루트(root)라 한다.
  - 나머지 노드들은 n(>=0)개의 분리 집합 T1, ..., TN으로 분리될 수 있다.

- 이들 T1, ..., TN은 각각 하나의 트리가 되며(재귀적 정의)루트의 부 트리(subtree)라 한다.
  - 서브 트리: 부모 노드와 연결된 간선을 끊었을 때 생성되는 트리

- 노드(node)
  - 트리의 원소

- 간선(edge)
  - 노드와 노드를 연결하는 선으로 부모 노드와 자식 노드를 연결

- 루트 노드(root node)
  - 트리의 시작 노드인 차상위 노드

- 형제 노드(sibling node)
  - 같은 부모 ㅗㄴ드의 자식 노드들

- 조상 노드
  - 간선을 따라 루트 노드까지 이르는 경로에 있는 모든 노드들

- 자손 노드
  - 서브 트리에 있는 하위 레벨의 노드들

- 차수(degree)
  - 노드의 차수 : 노드에 연결된 자식 노드의 수
  - 트리의 차수 : 트리에 있는 노드의 차수 중에서 가장 큰 값
  - 단말 노드(리프 노드) : 차수가 0인 노드 즉, 자식 노드가 없는 노드

- 높이
  - 노드의 높이 : 루트에서 노드에 이르는 간선의 수, 노드의 레벨
  - 트리의 높이 : 트리에 있는 노드의 높이 중에서 가장 큰 값, 최대 레벨

# 이진 트리
- 차수가 2인 트리 == 모든 노드 차수 2 이하
- 각 노드가 자식 노드를 최대한 2개까지만 가질 수 있는 트리
  - 왼쪽 자식 노드(left child node)
  - 오른쪽 자식 노드(right child node)

- 모든 노드들이 최대 2개의 서브트리를 갖는 특별한 형태의 트리
- 높이 i(level i)에서의 노드의 최대 개수는 2^i개
- 높이가 h인 이진트리가 가질 수 있는 노드의 최소 개수는 (h+1)개가 되며, 최대 개수는(2^(h+1) - 1)개가 된다.

## 종류
### 포화 이진 트리(Perfect Binary Tree)
- 모든 레벨에 노드가 포화 생태로 차 있는 이진 트리
- 높이가 h일 때, 최대의 노드 개수인(2^(h+1) -1)의 노드를 가진 이진 트리
- 루트를 1번으로 하여 2^(h+1) -1까지 정해진 위치에 대한 노드 번호를 가짐
  
### 완전 이진 트리(Complete Binary Tree)
- 높이가 h이고 노드 수가 n개일 때(단, h+1<=n<2^(h+1) -1), 포화 이진 트리의 노드 번호 1번부터 n번까지 빈 자리가 없는 이진 트리
  
### 편향 이진 트리(Skewed Binary Tree)
- 높이 h에 대한 최소 개수의 노드를 가지면서 한쪽 방향의 자식 노드만을 가진 이진 트리
  - 왼쪽/오른쪽 편향 이진 트리

## 이진트리의 표현
### 배열을 이용한 이진 트리의 표현
- 이진 트리에 각 노드 번호를 다음과 같이 부여
- 루트의 번호를 1로 함
- 레벨 n에 있는 노드에 대하여 왼쪽부터 오른쪽으로 2^n 부터 2^(n+1) -1까지 번호를 차례로 부여

### 노드 번호의 성질
- 노드 번호가 i인 노드의 부모 노드 번호? i/2
- 노드 번호가 i인 노드의 왼쪽 자식 노드 번호? 2*i
- 노드 번호가 i인 노드의 오른쪽 자식 노드 번호? 2*i + 1
- 레벨 n의 노드 번호 시작 번호? 2^n
- 높이가 h일 때, 배열의 크기? 2^(h+1)

### 배열을 이용한 이진 트리의 표현의 단점
- 편향 이진 트리의 경우에 사용하지 않는 배열 원소에 대한 메모리 공간 낭비 발생
- 트리의 중간에 새로운 노드를 삽입하거나 기존의 노드를 삭제할 경우 배열의 크기 변경 어려워 비효율적

## 비선형 자료구조 완전탐색
> 비선형구조인 트리, 그래프의 각 노드(정점)를 중복되지 않게 전부 방문(visit) 하는 것을 말하는데 비선형 구조는 선형 구조에서와 같이 선후 연결 관계를 알 수 없다. 따라서, BFS, DFS와 같은 방법이 필요하다.
