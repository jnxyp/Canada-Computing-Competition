package ccc2016;

import java.util.Scanner;

/**
 * My site: <a href="https://blog.jnxyp.tk/">Water Pool</a>
 * 
 * @author Xin (Jn_xyp)
 * @version Unavailable
 */
public class J1 {
  public static void main(String[] args) {
    // declare variables
    char temp;
    int winCount = 0;
    Scanner cary = new java.util.Scanner(System.in);

    // System.out.println ("Enter the result of 6 games:");
    for (int x = 0; x < 6; x++) {
      // get input
      temp = cary.nextLine().charAt(0);
      // process
      if (temp == 'w' || temp == 'W') {
        winCount++;
      }
    }
    cary.close();
    // print result
    if (winCount == 5 || winCount == 6) {
      System.out.println("1");
    }
    else if (winCount == 3 || winCount == 4) {
      System.out.println("2");
    }
    else if (winCount == 1 || winCount == 2) {
      System.out.println("3");
    }
    else {
      System.out.println("-1");
    }
  }
}
