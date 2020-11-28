package com.leetcode.arrays.easy;

// You are given a sorted unique integer array nums.
//
// Return the smallest sorted list of ranges that cover all the numbers in the a
// rray exactly. That is, each element of nums is covered by exactly one of the ran
// ges, and there is no integer x such that x is in one of the ranges but not in nu
// ms.
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
// Input: nums = [0,1,2,4,5,7]
// Output: ["0->2","4->5","7"]
// Explanation: The ranges are:
// [0,2] --> "0->2"
// [4,5] --> "4->5"
// [7,7] --> "7"
//
//
// Example 2:
//
//
// Input: nums = [0,2,3,4,6,8,9]
// Output: ["0","2->4","6","8->9"]
// Explanation: The ranges are:
// [0,0] --> "0"
// [2,4] --> "2->4"
// [6,6] --> "6"
// [8,9] --> "8->9"
//
//
// Example 3:
//
//
// Input: nums = []
// Output: []
//
//
// Example 4:
//
//
// Input: nums = [-1]
// Output: ["-1"]
//
//
// Example 5:
//
//
// Input: nums = [0]
// Output: ["0"]
//
//
//
// Constraints:
//
//
// 0 <= nums.length <= 20
// -231 <= nums[i] <= 231 - 1
// All the values of nums are unique.
//
// Related Topics Array
// 👍 743 👎 566

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;
/*
 O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Summary Ranges.
 O(1) Memory Usage: 37.1 MB, less than 8.82% of Java online submissions for Summary Ranges.
*/
public class SummaryRanges_228 {
  public List<String> summaryRanges(int[] nums) {
    List<String> result = new ArrayList<>();
    if (nums.length == 0) {
      return result;
    }

    StringBuilder range = new StringBuilder();
    range.append(nums[0]);
    boolean isRange = false;

    for (int i = 1; i < nums.length; i++) {
      if (nums[i] != nums[i - 1] + 1) {
        if (isRange) {
          range.append("->").append(nums[i - 1]);
        }
        result.add(range.toString());
        range = new StringBuilder();
        range.append(nums[i]);
        isRange = false;
      } else {
        isRange = true;
      }
    }
    if (isRange) {
      range.append("->").append(nums[nums.length - 1]);
    }
    result.add(range.toString());
    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
