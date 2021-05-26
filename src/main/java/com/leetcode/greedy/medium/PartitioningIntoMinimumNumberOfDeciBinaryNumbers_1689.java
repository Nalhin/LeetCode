package com.leetcode.greedy.medium;

// A decimal number is called deci-binary if each of its digits is either 0 or 1
// without any leading zeros. For example, 101 and 1100 are deci-binary, while 112
// and 3001 are not.
//
// Given a string n that represents a positive decimal integer, return the minim
// um number of positive deci-binary numbers needed so that they sum up to n.
//
//
// Example 1:
//
//
// Input: n = "32"
// Output: 3
// Explanation: 10 + 11 + 11 = 32
//
//
// Example 2:
//
//
// Input: n = "82734"
// Output: 8
//
//
// Example 3:
//
//
// Input: n = "27346209830709182346"
// Output: 9
//
//
//
// Constraints:
//
//
// 1 <= n.length <= 105
// n consists of only digits.
// n does not contain any leading zeros and represents a positive integer.
// Related Topics Greedy
// 👍 292 👎 240
/*
 O(n) Runtime: 17 ms, faster than 12.68% of Java online submissions for Partitioning Into Minimum Number Of Deci-Binary Numbers.
 O(1) Memory Usage: 39.2 MB, less than 94.91% of Java online submissions for Partitioning Into Minimum Number Of Deci-Binary Numbers.
*/
// leetcode submit region begin(Prohibit modification and deletion)

public class PartitioningIntoMinimumNumberOfDeciBinaryNumbers_1689 {
  public int minPartitions(String str) {
    return str.chars().map(Character::getNumericValue).max().orElse(0);
  }
}
// leetcode submit region end(Prohibit modification and deletion)
