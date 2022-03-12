package com.leetcode.strings.medium;

// Given an integer n, return all the strobogrammatic numbers that are of length
// n. You may return the answer in any order.
//
// A strobogrammatic number is a number that looks the same when rotated 180
// degrees (looked at upside down).
//
//
// Example 1:
// Input: n = 2
// Output: ["11","69","88","96"]
// Example 2:
// Input: n = 1
// Output: ["0","1","8"]
//
//
// Constraints:
//
//
// 1 <= n <= 14
//
// Related Topics Array String Recursion 👍 733 👎 189
/*
 O(n * 5^n) Runtime: 91 ms, faster than 8.87% of Java online submissions for Strobogrammatic Number II.
 O(n* 5^n) Memory Usage: 127.7 MB, less than 5.20% of Java online submissions for Strobogrammatic Number II.
*/

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StrobogrammaticNumberII_247 {

  private final Map<Character, Character> mirroredMapping =
      Map.ofEntries(
          Map.entry('1', '1'),
          Map.entry('0', '0'),
          Map.entry('8', '8'),
          Map.entry('6', '9'),
          Map.entry('9', '6'));

  private final List<Character> mirrored = List.of('1', '0', '8');
  private final List<Character> available = List.of('0', '1', '6', '8', '9');

  public List<String> findStrobogrammatic(int n) {
    if (n == 1) {
      return mirrored.stream().map(c -> Character.toString(c)).collect(Collectors.toList());
    }

    List<String> result = new ArrayList<>();

    findRecursive(0, n, new StringBuilder(), result);

    return result;
  }

  private void findRecursive(int curr, int total, StringBuilder sb, List<String> result) {
    if (curr == total / 2) {

      if (total % 2 == 1) {
        for (char c : mirrored) {
          result.add(buildMirroredResult(sb.toString() + c, true));
        }
      } else {
        result.add(buildMirroredResult(sb.toString(), false));
      }

      return;
    }

    for (char c : available) {
      if (curr == 0 && c == '0') {
        continue;
      }
      sb.append(c);
      findRecursive(curr + 1, total, sb, result);
      sb.setLength(sb.length() - 1);
    }
  }

  private String buildMirroredResult(String str, boolean skipLast) {
    StringBuilder result = new StringBuilder(str);

    for (int i = str.length() - (skipLast ? 2 : 1); i >= 0; i--) {
      result.append(mirroredMapping.get(str.charAt(i)));
    }

    return result.toString();
  }
}
// leetcode submit region end(Prohibit modification and deletion)
