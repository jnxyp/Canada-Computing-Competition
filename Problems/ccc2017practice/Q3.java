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
public class Q3 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int lines = in.nextInt();
    int temp;
    int[] count = new int[1001];
    for (int i = 0; i < count.length; i++) {
      count[i] = 0;
    }
    for (int i = 0; i < lines; i++) {
      temp = in.nextInt();
      count[temp]++;
    }

    int max1 = 0, max2 = 0;
    for (int i = 0; i < count.length; i++) {
      if (count[i] > count[max1]) {
        max1 = i;
      }
    }
    for (int i = 0; i < count.length; i++) {
      if (count[i] >= count[max2] && i != max1) {
        max2 = i;
      }
    }

    int maxDiff = 0;
    if (count[max1] == count[max2]) {
      maxDiff = max2 - max1;
    }
    else {
      for (int i = 0; i < count.length; i++) {
        if (count[i] == count[max2]) {
          if (Math.abs(max1 - i) > maxDiff) {
            maxDiff = Math.abs(max1 - i);
          }
        }
      }
    }

    System.out.println(maxDiff);
  }
}
