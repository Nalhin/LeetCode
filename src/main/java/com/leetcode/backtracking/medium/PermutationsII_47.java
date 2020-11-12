package com.leetcode.backtracking.medium;

// Given a collection of numbers, nums, that might contain duplicates, return all
// possible unique permutations in any order.
//
//
// Example 1:
//
//
// Input: nums = [1,1,2]
// Output:
// [[1,1,2],
// [1,2,1],
// [2,1,1]]
//
//
// Example 2:
//
//
// Input: nums = [1,2,3]
// Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 8
// -10 <= nums[i] <= 10
//
// Related Topics Backtracking
// 👍 2434 👎 68

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;
/*
 O(n * n!)  Runtime: 18 ms, faster than 19.90% of Java online submissions for Permutations II.
 O(n) Memory Usage: 40 MB, less than 7.49% of Java online submissions for Permutations II.
*/
public class PermutationsII_47 {

  public List<List<Integer>> permuteUnique(int[] nums) {
    Set<String> visited = new HashSet<>();
    Set<Integer> used = new LinkedHashSet<>();
    List<List<Integer>> result = new ArrayList<>();
    visit(nums, "", visited, used, result);
    return result;
  }

  private void visit(
      int[] nums, String curr, Set<String> visited, Set<Integer> used, List<List<Integer>> result) {
    if (visited.contains(curr)) {
      return;
    }

    visited.add(curr);

    if (used.size() == nums.length) {
      List<Integer> partial = new ArrayList<>();
      for (int pos : used) {
        partial.add(nums[pos]);
      }
      result.add(partial);
      return;
    }

    for (int i = 0; i < nums.length; i++) {
      if (!used.contains(i)) {
        used.add(i);
        visit(nums, curr + nums[i], visited, used, result);
        used.remove(i);
      }
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
