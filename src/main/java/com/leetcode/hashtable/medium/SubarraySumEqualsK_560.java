package com.leetcode.hashtable.medium;

// Given an array of integers nums and an integer k, return the total number of c
// ontinuous subarrays whose sum equals to k.
//
//
// Example 1:
// Input: nums = [1,1,1], k = 2
// Output: 2
// Example 2:
// Input: nums = [1,2,3], k = 3
// Output: 2
//
//
// Constraints:
//
//
// 1 <= nums.length <= 2 * 104
// -1000 <= nums[i] <= 1000
// -107 <= k <= 107
//
// Related Topics Array Hash Table
// 👍 7079 👎 243
/*
 O(n) Runtime: 31 ms, faster than 29.35% of Java online submissions for Subarray Sum Equals K.
 O(n) Memory Usage: 57.2 MB, less than 5.06% of Java online submissions for Subarray Sum Equals K.
*/
// leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashMap;

public class SubarraySumEqualsK_560 {
  public int subarraySum(int[] nums, int k) {
    int result = 0;
    int sum = 0;
    HashMap<Integer, Integer> map = new HashMap<>();
    map.put(0, 1);

    for (int num : nums) {
      sum += num;
      result += map.getOrDefault(sum - k, 0);
      map.put(sum, map.getOrDefault(sum, 0) + 1);
    }
    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
