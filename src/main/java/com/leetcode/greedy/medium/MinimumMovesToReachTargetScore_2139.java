package com.leetcode.greedy.medium;

// You are playing a game with integers. You start with the integer 1 and you
// want to reach the integer target.
//
// In one move, you can either:
//
//
// Increment the current integer by one (i.e., x = x + 1).
// Double the current integer (i.e., x = 2 * x).
//
//
// You can use the increment operation any number of times, however, you can
// only use the double operation at most maxDoubles times.
//
// Given the two integers target and maxDoubles, return the minimum number of
// moves needed to reach target starting with 1.
//
//
// Example 1:
//
//
// Input: target = 5, maxDoubles = 0
// Output: 4
// Explanation: Keep incrementing by 1 until you reach target.
//
//
// Example 2:
//
//
// Input: target = 19, maxDoubles = 2
// Output: 7
// Explanation: Initially, x = 1
// Increment 3 times so x = 4
// Double once so x = 8
// Increment once so x = 9
// Double again so x = 18
// Increment once so x = 19
//
//
// Example 3:
//
//
// Input: target = 10, maxDoubles = 4
// Output: 4
// Explanation: Initially, x = 1
// Increment once so x = 2
// Double once so x = 4
// Increment once so x = 5
// Double again so x = 10
//
//
//
// Constraints:
//
//
// 1 <= target <= 10⁹
// 0 <= maxDoubles <= 100
//
// Related Topics Math Greedy 👍 344 👎 4
/*
 O(log(n))  Runtime: 1 ms, faster than 45.30% of Java online submissions for Minimum Moves to Reach Target Score.
 O(1) Memory Usage: 41.2 MB, less than 5.29% of Java online submissions for Minimum Moves to Reach Target Score.
*/
// leetcode submit region begin(Prohibit modification and deletion)

public class MinimumMovesToReachTargetScore_2139 {
  public int minMoves(int target, int maxDoubles) {
    int result = 0;

    for (int i = 0; i < maxDoubles && target > 1; i++) {
      if (target % 2 == 1) {
        result++;
        target--;
      }

      target /= 2;
      result++;
    }

    return result + target - 1;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
