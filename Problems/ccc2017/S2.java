package ccc2017;

import java.util.Arrays;
import java.util.Scanner;

public class S2 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int count = input.nextInt();
    int[] tides = new int[count];
    for (int i = 0; i < tides.length; i++) {
      tides[i] = input.nextInt();
    }
    Arrays.sort(tides);
    int[] high, low;
    high = new int[tides.length / 2];
    low = new int[tides.length - high.length];
    for (int i = 0; i < low.length; i++) {
      low[i] = tides[i];
    }
    for (int i = 0; i < high.length; i++) {
      high[i] = tides[low.length + i];
    }

    boolean isLow = true;
    int lowIndex = low.length - 1, highIndex = 0;
    for (int i = 0; i < tides.length; i++) {
      if (isLow) {
        System.out.print(low[lowIndex] + " ");
        lowIndex--;
        isLow = false;
      }
      else {
        System.out.print(high[highIndex] + " ");
        highIndex++;
        isLow = true;
      }
    }
  }
}
