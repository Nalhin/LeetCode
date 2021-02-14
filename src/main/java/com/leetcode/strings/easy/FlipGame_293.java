package com.leetcode.strings.easy;

// You are playing the following Flip Game with your friend: Given a string that
// contains only these two characters: + and -, you and your friend take turns to f
// lip two consecutive "++" into "--". The game ends when a person can no longer ma
// ke a move and therefore the other person will be the winner.
//
// Write a function to compute all possible states of the string after one valid
// move.
//
// Example:
//
//
// Input: s = "++++"
// Output:
// [
//  "--++",
//  "+--+",
//  "++--"
// ]
//
//
// Note: If there is no valid move, return an empty list [].
// Related Topics String
// 👍 126 👎 314

import java.util.ArrayList;
import java.util.List;
/*
 O(n*m) Runtime: 4 ms, faster than 46.58% of Java online submissions for Flip Game.
 O(n) Memory Usage: 39.4 MB, less than 39.45% of Java online submissions for Flip Game.
*/
// leetcode submit region begin(Prohibit modification and deletion)
public class FlipGame_293 {
  public List<String> generatePossibleNextMoves(String s) {
    List<String> result = new ArrayList<>();
    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i - 1) == '+' && s.charAt(i) == '+') {
        result.add(s.substring(0, i - 1) + "--" + s.substring(i + 1));
      }
    }

    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
