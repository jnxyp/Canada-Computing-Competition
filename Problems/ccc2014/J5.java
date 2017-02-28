package ccc2014;

import java.util.Scanner;

/**
 * @author Xin (Jn_xyp)
 * @version 2017-01-11 This is a practice of CCC problems, 2014 Junior A program
 *          to check if people are in correct pairs with each other
 */

public class J5 {
  public static void main(String[] args) {
    Scanner cary = new Scanner(System.in);
    String temp;
    String[] list1, list2;
    boolean isGood = true;
    cary.nextInt();
    cary.nextLine();
    temp = cary.nextLine();
    list1 = temp.split(" ");
    temp = cary.nextLine();
    list2 = temp.split(" ");
    cary.close();
    // Check duplication
    for (int i = 0; i < list1.length; i++) {
      if (list1[i].equals(list2[i])) {
        isGood = false;
        break;
      }
    }
    // Check correspondence
    if (isGood) {
      for (int i = 0; i < list1.length; i++) {
        for (int j = 0; j < list1.length; j++) {
          if (list1[j].equals(list2[i])) {
            if (!list2[j].equals(list1[i])) {
              isGood = false;
              break;
            }
          }
        }
        if (!isGood) {
          break;
        }
      }
    }
    // Print result
    if (isGood) {
      System.out.println("good");
    }
    else {
      System.out.println("bad");
    }
  }
}