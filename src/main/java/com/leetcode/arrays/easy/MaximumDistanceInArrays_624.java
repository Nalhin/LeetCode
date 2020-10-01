package com.leetcode.arrays.easy;

//
// Given m arrays, and each array is sorted in ascending order. Now you can pick
// up two integers from two different arrays (each array picks one) and calculate t
// he distance. We define the distance between two integers a and b to be their abs
// olute difference |a-b|. Your task is to find the maximum distance.
//
//
// Example 1:
//
// Input:
// [[1,2,3],
// [4,5],
// [1,2,3]]
// Output: 4
// Explanation:
// One way to reach the maximum distance 4 is to pick 1 in the first or third arr
// ay and pick 5 in the second array.
//
//
//
// Note:
//
// Each given array will have at least 1 number. There will be at least two non-
// empty arrays.
// The total number of the integers in all the m arrays will be in the range of
// [2, 10000].
// The integers in the m arrays will be in the range of [-10000, 10000].
//
// Related Topics Array Hash Table
// 👍 396 👎 52

import java.util.List;

// leetcode submit region begin(Prohibit modification and deletion)
public class MaximumDistanceInArrays_624 {
  public int maxDistance(List<List<Integer>> arrays) {
    int min = arrays.get(0).get(0);
    int max = arrays.get(0).get(arrays.get(0).size() - 1);
    int result = Integer.MIN_VALUE;

    for (int i = 1; i < arrays.size(); i++) {
      int currMin = arrays.get(i).get(0);
      int currMax = arrays.get(i).get(arrays.get(i).size() - 1);

      result = Math.max(result, Math.abs(currMin - max));
      result = Math.max(result, Math.abs(currMax - min));

      min = Math.min(currMin, min);
      max = Math.max(currMax, max);
    }
    return result;
  }
}
/*
  O(n) Runtime: 3 ms, faster than 93.40% of Java online submissions for Maximum Distance in Arrays.
  O(1) Memory Usage: 40.3 MB, less than 98.11% of Java online submissions for Maximum Distance in Arrays.
*/
// leetcode submit region end(Prohibit modification and deletion)
