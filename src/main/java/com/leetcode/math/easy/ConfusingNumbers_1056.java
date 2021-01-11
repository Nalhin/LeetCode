package com.leetcode.math.easy;

// Given a number N, return true if and only if it is a confusing number, which s
// atisfies the following condition:
//
// We can rotate digits by 180 degrees to form new digits. When 0, 1, 6, 8, 9 ar
// e rotated 180 degrees, they become 0, 1, 9, 8, 6 respectively. When 2, 3, 4, 5 a
// nd 7 are rotated 180 degrees, they become invalid. A confusing number is a numbe
// r that when rotated 180 degrees becomes a different number with each digit valid
// .
//
//
//
// Example 1:
//
//
//
//
// Input: 6
// Output: true
// Explanation:
// We get 9 after rotating 6, 9 is a valid number and 9!=6.
//
//
// Example 2:
//
//
//
//
// Input: 89
// Output: true
// Explanation:
// We get 68 after rotating 89, 86 is a valid number and 86!=89.
//
//
// Example 3:
//
//
//
//
// Input: 11
// Output: false
// Explanation:
// We get 11 after rotating 11, 11 is a valid number but the value remains the sa
// me, thus 11 is not a confusing number.
//
//
// Example 4:
//
//
//
//
// Input: 25
// Output: false
// Explanation:
// We get an invalid number after rotating 25.
//
//
//
//
// Note:
//
//
// 0 <= N <= 10^9
// After the rotation we can ignore leading zeros, for example if after rotation
// we have 0008 then this number is considered as just 8.
// Related Topics Math
// 👍 96 👎 72
/*
 O(log(n)) Runtime: 0 ms, faster than 100.00% of Java online submissions for Confusing Number.
 O(1) Memory Usage: 37.9 MB, less than 6.51% of Java online submissions for Confusing Number.
*/
// leetcode submit region begin(Prohibit modification and deletion)

public class ConfusingNumbers_1056 {
  private final int[] mappings = {0, 1, -1, -1, -1, -1, 9, -1, 8, 6};

  public boolean confusingNumber(int n) {

    int pow = 1;
    int nCurr = n;
    while (nCurr >= 10) {
      pow *= 10;
      nCurr /= 10;
    }
    nCurr = n;

    int curr = 0;
    while (nCurr > 0) {
      int mapping = mappings[nCurr % 10];

      if (mapping == -1) {
        return false;
      }

      curr = curr + mapping * pow;
      nCurr /= 10;
      pow /= 10;
    }

    return curr != n;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
