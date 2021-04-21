package com.leetcode.dp.medium;

// Given a triangle array, return the minimum path sum from top to bottom.
//
// For each step, you may move to an adjacent number of the row below. More form
// ally, if you are on index i on the current row, you may move to either index i o
// r index i + 1 on the next row.
//
//
// Example 1:
//
//
// Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
// Output: 11
// Explanation: The triangle looks like:
//   2
//  3 4
// 6 5 7
// 4 1 8 3
// The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined abov
// e).
//
//
// Example 2:
//
//
// Input: triangle = [[-10]]
// Output: -10
//
//
//
// Constraints:
//
//
// 1 <= triangle.length <= 200
// triangle[0].length == 1
// triangle[i].length == triangle[i - 1].length + 1
// -104 <= triangle[i][j] <= 104
//
//
//
// Follow up: Could you do this using only O(n) extra space, where n is the total
// number of rows in the triangle? Related Topics Array Dynamic Programming
// 👍 2971 👎 316

import java.util.ArrayList;
import java.util.List;
/*
 O(n*n) Runtime: 4 ms, faster than 31.23% of Java online submissions for Triangle.
 O(n) Memory Usage: 41.1 MB, less than 5.90% of Java online submissions for Triangle.
*/
// leetcode submit region begin(Prohibit modification and deletion)
public class Triangle_120 {
  public int minimumTotal(List<List<Integer>> triangle) {
    List<Integer> prev = triangle.get(triangle.size() - 1);
    for (int i = triangle.size() - 2; i >= 0; i--) {
      List<Integer> curr = new ArrayList<>();
      for (int j = 0; j < prev.size() - 1; j++) {
        curr.add(Math.min(prev.get(j), prev.get(j + 1)) + triangle.get(i).get(j));
      }
      prev = curr;
    }
    return prev.get(0);
  }
}
// leetcode submit region end(Prohibit modification and deletion)
