package com.leetcode.arrays.medium;

// Given an array of integers, find out whether there are two distinct indices i
// and j in the array such that the absolute difference between nums[i] and nums[j]
// is at most t and the absolute difference between i and j is at most k.
//
//
// Example 1:
// Input: nums = [1,2,3,1], k = 3, t = 0
// Output: true
// Example 2:
// Input: nums = [1,0,1,1], k = 1, t = 2
// Output: true
// Example 3:
// Input: nums = [1,5,9,1,5,9], k = 2, t = 3
// Output: false
//
//
// Constraints:
//
//
// 0 <= nums.length <= 2 * 104
// -231 <= nums[i] <= 231 - 1
// 0 <= k <= 104
// 0 <= t <= 231 - 1
//
// Related Topics Sort Ordered Map
// 👍 1385 👎 1470

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.TreeSet;
/*
 O(nlog(min(n,k))) Runtime: 29 ms, faster than 37.85% of Java online submissions for Contains Duplicate III.
 O(min(k, n)) Memory Usage: 39.9 MB, less than 5.33% of Java online submissions for Contains Duplicate I
*/
public class ContainsDuplicateIII_220 {
  public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    TreeSet<Integer> set = new TreeSet<>();

    for (int i = 0; i < nums.length; i++) {

      Integer lower = set.ceiling(nums[i]);
      if (lower != null && lower <= (long) nums[i] + t) {
        return true;
      }

      Integer higher = set.floor(nums[i]);
      if (higher != null && higher >= (long) nums[i] - t) {
        return true;
      }

      set.add(nums[i]);
      if (set.size() > k) {
        set.remove(nums[i - k]);
      }
    }

    return false;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
