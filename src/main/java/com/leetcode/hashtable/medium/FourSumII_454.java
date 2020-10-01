package com.leetcode.hashtable.medium;

// Given four lists A, B, C, D of integer values, compute how many tuples (i, j,
// k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.
//
// To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤
// N ≤ 500. All integers are in the range of -228 to 228 - 1 and the result is guar
// anteed to be at most 231 - 1.
//
// Example:
//
//
// Input:
// A = [ 1, 2]
// B = [-2,-1]
// C = [-1, 2]
// D = [ 0, 2]
//
// Output:
// 2
//
// Explanation:
// The two tuples are:
// 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
// 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
//
//
//
// Related Topics Hash Table Binary Search
// 👍 1375 👎 75

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashMap;
import java.util.Map;

public class FourSumII_454 {
  public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
    Map<Integer, Integer> map = new HashMap<>();

    for (int a : A) {
      for (int b : B) {
        map.put(a + b, map.getOrDefault(a + b, 0) + 1);
      }
    }

    int result = 0;

    for (int c : C) {
      for (int d : D) {
        result += map.getOrDefault(c + d, 0);
      }
    }

    return result;
  }
}
/*
  O(n^2) Runtime: 60 ms, faster than 94.64% of Java online submissions for 4Sum II.
  O(n^2)   Memory Usage: 58.4 MB, less than 80.32% of Java online submissions for 4Sum II.
*/
// leetcode submit region end(Prohibit modification and deletion)
