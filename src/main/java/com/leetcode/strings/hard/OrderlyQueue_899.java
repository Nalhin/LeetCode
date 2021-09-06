package com.leetcode.strings.hard;

// You are given a string s and an integer k. You can choose one of the first k
// letters of s and append it at the end of the string..
//
// Return the lexicographically smallest string you could have after applying
// the mentioned step any number of moves.
//
//
// Example 1:
//
//
// Input: s = "cba", k = 1
// Output: "acb"
// Explanation:
// In the first move, we move the 1ˢᵗ character 'c' to the end, obtaining the
// string "bac".
// In the second move, we move the 1ˢᵗ character 'b' to the end, obtaining the
// final result "acb".
//
//
// Example 2:
//
//
// Input: s = "baaca", k = 3
// Output: "aaabc"
// Explanation:
// In the first move, we move the 1ˢᵗ character 'b' to the end, obtaining the
// string "aacab".
// In the second move, we move the 3ʳᵈ character 'c' to the end, obtaining the
// final result "aaabc".
//
//
//
// Constraints:
//
//
// 1 <= k <= s.length <= 1000
// s consist of lowercase English letters.
//
// Related Topics Math String Sorting 👍 405 👎 295
/*
 O(n^2) Runtime: 2 ms, faster than 89.72% of Java online submissions for Orderly Queue.
 O(n) Memory Usage: 39.2 MB, less than 50.47% of Java online submissions for Orderly Queue.
*/
// leetcode submit region begin(Prohibit modification and deletion)

import java.util.Arrays;

public class OrderlyQueue_899 {
  public String orderlyQueue(String s, int k) {
    if (k > 1) {
      char[] strAsChars = s.toCharArray();
      Arrays.sort(strAsChars);
      return new String(strAsChars);
    } else {
      String result = s;
      for (int i = 0; i < s.length(); ++i) {
        String curr = s.substring(i) + s.substring(0, i);
        if (curr.compareTo(result) < 0) {
          result = curr;
        }
      }
      return result;
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
