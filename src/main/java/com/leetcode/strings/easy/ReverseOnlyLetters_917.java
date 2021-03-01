package com.leetcode.strings.easy;

// Given a string S, return the "reversed" string where all characters that are n
// ot a letter stay in the same place, and all letters reverse their positions.
//
//
//
//
//
//
//
//
//
//
//
//
//
// Example 1:
//
//
// Input: "ab-cd"
// Output: "dc-ba"
//
//
//
// Example 2:
//
//
// Input: "a-bC-dEf-ghIj"
// Output: "j-Ih-gfE-dCba"
//
//
//
// Example 3:
//
//
// Input: "Test1ng-Leet=code-Q!"
// Output: "Qedo1ct-eeLg=ntse-T!"
//
//
//
//
//
// Note:
//
//
// S.length <= 100
// 33 <= S[i].ASCIIcode <= 122
// S doesn't contain \ or "
//
//
//
//
// Related Topics String
// 👍 756 👎 42

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Only Letters.
 O(1) Memory Usage: 37.2 MB, less than 75.57% of Java online submissions for Reverse Only Letters.
*/
public class ReverseOnlyLetters_917 {
  public String reverseOnlyLetters(String str) {
    char[] word = str.toCharArray();

    int left = 0;
    int right = str.length() - 1;

    while (left < right) {

      while (left < str.length() && !Character.isLetter(str.charAt(left))) {
        left++;
      }
      while (right >= 0 && !Character.isLetter(str.charAt(right))) {
        right--;
      }

      if (left < right) {
        char temp = word[left];
        word[left] = word[right];
        word[right] = temp;
        left++;
        right--;
      }
    }

    return new String(word);
  }
}
// leetcode submit region end(Prohibit modification and deletion)
