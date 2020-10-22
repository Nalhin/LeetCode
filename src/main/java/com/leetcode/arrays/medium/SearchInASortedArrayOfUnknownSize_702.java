package com.leetcode.arrays.medium;

// Given an integer array sorted in ascending order, write a function to search t
// arget in nums. If target exists, then return its index, otherwise return -1. How
// ever, the array size is unknown to you. You may only access the array using an A
// rrayReader interface, where ArrayReader.get(k) returns the element of the array
// at index k (0-indexed).
//
// You may assume all integers in the array are less than 10000, and if you acce
// ss the array out of bounds, ArrayReader.get will return 2147483647.
//
//
//
// Example 1:
//
//
// Input: array = [-1,0,3,5,9,12], target = 9
// Output: 4
// Explanation: 9 exists in nums and its index is 4
//
//
// Example 2:
//
//
// Input: array = [-1,0,3,5,9,12], target = 2
// Output: -1
// Explanation: 2 does not exist in nums so return -1
//
//
//
// Constraints:
//
//
// You may assume that all elements in the array are unique.
// The value of each element in the array will be in the range [-9999, 9999].
// The length of the array will be in the range [1, 10^4].
//
// Related Topics Binary Search
// 👍 374 👎 28

// leetcode submit region begin(Prohibit modification and deletion)
/**
 * // This is ArrayReader's API interface. // You should not implement it, or speculate about its
 * implementation interface ArrayReader { public int get(int index) {} }
 */

/*
 O(log(n)) Runtime: 1 ms, faster than 100.00% of Java online submissions for Search in a Sorted Array of Unknown Size.
 O(1) Memory Usage: 40.2 MB, less than 17.17% of Java online submissions for Search in a Sorted Array of Unknown Size.
*/
public class SearchInASortedArrayOfUnknownSize_702 {
  public int search(ArrayReader reader, int target) {
    int left = 0;
    int right = 1;

    while (reader.get(right) != Integer.MAX_VALUE) {
      left = right;
      right *= 10;
    }

    while (left <= right) {
      int mid = (left + right) >> 1;
      int midVal = reader.get(mid);

      if (midVal != Integer.MAX_VALUE && reader.get(mid + 1) == Integer.MAX_VALUE) {
        right = mid;
        break;
      } else if (midVal == Integer.MAX_VALUE) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }

    left = 0;

    while (left <= right) {
      int mid = (left + right) >> 1;
      int midVal = reader.get(mid);
      if (midVal == target) {
        return mid;
      } else if (midVal > target) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }

    return -1;
  }

  interface ArrayReader {
    int get(int index);
  }
}
// leetcode submit region end(Prohibit modification and deletion)
