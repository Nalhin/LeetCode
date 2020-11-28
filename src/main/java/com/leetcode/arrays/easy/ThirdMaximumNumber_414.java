package com.leetcode.arrays.easy;

// Given a non-empty array of integers, return the third maximum number in this a
// rray. If it does not exist, return the maximum number. The time complexity must
// be in O(n).
//
// Example 1:
//
// Input: [3, 2, 1]
//
// Output: 1
//
// Explanation: The third maximum is 1.
//
//
//
// Example 2:
//
// Input: [1, 2]
//
// Output: 2
//
// Explanation: The third maximum does not exist, so the maximum (2) is returned
// instead.
//
//
//
// Example 3:
//
// Input: [2, 2, 3, 1]
//
// Output: 1
//
// Explanation: Note that the third maximum here means the third maximum distinct
// number.
// Both numbers with value 2 are both considered as second maximum.
//
// Related Topics Array
// 👍 741 👎 1357

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// leetcode submit region begin(Prohibit modification and deletion)
public class ThirdMaximumNumber_414 {
  public int thirdMax(int[] nums) {
    Set<Integer> set = IntStream.of(nums).boxed().collect(Collectors.toSet());

    int max = Collections.max(set);

    if (set.size() < 3) {
      return max;
    }

    set.remove(max);
    set.remove(Collections.max(set));
    return Collections.max(set);
  }
}

/*
  Runtime: 6 ms, faster than 22.40% of Java online submissions for Third Maximum Number.
  Memory Usage: 39.4 MB, less than 58.12% of Java online submissions for Third Maximum Number.
*/

// leetcode submit region end(Prohibit modification and deletion)
