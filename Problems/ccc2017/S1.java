package ccc2017;

import java.util.Scanner;

/**
 * <p>
 * This is my answer for CCC, 2017 Senior. <br />
 * <br />
 * </p>
 * 
 * @author Xin (<a href="http://blog.jnxyp.tk">Jn_xyp</a>)
 * @version 2017-02-22
 * 
 */
public class S1 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int[] team1, team2;
    int days = input.nextInt();
    team1 = new int[days];
    team2 = new int[days];

    for (int i = 0; i < days; i++) {
      team1[i] = input.nextInt();
    }

    for (int i = 0; i < days; i++) {
      team2[i] = input.nextInt();
    }

    int same = 0;

    int sum1 = 0, sum2 = 0;

    for (int i = 0; i < days; i++) {
      sum1 += team1[i];
      sum2 += team2[i];
      if (sum1 == sum2) {
        same = i + 1;
      }
    }

    System.out.println(same);
  }
}
