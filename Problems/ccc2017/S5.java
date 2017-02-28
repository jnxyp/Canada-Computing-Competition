package ccc2017;

import java.util.Scanner;

public class S5 {
  static int    numOfStations;
  static int[]  stationToLine;
  static int[]  peopleInStation;
  static int[]  stationInEachLine;
  static String output = "";

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    numOfStations = input.nextInt();
    int numOflines = input.nextInt();
    int numOfOperations = input.nextInt();
    stationToLine = new int[numOfStations];
    peopleInStation = new int[numOfStations];
    stationInEachLine = new int[numOflines];
    for (int i = 0; i < stationToLine.length; i++) {
      stationToLine[i] = input.nextInt();
      stationInEachLine[stationToLine[i] - 1]++;
    }
    for (int i = 0; i < peopleInStation.length; i++) {
      peopleInStation[i] = input.nextInt();
    }
    for (int i = 0; i < numOfOperations; i++) {
      if (input.nextInt() == 1) {
        survey(input.nextInt(), input.nextInt());
      }
      else {
        operateTrain(input.nextInt());
      }
    }

    System.out.println(output);
  }

  public static void survey(int start, int end) {
    int sum = 0;
    for (int i = start - 1; i < end; i++) {
      sum += peopleInStation[i];
    }
    output += sum + "\n";
  }

  public static void operateTrain(int line) {
    int prevStation = 0, firstStation = 0, stationCount = 0;
    for (int i = 0; i < numOfStations; i++) {
      if (stationToLine[i] == line) {
        if (stationCount == 0) {
          firstStation = i;
          prevStation = i;
          stationCount++;
        }
        else if (stationCount == stationInEachLine[line - 1] - 1) {
          swich(firstStation, i);
          break;
        }
        else {
          swich(prevStation, i);
          prevStation = i;
          stationCount++;
        }
      }
    }
  }

  public static void swich(int from, int to) {
    int temp = peopleInStation[from];
    peopleInStation[from] = peopleInStation[to];
    peopleInStation[to] = temp;
  }
}
