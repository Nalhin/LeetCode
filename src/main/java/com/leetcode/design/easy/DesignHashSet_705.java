package com.leetcode.design.easy;

// Design a HashSet without using any built-in hash table libraries.
//
// To be specific, your design should include these functions:
//
//
// put(value): Insert a value into the HashSet.
// contains(value) : Return whether the value exists in the HashSet or not.
// remove(value): Remove a value in the HashSet. If the value does not exist in
// the HashSet, do nothing.
//
//
//
// Example:
//
//
// MyHashSet hashSet = new MyHashSet();
// hashSet.put(1);
// hashSet.put(2);
// hashSet.contains(1);    // returns true
// hashSet.contains(3);    // returns false (not found)
// hashSet.put(2);
// hashSet.contains(2);    // returns true
// hashSet.remove(2);
// hashSet.contains(2);    // returns false (already removed)
//
//
//
// Note:
//
//
// All values will be in the range of [0, 1000000].
// The number of operations will be in the range of [1, 10000].
// Please do not use the built-in HashSet library.
//
// Related Topics Hash Table Design
// 👍 546 👎 91

// leetcode submit region begin(Prohibit modification and deletion)

public class DesignHashSet_705 {
  static class MyHashSet {
    private final int indexRange = 769;
    private final Bucket[] buckets;

    /** Initialize your data structure here. */
    public MyHashSet() {
      this.buckets = new Bucket[indexRange];
      for (int i = 0; i < indexRange; i++) {
        this.buckets[i] = new Bucket();
      }
    }

    public void add(int key) {
      buckets[hash(key)].add(key);
    }

    public void remove(int key) {
      buckets[hash(key)].remove(key);
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
      return buckets[hash(key)].contains(key);
    }

    private int hash(int key) {
      return key % indexRange;
    }
  }

  private static class Bucket {
    private final BucketNode head = new BucketNode();

    public void add(int key) {
      if (!this.contains(key)) {
        head.next = new BucketNode(key, head.next);
      }
    }

    private boolean contains(int key) {
      BucketNode curr = head.next;

      while (curr != null) {
        if (curr.key == key) {
          return true;
        }
        curr = curr.next;
      }
      return false;
    }

    private void remove(int key) {
      BucketNode curr = head;

      while (curr.next != null) {
        if (curr.next.key == key) {
          curr.next = curr.next.next;
          return;
        }
        curr = curr.next;
      }
    }

    private static class BucketNode {
      private int key;
      private BucketNode next;

      public BucketNode() {}

      public BucketNode(int key, BucketNode next) {
        this.key = key;
        this.next = next;
      }
    }
  }
}

/*
 K - buckets count;
 M - unique values inserted;
 N - number of all possible values;

 O(N / K) Runtime: 12 ms, faster than 73.25% of Java online submissions for Design HashSet.
 O(K + M) Memory Usage: 45.6 MB, less than 95.61% of Java online submissions for Design HashSet.
*/

/*
 * Your MyHashSet object will be instantiated and called as such: MyHashSet obj = new MyHashSet();
 * obj.put(key); obj.remove(key); boolean param_3 = obj.contains(key);
 */
// leetcode submit region end(Prohibit modification and deletion)
