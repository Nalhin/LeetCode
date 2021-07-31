package com.leetcode.binarysearch.medium;

// Given an n x n matrix where each of the rows and columns are sorted in ascendi
// ng order, return the kth smallest element in the matrix.
//
// Note that it is the kth smallest element in the sorted order, not the kth dis
// tinct element.
//
//
// Example 1:
//
//
// Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
// Output: 13
// Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and the
// 8th smallest number is 13
//
//
// Example 2:
//
//
// Input: matrix = [[-5]], k = 1
// Output: -5
//
//
//
// Constraints:
//
//
// n == matrix.length
// n == matrix[i].length
// 1 <= n <= 300
// -109 <= matrix[i][j] <= 109
// All the rows and columns of matrix are guaranteed to be sorted in non-decreas
// ing order.
// 1 <= k <= n2
//
// Related Topics Array Binary Search Sorting Heap (Priority Queue) Matrix
// 👍 4397 👎 205
/*
 O(nlog(n) + log(n) * k) Runtime: 21 ms, faster than 26.20% of Java online submissions for Kth Smallest Element in a Sorted Matrix.
 O(n) Memory Usage: 44.6 MB, less than 37.86% of Java online submissions for Kth Smallest Element in a Sorted Matrix.
*/
// leetcode submit region begin(Prohibit modification and deletion)

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthSmallestElementInASortedMatrix_378 {
  public int kthSmallest(int[][] matrix, int k) {

    Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt((a) -> matrix[a[0]][a[1]]));

    for (int i = 0; i < matrix[0].length; i++) {
      pq.add(new int[] {0, i});
    }

    while (--k > 0) {
      int[] smallestElement = pq.poll();
      if (smallestElement[0] < matrix.length - 1) {
        pq.add(new int[] {smallestElement[0] + 1, smallestElement[1]});
      }
    }

    int[] resultingCell = pq.poll();
    return matrix[resultingCell[0]][resultingCell[1]];
  }
}
// leetcode submit region end(Prohibit modification and deletion)
