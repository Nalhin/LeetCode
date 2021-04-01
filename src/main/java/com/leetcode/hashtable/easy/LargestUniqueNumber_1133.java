package com.leetcode.hashtable.easy;

// Given an array of integers A, return the largest integer that only occurs once
// .
//
// If no integer occurs once, return -1.
//
//
//
// Example 1:
//
//
// Input: [5,7,3,9,4,9,8,3,1]
// Output: 8
// Explanation:
// The maximum integer in the array is 9 but it is repeated. The number 8 occurs
// only once, so it's the answer.
//
//
// Example 2:
//
//
// Input: [9,9,8,8]
// Output: -1
// Explanation:
// There is no number that occurs only once.
//
//
//
//
// Note:
//
//
// 1 <= A.length <= 2000
// 0 <= A[i] <= 1000
//
// Related Topics Array Hash Table
// 👍 136 👎 12
/*
  O(n) Runtime: 3 ms, faster than 64.03% of Java online submissions for Largest Unique Number.
  O(n) Memory Usage: 39.2 MB, less than 11.99% of Java online submissions for Largest Unique Number.
*/
// leetcode submit region begin(Prohibit modification and deletion)

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class LargestUniqueNumber_1133 {
  public int largestUniqueNumber(int[] nums) {
    Set<Integer> moreThanOnce = new HashSet<>();
    Set<Integer> once = new HashSet<>();

    for (int num : nums) {
      if (once.contains(num)) {
        once.remove(num);
        moreThanOnce.add(num);
      } else if (!moreThanOnce.contains(num)) {
        once.add(num);
      }
    }

    return once.isEmpty() ? -1 : Collections.max(once);
  }
}
// leetcode submit region end(Prohibit modification and deletion)
