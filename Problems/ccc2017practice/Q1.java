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
public class Q1 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int input = in.nextInt();
    in.close();
    int count = 0;
    if (input <= 5) {
      count++;
    }
    for (int left = 1; left <= 5; left++) {
      for (int right = left; right <= 5; right++) {
        if (left + right == input) {
          count++;
        }
      }
    }
    System.out.println(count);
  }
}
