package com.leetcode.strings.medium;

// Given a string s and an integer k.
//
// Return the maximum number of vowel letters in any substring of s with length
// k.
//
// Vowel letters in English are (a, e, i, o, u).
//
//
// Example 1:
//
//
// Input: s = "abciiidef", k = 3
// Output: 3
// Explanation: The substring "iii" contains 3 vowel letters.
//
//
// Example 2:
//
//
// Input: s = "aeiou", k = 2
// Output: 2
// Explanation: Any substring of length 2 contains 2 vowels.
//
//
// Example 3:
//
//
// Input: s = "leetcode", k = 3
// Output: 2
// Explanation: "lee", "eet" and "ode" contain 2 vowels.
//
//
// Example 4:
//
//
// Input: s = "rhythms", k = 4
// Output: 0
// Explanation: We can see that s doesn't have any vowel letters.
//
//
// Example 5:
//
//
// Input: s = "tryhard", k = 4
// Output: 1
//
//
//
// Constraints:
//
//
// 1 <= s.length <= 10^5
// s consists of lowercase English letters.
// 1 <= k <= s.length
// Related Topics String Sliding Window
// 👍 363 👎 24

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(n) Runtime: 31 ms, faster than 16.33% of Java online submissions for Maximum Number of Vowels in a Substring of Given Length.
 O(1) Memory Usage: 39.4 MB, less than 73.25% of Java online submissions for Maximum Number of Vowels in a Substring of Given Length.
*/

import java.util.Set;

public class MaximumNumberOfVowelsInASubstringOfGivenLength_1456 {
  private static final Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');

  public int maxVowels(String s, int k) {
    int vowelCount = 0;

    for (int i = 0; i < Math.min(k, s.length()); i++) {
      vowelCount += vowels.contains(s.charAt(i)) ? 1 : 0;
    }

    int result = vowelCount;

    for (int i = k; i < s.length(); i++) {
      vowelCount -= vowels.contains(s.charAt(i - k)) ? 1 : 0;
      vowelCount += vowels.contains(s.charAt(i)) ? 1 : 0;

      result = Math.max(vowelCount, result);
    }

    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
