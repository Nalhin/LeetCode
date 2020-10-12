package com.leetcode.strings.easy;

// Given two strings A and B of lowercase letters, return true if you can swap tw
// o letters in A so the result is equal to B, otherwise, return false.
//
// Swapping letters is defined as taking two indices i and j (0-indexed) such th
// at i != j and swapping the characters at A[i] and A[j]. For example, swapping at
// indices 0 and 2 in "abcd" results in "cbad".
//
//
// Example 1:
//
//
// Input: A = "ab", B = "ba"
// Output: true
// Explanation: You can swap A[0] = 'a' and A[1] = 'b' to get "ba", which is equa
// l to B.
//
//
// Example 2:
//
//
// Input: A = "ab", B = "ab"
// Output: false
// Explanation: The only letters you can swap are A[0] = 'a' and A[1] = 'b', whic
// h results in "ba" != B.
//
//
// Example 3:
//
//
// Input: A = "aa", B = "aa"
// Output: true
// Explanation: You can swap A[0] = 'a' and A[1] = 'a' to get "aa", which is equa
// l to B.
//
//
// Example 4:
//
//
// Input: A = "aaaaaaabc", B = "aaaaaaacb"
// Output: true
//
//
// Example 5:
//
//
// Input: A = "", B = "aa"
// Output: false
//
//
//
// Constraints:
//
//
// 0 <= A.length <= 20000
// 0 <= B.length <= 20000
// A and B consist of lowercase letters.
//
// Related Topics String
// 👍 641 👎 443

// leetcode submit region begin(Prohibit modification and deletion)

public class BuddyStrings_859 {
  public boolean buddyStrings(String A, String B) {
    if (A.length() != B.length()) {
      return false;
    }

    int diffs = 0;
    char[] counter1 = new char[26];
    char[] counter2 = new char[26];
    for (int i = 0; i < A.length(); i++) {
      counter1[A.charAt(i) - 'a']++;
      counter2[B.charAt(i) - 'a']++;
      if (A.charAt(i) != B.charAt(i)) {
        diffs++;
      }
    }

    if (diffs == 0) {
      for (int i = 0; i < counter1.length; i++) {
        if (counter1[i] > 1 && counter2[i] > 1) {
          return true;
        }
      }
      return false;
    }

    if (diffs == 2) {
      for (int i = 0; i < counter1.length; i++) {
        if (counter1[i] != counter2[i]) {
          return false;
        }
      }
      return true;
    }

    return false;
  }
}
/*
 O(n) Runtime: 4 ms, faster than 26.71% of Java online submissions for Buddy Strings.
 O(1) Memory Usage: 38.8 MB, less than 7.78% of Java online submissions for Buddy Strings.
*/
// leetcode submit region end(Prohibit modification and deletion)
