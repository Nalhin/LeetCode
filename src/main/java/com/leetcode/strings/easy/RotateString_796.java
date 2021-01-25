package com.leetcode.strings.easy;

// We are given two strings, A and B.
//
// A shift on A consists of taking string A and moving the leftmost character to
// the rightmost position. For example, if A = 'abcde', then it will be 'bcdea' af
// ter one shift on A. Return True if and only if A can become B after some number
// of shifts on A.
//
//
// Example 1:
// Input: A = 'abcde', B = 'cdeab'
// Output: true
//
// Example 2:
// Input: A = 'abcde', B = 'abced'
// Output: false
//
//
// Note:
//
//
// A and B will have length at most 100.
//
// 👍 971 👎 58

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(nm) Runtime: 0 ms, faster than 100.00% of Java online submissions for Rotate String.
 O(n) Memory Usage: 37.1 MB, less than 55.43% of Java online submissions for Rotate String.
*/
public class RotateString_796 {
  public boolean rotateString(String A, String B) {
    return A.length() == B.length() && (A + A).contains(B);
  }
}
// leetcode submit region end(Prohibit modification and deletion)
