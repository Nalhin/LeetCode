package com.leetcode.strings.medium;

// Given two strings: s1 and s2 with the same size, check if some permutation of
// string s1 can break some permutation of string s2 or vice-versa. In other words
// s2 can break s1 or vice-versa.
//
// A string x can break string y (both of size n) if x[i] >= y[i] (in alphabetic
// al order) for all i between 0 and n-1.
//
//
// Example 1:
//
//
// Input: s1 = "abc", s2 = "xya"
// Output: true
// Explanation: "ayx" is a permutation of s2="xya" which can break to string "abc
// " which is a permutation of s1="abc".
//
//
// Example 2:
//
//
// Input: s1 = "abe", s2 = "acd"
// Output: false
// Explanation: All permutations for s1="abe" are: "abe", "aeb", "bae", "bea", "e
// ab" and "eba" and all permutation for s2="acd" are: "acd", "adc", "cad", "cda",
// "dac" and "dca". However, there is not any permutation from s1 which can break s
// ome permutation from s2 and vice-versa.
//
//
// Example 3:
//
//
// Input: s1 = "leetcodee", s2 = "interview"
// Output: true
//
//
//
// Constraints:
//
//
// s1.length == n
// s2.length == n
// 1 <= n <= 10^5
// All strings consist of lowercase English letters.
//
// Related Topics String Greedy
// 👍 253 👎 73

// leetcode submit region begin(Prohibit modification and deletion)
/*
  O(n) Runtime: 8 ms, faster than 75.68% of Java online submissions for Check If a String Can Break Another String.
  O(1) Memory Usage: 39.4 MB, less than 95.80% of Java online submissions for Check If a String Can Break Another String.
 */
public class CheckIfAStringCanBreakAnotherString_1433 {
  public boolean checkIfCanBreak(String s1, String s2) {
    int[] charactersInS1 = new int[26];
    int[] charactersInS2 = new int[26];

    for (int i = 0; i < s1.length(); i++) {
      charactersInS1[s1.charAt(i) - 'a']++;
      charactersInS2[s2.charAt(i) - 'a']++;
    }

    for (int i = 1; i < 26; i++) {
      charactersInS1[i] += charactersInS1[i - 1];
      charactersInS2[i] += charactersInS2[i - 1];
    }

    return canBreak(charactersInS1, charactersInS2) || canBreak(charactersInS2, charactersInS1);
  }

  private boolean canBreak(int[] chars1, int[] chars2) {
    for (int i = 0; i < 26; i++) {
      if (chars1[i] > chars2[i]) {
        return false;
      }
    }
    return true;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
