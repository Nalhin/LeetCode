package com.leetcode.arrays.easy;

// Given an array arr of positive integers sorted in a strictly increasing order,
// and an integer k.
//
// Find the kth positive integer that is missing from this array.
//
//
// Example 1:
//
//
// Input: arr = [2,3,4,7,11], k = 5
// Output: 9
// Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5
// th missing positive integer is 9.
//
//
// Example 2:
//
//
// Input: arr = [1,2,3,4], k = 2
// Output: 6
// Explanation: The missing positive integers are [5,6,7,...]. The 2nd missing po
// sitive integer is 6.
//
//
//
// Constraints:
//
//
// 1 <= arr.length <= 1000
// 1 <= arr[i] <= 1000
// 1 <= k <= 1000
// arr[i] < arr[j] for 1 <= i < j <= arr.length
// Related Topics Array Hash Table
// 👍 521 👎 17
/*
 O(log(n)) Runtime: 0 ms, faster than 100.00% of Java online submissions for Kth Missing Positive Number.
 O(1) Memory Usage: 38.7 MB, less than 59.54% of Java online submissions for Kth Missing Positive Number.
*/
// leetcode submit region begin(Prohibit modification and deletion)
public class KthMissingPositiveNumber_1539 {
  public int findKthPositive(int[] arr, int k) {
    int left = 0;
    int right = arr.length - 1;

    while (left <= right) {
      int mid = left + (right - left) / 2;

      if (arr[mid] - mid - 1 < k) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return left + k;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
