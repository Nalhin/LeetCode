package com.leetcode.strings.medium;

// International Morse Code defines a standard encoding where each letter is mapp
// ed to a series of dots and dashes, as follows: "a" maps to ".-", "b" maps to "-.
// ..", "c" maps to "-.-.", and so on.
//
// For convenience, the full table for the 26 letters of the English alphabet is
// given below:
//
//
// [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--
// ","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.
// ."]
//
// Now, given a list of words, each word can be written as a concatenation of th
// e Morse code of each letter. For example, "cab" can be written as "-.-..--...",
// (which is the concatenation "-.-." + ".-" + "-..."). We'll call such a concatena
// tion, the transformation of a word.
//
// Return the number of different transformations among all words we have.
//
//
// Example:
// Input: words = ["gin", "zen", "gig", "msg"]
// Output: 2
// Explanation:
// The transformation of each word is:
// "gin" -> "--...-."
// "zen" -> "--...-."
// "gig" -> "--...--."
// "msg" -> "--...--."
//
// There are 2 different transformations, "--...-." and "--...--.".
//
//
// Note:
//
//
// The length of words will be at most 100.
// Each words[i] will have length in range [1, 12].
// words[i] will only consist of lowercase letters.
//
// Related Topics String
// 👍 748 👎 739

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashSet;
import java.util.Set;
/*
 O(n) Runtime: 1 ms, faster than 100.00% of Java online submissions for Unique Morse Code Words.
 O(1) Memory Usage: 36.6 MB, less than 94.16% of Java online submissions for Unique Morse Code Words.
*/
public class UniqueMorseCodeWords_804 {

  private final String[] morseCodes = {
    ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--",
    "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."
  };

  public int uniqueMorseRepresentations(String[] words) {
    Set<String> visited = new HashSet<>();

    for (String word : words) {
      StringBuilder sb = new StringBuilder();

      for (int i = 0; i < word.length(); i++) {
        sb.append(morseCodes[word.charAt(i) - 'a']);
      }
      visited.add(sb.toString());
    }
    return visited.size();
  }
}
// leetcode submit region end(Prohibit modification and deletion)
