package com.leetcode.arrays.easy;

//
// An image is represented by a 2-D array of integers, each integer representing
// the pixel value of the image (from 0 to 65535).
//
// Given a coordinate (sr, sc) representing the starting pixel (row and column) o
// f the flood fill, and a pixel value newColor, "flood fill" the image.
//
// To perform a "flood fill", consider the starting pixel, plus any pixels connec
// ted 4-directionally to the starting pixel of the same color as the starting pixe
// l, plus any pixels connected 4-directionally to those pixels (also with the same
// color as the starting pixel), and so on. Replace the color of all of the aforem
// entioned pixels with the newColor.
//
// At the end, return the modified image.
//
// Example 1:
//
// Input:
// image = [[1,1,1],[1,1,0],[1,0,1]]
// sr = 1, sc = 1, newColor = 2
// Output: [[2,2,2],[2,2,0],[2,0,1]]
// Explanation:
// From the center of the image (with position (sr, sc) = (1, 1)), all pixels con
// nected
// by a path of the same color as the starting pixel are colored with the new col
// or.
// Note the bottom corner is not colored 2, because it is not 4-directionally con
// nected
// to the starting pixel.
//
//
//
// Note:
// The length of image and image[0] will be in the range [1, 50].
// The given starting pixel will satisfy 0 <= sr < image.length and 0 <= sc < im
// age[0].length.
// The value of each color in image[i][j] and newColor will be an integer in [0,
// 65535].
// Related Topics Depth-first Search
// 👍 1467 👎 206

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayDeque;
import java.util.Deque;

public class FloodFill_733 {
  private final int[][] directions = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

  public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    int target = image[sr][sc];
    if (target == newColor) {
      return image;
    }

    Deque<int[]> stack = new ArrayDeque<>();
    stack.push(new int[] {sr, sc});

    while (!stack.isEmpty()) {
      int[] point = stack.pop();

      int pointColor = image[point[0]][point[1]];
      if (pointColor == target) {
        for (int[] direction : directions) {
          int x = direction[0] + point[0];
          int y = direction[1] + point[1];
          if ((x >= 0 && x < image.length) && (y >= 0 && y < image[0].length)) {
            stack.push(new int[] {x, y});
          }
        }
        image[point[0]][point[1]] = newColor;
      }
    }
    return image;
  }
}
/*
 O(n) Runtime: 1 ms, faster than 55.51% of Java online submissions for Flood Fill.
 O(n) Memory Usage: 39.8 MB, less than 6.79% of Java online submissions for Flood Fill.
*/

// leetcode submit region end(Prohibit modification and deletion)
