package com.leetcode.arrays.easy;

// You are given an array of distinct integers arr and an array of integer arrays
// pieces, where the integers in pieces are distinct. Your goal is to form arr by
// concatenating the arrays in pieces in any order. However, you are not allowed to
// reorder the integers in each array pieces[i].
//
// Return true if it is possible to form the array arr from pieces. Otherwise, r
// eturn false.
//
//
// Example 1:
//
//
// Input: arr = [85], pieces = [[85]]
// Output: true
//
//
// Example 2:
//
//
// Input: arr = [15,88], pieces = [[88],[15]]
// Output: true
// Explanation: Concatenate [15] then [88]
//
//
// Example 3:
//
//
// Input: arr = [49,18,16], pieces = [[16,18,49]]
// Output: false
// Explanation: Even though the numbers match, we cannot reorder pieces[0].
//
//
// Example 4:
//
//
// Input: arr = [91,4,64,78], pieces = [[78],[4,64],[91]]
// Output: true
// Explanation: Concatenate [91] then [4,64] then [78]
//
// Example 5:
//
//
// Input: arr = [1,3,5,7], pieces = [[2,4,6,8]]
// Output: false
//
//
//
// Constraints:
//
//
// 1 <= pieces.length <= arr.length <= 100
// sum(pieces[i].length) == arr.length
// 1 <= pieces[i].length <= arr.length
// 1 <= arr[i], pieces[i][j] <= 100
// The integers in arr are distinct.
// The integers in pieces are distinct (i.e., If we flatten pieces in a 1D array
// , all the integers in this array are distinct).
//
// Related Topics Array Sort
// 👍 199 👎 50

import java.util.HashMap;
import java.util.Map;
/*
 O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Check Array Formation Through Concatenation.
 O(n) Memory Usage: 38.2 MB, less than 68.87% of Java online submissions for Check Array Formation Through Concatenation.
*/
// leetcode submit region begin(Prohibit modification and deletion)
public class CheckArrayFormationThroughConcentration_1640 {
  public boolean canFormArray(int[] arr, int[][] pieces) {
    Map<Integer, int[]> map = new HashMap<>();
    for (int[] piece : pieces) {
      map.put(piece[0], piece);
    }
    int i = 0;
    while (i < arr.length) {
      if (!map.containsKey(arr[i])) {
        return false;
      }
      int[] nums = map.get(arr[i]);
      for (int j = 0; j < nums.length; j++) {
        if (nums[j] != arr[i + j]) {
          return false;
        }
      }
      i += nums.length;
    }
    return true;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
