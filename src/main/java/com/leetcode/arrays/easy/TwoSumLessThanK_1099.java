package com.leetcode.arrays.easy;

// Given an array A of integers and integer K, return the maximum S such that the
// re exists i < j with A[i] + A[j] = S and S < K. If no i, j exist satisfying this
// equation, return -1.
//
//
// Example 1:
//
//
// Input: A = [34,23,1,24,75,33,54,8], K = 60
// Output: 58
// Explanation: We can use 34 and 24 to sum 58 which is less than 60.
//
// Example 2:
//
//
// Input: A = [10,20,30], K = 15
// Output: -1
// Explanation: In this case it is not possible to get a pair sum less that 15.
//
//
// Constraints:
//
//
// 1 <= A.length <= 100
// 1 <= A[i] <= 1000
// 1 <= K <= 2000
//
// Related Topics Array Two Pointers Sort
// 👍 394 👎 43

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.Arrays;
/*
 O(nlog(n)) Runtime: 1 ms, faster than 100.00% of Java online submissions for Two Sum Less Than K.
 O(sort)  Memory Usage: 38.9 MB, less than 7.01% of Java online submissions for Two Sum Less Than K.
*/
public class TwoSumLessThanK_1099 {
  public int twoSumLessThanK(int[] A, int K) {
    Arrays.sort(A);

    int left = 0;
    int right = A.length - 1;
    int max = -1;

    while (left < right) {
      if (A[left] + A[right] < K) {
        max = Math.max(max, A[left] + A[right]);
        left++;
      } else {
        right--;
      }
    }

    return max;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
