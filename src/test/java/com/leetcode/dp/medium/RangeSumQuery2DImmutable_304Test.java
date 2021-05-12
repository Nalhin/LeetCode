package com.leetcode.dp.medium;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

class RangeSumQuery2DImmutable_304Test {

  @Test
  void acceptanceTest() {
    RangeSumQuery2DImmutable_304.NumMatrix numMatrix =
        new RangeSumQuery2DImmutable_304.NumMatrix(
            new int[][] {
              {3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}
            });

    SoftAssertions softAssertions = new SoftAssertions();
    softAssertions.assertThat(numMatrix.sumRegion(2, 1, 4, 3)).isEqualTo(8);
    softAssertions.assertThat(numMatrix.sumRegion(1, 1, 2, 2)).isEqualTo(11);
    softAssertions.assertThat(numMatrix.sumRegion(1, 2, 2, 4)).isEqualTo(12);
    softAssertions.assertAll();
  }
}
