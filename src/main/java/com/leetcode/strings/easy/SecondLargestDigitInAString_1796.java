package com.leetcode.strings.easy;

// Given an alphanumeric string s, return the second largest numerical digit that
// appears in s, or -1 if it does not exist.
//
// An alphanumeric string is a string consisting of lowercase English letters an
// d digits.
//
//
// Example 1:
//
//
// Input: s = "dfa12321afd"
// Output: 2
// Explanation: The digits that appear in s are [1, 2, 3]. The second largest dig
// it is 2.
//
//
// Example 2:
//
//
// Input: s = "abc1111"
// Output: -1
// Explanation: The digits that appear in s are [1]. There is no second largest d
// igit.
//
//
//
// Constraints:
//
//
// 1 <= s.length <= 500
// s consists of only lowercase English letters and/or digits.
//
// Related Topics String
// 👍 34 👎 26
/*
 O(n) Runtime: 1 ms, faster than 100.00% of Java online submissions for Second Largest Digit in a String.
 O(1) Memory Usage: 37.2 MB, less than 100.00% of Java online submissions for Second Largest Digit in a String.
*/
// leetcode submit region begin(Prohibit modification and deletion)
public class SecondLargestDigitInAString_1796 {
  public int secondHighest(String str) {
    boolean[] nums = new boolean[10];

    for (int i = 0; i < str.length(); i++) {
      if (Character.isDigit(str.charAt(i))) {
        nums[str.charAt(i) - '0'] = true;
      }
    }

    boolean prevFound = false;
    for (int i = nums.length - 1; i >= 0; i--) {
      if (nums[i]) {
        if (prevFound) {
          return i;
        }
        prevFound = true;
      }
    }
    return -1;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
