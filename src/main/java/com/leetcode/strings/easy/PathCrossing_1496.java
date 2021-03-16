package com.leetcode.strings.easy;

// Given a string path, where path[i] = 'N', 'S', 'E' or 'W', each representing m
// oving one unit north, south, east, or west, respectively. You start at the origi
// n (0, 0) on a 2D plane and walk on the path specified by path.
//
// Return True if the path crosses itself at any point, that is, if at any time
// you are on a location you've previously visited. Return False otherwise.
//
//
// Example 1:
//
//
//
//
// Input: path = "NES"
// Output: false
// Explanation: Notice that the path doesn't cross any point more than once.
//
//
// Example 2:
//
//
//
//
// Input: path = "NESWW"
// Output: true
// Explanation: Notice that the path visits the origin twice.
//
//
// Constraints:
//
//
// 1 <= path.length <= 10^4
// path will only consist of characters in {'N', 'S', 'E', 'W}
//
// Related Topics String
// 👍 275 👎 6
/*
 O(n) Runtime: 1 ms, faster than 92.12% of Java online submissions for Path Crossing.
 O(n) Memory Usage: 37.4 MB, less than 96.40% of Java online submissions for Path Crossing.
*/
// leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PathCrossing_1496 {
  private static final int MAX_VAL = 10000;
  private static final Map<Character, int[]> map =
      Map.of(
          'N', new int[] {1, 0},
          'E', new int[] {0, 1},
          'S', new int[] {-1, 0},
          'W', new int[] {0, -1});

  public boolean isPathCrossing(String path) {

    int row = 0;
    int col = 0;
    Set<Integer> visited = new HashSet<>();
    visited.add(hash(row, col));

    for (int i = 0; i < path.length(); i++) {
      int[] move = map.get(path.charAt(i));
      row += move[0];
      col += move[1];
      int hashed = hash(row, col);
      if (visited.contains(hashed)) {
        return true;
      }
      visited.add(hashed);
    }

    return false;
  }

  private int hash(int row, int col) {
    return row + col * MAX_VAL;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
