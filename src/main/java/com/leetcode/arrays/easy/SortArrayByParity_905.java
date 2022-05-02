package com.leetcode.arrays.easy;
// Given an array A of non-negative integers, return an array consisting of all t
// he even elements of A, followed by all the odd elements of A.
//
// You may return any answer array that satisfies this condition.
//
//
//
//
// Example 1:
//
//
// Input: [3,1,2,4]
// Output: [2,4,3,1]
// The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
//
//
//
//
// Note:
//
//
// 1 <= A.length <= 5000
// 0 <= A[i] <= 5000
//
//
// Related Topics Array
// 👍 1275 👎 77

// leetcode submit region begin(Prohibit modification and deletion)
public class SortArrayByParity_905 {
  /*
    O(n) Runtime: 1 ms, faster than 96.63% of Java online submissions for Sort Array By Parity.
    O(1) Memory Usage: 48.8 MB, less than 11.17% of Java online submissions for Sort Array By Parity.
  */
  static class InPlace {
    public int[] sortArrayByParity(int[] nums) {
      int left = 0;
      int right = nums.length - 1;

      while (left <= right) {
        while (left <= nums.length - 1 && nums[left] % 2 == 0) {
          left++;
        }

        while (right >= 0 && nums[right] % 2 == 1) {
          right--;
        }

        if (left <= right) {
          int temp = nums[left];
          nums[left] = nums[right];
          nums[right] = temp;
        }
      }

      return nums;
    }
  }
  /*
    O(n) Runtime: 2 ms, faster than 38.16% of Java online submissions for Sort Array By Parity.
    O(n) Memory Usage: 47.7 MB, less than 71.20% of Java online submissions for Sort Array By Parity.
  */
  static class NewOutput {
    public int[] sortArrayByParity(int[] nums) {
      int[] result = new int[nums.length];
      int right = nums.length - 1;
      int left = 0;
      for (int j : nums) {
        if (j % 2 == 0) {
          result[left++] = j;
        } else {
          result[right--] = j;
        }
      }
      return result;
    }
  }
}

/*
   Runtime: 1 ms, faster than 99.59% of Java online submissions for Sort Array By Parity.
   Memory Usage: 40.7 MB, less than 45.26% of Java online submissions for Sort Array By Parity.
*/

// leetcode submit region end(Prohibit modification and deletion)
