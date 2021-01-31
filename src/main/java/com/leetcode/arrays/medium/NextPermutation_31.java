package com.leetcode.arrays.medium;

// Implement next permutation, which rearranges numbers into the lexicographicall
// y next greater permutation of numbers.
//
// If such an arrangement is not possible, it must rearrange it as the lowest po
// ssible order (i.e., sorted in ascending order).
//
// The replacement must be in place and use only constant extra memory.
//
//
// Example 1:
// Input: nums = [1,2,3]
// Output: [1,3,2]
// Example 2:
// Input: nums = [3,2,1]
// Output: [1,2,3]
// Example 3:
// Input: nums = [1,1,5]
// Output: [1,5,1]
// Example 4:
// Input: nums = [1]
// Output: [1]
//
//
// Constraints:
//
//
// 1 <= nums.length <= 100
// 0 <= nums[i] <= 100
//
// Related Topics Array
// 👍 4790 👎 1669

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Next Permutation.
 O(1) Memory Usage: 39.4 MB, less than 38.65% of Java online submissions for Next Permutation.
*/
public class NextPermutation_31 {
  public void nextPermutation(int[] nums) {
    int last = nums.length - 2;

    while (last >= 0 && nums[last + 1] <= nums[last]) {
      last--;
    }

    if (last >= 0) {
      for (int i = nums.length - 1; i > last; i--) {
        if (nums[i] > nums[last]) {
          swap(nums, last, i);
          break;
        }
      }
      reverse(nums, last + 1, nums.length - 1);
    } else {
      reverse(nums, 0, nums.length - 1);
    }
  }

  private void reverse(int[] arr, int left, int right) {
    while (left <= right) {
      swap(arr, left, right);
      left++;
      right--;
    }
  }

  private void swap(int[] arr, int first, int second) {
    int temp = arr[first];
    arr[first] = arr[second];
    arr[second] = temp;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
