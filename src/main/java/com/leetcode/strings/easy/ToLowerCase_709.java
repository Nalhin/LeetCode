package com.leetcode.strings.easy;

// Implement function ToLowerCase() that has a string parameter str, and returns
// the same string in lowercase.
//
//
//
//
// Example 1:
//
//
// Input: "Hello"
// Output: "hello"
//
//
//
// Example 2:
//
//
// Input: "here"
// Output: "here"
//
//
//
// Example 3:
//
//
// Input: "LOVELY"
// Output: "lovely"
//
//
//
// Related Topics String
// 👍 563 👎 1694

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for To Lower Case.
 O(n) Memory Usage: 37 MB, less than 9.98% of Java online submissions for To Lower Case.
*/
public class ToLowerCase_709 {
  public String toLowerCase(String str) {
    char[] chars = str.toCharArray();
    int diff = 'a' - 'A';
    for (int i = 0; i < chars.length; i++) {
      if (chars[i] >= 'A' && chars[i] <= 'Z') {
        chars[i] = (char) (chars[i] + diff);
      }
    }
    return new String(chars);
  }
}
// leetcode submit region end(Prohibit modification and deletion)
