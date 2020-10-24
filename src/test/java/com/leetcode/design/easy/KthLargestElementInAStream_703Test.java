package com.leetcode.design.easy;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

class KthLargestElementInAStream_703Test {

  @Test
  void acceptanceTest() {
    KthLargestElementInAStream_703.KthLargest kthLargest =
        new KthLargestElementInAStream_703.KthLargest(3, new int[] {4, 5, 8, 2});

    SoftAssertions softly = new SoftAssertions();
    softly.assertThat(kthLargest.add(3)).isEqualTo(4);
    softly.assertThat(kthLargest.add(5)).isEqualTo(5);
    softly.assertThat(kthLargest.add(10)).isEqualTo(5);
    softly.assertThat(kthLargest.add(9)).isEqualTo(8);
    softly.assertThat(kthLargest.add(4)).isEqualTo(8);
    softly.assertAll();
  }
}
