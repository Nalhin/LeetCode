package com.leetcode.math.hard;

// Let's say a positive integer is a super-palindrome if it is a palindrome, and
// it is also the square of a palindrome.
//
// Given two positive integers left and right represented as strings, return the
// number of super-palindromes integers in the inclusive range [left, right].
//
//
// Example 1:
//
//
// Input: left = "4", right = "1000"
// Output: 4
// Explanation: 4, 9, 121, and 484 are superpalindromes.
// Note that 676 is not a superpalindrome: 26 * 26 = 676, but 26 is not a palindr
// ome.
//
//
// Example 2:
//
//
// Input: left = "1", right = "2"
// Output: 1
//
//
//
// Constraints:
//
//
// 1 <= left.length, right.length <= 18
// left and right consist of only digits.
// left and right cannot have leading zeros.
// left and right represent integers in the range [1, 1018].
// left is less than or equal to right.
//
// Related Topics Math
// 👍 207 👎 284
/*
  Runtime: 256 ms, faster than 72.34% of Java online submissions for Super Palindromes.
  Memory Usage: 39.1 MB, less than 63.83% of Java online submissions for Super Palindromes.
*/
// leetcode submit region begin(Prohibit modification and deletion)

public class SuperPalindromes_906 {
  private static final int MAX_POSSIBLE = 100_000;

  public int superpalindromesInRange(String sL, String sR) {
    long lowerBound = Long.parseLong(sL);
    long upperBound = Long.parseLong(sR);
    int result = 0;

    for (int k = 1; k < MAX_POSSIBLE; ++k) {
      StringBuilder sb = new StringBuilder(Integer.toString(k));
      for (int i = sb.length() - 2; i >= 0; --i) {
        sb.append(sb.charAt(i));
      }
      long currVal = Long.parseLong(sb.toString());
      long currValSquared = currVal * currVal;
      if (currValSquared > upperBound) {
        break;
      }
      if (currValSquared >= lowerBound && isPalindrome(currValSquared)) {
        result++;
      }
    }

    for (int k = 1; k < MAX_POSSIBLE; ++k) {
      StringBuilder sb = new StringBuilder(Integer.toString(k));
      for (int i = sb.length() - 1; i >= 0; --i) {
        sb.append(sb.charAt(i));
      }
      long currVal = Long.parseLong(sb.toString());
      long currValSquared = currVal * currVal;
      if (currValSquared > upperBound) {
        break;
      }
      if (currValSquared >= lowerBound && isPalindrome(currValSquared)) {
        result++;
      }
    }

    return result;
  }

  public boolean isPalindrome(long x) {
    return x == reverse(x);
  }

  public long reverse(long x) {
    long ans = 0;
    while (x > 0) {
      ans = 10 * ans + x % 10;
      x /= 10;
    }

    return ans;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
