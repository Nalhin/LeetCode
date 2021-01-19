package com.leetcode.arrays.medium;

// Given n non-negative integers a1, a2, ..., an , where each represents a point
// at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of
// the line i is at (i, ai) and (i, 0). Find two lines, which, together with the x
// -axis forms a container, such that the container contains the most water.
//
// Notice that you may not slant the container.
//
//
// Example 1:
//
//
// Input: height = [1,8,6,2,5,4,8,3,7]
// Output: 49
// Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,
// 3,7]. In this case, the max area of water (blue section) the container can conta
// in is 49.
//
//
// Example 2:
//
//
// Input: height = [1,1]
// Output: 1
//
//
// Example 3:
//
//
// Input: height = [4,3,2,1,4]
// Output: 16
//
//
// Example 4:
//
//
// Input: height = [1,2,1]
// Output: 2
//
//
//
// Constraints:
//
//
// n == height.length
// 2 <= n <= 3 * 104
// 0 <= height[i] <= 3 * 104
//
// Related Topics Array Two Pointers
// 👍 8104 👎 651

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(n) Runtime: 2 ms, faster than 95.59% of Java online submissions for Container With Most Water.
 O(1) Memory Usage: 40.8 MB, less than 31.19% of Java online submissions for Container With Most Water.
*/
public class ContainerWithMostWater_11 {
  public int maxArea(int[] height) {
    int left = 0;
    int right = height.length - 1;
    int result = 0;

    while (left <= right) {
      result = Math.max(result, Math.min(height[left], height[right]) * (right - left));

      if (height[left] > height[right]) {
        right--;
      } else {
        left++;
      }
    }

    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
