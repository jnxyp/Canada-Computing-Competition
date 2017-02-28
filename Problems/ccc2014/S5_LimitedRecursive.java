package ccc2014;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 * @author Xin (Jn_xyp)
 * @version 2017-01-22
 * 
 *          This is a practice of CCC problems, 2014 Senior. Limited Recursive
 *          Version, change SEARCH_BREADTH_LIMIT to change the maximum branches
 *          from each position.
 */
public class S5_LimitedRecursive {

  static int[][]            pos;                                      // Store
                                                                      // the
                                                                      // coordinates
                                                                      // of each
                                                                      // point
  static int                max                  = 0;                 // Max
                                                                      // length
                                                                      // of
                                                                      // route
  static Integer[]          longestRoute         = new Integer[0];
  static ArrayList<Integer> route                = new ArrayList<>(); // Store
                                                                      // the
                                                                      // route
                                                                      // of
                                                                      // moving
  static boolean            DEBUG_OUTPUT         = true;
  static int                SEARCH_BREADTH_LIMIT = 2;

  // Make a comparator to sort the values in the Map
  static Comparator<Map.Entry<Integer, Integer>> comparator = new Comparator<Map.Entry<Integer, Integer>>() {
    @Override
    public int compare(Entry<Integer, Integer> e1, Entry<Integer, Integer> e2) {
      if (e1.getValue() > e2.getValue()) {
        return -1;
      }
      else if (e1.getValue() < e2.getValue()) {
        return 1;
      }
      else {
        return 0;
      }
    }
  };

  public static void main(String[] args) {
    Scanner cary = new Scanner(System.in);
    int amountOfPos, currentPos = 0;
    final int ORIGIN_X = 0, ORIGIN_Y = 0; // Set origin
    final int X_LIMIT = 10000, Y_LIMIT = 10000;
    // Get user input
    amountOfPos = cary.nextInt();
    if (SEARCH_BREADTH_LIMIT == 0) {
      SEARCH_BREADTH_LIMIT = amountOfPos;
    }
    // Initialize arrays
    pos = new int[amountOfPos + 1][2]; // First one is x-coordinate, second is
                                       // y-coordinate
    // Put origin into array
    pos[0][0] = ORIGIN_X;
    pos[0][1] = ORIGIN_Y;
    // Get coordinates
    for (int i = 1; i < pos.length; i++) {
      pos[i][0] = cary.nextInt();
      pos[i][1] = cary.nextInt();
    }
    cary.close();
    // Start moving
    checkLinesFrom(currentPos, X_LIMIT * X_LIMIT + Y_LIMIT * Y_LIMIT + 1);
    // Print result
    System.out.println(max);
    // DEBUG
    System.out.println(Arrays.toString(longestRoute));
  }

  public static void checkLinesFrom(int currentPos, int limit) {
    route.add(currentPos); // Add record to route
    // Calculate the length from current point to each point
    Map<Integer, Integer> lines = new HashMap<>();
    lines = computeLength(currentPos);
    lines = removeInvalid(lines, limit);
    // If this is the end of path, record the length and route
    if (lines.isEmpty()) {
      if (DEBUG_OUTPUT) {
        for (Integer x : route) {
          System.out.print("->[" + x + "](" + pos[x][0] + "," + pos[x][1] + ")");
        }
        System.out.println("||");
      }
      if (route.size() > max) {
        max = route.size() - 1;
        longestRoute = route.toArray(new Integer[max]);
      }
    }
    else { // Else, continue search each branch
      // Sort the values in the Map
      List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(lines.entrySet());
      Collections.sort(list, comparator);
      Iterator<Map.Entry<Integer, Integer>> iterator = list.iterator();
      for (int i = 0; i < SEARCH_BREADTH_LIMIT; i++) {
        if (iterator.hasNext()) {
          currentPos = iterator.next().getKey();
          limit = lines.get(currentPos);
          checkLinesFrom(currentPos, limit); // Moving Recursion
        }
      }
    }
    route.remove(route.size() - 1);
    route.trimToSize();
  }

  public static Map<Integer, Integer> computeLength(int currentPos) {
    Map<Integer, Integer> lines = new HashMap<>();
    int diffX, diffY;
    for (int i = 1; i < pos.length; i++) {
      if (i != currentPos) {
        diffX = pos[i][0] - pos[currentPos][0];
        diffY = pos[i][1] - pos[currentPos][1];
        lines.put(i, diffX * diffX + diffY * diffY);
      }
    }
    return lines;
  }

  public static Map<Integer, Integer> removeInvalid(Map<Integer, Integer> lines, int limit) {
    Iterator<Map.Entry<Integer, Integer>> iterator = lines.entrySet().iterator();
    while (iterator.hasNext()) {
      if (iterator.next().getValue() >= limit) {
        iterator.remove();
      }
    }
    return lines;
  }
}