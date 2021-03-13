package com.leetcode.strings.easy;

// You are given a string s of even length. Split this string into two halves of
// equal lengths, and let a be the first half and b be the second half.
//
// Two strings are alike if they have the same number of vowels ('a', 'e', 'i',
// 'o', 'u', 'A', 'E', 'I', 'O', 'U'). Notice that s contains uppercase and lowerca
// se letters.
//
// Return true if a and b are alike. Otherwise, return false.
//
//
// Example 1:
//
//
// Input: s = "book"
// Output: true
// Explanation: a = "bo" and b = "ok". a has 1 vowel and b has 1 vowel. Therefore
// , they are alike.
//
//
// Example 2:
//
//
// Input: s = "textbook"
// Output: false
// Explanation: a = "text" and b = "book". a has 1 vowel whereas b has 2. Therefo
// re, they are not alike.
// Notice that the vowel o is counted twice.
//
//
// Example 3:
//
//
// Input: s = "MerryChristmas"
// Output: false
//
//
// Example 4:
//
//
// Input: s = "AbCdEfGh"
// Output: true
//
//
//
// Constraints:
//
//
// 2 <= s.length <= 1000
// s.length is even.
// s consists of uppercase and lowercase letters.
//
// Related Topics String
// 👍 154 👎 10
/*
 O(n) Runtime: 2 ms, faster than 93.04% of Java online submissions for Determine if String Halves Are Alike.
 O(1) Memory Usage: 37.4 MB, less than 76.74% of Java online submissions for Determine if String Halves Are Alike.
*/
// leetcode submit region begin(Prohibit modification and deletion)

import java.util.Set;

public class DetermineIfStringHalvesAreAlike_1704 {
  private static final Set<Character> vowels =
      Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

  public boolean halvesAreAlike(String str) {
    return countVowels(str, 0, str.length() / 2)
        == countVowels(str, str.length() / 2, str.length());
  }

  private int countVowels(String str, int from, int to) {
    int vowelCountLeft = 0;

    for (int i = from; i < to; i++) {
      vowelCountLeft += vowels.contains(str.charAt(i)) ? 1 : 0;
    }
    return vowelCountLeft;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
