package com.leetcode.strings.medium;

// Given two strings s and t, your goal is to convert s into t in k moves or less
// .
//
// During the ith (1 <= i <= k) move you can:
//
//
// Choose any index j (1-indexed) from s, such that 1 <= j <= s.length and j has
// not been chosen in any previous move, and shift the character at that index i t
// imes.
// Do nothing.
//
//
// Shifting a character means replacing it by the next letter in the alphabet (w
// rapping around so that 'z' becomes 'a'). Shifting a character by i means applyin
// g the shift operations i times.
//
// Remember that any index j can be picked at most once.
//
// Return true if it's possible to convert s into t in no more than k moves, oth
// erwise return false.
//
//
// Example 1:
//
//
// Input: s = "input", t = "ouput", k = 9
// Output: true
// Explanation: In the 6th move, we shift 'i' 6 times to get 'o'. And in the 7th
// move we shift 'n' to get 'u'.
//
//
// Example 2:
//
//
// Input: s = "abc", t = "bcd", k = 10
// Output: false
// Explanation: We need to shift each character in s one time to convert it into
// t. We can shift 'a' to 'b' during the 1st move. However, there is no way to shif
// t the other characters in the remaining moves to obtain t from s.
//
//
// Example 3:
//
//
// Input: s = "aab", t = "bbb", k = 27
// Output: true
// Explanation: In the 1st move, we shift the first 'a' 1 time to get 'b'. In the
// 27th move, we shift the second 'a' 27 times to get 'b'.
//
//
//
// Constraints:
//
//
// 1 <= s.length, t.length <= 10^5
// 0 <= k <= 10^9
// s, t contain only lowercase English letters.
//
// Related Topics String Greedy
// 👍 187 👎 146

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(n) Runtime: 19 ms, faster than 47.98% of Java online submissions for Can Convert String in K Moves.
 O(n) Memory Usage: 52.6 MB, less than 8.08% of Java online submissions for Can Convert String in K Moves.
*/
public class CanConvertStringInKMoves_1540 {

  private int ALPHABET_SIZE = 26;

  public boolean canConvertString(String s, String t, int k) {
    if (s.length() != t.length()) {
      return false;
    }

    int[] diff = new int[s.length()];

    for (int i = 0; i < s.length(); ++i) {
      diff[i] = (t.charAt(i) - s.charAt(i));
      if (diff[i] < 0) {
        diff[i] += ALPHABET_SIZE;
      }
    }

    int[] visited = new int[ALPHABET_SIZE];

    for (int curr : diff) {
      if (curr != 0) {
        if (visited[curr] * ALPHABET_SIZE + curr <= k) {
          visited[curr]++;
        } else {
          return false;
        }
      }
    }

    return true;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
