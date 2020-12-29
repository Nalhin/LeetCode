package com.leetcode.hashtable.medium;

// Given an array A of integers, return the number of (contiguous, non-empty) sub
// arrays that have a sum divisible by K.
//
//
//
//
// Example 1:
//
//
// Input: A = [4,5,0,-2,-3,1], K = 5
// Output: 7
// Explanation: There are 7 subarrays with a sum divisible by K = 5:
// [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
//
//
//
//
// Note:
//
//
// 1 <= A.length <= 30000
// -10000 <= A[i] <= 10000
// 2 <= K <= 10000
//
// Related Topics Array Hash Table
// 👍 1307 👎 99

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(n) Runtime: 4 ms, faster than 95.33% of Java online submissions for Subarray Sums Divisible by K.
 O(k) Memory Usage: 42.1 MB, less than 72.03% of Java online submissions for Subarray Sums Divisible by K.
*/
public class SubarraySumsDivisibleByK_974 {
  public int subarraysDivByK(int[] nums, int k) {
    int[] prefix = new int[k];
    prefix[0] = 1;
    int count = 0;
    int sum = 0;
    for (int num : nums) {
      sum = (sum + num) % k;
      if (sum < 0) {
        sum += k;
      }
      count += prefix[sum];
      prefix[sum]++;
    }
    return count;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
