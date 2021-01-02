package com.leetcode.hashtable.easy;

// Given an array of integers nums.
//
// A pair (i,j) is called good if nums[i] == nums[j] and i < j.
//
// Return the number of good pairs.
//
//
// Example 1:
//
//
// Input: nums = [1,2,3,1,1,3]
// Output: 4
// Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.
//
//
// Example 2:
//
//
// Input: nums = [1,1,1,1]
// Output: 6
// Explanation: Each pair in the array are good.
//
//
// Example 3:
//
//
// Input: nums = [1,2,3]
// Output: 0
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 100
// 1 <= nums[i] <= 100
// Related Topics Array Hash Table Math
// 👍 774 👎 69
/*
 O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Number of Good Pairs.
 O(n) Memory Usage: 36.3 MB, less than 64.94% of Java online submissions for Number of Good Pairs.
*/
// leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashMap;
import java.util.Map;

public class NumberOfGoodPairs_1512 {
  public int numIdenticalPairs(int[] nums) {
    int result = 0;
    Map<Integer, Integer> map = new HashMap<>();

    for (int num : nums) {
      int prev = map.getOrDefault(num, 0);
      result += prev;
      map.put(num, prev + 1);
    }

    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
