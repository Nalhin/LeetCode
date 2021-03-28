package com.leetcode.math.medium;

// Given a non-empty string containing an out-of-order English representation of
// digits 0-9, output the digits in ascending order.
//
// Note:
//
// Input contains only lowercase English letters.
// Input is guaranteed to be valid and can be transformed to its original digits
// . That means invalid inputs such as "abc" or "zerone" are not permitted.
// Input length is less than 50,000.
//
//
//
// Example 1:
//
// Input: "owoztneoer"
//
// Output: "012"
//
//
//
// Example 2:
//
// Input: "fviefuro"
//
// Output: "45"
//
// Related Topics Math
// 👍 295 👎 896
/*
 O(n) Runtime: 5 ms, faster than 66.18% of Java online submissions for Reconstruct Original Digits from English.
 O(1) Memory Usage: 39.4 MB, less than 71.98% of Java online submissions for Reconstruct Original Digits from English.
*/
// leetcode submit region begin(Prohibit modification and deletion)
public class ReconstructOriginalDigitsFromEnglish_423 {
  public String originalDigits(String str) {
    int[] counter = new int[26];
    for (int i = 0; i < str.length(); i++) {
      counter[str.charAt(i) - 'a']++;
    }

    int[] result = new int[10];
    result[0] = getCount(counter, 'z');
    result[2] = getCount(counter, 'w');
    result[4] = getCount(counter, 'u');
    result[6] = getCount(counter, 'x');
    result[8] = getCount(counter, 'g');
    result[3] = getCount(counter, 'h') - result[8];
    result[5] = getCount(counter, 'f') - result[4];
    result[7] = getCount(counter, 's') - result[6];
    result[9] = getCount(counter, 'i') - result[5] - result[6] - result[8];
    result[1] = getCount(counter, 'n') - result[7] - 2 * result[9];

    StringBuilder output = new StringBuilder();
    for (int i = 0; i < 10; i++) {
      output.append(String.valueOf(i).repeat(result[i]));
    }
    return output.toString();
  }

  private int getCount(int[] counter, char letter) {
    return counter[letter - 'a'];
  }
}
// leetcode submit region end(Prohibit modification and deletion)
