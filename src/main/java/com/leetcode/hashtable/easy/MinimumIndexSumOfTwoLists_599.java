package com.leetcode.hashtable.easy;

//
// Suppose Andy and Doris want to choose a restaurant for dinner, and they both h
// ave a list of favorite restaurants represented by strings.
//
//
// You need to help them find out their common interest with the least list index
// sum. If there is a choice tie between answers, output all of them with no order
// requirement. You could assume there always exists an answer.
//
//
//
// Example 1:
//
// Input:
// ["Shogun", "Tapioca Express", "Burger King", "KFC"]
// ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
// Output: ["Shogun"]
// Explanation: The only restaurant they both like is "Shogun".
//
//
//
// Example 2:
//
// Input:
// ["Shogun", "Tapioca Express", "Burger King", "KFC"]
// ["KFC", "Shogun", "Burger King"]
// Output: ["Shogun"]
// Explanation: The restaurant they both like and have the least index sum is "Sh
// ogun" with index sum 1 (0+1).
//
//
//
//
// Note:
//
// The length of both lists will be in the range of [1, 1000].
// The length of strings in both lists will be in the range of [1, 30].
// The index is starting from 0 to the list length minus 1.
// No duplicates in both lists.
//
// Related Topics Hash Table
// 👍 638 👎 209

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashMap;
import java.util.Map;

public class MinimumIndexSumOfTwoLists_599 {
  public String[] findRestaurant(String[] list1, String[] list2) {
    Map<String, Integer> map = new HashMap<>();
    Map<String, Integer> resultMap = new HashMap<>();

    for (int i = 0; i < list1.length; i++) {
      map.put(list1[i], i);
    }

    for (int i = 0; i < list2.length; i++) {
      if (map.containsKey(list2[i])) {
        resultMap.put(list2[i], map.get(list2[i]) + i);
      }
    }

    return resultMap.values().stream()
        .min(Integer::compareTo)
        .map(
            max ->
                resultMap.entrySet().stream()
                    .filter(i -> i.getValue().equals(max))
                    .map(Map.Entry::getKey)
                    .toArray(String[]::new))
        .orElse(new String[] {});
  }
}

/*
 O(n) Runtime: 14 ms, faster than 35.84% of Java online submissions for Minimum Index Sum of Two Lists.
 O(n) Memory Usage: 39.9 MB, less than 83.01% of Java online submissions for Minimum Index Sum of Two Lists.
*/

// leetcode submit region end(Prohibit modification and deletion)
