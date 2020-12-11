package com.leetcode.math.medium;
/*
 O(nlog(n)) Runtime: 1048 ms, faster than 25.98% of Java online submissions for Concatenation of Consecutive Binary Numbers.
 O(m)       Memory Usage: 47.3 MB, less than 22.68% of Java online submissions for Concatenation of Consecutive Binary Numbers.
*/
public class ConcatenationOfConsecutiveBinaryNumbers_1680 {

  private final int MOD = 1000000007;

  public int concatenatedBinary(int n) {
    int result = 0;

    int prevPow = 1;
    for (int i = n; i >= 0; i--) {
      String intAsBinary = Integer.toBinaryString(i);
      for (int j = intAsBinary.length() - 1; j >= 0; j--) {
        if (intAsBinary.charAt(j) == '1') {
          result = (result + prevPow) % MOD;
        }
        prevPow = (prevPow * 2) % MOD;
      }
    }

    return result;
  }
}
