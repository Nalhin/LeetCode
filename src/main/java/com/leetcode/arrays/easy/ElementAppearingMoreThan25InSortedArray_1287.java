package com.leetcode.arrays.easy;

// Given an integer array sorted in non-decreasing order, there is exactly one in
// teger in the array that occurs more than 25% of the time.
//
// Return that integer.
//
//
// Example 1:
// Input: arr = [1,2,2,6,6,6,6,7,10]
// Output: 6
//
//
// Constraints:
//
//
// 1 <= arr.length <= 10^4
// 0 <= arr[i] <= 10^5
// Related Topics Array
// 👍 417 👎 29

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Element Appearing More Than 25% In Sorted Array.
 O(1) Memory Usage: 39.2 MB, less than 69.59% of Java online submissions for Element Appearing More Than 25% In Sorted Array.
*/
public class ElementAppearingMoreThan25InSortedArray_1287 {
  public int findSpecialInteger(int[] arr) {
    int curr = -1;
    int count = 0;

    for (int num : arr) {
      if (num == curr) {
        count++;
      } else {
        curr = num;
        count = 1;
      }

      if (count > arr.length / 4) {
        return curr;
      }
    }

    return -1;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
