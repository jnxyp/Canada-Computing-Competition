package ccc2014;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author Xin (Jn_xyp)
 * @version 2017-01-18
 * 
 *          This is a practice of CCC problems, 2014 Senior. This version CAN
 *          NOT ensure to give the best answer.
 */
public class S5_LongestLine {
  /**
   * How this works: [1] Get the user input, include the amount of positions and
   * coordinates of them [2] Store the coordinates in a 2D array, the first
   * coordinate of array is origin point (0,0) [3] Calculate the length (sum of
   * the square of horizontal and vertical distance) from current point to each
   * of the points [4] Store them in an HashMap, and remove any line that longer
   * or equals to the previous line [5] Find out the longest one in the rest of
   * lines, set the target of this line as the current point, the length of this
   * line as the prevLength [6] Repeat from step 3 until there's no lines in the
   * HashMap after step 4
   */
  // Store the lines to each point in this turn;
  static HashMap<Integer, Integer> lines = new HashMap<>();
  // Store the coordinates of each position, last one is origin;
  static int[][] pos;
  static int     posCount, currentPos, prevLength, treatCount = 0;

  public static void main(String[] args) {
    Scanner cary = new Scanner(System.in);
    // Get user input
    posCount = cary.nextInt() + 1; // first one for origin
    cary.nextLine();
    pos = new int[posCount][2];
    for (int i = 1; i < posCount; i++) {
      pos[i][0] = cary.nextInt();
      pos[i][1] = cary.nextInt();
    }
    cary.close();
    // set origin
    pos[0][0] = 0;
    pos[0][1] = 0;
    currentPos = 0;
    // Start moving
    do {
      computeLength();
      if (currentPos != 0) {
        removeInvalid();
      }
      if (lines.isEmpty()) {
        break;
      }
      selectNext();
      treatCount++;
      // DEBUG
      System.out.print("¡ú[" + currentPos + "](" + pos[currentPos][0] + "," + pos[currentPos][1] + ")");
    } while (true);
    System.out.println("\n" + treatCount);
  }

  /**
   * Calculate the length from current point to any other point, will clear the
   * HashMap at first
   */
  public static void computeLength() {
    lines.clear(); // Clear the map
    int temp1, temp2;
    for (int i = 1; i < posCount; i++) {
      if (i != currentPos) {
        temp1 = pos[currentPos][0] - pos[i][0];
        temp2 = pos[currentPos][1] - pos[i][1];
        lines.put(i, (temp1 * temp1) + (temp2 * temp2));
      }
    }
  }

  /**
   * Remove any lines that longer or equals to previous one
   */
  public static void removeInvalid() {
    Iterator<HashMap.Entry<Integer, Integer>> it = lines.entrySet().iterator();
    while (it.hasNext()) {
      if (it.next().getValue() >= prevLength) {
        it.remove();
      }
    }
  }

  /**
   * Find out the longest line in the map, and set the length of line as the
   * prevLength, the target of line as the currentPos
   */
  public static void selectNext() {
    prevLength = 0;
    for (Integer key : lines.keySet()) {
      if (prevLength < lines.get(key)) {
        prevLength = lines.get(key);
        currentPos = key;
      }
    }
  }
}
