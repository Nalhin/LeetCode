package com.leetcode.strings.easy;

// Given a sentence text (A sentence is a string of space-separated words) in the
// following format:
//
//
// First letter is in upper case.
// Each word in text are separated by a single space.
//
//
// Your task is to rearrange the words in text such that all words are rearrange
// d in an increasing order of their lengths. If two words have the same length, ar
// range them in their original order.
//
// Return the new text following the format shown above.
//
//
// Example 1:
//
//
// Input: text = "Leetcode is cool"
// Output: "Is cool leetcode"
// Explanation: There are 3 words, "Leetcode" of length 8, "is" of length 2 and "
// cool" of length 4.
// Output is ordered by length and the new first word starts with capital letter.
//
//
//
// Example 2:
//
//
// Input: text = "Keep calm and code on"
// Output: "On and keep calm code"
// Explanation: Output is ordered as follows:
// "On" 2 letters.
// "and" 3 letters.
// "keep" 4 letters in case of tie order by position in original text.
// "calm" 4 letters.
// "code" 4 letters.
//
//
// Example 3:
//
//
// Input: text = "To be or not to be"
// Output: "To be or to be not"
//
//
//
// Constraints:
//
//
// text begins with a capital letter and then contains lowercase letters and sin
// gle space between words.
// 1 <= text.length <= 10^5
//
// Related Topics String Sort
// 👍 244 👎 49

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.Arrays;
import java.util.Comparator;
/*
 O(nlog(n)) Runtime: 20 ms, faster than 75.85% of Java online submissions for Rearrange Words in a Sentence.
 O(n) Memory Usage: 40.5 MB, less than 43.60% of Java online submissions for Rearrange Words in a Sentence.
*/
public class RearrangeWordsInASentence_1451 {
  public String arrangeWords(String text) {
    String[] strings = text.toLowerCase().split(" ");

    Arrays.sort(strings, Comparator.comparingInt(String::length));
    strings[0] = strings[0].substring(0, 1).toUpperCase() + strings[0].substring(1);

    return String.join(" ", strings);
  }
}
// leetcode submit region end(Prohibit modification and deletion)
