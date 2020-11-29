package com.leetcode.strings.medium;

// The numeric value of a lowercase character is defined as its position (1-index
// ed) in the alphabet, so the numeric value of a is 1, the numeric value of b is 2
// , the numeric value of c is 3, and so on.
//
// The numeric value of a string consisting of lowercase characters is defined a
// s the sum of its characters' numeric values. For example, the numeric value of t
// he string "abe" is equal to 1 + 2 + 5 = 8.
//
// You are given two integers n and k. Return the lexicographically smallest str
// ing with length equal to n and numeric value equal to k.
//
// Note that a string x is lexicographically smaller than string y if x comes be
// fore y in dictionary order, that is, either x is a prefix of y, or if i is the f
// irst position such that x[i] != y[i], then x[i] comes before y[i] in alphabetic
// order.
//
//
// Example 1:
//
//
// Input: n = 3, k = 27
// Output: "aay"
// Explanation: The numeric value of the string is 1 + 1 + 25 = 27, and it is the
// smallest string with such a value and length equal to 3.
//
//
// Example 2:
//
//
// Input: n = 5, k = 73
// Output: "aaszz"
//
//
//
// Constraints:
//
//
// 1 <= n <= 105
// n <= k <= 26 * n
//
// Related Topics Greedy
// 👍 116 👎 3

// leetcode submit region begin(Prohibit modification and deletion)

/*
  O(n) Runtime: 21 ms, faster than 66.49% of Java online submissions for Smallest String With A Given Numeric Value.
  O(n) Memory Usage: 38.9 MB, less than 79.03% of Java online submissions for Smallest String With A Given Numeric Value.
*/
public class SmallestStringWithAGivenNumericValue_1663 {
  public String getSmallestString(int n, int k) {
    StringBuilder result = new StringBuilder(n);

    while (n < k) {
      result.append((char) (Math.min(k - n, 25) + 'a'));
      k -= 26;
      n--;
    }

    result.append("a".repeat(Math.max(0, n)));

    return result.reverse().toString();
  }
}
// leetcode submit region end(Prohibit modification and deletion)
