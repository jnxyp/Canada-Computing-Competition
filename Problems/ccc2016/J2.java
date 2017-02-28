package ccc2016;

import java.util.Arrays;
import java.util.Scanner;

/**
 * My site: <a href="https://blog.jnxyp.tk/">Water Pool</a>
 * 
 * @author Xin (Jn_xyp)
 * @version Unavailable
 */
public class J2 {
  public static void main(String[] args) {
    // declare variables
    Scanner cary = new java.util.Scanner(System.in);
    boolean isMagic = true;
    int[][] numbers = new int[4][4];
    int[] sum = new int[8];
    Arrays.fill(sum, 0);
    String[] temp1;
    int temp2;
    // get input
    for (int x = 0; x < numbers.length; x++) {
      temp1 = cary.nextLine().split(" ");
      for (int y = 0; y < numbers[x].length; y++) {
        numbers[x][y] = Integer.parseInt(temp1[y]);
      }
    }
    cary.close();
    // calculate the sums
    for (int x = 0; x < numbers.length; x++) {
      for (int y = 0; y < numbers[x].length; y++) {
        sum[x] += numbers[x][y];
      }
    }
    for (int x = 0; x < numbers.length; x++) {
      for (int y = 0; y < numbers[x].length; y++) {
        sum[x + 4] += numbers[y][x];
      }
    }
    // compare
    temp2 = sum[0];
    for (int x : sum) {
      if (temp2 != x) {
        isMagic = false;
        break;
      }
    }
    // output
    if (isMagic) {
      System.out.println("magic");
    }
    else {
      System.out.println("not magic");
    }
  }
}
