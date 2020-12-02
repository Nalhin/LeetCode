package com.leetcode.arrays.easy;

// Given the array nums, for each nums[i] find out how many numbers in the array
// are smaller than it. That is, for each nums[i] you have to count the number of v
// alid j's such that j != i and nums[j] < nums[i].
//
// Return the answer in an array.
//
//
// Example 1:
//
//
// Input: nums = [8,1,2,2,3]
// Output: [4,0,1,1,3]
// Explanation:
// For nums[0]=8 there exist four smaller numbers than it (1, 2, 2 and 3).
// For nums[1]=1 does not exist any smaller number than it.
// For nums[2]=2 there exist one smaller number than it (1).
// For nums[3]=2 there exist one smaller number than it (1).
// For nums[4]=3 there exist three smaller numbers than it (1, 2 and 2).
//
//
// Example 2:
//
//
// Input: nums = [6,5,4,8]
// Output: [2,1,0,3]
//
//
// Example 3:
//
//
// Input: nums = [7,7,7,7]
// Output: [0,0,0,0]
//
//
//
// Constraints:
//
//
// 2 <= nums.length <= 500
// 0 <= nums[i] <= 100
//
// Related Topics Array Hash Table
// 👍 1173 👎 30

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(n) Runtime: 1 ms, faster than 96.91% of Java online submissions for How Many Numbers Are Smaller Than the Current Number.
 O(1) Memory Usage: 39.1 MB, less than 53.39% of Java online submissions for How Many Numbers Are Smaller Than the Current Number.
*/
public class HowManyNumbersAreSmallerThanTheCurrentNumber_1365 {
  public int[] smallerNumbersThanCurrent(int[] nums) {
    int[] count = new int[102];
    for (int num : nums) {
      count[num + 1]++;
    }

    for (int i = 1; i < count.length; i++) {
      count[i] += count[i - 1];
    }
    int[] result = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      result[i] = count[nums[i]];
    }
    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
