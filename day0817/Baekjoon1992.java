package com.day0817;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon1992 {

    static StringBuffer answer = new StringBuffer();
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int i=0; i<N; i++){
            String str = br.readLine().trim();
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(str.charAt(j)+"");
            }
        }

        divide(0, 0, N);
        System.out.println(answer);
    }

    private static void divide(int x, int y, int n) {
        if(n == 0) return;
        int val = allSame(x, y, n);
        if(val != -1){
            answer.append(val);
        } else {
            answer.append("(");
            divide(x, y, n / 2);
            divide(x, y + n / 2, n / 2);
            divide(x + n / 2, y, n / 2);
            divide(x + n / 2, y + n / 2, n / 2);
            answer.append(")");
        }
    }

    private static int allSame(int x, int y, int n) {
        int val = map[x][y];
        for(int i=x; i<x+n; i++){
            for(int j=y; j<y+n; j++){
                if(val != map[i][j]) return -1;
            }
        }
        return val;
    }

}
