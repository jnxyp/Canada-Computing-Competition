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
 * @author Xin (Jn_xyp)
 * @version 2017-02-12
 * 
 */

public class J4 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int numOfLines;
    int time = 0;
    boolean[] isPerson = new boolean[100];
    int[] receiveTime = new int[100];
    int[] waitingTime = new int[100];
    boolean[] noReply = new boolean[100];

    String[] inputTemp;
    char type;
    int value;

    numOfLines = input.nextInt();
    input.nextLine();

    for (int i = 0; i < numOfLines; i++) {
      inputTemp = input.nextLine().split(" ");
      type = inputTemp[0].charAt(0);
      value = Integer.parseInt(inputTemp[1]);

      if (type == 'R') {
        isPerson[value] = true;
        noReply[value] = true;
        receiveTime[value] = time;
        time++;
      }
      else if (type == 'S') {
        noReply[value] = false;
        waitingTime[value] += time - receiveTime[value];
        time++;
      }
      else if (type == 'W') {
        time = time + value - 1;
      }
    }

    input.close();

    for (int i = 0; i < 100; i++) {
      if (isPerson[i]) {
        if (noReply[i]) {
          System.out.println(i + " -1");
        }
        else {
          System.out.println(i + " " + waitingTime[i]);
        }
      }
    }
  }
}
