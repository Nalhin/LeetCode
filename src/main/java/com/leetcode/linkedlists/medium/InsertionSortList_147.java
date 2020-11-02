package com.leetcode.linkedlists.medium;

// Sort a linked list using insertion sort.
//
//
//
//
//
// A graphical example of insertion sort. The partial sorted list (black) initial
// ly contains only the first element in the list.
// With each iteration one element (red) is removed from the input data and inser
// ted in-place into the sorted list
//
//
//
//
//
// Algorithm of Insertion Sort:
//
//
// Insertion sort iterates, consuming one input element each repetition, and gro
// wing a sorted output list.
// At each iteration, insertion sort removes one element from the input data, fi
// nds the location it belongs within the sorted list, and inserts it there.
// It repeats until no input elements remain.
//
//
//
// Example 1:
//
//
// Input: 4->2->1->3
// Output: 1->2->3->4
//
//
// Example 2:
//
//
// Input: -1->5->3->4->0
// Output: -1->0->3->4->5
//
// Related Topics Linked List Sort
// 👍 794 👎 627

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.LinkedList.ListNode;

/*
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {}
 * ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
 * this.next = next; } }
 */
/*
 O(n^2) Runtime: 28 ms, faster than 61.74% of Java online submissions for Insertion Sort List.
 O(1)  Memory Usage: 38.8 MB, less than 8.12% of Java online submissions for Insertion Sort List.
*/
public class InsertionSortList_147 {
  public ListNode insertionSortList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode curr = head.next;
    head.next = null;
    ListNode sorted = head;

    while (curr != null) {
      ListNode temp = curr;
      curr = curr.next;

      ListNode prev = null;
      ListNode next = sorted;

      while (next != null && temp.val > next.val) {
        prev = next;
        next = next.next;
      }
      temp.next = next;

      if (prev == null) {
        sorted = temp;
      } else {
        prev.next = temp;
      }
    }

    return sorted;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
