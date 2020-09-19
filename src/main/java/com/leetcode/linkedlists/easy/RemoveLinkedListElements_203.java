package com.leetcode.linkedlists.easy;

// Remove all elements from a linked list of integers that have value val.
//
// Example:
//
//
// Input:  1->2->6->3->4->5->6, val = 6
// Output: 1->2->3->4->5
//
// Related Topics Linked List
// 👍 1982 👎 97

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.LinkedList.ListNode;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {}
 * ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
 * this.next = next; } }
 */
public class RemoveLinkedListElements_203 {
  public ListNode removeElements(ListNode head, int val) {
    ListNode dummy = new ListNode(-1);
    dummy.next = head;

    ListNode curr = dummy;
    while (curr != null) {
      while (curr.next != null && curr.next.val == val) {
        curr.next = curr.next.next;
      }
      curr = curr.next;
    }
    return dummy.next;
  }
}
/*
    O(n) Runtime: 1 ms, faster than 89.46% of Java online submissions for Remove Linked List Elements.
    O(1) Memory Usage: 40.1 MB, less than 90.85% of Java online submissions for Remove Linked List Elements.
 */


// leetcode submit region end(Prohibit modification and deletion)
