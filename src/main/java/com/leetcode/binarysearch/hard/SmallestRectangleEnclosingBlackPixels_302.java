package com.leetcode.binarysearch.hard;

/*
 O(nlog(m) + mlog(n)) Runtime: 1 ms, faster than 80.39% of Java online submissions for Smallest Rectangle Enclosing Black Pixels.
 O(1) Memory Usage: 52 MB, less than 44.65% of Java online submissions for Smallest Rectangle Enclosing Black Pixels.
*/
public class SmallestRectangleEnclosingBlackPixels_302 {

  public int minArea(char[][] image, int row, int col) {
    int rowMin = binarySearch(image, 0, row, true, true);
    int rowMax = binarySearch(image, row + 1, image.length, true, false);
    int colMin = binarySearch(image, 0, col, false, true);
    int colMax = binarySearch(image, col + 1, image[0].length, false, false);
    return (rowMax - rowMin) * (colMax - colMin);
  }

  private int binarySearch(
      char[][] image, int left, int right, boolean rowWise, boolean whiteToBlack) {
    while (left < right) {
      int mid = (left + right) / 2;
      if (rowWise ? isRowFilled(image, mid) : isColFilled(image, mid)) {
        if (whiteToBlack) {
          right = mid;
        } else {
          left = left + 1;
        }
      } else {
        if (whiteToBlack) {
          left = mid + 1;
        } else {
          right = mid;
        }
      }
    }
    return left;
  }

  private boolean isRowFilled(char[][] image, int idx) {
    for (int j = 0; j < image[0].length; ++j) {
      if (image[idx][j] == '1') {
        return true;
      }
    }

    return false;
  }

  private boolean isColFilled(char[][] image, int idx) {
    for (char[] chars : image) {
      if (chars[idx] == '1') {
        return true;
      }
    }
    return false;
  }
}
