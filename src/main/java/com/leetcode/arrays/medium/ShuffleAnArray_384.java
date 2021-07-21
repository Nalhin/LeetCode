package com.leetcode.arrays.medium;

// Given an integer array nums, design an algorithm to randomly shuffle the array
// . All permutations of the array should be equally likely as a result of the shuf
// fling.
//
// Implement the Solution class:
//
//
// Solution(int[] nums) Initializes the object with the integer array nums.
// int[] reset() Resets the array to its original configuration and returns it.
//
// int[] shuffle() Returns a random shuffling of the array.
//
//
//
// Example 1:
//
//
// Input
// ["Solution", "shuffle", "reset", "shuffle"]
// [[[1, 2, 3]], [], [], []]
// Output
// [null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]
//
// Explanation
// Solution solution = new Solution([1, 2, 3]);
// solution.shuffle();    // Shuffle the array [1,2,3] and return its result.
//                       // Any permutation of [1,2,3] must be equally likely to
// be returned.
//                       // Example: return [3, 1, 2]
// solution.reset();      // Resets the array back to its original configuration
// [1,2,3]. Return [1, 2, 3]
// solution.shuffle();    // Returns the random shuffling of array [1,2,3]. Examp
// le: return [1, 3, 2]
//
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 200
// -106 <= nums[i] <= 106
// All the elements of nums are unique.
// At most 5 * 104 calls in total will be made to reset and shuffle.
//
// Related Topics Array Math Randomized
// 👍 308 👎 350
/*
 O(n) Runtime: 70 ms, faster than 96.76% of Java online submissions for Shuffle an Array.
 O(n) Memory Usage: 47.9 MB, less than 24.26% of Java online submissions for Shuffle an Array.
*/
// leetcode submit region begin(Prohibit modification and deletion)

import java.util.Arrays;
import java.util.Random;

public class ShuffleAnArray_384 {
  static class Solution {
    private final int[] arr;
    private static final Random random = new Random();

    public Solution(int[] nums) {
      this.arr = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
      return arr;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
      int[] results = Arrays.copyOf(arr, arr.length);

      for (int i = 0; i < results.length; i++) {
        swap(results, i, randomBetween(i, arr.length));
      }
      return results;
    }

    private int randomBetween(int min, int max) {
      return random.nextInt(max - min) + min;
    }

    private void swap(int[] arr, int i, int j) {
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
    }
  }
}
/*
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
// leetcode submit region end(Prohibit modification and deletion)
