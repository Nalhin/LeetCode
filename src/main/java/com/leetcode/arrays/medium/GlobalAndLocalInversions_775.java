package com.leetcode.arrays.medium;

// We have some permutation A of [0, 1, ..., N - 1], where N is the length of A.
//
//
// The number of (global) inversions is the number of i < j with 0 <= i < j < N
// and A[i] > A[j].
//
// The number of local inversions is the number of i with 0 <= i < N and A[i] >
// A[i+1].
//
// Return true if and only if the number of global inversions is equal to the nu
// mber of local inversions.
//
// Example 1:
//
//
// Input: A = [1,0,2]
// Output: true
// Explanation: There is 1 global inversion, and 1 local inversion.
//
//
// Example 2:
//
//
// Input: A = [1,2,0]
// Output: false
// Explanation: There are 2 global inversions, and 1 local inversion.
//
//
// Note:
//
//
// A will be a permutation of [0, 1, ..., A.length - 1].
// A will have length in range [1, 5000].
// The time limit for this problem has been reduced.
//
// Related Topics Array Math
// 👍 616 👎 212
/*
  O(n) Runtime: 1 ms, faster than 96.92% of Java online submissions for Global and Local Inversions.
  O(1) Memory Usage: 39.7 MB, less than 32.92% of Java online submissions for Global and Local Inversions.
*/
// leetcode submit region begin(Prohibit modification and deletion)

public class GlobalAndLocalInversions_775 {
  public boolean isIdealPermutation(int[] arr) {
    int max = 0;
    for (int i = 0; i < arr.length - 2; ++i) {
      max = Math.max(max, arr[i]);
      if (max > arr[i + 2]) {
        return false;
      }
    }
    return true;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
