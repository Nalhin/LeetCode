package com.leetcode.design.medium;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

class IteratorForCombination_1286Test {

  @Test
  void acceptanceTest() {
    IteratorForCombination_1286.CombinationIterator iterator =
        new IteratorForCombination_1286.CombinationIterator("abc", 2);
    SoftAssertions softAssertions = new SoftAssertions();

    softAssertions.assertThat(iterator.next()).isEqualTo("ab");
    softAssertions.assertThat(iterator.hasNext()).isTrue();
    softAssertions.assertThat(iterator.next()).isEqualTo("ac");
    softAssertions.assertThat(iterator.hasNext()).isTrue();
    softAssertions.assertThat(iterator.next()).isEqualTo("bc");
    softAssertions.assertThat(iterator.hasNext()).isFalse();
    softAssertions.assertAll();
  }
}
