package ccc2014;

import java.util.Scanner;

/**
 * @author Xin (Jn_xyp)
 * @version 2017-01-11 This is a practice of CCC problems, 2014 Junior A program
 *          to judgment the type of triangle
 */

public class J1 {
  public static void main(String[] args) {
    Scanner cary = new Scanner(System.in);
    int angleA, angleB, angleC, sum;
    angleA = cary.nextInt();
    angleB = cary.nextInt();
    angleC = cary.nextInt();
    cary.close();
    sum = angleA + angleB + angleC;
    if (sum != 180) {
      System.out.println("Error");
    }
    else {
      if (angleA == angleB || angleB == angleC || angleC == angleA) {
        if (angleA == angleB && angleB == angleC) {
          System.out.println("Equilateral");
        }
        else {
          System.out.println("Isosceles");
        }
      }
      else {
        System.out.println("Scalene");
      }
    }
  }
}