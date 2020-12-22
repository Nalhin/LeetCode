package com.leetcode.greedy.medium;

// Given an array A of integers, for each integer A[i] we need to choose either x
// = -K or x = K, and add x to A[i] (only once).
//
// After this process, we have some array B.
//
// Return the smallest possible difference between the maximum value of B and th
// e minimum value of B.
//
//
//
//
//
//
//
// Example 1:
//
//
// Input: A = [1], K = 0
// Output: 0
// Explanation: B = [1]
//
//
//
// Example 2:
//
//
// Input: A = [0,10], K = 2
// Output: 6
// Explanation: B = [2,8]
//
//
//
// Example 3:
//
//
// Input: A = [1,3,6], K = 3
// Output: 3
// Explanation: B = [4,6,3]
//
//
//
//
// Note:
//
//
// 1 <= A.length <= 10000
// 0 <= A[i] <= 10000
// 0 <= K <= 10000
//
//
//
// Related Topics Math Greedy
// 👍 536 👎 239

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.Arrays;
/*
 O(n) Runtime: 7 ms, faster than 93.10% of Java online submissions for Smallest Range II.
 O(sort) Memory Usage: 39 MB, less than 99.31% of Java online submissions for Smallest Range II.
*/
public class SmallestRangeII_910 {
  public int smallestRangeII(int[] nums, int k) {
    int len = nums.length;
    Arrays.sort(nums);

    int result = nums[len - 1] - nums[0];

    for (int i = 0; i < nums.length - 1; ++i) {
      int a = nums[i];
      int b = nums[i + 1];
      int max = Math.max(nums[len - 1] - k, a + k);
      int min = Math.min(nums[0] + k, b - k);
      result = Math.min(result, max - min);
    }
    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
