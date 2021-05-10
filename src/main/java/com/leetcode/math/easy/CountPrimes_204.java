package com.leetcode.math.easy;

// Count the number of prime numbers less than a non-negative number, n.
//
//
// Example 1:
//
//
// Input: n = 10
// Output: 4
// Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
//
//
// Example 2:
//
//
// Input: n = 0
// Output: 0
//
//
// Example 3:
//
//
// Input: n = 1
// Output: 0
//
//
//
// Constraints:
//
//
// 0 <= n <= 5 * 106
//
// Related Topics Hash Table Math
// 👍 3042 👎 776
/*
 O(sqrt(loglog(n)) Runtime: 29 ms, faster than 46.46% of Java online submissions for Count Primes.
 O(n) Memory Usage: 42.2 MB, less than 30.88% of Java online submissions for Count Primes
*/
// leetcode submit region begin(Prohibit modification and deletion)

public class CountPrimes_204 {
  public int countPrimes(int n) {
    if (n <= 2) {
      return 0;
    }

    boolean[] notPrimes = new boolean[n];

    int sqrRootOfN = (int) Math.sqrt(n);
    for (int p = 2; p <= sqrRootOfN; ++p) {
      if (!notPrimes[p]) {
        for (int notPrime = p * p; notPrime < n; notPrime += p) {
          notPrimes[notPrime] = true;
        }
      }
    }

    int numberOfPrimes = 0;
    for (int i = 2; i < n; i++) {
      if (!notPrimes[i]) {
        ++numberOfPrimes;
      }
    }

    return numberOfPrimes;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
