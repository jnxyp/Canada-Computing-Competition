package ccc2014;

import java.util.Scanner;

/**
 * @author Xin (Jn_xyp)
 * @version 2017-01-13 This is a practice of CCC problems, 2014 Senior A program
 *          to find out which people should I invite to the party
 */

public class S1 {
  public static void main(String[] args) {
    Scanner cary = new Scanner(System.in);
    String inviteList = "", tempList = "";
    int amountOfPeople, amountOfRounds, removeNum;
    amountOfPeople = cary.nextInt();
    cary.nextLine();
    amountOfRounds = cary.nextInt();
    cary.nextLine();
    // generate inviting list
    for (int i = 1; i <= amountOfPeople; i++) {
      inviteList += i;
    }
    // remove people in each round
    for (int i = 0; i < amountOfRounds; i++) {
      tempList = "";
      removeNum = cary.nextInt();
      cary.nextLine();
      for (int j = 1; j <= inviteList.length(); j++) {
        if (j % removeNum != 0) {
          tempList += inviteList.charAt(j - 1);
        }
      }
      inviteList = tempList;
    }
    cary.close();
    // print result
    for (int i = 0; i < inviteList.length(); i++) {
      System.out.println(inviteList.charAt(i));
    }
  }
}