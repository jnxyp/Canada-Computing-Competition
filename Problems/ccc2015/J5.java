package ccc2015;

import java.util.Scanner;;

/**
 * <p>
 * This is a practice of CCC problems, 2015 Junior. <br />
 * <br />
 * <a href=
 * "http://cemc.uwaterloo.ca/contests/computing/2015/stage%201/juniorEn.pdf">Link
 * to the problem description</a>
 * </p>
 * 
 * @author Xin <a href= "http://blog.jnxyp.tk/">(Jn_xyp)</a>
 * @version 2017-02-13
 */
public class J5 {
  static int numOfWays = 0;

  // static ArrayList<Integer> routeTracking = new ArrayList<>();
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int numOfPie = input.nextInt();
    int numOfPeople = input.nextInt();
    input.close();
    eat(1, numOfPie, numOfPeople);
    System.out.println(numOfWays);
  }

  public static void eat(int prevEat, int remainPie, int remainPeople) {
    // routeTracking.add(prevEat);
    if (remainPeople == 1) {
      if (remainPie >= prevEat) {
        numOfWays++;
        // routeTracking.add(remainPie);
        // for (Integer x : routeTracking) {
        // System.out.print("->[" + x + "]");
        // }
        // System.out.println("");
        // routeTracking.remove(routeTracking.size() - 1);
        // routeTracking.trimToSize();
      }
    }
    else {
      for (int i = prevEat; i <= remainPie / remainPeople; i++) {
        eat(i, remainPie - i, remainPeople - 1);
      }
    }
    // routeTracking.remove(routeTracking.size() - 1);
    // routeTracking.trimToSize();
  }
}