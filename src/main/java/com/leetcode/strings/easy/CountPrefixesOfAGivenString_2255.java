package com.leetcode.strings.easy;

// You are given a string array words and a string s, where words[i] and s
// comprise only of lowercase English letters.
//
// Return the number of strings in words that are a prefix of s.
//
// A prefix of a string is a substring that occurs at the beginning of the
// string. A substring is a contiguous sequence of characters within a string.
//
//
// Example 1:
//
//
// Input: words = ["a","b","c","ab","bc","abc"], s = "abc"
// Output: 3
// Explanation:
// The strings in words which are a prefix of s = "abc" are:
// "a", "ab", and "abc".
// Thus the number of strings in words which are a prefix of s is 3.
//
// Example 2:
//
//
// Input: words = ["a","a"], s = "aa"
// Output: 2
// Explanation:
// Both of the strings are a prefix of s.
// Note that the same string can occur multiple times in words, and it should be
// counted each time.
//
//
// Constraints:
//
//
// 1 <= words.length <= 1000
// 1 <= words[i].length, s.length <= 10
// words[i] and s consist of lowercase English letters only.
//
// 👍 16 👎 0
/*
  O(n * m) Runtime: 1 ms, faster than 100.00% of Java online submissions for Count Prefixes of a Given String.
  O(1) Memory Usage: 42.3 MB, less than 100.00% of Java online submissions for Count Prefixes of a Given String.
*/
// leetcode submit region begin(Prohibit modification and deletion)

public class CountPrefixesOfAGivenString_2255 {
  public int countPrefixes(String[] words, String s) {
    int count = 0;
    for (String word : words) {
      if (s.startsWith(word)) {
        count++;
      }
    }

    return count;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
