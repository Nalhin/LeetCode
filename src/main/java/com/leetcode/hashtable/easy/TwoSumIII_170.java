package com.leetcode.hashtable.easy;

import java.util.HashMap;

// Design and implement a TwoSum class. It should support the following operation
// s: add and find.
//
// add - Add the number to an internal data structure.
// find - Find if there exists any pair of numbers which sum is equal to the valu
// e.
//
// Example 1:
//
//
// add(1); add(3); add(5);
// find(4) -> true
// find(7) -> false
//
//
// Example 2:
//
//
// add(3); add(1); add(2);
// find(3) -> true
// find(6) -> false
// Related Topics Hash Table Design
// 👍 302 👎 244

// leetcode submit region begin(Prohibit modification and deletion)
public class TwoSumIII_170 {
  static class TwoSum {

    private final HashMap<Integer, Integer> map = new HashMap<>();

    /** Initialize your data structure here. */
    public TwoSum() {}

    /** Add the number to an internal data structure.. */
    public void add(int number) {
      this.map.put(number, map.getOrDefault(number, 0) + 1);
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
      for (Integer key : map.keySet()) {
        int searched = value - key;
        if (map.containsKey(searched)) {
          if (key != searched) {
            return true;
          } else if (map.get(key) > 1) {
            return true;
          }
        }
      }
      return false;
    }
  }
}
/*
  O(n) find O(1) add Runtime: 86 ms, faster than 80.35% of Java online submissions for Two Sum III - Data structure design.
  O(n) Memory Usage: 46.7 MB, less than 80.60% of Java online submissions for Two Sum III - Data structure design.
*/

/*
* Your TwoSum object will be instantiated and called as such:
* TwoSum obj = new TwoSum();
* obj.add(number);
* boolean param_2 = obj.find(value);
*/
// leetcode submit region end(Prohibit modification and deletion)
