package com.leetcode.hashtable.medium;
// Given an array of integers nums and an integer k, return the number of unique
// k-diff pairs in the array.
//
// A k-diff pair is an integer pair (nums[i], nums[j]), where the following are
// true:
//
//
// 0 <= i, j < nums.length
// i != j
// a <= b
// b - a == k
//
//
//
// Example 1:
//
//
// Input: nums = [3,1,4,1,5], k = 2
// Output: 2
// Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
// Although we have two 1s in the input, we should only return the number of uniq
// ue pairs.
//
//
// Example 2:
//
//
// Input: nums = [1,2,3,4,5], k = 1
// Output: 4
// Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4)
// and (4, 5).
//
//
// Example 3:
//
//
// Input: nums = [1,3,1,5,4], k = 0
// Output: 1
// Explanation: There is one 0-diff pair in the array, (1, 1).
//
//
// Example 4:
//
//
// Input: nums = [1,2,4,4,3,3,0,9,2,3], k = 3
// Output: 2
//
//
// Example 5:
//
//
// Input: nums = [-1,-2,-3], k = 1
// Output: 2
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 104
// -107 <= nums[i] <= 107
// 0 <= k <= 107
//
// Related Topics Array Two Pointers
// 👍 731 👎 1445

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashMap;
import java.util.Map;

public class KdiffPairsInAnArray_532 {
  public int findPairs(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = nums.length - 1; i >= 0; i--) {
      map.put(nums[i], i);
    }

    int result = 0;
    for (int i = nums.length - 1; i >= 0; i--) {
      int searched = nums[i] - k;
      if (map.containsKey(searched)) {
        int j = map.get(searched);
        if (j != i) {
          result++;
          map.remove(searched);
        }
      }
    }
    return result;
  }
}
/*
   O(n) Runtime: 8 ms, faster than 72.91% of Java online submissions for K-diff Pairs in an Array
   O(n) Memory Usage: 39.1 MB, less than 97.65% of Java online submissions for K-diff Pairs in an Array.
*/
// leetcode submit region end(Prohibit modification and deletion)
