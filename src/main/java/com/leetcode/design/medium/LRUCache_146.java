package com.leetcode.design.medium;

// Design a data structure that follows the constraints of a Least Recently Used
// (LRU) cache.
//
// Implement the LRUCache_146 class:
//
//
// LRUCache_146(int capacity) Initialize the LRU cache with positive size capacity.
//
// int get(int key) Return the value of the key if the key exists, otherwise ret
// urn -1.
// void put(int key, int value) Update the value of the key if the key exists. O
// therwise, add the key-value pair to the cache. If the number of keys exceeds the
// capacity from this operation, evict the least recently used key.
//
//
// Follow up:
// Could you do get and put in O(1) time complexity?
//
//
// Example 1:
//
//
// Input
// ["LRUCache_146", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
// [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
// Output
// [null, null, null, 1, null, -1, null, -1, 3, 4]
//
// Explanation
// LRUCache_146 lRUCache = new LRUCache_146(2);
// lRUCache.put(1, 1); // cache is {1=1}
// lRUCache.put(2, 2); // cache is {1=1, 2=2}
// lRUCache.get(1);    // return 1
// lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
// lRUCache.get(2);    // returns -1 (not found)
// lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
// lRUCache.get(1);    // return -1 (not found)
// lRUCache.get(3);    // return 3
// lRUCache.get(4);    // return 4
//
//
//
// Constraints:
//
//
// 1 <= capacity <= 3000
// 0 <= key <= 3000
// 0 <= value <= 104
// At most 3 * 104 calls will be made to get and put.
//
// Related Topics Design
// 👍 6778 👎 286

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache_146 {
  static class LRUCacheLinkedHashMap {
    private final int capacity;
    private final LinkedHashMap<Integer, Integer> linkedMap = new LinkedHashMap<>();

    public LRUCacheLinkedHashMap(int capacity) {
      this.capacity = capacity;
    }

    public int get(int key) {
      if (!linkedMap.containsKey(key)) {
        return -1;
      }
      int val = linkedMap.remove(key);
      linkedMap.put(key, val);
      return val;
    }

    public void put(int key, int value) {
      linkedMap.remove(key);
      linkedMap.put(key, value);
      if (linkedMap.size() > capacity) {
        linkedMap.remove(linkedMap.keySet().iterator().next());
      }
    }
  }

  static class LRUCacheCustomLL {
    private final int capacity;
    private final Node dummyHead;
    private final Node dummyTail;
    private final Map<Integer, Node> map = new HashMap<>();

    public LRUCacheCustomLL(int capacity) {
      this.capacity = capacity;
      this.dummyHead = new Node(-1, -1);
      this.dummyTail = new Node(-1, -1);
      this.dummyHead.next = dummyTail;
      this.dummyTail.prev = dummyHead;
    }

    public int get(int key) {
      if (!map.containsKey(key)) {
        return -1;
      }
      Node node = map.get(key);
      unlinkNode(node);
      addLast(node);
      return node.val;
    }

    public void put(int key, int value) {
      Node node;
      if (map.containsKey(key)) {
        node = map.get(key);
        node.val = value;
        unlinkNode(node);
      } else {
        node = new Node(key, value);
        map.put(key, node);
      }
      addLast(node);
      ensureCapacity();
    }

    private void unlinkNode(Node node) {
      node.prev.next = node.next;
      node.next.prev = node.prev;
    }

    private void addLast(Node node) {
      node.prev = dummyTail.prev;
      node.next = dummyTail;
      dummyTail.prev.next = node;
      dummyTail.prev = node;
    }

    private void ensureCapacity() {
      if (map.size() > capacity) {
        Node toRemove = dummyHead.next;
        unlinkNode(toRemove);
        map.remove(toRemove.key);
      }
    }

    private static class Node {
      Node prev;
      Node next;
      int val;
      int key;

      public Node(int key, int val) {
        this.val = val;
        this.key = key;
      }
    }
  }
}
/*
Linked Hash Map
O(1)  Runtime: 14 ms, faster than 57.01% of Java online submissions for LRU Cache.
O(n)  Memory Usage: 47.3 MB, less than 5.01% of Java online submissions for LRU Cache.

Custom Doubly Linked List with sentinels
O(1)  Runtime: 13 ms, faster than 78.18% of Java online submissions for LRU Cache.
O(n)  Memory Usage: 46.7 MB, less than 5.01% of Java online submissions for LRU Cache.
 */
/*
 * Your LRUCache_146 object will be instantiated and called as such: LRUCache_146 obj = new
 * LRUCache_146(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */
// leetcode submit region end(Prohibit modification and deletion)
