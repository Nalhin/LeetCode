package com.leetcode.hashtable.medium;

// Given an integer array nums and an integer k, return the maximum length of a
// subarray that sums to k. If there isn't one, return 0 instead.
//
//
// Example 1:
//
//
// Input: nums = [1,-1,5,-2,3], k = 3
// Output: 4
// Explanation: The subarray [1, -1, 5, -2] sums to 3 and is the longest.
//
//
// Example 2:
//
//
// Input: nums = [-2,-1,2,1], k = 1
// Output: 2
// Explanation: The subarray [-1, 2] sums to 1 and is the longest.
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 2 * 10⁵
// -10⁴ <= nums[i] <= 10⁴
// -10⁹ <= k <= 10⁹
//
// Related Topics Array Hash Table 👍 1380 👎 41
/*
 O(n) Runtime: 30 ms, faster than 95.52% of Java online submissions for Maximum Size Subarray Sum Equals k.
 O(n) Memory Usage: 68.7 MB, less than 68.97% of Java online submissions for Maximum Size Subarray Sum Equals k.
*/
// leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashMap;
import java.util.Map;

public class MaximumSizeSubarraySumEqualsK_325 {

  public int maxSubArrayLen(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, -1);

    int sum = 0;
    int result = 0;

    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];

      if (map.containsKey(sum - k)) {
        result = Math.max(result, i - map.get(sum - k));
      }

      if (!map.containsKey(sum)) {
        map.put(sum, i);
      }
    }
    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
