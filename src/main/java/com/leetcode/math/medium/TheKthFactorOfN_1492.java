package com.leetcode.math.medium;

// Given two positive integers n and k.
//
// A factor of an integer n is defined as an integer i where n % i == 0.
//
// Consider a list of all factors of n sorted in ascending order, return the kth
// factor in this list or return -1 if n has less than k factors.
//
//
// Example 1:
//
//
// Input: n = 12, k = 3
// Output: 3
// Explanation: Factors list is [1, 2, 3, 4, 6, 12], the 3rd factor is 3.
//
//
// Example 2:
//
//
// Input: n = 7, k = 2
// Output: 7
// Explanation: Factors list is [1, 7], the 2nd factor is 7.
//
//
// Example 3:
//
//
// Input: n = 4, k = 4
// Output: -1
// Explanation: Factors list is [1, 2, 4], there is only 3 factors. We should ret
// urn -1.
//
//
// Example 4:
//
//
// Input: n = 1, k = 1
// Output: 1
// Explanation: Factors list is [1], the 1st factor is 1.
//
//
// Example 5:
//
//
// Input: n = 1000, k = 3
// Output: 4
// Explanation: Factors list is [1, 2, 4, 5, 8, 10, 20, 25, 40, 50, 100, 125, 200
// , 250, 500, 1000].
//
//
//
// Constraints:
//
//
// 1 <= k <= n <= 1000
// Related Topics Math
// 👍 258 👎 109

import java.util.ArrayList;
import java.util.List;
/*
 O(sqrt(n)) Runtime: 0 ms, faster than 100.00% of Java online submissions for The kth Factor of n.
 O(min(k, sqrt(n))) Memory Usage: 35.7 MB, less than 79.94% of Java online submissions for The kth Factor of n.
*/
// leetcode submit region begin(Prohibit modification and deletion)
public class TheKthFactorOfN_1492 {
  public int kthFactor(int n, int k) {
    List<Integer> divisors = new ArrayList<>();
    int sqrtN = (int) Math.sqrt(n);
    for (int i = 1; i <= sqrtN; i++) {
      if (n % i == 0) {
        k--;
        divisors.add(i);
        if (k == 0) {
          return i;
        }
      }
    }

    if (sqrtN * sqrtN == n) {
      ++k;
    }

    return k <= divisors.size() ? n / divisors.get(divisors.size() - k) : -1;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
