package com.leetcode.dp.easy;

// Given an integer numRows, return the first numRows of Pascal's triangle.
//
// In Pascal's triangle, each number is the sum of the two numbers directly abov
// e it as shown:
//
//
// Example 1:
// Input: numRows = 5
// Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
// Example 2:
// Input: numRows = 1
// Output: [[1]]
//
//
// Constraints:
//
//
// 1 <= numRows <= 30
//
// Related Topics Array
// 👍 2720 👎 139
/*
 O(n^2) Runtime: 0 ms, faster than 100.00% of Java online submissions for Pascal's Triangle.
 O(n^2) Memory Usage: 37.4 MB, less than 17.16% of Java online submissions for Pascal's Triangle.
*/
// leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle_118 {
  public List<List<Integer>> generate(int numRows) {

    List<List<Integer>> result = new ArrayList<>();

    result.add(List.of(1));

    for (int i = 1; i < numRows; i++) {
      List<Integer> prevRow = result.get(i - 1);

      List<Integer> row = new ArrayList<>();
      row.add(1);
      for (int j = 1; j < i; j++) {
        row.add(prevRow.get(j - 1) + prevRow.get(j));
      }
      row.add(1);
      result.add(row);
    }

    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
