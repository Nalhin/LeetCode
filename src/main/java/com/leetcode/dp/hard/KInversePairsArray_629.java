package com.leetcode.dp.hard;

// For an integer array nums, an inverse pair is a pair of integers [i, j] where
// 0 <= i < j < nums.length and nums[i] > nums[j].
//
// Given two integers n and k, return the number of different arrays consist of
// numbers from 1 to n such that there are exactly k inverse pairs. Since the answe
// r can be huge, return it modulo 109 + 7.
//
//
// Example 1:
//
//
// Input: n = 3, k = 0
// Output: 1
// Explanation: Only the array [1,2,3] which consists of numbers from 1 to 3 has
// exactly 0 inverse pairs.
//
//
// Example 2:
//
//
// Input: n = 3, k = 1
// Output: 2
// Explanation: The array [1,3,2] and [2,1,3] have exactly 1 inverse pair.
//
//
//
// Constraints:
//
//
// 1 <= n <= 1000
// 0 <= k <= 1000
//
// Related Topics Dynamic Programming
// 👍 629 👎 102
/*
 O(n * k) Runtime: 16 ms, faster than 92.54% of Java online submissions for K Inverse Pairs Array.
 O(k) Memory Usage: 38.6 MB, less than 84.33% of Java online submissions for K Inverse Pairs Array.
*/
// leetcode submit region begin(Prohibit modification and deletion)

public class KInversePairsArray_629 {

  private static final int MOD = 1_000_000_007;

  public int kInversePairs(int n, int k) {
    int[] oldDp = new int[k + 1];

    for (int i = 1; i <= n; i++) {
      int[] newDp = new int[k + 1];
      newDp[0] = 1;
      for (int j = 1; j <= k; j++) {
        int prev = (oldDp[j] + MOD - ((j - i) >= 0 ? oldDp[j - i] : 0)) % MOD;
        newDp[j] = (newDp[j - 1] + prev) % MOD;
      }
      oldDp = newDp;
    }
    return ((oldDp[k] + MOD - (k > 0 ? oldDp[k - 1] : 0)) % MOD);
  }
}
// leetcode submit region end(Prohibit modification and deletion)
