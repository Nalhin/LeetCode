package com.leetcode.arrays.medium;

// In a row of dominoes, A[i] and B[i] represent the top and bottom halves of the
// ith domino. (A domino is a tile with two numbers from 1 to 6 - one on each half
// of the tile.)
//
// We may rotate the ith domino, so that A[i] and B[i] swap values.
//
// Return the minimum number of rotations so that all the values in A are the sa
// me, or all the values in B are the same.
//
// If it cannot be done, return -1.
//
//
// Example 1:
//
//
// Input: A = [2,1,2,4,2,2], B = [5,2,6,2,3,2]
// Output: 2
// Explanation:
// The first figure represents the dominoes as given by A and B: before we do any
// rotations.
// If we rotate the second and fourth dominoes, we can make every value in the to
// p row equal to 2, as indicated by the second figure.
//
//
// Example 2:
//
//
// Input: A = [3,5,1,2,3], B = [3,6,3,3,4]
// Output: -1
// Explanation:
// In this case, it is not possible to rotate the dominoes to make one row of val
// ues equal.
//
//
//
// Constraints:
//
//
// 2 <= A.length == B.length <= 2 * 104
// 1 <= A[i], B[i] <= 6
//
// Related Topics Array Greedy
// 👍 1022 👎 181

// leetcode submit region begin(Prohibit modification and deletion)

public class MinDominoRotations_1007 {
  public int minDominoRotations(int[] A, int[] B) {
    int firstCount = calculateRotations(A, B, A[0]);

    if (firstCount != -1 || A[0] == B[0]) {
      return firstCount;
    }
    return calculateRotations(B, A, B[0]);
  }

  private int calculateRotations(int[] firstArr, int[] secondArr, int val) {
    int firstCount = 0;
    int secondCount = 0;
    for (int i = 0; i < firstArr.length; ++i) {
      if (firstArr[i] != val && secondArr[i] != val) {
        return -1;
      } else if (secondArr[i] != val) {
        firstCount++;
      } else if (firstArr[i] != val) {
        secondCount++;
      }
    }
    return Math.min(firstCount, secondCount);
  }
}
/*
 O(n) Runtime: 3 ms, faster than 98.37% of Java online submissions for Minimum Domino Rotations For Equal Row.
 O(1) Memory Usage: 47.3 MB, less than 18.75% of Java online submissions for Minimum Domino Rotations For Equal Row.
*/
// leetcode submit region end(Prohibit modification and deletion)
