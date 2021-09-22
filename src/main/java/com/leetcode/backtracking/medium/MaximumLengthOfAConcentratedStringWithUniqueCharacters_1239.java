package com.leetcode.backtracking.medium;

// Given an array of strings arr. String s is a concatenation of a sub-sequence
// of arr which have unique characters.
//
// Return the maximum possible length of s.
//
//
// Example 1:
//
//
// Input: arr = ["un","iq","ue"]
// Output: 4
// Explanation: All possible concatenations are "","un","iq","ue","uniq" and
// "ique".
// Maximum length is 4.
//
//
// Example 2:
//
//
// Input: arr = ["cha","r","act","ers"]
// Output: 6
// Explanation: Possible solutions are "chaers" and "acters".
//
//
// Example 3:
//
//
// Input: arr = ["abcdefghijklmnopqrstuvwxyz"]
// Output: 26
//
//
//
// Constraints:
//
//
// 1 <= arr.length <= 16
// 1 <= arr[i].length <= 26
// arr[i] contains only lower case English letters.
//
// Related Topics Array String Backtracking Bit Manipulation 👍 1308 👎 124
/*
 O(2^n) Runtime: 3 ms, faster than 95.52% of Java online submissions for Maximum Length of a Concatenated String with Unique Characters.
 O(n) Memory Usage: 36.2 MB, less than 99.47% of Java online submissions for Maximum Length of a Concatenated String with Unique Characters.
*/
import java.util.List;
import java.util.stream.Collectors;

// leetcode submit region begin(Prohibit modification and deletion)
public class MaximumLengthOfAConcentratedStringWithUniqueCharacters_1239 {
  public int maxLength(List<String> arr) {
    List<EncodedSubstring> encoded =
        arr.stream()
            .map(this::encode)
            .filter(e -> e.encodedChars != -1)
            .collect(Collectors.toList());

    return backtrack(0, 0, 0, encoded);
  }

  private int backtrack(
      int encodedSoFar, int lenSoFar, int currIdx, List<EncodedSubstring> encodedSubstrings) {
    if (currIdx >= encodedSubstrings.size()) {
      return lenSoFar;
    }

    EncodedSubstring currNum = encodedSubstrings.get(currIdx);

    int result = backtrack(encodedSoFar, lenSoFar, currIdx + 1, encodedSubstrings);

    if ((encodedSoFar & currNum.encodedChars) == 0) {
      result =
          Math.max(
              backtrack(
                  encodedSoFar | currNum.encodedChars,
                  lenSoFar + currNum.numOfChars,
                  currIdx + 1,
                  encodedSubstrings),
              result);
    }

    return result;
  }

  private EncodedSubstring encode(String str) {
    int result = 0;

    for (int i = 0; i < str.length(); i++) {
      int charBit = 1 << (str.charAt(i) - 'a');
      if ((result & charBit) != 0) {
        return new EncodedSubstring(-1, -1);
      }
      result |= charBit;
    }

    return new EncodedSubstring(result, str.length());
  }

  private static final class EncodedSubstring {
    private final int encodedChars;
    private final int numOfChars;

    private EncodedSubstring(int encodedChars, int numOfChars) {
      this.encodedChars = encodedChars;
      this.numOfChars = numOfChars;
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
