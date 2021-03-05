package com.leetcode.hashtable.medium;

// There is a brick wall in front of you. The wall is rectangular and has several
// rows of bricks. The bricks have the same height but different width. You want t
// o draw a vertical line from the top to the bottom and cross the least bricks.
//
// The brick wall is represented by a list of rows. Each row is a list of intege
// rs representing the width of each brick in this row from left to right.
//
// If your line go through the edge of a brick, then the brick is not considered
// as crossed. You need to find out how to draw the line to cross the least bricks
// and return the number of crossed bricks.
//
// You cannot draw a line just along one of the two vertical edges of the wall,
// in which case the line will obviously cross no bricks.
//
//
//
// Example:
//
//
// Input: [[1,2,2,1],
//        [3,1,2],
//        [1,3,2],
//        [2,4],
//        [3,1,2],
//        [1,3,1,1]]
//
// Output: 2
//
// Explanation:
//
//
//
//
//
// Note:
//
//
// The width sum of bricks in different rows are the same and won't exceed INT_M
// AX.
// The number of bricks in each row is in range [1,10,000]. The height of wall i
// s in range [1,10,000]. Total number of bricks of the wall won't exceed 20,000.
//
// Related Topics Hash Table
// 👍 1124 👎 56

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
 O(n) Runtime: 13 ms, faster than 26.90% of Java online submissions for Brick Wall.
 O(m) Memory Usage: 41.6 MB, less than 95.63% of Java online submissions for Brick Wall.
*/
public class BrickWall_554 {
  public int leastBricks(List<List<Integer>> wall) {

    Map<Integer, Integer> counter = new HashMap<>();

    for (List<Integer> entry : wall) {
      int curr = 0;

      for (int size : entry) {
        curr += size;
        counter.put(curr, counter.getOrDefault(curr, 0) + 1);
      }
      counter.remove(curr);
    }

    if (counter.isEmpty()) {
      return wall.size();
    }

    return wall.size() - Collections.max(counter.values());
  }
}
// leetcode submit region end(Prohibit modification and deletion)
