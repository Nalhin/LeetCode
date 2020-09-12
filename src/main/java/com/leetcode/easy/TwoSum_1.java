package com.leetcode.easy;
//Given an array of integers nums and an integer target, return indices of the t
//wo numbers such that they add up to target.
//
// You may assume that each input would have exactly one solution, and you may n
//ot use the same element twice.
//
// You can return the answer in any order.
//
//
// Example 1:
//
//
//Input: nums = [2,7,11,15], target = 9
//Output: [0,1]
//Output: Because nums[0] + nums[1] == 9, we return [0, 1].
//
//
// Example 2:
//
//
//Input: nums = [3,2,4], target = 6
//Output: [1,2]
//
//
// Example 3:
//
//
//Input: nums = [3,3], target = 6
//Output: [0,1]
//
//
//
// Constraints:
//
//
// 2 <= nums.length <= 105
// -109 <= nums[i] <= 109
// -109 <= target <= 109
// Only one valid answer exists.
//
// Related Topics Array Hash Table
// 👍 16731 👎 605


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashMap;


public class TwoSum_1 {
  public int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> cache = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      cache.put(nums[i], i);
    }

    for (int i = 0; i < nums.length; i++) {
      int curr = target - nums[i];
      if (cache.containsKey(curr) && cache.get(curr) != i) {
        return new int[] {i, cache.get(curr)};
      }
    }
    return new int[0];
  }
}

/*
    Runtime: 2 ms, faster than 75.69% of Java online submissions for Two Sum.
    Memory Usage: 39.8 MB, less than 54.72% of Java online submissions for Two Sum.
*/
