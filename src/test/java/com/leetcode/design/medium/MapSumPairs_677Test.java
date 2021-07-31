package com.leetcode.design.medium;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

class MapSumPairs_677Test {

  @Test
  void acceptanceTest() {
    MapSumPairs_677.MapSum mapSum = new MapSumPairs_677.MapSum();
    SoftAssertions softAssertions = new SoftAssertions();

    mapSum.insert("apple", 3);
    softAssertions.assertThat(mapSum.sum("ap")).isEqualTo(3);
    mapSum.insert("app", 2);
    softAssertions.assertThat(mapSum.sum("ap")).isEqualTo(2);
    softAssertions.assertAll();
  }
}
