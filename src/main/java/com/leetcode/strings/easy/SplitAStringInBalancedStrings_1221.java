package com.leetcode.strings.easy;

// Balanced strings are those who have equal quantity of 'L' and 'R' characters.
//
//
// Given a balanced string s split it in the maximum amount of balanced strings.
//
//
// Return the maximum amount of splitted balanced strings.
//
//
// Example 1:
//
//
// Input: s = "RLRRLLRLRL"
// Output: 4
// Explanation: s can be split into "RL", "RRLL", "RL", "RL", each substring cont
// ains same number of 'L' and 'R'.
//
//
// Example 2:
//
//
// Input: s = "RLLLLRRRLR"
// Output: 3
// Explanation: s can be split into "RL", "LLLRRR", "LR", each substring contains
// same number of 'L' and 'R'.
//
//
// Example 3:
//
//
// Input: s = "LLLLRRRR"
// Output: 1
// Explanation: s can be split into "LLLLRRRR".
//
//
// Example 4:
//
//
// Input: s = "RLRRRLLRLL"
// Output: 2
// Explanation: s can be split into "RL", "RRRLLRLL", since each substring contai
// ns an equal number of 'L' and 'R'
//
//
//
// Constraints:
//
//
// 1 <= s.length <= 1000
// s[i] = 'L' or 'R'
//
// Related Topics String Greedy
// 👍 782 👎 501

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Split a String in Balanced Strings.
 O(1) Memory Usage: 36.9 MB, less than 56.53% of Java online submissions for Split a String in Balanced Strings.
*/
public class SplitAStringInBalancedStrings_1221 {
  public int balancedStringSplit(String s) {
    int ans = 0;

    int r = 0;
    int l = 0;

    for (int i = 0; i < s.length(); i++) {

      if (s.charAt(i) == 'R') {
        r++;
      } else {
        l++;
      }

      if (l == r) {
        ans++;
      }
    }

    return ans;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
