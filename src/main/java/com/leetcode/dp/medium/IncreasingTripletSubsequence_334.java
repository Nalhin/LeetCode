package com.leetcode.dp.medium;

// Given an integer array nums, return true if there exists a triple of indices (
// i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices
// exists, return false.
//
//
// Example 1:
//
//
// Input: nums = [1,2,3,4,5]
// Output: true
// Explanation: Any triplet where i < j < k is valid.
//
//
// Example 2:
//
//
// Input: nums = [5,4,3,2,1]
// Output: false
// Explanation: No triplet exists.
//
//
// Example 3:
//
//
// Input: nums = [2,1,5,0,4,6]
// Output: true
// Explanation: The triplet (3, 4, 5) is valid because nums[3] == 0 < nums[4] ==
// 4 < nums[5] == 6.
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 105
// -231 <= nums[i] <= 231 - 1
//
//
//
// Follow up: Could you implement a solution that runs in O(n) time complexity an
// d O(1) space complexity? 👍 2082 👎 155

// leetcode submit region begin(Prohibit modification and deletion)
class IncreasingTripletSubsequence_334 {
  /*
   O(n) Runtime: 1 ms, faster than 31.24% of Java online submissions for Increasing Triplet Subsequence.
   O(n) Memory Usage: 38.7 MB, less than 66.11% of Java online submissions for Increasing Triplet Subsequence.
  */
  public static class Dp {
    public boolean increasingTriplet(int[] nums) {
      if (nums.length < 3) {
        return false;
      }
      int n = nums.length - 1;
      int[] mins = new int[nums.length];
      int[] maxes = new int[nums.length];

      mins[0] = nums[0];
      for (int i = 1; i <= n; i++) {
        mins[i] = Math.min(nums[i], mins[i - 1]);
      }

      maxes[n] = nums[n];
      for (int i = n - 1; i >= 0; i--) {
        maxes[i] = Math.max(nums[i], maxes[i + 1]);
      }

      for (int i = 2; i <= n; i++) {
        int mid = nums[i - 1];
        int left = mins[i - 2];
        int right = maxes[i];

        if (left < mid && right > mid) {
          return true;
        }
      }

      return false;
    }
  }
  /*
   O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Increasing Triplet Subsequence.
   O(1) Memory Usage: 38.6 MB, less than 89.62% of Java online submissions for Increasing Triplet Subsequence.
  */
  public static class LinearScan {
    public boolean increasingTriplet(int[] nums) {
      int firstMin = Integer.MAX_VALUE;
      int secondMin = Integer.MAX_VALUE;
      for (int n : nums) {
        if (n <= firstMin) {
          firstMin = n;
        } else if (n <= secondMin) {
          secondMin = n;
        } else {
          return true;
        }
      }
      return false;
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
