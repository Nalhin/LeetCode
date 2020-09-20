package com.leetcode.assertions;

import com.leetcode.utils.LinkedList.ListNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LinkedListAssertions {
  private ListNode listHead;

  public LinkedListAssertions(ListNode listHead) {
    this.listHead = listHead;
  }

  private List<Integer> convertLLtoAL(ListNode head) {
    List<Integer> resultValues = new ArrayList<>();
    while (head != null) {
      resultValues.add(head.val);
      head = head.next;
    }
    return resultValues;
  }

  private List<Integer> convertLLtoALIgnoringCycles(ListNode head) {
    List<Integer> resultValues = new ArrayList<>();
    Set<ListNode> visited = new HashSet<>();
    while (head != null && visited.add(head)) {
      resultValues.add(head.val);
      head = head.next;
    }
    return resultValues;
  }

  public void isEqualTo(ListNode expected) {
    assertThat(convertLLtoAL(listHead)).isEqualTo(convertLLtoAL(expected));
  }

  public void isEqualToIgnoringCycles(ListNode expected) {
    assertThat(convertLLtoALIgnoringCycles(listHead)).isEqualTo(convertLLtoALIgnoringCycles(expected));
  }

  public void hasAtPosition(ListNode node, int position) {
    ListNode curr = listHead;
    int pos = 0;
    while (curr != node && pos < position) {
      curr = curr.next;
      pos++;
    }

    assertThat(pos).isEqualTo(position);
  }

  public void hasCycleAtPosition(ListNode head, int position) {
    if (position < 0) {
      assertThat(hasCycle(listHead)).isFalse();
      return;
    }

    hasAtPosition(head, position);
  }

  private boolean hasCycle(ListNode head) {

    ListNode fast = head;
    ListNode slow = head;

    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;

      if (fast == slow) {
        return true;
      }
    }

    return false;
  }

  public static LinkedListAssertions assertThatLinkedList(ListNode head) {
    return new LinkedListAssertions(head);
  }
}
