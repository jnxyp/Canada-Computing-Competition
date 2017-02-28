package ccc2015;

import java.util.Scanner;

/**
 * <p>
 * This is a practice of CCC problems, 2015 Junior. <br />
 * <br />
 * <a href=
 * "http://cemc.uwaterloo.ca/contests/computing/2015/stage%201/juniorEn.pdf">Link
 * to the problem description</a>
 * </p>
 * 
 * @author Xin (<a href="http://blog.jnxyp.tk">Jn_xyp</a>)
 * @version 2017-02-18
 * 
 */
public class J2 {
  public static void main(String[] args) {
    final String happy = ":-)", sad = ":-(";
    int happyCount = 0, sadCount = 0;
    Scanner cary = new Scanner(System.in);
    String input = cary.nextLine();
    cary.close();

    if (input.contains(happy) || input.contains(sad)) {
      int i = 0;
      // Count happy
      while (true) {
        i = input.indexOf(happy, i);
        if (i == -1) {
          break;
        }
        happyCount++;
        i += happy.length();
      }
      i = 0;
      // Count sad
      while (true) {
        i = input.indexOf(sad, i);
        if (i == -1) {
          break;
        }
        sadCount++;
        i += sad.length();
      }
      // Output
      if (happyCount > sadCount) {
        System.out.println("happy");
      }
      else if (happyCount < sadCount) {
        System.out.println("sad");
      }
      else {
        System.out.println("unsure");
      }
    }
    else {
      System.out.println("none");
    }
  }
}
