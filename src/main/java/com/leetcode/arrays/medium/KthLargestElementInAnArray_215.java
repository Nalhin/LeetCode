package com.leetcode.arrays.medium;

// Find the kth largest element in an unsorted array. Note that it is the kth lar
// gest element in the sorted order, not the kth distinct element.
//
// Example 1:
//
//
// Input: [3,2,1,5,6,4] and k = 2
// Output: 5
//
//
// Example 2:
//
//
// Input: [3,2,3,1,2,4,5,5,6] and k = 4
// Output: 4
//
// Note:
// You may assume k is always valid, 1 ≤ k ≤ array's length.
// Related Topics Divide and Conquer Heap
// 👍 4575 👎 299

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(n) expected (n^2) worst Runtime: 17 ms, faster than 11.91% of Java online submissions for Kth Largest Element in an Array.
 O(1) Memory Usage: 39.7 MB, less than 23.54% of Java online submissions for Kth Largest Element in an Array.
*/
public class KthLargestElementInAnArray_215 {
  public int findKthLargest(int[] nums, int k) {

    return quickSelect(nums, 0, nums.length - 1, k - 1);
  }

  private int quickSelect(int[] nums, int left, int right, int k) {
    if (left == right) {
      return nums[left];
    }

    int curr = partition(nums, left, right);

    if (curr == k) {
      return nums[curr];
    }

    if (curr < k) {
      return quickSelect(nums, curr + 1, right, k);
    }

    return quickSelect(nums, left, curr - 1, k);
  }

  private int partition(int[] nums, int left, int right) {
    int split = nums[right];

    int larger = left;

    for (int i = left; i < right; i++) {
      if (nums[i] > split) {
        swap(nums, larger, i);
        larger++;
      }
    }
    swap(nums, larger, right);
    return larger;
  }

  private void swap(int[] nums, int first, int second) {
    int temp = nums[first];
    nums[first] = nums[second];
    nums[second] = temp;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
