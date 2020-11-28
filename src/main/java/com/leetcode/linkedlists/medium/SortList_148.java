package com.leetcode.linkedlists.medium;

// Given the head of a linked list, return the list after sorting it in ascending
// order.
//
// Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.
// e. constant space)?
//
//
// Example 1:
//
//
// Input: head = [4,2,1,3]
// Output: [1,2,3,4]
//
//
// Example 2:
//
//
// Input: head = [-1,5,3,4,0]
// Output: [-1,0,3,4,5]
//
//
// Example 3:
//
//
// Input: head = []
// Output: []
//
//
//
// Constraints:
//
//
// The number of nodes in the list is in the range [0, 5 * 104].
// -105 <= Node.val <= 105
//
// Related Topics Linked List Sort
// 👍 3327 👎 148

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.LinkedList.ListNode;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {}
 * ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
 * this.next = next; } }
 */
public class SortList_148 {
  public ListNode sortList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode mid = getMid(head);
    ListNode left = sortList(head);
    ListNode right = sortList(mid);
    return merge(left, right);
  }

  private ListNode merge(ListNode left, ListNode right) {
    ListNode dummy = new ListNode();
    ListNode curr = dummy;
    while (left != null && right != null) {
      if (left.val < right.val) {
        curr.next = left;
        left = left.next;
      } else {
        curr.next = right;
        right = right.next;
      }
      curr = curr.next;
    }
    if (left == null) {
      curr.next = right;
    } else {
      curr.next = left;
    }
    return dummy.next;
  }

  private ListNode getMid(ListNode head) {
    ListNode preMid = null;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      preMid = preMid == null ? head : preMid.next;
      fast = fast.next.next;
    }
    ListNode mid = preMid.next;
    preMid.next = null;
    return mid;
  }
}
/*
 O(nlog(n)) Runtime: 3 ms, faster than 97.54% of Java online submissions for Sort List.
 O(log(n)) Memory Usage: 40.9 MB, less than 13.39% of Java online submissions for Sort List.
*/
// leetcode submit region end(Prohibit modification and deletion)
