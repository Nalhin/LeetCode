package com.leetcode.dp.medium;
//Given a set of distinct positive integers nums, return the largest subset
//answer such that every pair (answer[i], answer[j]) of elements in this subset
//satisfies:
//
//
// answer[i] % answer[j] == 0, or
// answer[j] % answer[i] == 0
//
//
// If there are multiple solutions, return any of them.
//
//
// Example 1:
//
//
//Input: nums = [1,2,3]
//Output: [1,2]
//Explanation: [1,3] is also accepted.
//
//
// Example 2:
//
//
//Input: nums = [1,2,4,8]
//Output: [1,2,4,8]
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 1000
// 1 <= nums[i] <= 2 * 10⁹
// All the integers in nums are unique.
//
// Related Topics Array Math Dynamic Programming Sorting 👍 2842 👎 135
/*
  O(n^2) Runtime: 18 ms, faster than 40.19% of Java online submissions for Largest Divisible Subset.
  O(n) Memory Usage: 39.1 MB, less than 86.29% of Java online submissions for Largest Divisible Subset.
*/

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class LargestDivisibleSubset_368 {
  public List<Integer> largestDivisibleSubset(int[] nums) {
    Map<Integer, Integer> predecessors = new HashMap<>();
    Arrays.sort(nums);
    int[] dp = new int[nums.length];


    for(int i = 0; i < nums.length; i++){
      for(int j = i + 1; j < nums.length; j++) {
        if(nums[j] % nums[i] == 0){
          if(dp[i] + 1 > dp[j]){
            dp[j] = dp[i] + 1;
            predecessors.put(j, i);
          }
        }
      }
    }

    int lastIdx = 0;
    for(int i = 0; i < dp.length; i++){
      if(dp[i] > dp[lastIdx]){
        lastIdx = i;
      }
    }

    List<Integer> result = new ArrayList<>();
    result.add(nums[lastIdx]);

    while(predecessors.containsKey(lastIdx)){
      int prev = predecessors.get(lastIdx);
      result.add(nums[prev]);
      lastIdx = prev;
    }

    return result;
  }

}
//leetcode submit region end(Prohibit modification and deletion)
