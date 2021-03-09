package com.leetcode.strings.easy;

// In a string s of lowercase letters, these letters form consecutive groups of t
// he same character.
//
// For example, a string like s = "abbxxxxzyy" has the groups "a", "bb", "xxxx",
// "z", and "yy".
//
// A group is identified by an interval [start, end], where start and end denote
// the start and end indices (inclusive) of the group. In the above example, "xxxx
// " has the interval [3,6].
//
// A group is considered large if it has 3 or more characters.
//
// Return the intervals of every large group sorted in increasing order by start
// index.
//
//
// Example 1:
//
//
// Input: s = "abbxxxxzzy"
// Output: [[3,6]]
// Explanation: "xxxx" is the only large group with start index 3 and end index 6
// .
//
//
// Example 2:
//
//
// Input: s = "abc"
// Output: []
// Explanation: We have groups "a", "b", and "c", none of which are large groups.
//
//
//
// Example 3:
//
//
// Input: s = "abcdddeeeeaabbbcd"
// Output: [[3,5],[6,9],[12,14]]
// Explanation: The large groups are "ddd", "eeee", and "bbb".
//
//
// Example 4:
//
//
// Input: s = "aba"
// Output: []
//
//
//
// Constraints:
//
//
// 1 <= s.length <= 1000
// s contains lower-case English letters only.
//
// Related Topics Array
// 👍 459 👎 99
/*
 O(n) Runtime: 1 ms, faster than 100.00% of Java online submissions for Positions of Large Groups.
 O(n) Memory Usage: 39.3 MB, less than 39.73% of Java online submissions for Positions of Large Groups.
*/
// leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;

public class PositionsOfLargeGroups_830 {
  public List<List<Integer>> largeGroupPositions(String str) {
    List<List<Integer>> result = new ArrayList<>();

    int occurrences = 1;

    for (int i = 1; i < str.length(); i++) {
      if (str.charAt(i) == str.charAt(i - 1)) {
        occurrences++;
      } else {
        if (occurrences >= 3) {
          result.add(List.of(i - occurrences, i - 1));
        }
        occurrences = 1;
      }
    }

    if (occurrences >= 3) {
      result.add(List.of(str.length() - occurrences, str.length() - 1));
    }

    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
