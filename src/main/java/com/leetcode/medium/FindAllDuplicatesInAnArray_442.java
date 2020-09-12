package com.leetcode.medium;

// Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements ap
// pear twice and others appear once.
//
// Find all the elements that appear twice in this array.
//
// Could you do it without extra space and in O(n) runtime?
//
// Example:
//
// Input:
// [4,3,2,7,8,2,3,1]
//
// Output:
// [2,3]
// Related Topics Array
// 👍 2736 👎 161

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInAnArray_442 {
  public List<Integer> findDuplicates(int[] nums) {
    List<Integer> result = new ArrayList<>();

    for (int i = 0; i < nums.length; i++) {
      int num = Math.abs(nums[i]);
      if (nums[num - 1] < 0) {
        result.add(num);
      } else {
        nums[num - 1] = -nums[num - 1];
      }
    }

    return result;
  }
}

/*
    Runtime: 12 ms, faster than 37.16% of Java online submissions for Find All Duplicates in an Array.
    Memory Usage: 63.2 MB, less than 26.21% of Java online submissions for Find All Duplicates in an Array.
*/

// leetcode submit region end(Prohibit modification and deletion)
