package com.leetcode.design.medium;

// Implement the MapSum class:
//
//
// MapSum() Initializes the MapSum object.
// void insert(String key, int val) Inserts the key-val pair into the map. If th
// e key already existed, the original key-value pair will be overridden to the new
// one.
// int sum(string prefix) Returns the sum of all the pairs' value whose key star
// ts with the prefix.
//
//
//
// Example 1:
//
//
// Input
// ["MapSum", "insert", "sum", "insert", "sum"]
// [[], ["apple", 3], ["ap"], ["app", 2], ["ap"]]
// Output
// [null, null, 3, null, 5]
//
// Explanation
// MapSum mapSum = new MapSum();
// mapSum.insert("apple", 3);
// mapSum.sum("ap");           // return 3 (apple = 3)
// mapSum.insert("app", 2);
// mapSum.sum("ap");           // return 5 (apple + app = 3 + 2 = 5)
//
//
//
// Constraints:
//
//
// 1 <= key.length, prefix.length <= 50
// key and prefix consist of only lowercase English letters.
// 1 <= val <= 1000
// At most 50 calls will be made to insert and sum.
//
// Related Topics Hash Table String Design Trie
// 👍 884 👎 105

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashMap;
import java.util.Map;

public class MapSumPairs_677 {

  /*
   O(n^2) Runtime: 12 ms, faster than 56.29% of Java online submissions for Map Sum Pairs.
   O(n^2) Memory Usage: 38.7 MB, less than 88.81% of Java online submissions for Map Sum Pairs.
  */
  static class MapSum {

    private final Map<String, Integer> prefixMap = new HashMap<>();
    private final Map<String, Integer> originals = new HashMap<>();

    /** Initialize your data structure here. */
    public MapSum() {}

    public void insert(String key, int val) {
      int original = val;
      val -= originals.getOrDefault(key, 0);

      for (int i = 0; i < key.length(); i++) {
        prefixMap.merge(key.substring(0, i + 1), val, Integer::sum);
      }

      originals.put(key, original);
    }

    public int sum(String prefix) {
      return prefixMap.getOrDefault(prefix, 0);
    }
  }
}
/**
 * Your MapSum object will be instantiated and called as such: MapSum obj = new MapSum();
 * obj.insert(key,val); int param_2 = obj.sum(prefix);
 */
// leetcode submit region end(Prohibit modification and deletion)
