package com.leetcode.strings.medium;

// You are given a 0-indexed string s and a 0-indexed integer array spaces that
// describes the indices in the original string where spaces will be added. Each
// space should be inserted before the character at the given index.
//
//
// For example, given s = "EnjoyYourCoffee" and spaces = [5, 9], we place
// spaces before 'Y' and 'C', which are at indices 5 and 9 respectively. Thus, we obtain
// "Enjoy Your Coffee".
//
//
// Return the modified string after the spaces have been added.
//
//
// Example 1:
//
//
// Input: s = "LeetcodeHelpsMeLearn", spaces = [8,13,15]
// Output: "Leetcode Helps Me Learn"
// Explanation:
// The indices 8, 13, and 15 correspond to the underlined characters in
// "LeetcodeHelpsMeLearn".
// We then place spaces before those characters.
//
//
// Example 2:
//
//
// Input: s = "icodeinpython", spaces = [1,5,7,9]
// Output: "i code in py thon"
// Explanation:
// The indices 1, 5, 7, and 9 correspond to the underlined characters in
// "icodeinpython".
// We then place spaces before those characters.
//
//
// Example 3:
//
//
// Input: s = "spacing", spaces = [0,1,2,3,4,5,6]
// Output: " s p a c i n g"
// Explanation:
// We are also able to place spaces before the first character of the string.
//
//
//
// Constraints:
//
//
// 1 <= s.length <= 3 * 10⁵
// s consists only of lowercase and uppercase English letters.
// 1 <= spaces.length <= 3 * 10⁵
// 0 <= spaces[i] <= s.length - 1
// All the values of spaces are strictly increasing.
//
// Related Topics Array String Simulation 👍 128 👎 10
/*
 O(n+m) Runtime: 23 ms, faster than 83.29% of Java online submissions for Adding Spaces to a String.
 O(n+m) Memory Usage: 72.3 MB, less than 88.75% of Java online submissions for Adding Spaces to a String.
*/
// leetcode submit region begin(Prohibit modification and deletion)
public class AddingSpacesToAString_2109 {
  public String addSpaces(String s, int[] spaces) {

    int spacesIdx = 0;
    StringBuilder result = new StringBuilder();

    for (int i = 0; i < s.length(); i++) {
      if (spacesIdx < spaces.length && spaces[spacesIdx] == i) {
        spacesIdx++;
        result.append(" ");
      }
      result.append(s.charAt(i));
    }

    return result.toString();
  }
}
// leetcode submit region end(Prohibit modification and deletion)
