package com.leetcode.greedy.hard;

// Given a sorted integer array nums and an integer n, add/patch elements to the
// array such that any number in the range [1, n] inclusive can be formed by the
// sum of some elements in the array.
//
// Return the minimum number of patches required.
//
//
// Example 1:
//
//
// Input: nums = [1,3], n = 6
// Output: 1
// Explanation:
// Combinations of nums are [1], [3], [1,3], which form possible sums of: 1, 3, 4
// .
// Now if we add/patch 2 to nums, the combinations are: [1], [2], [3], [1,3], [2,
// 3], [1,2,3].
// Possible sums are 1, 2, 3, 4, 5, 6, which now covers the range [1, 6].
// So we only need 1 patch.
//
//
// Example 2:
//
//
// Input: nums = [1,5,10], n = 20
// Output: 2
// Explanation: The two patches can be [2, 4].
//
//
// Example 3:
//
//
// Input: nums = [1,2,2], n = 5
// Output: 0
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 1000
// 1 <= nums[i] <= 10⁴
// nums is sorted in ascending order.
// 1 <= n <= 2³¹ - 1
//
// Related Topics Array Greedy 👍 842 👎 99
/*
 O(n + log(m)) Runtime: 0 ms, faster than 100.00% of Java online submissions for Patching Array.
 O(1)  Memory Usage: 41.1 MB, less than 5.26% of Java online submissions for Patching Array.
*/
// leetcode submit region begin(Prohibit modification and deletion)

// leetcode submit region end(Prohibit modification and deletion)
public class PatchingArray_330 {
  public int minPatches(int[] nums, int n) {
    int result = 0;

    long nextMissing = 1;
    int currIdx = 0;
    while (nextMissing <= n) {
      if (currIdx < nums.length && nums[currIdx] <= nextMissing) {
        nextMissing += nums[currIdx++];
      } else {
        nextMissing += nextMissing;
        result++;
      }
    }
    return result;
  }
}
