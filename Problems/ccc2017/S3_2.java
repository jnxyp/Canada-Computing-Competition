package ccc2017;

import java.util.Scanner;

public class S3_2 {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int numOfPieces = input.nextInt();
    int[] pieces = new int[numOfPieces];
    for (int i = 0; i < pieces.length; i++) {
      pieces[i] = input.nextInt();
    }
    int[] lengths = new int[4001];
    for (int i = 0; i < pieces.length; i++) {
      for (int j = i + 1; j < pieces.length; j++) {
        lengths[pieces[i] + pieces[j]]++;
      }
    }
    int maxWidth = 0;
    for (int width : lengths) {
      if (width > maxWidth) {
        maxWidth = width;
      }
    }
    int count = 0;
    for (int width : lengths) {
      if (maxWidth == width) {
        count++;
      }
    }

    System.out.println(maxWidth + " " + count);
  }

}