package com.leetcode.hashtable.easy;

// You're given strings J representing the types of stones that are jewels, and S
// representing the stones you have. Each character in S is a type of stone you ha
// ve. You want to know how many of the stones you have are also jewels.
//
// The letters in J are guaranteed distinct, and all characters in J and S are l
// etters. Letters are case sensitive, so "a" is considered a different type of sto
// ne from "A".
//
// Example 1:
//
//
// Input: J = "aA", S = "aAAbbbb"
// Output: 3
//
//
// Example 2:
//
//
// Input: J = "z", S = "ZZ"
// Output: 0
//
//
// Note:
//
//
// S and J will consist of letters and have length at most 50.
// The characters in J are distinct.
//
// Related Topics Hash Table
// 👍 2255 👎 378

import java.util.Set;
import java.util.stream.Collectors;

// leetcode submit region begin(Prohibit modification and deletion)
public class JewelsAndStones_771 {
  public int numJewelsInStones(String J, String S) {
    Set<Character> jewels = J.chars().mapToObj(chr -> (char) chr).collect(Collectors.toSet());

    return (int) S.chars().mapToObj(chr -> (char) chr).filter(jewels::contains).count();
  }
}

/*
O(n) Runtime: 6 ms, faster than 5.07% of Java online submissions for Jewels and Stones.
O(1) Memory Usage: 37.6 MB, less than 91.21% of Java online submissions for Jewels and Stones.
*/
// leetcode submit region end(Prohibit modification and deletion)
