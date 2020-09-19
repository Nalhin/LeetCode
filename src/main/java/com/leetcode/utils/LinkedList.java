package com.leetcode.utils;

public class LinkedList {

  public static ListNode of(int first, int... args) {
    ListNode result = new ListNode(first, new ListNode());
    ListNode next = result.next;
    ListNode prev = result;
    for (int i : args) {
      next.val = i;
      next.next = new ListNode();
      prev = next;
      next = next.next;
    }
    prev.next = null;
    return result;
  }

  public static ListNode empty() {
    return null;
  }

  public static ListNode findFirstOccurrence(ListNode head, int val) {
    ListNode curr = head;
    while (curr != null) {
      if (curr.val == val) {
        return curr;
      }
      curr = curr.next;
    }
    return new ListNode();
  }

  public static ListNode addCycle(ListNode head, int cyclePosition) {
    if (cyclePosition < 0) {
      return head;
    }
    ListNode entry = head;
    ListNode node = head;

    while (cyclePosition-- > 0) {
      node = node.next;
    }

    while (entry.next != null) {
      entry = entry.next;
    }
    entry.next = node;

    return head;
  }

  public static class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {}

    public ListNode(int val) {
      this.val = val;
    }

    public ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }
}
