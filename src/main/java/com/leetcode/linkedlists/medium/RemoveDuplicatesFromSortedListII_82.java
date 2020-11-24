package com.leetcode.linkedlists.medium;

// Given a sorted linked list, delete all nodes that have duplicate numbers, leav
// ing only distinct numbers from the original list.
//
// Return the linked list sorted as well.
//
// Example 1:
//
//
// Input: 1->2->3->3->4->4->5
// Output: 1->2->5
//
//
// Example 2:
//
//
// Input: 1->1->1->2->3
// Output: 2->3
//
// Related Topics Linked List
// 👍 2139 👎 115

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.LinkedList.ListNode;

/*
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {}
 * ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
 * this.next = next; } }
 */
/*
 O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Duplicates from Sorted List II.
 O(1) Memory Usage: 38.5 MB, less than 33.28% of Java online submissions for Remove Duplicates from Sorted List II.
*/
public class RemoveDuplicatesFromSortedListII_82 {
  public ListNode deleteDuplicates(ListNode head) {
    ListNode dummy = new ListNode();

    dummy.next = head;
    ListNode curr = dummy.next;
    ListNode prev = dummy;

    while (curr != null && curr.next != null) {
      if (curr.val == curr.next.val) {
        int val = curr.val;
        while (curr != null && curr.val == val) {
          curr = curr.next;
        }
        prev.next = curr;
      } else {
        curr = curr.next;
        prev = prev.next;
      }
    }

    return dummy.next;
  }

}
// leetcode submit region end(Prohibit modification and deletion)
