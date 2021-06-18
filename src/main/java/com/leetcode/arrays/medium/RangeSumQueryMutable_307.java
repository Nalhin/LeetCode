package com.leetcode.arrays.medium;

// Given an integer array nums, handle multiple queries of the following types:
//
//
// Update the value of an element in nums.
// Calculate the sum of the elements of nums between indices left and right incl
// usive where left <= right.
//
//
// Implement the NumArray class:
//
//
// NumArray(int[] nums) Initializes the object with the integer array nums.
// void update(int index, int val) Updates the value of nums[index] to be val.
// int sumRange(int left, int right) Returns the sum of the elements of nums bet
// ween indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... +
// nums[right]).
//
//
//
// Example 1:
//
//
// Input
// ["NumArray", "sumRange", "update", "sumRange"]
// [[[1, 3, 5]], [0, 2], [1, 2], [0, 2]]
// Output
// [null, 9, null, 8]
//
// Explanation
// NumArray numArray = new NumArray([1, 3, 5]);
// numArray.sumRange(0, 2); // return 1 + 3 + 5 = 9
// numArray.update(1, 2);   // nums = [1, 2, 5]
// numArray.sumRange(0, 2); // return 1 + 2 + 5 = 8
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 3 * 104
// -100 <= nums[i] <= 100
// 0 <= index < nums.length
// -100 <= val <= 100
// 0 <= left <= right < nums.length
// At most 3 * 104 calls will be made to update and sumRange.
//
// Related Topics Binary Indexed Tree Segment Tree
// 👍 2023 👎 113
/*
 preprocess: O(n)
 update, read: O(sqrt(n))
      Runtime: 87 ms, faster than 66.34% of Java online submissions for Range Sum Query - Mutable.
 O(n) Memory Usage: 69.9 MB, less than 75.64% of Java online submissions for Range Sum Query - Mutable.
*/
// leetcode submit region begin(Prohibit modification and deletion)
public class RangeSumQueryMutable_307 {
  static class NumArray {
    private final int[] nums;
    private final int[] decomposedNums;

    private final int bucketSize;

    public NumArray(int[] nums) {
      this.nums = nums;
      this.bucketSize = (int) Math.ceil(nums.length / Math.sqrt(nums.length));
      decomposedNums = decompose(nums, bucketSize);
    }

    private int[] decompose(int[] nums, int bucketSize) {
      int[] result = new int[bucketSize];

      for (int i = 0; i < nums.length; i++) {
        int bucket = i / bucketSize;
        result[bucket] += nums[i];
      }

      return result;
    }

    public void update(int index, int val) {
      int bucket = index / bucketSize;
      int original = nums[index];
      decomposedNums[bucket] = decomposedNums[bucket] - original + val;
      nums[index] = val;
    }

    public int sumRange(int left, int right) {

      int bucketLeft = left / bucketSize;
      int bucketRight = right / bucketSize;

      int result = 0;

      if (bucketLeft == bucketRight) {
        for (int i = left; i <= right; i++) {
          result += nums[i];
        }
        return result;
      }

      for (int i = bucketLeft + 1; i <= bucketRight - 1; i++) {
        result += decomposedNums[i];
      }

      for (int i = left; i < +(bucketLeft + 1) * bucketSize; i++) {
        result += nums[i];
      }

      for (int i = bucketRight * bucketSize; i <= right; i++) {
        result += nums[i];
      }

      return result;
    }
  }
}
/*
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
// leetcode submit region end(Prohibit modification and deletion)
