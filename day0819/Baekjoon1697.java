package com.day0819;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon1697 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt(), K = sc.nextInt();
        if(N==K) {
            System.out.println(0);
            return;
        }
        
        boolean[] visited = new boolean[100001];
        Queue<int[]> que = new ArrayDeque<>();
        que.offer(new int[]{N, 0});
        visited[N] = true;
        
        int[] cur = new int[2];
        while(!que.isEmpty()){
            cur = que.poll();

            if(cur[0]-1==K || cur[0]+1==K || cur[0]*2==K) break;
            if(cur[0]-1 >= 0 && !visited[cur[0]-1]) {
                visited[cur[0]-1] = true;
                que.offer(new int[]{cur[0]-1, cur[1]+1});
            }
            if(cur[0]+1 <= 100000 && !visited[cur[0]+1]) {
                visited[cur[0]+1] = true;
                que.offer(new int[]{cur[0]+1, cur[1]+1});
            }
            if(cur[0]*2 <= 100000 && !visited[cur[0]*2]) {
                visited[cur[0]*2] = true;
                que.offer(new int[]{cur[0]*2, cur[1]+1});
            }
        }
        
        System.out.println(cur[1]+1);
    }
}
