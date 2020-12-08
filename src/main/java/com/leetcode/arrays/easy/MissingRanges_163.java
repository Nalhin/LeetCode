package com.leetcode.arrays.easy;

// You are given an inclusive range [lower, upper] and a sorted unique integer ar
// ray nums, where all elements are in the inclusive range.
//
// A number x is considered missing if x is in the range [lower, upper] and x is
// not in nums.
//
// Return the smallest sorted list of ranges that cover every missing number exa
// ctly. That is, no element of nums is in any of the ranges, and each missing numb
// er is in one of the ranges.
//
// Each range [a,b] in the list should be output as:
//
//
// "a->b" if a != b
// "a" if a == b
//
//
//
// Example 1:
//
//
// Input: nums = [0,1,3,50,75], lower = 0, upper = 99
// Output: ["2","4->49","51->74","76->99"]
// Explanation: The ranges are:
// [2,2] --> "2"
// [4,49] --> "4->49"
// [51,74] --> "51->74"
// [76,99] --> "76->99"
//
//
// Example 2:
//
//
// Input: nums = [], lower = 1, upper = 1
// Output: ["1"]
// Explanation: The only missing range is [1,1], which becomes "1".
//
//
// Example 3:
//
//
// Input: nums = [], lower = -3, upper = -1
// Output: ["-3->-1"]
// Explanation: The only missing range is [-3,-1], which becomes "-3->-1".
//
//
// Example 4:
//
//
// Input: nums = [-1], lower = -1, upper = -1
// Output: []
// Explanation: There are no missing ranges since there are no missing numbers.
//
//
// Example 5:
//
//
// Input: nums = [-1], lower = -2, upper = -1
// Output: ["-2"]
//
//
//
// Constraints:
//
//
// -109 <= lower <= upper <= 109
// 0 <= nums.length <= 100
// lower <= nums[i] <= upper
// All the values of nums are unique.
//
// Related Topics Array
// 👍 417 👎 1978

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;
/*
 O(n) Runtime: 6 ms, faster than 59.18% of Java online submissions for Missing Ranges.
 O(n) Memory Usage: 37.4 MB, less than 52.47% of Java online submissions for Missing Ranges.
*/
public class MissingRanges_163 {
  public List<String> findMissingRanges(int[] nums, int lower, int upper) {
    List<String> result = new ArrayList<>();

    if (nums.length <= 0) {
      if (lower == upper) {
        result.add(String.valueOf(lower));
        return result;
      }
      result.add(lower + "->" + upper);
      return result;
    }

    int left = lower - 1;

    for (int num : nums) {
      if (num - left >= 3) {
        result.add((left + 1) + "->" + (num - 1));
      } else if (left + 2 == num) {
        result.add(String.valueOf(left + 1));
      }
      left = num;
    }

    if (upper - left >= 2) {
      result.add((left + 1) + "->" + upper);
    } else if (left + 1 == upper) {
      result.add(String.valueOf(left + 1));
    }

    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
