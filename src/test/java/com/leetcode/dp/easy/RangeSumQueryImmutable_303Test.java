package com.leetcode.dp.easy;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

class RangeSumQueryImmutable_303Test {

  @Test
  void acceptanceTest() {
    RangeSumQueryImmutable_303.NumArray numArray =
        new RangeSumQueryImmutable_303.NumArray(new int[] {-2, 0, 3, -5, 2, -1});

    SoftAssertions softAssertions = new SoftAssertions();
    softAssertions.assertThat(numArray.sumRange(0, 2)).isEqualTo(1);
    softAssertions.assertThat(numArray.sumRange(2, 5)).isEqualTo(-1);
    softAssertions.assertThat(numArray.sumRange(0, 5)).isEqualTo(-3);
  }
}
