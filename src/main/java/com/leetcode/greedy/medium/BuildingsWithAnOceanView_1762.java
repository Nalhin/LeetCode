package com.leetcode.greedy.medium;

// There are n buildings in a line. You are given an integer array heights of siz
// e n that represents the heights of the buildings in the line.
//
// The ocean is to the right of the buildings. A building has an ocean view if t
// he building can see the ocean without obstructions. Formally, a building has an
// ocean view if all the buildings to its right have a smaller height.
//
// Return a list of indices (0-indexed) of buildings that have an ocean view, so
// rted in increasing order.
//
//
// Example 1:
//
//
// Input: heights = [4,2,3,1]
// Output: [0,2,3]
// Explanation: Building 1 (0-indexed) does not have an ocean view because buildi
// ng 2 is taller.
//
//
// Example 2:
//
//
// Input: heights = [4,3,2,1]
// Output: [0,1,2,3]
// Explanation: All the buildings have an ocean view.
//
// Example 3:
//
//
// Input: heights = [1,3,2,4]
// Output: [3]
// Explanation: Only building 3 has an ocean view.
//
// Example 4:
//
//
// Input: heights = [2,2,2,2]
// Output: [3]
// Explanation: Buildings cannot see the ocean if there are buildings of the same
// height to its right.
//
//
// Constraints:
//
//
// 1 <= heights.length <= 105
// 1 <= heights[i] <= 109
// Related Topics Greedy
// 👍 47 👎 8
/*
 O(n) Runtime: 8 ms, faster than 100.00% of Java online submissions for Buildings With an Ocean View.
 O(n) Memory Usage: 55 MB, less than 100.00% of Java online submissions for Buildings With an Ocean View.
*/
// leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BuildingsWithAnOceanView_1762 {
  public int[] findBuildings(int[] heights) {
    List<Integer> result = new ArrayList<>();

    int topHeight = 0;

    for (int i = heights.length - 1; i >= 0; i--) {
      int currHeight = heights[i];

      if (currHeight > topHeight) {
        result.add(i);
        topHeight = currHeight;
      }
    }

    Collections.reverse(result);

    return result.stream().mapToInt(i -> i).toArray();
  }
}
// leetcode submit region end(Prohibit modification and deletion)
