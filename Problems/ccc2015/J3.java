package ccc2015;

import java.util.Scanner;

/**
 * <p>
 * This is a practice of CCC problems, 2015 Junior. <br />
 * <br />
 * <a href=
 * "http://cemc.uwaterloo.ca/contests/computing/2015/stage%201/juniorEn.pdf">Link
 * to the problem description</a><br/>
 * </p>
 * <p>
 * <b>Vowel Groups: </b><br/>
 * [a]b c|d[e]f g|h[i]j k l|m n[o]p q r|s t[u]v w x y z <br/>
 * </p>
 * 
 * @author Xin (<a href="http://blog.jnxyp.tk">Jn_xyp</a>)
 * @version 2017-02-18
 * 
 */
public class J3 {
  public static void main(String[] args) {
    Scanner cary = new Scanner(System.in);
    String input = cary.nextLine();
    cary.close();

    String output = "";
    char c;

    for (int i = 0; i < input.length(); i++) {
      c = input.charAt(i);
      if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
        output += c;
      }
      else {
        output += c;
        if (c <= 'c') {
          output += 'a';
        }
        else if (c <= 'g') {
          output += 'e';
        }
        else if (c <= 'l') {
          output += 'i';
        }
        else if (c <= 'r') {
          output += 'o';
        }
        else {
          output += 'u';
        }
        if (c == 'z') {
          output += c;
        }
        else {
          if ((c + 1) == 'a' || (c + 1) == 'e' || (c + 1) == 'i' || (c + 1) == 'o' || (c + 1) == 'u') {
            output += (char) (c + 2);
          }
          else {
            output += (char) (c + 1);
          }
        }
      }
    }
    System.out.println(output);
  }
}
