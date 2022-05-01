package com.leetcode.strings.easy;

// Given two strings s and t, return true if they are equal when both are typed
// into empty text editors. '#' means a backspace character.
//
// Note that after backspacing an empty text, the text will continue empty.
//
//
// Example 1:
//
//
// Input: s = "ab#c", t = "ad#c"
// Output: true
// Explanation: Both s and t become "ac".
//
//
// Example 2:
//
//
// Input: s = "ab##", t = "c#d#"
// Output: true
// Explanation: Both s and t become "".
//
//
// Example 3:
//
//
// Input: s = "a#c", t = "b"
// Output: false
// Explanation: s becomes "c" while t becomes "b".
//
//
//
// Constraints:
//
//
// 1 <= s.length, t.length <= 200
// s and t only contain lowercase letters and '#' characters.
//
//
//
// Follow up: Can you solve it in O(n) time and O(1) space?
// Related Topics Two Pointers String Stack Simulation 👍 4401 👎 196
/*
  O(n) Runtime: 1 ms, faster than 87.56% of Java online submissions for Backspace String Compare.
  O(1) Memory Usage: 42.5 MB, less than 24.13% of Java online submissions for Backspace String Compare.
*/
// leetcode submit region begin(Prohibit modification and deletion)

public class BackspaceStringCompare_844 {
  public boolean backspaceCompare(String s, String t) {
    int firstIdx = s.length() - 1;
    int secondIdx = t.length() - 1;

    while (firstIdx >= 0 || secondIdx >= 0) {

      int skipFirst = 0;
      while (firstIdx >= 0) {
        if (s.charAt(firstIdx) == '#') {
          skipFirst++;
          firstIdx--;
        } else if (skipFirst > 0) {
          skipFirst--;
          firstIdx--;
        } else break;
      }

      int skipSecond = 0;
      while (secondIdx >= 0) {
        if (t.charAt(secondIdx) == '#') {
          skipSecond++;
          secondIdx--;
        } else if (skipSecond > 0) {
          skipSecond--;
          secondIdx--;
        } else break;
      }

      if (firstIdx >= 0 && secondIdx >= 0 && s.charAt(firstIdx) != t.charAt(secondIdx)) {
        return false;
      }

      if ((firstIdx >= 0) != (secondIdx >= 0)) {
        return false;
      }

      firstIdx--;
      secondIdx--;
    }

    return true;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
