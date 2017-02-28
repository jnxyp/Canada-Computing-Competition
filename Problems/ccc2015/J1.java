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
public class J1 {
  public static void main(String[] args) {
    Scanner cary = new Scanner(System.in);
    final int SPECIAL_MONTH = 2, SPECIAL_DAY = 18;
    int inputMonth = cary.nextInt();
    int inputDay = cary.nextInt();
    cary.close();

    if (inputMonth < SPECIAL_MONTH) {
      System.out.println("Before");
    }
    else if (inputMonth > SPECIAL_MONTH) {
      System.out.println("After");
    }
    else {
      if (inputDay < SPECIAL_DAY) {
        System.out.println("Before");
      }
      else if (inputDay > SPECIAL_DAY) {
        System.out.println("After");
      }
      else {
        System.out.println("Special");
      }
    }
  }
}
