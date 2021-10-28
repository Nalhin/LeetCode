package com.leetcode.twopointers.medium;

// Given an integer array nums, return all the triplets [nums[i], nums[j], nums[
// k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
//
// Notice that the solution set must not contain duplicate triplets.
//
//
// Example 1:
// Input: nums = [-1,0,1,2,-1,-4]
// Output: [[-1,-1,2],[-1,0,1]]
// Example 2:
// Input: nums = []
// Output: []
// Example 3:
// Input: nums = [0]
// Output: []
//
//
// Constraints:
//
//
// 0 <= nums.length <= 3000
// -10⁵ <= nums[i] <= 10⁵
//
/*
  O(n^2) Runtime: 18 ms, faster than 92.16% of Java online submissions for 3Sum.
  O(sort) Memory Usage: 43.1 MB, less than 72.96% of Java online submissions for 3Sum.
*/
// Related Topics Array Two Pointers Sorting 👍 13930 👎 1335

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// leetcode submit region begin(Prohibit modification and deletion)

public class ThreeSum_15 {
  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> result = new ArrayList<>();

    for (int i = 0; i < nums.length - 1; i++) {
      if (i != 0 && nums[i - 1] == nums[i]) {
        continue;
      }

      int left = i + 1;
      int right = nums.length - 1;

      while (left < right) {
        int sum = nums[left] + nums[right] + nums[i];

        if (sum > 0) {
          right--;
        } else if (sum < 0) {
          left++;
        } else {
          result.add(List.of(nums[i], nums[left], nums[right]));
          left++;
          right--;
          while (left < right && nums[left] == nums[left - 1]) {
            left++;
          }
        }
      }
    }

    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
