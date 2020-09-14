package com.leetcode.arrays.easy;

// Given an array arr of integers, check if there exists two integers N and M suc
// h that N is the double of M ( i.e. N = 2 * M).
//
// More formally check if there exists two indices i and j such that :
//
//
// i != j
// 0 <= i, j < arr.length
// arr[i] == 2 * arr[j]
//
//
//
// Example 1:
//
//
// Input: arr = [10,2,5,3]
// Output: true
// Explanation: N = 10 is the double of M = 5,that is, 10 = 2 * 5.
//
//
// Example 2:
//
//
// Input: arr = [7,1,14,11]
// Output: true
// Explanation: N = 14 is the double of M = 7,that is, 14 = 2 * 7.
//
//
// Example 3:
//
//
// Input: arr = [3,1,7,11]
// Output: false
// Explanation: In this case does not exist N and M, such that N = 2 * M.
//
//
//
// Constraints:
//
//
// 2 <= arr.length <= 500
// -10^3 <= arr[i] <= 10^3
//
// Related Topics Array
// 👍 203 👎 33

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashSet;
import java.util.Set;

public class CheckIfNAndItsDoubleExists_1346 {
  public boolean checkIfExist(int[] arr) {
    Set<Integer> cache = new HashSet<>();
    for (int el : arr) {
      if (cache.contains(el * 2) || (el % 2 == 0 && cache.contains(el / 2))) {
        return true;
      }
      cache.add(el);
    }
    return false;
  }
}

/*
    Runtime: 1 ms, faster than 99.25% of Java online submissions for Check If N and Its Double Exist.
    Memory Usage: 39.1 MB, less than 73.13% of Java online submissions for Check If N and Its Double Exist.
*/

// leetcode submit region end(Prohibit modification and deletion)
