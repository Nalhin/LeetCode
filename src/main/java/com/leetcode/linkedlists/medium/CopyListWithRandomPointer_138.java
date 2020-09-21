package com.leetcode.linkedlists.medium;
// A linked list is given such that each node contains an additional random point
// er which could point to any node in the list or null.
//
// Return a deep copy of the list.
//
// The Linked List is represented in the input/output as a list of n nodes. Each
// node is represented as a pair of [val, random_index] where:
//
//
// val: an integer representing Node.val
// random_index: the index of the node (range from 0 to n-1) where random pointe
// r points to, or null if it does not point to any node.
//
//
//
// Example 1:
//
//
// Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
// Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
//
//
// Example 2:
//
//
// Input: head = [[1,1],[2,1]]
// Output: [[1,1],[2,1]]
//
//
// Example 3:
//
//
//
//
// Input: head = [[3,null],[3,0],[3,null]]
// Output: [[3,null],[3,0],[3,null]]
//
//
// Example 4:
//
//
// Input: head = []
// Output: []
// Explanation: Given linked list is empty (null pointer), so return null.
//
//
//
// Constraints:
//
//
// -10000 <= Node.val <= 10000
// Node.random is null or pointing to a node in the linked list.
// Number of Nodes will not exceed 1000.
//
// Related Topics Hash Table Linked List
// 👍 3760 👎 714

// leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer_138 {
  private static class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
      this.val = val;
      this.next = null;
      this.random = null;
    }
  }

  Map<Node, Node> visited = new HashMap<>();

  public Node copyRandomList(Node head) {
    Node dummy = new Node(0);
    Node curr = dummy;
    Node old = head;

    for (int i = 0; old != null; i++) {
      curr.next = getNode(old);
      curr.next.random = getNode(old.random);
      old = old.next;
      curr = curr.next;
    }

    return dummy.next;
  }

  private Node getNode(Node node) {
    if (node == null) {
      return null;
    }
    if (this.visited.containsKey(node)) {
      return this.visited.get(node);
    } else {
      Node newNode = new Node(node.val);
      this.visited.put(node, newNode);
      return newNode;
    }
  }
}

/*
  O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Copy List with Random Pointer.
  O(n) Memory Usage: 39.5 MB, less than 37.32% of Java online submissions for Copy List with Random Pointer.
*/
// leetcode submit region end(Prohibit modification and deletion)
