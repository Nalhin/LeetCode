package easy;

// Write a function that reverses a string. The input string is given as an array
// of characters char[].
//
// Do not allocate extra space for another array, you must do this by modifying
// the input array in-place with O(1) extra memory.
//
// You may assume all the characters consist of printable ascii characters.
//
//
//
//
// Example 1:
//
//
// Input: ["h","e","l","l","o"]
// Output: ["o","l","l","e","h"]
//
//
//
// Example 2:
//
//
// Input: ["H","a","n","n","a","h"]
// Output: ["h","a","n","n","a","H"]
//
//
//
// Related Topics Two Pointers String
// 👍 1623 👎 715

// leetcode submit region begin(Prohibit modification and deletion)

public class ReverseString_344 {
  public void reverseString(char[] s) {
    int left = 0;
    int right = s.length - 1;

    while (left < right) {
      char temp = s[right];
      s[right--] = s[left];
      s[left++] = temp;
    }
  }
}

/*
    Runtime: 1 ms, faster than 69.60% of Java online submissions for Reverse String.
    Memory Usage: 53.5 MB, less than 14.01% of Java online submissions for Reverse String.
 */

// leetcode submit region end(Prohibit modification and deletion)
