package com.day0809;

import java.util.Scanner;

public class SWEA6808 {
	
	static int[] cardsA = new int[9];
	static int[] cardsB = new int[9];
	static int[] shuffledB = new int[9];
 	static boolean[] isSelected;
	static int win, lose;
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int t=1; t<=tc; t++) {
			boolean[] cardSet = new boolean[19];
			
			for(int i=0; i<9; i++) {
				cardsA[i] = sc.nextInt();
				cardSet[cardsA[i]] = true;
			}
	
			isSelected = new boolean[9];
			int cnt = 0;
			for(int i=1; i<=18; i++) {
				if(cardSet[i]) continue;
				cardsB[cnt] = i;
				cnt++;
			}
			
			win = 0;
			lose = 0;
			shuffle(0);
			
			System.out.println("#" + t + " " + win + " " + lose);
		}
	}

	private static void shuffle(int cnt) {
		if(cnt == 9) {
			playGame();
			return;
		}
		
		for(int i=0; i<9; i++) {
			if(isSelected[i]) continue;
			shuffledB[cnt] = cardsB[i];
			
			isSelected[i] = true;
			shuffle(cnt+1);
			isSelected[i] = false;
		}
	}

	private static void playGame() {
		int scoreA = 0, scoreB = 0;
		for(int i=0; i<9; i++) {
			if(cardsA[i] > shuffledB[i]) {
				scoreA += cardsA[i] + shuffledB[i];
			} else scoreB += cardsA[i] + shuffledB[i];
		}
		
		if(scoreA > scoreB) win += 1;
		else if(scoreA < scoreB) lose += 1;
	}

}
