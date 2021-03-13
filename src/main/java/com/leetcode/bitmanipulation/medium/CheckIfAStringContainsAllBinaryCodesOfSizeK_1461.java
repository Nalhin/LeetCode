package com.leetcode.bitmanipulation.medium;

// Given a binary string s and an integer k.
//
// Return True if every binary code of length k is a substring of s. Otherwise,
// return False.
//
//
// Example 1:
//
//
// Input: s = "00110110", k = 2
// Output: true
// Explanation: The binary codes of length 2 are "00", "01", "10" and "11". They
// can be all found as substrings at indicies 0, 1, 3 and 2 respectively.
//
//
// Example 2:
//
//
// Input: s = "00110", k = 2
// Output: true
//
//
// Example 3:
//
//
// Input: s = "0110", k = 1
// Output: true
// Explanation: The binary codes of length 1 are "0" and "1", it is clear that bo
// th exist as a substring.
//
//
// Example 4:
//
//
// Input: s = "0110", k = 2
// Output: false
// Explanation: The binary code "00" is of length 2 and doesn't exist in the arra
// y.
//
//
// Example 5:
//
//
// Input: s = "0000000001011100", k = 4
// Output: false
//
//
//
// Constraints:
//
//
// 1 <= s.length <= 5 * 10^5
// s consists of 0's and 1's only.
// 1 <= k <= 20
//
// Related Topics String Bit Manipulation
// 👍 424 👎 55

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashSet;
import java.util.Set;
/*
 O(nk) Runtime: 86 ms, faster than 67.18% of Java online submissions for Check If a String Contains All Binary Codes of Size K.
 O(nk) Memory Usage: 49.9 MB, less than 55.60% of Java online submissions for Check If a String Contains All Binary Codes of Size K.
*/
public class CheckIfAStringContainsAllBinaryCodesOfSizeK_1461 {
  public boolean hasAllCodes(String s, int k) {
    int goal = 1 << k;
    Set<String> visited = new HashSet<>();

    for (int i = k; i < s.length() && visited.size() < goal; i++) {
      visited.add(s.substring(i - k, i));
    }
    return visited.size() == goal;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
