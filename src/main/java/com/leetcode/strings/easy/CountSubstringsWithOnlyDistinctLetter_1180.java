package com.leetcode.strings.easy;

// Given a string S, return the number of substrings that have only one distinct
// letter.
//
//
// Example 1:
//
//
// Input: S = "aaaba"
// Output: 8
// Explanation: The substrings with one distinct letter are "aaa", "aa", "a", "b"
// .
// "aaa" occurs 1 time.
// "aa" occurs 2 times.
// "a" occurs 4 times.
// "b" occurs 1 time.
// So the answer is 1 + 2 + 4 + 1 = 8.
//
//
// Example 2:
//
//
// Input: S = "aaaaaaaaaa"
// Output: 55
//
//
//
// Constraints:
//
//
// 1 <= S.length <= 1000
// S[i] consists of only lowercase English letters.
//
// Related Topics Math String
// 👍 149 👎 31

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Count Substrings with Only One Distinct Letter.
 O(1) Memory Usage: 36.5 MB, less than 91.47% of Java online submissions for Count Substrings with Only One Distinct Letter.
*/
public class CountSubstringsWithOnlyDistinctLetter_1180 {
  public int countLetters(String str) {
    int ans = 0;
    int count = 1;

    for (int i = 1; i < str.length(); i++) {
      if (str.charAt(i - 1) != str.charAt(i)) {
        ans += getCount(count);
        count = 0;
      }
      count++;
    }
    return ans + getCount(count);
  }

  private int getCount(int n) {
    return n * (n + 1) / 2;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
