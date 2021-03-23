package com.leetcode.arrays.medium;

// Given an integer array arr, and an integer target, return the number of tuples
// i, j, k such that i < j < k and arr[i] + arr[j] + arr[k] == target.
//
// As the answer can be very large, return it modulo 109 + 7.
//
//
// Example 1:
//
//
// Input: arr = [1,1,2,2,3,3,4,4,5,5], target = 8
// Output: 20
// Explanation:
// Enumerating by the values (arr[i], arr[j], arr[k]):
// (1, 2, 5) occurs 8 times;
// (1, 3, 4) occurs 8 times;
// (2, 2, 4) occurs 2 times;
// (2, 3, 3) occurs 2 times.
//
//
// Example 2:
//
//
// Input: arr = [1,1,2,2,2,2], target = 5
// Output: 12
// Explanation:
// arr[i] = 1, arr[j] = arr[k] = 2 occurs 12 times:
// We choose one 1 from [1,1] in 2 ways,
// and two 2s from [2,2,2,2] in 6 ways.
//
//
//
// Constraints:
//
//
// 3 <= arr.length <= 3000
// 0 <= arr[i] <= 100
// 0 <= target <= 300
//
// Related Topics Two Pointers
// 👍 587 👎 102
/*
 O(n^2) Runtime: 740 ms, faster than 15.00% of Java online submissions for 3Sum With Multiplicity.
 O(n^2) Memory Usage: 39.2 MB, less than 34.64% of Java online submissions for 3Sum With Multiplicity.
*/
// leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashMap;
import java.util.Map;

public class ThreeSumWithMultiplicity_923 {
  private static final int MOD = 1_000_000_007;

  public int threeSumMulti(int[] arr, int target) {
    Map<Integer, Integer> map = new HashMap<>();

    int result = 0;
    for (int i = 0; i < arr.length; i++) {
      result = (result + map.getOrDefault(target - arr[i], 0)) % MOD;

      for (int j = 0; j < i; j++) {
        int sum = arr[i] + arr[j];
        map.put(sum, map.getOrDefault(sum, 0) + 1);
      }
    }
    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
