package com.leetcode.design.hard;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class MaximumFrequencyStack_895Test {

  @Nested
  class TreeSet {
    @Test
    void acceptanceTest() {
      MaximumFrequencyStack_895.FreqStackTreeSet stack =
          new MaximumFrequencyStack_895.FreqStackTreeSet();
      SoftAssertions softAssertions = new SoftAssertions();

      stack.push(5);
      stack.push(7);
      stack.push(5);
      stack.push(7);
      stack.push(4);
      stack.push(5);
      softAssertions.assertThat(stack.pop()).isEqualTo(5);
      softAssertions.assertThat(stack.pop()).isEqualTo(7);
      softAssertions.assertThat(stack.pop()).isEqualTo(5);
      softAssertions.assertThat(stack.pop()).isEqualTo(4);

      softAssertions.assertAll();
    }
  }

  @Nested
  class ListOfStacks {
    @Test
    void acceptanceTest() {
      MaximumFrequencyStack_895.FreqStackListOfStacks stack =
          new MaximumFrequencyStack_895.FreqStackListOfStacks();
      SoftAssertions softAssertions = new SoftAssertions();

      stack.push(5);
      stack.push(7);
      stack.push(5);
      stack.push(7);
      stack.push(4);
      stack.push(5);
      softAssertions.assertThat(stack.pop()).isEqualTo(5);
      softAssertions.assertThat(stack.pop()).isEqualTo(7);
      softAssertions.assertThat(stack.pop()).isEqualTo(5);
      softAssertions.assertThat(stack.pop()).isEqualTo(4);

      softAssertions.assertAll();
    }
  }
}
