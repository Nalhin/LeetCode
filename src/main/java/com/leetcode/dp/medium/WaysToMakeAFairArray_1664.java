package com.leetcode.dp.medium;

// You are given an integer array nums. You can choose exactly one index (0-index
// ed) and remove the element. Notice that the index of the elements may change aft
// er the removal.
//
// For example, if nums = [6,1,7,4,1]:
//
//
// Choosing to remove index 1 results in nums = [6,7,4,1].
// Choosing to remove index 2 results in nums = [6,1,4,1].
// Choosing to remove index 4 results in nums = [6,1,7,4].
//
//
// An array is fair if the sum of the odd-indexed values equals the sum of the e
// ven-indexed values.
//
// Return the number of indices that you could choose such that after the remova
// l, nums is fair.
//
//
// Example 1:
//
//
// Input: nums = [2,1,6,4]
// Output: 1
// Explanation:
// Remove index 0: [1,6,4] -> Even sum: 1 + 4 = 5. Odd sum: 6. Not fair.
// Remove index 1: [2,6,4] -> Even sum: 2 + 4 = 6. Odd sum: 6. Fair.
// Remove index 2: [2,1,4] -> Even sum: 2 + 4 = 6. Odd sum: 1. Not fair.
// Remove index 3: [2,1,6] -> Even sum: 2 + 6 = 8. Odd sum: 1. Not fair.
// There is 1 index that you can remove to make nums fair.
//
//
// Example 2:
//
//
// Input: nums = [1,1,1]
// Output: 3
// Explanation: You can remove any index and the remaining array is fair.
//
//
// Example 3:
//
//
// Input: nums = [1,2,3]
// Output: 0
// Explanation: You cannot make a fair array after removing any index.
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 105
// 1 <= nums[i] <= 104
//
// Related Topics Dynamic Programming Greedy
// 👍 186 👎 4

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(n) Runtime: 10 ms, faster than 54.90% of Java online submissions for Ways to Make a Fair Array.
 O(n) Memory Usage: 52.3 MB, less than 78.22% of Java online submissions for Ways to Make a Fair Array.
*/
public class WaysToMakeAFairArray_1664 {
  public int waysToMakeFair(int[] nums) {
    int[] evens = new int[nums.length];
    int[] odds = new int[nums.length];

    evens[0] = nums[0];

    for (int i = 1; i < nums.length; i++) {
      evens[i] = evens[i - 1] + (i % 2 == 0 ? nums[i] : 0);
    }

    for (int i = 1; i < nums.length; i++) {
      odds[i] = odds[i - 1] + (i % 2 == 1 ? nums[i] : 0);
    }

    int result = 0;
    int len = nums.length - 1;

    for (int i = 0; i < nums.length; i++) {

      int prevEven = i > 0 ? evens[i - 1] : 0;
      int afterEven = odds[len] - odds[i];
      int prevOdd = i > 0 ? odds[i - 1] : 0;
      int afterOdd = evens[len] - evens[i];

      if (prevEven + afterEven == prevOdd + afterOdd) {
        result++;
      }
    }

    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
