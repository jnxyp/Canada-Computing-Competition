package ccc2014;

import java.util.Scanner;

/**
 * @author Xin (Jn_xyp)
 * @version 2017-01-16 This is a practice of CCC problems, 2014 Junior
 */

public class J4 {
  public static void main(String[] args) {
    Scanner cary = new Scanner(System.in);
    int amountOfPeople, amountOfRound, removeSerial, currentIndex;
    int[] inviteList, tempList;

    amountOfPeople = cary.nextInt();
    cary.nextLine();
    amountOfRound = cary.nextInt();
    cary.nextLine();

    inviteList = new int[amountOfPeople];

    for (int i = 0; i < amountOfPeople; i++) {
      inviteList[i] = i + 1;
    }

    for (int i = 0; i < amountOfRound; i++) {
      removeSerial = cary.nextInt();
      cary.nextLine();
      for (int j = 0; j < inviteList.length; j++) {
        if ((j + 1) % removeSerial == 0) {
          inviteList[j] = 0;
        }
      }
      amountOfPeople = 0;
      for (int x : inviteList) {
        if (x != 0) {
          amountOfPeople++;
        }
      }
      tempList = new int[amountOfPeople];
      currentIndex = 0;
      for (int j = 0; j < inviteList.length; j++) {
        if (inviteList[j] != 0) {
          tempList[currentIndex] = inviteList[j];
          currentIndex++;
        }
      }
      inviteList = tempList;
    }
    cary.close();

    for (int x : inviteList) {
      System.out.println(x);
    }
  }
}