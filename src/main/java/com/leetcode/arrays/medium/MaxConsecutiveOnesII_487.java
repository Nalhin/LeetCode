package com.leetcode.arrays.medium;

//
// Given a binary array, find the maximum number of consecutive 1s in this array
// if you can flip at most one 0.
//
//
// Example 1:
//
// Input: [1,0,1,1,0]
// Output: 4
// Explanation: Flip the first zero will get the the maximum number of consecutiv
// e 1s.
//    After flipping, the maximum number of consecutive 1s is 4.
//
//
//
// Note:
//
// The input array will only contain 0 and 1.
// The length of input array is a positive integer and will not exceed 10,000
//
//
//
// Follow up:
// What if the input numbers come in one by one as an infinite stream? In other w
// ords, you can't store all numbers coming from the stream as it's too large to ho
// ld in memory. Could you solve it efficiently?
// Related Topics Two Pointers
// 👍 580 👎 9

// leetcode submit region begin(Prohibit modification and deletion)
public class MaxConsecutiveOnesII_487 {
  public int findMaxConsecutiveOnes(int[] nums) {
    int max = 0;
    int currMax = 0;
    int flippedMax = 0;

    for (int num : nums) {
      if (num == 1) {
        currMax++;
        flippedMax++;
      } else {
        max = Math.max(Math.max(max, currMax), flippedMax);
        flippedMax = currMax + 1;
        currMax = 0;
      }
    }

    return Math.max(Math.max(max, currMax), flippedMax);
  }
}

/*
    Runtime: 1 ms, faster than 100.00% of Java online submissions for Max Consecutive Ones II.
    Memory Usage: 41 MB, less than 79.59% of Java online submissions for Max Consecutive Ones II.
 */
// leetcode submit region end(Prohibit modification and deletion)
