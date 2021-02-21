package com.leetcode.strings.medium;

// Given an array of characters chars, compress it using the following algorithm:
//
//
// Begin with an empty string s. For each group of consecutive repeating charact
// ers in chars:
//
//
// If the group's length is 1, append the character to s.
// Otherwise, append the character followed by the group's length.
//
//
// The compressed string s should not be returned separately, but instead be sto
// red in the input character array chars. Note that group lengths that are 10 or l
// onger will be split into multiple characters in chars.
//
// After you are done modifying the input array, return the new length of the ar
// ray.
//
//
// Follow up:
// Could you solve it using only O(1) extra space?
//
//
// Example 1:
//
//
// Input: chars = ["a","a","b","b","c","c","c"]
// Output: Return 6, and the first 6 characters of the input array should be: ["a
// ","2","b","2","c","3"]
// Explanation: The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3"
// .
//
//
// Example 2:
//
//
// Input: chars = ["a"]
// Output: Return 1, and the first character of the input array should be: ["a"]
// Explanation: The only group is "a", which remains uncompressed since it's a si
// ngle character.
//
//
// Example 3:
//
//
// Input: chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
// Output: Return 4, and the first 4 characters of the input array should be: ["a
// ","b","1","2"].
// Explanation: The groups are "a" and "bbbbbbbbbbbb". This compresses to "ab12".
//
//
// Example 4:
//
//
// Input: chars = ["a","a","a","b","b","a","a"]
// Output: Return 6, and the first 6 characters of the input array should be: ["a
// ","3","b","2","a","2"].
// Explanation: The groups are "aaa", "bb", and "aa". This compresses to "a3b2a2"
// . Note that each group is independent even if two groups have the same character
// .
//
//
//
// Constraints:
//
//
// 1 <= chars.length <= 2000
// chars[i] is a lower-case English letter, upper-case English letter, digit, or
// symbol.
//
// Related Topics String
// 👍 1156 👎 3036
/*
  O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for String Compression.
  O(1)     Memory Usage: 38.6 MB, less than 68.48% of Java online submissions for String Compression.
*/
// leetcode submit region begin(Prohibit modification and deletion)
public class StringCompression_443 {
  public int compress(char[] chars) {
    if (chars.length == 0) {
      return 0;
    }

    char prev = chars[0];
    int insertionSpot = 0;
    int count = 0;
    for (char aChar : chars) {
      if (prev != aChar) {
        insertionSpot = compressSubstring(chars, prev, insertionSpot, count);
        count = 0;
      }
      count++;
      prev = aChar;
    }

    return compressSubstring(chars, prev, insertionSpot, count);
  }

  private int compressSubstring(char[] chars, char charToCompress, int insertionSpot, int count) {
    chars[insertionSpot++] = charToCompress;

    if (count == 1) {
      return insertionSpot;
    }

    String countAsStr = String.valueOf(count);
    for (int j = 0; j < countAsStr.length(); ++j) {
      chars[insertionSpot++] = countAsStr.charAt(j);
    }

    return insertionSpot;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
