package com.leetcode.design.hard;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class FindMedianFromDataStream_295Test {

  @Nested
  class BinarySearch {
    @Test
    void acceptanceTest() {
      FindMedianFromDataStream_295.MedianFinderBinarySearch medianFinder =
          new FindMedianFromDataStream_295.MedianFinderBinarySearch();
      SoftAssertions softAssertions = new SoftAssertions();

      medianFinder.addNum(1);
      medianFinder.addNum(2);
      softAssertions.assertThat(medianFinder.findMedian()).isEqualTo(1.5);
      medianFinder.addNum(3);
      softAssertions.assertThat(medianFinder.findMedian()).isEqualTo(2.0);

      softAssertions.assertAll();
    }
  }

  @Nested
  class Pq {
    @Test
    void acceptanceTest() {
      FindMedianFromDataStream_295.MedianFinderPq medianFinder =
          new FindMedianFromDataStream_295.MedianFinderPq();
      SoftAssertions softAssertions = new SoftAssertions();

      medianFinder.addNum(1);
      medianFinder.addNum(2);
      softAssertions.assertThat(medianFinder.findMedian()).isEqualTo(1.5);
      medianFinder.addNum(3);
      softAssertions.assertThat(medianFinder.findMedian()).isEqualTo(2.0);

      softAssertions.assertAll();
    }
  }
}
