package com.leetcode.linkedlists.easy;

// Given a sorted linked list, delete all duplicates such that each element appea
// r only once.
//
// Example 1:
//
//
// Input: 1->1->2
// Output: 1->2
//
//
// Example 2:
//
//
// Input: 1->1->2->3->3
// Output: 1->2->3
//
// Related Topics Linked List
// 👍 1973 👎 131

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.LinkedList.ListNode;

/*
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {}
 * ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
 * this.next = next; } }
 */
/*
 O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Duplicates from Sorted List.
 O(1) Memory Usage: 38.4 MB, less than 48.26% of Java online submissions for Remove Duplicates from Sorted List.
*/
public class RemoveDuplicatesFromSortedList_83 {
  public ListNode deleteDuplicates(ListNode head) {
    ListNode curr = head;
    while (curr != null && curr.next != null) {
      if (curr.next.val == curr.val) {
        curr.next = curr.next.next;
      }
      curr = curr.next;
    }
    return head;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
