package com.leetcode.greedy.medium;

// Given an integer array nums, return the number of triplets chosen from the arr
// ay that can make triangles if we take them as side lengths of a triangle.
//
//
// Example 1:
//
//
// Input: nums = [2,2,3,4]
// Output: 3
// Explanation: Valid combinations are:
// 2,3,4 (using the first 2)
// 2,3,4 (using the second 2)
// 2,2,3
//
//
// Example 2:
//
//
// Input: nums = [4,2,3,4]
// Output: 4
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 1000
// 0 <= nums[i] <= 1000
//
// Related Topics Array Two Pointers Binary Search Greedy Sorting
// 👍 1778 👎 126
/*
 O(n^2) Runtime: 37 ms, faster than 56.30% of Java online submissions for Valid Triangle Number.
 O(1) Memory Usage: 38.7 MB, less than 45.34% of Java online submissions for Valid Triangle Number.
*/
import java.util.Arrays;

// leetcode submit region begin(Prohibit modification and deletion)
public class ValidTriangleNumber_611 {
  public int triangleNumber(int[] nums) {
    int result = 0;
    Arrays.sort(nums);

    for (int i = 0; i < nums.length - 2; i++) {
      if (nums[i] == 0) {
        continue;
      }

      int k = i + 2;

      for (int j = i + 1; j < nums.length - 1; j++) {
        int leftSideSum = nums[i] + nums[j];
        while (k < nums.length && leftSideSum > nums[k]) {
          k++;
        }
        result += k - j - 1;
      }
    }
    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
