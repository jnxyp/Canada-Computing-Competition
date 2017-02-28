package ccc2016;

import java.util.Scanner;

/**
 * My site: <a href="https://blog.jnxyp.tk/">Water Pool</a>
 * 
 * @author Xin (Jn_xyp)
 * @version Unavailable
 */
public class J3 {
  public static void main(String[] args) {
    // declare variables
    Scanner cary = new java.util.Scanner(System.in);
    String input, temp;
    int length = 0;
    String[] odds;
    // get input
    // System.out.println ("Enter something:");
    input = cary.next();
    cary.close();
    // find out all possibilities
    odds = new String[input.length()];
    for (int start = 0; start < input.length(); start++) {
      for (int end = start + 1; end <= input.length(); end++) {
        odds[start] = input.substring(start, end);
        temp = "";
        for (int i = odds[start].length() - 1; i >= 0; i--) {
          temp += odds[start].charAt(i);
        }
        if (temp.equals(odds[start])) {
          if (length < temp.length()) {
            length = temp.length();
          }
        }
      }
    }
    // output
    System.out.println(length);
  }
}
