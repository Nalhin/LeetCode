package com.leetcode.linkedlists.medium;

// Reverse a linked list from position m to n. Do it in one-pass.
//
// Note: 1 ≤ m ≤ n ≤ length of list.
//
// Example:
//
//
// Input: 1->2->3->4->5->NULL, m = 2, n = 4
// Output: 1->4->3->2->5->NULL
//
// Related Topics Linked List
// 👍 2970 👎 159

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.LinkedList.ListNode;

/*
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {}
 * ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
 * this.next = next; } }
 */

/*
 O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Linked List II.
 O(1) Memory Usage: 36.9 MB, less than 17.19% of Java online submissions for Reverse Linked List II.
*/
public class ReverseLinkedListII_92 {
  public ListNode reverseBetween(ListNode head, int m, int n) {
    ListNode dummy = new ListNode();
    dummy.next = head;
    ListNode curr = dummy;

    while (curr != null && m-- > 1) {
      curr = curr.next;
      n--;
    }

    ListNode prev = curr.next;
    ListNode reversed = null;

    while (n-- > 0) {
      ListNode temp = prev.next;
      prev.next = reversed;
      reversed = prev;
      prev = temp;
    }

    curr.next = reversed;

    while (reversed.next != null) {
      reversed = reversed.next;
    }

    reversed.next = prev;
    return dummy.next;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
