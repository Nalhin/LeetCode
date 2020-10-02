package com.leetcode.strings.easy;

// Given a valid (IPv4) IP address, return a defanged version of that IP address.
//
//
// A defanged IP address replaces every period "." with "[.]".
//
//
// Example 1:
// Input: address = "1.1.1.1"
// Output: "1[.]1[.]1[.]1"
// Example 2:
// Input: address = "255.100.50.0"
// Output: "255[.]100[.]50[.]0"
//
//
// Constraints:
//
//
// The given address is a valid IPv4 address.
// Related Topics String
// 👍 483 👎 931

// leetcode submit region begin(Prohibit modification and deletion)
public class DefangingAnIPAddress_1108 {
  public String defangIPaddr(String address) {
    StringBuilder builder = new StringBuilder();

    for (char c : address.toCharArray()) {
      if (c == '.') {
        builder.append("[.]");
      } else {
        builder.append(c);
      }
    }
    return builder.toString();
  }
}
/*
 O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Defanging an IP Address.
 O(n) Memory Usage: 37.4 MB, less than 55.30% of Java online submissions for Defanging an IP Address.
*/
// leetcode submit region end(Prohibit modification and deletion)
