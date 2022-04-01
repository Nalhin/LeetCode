package com.leetcode.binarysearch.hard;

// Given an array nums which consists of non-negative integers and an integer m,
// you can split the array into m non-empty continuous subarrays.
//
// Write an algorithm to minimize the largest sum among these m subarrays.
//
//
// Example 1:
//
//
// Input: nums = [7,2,5,10,8], m = 2
// Output: 18
// Explanation:
// There are four ways to split nums into two subarrays.
// The best way is to split it into [7,2,5] and [10,8],
// where the largest sum among the two subarrays is only 18.
//
//
// Example 2:
//
//
// Input: nums = [1,2,3,4,5], m = 2
// Output: 9
//
//
// Example 3:
//
//
// Input: nums = [1,4,4], m = 3
// Output: 4
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 1000
// 0 <= nums[i] <= 10⁶
// 1 <= m <= min(50, nums.length)
//
// Related Topics Array Binary Search Dynamic Programming Greedy 👍 5595 👎 147
/*
 O(nlog(k)) Runtime: 3 ms, faster than 28.64% of Java online submissions for Split Array Largest Sum.
 O(nlog(k))  Memory Usage: 41.9 MB, less than 46.81% of Java online submissions for Split Array Largest Sum.
*/

import java.util.Arrays;

// leetcode submit region begin(Prohibit modification and deletion)
public class SplitArrayLargestSum_410 {
  public int splitArray(int[] nums, int m) {
    int left = 0;
    int right = Arrays.stream(nums).sum();

    int result = -1;

    while (left <= right) {
      int mid = left + (right - left) / 2;

      if (canSplit(nums, mid, m)) {
        result = mid;
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }

    return result;
  }

  private boolean canSplit(int[] nums, int target, int m) {

    int currSum = 0;
    int currSubarrays = 0;

    for (int num : nums) {
      if (num > target) {
        return false;
      }

      if (currSum + num > target) {
        currSum = 0;
        currSubarrays++;
      }
      currSum += num;
    }

    if (currSum != 0) {
      currSubarrays++;
    }

    return currSubarrays <= m;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
