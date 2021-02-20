package com.leetcode.math.medium;

// On an infinite plane, a robot initially stands at (0, 0) and faces north. The
// robot can receive one of three instructions:
//
//
// "G": go straight 1 unit;
// "L": turn 90 degrees to the left;
// "R": turn 90 degrees to the right.
//
//
// The robot performs the instructions given in order, and repeats them forever.
//
//
// Return true if and only if there exists a circle in the plane such that the r
// obot never leaves the circle.
//
//
// Example 1:
//
//
// Input: instructions = "GGLLGG"
// Output: true
// Explanation: The robot moves from (0,0) to (0,2), turns 180 degrees, and then
// returns to (0,0).
// When repeating these instructions, the robot remains in the circle of radius 2
// centered at the origin.
//
// Example 2:
//
//
// Input: instructions = "GG"
// Output: false
// Explanation: The robot moves north indefinitely.
//
// Example 3:
//
//
// Input: instructions = "GL"
// Output: true
// Explanation: The robot moves from (0, 0) -> (0, 1) -> (-1, 1) -> (-1, 0) -> (0
// , 0) -> ...
//
//
// Constraints:
//
//
// 1 <= instructions.length <= 100
// instructions[i] is 'G', 'L' or, 'R'.
//
// Related Topics Math
// 👍 826 👎 251

// leetcode submit region begin(Prohibit modification and deletion)

public class RobotBoundedInCircle_1041 {
  private final int[][] DIRECTIONS = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

  public boolean isRobotBounded(String instructions) {
    int initialX = 0;
    int initialY = 0;
    int initialDir = 0;

    int currX = initialX;
    int currY = initialY;
    int currDir = initialDir;

    for (int i = 0; i < instructions.length(); i++) {
      int c = instructions.charAt(i);

      if (c == 'L') {
        currDir = currDir == 0 ? DIRECTIONS.length - 1 : currDir - 1;
      } else if (c == 'R') {
        currDir = (currDir + 1) % DIRECTIONS.length;
      } else {
        currX += DIRECTIONS[currDir][0];
        currY += DIRECTIONS[currDir][1];
      }
    }

    return (currX == initialX && currY == initialY) || currDir != initialDir;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
