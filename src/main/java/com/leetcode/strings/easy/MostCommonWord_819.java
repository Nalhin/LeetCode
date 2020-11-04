package com.leetcode.strings.easy;

// Given a paragraph and a list of banned words, return the most frequent word th
// at is not in the list of banned words. It is guaranteed there is at least one wo
// rd that isn't banned, and that the answer is unique.
//
// Words in the list of banned words are given in lowercase, and free of punctua
// tion. Words in the paragraph are not case sensitive. The answer is in lowercase.
//
//
//
//
// Example:
//
//
// Input:
// paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
// banned = ["hit"]
// Output: "ball"
// Explanation:
// "hit" occurs 3 times, but it is a banned word.
// "ball" occurs twice (and no other word does), so it is the most frequent non-b
// anned word in the paragraph.
// Note that words in the paragraph are not case sensitive,
// that punctuation is ignored (even if adjacent to words, such as "ball,"),
// and that "hit" isn't the answer even though it occurs more because it is banne
// d.
//
//
//
//
// Note:
//
//
// 1 <= paragraph.length <= 1000.
// 0 <= banned.length <= 100.
// 1 <= banned[i].length <= 10.
// The answer is unique, and written in lowercase (even if its occurrences in pa
// ragraph may have uppercase symbols, and even if it is a proper noun.)
// paragraph only consists of letters, spaces, or the punctuation symbols !?',;.
//
// There are no hyphens or hyphenated words.
// Words only consist of letters, never apostrophes or other punctuation symbols
// .
//
// Related Topics String
// 👍 788 👎 1834

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
/*
 O(n + m) Runtime: 15 ms, faster than 53.64% of Java online submissions for Most Common Word.
 O(n + m) Memory Usage: 39.2 MB, less than 5.41% of Java online submissions for Most Common Word.
*/
public class MostCommonWord_819 {
  public String mostCommonWord(String paragraph, String[] banned) {
    Set<String> bannedSet = Arrays.stream(banned).collect(Collectors.toSet());
    return Arrays.stream(paragraph.replaceAll("[!?',;.]", " ").split(" "))
        .map(String::toLowerCase)
        .filter(s -> !s.isEmpty())
        .filter(a -> !bannedSet.contains(a))
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
        .entrySet()
        .stream()
        .max(Comparator.comparingLong(Map.Entry::getValue))
        .map(Map.Entry::getKey)
        .get();
  }
}
// leetcode submit region end(Prohibit modification and deletion)
