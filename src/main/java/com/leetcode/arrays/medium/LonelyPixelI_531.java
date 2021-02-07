package com.leetcode.arrays.medium;

// Given an m x n picture consisting of black 'B' and white 'W' pixels, return th
// e number of black lonely pixels.
//
// A black lonely pixel is a character 'B' that located at a specific position w
// here the same row and same column don't have any other black pixels.
//
//
// Example 1:
//
//
// Input: picture = [["W","W","B"],["W","B","W"],["B","W","W"]]
// Output: 3
// Explanation: All the three 'B's are black lonely pixels.
//
//
// Example 2:
//
//
// Input: picture = [["B","B","B"],["B","B","B"],["B","B","B"]]
// Output: 0
//
//
//
// Constraints:
//
//
// m == picture.length
// n == picture[i].length
// 1 <= m, n <= 500
// picture[i][j] is 'W' or 'B'.
//
// Related Topics Array Depth-first Search
// 👍 219 👎 32

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(nm) Runtime: 1 ms, faster than 100.00% of Java online submissions for Lonely Pixel I.
 O(n + m) Memory Usage: 43.7 MB, less than 50.70% of Java online submissions for Lonely Pixel I.
*/
public class LonelyPixelI_531 {
  private final char TARGET = 'B';

  public int findLonelyPixel(char[][] picture) {
    int n = picture.length;
    int m = picture[0].length;
    int[] rows = new int[n];
    int[] cols = new int[m];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (picture[i][j] == TARGET) {
          rows[i]++;
          cols[j]++;
        }
      }
    }

    int result = 0;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (picture[i][j] == TARGET && rows[i] == 1 && cols[j] == 1) {
          result++;
        }
      }
    }
    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
