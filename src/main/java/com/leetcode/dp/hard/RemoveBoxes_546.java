package com.leetcode.dp.hard;

// You are given several boxes with different colors represented by different pos
// itive numbers.
//
// You may experience several rounds to remove boxes until there is no box left.
// Each time you can choose some continuous boxes with the same color (i.e., compo
// sed of k boxes, k >= 1), remove them and get k * k points.
//
// Return the maximum points you can get.
//
//
// Example 1:
//
//
// Input: boxes = [1,3,2,2,2,3,4,3,1]
// Output: 23
// Explanation:
// [1, 3, 2, 2, 2, 3, 4, 3, 1]
// ----> [1, 3, 3, 4, 3, 1] (3*3=9 points)
// ----> [1, 3, 3, 3, 1] (1*1=1 points)
// ----> [1, 1] (3*3=9 points)
// ----> [] (2*2=4 points)
//
//
// Example 2:
//
//
// Input: boxes = [1,1,1]
// Output: 9
//
//
// Example 3:
//
//
// Input: boxes = [1]
// Output: 1
//
//
//
// Constraints:
//
//
// 1 <= boxes.length <= 100
// 1 <= boxes[i] <= 100
//
// Related Topics Array Dynamic Programming Memoization
// 👍 1145 👎 73
/*
 O(n^4) Runtime: 34 ms, faster than 73.06% of Java online submissions for Remove Boxes.
 O(n^3) Memory Usage: 49.2 MB, less than 36.53% of Java online submissions for Remove Boxes.
*/
// leetcode submit region begin(Prohibit modification and deletion)

public class RemoveBoxes_546 {
  public int removeBoxes(int[] boxes) {
    int[][][] memo = new int[boxes.length][boxes.length][100];
    return maxPoints(boxes, memo, 0, boxes.length - 1, 0);
  }

  private int maxPoints(int[] boxes, int[][][] memo, int leftIdx, int rightIdx, int k) {
    if (leftIdx > rightIdx) {
      return 0;
    }

    while (rightIdx > leftIdx && boxes[rightIdx] == boxes[rightIdx - 1]) {
      rightIdx--;
      k++;
    }

    if (memo[leftIdx][rightIdx][k] != 0) {
      return memo[leftIdx][rightIdx][k];
    }

    memo[leftIdx][rightIdx][k] =
        maxPoints(boxes, memo, leftIdx, rightIdx - 1, 0) + (k + 1) * (k + 1);
    for (int i = leftIdx; i < rightIdx; i++) {
      if (boxes[i] == boxes[rightIdx]) {
        memo[leftIdx][rightIdx][k] =
            Math.max(
                memo[leftIdx][rightIdx][k],
                maxPoints(boxes, memo, leftIdx, i, k + 1)
                    + maxPoints(boxes, memo, i + 1, rightIdx - 1, 0));
      }
    }

    return memo[leftIdx][rightIdx][k];
  }
}
// leetcode submit region end(Prohibit modification and deletion)
