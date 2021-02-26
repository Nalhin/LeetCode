package com.leetcode.hashtable.easy;

// A robot on an infinite XY-plane starts at point (0, 0) and faces north. The ro
// bot can receive one of three possible types of commands:
//
//
// -2: turn left 90 degrees,
// -1: turn right 90 degrees, or
// 1 <= k <= 9: move forward k units.
//
//
// Some of the grid squares are obstacles. The ith obstacle is at grid point obs
// tacles[i] = (xi, yi).
//
// If the robot would try to move onto them, the robot stays on the previous gri
// d square instead (but still continues following the rest of the route.)
//
// Return the maximum Euclidean distance that the robot will be from the origin
// squared (i.e. if the distance is 5, return 25).
//
// Note:
//
//
// North means +Y direction.
// East means +X direction.
// South means -Y direction.
// West means -X direction.
//
//
//
// Example 1:
//
//
// Input: commands = [4,-1,3], obstacles = []
// Output: 25
// Explanation: The robot starts at (0, 0):
// 1. Move north 4 units to (0, 4).
// 2. Turn right.
// 3. Move east 3 units to (3, 4).
// The furthest point away from the origin is (3, 4), which is 32 + 42 = 25 units
// away.
//
//
// Example 2:
//
//
// Input: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
// Output: 65
// Explanation: The robot starts at (0, 0):
// 1. Move north 4 units to (0, 4).
// 2. Turn right.
// 3. Move east 1 unit and get blocked by the obstacle at (2, 4), robot is at (1,
// 4).
// 4. Turn left.
// 5. Move north 4 units to (1, 8).
// The furthest point away from the origin is (1, 8), which is 12 + 82 = 65 units
// away.
//
//
//
// Constraints:
//
//
// 1 <= commands.length <= 104
// commands[i] is one of the values in the list [-2,-1,1,2,3,4,5,6,7,8,9].
// 0 <= obstacles.length <= 104
// -3 * 104 <= xi, yi <= 3 * 104
// The answer is guaranteed to be less than 231.
//
// Related Topics Greedy
// 👍 225 👎 942

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashSet;
import java.util.Set;

public class WalkingRobotSimulation_874 {
  private static final int MAX_SIZE = 30000;
  private static final int[][] DIRECTIONS = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

  public int robotSim(int[] commands, int[][] obstacles) {

    Set<Integer> obstacleSet = new HashSet<>();
    for (int[] obstacle : obstacles) {
      obstacleSet.add(encodePosition(obstacle[0], obstacle[1]));
    }

    int currX = 0;
    int currY = 0;
    int currPosition = 0;
    int maxDist = 0;

    for (int command : commands) {
      if (command == -1) {
        currPosition = (currPosition + 1) % DIRECTIONS.length;
      } else if (command == -2) {
        currPosition = currPosition - 1 < 0 ? DIRECTIONS.length - 1 : currPosition - 1;
      } else {
        for (int i = 1; i <= command; i++) {
          int nextX = currX + DIRECTIONS[currPosition][0];
          int nextY = currY + DIRECTIONS[currPosition][1];

          if (obstacleSet.contains(encodePosition(nextX, nextY))) {
            break;
          }

          currX = nextX;
          currY = nextY;
          maxDist = Math.max(getDist(currX, currY), maxDist);
        }
      }
    }

    return maxDist;
  }

  private int encodePosition(int x, int y) {
    return x + MAX_SIZE * y;
  }

  private int getDist(int x, int y) {
    return x * x + y * y;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
