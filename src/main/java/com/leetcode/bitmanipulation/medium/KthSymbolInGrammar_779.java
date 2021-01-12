package com.leetcode.bitmanipulation.medium;

// On the first row, we write a 0. Now in every subsequent row, we look at the pr
// evious row and replace each occurrence of 0 with 01, and each occurrence of 1 wi
// th 10.
//
// Given row N and index K, return the K-th indexed symbol in row N. (The values
// of K are 1-indexed.) (1 indexed).
//
//
// Examples:
// Input: N = 1, K = 1
// Output: 0
//
// Input: N = 2, K = 1
// Output: 0
//
// Input: N = 2, K = 2
// Output: 1
//
// Input: N = 4, K = 5
// Output: 1
//
// Explanation:
// row 1: 0
// row 2: 01
// row 3: 0110
// row 4: 01101001
//
//
// Note:
//
//
// N will be an integer in the range [1, 30].
// K will be an integer in the range [1, 2^(N-1)].
//
// Related Topics Recursion
// 👍 729 👎 182

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for K-th Symbol in Grammar.
 O(n) Memory Usage: 35.8 MB, less than 56.43% of Java online submissions for K-th Symbol in Grammar.
*/
public class KthSymbolInGrammar_779 {
  public int kthGrammar(int N, int K) {
    if (N == 1) {
      return 0;
    }
    if (K <= 1 << N - 2) {
      return kthGrammar(N - 1, K);
    }
    return kthGrammar(N - 1, K - (1 << N - 2)) ^ 1;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
