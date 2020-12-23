package com.leetcode.strings.medium;

// Given a positive integer n, find the smallest integer which has exactly the sa
// me digits existing in the integer n and is greater in value than n. If no such p
// ositive integer exists, return -1.
//
// Note that the returned integer should fit in 32-bit integer, if there is a va
// lid answer but it does not fit in 32-bit integer, return -1.
//
//
// Example 1:
// Input: n = 12
// Output: 21
// Example 2:
// Input: n = 21
// Output: -1
//
//
// Constraints:
//
//
// 1 <= n <= 231 - 1
//
// Related Topics String
// 👍 906 👎 230

/*
 O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Next Greater Element III.
 O(n) Memory Usage: 35.4 MB, less than 98.73% of Java online submissions for Next Greater Element III.
*/
// leetcode submit region begin(Prohibit modification and deletion)
public class NextGreaterElementIII_556 {
  public int nextGreaterElement(int n) {
    char[] nums = String.valueOf(n).toCharArray();

    int index = nums.length - 2;
    while (index >= 0 && nums[index] >= nums[index + 1]) {
      index--;
    }

    if (index < 0) {
      return -1;
    }

    int curr = nums.length - 1;
    while (curr >= 0 && nums[curr] <= nums[index]) {
      curr--;
    }

    swap(nums, index, curr);
    reverse(nums, index + 1);

    long result = Long.parseLong(String.valueOf(nums));

    if (result > Integer.MAX_VALUE) {
      return -1;
    }
    return (int) result;
  }

  private void swap(char[] nums, int first, int second) {
    char temp = nums[first];
    nums[first] = nums[second];
    nums[second] = temp;
  }

  private void reverse(char[] nums, int from) {
    int to = nums.length - 1;
    while (from < to) {
      swap(nums, from, to);
      from++;
      to--;
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
