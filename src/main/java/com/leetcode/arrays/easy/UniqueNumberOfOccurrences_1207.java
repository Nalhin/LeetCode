package com.leetcode.arrays.easy;

// Given an array of integers arr, write a function that returns true if and only
// if the number of occurrences of each value in the array is unique.
//
//
// Example 1:
//
//
// Input: arr = [1,2,2,1,1,3]
// Output: true
// Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values
// have the same number of occurrences.
//
// Example 2:
//
//
// Input: arr = [1,2]
// Output: false
//
//
// Example 3:
//
//
// Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
// Output: true
//
//
//
// Constraints:
//
//
// 1 <= arr.length <= 1000
// -1000 <= arr[i] <= 1000
//
// Related Topics Hash Table
// 👍 525 👎 23

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 O(n) Runtime: 1 ms, faster than 99.40% of Java online submissions for Unique Number of Occurrences.
 O(n) Memory Usage: 37.1 MB, less than 15.55% of Java online submissions for Unique Number of Occurrences.
*/
public class UniqueNumberOfOccurrences_1207 {
  public boolean uniqueOccurrences(int[] arr) {
    Map<Integer, Integer> counter = new HashMap<>();

    for (int n : arr) {
      counter.put(n, counter.getOrDefault(n, 0) + 1);
    }

    Set<Integer> visited = new HashSet<>();

    for (Integer val : counter.values()) {
      if (visited.contains(val)) {
        return false;
      }
      visited.add(val);
    }
    return true;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
