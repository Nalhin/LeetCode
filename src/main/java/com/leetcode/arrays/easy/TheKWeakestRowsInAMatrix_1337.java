package com.leetcode.arrays.easy;

// Given a m * n matrix mat of ones (representing soldiers) and zeros (representi
// ng civilians), return the indexes of the k weakest rows in the matrix ordered fr
// om the weakest to the strongest.
//
// A row i is weaker than row j, if the number of soldiers in row i is less than
// the number of soldiers in row j, or they have the same number of soldiers but i
// is less than j. Soldiers are always stand in the frontier of a row, that is, al
// ways ones may appear first and then zeros.
//
//
// Example 1:
//
//
// Input: mat =
// [[1,1,0,0,0],
// [1,1,1,1,0],
// [1,0,0,0,0],
// [1,1,0,0,0],
// [1,1,1,1,1]],
// k = 3
// Output: [2,0,3]
// Explanation:
// The number of soldiers for each row is:
// row 0 -> 2
// row 1 -> 4
// row 2 -> 1
// row 3 -> 2
// row 4 -> 5
// Rows ordered from the weakest to the strongest are [2,0,3,1,4]
//
//
// Example 2:
//
//
// Input: mat =
// [[1,0,0,0],
//  [1,1,1,1],
//  [1,0,0,0],
//  [1,0,0,0]],
// k = 2
// Output: [0,2]
// Explanation:
// The number of soldiers for each row is:
// row 0 -> 1
// row 1 -> 4
// row 2 -> 1
// row 3 -> 1
// Rows ordered from the weakest to the strongest are [0,2,3,1]
//
//
//
// Constraints:
//
//
// m == mat.length
// n == mat[i].length
// 2 <= n, m <= 100
// 1 <= k <= m
// matrix[i][j] is either 0 or 1.
//
// Related Topics Array Binary Search
// 👍 493 👎 35

import java.util.PriorityQueue;
import java.util.Queue;
/*
 O(n * k * log(n))  Runtime: 19 ms, faster than 6.32% of Java online submissions for The K Weakest Rows in a Matrix.
 O(n)  Memory Usage: 45.4 MB, less than 5.39% of Java online submissions for The K Weakest Rows in a Matrix.
*/
// leetcode submit region begin(Prohibit modification and deletion)
public class TheKWeakestRowsInAMatrix_1337 {
  public int[] kWeakestRows(int[][] mat, int k) {

    Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] == b[1] ? b[0] - a[0] : b[1] - a[1]);

    for (int i = 0; i < mat.length; i++) {
      int[] row = mat[i];
      int size = getRowSize(row);
      pq.add(new int[] {i, size});
      if (pq.size() > k) {
        pq.remove();
      }
    }

    int[] result = new int[k];
    for (int i = result.length - 1; i >= 0; i--) {
      result[i] = pq.remove()[0];
    }

    return result;
  }

  private int getRowSize(int[] row) {
    int left = 0;
    int right = row.length;
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (row[mid] == 1) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return right;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
