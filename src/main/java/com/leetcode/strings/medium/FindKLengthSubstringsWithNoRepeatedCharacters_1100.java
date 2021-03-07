package com.leetcode.strings.medium;

// Given a string S, return the number of substrings of length K with no repeated
// characters.
//
//
//
// Example 1:
//
//
// Input: S = "havefunonleetcode", K = 5
// Output: 6
// Explanation:
// There are 6 substrings they are : 'havef','avefu','vefun','efuno','etcod','tco
// de'.
//
//
// Example 2:
//
//
// Input: S = "home", K = 5
// Output: 0
// Explanation:
// Notice K can be larger than the length of S. In this case is not possible to f
// ind any substring.
//
//
//
//
// Note:
//
//
// 1 <= S.length <= 10^4
// All characters of S are lowercase English letters.
// 1 <= K <= 10^4
//
// Related Topics String Sliding Window
// 👍 240 👎 6

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(n) Runtime: 8 ms, faster than 58.48% of Java online submissions for Find K-Length Substrings With No Repeated Characters.
 O(1) Memory Usage: 39 MB, less than 49.00% of Java online submissions for Find K-Length Substrings With No Repeated Characters.
*/
import java.util.HashSet;
import java.util.Set;

public class FindKLengthSubstringsWithNoRepeatedCharacters_1100 {
  public int numKLenSubstrNoRepeats(String str, int k) {
    int result = 0;

    Set<Character> visited = new HashSet<>();
    int left = 0;

    for (int i = 0; i < str.length(); i++) {
      while (visited.contains(str.charAt(i))) {
        visited.remove(str.charAt(left++));
      }
      visited.add(str.charAt(i));

      if (visited.size() >= k) {
        result++;
      }
    }

    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
