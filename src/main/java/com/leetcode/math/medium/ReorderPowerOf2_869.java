package com.leetcode.math.medium;

// Starting with a positive integer N, we reorder the digits in any order (includ
// ing the original order) such that the leading digit is not zero.
//
// Return true if and only if we can do this in a way such that the resulting nu
// mber is a power of 2.
//
//
//
//
//
//
//
// Example 1:
//
//
// Input: 1
// Output: true
//
//
//
// Example 2:
//
//
// Input: 10
// Output: false
//
//
//
// Example 3:
//
//
// Input: 16
// Output: true
//
//
//
// Example 4:
//
//
// Input: 24
// Output: false
//
//
//
// Example 5:
//
//
// Input: 46
// Output: true
//
//
//
//
// Note:
//
//
// 1 <= N <= 10^9
//
//
//
//
//
//
// Related Topics Math
// 👍 306 👎 109
/*
 O(log(n)) Runtime: 1 ms, faster than 96.64% of Java online submissions for Reordered Power of 2.
 O(1) Memory Usage: 35.8 MB, less than 82.35% of Java online submissions for Reordered Power of 2.
*/
import java.util.Arrays;

// leetcode submit region begin(Prohibit modification and deletion)
public class ReorderPowerOf2_869 {
  public boolean reorderedPowerOf2(int n) {
    int[] digitsOfN = countDigits(n);
    for (int i = 0; i < 31; i++) {
      int num = 1 << i;
      if (Arrays.equals(digitsOfN, countDigits(num))) {
        return true;
      }
    }
    return false;
  }

  private int[] countDigits(int n) {
    int[] counter = new int[10];

    while (n > 0) {
      counter[n % 10]++;
      n /= 10;
    }

    return counter;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
