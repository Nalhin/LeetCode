package com.leetcode.arrays.easy;
// Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elemen
// ts appear twice and others appear once.
//
// Find all the elements of [1, n] inclusive that do not appear in this array.
//
// Could you do it without extra space and in O(n) runtime? You may assume the r
// eturned list does not count as extra space.
//
// Example:
//
// Input:
// [4,3,2,7,8,2,3,1]
//
// Output:
// [5,6]
//
// Related Topics Array
// 👍 3198 👎 260

import java.util.ArrayList;
import java.util.List;

// leetcode submit region begin(Prohibit modification and deletion)
public class FindAllNumbersDisappearedInAnArray_448 {
  public List<Integer> findDisappearedNumbers(int[] nums) {
    List<Integer> result = new ArrayList<>();

    for (int i = 0; i < nums.length; i++) {
      int num = Math.abs(nums[i]) - 1;
      if (nums[num] > 0) {
        nums[num] = -nums[num];
      }
    }

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > 0) {
        result.add(i + 1);
      }
    }

    return result;
  }
}

/*
   Runtime: 5 ms, faster than 85.42% of Java online submissions for Find All Numbers Disappeared in an Array.
   Memory Usage: 48.9 MB, less than 44.54% of Java online submissions for Find All Numbers Disappeared in an Array.
*/
// leetcode submit region end(Prohibit modification and deletion)
