package com.leetcode.strings.easy;

// There is a robot starting at position (0, 0), the origin, on a 2D plane. Given
// a sequence of its moves, judge if this robot ends up at (0, 0) after it complet
// es its moves.
//
// The move sequence is represented by a string, and the character moves[i] repr
// esents its ith move. Valid moves are R (right), L (left), U (up), and D (down).
// If the robot returns to the origin after it finishes all of its moves, return tr
// ue. Otherwise, return false.
//
// Note: The way that the robot is "facing" is irrelevant. "R" will always make
// the robot move to the right once, "L" will always make it move left, etc. Also,
// assume that the magnitude of the robot's movement is the same for each move.
//
//
// Example 1:
//
//
// Input: moves = "UD"
// Output: true
// Explanation: The robot moves up once, and then down once. All moves have the s
// ame magnitude, so it ended up at the origin where it started. Therefore, we retu
// rn true.
//
//
// Example 2:
//
//
// Input: moves = "LL"
// Output: false
// Explanation: The robot moves left twice. It ends up two "moves" to the left of
// the origin. We return false because it is not at the origin at the end of its m
// oves.
//
//
// Example 3:
//
//
// Input: moves = "RRDD"
// Output: false
//
//
// Example 4:
//
//
// Input: moves = "LDRRLRUULR"
// Output: false
//
//
//
// Constraints:
//
//
// 1 <= moves.length <= 2 * 104
// moves only contains the characters 'U', 'D', 'L' and 'R'.
//
// Related Topics String
// 👍 1149 👎 682

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(n) Runtime: 5 ms, faster than 53.57% of Java online submissions for Robot Return to Origin.
 O(1) Memory Usage: 39.3 MB, less than 31.35% of Java online submissions for Robot Return to Origin.
*/
public class RobotReturnToOrigin_657 {

  public boolean judgeCircle(String moves) {
    int x = 0;
    int y = 0;

    for (int i = 0; i < moves.length(); i++) {
      char dir = moves.charAt(i);
      if (dir == 'L') {
        x--;
      } else if (dir == 'R') {
        x++;
      } else if (dir == 'U') {
        y++;
      } else if (dir == 'D') {
        y--;
      }
    }

    return y == 0 && x == 0;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
