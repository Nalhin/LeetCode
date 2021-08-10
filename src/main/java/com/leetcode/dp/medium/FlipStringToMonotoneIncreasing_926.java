package com.leetcode.dp.medium;

// A binary string is monotone increasing if it consists of some number of 0's (p
// ossibly none), followed by some number of 1's (also possibly none).
//
// You are given a binary string s. You can flip s[i] changing it from 0 to 1 or
// from 1 to 0.
//
// Return the minimum number of flips to make s monotone increasing.
//
//
// Example 1:
//
//
// Input: s = "00110"
// Output: 1
// Explanation: We flip the last digit to get 00111.
//
//
// Example 2:
//
//
// Input: s = "010110"
// Output: 2
// Explanation: We flip to get 011111, or alternatively 000111.
//
//
// Example 3:
//
//
// Input: s = "00011000"
// Output: 2
// Explanation: We flip to get 00000000.
//
//
//
// Constraints:
//
//
// 1 <= s.length <= 105
// s[i] is either '0' or '1'.
//
// Related Topics String Dynamic Programming
// 👍 1097 👎 30
/*
 O(n) Runtime: 15 ms, faster than 9.43% of Java online submissions for Flip String to Monotone Increasing.
 O(1) Memory Usage: 39.8 MB, less than 21.07% of Java online submissions for Flip String to Monotone Increasing.
*/
// leetcode submit region begin(Prohibit modification and deletion)

public class FlipStringToMonotoneIncreasing_926 {
  public int minFlipsMonoIncr(String s) {

    int zeroes = 0;
    for (int i = 0; i < s.length(); i++) {
      zeroes += s.charAt(i) == '0' ? 1 : 0;
    }

    int result = zeroes;
    int ones = 0;
    for (int i = 0; i < s.length(); i++) {
      zeroes -= s.charAt(i) == '0' ? 1 : 0;
      ones += s.charAt(i) == '1' ? 1 : 0;

      result = Math.min(zeroes + ones, result);
    }

    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
