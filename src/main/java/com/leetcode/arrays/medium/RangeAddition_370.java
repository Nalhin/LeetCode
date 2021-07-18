package com.leetcode.arrays.medium;

// You are given an integer length and an array updates where updates[i] = [start
// Idxi, endIdxi, inci].
//
// You have an array arr of length length with all zeros, and you have some oper
// ation to apply on arr. In the ith operation, you should increment all the elemen
// ts arr[startIdxi], arr[startIdxi + 1], ..., arr[endIdxi] by inci.
//
// Return arr after applying all the updates.
//
//
// Example 1:
//
//
// Input: length = 5, updates = [[1,3,2],[2,4,3],[0,2,-2]]
// Output: [-2,0,3,5,3]
//
//
// Example 2:
//
//
// Input: length = 10, updates = [[2,4,6],[5,6,8],[1,9,-4]]
// Output: [0,-4,2,2,2,4,4,-4,-4,-4]
//
//
//
// Constraints:
//
//
// 1 <= length <= 105
// 0 <= updates.length <= 104
// 0 <= startIdxi <= endIdxi < length
// -1000 <= inci <= 1000
//
// Related Topics Array Prefix Sum
// 👍 757 👎 31
/*
 O(n + k) Runtime: 1 ms, faster than 100.00% of Java online submissions for Range Addition.
 O(n) Memory Usage: 47 MB, less than 9.37% of Java online submissions for Range Addition.
*/
// leetcode submit region begin(Prohibit modification and deletion)

public class RangeAddition_370 {
  public int[] getModifiedArray(int length, int[][] updates) {
    int[] operations = new int[length + 1];

    for (int[] update : updates) {
      int firstIdx = update[0];
      int endIdx = update[1] + 1;
      int change = update[2];
      operations[firstIdx] += change;
      operations[endIdx] -= change;
    }

    int[] result = new int[length];

    int curr = 0;
    for (int i = 0; i < result.length; i++) {
      curr += operations[i];
      result[i] = curr;
    }

    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
