package com.leetcode.easy;

// Determine whether an integer is a palindrome. An integer is a palindrome when
// it reads the same backward as forward.
//
// Follow up: Could you solve it without converting the integer to a string?
//
//
// Example 1:
//
//
// Input: x = 121
// Output: true
//
//
// Example 2:
//
//
// Input: x = -121
// Output: false
// Explanation: From left to right, it reads -121. From right to left, it becomes
// 121-. Therefore it is not a palindrome.
//
//
// Example 3:
//
//
// Input: x = 10
// Output: false
// Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
//
//
// Example 4:
//
//
// Input: x = -101
// Output: false
//
//
//
// Constraints:
//
//
// -231 <= x <= 231 - 1
//
// Related Topics Math
// 👍 2623 👎 1616

// leetcode submit region begin(Prohibit modification and deletion)
public class PalindromeNumber_9 {
  public boolean isPalindrome(int x) {
    if (x < 0) {
      return false;
    }

    int original = x;
    int reversed = 0;

    while (original != 0) {
      reversed = reversed * 10 + original % 10;
      original /= 10;
    }

    return reversed == x;
  }
}
/*
 O(m) Runtime: 7 ms, faster than 73.50% of Java online submissions for Palindrome Number.
 O(1) Memory Usage: 38.1 MB, less than 98.63% of Java online submissions for Palindrome Number.
 where:
  m - log10(x) + 1
*/
// leetcode submit region end(Prohibit modification and deletion)
