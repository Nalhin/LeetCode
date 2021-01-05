package com.leetcode.linkedlists.medium;

// We are given a linked list with head as the first node. Let's number the nodes
// in the list: node_1, node_2, node_3, ... etc.
//
// Each node may have a next larger value: for node_i, next_larger(node_i) is th
// e node_j.val such that j > i, node_j.val > node_i.val, and j is the smallest pos
// sible choice. If such a j does not exist, the next larger value is 0.
//
// Return an array of integers answer, where answer[i] = next_larger(node_{i+1})
// .
//
// Note that in the example inputs (not outputs) below, arrays such as [2,1,5] r
// epresent the serialization of a linked list with a head node value of 2, second
// node value of 1, and third node value of 5.
//
//
//
//
// Example 1:
//
//
// Input: [2,1,5]
// Output: [5,5,0]
//
//
//
// Example 2:
//
//
// Input: [2,7,4,3,5]
// Output: [7,0,5,5,0]
//
//
//
// Example 3:
//
//
// Input: [1,7,5,1,9,2,5,1]
// Output: [7,9,9,9,0,5,0,0]
//
//
//
//
// Note:
//
//
// 1 <= node.val <= 10^9 for each node in the linked list.
// The given list has length in the range [0, 10000].
//
//
//
// Related Topics Linked List Stack
// 👍 1126 👎 64

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.LinkedList.ListNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {}
 * ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
 * this.next = next; } }
 */
/*
 O(n) Runtime: 11 ms, faster than 90.34% of Java online submissions for Next Greater Node In Linked List.
 O(n) Memory Usage: 41.1 MB, less than 95.49% of Java online submissions for Next Greater Node In Linked List.
*/
public class NextGreaterNodeInLinkedList_1019 {
  public int[] nextLargerNodes(ListNode head) {
    List<Integer> nodes = new ArrayList<>();

    while (head != null) {
      nodes.add(head.val);
      head = head.next;
    }
    int[] result = new int[nodes.size()];
    Deque<Integer> stack = new ArrayDeque<>();

    for (int i = nodes.size() - 1; i >= 0; i--) {
      while (!stack.isEmpty() && nodes.get(i) >= stack.peek()) {
        stack.pop();
      }
      result[i] = stack.isEmpty() ? 0 : stack.peek();
      stack.push(nodes.get(i));
    }

    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
