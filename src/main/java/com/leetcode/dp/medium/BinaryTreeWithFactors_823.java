package com.leetcode.dp.medium;

// Given an array of unique integers, arr, where each integer arr[i] is strictly
// greater than 1.
//
// We make a binary tree using these integers, and each number may be used for a
// ny number of times. Each non-leaf node's value should be equal to the product of
// the values of its children.
//
// Return the number of binary trees we can make. The answer may be too large so
// return the answer modulo 109 + 7.
//
//
// Example 1:
//
//
// Input: arr = [2,4]
// Output: 3
// Explanation: We can make these trees: [2], [4], [4, 2, 2]
//
// Example 2:
//
//
// Input: arr = [2,4,5,10]
// Output: 7
// Explanation: We can make these trees: [2], [4], [5], [10], [4, 2, 2], [10, 2,
// 5], [10, 5, 2].
//
//
// Constraints:
//
//
// 1 <= arr.length <= 1000
// 2 <= arr[i] <= 109
//
// 👍 447 👎 52

/*
 O(n^2) Runtime: 33 ms, faster than 42.48% of Java online submissions for Binary Trees With Factors.
 O(n) Memory Usage: 39.3 MB, less than 48.67% of Java online submissions for Binary Trees With Factors.
*/

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.Arrays;
import java.util.HashMap;

public class BinaryTreeWithFactors_823 {
  private static final int MOD = 1_000_000_007;

  public int numFactoredBinaryTrees(int[] arr) {
    HashMap<Integer, Long> nums = new HashMap<>();
    for (int k : arr) {
      nums.put(k, 1L);
    }

    Arrays.sort(arr);

    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < i; j++) {
        if (arr[i] % arr[j] != 0) {
          continue;
        }

        int key = arr[i] / arr[j];
        if (nums.containsKey(key)) {
          nums.put(arr[i], (nums.get(arr[i]) + (nums.get(key) * nums.get(arr[j])) % MOD));
        }
      }
    }

    int result = 0;
    for (long num : nums.values()) {
      result = (int) ((result + num) % MOD);
    }
    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
