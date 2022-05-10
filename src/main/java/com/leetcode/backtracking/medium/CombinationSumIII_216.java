package com.leetcode.backtracking.medium;

// Find all valid combinations of k numbers that sum up to n such that the
// following conditions are true:
//
//
// Only numbers 1 through 9 are used.
// Each number is used at most once.
//
//
// Return a list of all possible valid combinations. The list must not contain
// the same combination twice, and the combinations may be returned in any order.
//
//
// Example 1:
//
//
// Input: k = 3, n = 7
// Output: [[1,2,4]]
// Explanation:
// 1 + 2 + 4 = 7
// There are no other valid combinations.
//
// Example 2:
//
//
// Input: k = 3, n = 9
// Output: [[1,2,6],[1,3,5],[2,3,4]]
// Explanation:
// 1 + 2 + 6 = 9
// 1 + 3 + 5 = 9
// 2 + 3 + 4 = 9
// There are no other valid combinations.
//
//
// Example 3:
//
//
// Input: k = 4, n = 1
// Output: []
// Explanation: There are no valid combinations.
// Using 4 different numbers in the range [1,9], the smallest sum we can get is 1
// +2+3+4 = 10 and since 10 > 1, there are no valid combination.
//
//
//
// Constraints:
//
//
// 2 <= k <= 9
// 1 <= n <= 60
//
// Related Topics Array Backtracking 👍 2913 👎 74
/*
 O(9! * k) Runtime: 0 ms, faster than 100.00% of Java online submissions for Combination Sum III.
 O(9! * k) Memory Usage: 39.6 MB, less than 97.10% of Java online submissions for Combination Sum III.
*/
import java.util.ArrayList;
import java.util.List;

// leetcode submit region begin(Prohibit modification and deletion)
public class CombinationSumIII_216 {
  public List<List<Integer>> combinationSum3(int k, int n) {
    List<List<Integer>> result = new ArrayList<>();

    combinationBacktrack(9, k, n, new ArrayList<>(), result);

    return result;
  }

  private void combinationBacktrack(
      int currNum, int k, int n, List<Integer> currentSolution, List<List<Integer>> result) {
    if (n == 0 && currentSolution.size() == k) {
      result.add(new ArrayList<>(currentSolution));
      return;
    }
    if (n < 0 || currentSolution.size() > k) {
      return;
    }

    for (int i = currNum; i > 0; i--) {
      currentSolution.add(i);

      combinationBacktrack(i - 1, k, n - i, currentSolution, result);

      currentSolution.remove(currentSolution.size() - 1);
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
