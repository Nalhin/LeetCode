package com.leetcode.strings.easy;

// Give a string s, count the number of non-empty (contiguous) substrings that ha
// ve the same number of 0's and 1's, and all the 0's and all the 1's in these subs
// trings are grouped consecutively.
//
// Substrings that occur multiple times are counted the number of times they occ
// ur.
//
// Example 1:
//
// Input: "00110011"
// Output: 6
// Explanation: There are 6 substrings that have equal number of consecutive 1's
// and 0's: "0011", "01", "1100", "10", "0011", and "01".
// Notice that some of these substrings repeat and are counted the number of tim
// es they occur.
// Also, "00110011" is not a valid substring because all the 0's (and 1's) are n
// ot grouped together.
//
//
//
// Example 2:
//
// Input: "10101"
// Output: 4
// Explanation: There are 4 substrings: "10", "01", "10", "01" that have equal nu
// mber of consecutive 1's and 0's.
//
//
//
// Note:
// s.length will be between 1 and 50,000.
// s will only consist of "0" or "1" characters.
// Related Topics String
// 👍 1171 👎 196

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(n) Runtime: 14 ms, faster than 16.16% of Java online submissions for Count Binary Substrings.
 O(1) Memory Usage: 39.1 MB, less than 94.40% of Java online submissions for Count Binary Substring
*/
public class CountBinarySubstrings_696 {
  public int countBinarySubstrings(String s) {
    int ans = 0;
    int prev = 0;
    int curr = 1;
    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i - 1) != s.charAt(i)) {
        ans += Math.min(prev, curr);
        prev = curr;
        curr = 1;
      } else {
        curr++;
      }
    }
    return ans + Math.min(prev, curr);
  }
}
// leetcode submit region end(Prohibit modification and deletion)
