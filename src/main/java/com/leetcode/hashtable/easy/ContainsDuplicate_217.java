package com.leetcode.hashtable.easy;

// Given an array of integers, find if the array contains any duplicates.
//
// Your function should return true if any value appears at least twice in the a
// rray, and it should return false if every element is distinct.
//
// Example 1:
//
//
// Input: [1,2,3,1]
// Output: true
//
// Example 2:
//
//
// Input: [1,2,3,4]
// Output: false
//
// Example 3:
//
//
// Input: [1,1,1,3,3,4,3,2,4,2]
// Output: true
// Related Topics Array Hash Table
// 👍 1092 👎 774

import java.util.HashSet;
import java.util.Set;

// leetcode submit region begin(Prohibit modification and deletion)
public class ContainsDuplicate_217 {
  public boolean containsDuplicate(int[] nums) {
    Set<Integer> set = new HashSet<>();

    for (int num : nums) {
      if (!set.add(num)) {
        return true;
      }
    }
    return false;
  }
}

/*
  O(n) Runtime: 4 ms, faster than 85.60% of Java online submissions for Contains Duplicate.
  O(n) Memory Usage: 43.3 MB, less than 92.37% of Java online submissions for Contains Duplicate.
 */

// leetcode submit region end(Prohibit modification and deletion)
