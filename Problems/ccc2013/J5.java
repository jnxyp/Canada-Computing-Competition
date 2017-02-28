package ccc2013;

import java.util.Scanner;

public class J5 {
  static int       TEAMS         = 4;
  static int[][]   MATCHES       = { { 1, 2 }, { 1, 3 }, { 1, 4 }, { 2, 3 }, { 2, 4 }, { 3, 4 } };
  static int       numOfWays;
  static boolean[] matchIsFinish = new boolean[MATCHES.length];

  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
    int[] score = new int[TEAMS];

    int myTeam = input.nextInt();
    int matchCount = input.nextInt();
    int team1, team2, team1Points, team2Points;

    for (int i = 0; i < matchCount; i++) {
      team1 = input.nextInt();
      team2 = input.nextInt();
      team1Points = input.nextInt();
      team2Points = input.nextInt();

      for (int j = 0; j < MATCHES.length; j++) {
        if (team1 == MATCHES[j][0] && team2 == MATCHES[j][1]) {
          matchIsFinish[j] = true;
          break;
        }
        if (team1Points > team2Points) {
          score[team1] = score[team1] + 3;
        }
        else if (team1Points < team2Points) {
          score[team2] = score[team2] + 3;
        }
        else {
          score[team1] = score[team1] + 1;
          score[team2] = score[team2] + 1;
        }
      }
    }
  }

  public void play(int prevMatch, int[] score) {
    int currentMatch = -1;
    for (int i = prevMatch + 1; i < MATCHES.length; i++) {
      if (matchIsFinish[i] == false) {
        currentMatch = i;
        break;
      }
    }
    int[] scoreCopy;
    scoreCopy = score.clone();
    play(currentMatch, scoreCopy);

  }
}
