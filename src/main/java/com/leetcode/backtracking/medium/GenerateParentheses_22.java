package com.leetcode.backtracking.medium;

// Given n pairs of parentheses, write a function to generate all combinations of
// well-formed parentheses.
//
//
// Example 1:
// Input: n = 3
// Output: ["((()))","(()())","(())()","()(())","()()()"]
// Example 2:
// Input: n = 1
// Output: ["()"]
//
//
// Constraints:
//
//
// 1 <= n <= 8
//
// Related Topics String Backtracking
// 👍 6741 👎 306

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;
/*
 O(4^n / sqrt(n)) Runtime: 0 ms, faster than 100.00% of Java online submissions for Generate Parentheses.
 O(4^n / sqrt(n)) Memory Usage: 39.4 MB, less than 34.09% of Java online submissions for Generate Parentheses.
*/
public class GenerateParentheses_22 {
  public List<String> generateParenthesis(int n) {
    StringBuilder sb = new StringBuilder();
    List<String> result = new ArrayList<>();
    generateHelper(sb, n * 2, 0, 0, result);

    return result;
  }

  private void generateHelper(
      StringBuilder sb, int len, int open, int position, List<String> result) {
    if (position == len) {
      result.add(sb.toString());
    }
    if (open < len - position) {
      sb.append("(");
      generateHelper(sb, len, open + 1, position + 1, result);
      sb.deleteCharAt(sb.length() - 1);
    }
    if (open > 0) {
      sb.append(")");
      generateHelper(sb, len, open - 1, position + 1, result);
      sb.deleteCharAt(sb.length() - 1);
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
