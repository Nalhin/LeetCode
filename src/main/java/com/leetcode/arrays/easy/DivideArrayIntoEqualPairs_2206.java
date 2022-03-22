package com.leetcode.arrays.easy;

// You are given an integer array nums consisting of 2 * n integers.
//
// You need to divide nums into n pairs such that:
//
//
// Each element belongs to exactly one pair.
// The elements present in a pair are equal.
//
//
// Return true if nums can be divided into n pairs, otherwise return false.
//
//
// Example 1:
//
//
// Input: nums = [3,2,3,2,2,2]
// Output: true
// Explanation:
// There are 6 elements in nums, so they should be divided into 6 / 2 = 3 pairs.
// If nums is divided into the pairs (2, 2), (3, 3), and (2, 2), it will satisfy
// all the conditions.
//
//
// Example 2:
//
//
// Input: nums = [1,2,3,4]
// Output: false
// Explanation:
// There is no way to divide nums into 4 / 2 = 2 pairs such that the pairs
// satisfy every condition.
//
//
//
// Constraints:
//
//
// nums.length == 2 * n
// 1 <= n <= 500
// 1 <= nums[i] <= 500
//
// 👍 77 👎 1
/*
  O(n) Runtime: 4 ms, faster than 73.77% of Java online submissions for Divide Array Into Equal Pairs.
  O(n) Memory Usage: 42.1 MB, less than 96.58% of Java online submissions for Divide Array Into Equal Pairs.
*/

import java.util.HashSet;
import java.util.Set;

// leetcode submit region begin(Prohibit modification and deletion)
public class DivideArrayIntoEqualPairs_2206 {
  public boolean divideArray(int[] nums) {
    Set<Integer> odds = new HashSet<>();

    for (int num : nums) {
      if (odds.contains(num)) {
        odds.remove(num);
      } else {
        odds.add(num);
      }
    }

    return odds.isEmpty();
  }
}
// leetcode submit region end(Prohibit modification and deletion)
