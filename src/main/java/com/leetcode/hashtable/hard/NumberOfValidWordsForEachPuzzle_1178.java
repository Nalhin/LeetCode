package com.leetcode.hashtable.hard;

// With respect to a given puzzle string, a word is valid if both the following
// conditions are satisfied:
//
// word contains the first letter of puzzle.
// For each letter in word, that letter is in puzzle.
//
// For example, if the puzzle is "abcdefg", then valid words are "faced",
// "cabbage", and "baggage", while
// invalid words are "beefed" (does not include 'a') and "based" (includes 's'
// which is not in the puzzle).
//
//
//
// Return an array answer, where answer[i] is the number of words in the given
// word list words that is valid with respect to the puzzle puzzles[i].
//
// Example 1:
//
//
// Input: words = ["aaaa","asas","able","ability","actt","actor","access"],
// puzzles = ["aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"]
// Output: [1,1,3,2,4,0]
// Explanation:
// 1 valid word for "aboveyz" : "aaaa"
// 1 valid word for "abrodyz" : "aaaa"
// 3 valid words for "abslute" : "aaaa", "asas", "able"
// 2 valid words for "absoryz" : "aaaa", "asas"
// 4 valid words for "actresz" : "aaaa", "asas", "actt", "access"
// There are no valid words for "gaswxyz" cause none of the words in the list
// contains letter 'g'.
//
//
// Example 2:
//
//
// Input: words = ["apple","pleas","please"], puzzles = ["aelwxyz","aelpxyz",
// "aelpsxy","saelpxy","xaelpsy"]
// Output: [0,1,3,2,0]
//
//
//
// Constraints:
//
//
// 1 <= words.length <= 10⁵
// 4 <= words[i].length <= 50
// 1 <= puzzles.length <= 10⁴
// puzzles[i].length == 7
// words[i] and puzzles[i] consist of lowercase English letters.
// Each puzzles[i] does not contain repeated characters.
//
// Related Topics Array Hash Table String Bit Manipulation Trie 👍 783 👎 63
/*
  Runtime: 101 ms, faster than 39.47% of Java online submissions for Number of Valid Words for Each Puzzle.
  Memory Usage: 93.8 MB, less than 5.32% of Java online submissions for Number of Valid Words for Each Puzzle.*
*/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// leetcode submit region begin(Prohibit modification and deletion)

public class NumberOfValidWordsForEachPuzzle_1178 {
  public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
    List<Integer> result = new ArrayList<>();
    if (puzzles.length == 0 || words.length == 0) {
      for (int i = 0; i < puzzles.length; i++) {
        result.add(0);
      }
      return result;
    }

    Map<Integer, Integer> wordMaskCountMap = new HashMap<>();
    for (String word : words) {
      int wordMask = mask(word, 0);
      wordMaskCountMap.merge(wordMask, 1, Integer::sum);
    }

    for (String puzzle : puzzles) {
      int puzzleMask = mask(puzzle, 1);
      int firstCharBit = 1 << (puzzle.charAt(0) - 'a');
      int subsetMask = puzzleMask;
      int puzzleCount = wordMaskCountMap.getOrDefault(firstCharBit, 0);

      while (subsetMask != 0) {
        puzzleCount += wordMaskCountMap.getOrDefault(subsetMask | firstCharBit, 0);

        subsetMask = (subsetMask - 1) & puzzleMask;
      }

      result.add(puzzleCount);
    }

    return result;
  }

  private int mask(String str, int start) {
    int mask = 0;
    for (int i = start; i < str.length(); i++) {
      mask |= 1 << (str.charAt(i) - 'a');
    }
    return mask;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
