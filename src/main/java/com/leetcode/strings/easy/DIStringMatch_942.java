package com.leetcode.strings.easy;

// Given a string S that only contains "I" (increase) or "D" (decrease), let N =
// S.length.
//
// Return any permutation A of [0, 1, ..., N] such that for all i = 0, ..., N-1:
//
//
//
// If S[i] == "I", then A[i] < A[i+1]
// If S[i] == "D", then A[i] > A[i+1]
//
//
//
//
// Example 1:
//
//
// Input: "IDID"
// Output: [0,4,1,3,2]
//
//
//
// Example 2:
//
//
// Input: "III"
// Output: [0,1,2,3]
//
//
//
// Example 3:
//
//
// Input: "DDI"
// Output: [3,2,0,1]
//
//
//
//
//
// Note:
//
//
// 1 <= S.length <= 10000
// S only contains characters "I" or "D".
// Related Topics Math
// 👍 1026 👎 394

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(n) Runtime: 3 ms, faster than 27.81% of Java online submissions for DI String Match.
 O(n) Memory Usage: 45.4 MB, less than 6.82% of Java online submissions for DI String Match.
*/
public class DIStringMatch_942 {
  public int[] diStringMatch(String str) {
    int len = str.length();
    int min = 0;
    int max = 0;

    int[] result = new int[len + 1];

    for (int i = 0; i < len; i++) {
      if (str.charAt(i) == 'I') {
        result[i + 1] = ++max;
      } else {
        result[i + 1] = --min;
      }
    }

    for (int i = 0; i < result.length; i++) {
      result[i] += Math.abs(min);
    }

    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
