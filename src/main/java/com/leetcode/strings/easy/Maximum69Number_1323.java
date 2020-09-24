package com.leetcode.strings.easy;

// Given a positive integer num consisting only of digits 6 and 9.
//
// Return the maximum number you can get by changing at most one digit (6 become
// s 9, and 9 becomes 6).
//
//
// Example 1:
//
//
// Input: num = 9669
// Output: 9969
// Explanation:
// Changing the first digit results in 6669.
// Changing the second digit results in 9969.
// Changing the third digit results in 9699.
// Changing the fourth digit results in 9666.
// The maximum number is 9969.
//
//
// Example 2:
//
//
// Input: num = 9996
// Output: 9999
// Explanation: Changing the last digit 6 to 9 results in the maximum number.
//
// Example 3:
//
//
// Input: num = 9999
// Output: 9999
// Explanation: It is better not to apply any change.
//
//
// Constraints:
//
//
// 1 <= num <= 10^4
// num's digits are 6 or 9.
// Related Topics Math
// 👍 358 👎 57

// leetcode submit region begin(Prohibit modification and deletion)

public class Maximum69Number_1323 {
  public int maximum69Number(int num) {
    char[] nums = Integer.toString(num).toCharArray();

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == '6') {
        nums[i] = '9';
        break;
      }
    }

    return Integer.parseInt(String.valueOf(nums));
  }
}

/*
  O(n) Runtime: 1 ms, faster than 62.40% of Java online submissions for Maximum 69 Number.
  O(n) Memory Usage: 38.2 MB, less than 15.61% of Java online submissions for Maximum 69 Numb
 */
// leetcode submit region end(Prohibit modification and deletion)
