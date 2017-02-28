package ccc2014;

import java.util.Scanner;

/**
 * @author Xin (Jn_xyp)
 * @version 2017-01-11 This is a practice of CCC problems, 2014 Junior A program
 *          to find out the result of dice game
 */

public class J3 {
  public static void main(String[] args) {
    Scanner cary = new Scanner(System.in);
    int amountOfRounds, scoreA = 100, scoreB = 100, diceA, diceB;
    String input;
    amountOfRounds = cary.nextInt();
    cary.nextLine();
    for (int i = 0; i < amountOfRounds; i++) {
      input = cary.nextLine();
      diceA = Integer.parseInt(input.substring(0, 1));
      diceB = Integer.parseInt(input.substring(2));
      if (diceA > diceB) {
        scoreB -= diceA;
      }
      else if (diceA < diceB) {
        scoreA -= diceB;
      }
    }
    cary.close();
    System.out.println(scoreA);
    System.out.println(scoreB);
  }
}