package com.leetcode.strings.medium;
// Given a binary string s (a string consisting only of '0' and '1's).
//
// Return the number of substrings with all characters 1's.
//
// Since the answer may be too large, return it modulo 10^9 + 7.
//
//
// Example 1:
//
//
// Input: s = "0110111"
// Output: 9
// Explanation: There are 9 substring in total with only 1's characters.
// "1" -> 5 times.
// "11" -> 3 times.
// "111" -> 1 time.
//
// Example 2:
//
//
// Input: s = "101"
// Output: 2
// Explanation: Substring "1" is shown 2 times in s.
//
//
// Example 3:
//
//
// Input: s = "111111"
// Output: 21
// Explanation: Each substring contains only 1's characters.
//
//
// Example 4:
//
//
// Input: s = "000"
// Output: 0
//
//
//
// Constraints:
//
//
// s[i] == '0' or s[i] == '1'
// 1 <= s.length <= 10^5
// Related Topics Math String
// 👍 213 👎 9

// leetcode submit region begin(Prohibit modification and deletion)
public class NumberOfSubstringsWithOnly1s_1513 {

  public int numSub(String s) {
    int total = 0;
    int wordSize = 0;

    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '0') {
        total += countPermutations(wordSize);
        wordSize = 0;
      } else {
        wordSize++;
      }
    }
    total += countPermutations(wordSize);
    return total;
  }

  private int countPermutations(int n) {
    return (int) ((n * (n + 1.0) / 2 ) % 1_000_000_007);
  }
}
/*
    O(n) Runtime: 5 ms, faster than 84.25% of Java online submissions for Number of Substrings With Only 1s.
    O(1) Memory Usage: 39.9 MB, less than 58.42% of Java online submissions for Number of Substrings With Only 1s.
 */

// leetcode submit region end(Prohibit modification and deletion)
