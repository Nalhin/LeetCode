package com.leetcode.greedy.medium;

// Given an array of integers arr of even length, return true if and only if it i
// s possible to reorder it such that arr[2 * i + 1] = 2 * arr[2 * i] for every 0 <
// = i < len(arr) / 2.
//
//
// Example 1:
//
//
// Input: arr = [3,1,3,6]
// Output: false
//
//
// Example 2:
//
//
// Input: arr = [2,1,2,6]
// Output: false
//
//
// Example 3:
//
//
// Input: arr = [4,-2,2,-4]
// Output: true
// Explanation: We can take two groups, [-2,-4] and [2,4] to form [-2,-4,2,4] or
// [2,4,-2,-4].
//
//
// Example 4:
//
//
// Input: arr = [1,2,4,16,8,4]
// Output: false
//
//
//
// Constraints:
//
//
// 0 <= arr.length <= 3 * 104
// arr.length is even.
// -105 <= arr[i] <= 105
//
// Related Topics Array Hash Table Greedy Sorting
// 👍 622 👎 85
/*
 O(n) Runtime: 116 ms, faster than 7.64% of Java online submissions for Array of Doubled Pairs.
 O(n) Memory Usage: 47 MB, less than 50.12% of Java online submissions for Array of Doubled Pairs.
*/

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ArrayOfDoubledPairs_954 {
  public boolean canReorderDoubled(int[] arr) {

    List<Integer> items =
        Arrays.stream(arr)
            .boxed()
            .sorted(Comparator.comparingInt(Math::abs))
            .collect(Collectors.toList());
    Map<Integer, Long> counter =
        items.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    for (Integer num : items) {
      if (counter.get(num) == 0) {
        continue;
      }

      if (counter.getOrDefault(num * 2, 0L) <= 0) {
        return false;
      }

      counter.merge(num, -1L, Long::sum);
      counter.merge(num * 2, -1L, Long::sum);
    }
    return true;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
