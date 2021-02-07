package com.leetcode.hashtable.easy;

// Given an array of strings words, return the words that can be typed using lett
// ers of the alphabet on only one row of American keyboard like the image below.
//
// In the American keyboard:
//
//
// the first row consists of the characters "qwertyuiop",
// the second row consists of the characters "asdfghjkl", and
// the third row consists of the characters "zxcvbnm".
//
//
//
// Example 1:
//
//
// Input: words = ["Hello","Alaska","Dad","Peace"]
// Output: ["Alaska","Dad"]
//
//
// Example 2:
//
//
// Input: words = ["omk"]
// Output: []
//
//
// Example 3:
//
//
// Input: words = ["adsdf","sfd"]
// Output: ["adsdf","sfd"]
//
//
//
// Constraints:
//
//
// 1 <= words.length <= 20
// 1 <= words[i].length <= 100
// words[i] consists of English letters (both lowercase and uppercase).
//
// Related Topics Hash Table
// 👍 617 👎 747

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
/*
 O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Keyboard Row.
 O(1) Memory Usage: 37.2 MB, less than 52.70% of Java online submissions for Keyboard Row.
*/
public class KeyboardRow_500 {
  private final Set<Character> FIRST_ROW = Set.of('q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p');
  private final Set<Character> SECOND_ROW = Set.of('a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l');
  private final Set<Character> THIRD_ROW = Set.of('z', 'x', 'c', 'v', 'b', 'n', 'm');

  public String[] findWords(String[] words) {
    List<String> result = new ArrayList<>();

    for (String word : words) {
      int i = 0, j = 0, k = 0;
      while (i < word.length() && FIRST_ROW.contains(Character.toLowerCase(word.charAt(i)))) {
        i++;
      }
      while (j < word.length() && SECOND_ROW.contains(Character.toLowerCase(word.charAt(j)))) {
        j++;
      }
      while (k < word.length() && THIRD_ROW.contains(Character.toLowerCase(word.charAt(k)))) {
        k++;
      }

      if (word.length() == i || word.length() == j || word.length() == k) {
        result.add(word);
      }
    }

    return result.toArray(new String[0]);
  }
}
// leetcode submit region end(Prohibit modification and deletion)
