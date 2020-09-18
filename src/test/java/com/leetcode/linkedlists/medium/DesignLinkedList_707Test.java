package com.leetcode.linkedlists.medium;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class DesignLinkedList_707Test {

  private DesignLinkedList_707 emptyLinkedList() {
    return new DesignLinkedList_707();
  }

  private DesignLinkedList_707 linkedListOf(int... args) {
    DesignLinkedList_707 list = new DesignLinkedList_707();
    for (int arg : args) {
      list.addAtTail(arg);
    }
    return list;
  }

  @Nested
  class Get {

    @Test
    void itShouldReturnHeadIfIndexIsZero() {
      DesignLinkedList_707 list = linkedListOf(1);

      int actualResult = list.get(0);

      assertThat(actualResult).isEqualTo(1);
    }

    @Test
    void itShouldReturnElementPresentAtPosition() {
      DesignLinkedList_707 list = linkedListOf(1, 2, 3);

      int actualResult = list.get(2);

      assertThat(actualResult).isEqualTo(3);
    }

    @Test
    void isShouldIndicateThatValueWasNotFound() {
      DesignLinkedList_707 list = linkedListOf(5);

      int actualResult = list.get(1);

      assertThat(actualResult).isEqualTo(-1);
    }

    @Test
    void itShouldIndicateThatTheListIsEmpty() {
      DesignLinkedList_707 list = emptyLinkedList();

      int actualResult = list.get(0);

      assertThat(actualResult).isEqualTo(-1);
    }
  }

  @Nested
  class AddAtHead {

    @Test
    void itShouldRetainInsertionOrder() {
      DesignLinkedList_707 list = emptyLinkedList();

      list.addAtHead(3);
      list.addAtHead(2);
      list.addAtHead(1);

      assertThat(list.get(1)).isEqualTo(2);
    }

    @Test
    void itShouldReturnHead() {
      DesignLinkedList_707 list = emptyLinkedList();

      list.addAtHead(3);

      assertThat(list.get(0)).isEqualTo(3);
    }
  }

  @Nested
  class AddAtTail {

    @Test
    void itShouldInsertValueWhenListIsEmpty() {
      DesignLinkedList_707 list = emptyLinkedList();

      list.addAtTail(3);

      assertThat(list.get(0)).isEqualTo(3);
    }

    @Test
    void itShouldRetainItemOrder() {
      DesignLinkedList_707 list = emptyLinkedList();

      list.addAtTail(3);
      list.addAtTail(2);
      list.addAtTail(1);

      assertThat(list.get(0)).isEqualTo(3);
    }
  }

  @Nested
  class AddAtIndex {

    @Test
    void itShouldAddHead() {
      DesignLinkedList_707 list = linkedListOf(1);

      list.addAtIndex(0, 2);

      assertThat(list.get(0)).isEqualTo(2);
      assertThat(list.get(1)).isEqualTo(1);
    }

    @Test
    void itShouldNotAddItemIfIndexIsTooLarge() {
      DesignLinkedList_707 list = linkedListOf(1);

      list.addAtIndex(3, 2);

      assertThat(list.get(1)).isEqualTo(-1);
    }

    @Test
    void itShouldInsertValueAtPosition() {
      DesignLinkedList_707 list = linkedListOf(1, 2);

      list.addAtIndex(1, 3);

      assertThat(list.get(1)).isEqualTo(3);
    }
  }

  @Nested
  class DeleteAtIndex {

    @Test
    void itShouldRemoveHead() {
      DesignLinkedList_707 list = linkedListOf(3, 2);

      list.deleteAtIndex(0);

      assertThat(list.get(0)).isEqualTo(2);
    }

    @Test
    void itShouldDeleteValueAtPosition() {
      DesignLinkedList_707 list = linkedListOf(3, 2, 1);

      list.deleteAtIndex(1);

      assertThat(list.get(1)).isEqualTo(1);
    }
  }

  @Nested
  class AcceptanceTests {
    @Test
    void acceptance_1() {
      SoftAssertions softly = new SoftAssertions();
      DesignLinkedList_707 list = emptyLinkedList();

      list.addAtHead(1);
      list.addAtTail(3);
      list.addAtIndex(1, 2);

      softly.assertThat(list.get(1)).isEqualTo(2);

      list.deleteAtIndex(1);

      softly.assertThat(list.get(1)).isEqualTo(3);
      softly.assertAll();
    }
  }
}
