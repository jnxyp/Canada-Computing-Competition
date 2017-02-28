package ccc2017;

import java.util.Arrays;
import java.util.Scanner;

public class J5 {
  static int[] piecesLength, reducedLength, reducedFrequency, combinedLengthFrequency;

  public static void main(String[] args) {
    final int PIECE_LENGTH_LIMIT = 2000;
    Scanner input = new Scanner(System.in);
    int numOfPieces = input.nextInt();
    piecesLength = new int[numOfPieces];
    reducedFrequency = new int[PIECE_LENGTH_LIMIT + 1];
    combinedLengthFrequency = new int[PIECE_LENGTH_LIMIT * 2 + 1];
    for (int i = 0; i < piecesLength.length; i++) {
      piecesLength[i] = input.nextInt();
    }
    reduceLength();
    for (int piece1 = 0; piece1 < reducedLength.length; piece1++) {
      for (int piece2 = piece1 + 1; piece2 < reducedLength.length; piece2++) {
        combinedLengthFrequency[reducedLength[piece1] + reducedLength[piece2]] += Math
            .min(reducedFrequency[reducedLength[piece1]], reducedFrequency[reducedLength[piece2]]);
      }
    }
    int maxWidth = 0;
    for (int width : combinedLengthFrequency) {
      if (maxWidth < width) {
        maxWidth = width;
      }
    }
    int maxCount = 0;
    for (int width : combinedLengthFrequency) {
      if (maxWidth == width) {
        maxCount++;
      }
    }
    System.out.println(maxWidth + " " + maxCount);
  }

  private static void reduceLength() {
    Arrays.sort(piecesLength);
    int elementCount = 0;
    int currentElement = 0;
    for (int length : piecesLength) {
      reducedFrequency[length]++;
      if (length != currentElement) {
        elementCount++;
        currentElement = length;
      }
    }
    reducedLength = new int[elementCount];
    int index = 0;
    for (int i = 0; i < reducedFrequency.length; i++) {
      if (reducedFrequency[i] != 0) {
        reducedLength[index] = i;
        index++;
      }
    }
  }

}