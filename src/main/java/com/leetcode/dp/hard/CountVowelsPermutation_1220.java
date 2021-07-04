package com.leetcode.dp.hard;

// Given an integer n, your task is to count how many strings of length n can be
// formed under the following rules:
//
//
// Each character is a lower case vowel ('a', 'e', 'i', 'o', 'u')
// Each vowel 'a' may only be followed by an 'e'.
// Each vowel 'e' may only be followed by an 'a' or an 'i'.
// Each vowel 'i' may not be followed by another 'i'.
// Each vowel 'o' may only be followed by an 'i' or a 'u'.
// Each vowel 'u' may only be followed by an 'a'.
//
//
// Since the answer may be too large, return it modulo 10^9 + 7.
//
//
// Example 1:
//
//
// Input: n = 1
// Output: 5
// Explanation: All possible strings are: "a", "e", "i" , "o" and "u".
//
//
// Example 2:
//
//
// Input: n = 2
// Output: 10
// Explanation: All possible strings are: "ae", "ea", "ei", "ia", "ie", "io", "iu
// ", "oi", "ou" and "ua".
//
//
// Example 3:
//
//
// Input: n = 5
// Output: 68
//
//
// Constraints:
//
//
// 1 <= n <= 2 * 10^4
//
// Related Topics Dynamic Programming
// 👍 493 👎 69

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.List;
import java.util.Map;

public class CountVowelsPermutation_1220 {

  /*
   O(n) Runtime: 93 ms, faster than 10.77% of Java online submissions for Count Vowels Permutation.
   O(n) Memory Usage: 46.6 MB, less than 17.96% of Java online submissions for Count Vowels Permutation.
  */
  static class TopDown {

    private static final int MOD = 1_000_000_007;
    private static final Map<Character, List<Character>> NEXT_ALLOWED =
        Map.ofEntries(
            Map.entry('a', List.of('e')),
            Map.entry('e', List.of('a', 'i')),
            Map.entry('i', List.of('a', 'e', 'o', 'u')),
            Map.entry('o', List.of('i', 'u')),
            Map.entry('u', List.of('a')));
    private static final Map<Character, Integer> INDICES =
        Map.ofEntries(
            Map.entry('a', 0),
            Map.entry('e', 1),
            Map.entry('i', 2),
            Map.entry('o', 3),
            Map.entry('u', 4));

    public int countVowelPermutation(int n) {
      int[][] memo = new int[n][5];
      int result = 0;
      for (char c : List.of('a', 'e', 'i', 'o', 'u')) {
        result = (result + dfs(memo, c, n - 1)) % MOD;
      }
      return result;
    }

    private int dfs(int[][] memo, char prevChar, int n) {
      if (n == 0) {
        return 1;
      }
      int index = INDICES.get(prevChar);

      if (memo[n][index] != 0) {
        return memo[n][index];
      }

      int sum = 0;
      for (char c : NEXT_ALLOWED.get(prevChar)) {
        sum = (sum + dfs(memo, c, n - 1)) % MOD;
      }

      memo[n][index] = sum;

      return sum;
    }
  }
  /*
   O(n) Runtime: 10 ms, faster than 87.85% of Java online submissions for Count Vowels Permutation.
   O(1) Memory Usage: 35.6 MB, less than 94.75% of Java online submissions for Count Vowels Permutation.
  */
  static class BottomUp {

    private static final int MOD = 1_000_000_007;

    public int countVowelPermutation(int n) {
      long aCount = 1;
      long eCount = 1;
      long iCount = 1;
      long oCount = 1;
      long uCount = 1;

      for (int i = 1; i < n; i++) {
        long naCount = (eCount + iCount + uCount) % MOD;
        long neCount = (aCount + iCount) % MOD;
        long niCount = (eCount + oCount) % MOD;
        long noCount = (iCount) % MOD;
        long nuCount = (iCount + oCount) % MOD;
        aCount = naCount;
        eCount = neCount;
        iCount = niCount;
        oCount = noCount;
        uCount = nuCount;
      }

      return (int) ((aCount + eCount + iCount + oCount + uCount) % MOD);
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
