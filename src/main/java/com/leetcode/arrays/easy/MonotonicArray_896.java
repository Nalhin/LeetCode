package com.leetcode.arrays.easy;

// An array is monotonic if it is either monotone increasing or monotone decreasi
// ng.
//
// An array A is monotone increasing if for all i <= j, A[i] <= A[j]. An array A
// is monotone decreasing if for all i <= j, A[i] >= A[j].
//
// Return true if and only if the given array A is monotonic.
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
// Input: [1,2,2,3]
// Output: true
//
//
//
// Example 2:
//
//
// Input: [6,5,4,4]
// Output: true
//
//
//
// Example 3:
//
//
// Input: [1,3,2]
// Output: false
//
//
//
// Example 4:
//
//
// Input: [1,2,4,5]
// Output: true
//
//
//
// Example 5:
//
//
// Input: [1,1,1]
// Output: true
//
//
//
//
// Note:
//
//
// 1 <= A.length <= 50000
// -100000 <= A[i] <= 100000
//
//
//
//
//
//
// Related Topics Array
// 👍 874 👎 40

// leetcode submit region begin(Prohibit modification and deletion)
/*
O(n) Runtime: 1 ms, faster than 100.00% of Java online submissions for Monotonic Array.
O(1) Memory Usage: 47.4 MB, less than 76.68% of Java online submissions for Monotonic Array.
*/
public class MonotonicArray_896 {
  public boolean isMonotonic(int[] A) {

    int diff = 0;

    for (int i = 1; i < A.length; i++) {
      int currMinusPrev = A[i] - A[i - 1];

      if (currMinusPrev > 0 && diff < 0) {
        return false;
      }
      if (currMinusPrev < 0 && diff > 0) {
        return false;
      }

      if (currMinusPrev != 0) {
        diff = currMinusPrev;
      }
    }

    return true;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
