package ccc2016;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author Xin (Jn_xyp)
 * @version Unavailable My site: <a href="https://blog.jnxyp.tk/">Water Pool</a>
 */
public class J5 {
  public static void main(String[] args) {
    // declare variables
    Scanner cary = new java.util.Scanner(System.in);
    int choice = 0, n = 0;
    Integer[] a;
    Integer[] b;
    int sum = 0;
    // get input
    choice = cary.nextInt();
    cary.nextLine();
    n = cary.nextInt();
    cary.nextLine();
    a = new Integer[n];
    b = new Integer[n];
    for (int i = 0; i < n; i++) {
      a[i] = cary.nextInt();
    }
    for (int i = 0; i < n; i++) {
      b[i] = cary.nextInt();
    }
    cary.close();
    Arrays.sort(a);
    if (choice == 1) {
      Arrays.sort(b);
    }
    else {
      Arrays.sort(b, Collections.reverseOrder());
    }

    for (int x = 0; x < a.length; x++) {
      sum += max(a[x], b[x]);
    }
    System.out.println(sum);
  }

  public static int max(int a, int b) {
    if (a > b) {
      return a;
    }
    else {
      return b;
    }
  }
}
