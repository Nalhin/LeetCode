package com.leetcode.backtracking.medium;

// Given an array nums of distinct integers, return all the possible permutations
// . You can return the answer in any order.
//
//
// Example 1:
// Input: nums = [1,2,3]
// Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// Example 2:
// Input: nums = [0,1]
// Output: [[0,1],[1,0]]
// Example 3:
// Input: nums = [1]
// Output: [[1]]
//
//
// Constraints:
//
//
// 1 <= nums.length <= 6
// -10 <= nums[i] <= 10
// All the integers of nums are unique.
//
// Related Topics Backtracking
// 👍 5416 👎 126

import java.util.ArrayList;
import java.util.List;
/*
 O(n!) Runtime: 1 ms, faster than 93.75% of Java online submissions for Permutations.
 O(n! * n) Memory Usage: 39.1 MB, less than 71.95% of Java online submissions for Permutations.
*/
// leetcode submit region begin(Prohibit modification and deletion)
public class Permutations_46 {
  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    dfs(nums, new boolean[nums.length], new ArrayList<>(), result);
    return result;
  }

  public void dfs(int[] nums, boolean[] visited, List<Integer> curr, List<List<Integer>> result) {
    if (curr.size() == nums.length) {
      result.add(new ArrayList<>(curr));
    }

    for (int i = 0; i < nums.length; i++) {
      if (!visited[i]) {
        visited[i] = true;
        curr.add(nums[i]);
        dfs(nums, visited, curr, result);
        curr.remove(curr.size() - 1);
        visited[i] = false;
      }
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
