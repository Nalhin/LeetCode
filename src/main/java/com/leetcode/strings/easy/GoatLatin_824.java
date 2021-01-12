package com.leetcode.strings.easy;

// A sentence S is given, composed of words separated by spaces. Each word consis
// ts of lowercase and uppercase letters only.
//
// We would like to convert the sentence to "Goat Latin" (a made-up language sim
// ilar to Pig Latin.)
//
// The rules of Goat Latin are as follows:
//
//
// If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of t
// he word.
// For example, the word 'apple' becomes 'applema'.
//
// If a word begins with a consonant (i.e. not a vowel), remove the first letter
// and append it to the end, then add "ma".
// For example, the word "goat" becomes "oatgma".
//
// Add one letter 'a' to the end of each word per its word index in the sentence
// , starting with 1.
// For example, the first word gets "a" added to the end, the second word gets "
// aa" added to the end and so on.
//
//
// Return the final sentence representing the conversion from S to Goat Latin.
//
//
//
// Example 1:
//
//
// Input: "I speak Goat Latin"
// Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
//
//
// Example 2:
//
//
// Input: "The quick brown fox jumped over the lazy dog"
// Output: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetm
// aaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
//
//
//
//
// Notes:
//
//
// S contains only uppercase, lowercase and spaces. Exactly one space between ea
// ch word.
// 1 <= S.length <= 150.
//
// Related Topics String
// 👍 466 👎 887

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.Set;
/*
 O(n) Runtime: 2 ms, faster than 83.96% of Java online submissions for Goat Latin.
 O(n) Memory Usage: 37.9 MB, less than 58.65% of Java online submissions for Goat Latin.
*/
public class GoatLatin_824 {

  private final Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

  public String toGoatLatin(String str) {
    String[] words = str.split(" ");
    StringBuilder result = new StringBuilder();

    for (int i = 0; i < words.length; i++) {
      String word = words[i];
      if (vowels.contains(word.charAt(0))) {
        result.append(word);
      } else {
        result.append(word.substring(1)).append(word.charAt(0));
      }
      result.append("ma");
      result.append("a".repeat(i + 1)).append(" ");
    }

    return result.toString().trim();
  }
}
// leetcode submit region end(Prohibit modification and deletion)
