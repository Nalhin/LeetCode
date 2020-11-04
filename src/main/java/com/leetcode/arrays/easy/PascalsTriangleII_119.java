package com.leetcode.arrays.easy;

import java.util.ArrayList;
import java.util.List;
/*
 O(n*n) Runtime: 1 ms, faster than 77.14% of Java online submissions for Pascal's Triangle II.
 O(n) Memory Usage: 36.8 MB, less than 12.07% of Java online submissions for Pascal's Triangle II.

*/
public class PascalsTriangleII_119 {
  public List<Integer> getRow(int rowIndex) {
    List<Integer> res = new ArrayList<>();
    for (int i = 0; i <= rowIndex; i++) {
      res.add(1);
      for (int j = i - 1; j > 0; j--) {
        res.set(j, res.get(j - 1) + res.get(j));
      }
    }
    return res;
  }
}
