package com.leetcode.hashtable.easy;

// Given a string, determine if a permutation of the string could form a palindro
// me.
//
// Example 1:
//
//
// Input: "code"
// Output: false
//
// Example 2:
//
//
// Input: "aab"
// Output: true
//
// Example 3:
//
//
// Input: "carerac"
// Output: true
// Related Topics Hash Table
// 👍 465 👎 56

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Palindrome Permutation.
 O(1) Memory Usage: 36.8 MB, less than 63.75% of Java online submissions for Palindrome Permutation.
*/
public class PalindromePermutation_266 {
  public boolean canPermutePalindrome(String s) {
    int[] counter = new int[26];

    for (int i = 0; i < s.length(); i++) {
      counter[s.charAt(i) - 'a']++;
    }
    int odd = 0;
    for (int j : counter) {
      if (j % 2 == 1) {
        odd++;
      }
    }
    return odd < 2;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
