package com.leetcode.strings.easy;

// Given a string s of lower and upper case English letters.
//
// A good string is a string which doesn't have two adjacent characters s[i] and
// s[i + 1] where:
//
//
// 0 <= i <= s.length - 2
// s[i] is a lower-case letter and s[i + 1] is the same letter but in upper-case
// or vice-versa.
//
//
// To make the string good, you can choose two adjacent characters that make the
// string bad and remove them. You can keep doing this until the string becomes go
// od.
//
// Return the string after making it good. The answer is guaranteed to be unique
// under the given constraints.
//
// Notice that an empty string is also good.
//
//
// Example 1:
//
//
// Input: s = "leEeetcode"
// Output: "leetcode"
// Explanation: In the first step, either you choose i = 1 or i = 2, both will re
// sult "leEeetcode" to be reduced to "leetcode".
//
//
// Example 2:
//
//
// Input: s = "abBAcC"
// Output: ""
// Explanation: We have many possible scenarios, and all lead to the same answer.
// For example:
// "abBAcC" --> "aAcC" --> "cC" --> ""
// "abBAcC" --> "abBA" --> "aA" --> ""
//
//
// Example 3:
//
//
// Input: s = "s"
// Output: "s"
//
//
//
// Constraints:
//
//
// 1 <= s.length <= 100
// s contains only lower and upper case English letters.
// Related Topics String Stack
// 👍 336 👎 36

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayDeque;
import java.util.Deque;
/*
 O(n) Runtime: 2 ms, faster than 87.84% of Java online submissions for Make The String Great.
 O(n) Memory Usage: 38.8 MB, less than 64.49% of Java online submissions for Make The String Great.
*/
public class MakeTheStringGreat_1544 {
  public String makeGood(String s) {
    Deque<Character> stack = new ArrayDeque<>();

    for (int i = 0; i < s.length(); i++) {
      if (!stack.isEmpty()
          && stack.peek() != s.charAt(i)
          && Character.toLowerCase(stack.peek()) == Character.toLowerCase(s.charAt(i))) {
        stack.pop();
        continue;
      }

      stack.push(s.charAt(i));
    }

    StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
      sb.append(stack.removeLast());
    }

    return sb.toString();
  }
}
// leetcode submit region end(Prohibit modification and deletion)
