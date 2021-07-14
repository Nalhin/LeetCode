package com.leetcode.strings.medium;

// order and str are strings composed of lowercase letters. In order, no letter o
// ccurs more than once.
//
// order was sorted in some custom order previously. We want to permute the char
// acters of str so that they match the order that order was sorted. More specifica
// lly, if x occurs before y in order, then x should occur before y in the returned
// string.
//
// Return any permutation of str (as a string) that satisfies this property.
//
//
// Example:
// Input:
// order = "cba"
// str = "abcd"
// Output: "cbad"
// Explanation:
// "a", "b", "c" appear in order, so the order of "a", "b", "c" should be "c", "b
// ", and "a".
// Since "d" does not appear in order, it can be at any position in the returned
// string. "dcba", "cdba", "cbda" are also valid outputs.
//
//
//
//
// Note:
//
//
// order has length at most 26, and no character is repeated in order.
// str has length at most 200.
// order and str consist of lowercase letters only.
//
// Related Topics Hash Table String Sorting
// 👍 1328 👎 241
/*
 O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Custom Sort String.
 O(n) Memory Usage: 37.5 MB, less than 46.36% of Java online submissions for Custom Sort String.
*/
// leetcode submit region begin(Prohibit modification and deletion)
public class CustomSortString_791 {
  public String customSortString(String order, String str) {
    int[] count = new int[26];

    for (int i = 0; i < str.length(); i++) {
      count[str.charAt(i) - 'a']++;
    }

    StringBuilder result = new StringBuilder();

    for (int i = 0; i < order.length(); i++) {
      char c = order.charAt(i);
      result.append(Character.toString(c).repeat(count[c - 'a']));
      count[c - 'a'] = 0;
    }
    for (int i = 0; i < count.length; i++) {
      result.append(Character.toString(i + 'a').repeat(count[i]));
    }

    return result.toString();
  }
}
// leetcode submit region end(Prohibit modification and deletion)
