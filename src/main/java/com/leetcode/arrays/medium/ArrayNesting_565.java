package com.leetcode.arrays.medium;

// You are given an integer array nums of length n where nums is a permutation
// of the numbers in the range [0, n - 1].
//
// You should build a set s[k] = {nums[k], nums[nums[k]], nums[nums[nums[k]]], .
// .. } subjected to the following rule:
//
//
// The first element in s[k] starts with the selection of the element nums[k]
// of index = k.
// The next element in s[k] should be nums[nums[k]], and then nums[nums[nums[k]]
// ], and so on.
// We stop adding right before a duplicate element occurs in s[k].
//
//
// Return the longest length of a set s[k].
//
//
// Example 1:
//
//
// Input: nums = [5,4,0,3,1,6,2]
// Output: 4
// Explanation:
// nums[0] = 5, nums[1] = 4, nums[2] = 0, nums[3] = 3, nums[4] = 1, nums[5] = 6,
// nums[6] = 2.
// One of the longest sets s[k]:
// s[0] = {nums[0], nums[5], nums[6], nums[2]} = {5, 6, 2, 0}
//
//
// Example 2:
//
//
// Input: nums = [0,1,2]
// Output: 1
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 10⁵
// 0 <= nums[i] < nums.length
// All the values of nums are unique.
//
// Related Topics Array Depth-First Search 👍 1402 👎 126
/*
 O(n) Runtime: 2 ms, faster than 62.59% of Java online submissions for Array Nesting.
 O(n) Memory Usage: 45.9 MB, less than 10.43% of Java online submissions for Array Nesting.
*/
// leetcode submit region begin(Prohibit modification and deletion)
public class ArrayNesting_565 {
  public int arrayNesting(int[] nums) {
    boolean[] visited = new boolean[nums.length];
    int result = 0;

    for (int num : nums) {
      int curr = 0;

      while (!visited[num]) {
        visited[num] = true;
        num = nums[num];
        curr++;
      }
      result = Math.max(result, curr);
    }

    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
