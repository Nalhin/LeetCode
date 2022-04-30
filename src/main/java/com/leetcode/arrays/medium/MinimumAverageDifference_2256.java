package com.leetcode.arrays.medium;

// You are given a 0-indexed integer array nums of length n.
//
// The average difference of the index i is the absolute difference between the
// average of the first i + 1 elements of nums and the average of the last n - i -
// 1 elements. Both averages should be rounded down to the nearest integer.
//
// Return the index with the minimum average difference. If there are multiple
// such indices, return the smallest one.
//
// Note:
//
//
// The absolute difference of two numbers is the absolute value of their
// difference.
// The average of n elements is the sum of the n elements divided (integer
// division) by n.
// The average of 0 elements is considered to be 0.
//
//
//
// Example 1:
//
//
// Input: nums = [2,5,3,9,5,3]
// Output: 3
// Explanation:
// - The average difference of index 0 is: |2 / 1 - (5 + 3 + 9 + 5 + 3) / 5| = |2
// / 1 - 25 / 5| = |2 - 5| = 3.
// - The average difference of index 1 is: |(2 + 5) / 2 - (3 + 9 + 5 + 3) / 4| =
// |7 / 2 - 20 / 4| = |3 - 5| = 2.
// - The average difference of index 2 is: |(2 + 5 + 3) / 3 - (9 + 5 + 3) / 3| =
// |10 / 3 - 17 / 3| = |3 - 5| = 2.
// - The average difference of index 3 is: |(2 + 5 + 3 + 9) / 4 - (5 + 3) / 2| =
// |19 / 4 - 8 / 2| = |4 - 4| = 0.
// - The average difference of index 4 is: |(2 + 5 + 3 + 9 + 5) / 5 - 3 / 1| = |2
// 4 / 5 - 3 / 1| = |4 - 3| = 1.
// - The average difference of index 5 is: |(2 + 5 + 3 + 9 + 5 + 3) / 6 - 0| = |2
// 7 / 6 - 0| = |4 - 0| = 4.
// The average difference of index 3 is the minimum average difference so return
// 3.
//
//
// Example 2:
//
//
// Input: nums = [0]
// Output: 0
// Explanation:
// The only index is 0 so return 0.
// The average difference of index 0 is: |0 / 1 - 0| = |0 - 0| = 0.
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 10⁵
// 0 <= nums[i] <= 10⁵
//
// 👍 42 👎 3
/*
  O(n) Runtime: 23 ms, faster than 14.29% of Java online submissions for Minimum Average Difference.
  O(1) Memory Usage: 75.1 MB, less than 71.43% of Java online submissions for Minimum Average Difference.
*/
// leetcode submit region begin(Prohibit modification and deletion)

public class MinimumAverageDifference_2256 {
  public int minimumAverageDifference(int[] nums) {

    long suffixSum = 0;

    for (int num : nums) {
      suffixSum += num;
    }

    long result = Long.MAX_VALUE;
    int resultIdx = -1;

    long sum = 0;

    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];

      long currAvg = sum / (i + 1);
      long restAvg = nums.length - i - 1 == 0 ? 0 : ((suffixSum - sum) / (nums.length - i - 1));

      if (Math.abs(currAvg - restAvg) < result) {
        resultIdx = i;
        result = Math.abs(currAvg - restAvg);
      }
    }

    return resultIdx;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
