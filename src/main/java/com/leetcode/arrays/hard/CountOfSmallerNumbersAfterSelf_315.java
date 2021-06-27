package com.leetcode.arrays.hard;

// You are given an integer array nums and you have to return a new counts array.
// The counts array has the property where counts[i] is the number of smaller elem
// ents to the right of nums[i].
//
//
// Example 1:
//
//
// Input: nums = [5,2,6,1]
// Output: [2,1,1,0]
// Explanation:
// To the right of 5 there are 2 smaller elements (2 and 1).
// To the right of 2 there is only 1 smaller element (1).
// To the right of 6 there is 1 smaller element (1).
// To the right of 1 there is 0 smaller element.
//
//
// Example 2:
//
//
// Input: nums = [-1]
// Output: [0]
//
//
// Example 3:
//
//
// Input: nums = [-1,-1]
// Output: [0,0]
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 105
// -104 <= nums[i] <= 104
//
// Related Topics Array Binary Search Divide and Conquer Binary Indexed Tree Seg
// ment Tree Merge Sort Ordered Set
// 👍 4027 👎 120
/*
 O(nlog(n)) Runtime: 51 ms, faster than 88.56% of Java online submissions for Count of Smaller Numbers After Self.
 O(n) Memory Usage: 58.7 MB, less than 35.36% of Java online submissions for Count of Smaller Numbers After Self.
*/
// leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;

public class CountOfSmallerNumbersAfterSelf_315 {
  public List<Integer> countSmaller(int[] nums) {

    int[] count = new int[nums.length];
    int[] indexes = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      indexes[i] = i;
    }

    mergeSort(nums, indexes, count, 0, nums.length - 1);
    List<Integer> result = new ArrayList<>();
    for (int j : count) {
      result.add(j);
    }
    return result;
  }

  private void mergeSort(int[] nums, int[] indexes, int[] count, int start, int end) {
    if (end <= start) {
      return;
    }
    int mid = (start + end) / 2;
    mergeSort(nums, indexes, count, start, mid);
    mergeSort(nums, indexes, count, mid + 1, end);

    merge(nums, indexes, count, start, end);
  }

  private void merge(int[] nums, int[] indexes, int[] count, int start, int end) {
    int mid = (start + end) / 2;
    int leftIdx = start;
    int rightIdx = mid + 1;
    int rightCount = 0;

    int[] newIndexes = new int[end - start + 1];

    int sortIndex = 0;
    while (leftIdx <= mid && rightIdx <= end) {
      if (nums[indexes[rightIdx]] < nums[indexes[leftIdx]]) {
        newIndexes[sortIndex] = indexes[rightIdx];
        rightCount++;
        rightIdx++;
      } else {
        newIndexes[sortIndex] = indexes[leftIdx];
        count[indexes[leftIdx]] += rightCount;
        leftIdx++;
      }
      sortIndex++;
    }
    while (leftIdx <= mid) {
      newIndexes[sortIndex] = indexes[leftIdx];
      count[indexes[leftIdx]] += rightCount;
      leftIdx++;
      sortIndex++;
    }

    while (rightIdx <= end) {
      newIndexes[sortIndex++] = indexes[rightIdx++];
    }

    for (int i = start; i <= end; i++) {
      indexes[i] = newIndexes[i - start];
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
