package ccc2014;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import javax.swing.JFrame;

/**
 * @author Xin (Jn_xyp)
 * @version 2017-01-22 This Version CANNOT ensure the answer is correct! This is
 *          a practice of CCC problems, 2014 Senior. Limited Recursive Version,
 *          change SEARCH_BREADTH_LIMIT to change the maximum branches from each
 *          position.
 */
public class S5_GUI {

  static Integer[][]        pos;                              // Store the
                                                              // coordinates of
                                                              // each point
  static int                max          = 0;                 // Max length of
                                                              // route
  static Integer[]          longestRoute = new Integer[0];
  static ArrayList<Integer> route        = new ArrayList<>(); // Store the route
                                                              // of
                                                              // moving
  static GUI                gui;

  static boolean DEBUG_OUTPUT         = true;
  static boolean AUTO_GENERATE        = true; // if auto generate positions
  static int     SEARCH_BREADTH_LIMIT = 2;    // 0 means no limit

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
    boolean inputInvalid;
    final int ORIGIN_X = 0, ORIGIN_Y = 0; // Set origin
    final int X_LIMIT = 300, Y_LIMIT = 300;
    gui = new GUI("S5 Graphic Interface", X_LIMIT * 2, Y_LIMIT * 2);
    // Get user input
    amountOfPos = cary.nextInt();
    if (SEARCH_BREADTH_LIMIT == 0) {
      SEARCH_BREADTH_LIMIT = amountOfPos;
    }
    // Initialize arrays
    pos = new Integer[amountOfPos + 1][2]; // First one is x-coordinate, second
                                           // is
    // y-coordinate
    // Put origin into array
    pos[0][0] = ORIGIN_X;
    pos[0][1] = ORIGIN_Y;
    gui.addPosition(pos[0]);
    // Get coordinates
    if (AUTO_GENERATE) {
      for (int i = 1; i < pos.length; i++) {
        pos[i][0] = (int) (Math.random() * X_LIMIT * 2 - X_LIMIT);
        pos[i][1] = (int) (Math.random() * Y_LIMIT * 2 - Y_LIMIT);
        if (DEBUG_OUTPUT) {
          System.out.println("[" + i + "](" + pos[i][0] + "," + pos[i][1] + ")");
        }
      }
    }
    else {
      for (int i = 1; i < pos.length; i++) {
        do {
          inputInvalid = false;
          pos[i][0] = cary.nextInt();
          if (pos[i][0] > X_LIMIT || pos[i][0] < X_LIMIT * -1) {
            inputInvalid = true;
            System.out.println("Out of range");
          }
        } while (inputInvalid);
        do {
          inputInvalid = false;
          pos[i][1] = cary.nextInt();
          if (pos[i][1] > Y_LIMIT || pos[i][1] < Y_LIMIT * -1) {
            inputInvalid = true;
            System.out.println("Out of range");
          }
        } while (inputInvalid);
      }
    }
    cary.close();
    // Draw all the points
    for (int i = 1; i < pos.length; i++) {
      gui.addPosition(pos[i]);
    }
    // Start moving
    checkLinesFrom(currentPos, X_LIMIT * X_LIMIT + Y_LIMIT * Y_LIMIT + 1);
    // Print result
    System.out.println(max);
    // DEBUG
    if (DEBUG_OUTPUT) {
      for (Integer x : longestRoute) {
        System.out.print("->[" + x + "](" + pos[x][0] + "," + pos[x][1] + ")");
      }
    }
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
      // Expand the branches
      int nextPos;
      for (int i = 0; i < SEARCH_BREADTH_LIMIT; i++) {
        if (iterator.hasNext()) {
          nextPos = iterator.next().getKey();
          gui.addLine(pos[currentPos], pos[nextPos]);
          currentPos = nextPos;
          limit = lines.get(currentPos);
          checkLinesFrom(currentPos, limit); // Moving Recursion
        }
      }
    }
    // Delete last position in the route when return to the superior position
    route.remove(route.size() - 1);
    route.trimToSize(); // Remove null elements
  }

  /**
   * This method can calculate the length from current point to all other points
   * 
   * @param currentPos
   *          Current point
   * @return Map<pos#, length>
   */
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

  /**
   * This method can remove any lines that are longer or equals to the limit
   * value
   * 
   * @param lines
   *          The Map that contains lines and their lengths
   * @param limit
   *          The maximum length of lines
   * @return The Map that contains valid lines and their lengths
   */
  public static Map<Integer, Integer> removeInvalid(Map<Integer, Integer> lines, int limit) {
    Iterator<Map.Entry<Integer, Integer>> iterator = lines.entrySet().iterator();
    Integer length;
    while (iterator.hasNext()) {
      length = iterator.next().getValue();
      if (length >= limit || length == 0) {
        iterator.remove();
      }
    }
    return lines;
  }
}

class GUI extends JFrame {
  private static final long serialVersionUID = 1L;
  static Color              LINES            = new Color(255, 0, 0, 10); // Change
                                                                         // the
                                                                         // last
                                                                         // value
                                                                         // to
                                                                         // change
                                                                         // the
                                                                         // concentration
  static Color              POINTS           = new Color(0, 0, 255);

  Integer[] currentPosition = { 0, 0 };
  Integer[] currentLine     = { 0, 0, 0, 0 };

  public GUI(String title, int width, int height) {
    super(title);
    this.setSize(width, height);
    this.setResizable(false);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setAlwaysOnTop(true);
    this.setVisible(true);
  }

  @Override
  public synchronized void update(Graphics g) {
    Graphics2D g2d = (Graphics2D) g;
    // Draw points
    g2d.setColor(POINTS);
    drawPoint(g2d, currentPosition[0] + this.getWidth() / 2, currentPosition[1] + this.getHeight() / 2, 3);
    // Draw lines
    g2d.setColor(LINES);
    g2d.drawLine(currentLine[0] + this.getWidth() / 2, currentLine[1] + this.getHeight() / 2,
        currentLine[2] + this.getWidth() / 2, currentLine[3] + this.getHeight() / 2);
  }

  public void drawPoint(Graphics2D g2d, int x, int y, int r) {
    g2d.fillOval(x - r, y - r, 2 * r, 2 * r);
  }

  public void addPosition(Integer[] coordinate) {
    this.currentPosition = coordinate;
    this.update(this.getGraphics());
  }

  public synchronized void addLine(Integer[] from, Integer[] to) {
    this.currentLine[0] = from[0];
    this.currentLine[1] = from[1];
    this.currentLine[2] = to[0];
    this.currentLine[3] = to[1];
    this.update(this.getGraphics());
  }

}