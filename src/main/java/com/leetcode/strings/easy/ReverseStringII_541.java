package com.leetcode.strings.easy;

//
// Given a string and an integer k, you need to reverse the first k characters fo
// r every 2k characters counting from the start of the string. If there are less t
// han k characters left, reverse all of them. If there are less than 2k but greate
// r than or equal to k characters, then reverse the first k characters and left th
// e other as original.
//
//
// Example:
//
// Input: s = "abcdefg", k = 2
// Output: "bacdfeg"
//
//
//
// Restrictions:
//
// The string consists of lower English letters only.
// Length of the given string and k will in the range [1, 10000]
// Related Topics String
// 👍 548 👎 1527

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse String II.
 O(n) Memory Usage: 39.2 MB, less than 53.55% of Java online submissions for Reverse String II.
*/
public class ReverseStringII_541 {
  public String reverseStr(String s, int k) {
    char[] str = s.toCharArray();

    for (int i = 0; i < str.length; i += 2 * k) {
      reverseStr(i, Math.min(i + k - 1, str.length - 1), str);
    }

    return new String(str);
  }

  private void reverseStr(int left, int right, char[] str) {
    while (left < right) {
      char temp = str[left];
      str[left] = str[right];
      str[right] = temp;
      left++;
      right--;
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
