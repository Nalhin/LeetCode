package com.leetcode.arrays.easy;

// Given an array arr, replace every element in that array with the greatest elem
// ent among the elements to its right, and replace the last element with -1.
//
// After doing so, return the array.
//
//
// Example 1:
// Input: arr = [17,18,5,4,6,1]
// Output: [18,6,6,6,1,-1]
//
//
// Constraints:
//
//
// 1 <= arr.length <= 10^4
// 1 <= arr[i] <= 10^5
// Related Topics Array
// 👍 465 👎 104

// leetcode submit region begin(Prohibit modification and deletion)

public class ReplaceElementsWithGreatestElementOnRightSide_1299 {
  public int[] replaceElements(int[] arr) {
    int prev = arr[arr.length - 1];
    arr[arr.length - 1] = -1;

    for (int i = arr.length - 2; i >= 0; i--) {
      int newVal = Math.max(arr[i + 1], prev);
      prev = arr[i];
      arr[i] = newVal;
    }
    return arr;
  }
}

/*
   Runtime: 1 ms, faster than 99.79% of Java online submissions for Valid Mountain Array.
   Memory Usage: 41.1 MB, less than  37.46 % of Java online submissions for Valid Mountain Array.
*/

// leetcode submit region end(Prohibit modification and deletion)
