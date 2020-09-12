package com.leetcode.assertions;

import com.leetcode.utils.LinkedList.ListNode;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LinkedListAssertions {
  private List<Integer> given;

  public LinkedListAssertions(ListNode head) {
    this.given = convertLLtoAL(head);
  }

  private List<Integer> convertLLtoAL(ListNode head) {
    List<Integer> resultValues = new ArrayList<>();
    while (head != null) {
      resultValues.add(head.val);
      head = head.next;
    }
    return resultValues;
  }

  public void isEqualTo(ListNode expected) {
    List<Integer> expectedValues = new ArrayList<>();
    while (expected != null) {
      expectedValues.add(expected.val);
      expected = expected.next;
    }

    assertThat(given).isEqualTo(expectedValues);
  }

  public static LinkedListAssertions assertThatLinkedList(ListNode head) {
    return new LinkedListAssertions(head);
  }
}
