package com.leetcode.arrays.easy;
// Given a fixed length array arr of integers, duplicate each occurrence of zero,
// shifting the remaining elements to the right.
//
// Note that elements beyond the length of the original array are not written.
//
// Do the above modifications to the input array in place, do not return anythin
// g from your function.
//
//
//
// Example 1:
//
//
// Input: [1,0,2,3,0,4,5,0]
// Output: null
// Explanation: After calling your function, the input array is modified to: [1,0
// ,0,2,3,0,0,4]
//
//
// Example 2:
//
//
// Input: [1,2,3]
// Output: null
// Explanation: After calling your function, the input array is modified to: [1,2
// ,3]
//
//
//
//
// Note:
//
//
// 1 <= arr.length <= 10000
// 0 <= arr[i] <= 9
// Related Topics Array
// 👍 583 👎 225

import java.util.ArrayDeque;
import java.util.Queue;

// leetcode submit region begin(Prohibit modification and deletion)
public class DuplicateZeros_1089 {
  public void duplicateZeros(int[] arr) {
    Queue<Integer> stack = new ArrayDeque<>();

    for (int i = 0; i < arr.length; i++) {
      stack.add(arr[i]);
      if (arr[i] == 0) {
        stack.add(0);
      }
      arr[i] = stack.remove();
    }
  }
}

/*
    Runtime: 2 ms, faster than 63.22% of Java online submissions for Duplicate Zeros.
    Memory Usage: 39.4 MB, less than 91.80% of Java online submissions for Duplicate Zeros.
*/
// leetcode submit region end(Prohibit modification and deletion)
