package com.leetcode.greedy.medium;

//Given an integer array nums, return the largest perimeter of a triangle with
//a non-zero area, formed from three of these lengths. If it is impossible to form
//any triangle of a non-zero area, return 0.
//
//
// Example 1:
//
//
//Input: nums = [2,1,2]
//Output: 5
//
//
// Example 2:
//
//
//Input: nums = [1,2,1]
//Output: 0
//
//
//
// Constraints:
//
//
// 3 <= nums.length <= 10⁴
// 1 <= nums[i] <= 10⁶
//
//
// Related Topics Array Math Greedy Sorting 👍 2262 👎 304
/*
  O(nlog(n)) Runtime: 9 ms, faster than 89.51% of Java online submissions for Largest Perimeter Triangle.
  O(1) Memory Usage: 54.2 MB, less than 52.66% of Java online submissions for Largest Perimeter Triangle.
*/
import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
public class LargestPerimeterTriangle_976 {
    public int largestPerimeter(int[] nums) {
      Arrays.sort(nums);
      for (int i = nums.length - 3; i >= 0; --i) {
        if (nums[i] + nums[i + 1] > nums[i + 2]) {
          return nums[i] + nums[i + 1] + nums[i + 2];
        }
      }
      return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
