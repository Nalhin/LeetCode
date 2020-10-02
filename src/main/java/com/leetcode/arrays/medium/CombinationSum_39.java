package com.leetcode.arrays.medium;

// Given an array of distinct integers candidates and a target integer target, re
// turn a list of all unique combinations of candidates where the chosen numbers su
// m to target. You may return the combinations in any order.
//
// The same number may be chosen from candidates an unlimited number of times. T
// wo combinations are unique if the frequency of at least one of the chosen number
// s is different.
//
//
// Example 1:
//
//
// Input: candidates = [2,3,6,7], target = 7
// Output: [[2,2,3],[7]]
// Explanation:
// 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple ti
// mes.
// 7 is a candidate, and 7 = 7.
// These are the only two combinations.
//
//
// Example 2:
//
//
// Input: candidates = [2,3,5], target = 8
// Output: [[2,2,2,2],[2,3,3],[3,5]]
//
//
// Example 3:
//
//
// Input: candidates = [2], target = 1
// Output: []
//
//
// Example 4:
//
//
// Input: candidates = [1], target = 1
// Output: [[1]]
//
//
// Example 5:
//
//
// Input: candidates = [1], target = 2
// Output: [[1,1]]
//
//
//
// Constraints:
//
//
// 1 <= candidates.length <= 30
// 1 <= candidates[i] <= 200
// All elements of candidates are distinct.
// 1 <= target <= 500
//
// Related Topics Array Backtracking
// 👍 4560 👎 129

// leetcode submit region begin(Prohibit modification and deletion)
import java.util.ArrayList;
import java.util.List;

public class CombinationSum_39 {

  private final List<List<Integer>> result = new ArrayList<>();

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    backtrack(candidates, 0, new ArrayList<>(), target);
    return result;
  }

  private void backtrack(int[] candidates, int start, List<Integer> curr, int remaining) {
    if (remaining == 0) {
      result.add(new ArrayList<>(curr));
    } else if (remaining > 0) {
      for (int i = start; i < candidates.length; i++) {
        curr.add(candidates[i]);
        backtrack(candidates, i, curr, remaining - candidates[i]);
        curr.remove(curr.size() - 1);
      }
    }
  }
}
/*
   T - target
   M - min value
   O(n^((T/M) + 1)) Runtime: 3 ms, faster than 80.27% of Java online submissions for Combination Sum.
   O(T/M) Memory Usage: 39.4 MB, less than 89.09% of Java online submissions for Combination Sum.
*/
// leetcode submit region end(Prohibit modification and deletion)

