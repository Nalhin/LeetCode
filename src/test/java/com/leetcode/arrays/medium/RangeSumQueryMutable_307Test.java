package com.leetcode.arrays.medium;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

class RangeSumQueryMutable_307Test {

  @Test
  void acceptanceTest() {
    RangeSumQueryMutable_307.NumArray query =
        new RangeSumQueryMutable_307.NumArray(new int[] {1, 3, 5});
    SoftAssertions softAssertions = new SoftAssertions();

    softAssertions.assertThat(query.sumRange(0, 2)).isEqualTo(9);
    query.update(1, 2);
    softAssertions.assertThat(query.sumRange(0, 2)).isEqualTo(8);
    softAssertions.assertAll();
  }
}
