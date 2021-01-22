package com.leetcode.strings.medium;

// You are given two strings a and b of the same length. Choose an index and spli
// t both strings at the same index, splitting a into two strings: aprefix and asuf
// fix where a = aprefix + asuffix, and splitting b into two strings: bprefix and b
// suffix where b = bprefix + bsuffix. Check if aprefix + bsuffix or bprefix + asuf
// fix forms a palindrome.
//
// When you split a string s into sprefix and ssuffix, either ssuffix or sprefix
// is allowed to be empty. For example, if s = "abc", then "" + "abc", "a" + "bc",
// "ab" + "c" , and "abc" + "" are valid splits.
//
// Return true if it is possible to form a palindrome string, otherwise return f
// alse.
//
// Notice that x + y denotes the concatenation of strings x and y.
//
//
// Example 1:
//
//
// Input: a = "x", b = "y"
// Output: true
// Explaination: If either a or b are palindromes the answer is true since you ca
// n split in the following way:
// aprefix = "", asuffix = "x"
// bprefix = "", bsuffix = "y"
// Then, aprefix + bsuffix = "" + "y" = "y", which is a palindrome.
//
//
// Example 2:
//
//
// Input: a = "abdef", b = "fecab"
// Output: true
//
//
// Example 3:
//
//
// Input: a = "ulacfd", b = "jizalu"
// Output: true
// Explaination: Split them at index 3:
// aprefix = "ula", asuffix = "cfd"
// bprefix = "jiz", bsuffix = "alu"
// Then, aprefix + bsuffix = "ula" + "alu" = "ulaalu", which is a palindrome.
//
//
// Example 4:
//
//
// Input: a = "xbdef", b = "xecab"
// Output: false
//
//
//
// Constraints:
//
//
// 1 <= a.length, b.length <= 105
// a.length == b.length
// a and b consist of lowercase English letters
//
// Related Topics Two Pointers String Greedy
// 👍 239 👎 141

// leetcode submit region begin(Prohibit modification and deletion)

public class SplitTwoStringToMakePalindrome_1616 {
  public boolean checkPalindromeFormation(String a, String b) {
    return checkPair(a, b) || checkPair(b, a);
  }

  private boolean checkPair(String a, String b) {
    int left = 0;
    int right = a.length() - 1;

    while (left <= right && a.charAt(left) == b.charAt(right)) {
      left++;
      right--;
    }

    return checkPalindrome(left, right, a) || checkPalindrome(left, right, b);
  }

  private boolean checkPalindrome(int left, int right, String str) {
    while (left <= right && str.charAt(left) == str.charAt(right)) {
      left++;
      right--;
    }

    return left >= right;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
