package com.leetcode.strings.easy;

// Given a string, you need to reverse the order of characters in each word withi
// n a sentence while still preserving whitespace and initial word order.
//
// Example 1:
//
// Input: "Let's take LeetCode contest"
// Output: "s'teL ekat edoCteeL tsetnoc"
//
//
//
// Note:
// In the string, each word is separated by single space and there will not be an
// y extra space in the string.
// Related Topics String
// 👍 1169 👎 94

// leetcode submit region begin(Prohibit modification and deletion)

public class ReverseWordsInAStringIII_557 {
  public String reverseWords(String s) {
    char[] word = s.toCharArray();

    int slow = 0;
    for (int fast = 0; fast < word.length; fast++) {
      if (word[fast] == ' ') {
        reverseWord(word, slow, fast - 1);
        slow = fast + 1;
      }
    }
    reverseWord(word, slow, word.length - 1);
    return new String(word);
  }

  private void reverseWord(char[] str, int first, int last) {
    while (first < last) {
      char temp = str[last];
      str[last] = str[first];
      str[first] = temp;
      first++;
      last--;
    }
  }
}
/*
  O(n)  Runtime: 6 ms, faster than 58.86% of Java online submissions for Reverse Words in a String III.
  O(1)  Memory Usage: 45.9 MB, less than 21.32% of Java online submissions for Reverse Words in a String III.
*/
// leetcode submit region end(Prohibit modification and deletion)
