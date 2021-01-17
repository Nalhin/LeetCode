package com.leetcode.dp.medium;

// Given an integer n, return the number of strings of length n that consist only
// of vowels (a, e, i, o, u) and are lexicographically sorted.
//
// A string s is lexicographically sorted if for all valid i, s[i] is the same a
// s or comes before s[i+1] in the alphabet.
//
//
// Example 1:
//
//
// Input: n = 1
// Output: 5
// Explanation: The 5 sorted strings that consist of vowels only are ["a","e","i"
// ,"o","u"].
//
//
// Example 2:
//
//
// Input: n = 2
// Output: 15
// Explanation: The 15 sorted strings that consist of vowels only are
// ["aa","ae","ai","ao","au","ee","ei","eo","eu","ii","io","iu","oo","ou","uu"].
// Note that "ea" is not a valid string since 'e' comes after 'a' in the alphabet
// .
//
//
// Example 3:
//
//
// Input: n = 33
// Output: 66045
//
//
//
// Constraints:
//
//
// 1 <= n <= 50
//
// Related Topics Math Dynamic Programming Backtracking
// 👍 444 👎 9

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.Arrays;

public class CountSortedVowelStrings_1641 {
  /*
   O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Count Sorted Vowel Strings.
   O(n) Memory Usage: 37.6 MB, less than 13.37% of Java online submissions for Count Sorted Vowel Strings.
  */
  static class TopDownDp {

    private final char[] VOWELS = {'a', 'e', 'i', 'o', 'u'};

    public int countVowelStrings(int n) {
      int[][] dp = new int[26][n + 1];
      return countVowel(dp, n, 'a');
    }

    private int countVowel(int[][] dp, int n, char prevChar) {
      if (n <= 0) {
        return 1;
      }

      if (dp[prevChar - 'a'][n] > 0) {
        return dp[prevChar - 'a'][n];
      }

      int sum = 0;
      for (char c : VOWELS) {
        if (prevChar <= c) {
          sum += countVowel(dp, n - 1, c);
        }
      }
      dp[prevChar - 'a'][n] = sum;
      return sum;
    }
  }
  /*
   O(n) Runtime: 2 ms, faster than 32.65% of Java online submissions for Count Sorted Vowel Strings.
   O(n) Memory Usage: 37.8 MB, less than 12.31% of Java online submissions for Count Sorted Vowel Strings.
  */
  static class BottomUpDp {
    private final char[] VOWELS = {'a', 'e', 'i', 'o', 'u'};

    public int countVowelStrings(int n) {
      if (n == 1) {
        return 5;
      }
      int[][] dp = new int[n + 1][26];
      Arrays.fill(dp[0], 1);
      for (int i = 1; i < n; i++) {
        for (char vowel : VOWELS) {
          for (char greater : VOWELS) {
            if (vowel >= greater) {
              dp[i][vowel - 'a'] += dp[i - 1][greater - 'a'];
            }
          }
        }
      }

      return Arrays.stream(dp[n - 1]).sum();
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
