package com.leetcode.strings.medium;

// We have a string S of lowercase letters, and an integer array shifts.
//
// Call the shift of a letter, the next letter in the alphabet, (wrapping around
// so that 'z' becomes 'a').
//
// For example, shift('a') = 'b', shift('t') = 'u', and shift('z') = 'a'.
//
// Now for each shifts[i] = x, we want to shift the first i+1 letters of S, x ti
// mes.
//
// Return the final string after all such shifts to S are applied.
//
// Example 1:
//
//
// Input: S = "abc", shifts = [3,5,9]
// Output: "rpl"
// Explanation:
// We start with "abc".
// After shifting the first 1 letters of S by 3, we have "dbc".
// After shifting the first 2 letters of S by 5, we have "igc".
// After shifting the first 3 letters of S by 9, we have "rpl", the answer.
//
//
// Note:
//
//
// 1 <= S.length = shifts.length <= 20000
// 0 <= shifts[i] <= 10 ^ 9
//
// Related Topics String
// 👍 350 👎 67

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(n) Runtime: 5 ms, faster than 38.55% of Java online submissions for Shifting Letters.
 O(n) Memory Usage: 41.3 MB, less than 52.46% of Java online submissions for Shifting Letters.
*/
public class ShiftingLetters_848 {
  public String shiftingLetters(String s, int[] shifts) {
    int prefix = 0;
    StringBuilder sb = new StringBuilder();

    for (int i = s.length() - 1; i >= 0; i--) {
      prefix = (prefix + shifts[i]) % 26;
      int curr = s.charAt(i) - 'a';
      int transformed = (curr + prefix) % 26;
      sb.append((char) (transformed + 'a'));
    }

    return sb.reverse().toString();
  }
}
// leetcode submit region end(Prohibit modification and deletion)
