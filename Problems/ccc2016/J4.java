package ccc2016;

import java.util.Scanner;

/**
 * My site: <a href="https://blog.jnxyp.tk/">Water Pool</a>
 * 
 * @author Xin (Jn_xyp)
 * @version Unavailable
 */
public class J4 {
  public static void main(String[] args) {
    // declare variables
    Scanner cary = new java.util.Scanner(System.in);
    int DISTANCE = 120;
    int depTime, arriveTime, remainTime;
    // get input
    depTime = toNumber(cary.nextLine());
    cary.close();
    // calculate
    // rush-hour traffic: 420 - 600 900 - 1140
    if (depTime < 420) {
      remainTime = DISTANCE - (420 - depTime);
      if (remainTime <= 0) {
        arriveTime = depTime + DISTANCE;
      }
      else {
        if (remainTime * 2 <= 600 - 420) {
          arriveTime = 420 + remainTime * 2;
        }
        else {
          remainTime = remainTime - (600 - 420) / 2;
          arriveTime = 600 + remainTime;
        }
      }
    }
    else if (depTime < 600) {
      remainTime = DISTANCE - (600 - depTime) / 2;
      arriveTime = 600 + remainTime;
    }
    else if (depTime < 900) {
      remainTime = DISTANCE - (900 - depTime);
      if (remainTime <= 0) {
        arriveTime = depTime + DISTANCE;
      }
      else {
        arriveTime = 900 + remainTime * 2;
      }
    }
    else if (depTime < 1140) {
      remainTime = DISTANCE - (1140 - depTime) / 2;
      if (remainTime <= 0) {
        arriveTime = depTime + DISTANCE * 2;
      }
      else {
        arriveTime = 1140 + remainTime;
      }
    }
    else {
      arriveTime = depTime + DISTANCE;
    }
    // output
    System.out.println(toHour(arriveTime));
  }

  public static String toHour(int time) {
    int hour = time / 60;
    if (hour >= 24) {
      hour -= 24;
    }
    return String.format("%02d%s%02d", hour, ":", (time % 60));
  }

  public static int toNumber(String time) {
    int number = Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3));
    if (number >= 60 * 24) {
      number -= 60 * 24;
    }
    return number;
  }
}
