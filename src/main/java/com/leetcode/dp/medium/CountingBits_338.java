package com.leetcode.dp.medium;

// Given a non negative integer number num. For every numbers i in the range 0 ≤
// i ≤ num calculate the number of 1's in their binary representation and return th
// em as an array.
//
// Example 1:
//
//
// Input: 2
// Output: [0,1,1]
//
// Example 2:
//
//
// Input: 5
// Output: [0,1,1,2,1,2]
//
//
// Follow up:
//
//
// It is very easy to come up with a solution with run time O(n*sizeof(integer))
// . But can you do it in linear time O(n) /possibly in a single pass?
// Space complexity should be O(n).
// Can you do it like a boss? Do it without using any builtin function like __bu
// iltin_popcount in c++ or in any other language.
// Related Topics Dynamic Programming Bit Manipulation
// 👍 3167 👎 180

// leetcode submit region begin(Prohibit modification and deletion)

/*
 O(n) Runtime: 1 ms, faster than 99.92% of Java online submissions for Counting Bits.
 O(n) Memory Usage: 43.1 MB, less than 12.34% of Java online submissions for Counting Bits.
*/
public class CountingBits_338 {
  public int[] countBits(int num) {
    int[] dp = new int[num + 1];
    for (int i = 1; i <= num; ++i) {
      dp[i] = dp[i >> 1] + (i & 1);
    }
    return dp;
  }
}

// leetcode submit region end(Prohibit modification and deletion)
