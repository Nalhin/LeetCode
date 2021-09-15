package com.leetcode.arrays.medium;

// Given an integer array arr, return the length of a maximum size turbulent
// subarray of arr.
//
// A subarray is turbulent if the comparison sign flips between each adjacent
// pair of elements in the subarray.
//
// More formally, a subarray [arr[i], arr[i + 1], ..., arr[j]] of arr is said
// to be turbulent if and only if:
//
//
// For i <= k < j:
//
//
// arr[k] > arr[k + 1] when k is odd, and
// arr[k] < arr[k + 1] when k is even.
//
//
// Or, for i <= k < j:
//
// arr[k] > arr[k + 1] when k is even, and
// arr[k] < arr[k + 1] when k is odd.
//
//
//
//
//
// Example 1:
//
//
// Input: arr = [9,4,2,10,7,8,8,1,9]
// Output: 5
// Explanation: arr[1] > arr[2] < arr[3] > arr[4] < arr[5]
//
//
// Example 2:
//
//
// Input: arr = [4,8,12,16]
// Output: 2
//
//
// Example 3:
//
//
// Input: arr = [100]
// Output: 1
//
//
//
// Constraints:
//
//
// 1 <= arr.length <= 4 * 10⁴
// 0 <= arr[i] <= 10⁹
//

/*
 O(n) Runtime: 8 ms, faster than 24.04% of Java online submissions for Longest Turbulent Subarray.
 O(1) Memory Usage: 61.1 MB, less than 24.05% of Java online submissions for Longest Turbulent Subarray.
*/
// Related Topics Array Dynamic Programming Sliding Window 👍 956 👎 154

// leetcode submit region begin(Prohibit modification and deletion)
public class LongestTurbulentSubarray_978 {
  public int maxTurbulenceSize(int[] arr) {
    if (arr.length == 1) {
      return 1;
    }

    boolean inc = arr[0] < arr[1];
    int currCount = (arr[0] != arr[1]) ? 2 : 1;
    int result = currCount;

    for (int j = 1; j < arr.length - 1; j++) {
      if (inc && arr[j] > arr[j + 1] || !inc && arr[j] < arr[j + 1]) {
        currCount++;
        result = Math.max(result, currCount);
      } else {
        currCount = (arr[j] != arr[j + 1]) ? 2 : 1;
      }
      inc = arr[j] < arr[j + 1];
    }
    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
