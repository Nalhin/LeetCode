package com.leetcode.greedy.medium;

// Given string num representing a non-negative integer num, and an integer k,
// return the smallest possible integer after removing k digits from num.
//
//
// Example 1:
//
//
// Input: num = "1432219", k = 3
// Output: "1219"
// Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219
// which is the smallest.
//
//
// Example 2:
//
//
// Input: num = "10200", k = 1
// Output: "200"
// Explanation: Remove the leading 1 and the number is 200. Note that the output
// must not contain leading zeroes.
//
//
// Example 3:
//
//
// Input: num = "10", k = 2
// Output: "0"
// Explanation: Remove all the digits from the number and it is left with
// nothing which is 0.
//
//
//
// Constraints:
//
//
// 1 <= k <= num.length <= 10⁵
// num consists of only digits.
// num does not have any leading zeros except for the zero itself.
//
// Related Topics String Stack Greedy Monotonic Stack 👍 5559 👎 233
/*
 O(n) Runtime: 16 ms, faster than 54.17% of Java online submissions for Remove K Digits.
 O(n) Memory Usage: 43.8 MB, less than 40.94% of Java online submissions for Remove K Digits.
*/
// leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveKDigits_402 {
  public String removeKdigits(String num, int k) {

    Deque<Character> stack = new ArrayDeque<>();

    for (int i = 0; i < num.length(); i++) {

      char currChar = num.charAt(i);
      if (currChar == '0' && stack.size() <= k) {
        k -= stack.size();
        stack.clear();
        continue;
      }

      while (k > 0 && !stack.isEmpty() && stack.peek() > currChar) {
        stack.pop();
        k--;
      }

      stack.push(currChar);
    }

    StringBuilder sb = new StringBuilder();

    while (!stack.isEmpty()) {
      char c = stack.pop();

      if (k <= 0) {
        sb.append(c);
      } else {
        k--;
      }
    }

    return sb.length() == 0 ? "0" : sb.reverse().toString();
  }
}
// leetcode submit region end(Prohibit modification and deletion)
