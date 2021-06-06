package com.leetcode.hashtable.medium;

// Given an unsorted array of integers nums, return the length of the longest con
// secutive elements sequence.
//
// You must write an algorithm that runs in O(n) time.
//
//
// Example 1:
//
//
// Input: nums = [100,4,200,1,3,2]
// Output: 4
// Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Theref
// ore its length is 4.
//
//
// Example 2:
//
//
// Input: nums = [0,3,7,2,5,8,4,6,0,1]
// Output: 9
//
//
//
// Constraints:
//
//
// 0 <= nums.length <= 105
// -109 <= nums[i] <= 109
//
// Related Topics Array Union Find
// 👍 5400 👎 264

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class LongestConsecutiveSequence_128 {
  static class Recursive {
    /*
      O(n) Runtime: 83 ms, faster than 29.40% of Java online submissions for Longest Consecutive Sequence.
      O(n) Memory Usage: 79.1 MB, less than 5.18% of Java online submissions for Longest Consecutive Sequence.
    */
    public int longestConsecutive(int[] nums) {
      Set<Integer> numsSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());
      Map<Integer, Integer> consecutiveCounts = new HashMap<>();

      int result = 0;
      for (int num : nums) {
        result = Math.max(result, calculateConsecutiveCount(num, numsSet, consecutiveCounts));
      }

      return result;
    }

    private int calculateConsecutiveCount(
        int currNum, Set<Integer> numsSet, Map<Integer, Integer> consecutiveCounts) {
      if (!numsSet.contains(currNum)) {
        return 0;
      }
      if (consecutiveCounts.containsKey(currNum)) {
        return consecutiveCounts.get(currNum);
      }

      int currCounts = calculateConsecutiveCount(currNum - 1, numsSet, consecutiveCounts) + 1;
      consecutiveCounts.put(currNum, currCounts);
      return currCounts;
    }
  }
  /*
   O(n) Runtime: 511 ms, faster than 7.13% of Java online submissions for Longest Consecutive Sequence.
   O(n) Memory Usage: 181.2 MB, less than 5.18% of Java online submissions for Longest Consecutive Sequence.
  */
  static class Iterative {
    public int longestConsecutive(int[] nums) {
      Set<Integer> numsSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());

      int result = 0;
      for (int num : nums) {
        if (!numsSet.contains(num - 1)) {
          int curr = num + 1;
          while (numsSet.contains(curr)) {
            curr++;
          }
          result = Math.max(curr - num, result);
        }
      }

      return result;
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
