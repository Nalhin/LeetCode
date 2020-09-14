package com.leetcode.arrays.easy;
// Given an array of integers A sorted in non-decreasing order, return an array o
// f the squares of each number, also in sorted non-decreasing order.
//
//
//
//
// Example 1:
//
//
// Input: [-4,-1,0,3,10]
// Output: [0,1,9,16,100]
//
//
//
// Example 2:
//
//
// Input: [-7,-3,2,3,11]
// Output: [4,9,9,49,121]
//
//
//
//
// Note:
//
//
// 1 <= A.length <= 10000
// -10000 <= A[i] <= 10000
// A is sorted in non-decreasing order.
//
//
// Related Topics Array Two Pointers
// 👍 1407 👎 95

// leetcode submit region begin(Prohibit modification and deletion)
public class SquaresOfASortedArray_977 {
  public int[] sortedSquares(int[] array) {

    int left = 0;
    int right = array.length - 1;

    int[] result = new int[array.length];

    for (int i = array.length - 1; i >= 0; i--) {
      if (Math.abs(array[left]) < Math.abs(array[right])) {
        result[i] = (int) Math.pow(array[right--], 2);
      } else {
        result[i] = (int) Math.pow(array[left++], 2);
      }
    }

    return result;
  }
}

/*
   Runtime: 3 ms, faster than 34.04% of Java online submissions for Squares of a Sorted Array.
   Memory Usage: 53.2 MB, less than 16.06% of Java online submissions for Squares of a Sorted Array.
*/
// leetcode submit region end(Prohibit modification and deletion)
