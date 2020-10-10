package com.leetcode.design.easy;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ImplementQueueUsingStacks_232Test {

  @Nested
  class MyQueue {

    @Test
    void acceptanceTest() {
      ImplementQueueUsingStacks_232.MyQueue queue = new ImplementQueueUsingStacks_232.MyQueue();

      SoftAssertions softAssertions = new SoftAssertions();

      queue.push(1);
      queue.push(2);

      softAssertions.assertThat(queue.peek()).isEqualTo(1);
      softAssertions.assertThat(queue.pop()).isEqualTo(1);
      softAssertions.assertThat(queue.empty()).isFalse();
      softAssertions.assertAll();
    }
  }

  @Nested
  class MyQueueAmortized {
    @Test
    void acceptanceTest() {
      ImplementQueueUsingStacks_232.MyQueueAmortized queue =
          new ImplementQueueUsingStacks_232.MyQueueAmortized();

      SoftAssertions softAssertions = new SoftAssertions();

      queue.push(1);
      queue.push(2);

      softAssertions.assertThat(queue.peek()).isEqualTo(1);
      softAssertions.assertThat(queue.pop()).isEqualTo(1);
      softAssertions.assertThat(queue.empty()).isFalse();
      softAssertions.assertAll();
    }
  }
}
