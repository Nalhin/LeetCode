package com.leetcode.backtracking.medium;

// A string S represents a list of words.
//
// Each letter in the word has 1 or more options. If there is one option, the le
// tter is represented as is. If there is more than one option, then curly braces d
// elimit the options. For example, "{a,b,c}" represents options ["a", "b", "c"].
//
// For example, "{a,b,c}d{e,f}" represents the list ["ade", "adf", "bde", "bdf",
// "cde", "cdf"].
//
// Return all words that can be formed in this manner, in lexicographical order.
//
//
//
//
// Example 1:
//
//
// Input: "{a,b}c{d,e}f"
// Output: ["acdf","acef","bcdf","bcef"]
//
//
// Example 2:
//
//
// Input: "abcd"
// Output: ["abcd"]
//
//
//
//
// Note:
//
//
// 1 <= S.length <= 50
// There are no nested curly brackets.
// All characters inside a pair of consecutive opening and ending curly brackets
// are different.
//
// Related Topics Backtracking
// 👍 296 👎 33

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
 O(n^m) Runtime: 3 ms, faster than 81.34% of Java online submissions for Brace Expansion.
 O(n^m) Memory Usage: 39.4 MB, less than 71.20% of Java online submissions for Brace Expansion.
*/
public class BraceExpression_1087 {
  public String[] expand(String str) {
    StringBuilder sb = new StringBuilder();
    List<String> result = new ArrayList<>();
    backtrackDfs(sb, 0, str, result);
    Collections.sort(result);

    return result.toArray(new String[0]);
  }

  private void backtrackDfs(StringBuilder sb, int position, String str, List<String> result) {
    if (position >= str.length()) {
      result.add(sb.toString());
      return;
    }

    if (str.charAt(position) == '{') {
      int right = position;
      while (str.charAt(right) != '}') {
        right++;
      }
      String[] sub = str.substring(position + 1, right).split(",");
      for (String subStr : sub) {
        sb.append(subStr);
        backtrackDfs(sb, right + 1, str, result);
        sb.deleteCharAt(sb.length() - 1);
      }

    } else {
      sb.append(str.charAt(position));
      backtrackDfs(sb, position + 1, str, result);
      sb.deleteCharAt(sb.length() - 1);
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
