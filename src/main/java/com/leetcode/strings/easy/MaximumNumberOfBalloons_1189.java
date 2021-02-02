package com.leetcode.strings.easy;

// Given a string text, you want to use the characters of text to form as many in
// stances of the word "balloon" as possible.
//
// You can use each character in text at most once. Return the maximum number of
// instances that can be formed.
//
//
// Example 1:
//
//
//
//
// Input: text = "nlaebolko"
// Output: 1
//
//
// Example 2:
//
//
//
//
// Input: text = "loonbalxballpoon"
// Output: 2
//
//
// Example 3:
//
//
// Input: text = "leetcode"
// Output: 0
//
//
//
// Constraints:
//
//
// 1 <= text.length <= 10^4
// text consists of lower case English letters only.
// Related Topics Hash Table String
// 👍 448 👎 45

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(n) Runtime: 2 ms, faster than 74.75% of Java online submissions for Maximum Number of Balloons.
 O(1) Memory Usage: 39.4 MB, less than 15.20% of Java online submissions for Maximum Number of Balloons.
*/
public class MaximumNumberOfBalloons_1189 {
  private final String TARGET = "balloon";

  public int maxNumberOfBalloons(String text) {
    int[] counter = new int[26];

    for (int i = 0; i < text.length(); i++) {
      counter[text.charAt(i) - 'a']++;
    }

    int[] targetCounter = new int[26];
    for (int i = 0; i < TARGET.length(); i++) {
      targetCounter[TARGET.charAt(i) - 'a']++;
    }

    int result = Integer.MAX_VALUE;
    for (int i = 0; i < counter.length; i++) {
      if (targetCounter[i] != 0) {
        if (counter[i] == 0) {
          return 0;
        }
        result = Math.min(result, counter[i] / targetCounter[i]);
      }
    }

    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
