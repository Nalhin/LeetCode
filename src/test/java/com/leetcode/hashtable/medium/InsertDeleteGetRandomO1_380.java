package com.leetcode.hashtable.medium;

// Implement the RandomizedSet class:
//
//
// bool insert(int val) Inserts an item val into the set if not present. Returns
// true if the item was not present, false otherwise.
// bool remove(int val) Removes an item val from the set if present. Returns tru
// e if the item was present, false otherwise.
// int getRandom() Returns a random element from the current set of elements (it
// 's guaranteed that at least one element exists when this method is called). Each
// element must have the same probability of being returned.
//
//
// Follow up: Could you implement the functions of the class with each function
// works in average O(1) time?
//
//
// Example 1:
//
//
// Input
// ["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert
// ", "getRandom"]
// [[], [1], [2], [2], [], [1], [2], []]
// Output
// [null, true, false, true, 2, true, false, 2]
//
// Explanation
// RandomizedSet randomizedSet = new RandomizedSet();
// randomizedSet.insert(1); // Inserts 1 to the set. Returns true as 1 was insert
// ed successfully.
// randomizedSet.remove(2); // Returns false as 2 does not exist in the set.
// randomizedSet.insert(2); // Inserts 2 to the set, returns true. Set now contai
// ns [1,2].
// randomizedSet.getRandom(); // getRandom() should return either 1 or 2 randomly
// .
// randomizedSet.remove(1); // Removes 1 from the set, returns true. Set now cont
// ains [2].
// randomizedSet.insert(2); // 2 was already in the set, so return false.
// randomizedSet.getRandom(); // Since 2 is the only number in the set, getRandom
// () will always return 2.
//
//
//
// Constraints:
//
//
// -231 <= val <= 231 - 1
// At most 105 calls will be made to insert, remove, and getRandom.
// There will be at least one element in the data structure when getRandom is ca
// lled.
//
// Related Topics Array Hash Table Design
// 👍 2772 👎 173

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class InsertDeleteGetRandomO1_380 {

  static class RandomizedSet {

    private final Map<Integer, Integer> map = new HashMap<>();
    private final List<Integer> list = new ArrayList<>();

    /** Initialize your data structure here. */
    public RandomizedSet() {}

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified
     * element.
     */
    public boolean insert(int val) {
      if (map.containsKey(val)) {
        return false;
      }
      map.put(val, list.size());
      list.add(val);

      return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
      if (!map.containsKey(val)) {
        return false;
      }

      int listPosition = map.get(val);
      Collections.swap(list, list.size() - 1, listPosition);
      int key = list.get(listPosition);
      map.put(key, listPosition);
      map.remove(val);
      list.remove(list.size() - 1);

      return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
      int randomNum = ThreadLocalRandom.current().nextInt(0, list.size());
      return list.get(randomNum);
    }
  }
}
/*
  O(1)  Runtime: 8 ms, faster than 86.04% of Java online submissions for Insert Delete GetRandom O(1).
  O(n)  Memory Usage: 44.1 MB, less than 88.26% of Java online submissions for Insert Delete GetRandom O(1).
*/

/*
 * Your RandomizedSet object will be instantiated and called as such: RandomizedSet obj = new
 * RandomizedSet(); boolean param_1 = obj.insert(val); boolean param_2 = obj.remove(val); int
 * param_3 = obj.getRandom();
 */
// leetcode submit region end(Prohibit modification and deletion)
