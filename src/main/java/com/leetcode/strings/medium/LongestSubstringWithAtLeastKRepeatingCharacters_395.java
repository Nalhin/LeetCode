package com.leetcode.strings.medium;

// Given a string s and an integer k, return the length of the longest substring
// of s such that the frequency of each character in this substring is greater than
// or equal to k.
//
//
// Example 1:
//
//
// Input: s = "aaabb", k = 3
// Output: 3
// Explanation: The longest substring is "aaa", as 'a' is repeated 3 times.
//
//
// Example 2:
//
//
// Input: s = "ababbc", k = 2
// Output: 5
// Explanation: The longest substring is "ababb", as 'a' is repeated 2 times and
// 'b' is repeated 3 times.
//
//
//
// Constraints:
//
//
// 1 <= s.length <= 104
// s consists of only lowercase English letters.
// 1 <= k <= 105
//
// Related Topics Divide and Conquer Recursion Sliding Window
// 👍 1918 👎 240

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(n^2) Runtime: 0 ms, faster than 100.00% of Java online submissions for Longest Substring with At Least K Repeating Characters.
 O(n) Memory Usage: 36.8 MB, less than 79.31% of Java online submissions for Longest Substring with At Least K Repeating Characters.
*/
import java.util.ArrayList;
import java.util.List;

public class LongestSubstringWithAtLeastKRepeatingCharacters_395 {
  public int longestSubstring(String s, int k) {
    return longestStrDfs(s.toCharArray(), k, 0, s.length());
  }

  private int longestStrDfs(char[] str, int k, int left, int right) {
    if (left >= right) {
      return 0;
    }
    int[] count = new int[26];

    for (int i = left; i < right; i++) {
      count[str[i] - 'a']++;
    }

    List<Integer> splits = new ArrayList<>();

    boolean valid = true;
    for (int i = left; i < right; i++) {
      if (count[str[i] - 'a'] < k) {
        splits.add(i);
        valid = false;
      }
    }
    if (valid) {
      return right - left;
    }
    splits.add(right);

    int prev = left;
    int max = 0;

    for (int split : splits) {
      max = Math.max(max, longestStrDfs(str, k, prev, split));
      prev = split + 1;
    }

    return max;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
