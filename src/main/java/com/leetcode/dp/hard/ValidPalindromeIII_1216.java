package com.leetcode.dp.hard;

/*
 O(n^2) Runtime: 11 ms, faster than 57.62% of Java online submissions for Valid Palindrome III.
 O(n^2) Memory Usage: 41.1 MB, less than 37.86% of Java online submissions for Valid Palindrome III.
*/
import java.util.Arrays;

public class ValidPalindromeIII_1216 {
  public boolean isValidPalindrome(String s, int k) {
    int[][] memo = new int[s.length()][s.length()];

    for (int[] row : memo) {
      Arrays.fill(row, s.length() + 1);
    }

    return isValidPalindromeBetween(0, s.length() - 1, memo, s) <= k;
  }

  private int isValidPalindromeBetween(int left, int right, int[][] memo, String s) {
    if (left >= right) {
      return 0;
    }

    if (memo[left][right] < s.length() + 1) {
      return memo[left][right];
    }

    if (s.charAt(left) == s.charAt(right)) {
      memo[left][right] = isValidPalindromeBetween(left + 1, right - 1, memo, s);
    } else {
      memo[left][right] =
          Math.min(
                  isValidPalindromeBetween(left + 1, right, memo, s),
                  isValidPalindromeBetween(left, right - 1, memo, s))
              + 1;
    }

    return memo[left][right];
  }
}
