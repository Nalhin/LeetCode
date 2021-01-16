package com.leetcode.greedy.medium;

//
// You are given n pairs of numbers. In every pair, the first number is always sm
// aller than the second number.
//
//
//
// Now, we define a pair (c, d) can follow another pair (a, b) if and only if b <
// c. Chain of pairs can be formed in this fashion.
//
//
//
// Given a set of pairs, find the length longest chain which can be formed. You n
// eedn't use up all the given pairs. You can select pairs in any order.
//
//
//
// Example 1:
//
// Input: [[1,2], [2,3], [3,4]]
// Output: 2
// Explanation: The longest chain is [1,2] -> [3,4]
//
//
//
// Note:
//
// The number of given pairs will be in the range [1, 1000].
//
// Related Topics Dynamic Programming
// 👍 1210 👎 86

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(nlog(n)) Runtime: 9 ms, faster than 84.25% of Java online submissions for Maximum Length of Pair Chain.
 O(sort) Memory Usage: 39.5 MB, less than 30.13% of Java online submissions for Maximum Length of Pair Chain.
*/
import java.util.Arrays;
import java.util.Comparator;

public class MaximumLengthOfPairChain_646 {
  public int findLongestChain(int[][] pairs) {
    Arrays.sort(pairs, Comparator.comparingInt(a -> a[0]));

    int max = pairs[0][1];
    int curr = 1;

    for (int i = 1; i < pairs.length; i++) {
      int[] pair = pairs[i];
      if (pair[0] > max) {
        max = pair[1];
        curr++;
      } else if (pair[1] < max) {
        max = pair[1];
      }
    }

    return curr;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
