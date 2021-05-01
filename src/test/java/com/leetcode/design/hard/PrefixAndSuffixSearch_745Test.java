package com.leetcode.design.hard;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

class PrefixAndSuffixSearch_745Test {

  @Test
  void acceptanceTest() {
    PrefixAndSuffixSearch_745.WordFilter wordFilter =
        new PrefixAndSuffixSearch_745.WordFilter(new String[] {"apple", "apple"});

    SoftAssertions softAssertions = new SoftAssertions();

    softAssertions.assertThat(wordFilter.f("a", "e")).isEqualTo(1);
    softAssertions.assertThat(wordFilter.f("a", "apple")).isEqualTo(1);
    softAssertions.assertThat(wordFilter.f("a", "apple")).isEqualTo(1);
    softAssertions.assertAll();
  }
}
