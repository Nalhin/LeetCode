package com.leetcode.twopointers.medium;

// You are given an array of positive integers nums and want to erase a subarray
// containing unique elements. The score you get by erasing the subarray is equal t
// o the sum of its elements.
//
// Return the maximum score you can get by erasing exactly one subarray.
//
// An array b is called to be a subarray of a if it forms a contiguous subsequen
// ce of a, that is, if it is equal to a[l],a[l+1],...,a[r] for some (l,r).
//
//
// Example 1:
//
//
// Input: nums = [4,2,4,5,6]
// Output: 17
// Explanation: The optimal subarray here is [2,4,5,6].
//
//
// Example 2:
//
//
// Input: nums = [5,2,1,2,5,2,1,2,5]
// Output: 8
// Explanation: The optimal subarray here is [5,2,1] or [1,2,5].
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 105
// 1 <= nums[i] <= 104
//
// Related Topics Two Pointers
// 👍 302 👎 7
/*
 O(n) Runtime: 49 ms, faster than 51.34% of Java online submissions for Maximum Erasure Value.
 O(n) Memory Usage: 52.2 MB, less than 50.92% of Java online submissions for Maximum Erasure Value.
*/
// leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashSet;
import java.util.Set;

public class MaximumErasureValue_1695 {
  public int maximumUniqueSubarray(int[] nums) {
    Set<Integer> visited = new HashSet<>();
    int result = 0;
    int subarraySum = 0;
    int leftIndex = 0;

    for (int num : nums) {
      while (visited.contains(num)) {
        visited.remove(nums[leftIndex]);
        subarraySum -= nums[leftIndex];
        leftIndex++;
      }

      subarraySum += num;
      visited.add(num);
      result = Math.max(result, subarraySum);
    }

    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
