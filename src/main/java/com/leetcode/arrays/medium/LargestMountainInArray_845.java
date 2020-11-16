package com.leetcode.arrays.medium;

// Let's call any (contiguous) subarray B (of A) a mountain if the following prop
// erties hold:
//
//
// B.length >= 3
// There exists some 0 < i < B.length - 1 such that B[0] < B[1] < ... B[i-1] < B
// [i] > B[i+1] > ... > B[B.length - 1]
//
//
// (Note that B could be any subarray of A, including the entire array A.)
//
// Given an array A of integers, return the length of the longest mountain.
//
// Return 0 if there is no mountain.
//
// Example 1:
//
//
// Input: [2,1,4,7,3,2,5]
// Output: 5
// Explanation: The largest mountain is [1,4,7,3,2] which has length 5.
//
//
// Example 2:
//
//
// Input: [2,2,2]
// Output: 0
// Explanation: There is no mountain.
//
//
// Note:
//
//
// 0 <= A.length <= 10000
// 0 <= A[i] <= 10000
//
//
// Follow up:
//
//
// Can you solve it using only one pass?
// Can you solve it in O(1) space?
//
// Related Topics Two Pointers
// 👍 868 👎 38

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(n) Runtime: 2 ms, faster than 85.14% of Java online submissions for Longest Mountain in Array.
 O(1) Memory Usage: 40.2 MB, less than 36.85% of Java online submissions for Longest Mountain in Array.
*/
public class LargestMountainInArray_845 {
  public int longestMountain(int[] A) {

    int max = 0;
    int curr = 1;
    int index = 1;
    while (index < A.length) {

      boolean increased = false;
      boolean decreased = false;

      while (index < A.length && A[index - 1] < A[index]) {
        index++;
        curr++;
        increased = true;
      }

      while (index < A.length && A[index - 1] > A[index]) {
        index++;
        curr++;
        decreased = true;
      }

      while (index < A.length && A[index - 1] == A[index]) {
        index++;
      }

      if (increased && decreased) {
        max = Math.max(curr, max);
      }

      curr = 1;
    }
    return max;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
