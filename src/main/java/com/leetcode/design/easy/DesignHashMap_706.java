package com.leetcode.design.easy;

// Design a HashMap without using any built-in hash table libraries.
//
// To be specific, your design should include these functions:
//
//
// put(key, value) : Insert a (key, value) pair into the HashMap. If the value a
// lready exists in the HashMap, update the value.
// get(key): Returns the value to which the specified key is mapped, or -1 if th
// is map contains no mapping for the key.
// remove(key) : Remove the mapping for the value key if this map contains the m
// apping for the key.
//
//
//
// Example:
//
//
// MyHashMap hashMap = new MyHashMap();
// hashMap.put(1, 1);
// hashMap.put(2, 2);
// hashMap.get(1);            // returns 1
// hashMap.get(3);            // returns -1 (not found)
// hashMap.put(2, 1);          // update the existing value
// hashMap.get(2);            // returns 1
// hashMap.remove(2);          // remove the mapping for 2
// hashMap.get(2);            // returns -1 (not found)
//
//
//
// Note:
//
//
// All keys and values will be in the range of [0, 1000000].
// The number of operations will be in the range of [1, 10000].
// Please do not use the built-in HashMap library.
//
// Related Topics Hash Table Design
// 👍 995 👎 120

// leetcode submit region begin(Prohibit modification and deletion)

public class DesignHashMap_706 {
  static class MyHashMap {

    private final int indexRange = 769;
    private final Bucket[] buckets;

    /** Initialize your data structure here. */
    public MyHashMap() {
      this.buckets = new Bucket[indexRange];
      for (int i = 0; i < indexRange; i++) {
        buckets[i] = new Bucket();
      }
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
      buckets[hash(key)].put(key, value);
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping
     * for the key
     */
    public int get(int key) {
      return buckets[hash(key)].get(key);
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
      buckets[hash(key)].remove(key);
    }

    public int hash(int key) {
      return key % indexRange;
    }
  }

  private static class Bucket {

    BucketNode head = new BucketNode();

    public void put(int key, int val) {
      BucketNode node = findNextNodeWithKey(key);
      if (node != null) {
        node.next.val = val;
      } else {
        head.next = new BucketNode(key, val, head.next);
      }
    }

    public int get(int key) {
      BucketNode node = findNextNodeWithKey(key);
      if (node != null) {
        return node.next.val;
      }
      return -1;
    }

    public void remove(int key) {
      BucketNode node = findNextNodeWithKey(key);
      if (node != null) {
        node.next = node.next.next;
      }
    }

    private BucketNode findNextNodeWithKey(int key) {
      BucketNode curr = head;

      while (curr.next != null) {
        if (curr.next.key == key) {
          return curr;
        }
        curr = curr.next;
      }
      return null;
    }

    private static class BucketNode {
      private int key;
      private int val;
      private BucketNode next;

      public BucketNode() {}

      public BucketNode(int key, int val, BucketNode next) {
        this.key = key;
        this.val = val;
        this.next = next;
      }
    }
  }
}

/*
 K - buckets count;
 M - unique values inserted;
 N - number of all possible values;

 O(N / K) Runtime: 13 ms, faster than 84.64% of Java online submissions for Design HashMap.
 O(K + M) Memory Usage: 42.7 MB, less than 94.76% of Java online submissions for Design HashMap.
*/

/*
 * Your MyHashMap object will be instantiated and called as such: MyHashMap obj = new MyHashMap();
 * obj.put(key,value); int param_2 = obj.get(key); obj.remove(key);
 */
// leetcode submit region end(Prohibit modification and deletion)
