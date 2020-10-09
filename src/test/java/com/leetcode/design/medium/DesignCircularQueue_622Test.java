package com.leetcode.design.medium;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static com.leetcode.design.medium.DesignCircularQueue_622.MyCircularQueue;

class DesignCircularQueue_622Test {

  private MyCircularQueue circularQueueOf(int size, int[] args) {
    MyCircularQueue queue = new MyCircularQueue(size);
    for (int value : args) {
      queue.enQueue(value);
    }
    return queue;
  }

  private MyCircularQueue emptyCircularQueue(int size) {
    return new MyCircularQueue(size);
  }

  @Nested
  class EnQueue {

    @Test
    @DisplayName("Should return false if insertion was unsuccessful")
    void returnsFalseIfUnsuccessful() {
      MyCircularQueue queue = circularQueueOf(3, new int[] {1, 2, 3, 4});

      boolean actualResult = queue.enQueue(1);

      assertThat(actualResult).isFalse();
    }

    @Test
    @DisplayName("Should return true if the operation was successful")
    void returnsTrueIfSuccessful() {
      MyCircularQueue queue = circularQueueOf(3, new int[] {1, 2});

      boolean actualResult = queue.enQueue(1);

      assertThat(actualResult).isTrue();
    }

    @Test
    @DisplayName("Inserts correctly after a circle has occurred")
    void insertsAfterCircle() {
      MyCircularQueue queue = circularQueueOf(3, new int[] {1, 2, 3});
      queue.deQueue();
      queue.enQueue(4);
      queue.deQueue();

      queue.enQueue(3);

      assertThat(queue.Front()).isEqualTo(3);
    }
  }

  @Nested
  class DeQueue {

    @Test
    @DisplayName("Should return false if insertion was unsuccessful")
    void returnsFalseIfUnsuccessful() {
      MyCircularQueue queue = emptyCircularQueue(1);

      boolean actualResult = queue.deQueue();

      assertThat(actualResult).isFalse();
    }

    @Test
    @DisplayName("Should return true if the operation was successful")
    void returnsTrueIfSuccessful() {
      MyCircularQueue queue = circularQueueOf(3, new int[] {1, 2});

      boolean actualResult = queue.deQueue();

      assertThat(actualResult).isTrue();
    }

    @Test
    @DisplayName("Removes a value correctly")
    void insertsAfterCircle() {
      MyCircularQueue queue = circularQueueOf(3, new int[] {1, 2, 3});

      queue.deQueue();

      assertThat(queue.Front()).isEqualTo(2);
    }
  }

  @Nested
  class Front {
    @Test
    @DisplayName("Should return item present in frontal position")
    void returnsFrontalItem() {
      MyCircularQueue queue = circularQueueOf(3, new int[] {1, 2, 3, 4});

      int actualResult = queue.Front();

      assertThat(actualResult).isEqualTo(1);
    }
  }

  @Nested
  class Rear {

    @Test
    @DisplayName("Should return the previously inserted item")
    void returnsPrevInsertedItem() {
      MyCircularQueue queue = circularQueueOf(3, new int[] {1, 2, 3, 4});

      int actualResult = queue.Rear();

      assertThat(actualResult).isEqualTo(3);
    }

    @Test
    @DisplayName("Should return -1 if no items were inserted into the queue")
    void returnsDefaultValueIfNoInsertions() {
      MyCircularQueue queue = circularQueueOf(1, new int[] {1});
      queue.deQueue();

      int actualResult = queue.Rear();

      assertThat(actualResult).isEqualTo(-1);
    }

    @Test
    @DisplayName("Should return -1 if queue is empty")
    void returnsDefaultValueIfEmpty() {
      MyCircularQueue queue = emptyCircularQueue(3);

      int actualResult = queue.Rear();

      assertThat(actualResult).isEqualTo(-1);
    }
  }

  @Nested
  class isEmpty {

    @Test
    @DisplayName("Should return true if no items were inserted into the queue")
    void returnsTrueIfNoInsertions() {
      MyCircularQueue queue = circularQueueOf(1, new int[] {1});
      queue.deQueue();

      boolean actualResult = queue.isEmpty();

      assertThat(actualResult).isTrue();
    }

    @Test
    @DisplayName("Should return true if the queue is empty")
    void returnsTrueIfEmpty() {
      MyCircularQueue queue = emptyCircularQueue(3);

      boolean actualResult = queue.isEmpty();

      assertThat(actualResult).isTrue();
    }

    @Test
    @DisplayName("Should return false if the queue is not empty")
    void returnsFalseIfNotEmpty() {
      MyCircularQueue queue = circularQueueOf(2, new int[] {1, 2});

      boolean actualResult = queue.isEmpty();

      assertThat(actualResult).isFalse();
    }
  }

  @Nested
  class isFull {

    @Test
    @DisplayName("Should return false if no items were inserted into the queue")
    void returnsTrueIfNoInsertions() {
      MyCircularQueue queue = emptyCircularQueue(1);
      queue.deQueue();

      boolean actualResult = queue.isEmpty();

      assertThat(actualResult).isTrue();
    }

    @Test
    @DisplayName("Should return true if the queue is full")
    void returnsTrueIfEmpty() {
      MyCircularQueue queue = circularQueueOf(2, new int[] {1, 2, 3});

      boolean actualResult = queue.isFull();

      assertThat(actualResult).isTrue();
    }

    @Test
    @DisplayName("Should return false if the queue is not empty")
    void returnsFalseIfNotEmpty() {
      MyCircularQueue queue = circularQueueOf(2, new int[] {1, 2, 3});
      queue.deQueue();

      boolean actualResult = queue.isFull();

      assertThat(actualResult).isFalse();
    }
  }
}
