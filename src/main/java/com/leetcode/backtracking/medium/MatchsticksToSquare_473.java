package com.leetcode.backtracking.medium;

// You are given an integer array matchsticks where matchsticks[i] is the length
// of the ith matchstick. You want to use all the matchsticks to make one square. Y
// ou should not break any stick, but you can link them up, and each matchstick mus
// t be used exactly one time.
//
// Return true if you can make this square and false otherwise.
//
//
// Example 1:
//
//
// Input: matchsticks = [1,1,2,2,2]
// Output: true
// Explanation: You can form a square with length 2, one side of the square came
// two sticks with length 1.
//
//
// Example 2:
//
//
// Input: matchsticks = [3,3,3,3,4]
// Output: false
// Explanation: You cannot find a way to form a square with all the matchsticks.
//
//
//
// Constraints:
//
//
// 1 <= matchsticks.length <= 15
// 0 <= matchsticks[i] <= 109
//
// Related Topics Depth-first Search
// 👍 869 👎 73
/*
 O(4^n) Runtime: 149 ms, faster than 39.40% of Java online submissions for Matchsticks to Square.
 O(n) Memory Usage: 37.2 MB, less than 22.27% of Java online submissions for Matchsticks to Square.
*/
// leetcode submit region begin(Prohibit modification and deletion)

import java.util.Arrays;

public class MatchsticksToSquare_473 {
  public boolean makesquare(int[] matchsticks) {
    int sideLength = Arrays.stream(matchsticks).sum() / 4;
    int[] sides = new int[] {sideLength, sideLength, sideLength, sideLength};
    Arrays.sort(matchsticks);

    return dfs(matchsticks.length - 1, matchsticks, sides);
  }

  private boolean dfs(int currIdx, int[] matchsticks, int[] sides) {
    if (currIdx < 0) {
      return isValidSolution(sides);
    }

    for (int i = 0; i < sides.length; i++) {
      if (sides[i] >= matchsticks[currIdx]) {
        sides[i] -= matchsticks[currIdx];
        if (dfs(currIdx - 1, matchsticks, sides)) {
          return true;
        }
        sides[i] += matchsticks[currIdx];
      }
    }

    return false;
  }

  private boolean isValidSolution(int[] sides) {
    for (int side : sides) {
      if (side != 0) {
        return false;
      }
    }
    return true;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
