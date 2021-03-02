package com.leetcode.strings.easy;

// Given a string s containing only lower case English letters and the '?' charac
// ter, convert all the '?' characters into lower case letters such that the final
// string does not contain any consecutive repeating characters. You cannot modify
// the non '?' characters.
//
// It is guaranteed that there are no consecutive repeating characters in the gi
// ven string except for '?'.
//
// Return the final string after all the conversions (possibly zero) have been m
// ade. If there is more than one solution, return any of them. It can be shown tha
// t an answer is always possible with the given constraints.
//
//
// Example 1:
//
//
// Input: s = "?zs"
// Output: "azs"
// Explanation: There are 25 solutions for this problem. From "azs" to "yzs", all
// are valid. Only "z" is an invalid modification as the string will consist of co
// nsecutive repeating characters in "zzs".
//
// Example 2:
//
//
// Input: s = "ubv?w"
// Output: "ubvaw"
// Explanation: There are 24 solutions for this problem. Only "v" and "w" are inv
// alid modifications as the strings will consist of consecutive repeating characte
// rs in "ubvvw" and "ubvww".
//
//
// Example 3:
//
//
// Input: s = "j?qg??b"
// Output: "jaqgacb"
//
//
// Example 4:
//
//
// Input: s = "??yw?ipkj?"
// Output: "acywaipkja"
//
//
//
// Constraints:
//
//
// 1 <= s.length <= 100
// s contains only lower case English letters and '?'.
//
// Related Topics String
// 👍 172 👎 91

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(n) Runtime: 1 ms, faster than 100.00% of Java online submissions for Replace All ?'s to Avoid Consecutive Repeating Characters.
 O(n) Memory Usage: 38.9 MB, less than 82.86% of Java online submissions for Replace All ?'s to Avoid Consecutive Repeating Characters.
*/
public class ReplaceAllQuestionMarksToAvoidConsecutiveRepeatingCharacters_1576 {
  public String modifyString(String s) {
    if (s.equals("?")) {
      return "a";
    }

    char[] chars = s.toCharArray();
    if (chars[0] == '?') {
      chars[0] = getNextChar(' ', chars[1]);
    }

    for (int i = 1; i < s.length() - 1; i++) {
      if (chars[i] == '?') {
        chars[i] = getNextChar(chars[i - 1], chars[i + 1]);
      }
    }

    if (chars[chars.length - 1] == '?') {
      chars[chars.length - 1] = getNextChar(chars[chars.length - 2], ' ');
    }
    return new String(chars);
  }

  private char getNextChar(char prev, char next) {

    for (char c = 'a'; c <= 'z'; c++) {
      if (prev != c && next != c) {
        return c;
      }
    }
    return ' ';
  }
}
// leetcode submit region end(Prohibit modification and deletion)
