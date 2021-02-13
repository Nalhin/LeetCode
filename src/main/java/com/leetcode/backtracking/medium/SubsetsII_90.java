package com.leetcode.backtracking.medium;

// Given an integer array nums that may contain duplicates, return all possible s
// ubsets (the power set).
//
// The solution set must not contain duplicate subsets. Return the solution in a
// ny order.
//
//
// Example 1:
// Input: nums = [1,2,2]
// Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
// Example 2:
// Input: nums = [0]
// Output: [[],[0]]
//
//
// Constraints:
//
//
// 1 <= nums.length <= 10
// -10 <= nums[i] <= 10
//
// Related Topics Array Backtracking
// 👍 2244 👎 100

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
 O(2^n) Runtime: 1 ms, faster than 99.49% of Java online submissions for Subsets II.
 O(2^n) Memory Usage: 39.2 MB, less than 61.81% of Java online submissions for Subsets II.
*/
public class SubsetsII_90 {
  public List<List<Integer>> subsetsWithDup(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> result = new ArrayList<>();
    helper(0, nums, new ArrayList<>(), result);
    return result;
  }

  private void helper(int pos, int[] nums, List<Integer> curr, List<List<Integer>> result) {
    result.add(new ArrayList<>(curr));

    for (int i = pos; i < nums.length; i++) {
      if (i == pos || nums[i - 1] != nums[i]) {
        curr.add(nums[i]);
        helper(i + 1, nums, curr, result);
        curr.remove(curr.size() - 1);
      }
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
