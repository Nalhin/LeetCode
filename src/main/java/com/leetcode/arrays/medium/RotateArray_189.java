package com.leetcode.arrays.medium;

// Given an array, rotate the array to the right by k steps, where k is non-negat
// ive.
//
// Follow up:
//
//
// Try to come up as many solutions as you can, there are at least 3 different w
// ays to solve this problem.
// Could you do it in-place with O(1) extra space?
//
//
//
// Example 1:
//
//
// Input: nums = [1,2,3,4,5,6,7], k = 3
// Output: [5,6,7,1,2,3,4]
// Explanation:
// rotate 1 steps to the right: [7,1,2,3,4,5,6]
// rotate 2 steps to the right: [6,7,1,2,3,4,5]
// rotate 3 steps to the right: [5,6,7,1,2,3,4]
//
//
// Example 2:
//
//
// Input: nums = [-1,-100,3,99], k = 2
// Output: [3,99,-1,-100]
// Explanation:
// rotate 1 steps to the right: [99,-1,-100,3]
// rotate 2 steps to the right: [3,99,-1,-100]
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 2 * 104
// -231 <= nums[i] <= 231 - 1
// 0 <= k <= 105
//
// Related Topics Array
// 👍 3463 👎 864

// leetcode submit region begin(Prohibit modification and deletion)

public class RotateArray_189 {
  public void rotate(int[] nums, int k) {
    int rot = k % nums.length;
    if (rot == 0) {
      return;
    }
    int prevNum = nums[0];
    int startIndex = 0;
    int currIndex = 0;
    int visited = 0;
    while (visited != nums.length) {
      currIndex = nextIndex(currIndex, nums.length, rot);
      int temp = nums[currIndex];
      nums[currIndex] = prevNum;
      prevNum = temp;
      visited++;
      if (currIndex == startIndex) {
        startIndex++;
        currIndex++;
        prevNum = nums[currIndex];
      }
    }
  }

  private int nextIndex(int curr, int size, int rot) {
    return (curr + rot) % size;
  }
}
/*
 O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Rotate Array.
 O(1) Memory Usage: 39.3 MB, less than 12.43% of Java online submissions for Rotate Arra
*/
// leetcode submit region end(Prohibit modification and deletion)
