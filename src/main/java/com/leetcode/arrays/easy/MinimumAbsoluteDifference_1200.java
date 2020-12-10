package com.leetcode.arrays.easy;

// Given an array of distinct integers arr, find all pairs of elements with the m
// inimum absolute difference of any two elements.
//
// Return a list of pairs in ascending order(with respect to pairs), each pair [
// a, b] follows
//
//
// a, b are from arr
// a < b
// b - a equals to the minimum absolute difference of any two elements in arr
//
//
//
// Example 1:
//
//
// Input: arr = [4,2,1,3]
// Output: [[1,2],[2,3],[3,4]]
// Explanation: The minimum absolute difference is 1. List all pairs with differe
// nce equal to 1 in ascending order.
//
// Example 2:
//
//
// Input: arr = [1,3,6,10,15]
// Output: [[1,3]]
//
//
// Example 3:
//
//
// Input: arr = [3,8,-10,23,19,-4,-14,27]
// Output: [[-14,-10],[19,23],[23,27]]
//
//
//
// Constraints:
//
//
// 2 <= arr.length <= 10^5
// -10^6 <= arr[i] <= 10^6
//
// Related Topics Array
// 👍 453 👎 25

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
 O(nlog(n))  Runtime: 14 ms, faster than 98.37% of Java online submissions for Minimum Absolute Difference.
 O(n)        Memory Usage: 49.6 MB, less than 92.38% of Java online submissions for Minimum Absolute Difference.
*/
public class MinimumAbsoluteDifference_1200 {
  public List<List<Integer>> minimumAbsDifference(int[] arr) {
    Arrays.sort(arr);

    int min = Integer.MAX_VALUE;
    List<List<Integer>> result = new ArrayList<>();

    int prev = arr[0];
    for (int i = 1; i < arr.length; i++) {
      min = Math.min(arr[i] - prev, min);
      prev = arr[i];
    }

    prev = arr[0];
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] - prev == min) {
        result.add(List.of(prev, arr[i]));
      }
      prev = arr[i];
    }

    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
