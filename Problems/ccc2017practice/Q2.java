package ccc2017practice;

import java.util.Scanner;

/**
 * <p>
 * This is a practice of CCC problems, 2017 Practice. <br />
 * <br />
 * </p>
 * 
 * @author Xin (<a href="http://blog.jnxyp.tk">Jn_xyp</a>)
 * @version 2017-02-20
 * 
 */
public class Q2 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int h = in.nextInt();
    int m = in.nextInt();
    int t = 1;
    while (-6 * t * t * t * t + h * t * t * t + 2 * t * t + t > 0 && t < m) {
      t++;
    }
    if (t == m) {
      System.out.println("The balloon does not touch ground in the given time.");
    }
    else {
      System.out.println("The balloon first touches ground at hour:");
      System.out.println(t);
    }
  }
}
