package com.leetcode.twopointers.easy;

// Given an array of integers nums, half of the integers in nums are odd, and
// the other half are even.
//
// Sort the array so that whenever nums[i] is odd, i is odd, and whenever nums[
// i] is even, i is even.
//
// Return any answer array that satisfies this condition.
//
//
// Example 1:
//
//
// Input: nums = [4,2,5,7]
// Output: [4,5,2,7]
// Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.
//
//
// Example 2:
//
//
// Input: nums = [2,3]
// Output: [2,3]
//
//
//
// Constraints:
//
//
// 2 <= nums.length <= 2 * 10⁴
// nums.length is even.
// Half of the integers in nums are even.
// 0 <= nums[i] <= 1000
//
//
//
// Follow Up: Could you solve it in-place?
// Related Topics Array Two Pointers Sorting 👍 1286 👎 59
/*
 O(n) Runtime: 2 ms, faster than 99.65% of Java online submissions for Sort Array By Parity II.
 O(1) Memory Usage: 40 MB, less than 90.22% of Java online submissions for Sort Array By Parity II.
*/
// leetcode submit region begin(Prohibit modification and deletion)

public class SortArrayByParityII_922 {
  public int[] sortArrayByParityII(int[] nums) {
    int evenIdx = 0;
    int oddIdx = 1;

    while (evenIdx < nums.length && oddIdx < nums.length) {

      while (evenIdx < nums.length && nums[evenIdx] % 2 == 0) {
        evenIdx += 2;
      }

      while (oddIdx < nums.length && nums[oddIdx] % 2 == 1) {
        oddIdx += 2;
      }

      if (evenIdx < nums.length && oddIdx < nums.length) {
        int temp = nums[evenIdx];
        nums[evenIdx] = nums[oddIdx];
        nums[oddIdx] = temp;
      }
    }

    return nums;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
