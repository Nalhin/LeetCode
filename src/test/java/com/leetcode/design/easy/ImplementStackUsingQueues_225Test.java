package com.leetcode.design.easy;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ImplementStackUsingQueues_225Test {

  @Nested
  class MyStack {

    @Test
    void acceptanceTest() {
      ImplementStackUsingQueues_225.MyStack stack = new ImplementStackUsingQueues_225.MyStack();

      SoftAssertions softly = new SoftAssertions();

      stack.push(1);
      stack.push(2);
      softly.assertThat(stack.top()).isEqualTo(2);
      softly.assertThat(stack.pop()).isEqualTo(2);
      softly.assertThat(stack.empty()).isFalse();
    }
  }
}
