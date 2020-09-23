package com.leetcode.strings.medium;
//Given a string s of '(' , ')' and lowercase English characters.
//
// Your task is to remove the minimum number of parentheses ( '(' or ')', in any
// positions ) so that the resulting parentheses string is valid and return any va
//lid string.
//
// Formally, a parentheses string is valid if and only if:
//
//
// It is the empty string, contains only lowercase characters, or
// It can be written as AB (A concatenated with B), where A and B are valid stri
//ngs, or
// It can be written as (A), where A is a valid string.
//
//
//
// Example 1:
//
//
//Input: s = "lee(t(c)o)de)"
//Output: "lee(t(c)o)de"
//Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
//
//
// Example 2:
//
//
//Input: s = "a)b(c)d"
//Output: "ab(c)d"
//
//
// Example 3:
//
//
//Input: s = "))(("
//Output: ""
//Explanation: An empty string is also valid.
//
//
// Example 4:
//
//
//Input: s = "(a(b(c)d)"
//Output: "a(b(c)d)"
//
//
//
// Constraints:
//
//
// 1 <= s.length <= 10^5
// s[i] is one of '(' , ')' and lowercase English letters.
// Related Topics String Stack
// 👍 1084 👎 30


//leetcode submit region begin(Prohibit modification and deletion)

public class MinimumRemoveToMakeValidParentheses_1249 {

  public String minRemoveToMakeValid(String s) {
    char[] old = s.toCharArray();

    int opening = 0;
    int closing = 0;
    int left = 0;

    for (int i = 0; i < old.length; i++) {
      if (old[i] == '(') {
        opening++;
      } else if (old[i] == ')') {
        if (closing + 1 > opening) {
          continue;
        } else {
          closing++;
        }
      }
      old[left++] = old[i];
    }
    int right = left - 1;
    opening = 0;
    closing = 0;

    for (int i = right; i >= 0; i--) {
      if (old[i] == ')') {
        closing++;
      } else if (old[i] == '(') {
        if (opening + 1 > closing) {
          continue;
        } else {
          opening++;
        }
      }
      old[right--] = old[i];
    }

    return new String(old, right + 1, left - 1 - right);
  }
}

/*
  O(n) Runtime: 6 ms, faster than 99.29% of Java online submissions for Minimum Remove to Make Valid Parentheses.
  O(1) Memory Usage: 39.9 MB, less than 93.64% of Java online submissions for Minimum Remove to Make Valid Parentheses.
 */
//leetcode submit region end(Prohibit modification and deletion)