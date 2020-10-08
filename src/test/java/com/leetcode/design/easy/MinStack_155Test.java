package com.leetcode.design.easy;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MinStack_155Test {

  @Nested
  class MinStack {

    @Test
    void acceptanceTest() {
      MinStack_155.MinStack minStack = new MinStack_155.MinStack();
      SoftAssertions softly = new SoftAssertions();

      minStack.push(-2);
      minStack.push(0);
      minStack.push(-3);

      softly.assertThat(minStack.getMin()).isEqualTo(-3);

      minStack.pop();

      softly.assertThat(minStack.top()).isEqualTo(0);
      softly.assertThat(minStack.getMin()).isEqualTo(-2);
    }
  }
}
