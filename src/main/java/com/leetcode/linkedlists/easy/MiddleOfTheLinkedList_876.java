package com.leetcode.linkedlists.easy;
// Given a non-empty, singly linked list with head node head, return a middle nod
// e of linked list.
//
// If there are two middle nodes, return the second middle node.
//
//
//
//
// Example 1:
//
//
// Input: [1,2,3,4,5]
// Output: Node 3 from this list (Serialization: [3,4,5])
// The returned node has value 3.  (The judge's serialization of this node is [3,
// 4,5]).
// Note that we returned a ListNode object ans, such that:
// ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next =
// NULL.
//
//
//
// Example 2:
//
//
// Input: [1,2,3,4,5,6]
// Output: Node 4 from this list (Serialization: [4,5,6])
// Since the list has two middle nodes with values 3 and 4, we return the second
// one.
//
//
//
//
// Note:
//
//
// The number of nodes in the given list will be between 1 and 100.
//
//
//
// Related Topics Linked List
// 👍 1587 👎 65

// leetcode submit region begin(Prohibit modification and deletion)


import com.leetcode.utils.LinkedList.ListNode;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {}
 * ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
 * this.next = next; } }
 */
public class MiddleOfTheLinkedList_876 {
  public ListNode middleNode(ListNode head) {
    ListNode mid = head;

    while (head != null && head.next != null) {
      head = head.next.next;
      mid = mid.next;
    }

    return mid;
  }
}

/*
     Runtime: 0 ms, faster than 100.00% of Java online submissions for Middle of the Linked List.
     Memory Usage: 38.8 MB, less than 10.99% of Java online submissions for Middle of the Linked List.
*/
// leetcode submit region end(Prohibit modification and deletion)
