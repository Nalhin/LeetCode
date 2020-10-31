package com.leetcode.hashtable.medium;

// Given a matrix mat where every row is sorted in strictly increasing order, ret
// urn the smallest common element in all rows.
//
// If there is no common element, return -1.
//
//
// Example 1:
// Input: mat = [[1,2,3,4,5],[2,4,5,8,10],[3,5,7,9,11],[1,3,5,7,9]]
// Output: 5
//
//
// Constraints:
//
//
// 1 <= mat.length, mat[i].length <= 500
// 1 <= mat[i][j] <= 10^4
// mat[i] is sorted in strictly increasing order.
//
// Related Topics Hash Table Binary Search
// 👍 138 👎 11

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class FindSmallestCommonElementInAllRows_1198 {
  /*
  O(n * m) Runtime: 8 ms, faster than 36.41% of Java online submissions for Find Smallest Common Element in All Rows.
  O(n)  Memory Usage: 66.3 MB, less than 12.29% of Java online submissions for Find Smallest Common Element in All Rows.
  */
  static class HashMapSolution {
    public int smallestCommonElement(int[][] mat) {
      Map<Integer, Integer> firstRow = new HashMap<>();
      for (int el : mat[0]) {
        firstRow.put(el, 1);
      }

      for (int i = 1; i < mat.length; i++) {
        for (int j = 0; j < mat[i].length; j++) {
          if (firstRow.containsKey(mat[i][j])) {
            firstRow.put(mat[i][j], firstRow.get(mat[i][j]) + 1);
          }
        }
      }
      for (Map.Entry<Integer, Integer> entry : firstRow.entrySet()) {
        if (entry.getValue() == mat.length) {
          return entry.getKey();
        }
      }
      return -1;
    }
  }
  /*
  O(n * m) Runtime: 1 ms, faster than 77.54% of Java online submissions for Find Smallest Common Element in All Rows.
  O(n) Memory Usage: 61 MB, less than 12.29% of Java online submissions for Find Smallest Common Element in All Rows.
  */
  static class LinkedMapBinarySearchSolution {
    public int smallestCommonElement(int[][] mat) {
      Map<Integer, Integer> firstRow = new LinkedHashMap<>();
      for (int el : mat[0]) {
        firstRow.put(el, 1);
      }

      for (int i = 1; i < mat.length; i++) {
        Iterator<Integer> it = firstRow.keySet().iterator();
        int[] row = mat[i];
        int prev = 0;
        while (it.hasNext()) {
          int val = it.next();
          int position = binarySearch(row, prev, row.length - 1, val);
          if (position == -1) {
            it.remove();
          } else {
            prev = position;
          }
        }
      }

      Iterator<Integer> it = firstRow.keySet().iterator();

      if (!it.hasNext()) {
        return -1;
      }

      return it.next();
    }

    private int binarySearch(int[] array, int left, int right, int target) {
      while (left <= right) {
        int mid = (left + right) >> 1;
        int curr = array[mid];

        if (curr == target) {
          return mid;
        } else if (curr < target) {
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      }
      return -1;
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
