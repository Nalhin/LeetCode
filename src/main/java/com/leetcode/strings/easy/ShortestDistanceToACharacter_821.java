package com.leetcode.strings.easy;

// Given a string S and a character C, return an array of integers representing t
// he shortest distance from the character C in the string.
//
// Example 1:
//
//
// Input: S = "loveleetcode", C = 'e'
// Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
//
//
//
//
// Note:
//
//
// S string length is in [1, 10000].
// C is a single character, and guaranteed to be in string S.
// All letters in S and C are lowercase.
//
// 👍 1293 👎 88

// leetcode submit region begin(Prohibit modification and deletion)
/*
   O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Shortest Distance to a Character.
   O(n) Memory Usage: 38.9 MB, less than 93.28% of Java online submissions for Shortest Distance to a Character.
*/
public class ShortestDistanceToACharacter_821 {
  public int[] shortestToChar(String str, char c) {
    int[] result = new int[str.length()];
    int dist = str.length();

    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == c) {
        int pos = i - 1;
        while (pos >= 0 && i - pos < result[pos]) {
          result[pos] = i - pos;
          pos--;
        }
        dist = 0;
      }
      result[i] = dist++;
    }

    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
