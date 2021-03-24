package com.leetcode.strings.medium;

// You are given a string s consisting only of characters 'a' and 'b'.
//
// You can delete any number of characters in s to make s balanced. s is balance
// d if there is no pair of indices (i,j) such that i < j and s[i] = 'b' and s[j]=
// 'a'.
//
// Return the minimum number of deletions needed to make s balanced.
//
//
// Example 1:
//
//
// Input: s = "aababbab"
// Output: 2
// Explanation: You can either:
// Delete the characters at 0-indexed positions 2 and 6 ("aababbab" -> "aaabbb"),
// or
// Delete the characters at 0-indexed positions 3 and 6 ("aababbab" -> "aabbbb").
//
//
//
// Example 2:
//
//
// Input: s = "bbaaaaabb"
// Output: 2
// Explanation: The only solution is to delete the first two characters.
//
//
//
// Constraints:
//
//
// 1 <= s.length <= 105
// s[i] is 'a' or 'b'.
//
// Related Topics String Greedy
// 👍 275 👎 8
/*
 O(n) Runtime: 48 ms, faster than 28.71% of Java online submissions for Minimum Deletions to Make String Balanced.
 O(1) Memory Usage: 39.5 MB, less than 76.56% of Java online submissions for Minimum Deletions to Make String Balanced.
*/
// leetcode submit region begin(Prohibit modification and deletion)

public class MinimumDeletionsToMakeStringBalanced_1653 {
  public int minimumDeletions(String s) {

    int aRight = 0;
    for (int i = 0; i < s.length(); i++) {
      aRight += s.charAt(i) == 'a' ? 1 : 0;
    }

    int bLeft = 0;
    int result = s.length();
    for (int i = 0; i < s.length(); i++) {
      result = Math.min(result, bLeft + aRight);
      bLeft += s.charAt(i) == 'b' ? 1 : 0;
      aRight -= s.charAt(i) == 'a' ? 1 : 0;
    }

    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
