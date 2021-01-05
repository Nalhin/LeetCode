package com.leetcode.backtracking.medium;

// Given a collection of candidate numbers (candidates) and a target number (targ
// et), find all unique combinations in candidates where the candidate numbers sum
// to target.
//
// Each number in candidates may only be used once in the combination.
//
// Note: The solution set must not contain duplicate combinations.
//
//
// Example 1:
//
//
// Input: candidates = [10,1,2,7,6,1,5], target = 8
// Output:
// [
// [1,1,6],
// [1,2,5],
// [1,7],
// [2,6]
// ]
//
//
// Example 2:
//
//
// Input: candidates = [2,5,2,1,2], target = 5
// Output:
// [
// [1,2,2],
// [5]
// ]
//
//
//
// Constraints:
//
//
// 1 <= candidates.length <= 100
// 1 <= candidates[i] <= 50
// 1 <= target <= 30
//
// Related Topics Array Backtracking
// 👍 2346 👎 82

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(2^n) Runtime: 4 ms, faster than 71.17% of Java online submissions for Combination Sum II.
 O(n) Memory Usage: 39.3 MB, less than 64.58% of Java online submissions for Combination Sum II.
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII_40 {
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(candidates);
    dfs(candidates, 0, target, new ArrayList<>(), result);
    return result;
  }

  private void dfs(
      int[] candidates, int position, int target, List<Integer> curr, List<List<Integer>> result) {
    if (target < 0 || position > candidates.length) {
      return;
    }
    if (target == 0) {
      result.add(new ArrayList<>(curr));
    }

    for (int i = position; i < candidates.length; i++) {
      if (i > position && candidates[i] == candidates[i - 1]) {
        continue;
      }
      curr.add(candidates[i]);
      dfs(candidates, i + 1, target - candidates[i], curr, result);
      curr.remove(curr.size() - 1);
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
