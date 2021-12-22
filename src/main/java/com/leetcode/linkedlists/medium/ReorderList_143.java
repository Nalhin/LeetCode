package com.leetcode.linkedlists.medium;

// You are given the head of a singly linked-list. The list can be represented
// as:
//
//
// L0 → L1 → … → Ln - 1 → Ln
//
//
// Reorder the list to be on the following form:
//
//
// L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
//
//
// You may not modify the values in the list's nodes. Only nodes themselves may
// be changed.
//
//
// Example 1:
//
//
// Input: head = [1,2,3,4]
// Output: [1,4,2,3]
//
//
// Example 2:
//
//
// Input: head = [1,2,3,4,5]
// Output: [1,5,2,4,3]
//
//
//
// Constraints:
//
//
// The number of nodes in the list is in the range [1, 5 * 10⁴].
// 1 <= Node.val <= 1000
//
// Related Topics Linked List Two Pointers Stack Recursion 👍 4799 👎 190

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.LinkedList.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {}
 * ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
 * this.next = next; } }
 */
public class ReorderList_143 {

  /*
   O(n) Runtime: 3 ms, faster than 25.10% of Java online submissions for Reorder List.
   O(n) Memory Usage: 40.8 MB, less than 99.72% of Java online submissions for Reorder List.
  */
  static class Stack {
    public void reorderList(ListNode head) {
      Deque<ListNode> deque = new ArrayDeque<>();

      ListNode curr = head;
      while (curr != null) {
        deque.push(curr);
        curr = curr.next;
      }

      while (deque.peek() != head && deque.peek() != head.next) {
        ListNode next = head.next;
        head.next = deque.pop();
        head.next.next = next;
        head = next;
      }
      head.next = deque.pop();
      head.next.next = null;
    }
  }
  /*
   O(n) Runtime: 1 ms, faster than 99.88% of Java online submissions for Reorder List.
   O(1) Memory Usage: 41.4 MB, less than 90.98% of Java online submissions for Reorder List.
  */
  static class Reverse {

    public void reorderList(ListNode head) {

      ListNode fast = head;
      ListNode slow = head;
      while (fast != null && fast.next != null) {
        fast = fast.next.next;
        slow = slow.next;
      }

      ListNode reversed = null;

      while (slow != null) {
        ListNode next = slow.next;
        slow.next = reversed;
        reversed = slow;
        slow = next;
      }

      while (head != null && reversed != null) {
        ListNode next = head.next;
        head.next = reversed;
        reversed = reversed.next;
        head.next.next = next;
        head = next;
      }

      if(head != null){
        head.next = null;
      }
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
