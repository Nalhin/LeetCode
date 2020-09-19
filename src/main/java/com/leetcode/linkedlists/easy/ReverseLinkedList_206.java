package com.leetcode.linkedlists.easy;

// Reverse a singly linked list.
//
// Example:
//
//
// Input: 1->2->3->4->5->NULL
// Output: 5->4->3->2->1->NULL
//
//
// Follow up:
//
// A linked list can be reversed either iteratively or recursively. Could you im
// plement both?
// Related Topics Linked List
// 👍 5185 👎 98

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.LinkedList.ListNode;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {}
 * ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
 * this.next = next; } }
 */
public class ReverseLinkedList_206 {
  public ListNode reverseList(ListNode head) {
    if (head == null) {
      return null;
    }

    ListNode curr = head;
    ListNode reversed = null;

    while (curr != null) {
      ListNode temp = curr;
      curr = curr.next;
      temp.next = reversed;
      reversed = temp;
    }

    return reversed;
  }
}

/*
   O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Linked List.
   O(1) Memory Usage: 39.8 MB, less than 28.09% of Java online submissions for Reverse Linked List.
*/
// leetcode submit region end(Prohibit modification and deletion)
