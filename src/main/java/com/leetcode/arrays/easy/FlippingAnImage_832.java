package com.leetcode.arrays.easy;

// Given a binary matrix A, we want to flip the image horizontally, then invert i
// t, and return the resulting image.
//
// To flip an image horizontally means that each row of the image is reversed. F
// or example, flipping [1, 1, 0] horizontally results in [0, 1, 1].
//
// To invert an image means that each 0 is replaced by 1, and each 1 is replaced
// by 0. For example, inverting [0, 1, 1] results in [1, 0, 0].
//
// Example 1:
//
//
// Input: [[1,1,0],[1,0,1],[0,0,0]]
// Output: [[1,0,0],[0,1,0],[1,1,1]]
// Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
// Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
//
//
// Example 2:
//
//
// Input: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
// Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
// Explanation: First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]
// .
// Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
//
//
// Notes:
//
//
// 1 <= A.length = A[0].length <= 20
// 0 <= A[i][j] <= 1
//
// Related Topics Array
// 👍 1039 👎 162

// leetcode submit region begin(Prohibit modification and deletion)
/*
  O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Flipping an Image.
  O(1) Memory Usage: 39.3 MB, less than 8.12% of Java online submissions for Flipping an Image.
 */
public class FlippingAnImage_832 {
  public int[][] flipAndInvertImage(int[][] A) {
    if(A.length  == 0 || A[0].length == 0){
      return A;
    }

    int w = A.length - 1;
    int h = A[0].length - 1;

    for(int i = 0; i <= w; i++){
      int left = 0;
      int right = h;
      while(left < right){
        int temp = A[i][left];
        A[i][left] = A[i][right];
        A[i][right] = temp;
        left++;
        right--;
      }
    }

    for(int i = 0; i <= w; i++){
      for(int j = 0; j <= h; j++){
        A[i][j] ^= 1;
      }
    }

    return A;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
