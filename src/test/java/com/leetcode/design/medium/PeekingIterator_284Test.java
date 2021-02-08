package com.leetcode.design.medium;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class PeekingIterator_284Test {

  @Test
  void acceptanceTest() {
    PeekingIterator_284.PeekingIterator iterator =
        new PeekingIterator_284.PeekingIterator(List.of(1, 2, 3).iterator());
    SoftAssertions softAssertions = new SoftAssertions();

    softAssertions.assertThat(iterator.next()).isEqualTo(1);
    softAssertions.assertThat(iterator.peek()).isEqualTo(2);
    softAssertions.assertThat(iterator.next()).isEqualTo(2);
    softAssertions.assertThat(iterator.next()).isEqualTo(3);
    softAssertions.assertThat(iterator.hasNext()).isFalse();
    softAssertions.assertAll();
  }
}
