package com.leetcode.strings.easy;
// Given a string S, remove the vowels 'a', 'e', 'i', 'o', and 'u' from it, and r
// eturn the new string.
//
//
//
// Example 1:
//
//
// Input: "leetcodeisacommunityforcoders"
// Output: "ltcdscmmntyfrcdrs"
//
//
// Example 2:
//
//
// Input: "aeiou"
// Output: ""
//
//
//
//
// Note:
//
//
// S consists of lowercase English letters only.
// 1 <= S.length <= 1000
//
// Related Topics String
// 👍 112 👎 84

import java.util.Set;

// leetcode submit region begin(Prohibit modification and deletion)
public class RemoveVowelsFromAString_1119 {
  Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');

  public String removeVowels(String S) {
    char[] old = S.toCharArray();
    int left = 0;

    for (int i = 0; i < old.length; i++) {
      if (!vowels.contains(old[i])) {
        old[left++] = old[i];
      }
    }
    return new String(old, 0, left);
  }
}

/*
 O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Vowels from a String.
 O(1) Memory Usage: 37.3 MB, less than 82.07% of Java online submissions for Remove Vowels from a String
*/

// leetcode submit region end(Prohibit modification and deletion)
