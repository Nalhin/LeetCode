package com.leetcode.bitmanipulation.medium;

// An n-bit gray code sequence is a sequence of 2n integers where:
//
//
// Every integer is in the inclusive range [0, 2n - 1],
// The first integer is 0,
// An integer appears no more than once in the sequence,
// The binary representation of every pair of adjacent integers differs by exact
// ly one bit, and
// The binary representation of the first and last integers differs by exactly o
// ne bit.
//
//
// Given an integer n, return any valid n-bit gray code sequence.
//
//
// Example 1:
//
//
// Input: n = 2
// Output: [0,1,3,2]
// Explanation:
// The binary representation of [0,1,3,2] is [00,01,11,10].
// - 00 and 01 differ by one bit
// - 01 and 11 differ by one bit
// - 11 and 10 differ by one bit
// - 10 and 00 differ by one bit
// [0,2,3,1] is also a valid gray code sequence, whose binary representation is [
// 00,10,11,01].
// - 00 and 10 differ by one bit
// - 10 and 11 differ by one bit
// - 11 and 01 differ by one bit
// - 01 and 00 differ by one bit
//
//
// Example 2:
//
//
// Input: n = 1
// Output: [0,1]
//
//
//
// Constraints:
//
//
// 1 <= n <= 16
//
// Related Topics Math Backtracking Bit Manipulation
// 👍 1062 👎 1985
/*
 O(2^n) Runtime: 5 ms, faster than 73.30% of Java online submissions for Gray Code.
 O(2^n) Memory Usage: 46.4 MB, less than 58.18% of Java online submissions for Gray Code.
*/
// leetcode submit region begin(Prohibit modification and deletion)

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GrayCode_89 {
  public List<Integer> grayCode(int n) {
    return IntStream.range(0, 1 << n).map(i -> i ^ i >> 1).boxed().collect(Collectors.toList());
  }
}
// leetcode submit region end(Prohibit modification and deletion)
