package com.leetcode.arrays.easy;

// We have n chips, where the position of the ith chip is position[i].
//
// We need to move all the chips to the same position. In one step, we can chang
// e the position of the ith chip from position[i] to:
//
//
// position[i] + 2 or position[i] - 2 with cost = 0.
// position[i] + 1 or position[i] - 1 with cost = 1.
//
//
// Return the minimum cost needed to move all the chips to the same position.
//
//
// Example 1:
//
//
// Input: position = [1,2,3]
// Output: 1
// Explanation: First step: Move the chip at position 3 to position 1 with cost =
// 0.
// Second step: Move the chip at position 2 to position 1 with cost = 1.
// Total cost is 1.
//
//
// Example 2:
//
//
// Input: position = [2,2,2,3,3]
// Output: 2
// Explanation: We can move the two chips at poistion 3 to position 2. Each move
// has cost = 1. The total cost = 2.
//
//
// Example 3:
//
//
// Input: position = [1,1000000000]
// Output: 1
//
//
//
// Constraints:
//
//
// 1 <= position.length <= 100
// 1 <= position[i] <= 10^9
//
// Related Topics Array Math Greedy
// 👍 388 👎 1060

// leetcode submit region begin(Prohibit modification and deletion)
/*
  O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Minimum Cost to Move Chips to The Same Position.
  O(1) Memory Usage: 36.4 MB, less than 7.50% of Java online submissions for Minimum Cost to Move Chips to The Same Position.
*/
public class MinimumCostToMoveChipsToTheSamePosition_1217 {

  public int minCostToMoveChips(int[] position) {
    int evens = 0;
    int odds = 0;

    for (int j : position) {
      if (j % 2 == 0) {
        evens++;
      } else {
        odds++;
      }
    }
    return Math.min(evens, odds);
  }
}
// leetcode submit region end(Prohibit modification and deletion)
