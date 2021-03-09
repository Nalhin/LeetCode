package com.leetcode.math.easy;

// Given a string num which represents an integer, return true if num is a strobo
// grammatic number.
//
// A strobogrammatic number is a number that looks the same when rotated 180 deg
// rees (looked at upside down).
//
//
// Example 1:
// Input: num = "69"
// Output: true
// Example 2:
// Input: num = "88"
// Output: true
// Example 3:
// Input: num = "962"
// Output: false
// Example 4:
// Input: num = "1"
// Output: true
//
//
// Constraints:
//
//
// 1 <= num.length <= 50
// num consists of only digits.
// num does not contain any leading zeros except for zero itself.
//
// Related Topics Hash Table Math
// 👍 295 👎 563

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashMap;
import java.util.Map;

public class StrobogrammaticNumber_246 {

  private static final Map<Character, Character> replacements = new HashMap<>();

  static {
    replacements.put('9', '6');
    replacements.put('6', '9');
    replacements.put('8', '8');
    replacements.put('1', '1');
    replacements.put('0', '0');
  }

  public boolean isStrobogrammatic(String num) {
    int left = 0;
    int right = num.length() - 1;

    while (left <= right) {
      if (!replacements.containsKey(num.charAt(left))
          || !replacements.containsKey(num.charAt(right))) {
        return false;
      }

      if (replacements.get(num.charAt(left)) != num.charAt(right)) {
        return false;
      }

      left++;
      right--;
    }

    return true;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
