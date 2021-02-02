package com.leetcode.strings.medium;

// You are given a string s, a split is called good if you can split s into 2 non
// -empty strings p and q where its concatenation is equal to s and the number of d
// istinct letters in p and q are the same.
//
// Return the number of good splits you can make in s.
//
//
// Example 1:
//
//
// Input: s = "aacaba"
// Output: 2
// Explanation: There are 5 ways to split "aacaba" and 2 of them are good.
// ("a", "acaba") Left string and right string contains 1 and 3 different letters
// respectively.
// ("aa", "caba") Left string and right string contains 1 and 3 different letters
// respectively.
// ("aac", "aba") Left string and right string contains 2 and 2 different letters
// respectively (good split).
// ("aaca", "ba") Left string and right string contains 2 and 2 different letters
// respectively (good split).
// ("aacab", "a") Left string and right string contains 3 and 1 different letters
// respectively.
//
//
// Example 2:
//
//
// Input: s = "abcd"
// Output: 1
// Explanation: Split the string as follows ("ab", "cd").
//
//
// Example 3:
//
//
// Input: s = "aaaaa"
// Output: 4
// Explanation: All possible splits are good.
//
// Example 4:
//
//
// Input: s = "acbadbaada"
// Output: 2
//
//
//
// Constraints:
//
//
// s contains only lowercase English letters.
// 1 <= s.length <= 10^5
// Related Topics String Bit Manipulation
// 👍 337 👎 11

import java.util.Arrays;
/*
 O(n) Runtime: 7 ms, faster than 80.27% of Java online submissions for Number of Good Ways to Split a String.
 O(n) Memory Usage: 39.3 MB, less than 78.91% of Java online submissions for Number of Good Ways to Split a String.
*/
// leetcode submit region begin(Prohibit modification and deletion)
public class NumberOfGoodWaysToSplitAString_1525 {
  public int numSplits(String s) {
    int[] first = new int[26];
    int[] last = new int[26];

    Arrays.fill(first, -1);
    Arrays.fill(last, -1);

    for (int i = 0; i < s.length(); i++) {
      int index = s.charAt(i) - 'a';
      if (first[index] == -1) {
        first[index] = i;
      }
      last[index] = i;
    }

    int right = 0;
    for (int k : first) {
      if (k != -1) {
        right++;
      }
    }


    boolean[] increases = new boolean[s.length()];
    boolean[] decreases = new boolean[s.length()];

    for (int i = 0; i < first.length; i++) {
      if (first[i] != -1) {
        increases[first[i]] = true;
      }
      if (last[i] != -1) {
        decreases[last[i]] = true;
      }
    }

    int left = 0;
    int result = 0;

    for (int i = 0; i < s.length(); i++) {
      if (increases[i]) {
        left++;
      }
      if (decreases[i]) {
        right--;
      }

      if (left == right) {
        result++;
      }
    }

    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
