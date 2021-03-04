package com.leetcode.backtracking.medium;

// Given a string containing digits from 2-9 inclusive, return all possible lette
// r combinations that the number could represent. Return the answer in any order.
//
//
// A mapping of digit to letters (just like on the telephone buttons) is given b
// elow. Note that 1 does not map to any letters.
//
//
//
//
// Example 1:
//
//
// Input: digits = "23"
// Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
//
//
// Example 2:
//
//
// Input: digits = ""
// Output: []
//
//
// Example 3:
//
//
// Input: digits = "2"
// Output: ["a","b","c"]
//
//
//
// Constraints:
//
//
// 0 <= digits.length <= 4
// digits[i] is a digit in the range ['2', '9'].
//
// Related Topics String Backtracking Depth-first Search Recursion
// 👍 5461 👎 498

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber_17 {
  private static final HashMap<Integer, List<Character>> possibleLetters = new HashMap<>();

  static {
    possibleLetters.put(2, List.of('a', 'b', 'c'));
    possibleLetters.put(3, List.of('d', 'e', 'f'));
    possibleLetters.put(4, List.of('g', 'h', 'i'));
    possibleLetters.put(5, List.of('j', 'k', 'l'));
    possibleLetters.put(6, List.of('m', 'n', 'o'));
    possibleLetters.put(7, List.of('p', 'q', 'r', 's'));
    possibleLetters.put(8, List.of('t', 'u', 'v'));
    possibleLetters.put(9, List.of('w', 'x', 'y', 'z'));
  }

  public List<String> letterCombinations(String digits) {
    if ("".equals(digits)) {
      return Collections.emptyList();
    }
    List<String> result = new ArrayList<>();

    dfs(0, digits, new StringBuilder(), result);

    return result;
  }

  private void dfs(int idx, String digits, StringBuilder currWord, List<String> result) {
    if (idx >= digits.length()) {
      result.add(currWord.toString());
      return;
    }

    int digit = Character.getNumericValue(digits.charAt(idx++));

    for (char possibleChar : possibleLetters.get(digit)) {
      dfs(idx, digits, currWord.append(possibleChar), result);
      currWord.deleteCharAt(currWord.length() - 1);
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
