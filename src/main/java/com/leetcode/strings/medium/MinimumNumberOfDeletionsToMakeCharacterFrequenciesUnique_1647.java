package com.leetcode.strings.medium;

// A string s is called good if there are no two different characters in s that h
// ave the same frequency.
//
// Given a string s, return the minimum number of characters you need to delete
// to make s good.
//
// The frequency of a character in a string is the number of times it appears in
// the string. For example, in the string "aab", the frequency of 'a' is 2, while
// the frequency of 'b' is 1.
//
//
// Example 1:
//
//
// Input: s = "aab"
// Output: 0
// Explanation: s is already good.
//
//
// Example 2:
//
//
// Input: s = "aaabbbcc"
// Output: 2
// Explanation: You can delete two 'b's resulting in the good string "aaabcc".
// Another way it to delete one 'b' and one 'c' resulting in the good string "aaa
// bbc".
//
// Example 3:
//
//
// Input: s = "ceabaacb"
// Output: 2
// Explanation: You can delete both 'c's resulting in the good string "eabaab".
// Note that we only care about characters that are still in the string at the en
// d (i.e. frequency of 0 is ignored).
//
//
//
// Constraints:
//
//
// 1 <= s.length <= 105
// s contains only lowercase English letters.
//
// Related Topics Greedy Sort
// 👍 108 👎 5

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashSet;
import java.util.Set;
/*
 O(n) Runtime: 15 ms, faster than 64.13% of Java online submissions for Minimum Deletions to Make Character Frequencies Unique.
 O(n) Memory Usage: 40.1 MB, less than 9.12% of Java online submissions for Minimum Deletions to Make Character Frequencies Unique.
*/
public class MinimumNumberOfDeletionsToMakeCharacterFrequenciesUnique_1647 {
  public int minDeletions(String s) {
    int[] chars = new int[26];

    for (int i = 0; i < s.length(); i++) {
      chars[s.charAt(i) - 'a']++;
    }

    Set<Integer> set = new HashSet<>();
    int ans = 0;
    for (int i = 0; i < chars.length; i++) {
      if (chars[i] == 0) {
        continue;
      }
      while (set.contains(chars[i])) {
        chars[i]--;
        ans++;
      }
      if (chars[i] != 0) {
        set.add(chars[i]);
      }
    }
    return ans;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
