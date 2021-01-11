package com.leetcode.arrays.hard;

// Given an integer array instructions, you are asked to create a sorted array fr
// om the elements in instructions. You start with an empty container nums. For eac
// h element from left to right in instructions, insert it into nums. The cost of e
// ach insertion is the minimum of the following:
//
//
// The number of elements currently in nums that are strictly less than instruct
// ions[i].
// The number of elements currently in nums that are strictly greater than instr
// uctions[i].
//
//
// For example, if inserting element 3 into nums = [1,2,3,5], the cost of insert
// ion is min(2, 1) (elements 1 and 2 are less than 3, element 5 is greater than 3)
// and nums will become [1,2,3,3,5].
//
// Return the total cost to insert all elements from instructions into nums. Sin
// ce the answer may be large, return it modulo 109 + 7
//
//
// Example 1:
//
//
// Input: instructions = [1,5,6,2]
// Output: 1
// Explanation: Begin with nums = [].
// Insert 1 with cost min(0, 0) = 0, now nums = [1].
// Insert 5 with cost min(1, 0) = 0, now nums = [1,5].
// Insert 6 with cost min(2, 0) = 0, now nums = [1,5,6].
// Insert 2 with cost min(1, 2) = 1, now nums = [1,2,5,6].
// The total cost is 0 + 0 + 0 + 1 = 1.
//
// Example 2:
//
//
// Input: instructions = [1,2,3,6,5,4]
// Output: 3
// Explanation: Begin with nums = [].
// Insert 1 with cost min(0, 0) = 0, now nums = [1].
// Insert 2 with cost min(1, 0) = 0, now nums = [1,2].
// Insert 3 with cost min(2, 0) = 0, now nums = [1,2,3].
// Insert 6 with cost min(3, 0) = 0, now nums = [1,2,3,6].
// Insert 5 with cost min(3, 1) = 1, now nums = [1,2,3,5,6].
// Insert 4 with cost min(3, 2) = 2, now nums = [1,2,3,4,5,6].
// The total cost is 0 + 0 + 0 + 0 + 1 + 2 = 3.
//
//
// Example 3:
//
//
// Input: instructions = [1,3,3,3,2,4,2,1,2]
// Output: 4
// Explanation: Begin with nums = [].
// Insert 1 with cost min(0, 0) = 0, now nums = [1].
// Insert 3 with cost min(1, 0) = 0, now nums = [1,3].
// Insert 3 with cost min(1, 0) = 0, now nums = [1,3,3].
// Insert 3 with cost min(1, 0) = 0, now nums = [1,3,3,3].
// Insert 2 with cost min(1, 3) = 1, now nums = [1,2,3,3,3].
// Insert 4 with cost min(5, 0) = 0, now nums = [1,2,3,3,3,4].
// ​​​​​​​Insert 2 with cost min(1, 4) = 1, now nums = [1,2,2,3,3,3,4].
// ​​​​​​​Insert 1 with cost min(0, 6) = 0, now nums = [1,1,2,2,3,3,3,4].
// ​​​​​​​Insert 2 with cost min(2, 4) = 2, now nums = [1,1,2,2,2,3,3,3,4].
// The total cost is 0 + 0 + 0 + 0 + 1 + 0 + 1 + 0 + 2 = 4.
//
//
//
// Constraints:
//
//
// 1 <= instructions.length <= 105
// 1 <= instructions[i] <= 105
// Related Topics Binary Search Binary Indexed Tree Segment Tree Ordered Map
// 👍 229 👎 36
/*
 O(nlog(n)) Runtime: 895 ms, faster than 15.77% of Java online submissions for Create Sorted Array through Instructions.
 O(n) Memory Usage: 126.6 MB, less than 5.07% of Java online submissions for Create Sorted Array through Instructions.
*/
// leetcode submit region begin(Prohibit modification and deletion)
public class CreateSortedArrayThroughInstructions_1649 {
  int[] smaller;
  int[] larger;
  int[][] temp;

  public int createSortedArray(int[] instructions) {
    int n = instructions.length;
    smaller = new int[n];
    larger = new int[n];
    temp = new int[n][];
    long MOD = 1_000_000_007;

    int[][] arrSmaller = new int[n][];
    int[][] arrLarger = new int[n][];
    for (int i = 0; i < n; i++) {
      arrSmaller[i] = new int[] {instructions[i], i};
      arrLarger[i] = new int[] {instructions[i], i};
    }

    sortSmaller(arrSmaller, 0, n - 1);
    sortLarger(arrLarger, 0, n - 1);

    long result = 0;
    for (int i = 0; i < n; i++) {
      result += Math.min(smaller[i], larger[i]);
    }
    return (int) (result % MOD);
  }

  private void sortSmaller(int[][] arr, int left, int right) {
    if (left == right) {
      return;
    }
    int mid = (left + right) / 2;
    sortSmaller(arr, left, mid);
    sortSmaller(arr, mid + 1, right);
    mergeSmaller(arr, left, right, mid);
  }

  private void mergeSmaller(int[][] arr, int left, int right, int mid) {
    int i = left;
    int j = mid + 1;
    int k = left;
    while (i <= mid && j <= right) {
      if (arr[i][0] < arr[j][0]) {
        temp[k++] = arr[i];
        i++;
      } else {
        temp[k++] = arr[j];
        smaller[arr[j][1]] += i - left;
        j++;
      }
    }
    while (i <= mid) {
      temp[k++] = arr[i];
      i++;
    }
    while (j <= right) {
      temp[k++] = arr[j];
      smaller[arr[j][1]] += i - left;
      j++;
    }
    for (i = left; i <= right; i++) {
      arr[i] = temp[i];
    }
  }

  private void sortLarger(int[][] arr, int left, int right) {
    if (left == right) {
      return;
    }
    int mid = (left + right) / 2;
    sortLarger(arr, left, mid);
    sortLarger(arr, mid + 1, right);
    mergeLarger(arr, left, right, mid);
  }

  private void mergeLarger(int[][] arr, int left, int right, int mid) {
    int i = left;
    int j = mid + 1;
    int k = left;
    while (i <= mid && j <= right) {
      if (arr[i][0] <= arr[j][0]) {
        temp[k++] = arr[i];
        i++;
      } else {
        temp[k++] = arr[j];
        larger[arr[j][1]] += mid - i + 1;
        j++;
      }
    }
    while (i <= mid) {
      temp[k++] = arr[i];
      i++;
    }
    while (j <= right) {
      temp[k++] = arr[j];
      larger[arr[j][1]] += mid - i + 1;
      j++;
    }
    for (i = left; i <= right; i++) {
      arr[i] = temp[i];
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
