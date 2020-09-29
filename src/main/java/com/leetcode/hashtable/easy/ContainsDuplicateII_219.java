package com.leetcode.hashtable.easy;

// Given an array of integers and an integer k, find out whether there are two di
// stinct indices i and j in the array such that nums[i] = nums[j] and the absolute
// difference between i and j is at most k.
//
//
// Example 1:
//
//
// Input: nums = [1,2,3,1], k = 3
// Output: true
//
//
//
// Example 2:
//
//
// Input: nums = [1,0,1,1], k = 1
// Output: true
//
//
//
// Example 3:
//
//
// Input: nums = [1,2,3,1,2,3], k = 2
// Output: false
//
//
//
//
// Related Topics Array Hash Table
// 👍 1006 👎 1143

import java.util.HashMap;
import java.util.Map;

// leetcode submit region begin(Prohibit modification and deletion)
class ContainsDuplicateII_219 {
  public boolean containsNearbyDuplicate(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(nums[i])) {
        int pos = map.get(nums[i]);
        if (i - pos <= k) {
          return true;
        }
      }
      map.put(nums[i], i);
    }
    return false;
  }
}
/*
  O(n) Runtime: 5 ms, faster than 91.87% of Java online submissions for Contains Duplicate II.
  O(n) Memory Usage: 44.6 MB, less than 64.22% of Java online submissions for Contains Duplicate II.
*/
// leetcode submit region end(Prohibit modification and deletion)
