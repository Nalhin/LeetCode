package com.leetcode.arrays.easy;

// Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one
// sorted array.
//
// Note:
//
//
// The number of elements initialized in nums1 and nums2 are m and n respectivel
// y.
// You may assume that nums1 has enough space (size that is equal to m + n) to h
// old additional elements from nums2.
//
//
// Example:
//
//
// Input:
// nums1 = [1,2,3,0,0,0], m = 3
// nums2 = [2,5,6],       n = 3
//
// Output: [1,2,2,3,5,6]
//
//
//
// Constraints:
//
//
// -10^9 <= nums1[i], nums2[i] <= 10^9
// nums1.length == m + n
// nums2.length == n
//
// Related Topics Array Two Pointers
// 👍 2551 👎 4389

// leetcode submit region begin(Prohibit modification and deletion)
public class MergeSortedArray_88 {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int n1 = m - 1;
    int n2 = n - 1;

    for (int i = nums1.length - 1; n2 >= 0 && n1 >= 0; i--) {
      if (nums1[n1] > nums2[n2]) {
        nums1[i] = nums1[n1--];
      } else {
        nums1[i] = nums2[n2--];
      }
    }

    for (int i = n2; i >= 0; i--) {
      nums1[i] = nums2[n2--];
    }
  }
}
/*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Merge Sorted Array.
    Memory Usage: 39.7 MB, less than 50.13% of Java online submissions for Merge Sorted Array.
*/

// leetcode submit region end(Prohibit modification and deletion)
