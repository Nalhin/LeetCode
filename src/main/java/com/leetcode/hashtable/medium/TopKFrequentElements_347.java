package com.leetcode.hashtable.medium;
// Given a non-empty array of integers, return the k most frequent elements.
//
// Example 1:
//
//
// Input: nums = [1,1,1,2,2,3], k = 2
// Output: [1,2]
//
//
//
// Example 2:
//
//
// Input: nums = [1], k = 1
// Output: [1]
//
//
// Note:
//
//
// You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
// Your algorithm's time complexity must be better than O(n log n), where n is t
// he array's size.
// It's guaranteed that the answer is unique, in other words the set of the top
// k frequent elements is unique.
// You can return the answer in any order.
//
// Related Topics Hash Table Heap
// 👍 3761 👎 229

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TopKFrequentElements_347 {
  public int[] topKFrequent(int[] nums, int k) {

    Map<Integer, Long> map =
        Arrays.stream(nums)
            .boxed()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    Map<Integer, Set<Integer>> occurrences =
        map.entrySet().stream()
            .collect(
                Collectors.groupingBy(
                    (e) -> e.getValue().intValue(),
                    Collectors.mapping(Map.Entry::getKey, Collectors.toSet())));

    List<Integer> result = new ArrayList<>(k);
    for (int i = nums.length; i >= 0 && result.size() < k; i--) {
      if (occurrences.containsKey(i)) {
       result.addAll(occurrences.get(i));
      }
    }

    return result.stream().mapToInt(Integer::intValue).toArray();
  }
}

/*  O(n) Runtime: 16 ms, faster than 24.55% of Java online submissions for Top K Frequent Elements.
    O(n) Memory Usage: 40.9 MB, less than 99.97% of Java online submissions for Top K Frequent Elements.
*/
// leetcode submit region end(Prohibit modification and deletion)

