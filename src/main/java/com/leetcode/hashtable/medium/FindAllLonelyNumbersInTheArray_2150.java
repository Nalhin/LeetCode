package com.leetcode.hashtable.medium;

// You are given an integer array nums. A number x is lonely when it appears
// only once, and no adjacent numbers (i.e. x + 1 and x - 1) appear in the array.
//
// Return all lonely numbers in nums. You may return the answer in any order.
//
//
// Example 1:
//
//
// Input: nums = [10,6,5,8]
// Output: [10,8]
// Explanation:
// - 10 is a lonely number since it appears exactly once and 9 and 11 does not
// appear in nums.
// - 8 is a lonely number since it appears exactly once and 7 and 9 does not
// appear in nums.
// - 5 is not a lonely number since 6 appears in nums and vice versa.
// Hence, the lonely numbers in nums are [10, 8].
// Note that [8, 10] may also be returned.
//
//
// Example 2:
//
//
// Input: nums = [1,3,5,3]
// Output: [1,5]
// Explanation:
// - 1 is a lonely number since it appears exactly once and 0 and 2 does not
// appear in nums.
// - 5 is a lonely number since it appears exactly once and 4 and 6 does not
// appear in nums.
// - 3 is not a lonely number since it appears twice.
// Hence, the lonely numbers in nums are [1, 5].
// Note that [5, 1] may also be returned.
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 10⁵
// 0 <= nums[i] <= 10⁶
//
// Related Topics Array Hash Table Counting 👍 150 👎 23
/*
 O(n) Runtime: 134 ms, faster than 61.57% of Java online submissions for Find All Lonely Numbers in the Array.
 O(n) Memory Usage: 164.7 MB, less than 40.76% of Java online submissions for Find All Lonely Numbers in the Array.
*/
// leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllLonelyNumbersInTheArray_2150 {
  public List<Integer> findLonely(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();

    for (int num : nums) {
      map.merge(num, 1, Integer::sum);
    }

    List<Integer> result = new ArrayList<>();

    for (int num : nums) {
      if (!map.containsKey(num - 1) && !map.containsKey(num + 1) && map.get(num) == 1) {
        result.add(num);
      }
    }

    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
