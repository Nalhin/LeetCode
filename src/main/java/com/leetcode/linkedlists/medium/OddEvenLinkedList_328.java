package com.leetcode.linkedlists.medium;

// Given a singly linked list, group all odd nodes together followed by the even
// nodes. Please note here we are talking about the node number and not the value i
// n the nodes.
//
// You should try to do it in place. The program should run in O(1) space comple
// xity and O(nodes) time complexity.
//
// Example 1:
//
//
// Input: 1->2->3->4->5->NULL
// Output: 1->3->5->2->4->NULL
//
//
// Example 2:
//
//
// Input: 2->1->3->5->6->4->7->NULL
// Output: 2->3->6->7->1->5->4->NULL
//
//
//
// Constraints:
//
//
// The relative order inside both the even and odd groups should remain as it wa
// s in the input.
// The first node is considered odd, the second node even and so on ...
// The length of the linked list is between [0, 10^4].
//
// Related Topics Linked List
// 👍 2242 👎 310

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.LinkedList.ListNode;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {}
 * ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
 * this.next = next; } }
 */
public class OddEvenLinkedList_328 {
  public ListNode oddEvenList(ListNode head) {
    ListNode dummyEven = new ListNode();
    ListNode evenCurr = dummyEven;
    ListNode dummyOdd = new ListNode();
    ListNode oddCurr = dummyOdd;
    ListNode curr = head;
    int num = 1;

    while (curr != null) {
      if (num++ % 2 == 0) {
        evenCurr.next = curr;
        evenCurr = evenCurr.next;
      } else {
        oddCurr.next = curr;
        oddCurr = oddCurr.next;
      }
      curr = curr.next;
    }
    evenCurr.next = null;
    oddCurr.next = dummyEven.next;
    return dummyOdd.next;
  }
}

/*
  O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Odd Even Linked List.
  O(1) Memory Usage: 39.1 MB, less than 64.37% of Java online submissions for Odd Even Linked List.

 */
// leetcode submit region end(Prohibit modification and deletion)
