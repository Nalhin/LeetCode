package com.leetcode.arrays.medium;

// Given a sorted array nums, remove the duplicates in-place such that duplicates
// appeared at most twice and return the new length.
//
// Do not allocate extra space for another array; you must do this by modifying
// the input array in-place with O(1) extra memory.
//
// Clarification:
//
// Confused why the returned value is an integer, but your answer is an array?
//
// Note that the input array is passed in by reference, which means a modificati
// on to the input array will be known to the caller.
//
// Internally you can think of this:
//
//
//// nums is passed in by reference. (i.e., without making a copy)
// int len = removeDuplicates(nums);
//
//// any modification to nums in your function would be known by the caller.
//// using the length returned by your function, it prints the first len element
// s.
// for (int i = 0; i < len; i++) {
//     print(nums[i]);
// }
//
//
//
// Example 1:
//
//
// Input: nums = [1,1,1,2,2,3]
// Output: 5, nums = [1,1,2,2,3]
// Explanation: Your function should return length = 5, with the first five eleme
// nts of nums being 1, 1, 2, 2 and 3 respectively. It doesn't matter what you leav
// e beyond the returned length.
//
//
// Example 2:
//
//
// Input: nums = [0,0,1,1,1,1,2,3,3]
// Output: 7, nums = [0,0,1,1,2,3,3]
// Explanation: Your function should return length = 7, with the first seven elem
// ents of nums being modified to 0, 0, 1, 1, 2, 3 and 3 respectively. It doesn't m
// atter what values are set beyond the returned length.
//
//
//
// Constraints:
//
//
// 0 <= nums.length <= 3 * 104
// -104 <= nums[i] <= 104
// nums is sorted in ascending order.
//
// Related Topics Array Two Pointers
// 👍 1555 👎 757

// leetcode submit region begin(Prohibit modification and deletion)
public class RemoveDuplicatesFromSortedArrayII_80 {
  public int removeDuplicates(int[] nums) {
    int left = 0;
    int right = 0;
    while (right < nums.length) {
      int dups = 1;
      while (right < nums.length - 1 && nums[right + 1] == nums[right] && dups < 2) {
        dups++;
        swap(nums, left++, right++);
      }

      while (right < nums.length - 1 && nums[right + 1] == nums[right]) {
        swap(nums, left, right++);
      }

      if(dups == 1){
        swap(nums, left++, right++);
      }
    }
    return left;
  }


  private void swap(int[] nums, int first, int second) {
    int temp = nums[first];
    nums[first] = nums[second];
    nums[second] = temp;
  }

}

// leetcode submit region end(Prohibit modification and deletion)
