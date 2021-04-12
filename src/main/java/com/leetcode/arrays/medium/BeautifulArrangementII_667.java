package com.leetcode.arrays.medium;

//
// Given two integers n and k, you need to construct a list which contains n diff
// erent positive integers ranging from 1 to n and obeys the following requirement:
//
//
// Suppose this list is [a1, a2, a3, ... , an], then the list [|a1 - a2|, |a2 - a
// 3|, |a3 - a4|, ... , |an-1 - an|] has exactly k distinct integers.
//
//
//
// If there are multiple answers, print any of them.
//
//
// Example 1:
//
// Input: n = 3, k = 1
// Output: [1, 2, 3]
// Explanation: The [1, 2, 3] has three different positive integers ranging from
// 1 to 3, and the [1, 1] has exactly 1 distinct integer: 1.
//
//
//
// Example 2:
//
// Input: n = 3, k = 2
// Output: [1, 3, 2]
// Explanation: The [1, 3, 2] has three different positive integers ranging from
// 1 to 3, and the [2, 1] has exactly 2 distinct integers: 1 and 2.
//
//
//
// Note:
//
// The n and k are in the range 1 <= k < n <= 104.
//
// Related Topics Array
// 👍 489 👎 791
/*
 O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Beautiful Arrangement II.
 O(n) Memory Usage: 39.3 MB, less than 44.57% of Java online submissions for Beautiful Arrangement II.
*/
// leetcode submit region begin(Prohibit modification and deletion)

public class BeautifulArrangementII_667 {
  public int[] constructArray(int n, int k) {
    int min = 1;
    int max = n;

    int[] result = new int[n];

    for (int i = 0; i < k; i++) {
      result[i] = i % 2 == 0 ? min++ : max--;
    }

    boolean shouldMin = k % 2 == 1;
    for (int i = k; i < n; i++) {
      result[i] = shouldMin ? min++ : max--;
    }

    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
