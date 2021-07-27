package com.leetcode.arrays.medium;

// Given an array nums of n integers and an integer target, find three integers i
// n nums such that the sum is closest to target. Return the sum of the three integ
// ers. You may assume that each input would have exactly one solution.
//
//
// Example 1:
//
//
// Input: nums = [-1,2,1,-4], target = 1
// Output: 2
// Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
//
//
//
// Constraints:
//
//
// 3 <= nums.length <= 10^3
// -10^3 <= nums[i] <= 10^3
// -10^4 <= target <= 10^4
//
// Related Topics Array Two Pointers Sorting
// 👍 3932 👎 192
/*
 O(n^2) Runtime: 6 ms, faster than 51.83% of Java online submissions for 3Sum Closest.
 O(sort(n) Memory Usage: 38.4 MB, less than 91.76% of Java online submissions for 3Sum Closest.
*/
import java.util.Arrays;

// leetcode submit region begin(Prohibit modification and deletion)
public class ThreeSumClosest_16 {
  public int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);

    int result = nums[0] + nums[1] + nums[2];

    for (int i = 0; i < nums.length - 2; i++) {
      int left = i + 1;
      int right = nums.length - 1;

      while (left < right) {
        int value = nums[i] + nums[left] + nums[right];

        if (value > target) {
          right--;
        } else {
          left++;
        }

        if (Math.abs(target - result) > Math.abs(target - value)) {
          result = value;
        }
      }
    }

    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
