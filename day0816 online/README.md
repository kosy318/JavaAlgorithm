# 부분집합 응용 - 바이너리 카운팅
### 바이너리 카운팅을 통한 사전적 순서(Lexicographical Order)로 생성하는 방법
- 부분집합을 생성하기 위한 가장 자연스러운 방법이다.
- 바이너리 카운팅(Binary Counting)은 사전적 순서로 생성하기 위한 가장 간단한 방법이다.

### 바이너리 카운팅(Binary Counting)
- 원소 수에 해당하는 N개의 비트열을 이용한다.
- n번째 비트값이 1이면 n번째 원소가 포함되었음을 의미한다.

### 바이너리 카운팅을 통한 부분집합 생성 코드 예
<b>SubSet_BinaryCountingTest.java</b><br>
```java
int arr[] = {3, 6, 7, 1, 5, 4};
int n = arr.length;

for(int i=0; i<(1<<n); i++) { // 1<<n: 부분집합의 개수
  for(int j=0; j<n; j++) {    // 원소의 수만큼 비트를 비교함
    if(i & (1<<j) != 0) {
      System.out.print(arr[j] + " ");
  }
  System.out.println();
}
```

# 탐욕 기법
## 탐욕(Greedy) 알고리즘
- 탐욕 알고리즘은 최적해를 구하는 데 사용되는 근시안적인 방법
- 최적화문제(optimization)란 가능한 해들 중에서 가장 좋은(최대 또는 최소) 해를 찾는 문제이다.
- 일반적으로, 머리 속에 떠오르는 생각을 검증 없이 바로 구현하면 Greedy 접근이 된다.
- 여러 경우 중 하나를 선택 할 때마다 그 순간에 최적이라고 생각되는 것을 선택해 나가는 방식으로 진행하여 최종적인 해답에 도달한다.
- 각 선택 시점에서 이루어지는 결정은 지역적으로 최적이지만, 그 선택들을 계속 수집하여 최종적인 해답을 만들었다고 하여, 그것이 최적이라는 보장은 없다. (검증 요구)
- 일단, 한번 선택된 것은 번복하지 않는다. 이런 특석 때문에 대부분의 탐욕 알고리즘들은 단순하며, 또한 제한적인 문제들에 적용된다.

# 탐욕 기법 - 배낭 짐싸기
### knapsack 문제의 전형적 정의
- S : 물건들의 집합
- W_i : item_i의 무게, P_i = item_i의 값
- W : 배낭이 수용 가능한 총 무게
- 문제 정의<br>
  $\sum_{item_i \in A} w_i <= W$를 만족하면서 $\sum_{item_i \in A} P_i$가 최대가 되도록<br>
  $A \subseteq S$가 되는 $A$를 결정하는 문제 

### knapsack 문제 유형
- 0-1 knapsack
  - 배낭에 물건을 통째로 담아야 하는 문제
  - 물건을 쪼갤 수 없는 경우

- Fractional Knapsack
  - 물건을 부분적으로 담는 것이 허용되는 문제
  - 물건을 쪼갤 수 있는 경우
  
### 0-1 knapsack에 대한 완전 검색 방법
- 완전 검색으로 물건들의 집합 S에 대한 모든 부분집합을 구한다.
- 부분집합의 총 무게가 W를 초과하는 집합을 버리고 나머지 집합에서 총 값이 가장 큰 집합을 선택할 수 있다.
- 물건의 개수가 증가하면 시간 복잡도가 지수적으로 증가한다.
  - 크기 n인 부분집합의 수 2^n

# 탐욕 기법 활용 - 회의실 배정
- 시작시간과 종료시간( $s_i$, $f_i$ )이 있는 n개의 활동들의 집합 $A = {A_1, A_2, ..., A_n}$, $1<= i <=n$에서 서로 겹치지 않는(non-overlapping) 최대개수의 활동들의 집합 $S$를 구하는 문제
- 양립 가능한 활동들의 크기가 최대가 되는 $S_{0,n+1}$의 부분집합을 선택하는 문제
  - 종료시간 순으로 활동들을 정렬한다.
  - $S_{0,n+1}$는 $a_0$의 종료시간부터 $a_{n+1}$의 시작시간 사이에 포함된 활동들

## 활동 선택 문제(Activity-selection problem)
### 탐욕 기법의 적용
$S_{i,j}$를 풀기 위해
1. $a_i$ 종료 시간부터 시작 가능한 활동 중 종료 시간이 가장 빠른 $a_m$ 선택
2. $S_{i,j} = {a_m} \cup S_{m,j}$의 해집합

$S_{i,j}$는 $a_i$의 종료 시간부터 $a_j$의 시작시간 사이에 포함된 활동들

### 탐욕 기법을 적용한 반복 알고리즘
<b>MeetingRoomTest.java</b><br>
```java
A : 활동들의 집합, S : 선택된 활동(회의)들 집합
s_i : i활동의 시작시간, f_i : i활동의 종료시간, 1<=i<=n

Sort A by finish time
S <- {A_1}
j <- 1 // 선택된 활동 집합 중 마지막 활동
FOR i in 2 -> n
  IF f_j <= s_i
    S <- S U {A_i}
    j <- i
```
- 종료 시간이 빠른 순서로 활동들을 정렬한다.
- 첫번째 활동(A_1)을 선택한다.
- 선택한 활동(A_1)의 종료시간보다 빠른 시작 시간을 가지는 활동은 무시(skip)하며 같거나 늦은 시작시간을 갖는 활동을 선택한다.
- 선택된 활동의 종료시간을 기준으로 뒤에 남은 활동들에 대해 앞의 과정을 반복한다.

## 탐욕 알고리즘의 필수 요소
### 탐욕적 선택 속성(greedy choice property)
- 탐욕적 선택은 최적해로 갈 수 있음을 보여라.
  -> 즉, 탐욕적 선택은 항상 안전하다.

### 최적 부분 구조(optimal substructure property)
- 최적화 문제를 정형화하라
  -> 하나의 선택을 하면 풀어야 할 하나의 하위 문제가 남는다.

### [원문제의 최적해 = 탐욕적 선택 + 하위 문제의 최적해] 임을 증명하라.

## 탐욕 알고리즘의 예
### 대표적인 탐욕 기법의 알고리즘들
<img src = "https://user-images.githubusercontent.com/77595685/185794873-4620e602-56d4-4185-9c6b-e6d968af351d.png" width = "700px"/><br>

# 탐욕 기법 응용 - 동전 자판기
<b>Ex_동전자판기_Test.java</b><br>
동전을 많이 사용하는 법 구하기<br>
보유한 동전의 총 금액을 구하고 지불해야할 금액을 뺀 나머지의 값을 구한다<br>
그 나머지 값을 최소한의 동전을 사용하여 지불 할 수 있는 방법을 구한다.

# 분할 정복 기법
### 유래
- 1805년 12월 2일 아우스터리츠 전투에서 나폴레옹이 사용한 전략
- 전력이 우세한 연합군을 공격하기 위해 나폴레옹은 연합군의 중앙부로 쳐들어가 연합군을 둘로 나눔
- 둘로 나뉜 연합군을 한 부분씩 격파함

### 설계 전력
- 분할(Divide) : 해결할 문제를 여러 개의 작은 부분으로 나눈다.
- 정복(Conquer) : 나눈 작은 문제를 각각 해결한다.
- 통함(Combine) : (필요하다면) 해결된 해답을 모은다.

### Top-down approach

## 거듭 제곱
<b>SquareNumberTest.java</b><br>
### 반복(Iterative) 알고리즘 : $O(n)$
$C^n = C \times C \times C ... C$
```java
Iterative_Power(x, n)
  result <- 1
  
  FOR i in 1 -> n
    result <- result*x
    
  RETURN result
```

### 분할 정복 기반 알고리즘 : $O(\log_2 n)$
$C^n = C^{(n-1)/2} \times C^{(n-1)/2} \times C$
```java
Recursive_Power(x, n)
  IF n == 1 : RETURN x
  IF n is even
    y <- Recursive_Power(x, n/2)
    RETURN y*y
  ELSE
    y <- Recursive_Power(x, (n-1)/2)
    RETURN y*y*x
```

# 분할 정복 기법 활용 - 이진 검색
## 이진 검색(Binary Search)
- 자료의 가운데에 있는 항목의 키 값과 비교하여 다음 검색의 위치를 결정하고 검색을 계속 진행하는 방법
  - 목적 키를 찾을 때까지 이진 검색을 순환적으로 반복 수행함으로써 검색 범위를 반으로 줄여가면서 보다 빠르게 검색을 수행함
- 이진 검색을 하기 위해서는 자료가 정렬된 상태여야한다.

### 검색 과정
1. 자료의 중앙에 있는 원소를 고른다.
2. 중앙 원소의 값과 찾고자 하는 목표 값을 비교한다.
3. 중앙 원소의 값과 찾고자 하는 목표 값이 일치하면 탐색을 끝낸다.
4. 목표 값이 중앙 원소의 값보다 작으면 자료의 왼쪽 반에 대해서 새로 검색을 수행하고, 크다면 자료의 오른쪽 반에 대해서 새로 검색을 수행한다.
5. 찾고자 하는 값을 찾을 때까지 위의 과정을 반복한다.

### 알고리즘 : 반복구조
```java
binarySearch(S[], n, key)
  start <- 0
  end <- n-1
  
  WHILE start <= end
    mid <- (start + end) /2
    IF S[mid] == key
      RETURN mid
    ELIF S[mid] < key
      start <- mid + 1
    ELIF S[mid] > key
      end <- mid -1
  END WHILE
RETURN -1
```

### 알고리즘 : 재귀 구조
```java
binarySearch(S[], start, end, key)
  IF start > end
    RETURN -1
  ELSE
    mid <- (start + end) /2
    IF S[mid] == key
      RETURN mid
    ELIF S[mid] < key
      RETURN binarySearch(S[], mid+1, end, key)
    ELSE
      RETURN binarySearch(S[], start, mid-1, key)
```

## 이진 검색(Binary Search) API
java.util.Arrays.binarySearch : 정렬된 배열 전달
