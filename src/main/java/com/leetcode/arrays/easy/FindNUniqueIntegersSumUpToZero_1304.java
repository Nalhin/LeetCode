package com.leetcode.arrays.easy;

// Given an integer n, return any array containing n unique integers such that th
// ey add up to 0.
//
//
// Example 1:
//
//
// Input: n = 5
// Output: [-7,-1,1,3,4]
// Explanation: These arrays also are accepted [-5,-1,1,2,3] , [-3,-1,2,-2,4].
//
//
// Example 2:
//
//
// Input: n = 3
// Output: [-1,0,1]
//
//
// Example 3:
//
//
// Input: n = 1
// Output: [0]
//
//
//
// Constraints:
//
//
// 1 <= n <= 1000
//
// Related Topics Array
// 👍 423 👎 251

// leetcode submit region begin(Prohibit modification and deletion)
/*
  O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Find N Unique Integers Sum up to Zero.
  O(n) Memory Usage: 37.6 MB, less than 16.61% of Java online submissions for Find N Unique Integers Sum up to Zero.
*/
public class FindNUniqueIntegersSumUpToZero_1304 {

  public int[] sumZero(int n) {
    int[] result = new int[n];

    int j = 0;
    int max = n % 2 == 0 ? n + 2 : n;
    int first = n % 2 == 0 ? -n : -n + 2;
    for (int i = first; i < max; i += 2) {
      if (i == 0 && n % 2 == 0) {
        i += 2;
      }
      result[j++] = i;
    }

    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
