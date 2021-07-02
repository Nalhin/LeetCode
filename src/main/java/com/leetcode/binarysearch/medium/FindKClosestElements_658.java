package com.leetcode.binarysearch.medium;

// Given a sorted integer array arr, two integers k and x, return the k closest i
// ntegers to x in the array. The result should also be sorted in ascending order.
//
//
// An integer a is closer to x than an integer b if:
//
//
// |a - x| < |b - x|, or
// |a - x| == |b - x| and a < b
//
//
//
// Example 1:
// Input: arr = [1,2,3,4,5], k = 4, x = 3
// Output: [1,2,3,4]
// Example 2:
// Input: arr = [1,2,3,4,5], k = 4, x = -1
// Output: [1,2,3,4]
//
//
// Constraints:
//
//
// 1 <= k <= arr.length
// 1 <= arr.length <= 104
// arr is sorted in ascending order.
// -104 <= arr[i], x <= 104
//
// Related Topics Array Two Pointers Binary Search Sorting Heap (Priority Queue)
//
// 👍 2409 👎 342

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;

public class FindKClosestElements_658 {
  /*
    O(log(n) + k) Runtime: 6 ms, faster than 47.54% of Java online submissions for Find K Closest Elements.
    O(k) Memory Usage: 40.3 MB, less than 95.98% of Java online submissions for Find K Closest Elements.
  */
  static class TwoPointers {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
      Deque<Integer> result = new ArrayDeque<>();

      int pos = Arrays.binarySearch(arr, x);
      if (pos < 0) {
        pos = -(pos + 1);
      }

      int left = pos - 1;
      int right = pos;

      while (k > 0) {
        if (left < 0) {
          result.addLast(arr[right]);
          right++;
        } else if (right >= arr.length || Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
          result.addFirst(arr[left]);
          left--;
        } else {
          result.addLast(arr[right]);
          right++;
        }

        k--;
      }

      return new ArrayList<>(result);
    }
  }
  /*
    O(log(n - k) + k) Runtime: 3 ms, faster than 96.95% of Java online submissions for Find K Closest Elements.
    O(k) Memory Usage: 40.6 MB, less than 78.15% of Java online submissions for Find K Closest Elements
  */
  static class BinarySearch {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
      int left = 0;
      int right = arr.length - k;

      while (left < right) {
        int mid = left + (right - left) / 2;

        if (x - arr[mid] > arr[mid + k] - x) {
          left = mid + 1;
        } else {
          right = mid;
        }
      }

      List<Integer> result = new ArrayList<>();
      for (int i = left; i < left + k; i++) {
        result.add(arr[i]);
      }

      return result;
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
