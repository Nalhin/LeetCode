package com.leetcode.strings.easy;
/*
 O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Goal Parser Interpretation.
 O(n) Memory Usage: 37.5 MB, less than 62.73% of Java online submissions for Goal Parser Interpretation.
*/
public class GoalParserImplementation_1678 {
  public String interpret(String command) {
    StringBuilder sb = new StringBuilder();

    char prev = command.charAt(0);

    if (prev == 'G') {
      sb.append('G');
    }

    for (int i = 1; i < command.length(); i++) {
      if (prev == '(' && command.charAt(i) == ')') {
        sb.append('o');
      } else if (prev == 'l' && command.charAt(i) == ')') {
        sb.append("al");
      } else if (command.charAt(i) == 'G') {
        sb.append('G');
      }
      prev = command.charAt(i);
    }

    return sb.toString();
  }
}
