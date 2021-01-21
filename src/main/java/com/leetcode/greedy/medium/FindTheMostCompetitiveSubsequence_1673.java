package com.leetcode.greedy.medium;

// Given an integer array nums and a positive integer k, return the most competit
// ive subsequence of nums of size k.
//
// An array's subsequence is a resulting sequence obtained by erasing some (poss
// ibly zero) elements from the array.
//
// We define that a subsequence a is more competitive than a subsequence b (of t
// he same length) if in the first position where a and b differ, subsequence a has
// a number less than the corresponding number in b. For example, [1,3,4] is more
// competitive than [1,3,5] because the first position they differ is at the final
// number, and 4 is less than 5.
//
//
// Example 1:
//
//
// Input: nums = [3,5,2,6], k = 2
// Output: [2,6]
// Explanation: Among the set of every possible subsequence: {[3,5], [3,2], [3,6]
// , [5,2], [5,6], [2,6]}, [2,6] is the most competitive.
//
//
// Example 2:
//
//
// Input: nums = [2,4,3,3,5,4,9,6], k = 4
// Output: [2,3,3,4]
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 105
// 0 <= nums[i] <= 109
// 1 <= k <= nums.length
// Related Topics Stack Heap Greedy Queue
// 👍 477 👎 27

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayDeque;
import java.util.Deque;
/*
 O(n) Runtime: 24 ms, faster than 70.02% of Java online submissions for Find the Most Competitive Subsequence.
 O(n) Memory Usage: 57.7 MB, less than 30.69% of Java online submissions for Find the Most Competitive Subsequence.
*/
public class FindTheMostCompetitiveSubsequence_1673 {
  public int[] mostCompetitive(int[] nums, int k) {
    int removeCount = nums.length - k;
    Deque<Integer> deque = new ArrayDeque<>();
    int[] result = new int[k];
    for (int num : nums) {
      while (!deque.isEmpty() && deque.peek() > num && removeCount > 0) {
        deque.pop();
        removeCount--;
      }
      deque.push(num);
    }

    for (int i = 0; i < result.length; i++) {
      result[i] = deque.removeLast();
    }

    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
