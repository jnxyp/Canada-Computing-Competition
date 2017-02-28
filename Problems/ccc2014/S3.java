package ccc2014;

import java.util.Scanner;

/**
 * @author Xin (Jn_xyp)
 * @version 2017-01-13 This is a practice of CCC problems, 2014 Senior
 */

public class S3 {
  public static void main(String[] args) {
    Scanner cary = new Scanner(System.in);
    int[] cars;
    int round, numOfCars;
    boolean[] results;
    // get the amount of total round
    round = cary.nextInt();
    cary.nextLine();
    results = new boolean[round];
    for (int i = 0; i < results.length; i++) {
      results[i] = true;
    }
    // one round loop
    for (int i = 0; i < round; i++) {
      // get the amount of cars
      numOfCars = cary.nextInt();
      cary.nextLine();
      cars = new int[numOfCars];
      // get the input of cars
      for (int j = numOfCars - 1; j >= 0; j--) {
        cars[j] = cary.nextInt();
        cary.nextLine();
      }
      // Check if its possible
      for (int j = 0; j < numOfCars; j++) {
        if (cars[j] != maxOf(cars) && cars[j] != minOf(cars)) {
          results[i] = false;
          break;
        }
        else {
          cars[j] = -1;
        }
      }
    }
    cary.close();
    // print results
    for (boolean x : results) {
      if (x) {
        System.out.println("Y");
      }
      else {
        System.out.println("N");
      }
    }
  }

  // Find the max and min value of an array, bot include negative number
  public static int maxOf(int[] in) {
    int m = 0;
    for (int i = 0; i < in.length; i++) {
      if (m < in[i] && in[i] > 0) {
        m = in[i];
      }
    }
    return m;
  }

  public static int minOf(int[] in) {
    int m = 101;
    for (int i = 0; i < in.length; i++) {
      if (m > in[i] && in[i] > 0) {
        m = in[i];
      }
    }
    return m;
  }

}