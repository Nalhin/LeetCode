package com.leetcode.linkedlists.easy;

// Write a program to find the node at which the intersection of two singly linke
// d lists begins.
//
// For example, the following two linked lists:
//
//
// begin to intersect at node c1.
//
//
//
// Example 1:
//
//
//
// Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2
// , skipB = 3
// Output: Reference of the node with value = 8
// Input Explanation: The intersected node's value is 8 (note that this must not
// be 0 if the two lists intersect). From the head of A, it reads as [4,1,8,4,5]. F
// rom the head of B, it reads as [5,6,1,8,4,5]. There are 2 nodes before the inter
// sected node in A; There are 3 nodes before the intersected node in B.
//
//
//
// Example 2:
//
//
//
// Input: intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skip
// B = 1
// Output: Reference of the node with value = 2
// Input Explanation: The intersected node's value is 2 (note that this must not
// be 0 if the two lists intersect). From the head of A, it reads as [1,9,1,2,4]. F
// rom the head of B, it reads as [3,2,4]. There are 3 nodes before the intersected
// node in A; There are 1 node before the intersected node in B.
//
//
//
//
// Example 3:
//
//
//
// Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
// Output: null
// Input Explanation: From the head of A, it reads as [2,6,4]. From the head of B
// , it reads as [1,5]. Since the two lists do not intersect, intersectVal must be
// 0, while skipA and skipB can be arbitrary values.
// Explanation: The two lists do not intersect, so return null.
//
//
//
//
// Notes:
//
//
// If the two linked lists have no intersection at all, return null.
// The linked lists must retain their original structure after the function retu
// rns.
// You may assume there are no cycles anywhere in the entire linked structure.
// Each value on each linked list is in the range [1, 10^9].
// Your code should preferably run in O(n) time and use only O(1) memory.
//
// Related Topics Linked List
// 👍 4083 👎 467

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.LinkedList.ListNode;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int
 * x) { val = x; next = null; } }
 */
public class IntersectionOfTwoLinkedLists_160 {
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    int lengthA = 0;
    int lengthB = 0;

    ListNode currA = headA;
    ListNode currB = headB;

    while (currA != null) {
      lengthA++;
      currA = currA.next;
    }

    while (currB != null) {
      lengthB++;
      currB = currB.next;
    }

    currA = headA;
    currB = headB;

    for (int i = 0; i < lengthA - lengthB; i++) {
      currA = currA.next;
    }

    for (int i = 0; i < lengthB - lengthA; i++) {
      currB = currB.next;
    }

    while (currA != currB) {
      currA = currA.next;
      currB = currB.next;
    }

    return currA;
  }
}

/*

  O(n) Runtime: 2 ms, faster than 46.34% of Java online submissions for Intersection of Two Linked Lists.
  O(1) Memory Usage: 53 MB, less than 14.62% of Java online submissions for Intersection of Two Linked Lists.

 */
// leetcode submit region end(Prohibit modification and deletion)
