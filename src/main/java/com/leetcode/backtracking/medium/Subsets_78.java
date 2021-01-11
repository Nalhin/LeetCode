package com.leetcode.backtracking.medium;

// Given an integer array nums, return all possible subsets (the power set).
//
// The solution set must not contain duplicate subsets.
//
//
// Example 1:
//
//
// Input: nums = [1,2,3]
// Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
//
//
// Example 2:
//
//
// Input: nums = [0]
// Output: [[],[0]]
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 10
// -10 <= nums[i] <= 10
// All the numbers of nums are unique.
//
// Related Topics Array Backtracking Bit Manipulation
// 👍 5032 👎 106

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;

public class Subsets_78 {
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    dfs(new ArrayList<>(), result, 0, nums);
    return result;
  }

  private void dfs(List<Integer> curr, List<List<Integer>> result, int currPos, int[] nums) {
    if (currPos > nums.length) {
      return;
    }

    result.add(new ArrayList<>(curr));

    for (int i = currPos; i < nums.length; i++) {
      int num = nums[i];
      curr.add(num);
      dfs(curr, result, i + 1, nums);
      curr.remove(curr.size() - 1);
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
