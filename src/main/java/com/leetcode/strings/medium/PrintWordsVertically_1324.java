package com.leetcode.strings.medium;

// Given a string s. Return all the words vertically in the same order in which t
// hey appear in s.
// Words are returned as a list of strings, complete with spaces when is necessar
// y. (Trailing spaces are not allowed).
// Each word would be put on only one column and that in one column there will be
// only one word.
//
//
// Example 1:
//
//
// Input: s = "HOW ARE YOU"
// Output: ["HAY","ORO","WEU"]
// Explanation: Each word is printed vertically.
// "HAY"
//  "ORO"
//  "WEU"
//
//
// Example 2:
//
//
// Input: s = "TO BE OR NOT TO BE"
// Output: ["TBONTB","OEROOE","   T"]
// Explanation: Trailing spaces is not allowed.
// "TBONTB"
// "OEROOE"
// "   T"
//
//
// Example 3:
//
//
// Input: s = "CONTEST IS COMING"
// Output: ["CIC","OSO","N M","T I","E N","S G","T"]
//
//
//
// Constraints:
//
//
// 1 <= s.length <= 200
// s contains only upper case English letters.
// It's guaranteed that there is only one space between 2 words.
// Related Topics String
// 👍 212 👎 61

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
 O(n*m) Runtime: 2 ms, faster than 48.31% of Java online submissions for Print Words Vertically.
 O(n*m) Memory Usage: 37.6 MB, less than 64.89% of Java online submissions for Print Words Vertically.
*/
public class PrintWordsVertically_1324 {
  public List<String> printVertically(String s) {
    String[] words = s.split(" ");
    List<String> result = new ArrayList<>();

    int maxLen = Arrays.stream(words).mapToInt(String::length).max().getAsInt();

    for (int i = 0; i < maxLen; i++) {
      StringBuilder sb = new StringBuilder();
      for (String word : words) {
        if (i >= word.length()) {
          sb.append(" ");
        } else {
          sb.append(word.charAt(i));
        }
      }
      result.add(sb.toString().stripTrailing());
    }

    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
