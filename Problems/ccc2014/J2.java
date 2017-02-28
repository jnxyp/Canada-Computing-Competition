package ccc2014;

import java.util.Scanner;

/**
 * @author Xin (Jn_xyp)
 * @version 2017-01-11 This is a practice of CCC problems, 2014 Junior A program
 *          to count the vote of singer
 */

public class J2 {
  public static void main(String[] args) {
    Scanner cary = new Scanner(System.in);
    int voteAmount, voteForA = 0, voteForB = 0;
    String votes;
    voteAmount = cary.nextInt();
    cary.nextLine();
    votes = cary.nextLine();
    cary.close();
    for (int i = 0; i < voteAmount; i++) {
      if (votes.charAt(i) == 'A') {
        voteForA++;
      }
      else if (votes.charAt(i) == 'B') {
        voteForB++;
      }
    }
    if (voteForA > voteForB) {
      System.out.println("A");
    }
    else if (voteForB > voteForA) {
      System.out.println("B");
    }
    else {
      System.out.println("Tie");
    }
  }
}