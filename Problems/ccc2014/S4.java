package ccc2014;

import java.util.Scanner;

/**
 * @author Xin (Jn_xyp)
 * @version 2017-01-13 This is a practice of CCC problems, 2014 Senior
 */

public class S4 {
  public static void main(String[] args) {
    Scanner cary = new Scanner(System.in);
    String[] temp;
    int[][] grid, pieces;
    int amountOfPieces, t_factor;
    int x_max = 0, y_max = 0;
    int area = 0;

    // get the amount of glass pieces and the tint-factor that are looking for
    amountOfPieces = cary.nextInt();
    cary.nextLine();
    t_factor = cary.nextInt();
    cary.nextLine();
    // initialize the array to store the data of each piece (x-start, y-start,
    // x-end, y-end, t-factor)
    pieces = new int[amountOfPieces][5];
    // get the coordinate and t-factor of each piece
    for (int i = 0; i < amountOfPieces; i++) {
      temp = cary.nextLine().split(" ");
      for (int j = 0; j < pieces[0].length; j++) {
        pieces[i][j] = Integer.parseInt(temp[j]);
      }
      if (pieces[i][2] > x_max) {
        x_max = pieces[i][2];
      }
      if (pieces[i][3] > y_max) {
        y_max = pieces[i][3];
      }
    }
    cary.close();
    // initialize the array to store the t-factor in each area
    grid = new int[y_max][x_max];
    for (int y = 0; y < y_max; y++) {
      for (int x = 0; x < x_max; x++) {
        grid[y][x] = 0;
      }
    }
    // add the t-factor of each piece to each area
    for (int i = 0; i < amountOfPieces; i++) {
      for (int y = pieces[i][1]; y < pieces[i][3]; y++) {
        for (int x = pieces[i][0]; x < pieces[i][2]; x++) {
          grid[y][x] += pieces[i][4];
        }
      }
    }
    // find out the area that match the condition
    for (int[] y : grid) {
      for (int x : y) {
        if (x >= t_factor) {
          area++;
        }
      }
    }
    // output
    System.out.println(area);
  }
}