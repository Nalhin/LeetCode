package com.leetcode.arrays.easy;

// Given an array A of integers, return true if and only if it is a valid mountai
// n array.
//
// Recall that A is a mountain array if and only if:
//
//
// A.length >= 3
// There exists some i with 0 < i < A.length - 1 such that:
//
// A[0] < A[1] < ... A[i-1] < A[i]
// A[i] > A[i+1] > ... > A[A.length - 1]
//
//
//
//
//
//
//
//
//
// Example 1:
//
//
// Input: [2,1]
// Output: false
//
//
//
// Example 2:
//
//
// Input: [3,5,5]
// Output: false
//
//
//
// Example 3:
//
//
// Input: [0,3,2,1]
// Output: true
//
//
//
//
//
// Note:
//
//
// 0 <= A.length <= 10000
// 0 <= A[i] <= 10000
//
//
//
//
//
//
//
//
// Related Topics Array
// 👍 488 👎 75

// leetcode submit region begin(Prohibit modification and deletion)

public class ValidMountainArray_941 {
  public boolean validMountainArray(int[] A) {
    if (A.length < 3) {
      return false;
    }
    boolean peakReached = A[1] < A[0];

    if (peakReached) {
      return false;
    }

    for (int i = 1; i < A.length; i++) {
      int diff = A[i] - A[i - 1];

      if (diff == 0) {
        return false;
      }

      if (peakReached) {
        if (diff > 0) {
          return false;
        }
      } else if (diff < 0) {
        peakReached = true;
      }
    }

    return peakReached;
  }
}
/*
   Runtime: 4 ms, faster than 9.09% of Java online submissions for Valid Mountain Array.
   Memory Usage: 39.7 MB, less than 99.57% of Java online submissions for Valid Mountain Array.
*/
// leetcode submit region end(Prohibit modification and deletion)
