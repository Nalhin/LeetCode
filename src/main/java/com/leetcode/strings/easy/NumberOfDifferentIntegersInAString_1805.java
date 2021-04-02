package com.leetcode.strings.easy;

// You are given a string word that consists of digits and lowercase English lett
// ers.
//
// You will replace every non-digit character with a space. For example, "a123bc
// 34d8ef34" will become " 123 34 8 34". Notice that you are left with some integer
// s that are separated by at least one space: "123", "34", "8", and "34".
//
// Return the number of different integers after performing the replacement oper
// ations on word.
//
// Two integers are considered different if their decimal representations withou
// t any leading zeros are different.
//
//
// Example 1:
//
//
// Input: word = "a123bc34d8ef34"
// Output: 3
// Explanation: The three different integers are "123", "34", and "8". Notice tha
// t "34" is only counted once.
//
//
// Example 2:
//
//
// Input: word = "leet1234code234"
// Output: 2
//
//
// Example 3:
//
//
// Input: word = "a1b01c001"
// Output: 1
// Explanation: The three integers "1", "01", and "001" all represent the same in
// teger because
// the leading zeros are ignored when comparing their decimal values.
//
//
//
// Constraints:
//
//
// 1 <= word.length <= 1000
// word consists of digits and lowercase English letters.
//
// Related Topics String
// 👍 89 👎 13
/*
  O(n) Runtime: 12 ms, faster than 20.64% of Java online submissions for Number of Different Integers in a String.
  O(n) Memory Usage: 39.5 MB, less than 20.55% of Java online submissions for Number of Different Integers in a String.
*/
// leetcode submit region begin(Prohibit modification and deletion)

import java.util.Arrays;
import java.util.stream.Collectors;

public class NumberOfDifferentIntegersInAString_1805 {
  public int numDifferentIntegers(String word) {
    return Arrays.stream(word.replaceAll("[^\\d]+", " ").split(" "))
        .filter(s -> !s.isEmpty())
        .map(s -> s.replaceFirst("^0+", ""))
        .collect(Collectors.toSet())
        .size();
  }
}
// leetcode submit region end(Prohibit modification and deletion)
