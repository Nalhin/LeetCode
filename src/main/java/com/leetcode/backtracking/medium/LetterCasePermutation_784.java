package com.leetcode.backtracking.medium;

// Given a string S, we can transform every letter individually to be lowercase o
// r uppercase to create another string.
//
// Return a list of all possible strings we could create. You can return the out
// put in any order.
//
//
// Example 1:
//
//
// Input: S = "a1b2"
// Output: ["a1b2","a1B2","A1b2","A1B2"]
//
//
// Example 2:
//
//
// Input: S = "3z4"
// Output: ["3z4","3Z4"]
//
//
// Example 3:
//
//
// Input: S = "12345"
// Output: ["12345"]
//
//
// Example 4:
//
//
// Input: S = "0"
// Output: ["0"]
//
//
//
// Constraints:
//
//
// S will be a string with length between 1 and 12.
// S will consist only of letters or digits.
//
// Related Topics Backtracking Bit Manipulation
// 👍 1774 👎 118

import java.util.ArrayList;
import java.util.List;
/*
  O(2^n * n) Runtime: 2 ms, faster than 74.25% of Java online submissions for Letter Case Permutation.
  O(2^n * n) Memory Usage: 39.9 MB, less than 49.03% of Java online submissions for Letter Case Permutation.
*/
// leetcode submit region begin(Prohibit modification and deletion)
public class LetterCasePermutation_784 {
  public List<String> letterCasePermutation(String str) {
    List<String> result = new ArrayList<>();
    helper(0, str, new StringBuilder(), result);
    return result;
  }

  public void helper(int idx, String str, StringBuilder sb, List<String> result) {
    if (idx >= str.length()) {
      result.add(sb.toString());
      return;
    }
    if (Character.isDigit(str.charAt(idx))) {
      helper(idx + 1, str, sb.append(str.charAt(idx)), result);
    } else {
      helper(idx + 1, str, sb.append(Character.toLowerCase(str.charAt(idx))), result);
      sb.deleteCharAt(sb.length() - 1);
      helper(idx + 1, str, sb.append(Character.toUpperCase(str.charAt(idx))), result);
    }
    sb.deleteCharAt(sb.length() - 1);
  }
}
// leetcode submit region end(Prohibit modification and deletion)
