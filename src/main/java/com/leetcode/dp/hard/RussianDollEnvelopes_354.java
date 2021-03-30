package com.leetcode.dp.hard;

// You are given a 2D array of integers envelopes where envelopes[i] = [wi, hi] r
// epresents the width and the height of an envelope.
//
// One envelope can fit into another if and only if both the width and height of
// one envelope is greater than the width and height of the other envelope.
//
// Return the maximum number of envelopes can you Russian doll (i.e., put one in
// side the other).
//
// Note: You cannot rotate an envelope.
//
//
// Example 1:
//
//
// Input: envelopes = [[5,4],[6,4],[6,7],[2,3]]
// Output: 3
// Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3]
// => [5,4] => [6,7]).
//
//
// Example 2:
//
//
// Input: envelopes = [[1,1],[1,1],[1,1]]
// Output: 1
//
//
//
// Constraints:
//
//
// 1 <= envelopes.length <= 5000
// envelopes[i].length == 2
// 1 <= wi, hi <= 104
//
// Related Topics Binary Search Dynamic Programming
// 👍 1755 👎 53
/*
  O(nlog(n)) Runtime: 8 ms, faster than 98.48% of Java online submissions for Russian Doll Envelopes.
  O(n) Memory Usage: 39.9 MB, less than 55.03% of Java online submissions for Russian Doll Envelopes.
*/
// leetcode submit region begin(Prohibit modification and deletion)

import java.util.Arrays;

public class RussianDollEnvelopes_354 {
  private int longestIncreasingSubsequence(int[][] envelopes) {
    int[] dp = new int[envelopes.length];
    int result = 0;

    for (int[] num : envelopes) {
      int position = Arrays.binarySearch(dp, 0, result, num[1]);

      if (position < 0) {
        position = -(position + 1);
      }
      dp[position] = num[1];
      if (position == result) {
        result++;
      }
    }
    return result;
  }

  public int maxEnvelopes(int[][] envelopes) {
    Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

    return longestIncreasingSubsequence(envelopes);
  }
}
// leetcode submit region end(Prohibit modification and deletion)
